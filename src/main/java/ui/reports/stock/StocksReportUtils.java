/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import ui.reports.production.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.reports.ReportUtils;

/**
 *
 * @author Vimal
 */
public class StocksReportUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> itemCode;
    private final String companyCode;
    private boolean isFinsihed;
    private ProductionVoucherProReThread pro;
    private String fromDate;
    private String toDate;
    private String iteCode;
    private String iteName;
    private String unit;
    private double quantityPlus;
    private double quantityMinus;
    private double extraQtyPlus;
    private double extraQtyMinus;
    private double rate;
    private double amount;
    private int rowCount;

    /**
     *
     * @param mainFrame
     * @param cal
     * @param cal1
     * @param firstReportTable
     * @param itemCode
     * @param companyCode
     */
    public StocksReportUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable firstReportTable, ArrayList<String> itemCode, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = firstReportTable;
        this.itemCode = itemCode;
        this.companyCode = companyCode;

    }

    public void run() {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/"+String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/"+String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        rowCount = reportTable.getRowCount();
        for (String ic : itemCode) {
            this.iteCode = ic;
            this.iteName = new ReportUtils().getItemName(ic, companyCode, mainFrame);
            this.unit = new ReportUtils().getUnitName(ic, companyCode, mainFrame);
            this.quantityMinus = 0.0;
            this.quantityPlus = 0.0;
            this.extraQtyPlus = 0.0;
            this.extraQtyMinus = 0.0;
            this.rate = new ReportUtils().getRateForUnit(iteCode, unit, mainFrame, companyCode);
            this.amount = 0.0;
            fetchSaleRegister(ic);
            fetchPurchaseRegister(ic);
            fetchSaleReturn(ic);
            fetchPurchaseReturn(ic);
            fetchItemCreation(ic);
            fetchProductionGene(ic);
            fetchProductionCons(ic);
            addRow();
            reportTable.setValueAt(rowCount + 1, rowCount, 0);
            reportTable.setValueAt(iteCode, rowCount, 1);
            reportTable.setValueAt(iteName, rowCount, 2);
            reportTable.setValueAt(unit, rowCount, 3);
            reportTable.setValueAt(Math.abs(quantityMinus - quantityPlus), rowCount, 4);
            reportTable.setValueAt(Math.abs(extraQtyMinus - extraQtyPlus), rowCount, 5);
            reportTable.setValueAt(rate, rowCount, 6);
            reportTable.setValueAt(Math.abs(quantityMinus - quantityPlus) * rate, rowCount, 7);
            rowCount++;
        }
        isFinsihed = true;
        addRow();
        addRow();
    }

    public boolean getIsFinished() {
        return isFinsihed;
    }

    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        Object[] data = {null, null, null, null, null, null, null};
        model.addRow(data);
        reportTable.setModel(model);
    }

    private void fetchSaleRegister(String ic) {
        String sqlV = "SELECT voucherNumber FROM SALE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from SALE_REGISTER_ITEM_LIST where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemMinusDetail(sqlI);
        }
    }

    private void fetchItemMinusDetail(String sqlI) {
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String unitName = rs.getString("unitName");
                String qty = rs.getString("quantity");
                if (unit.equalsIgnoreCase(unitName)) {
                    try {
                        quantityMinus = quantityMinus + Double.valueOf(qty);
                    } catch (NumberFormatException | NullPointerException ex) {

                    }
                } else {
                    try {
                        quantityMinus = quantityMinus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, qty, companyCode, mainFrame));
                    } catch (NumberFormatException | NullPointerException ex) {
                    }
                }
                try {
                    if (rs.getString("taxClass").equalsIgnoreCase("Quantity")) {
                        String exQty = rs.getString("atTheRate");
                        if (unit.equalsIgnoreCase(unitName)) {
                            try {
                                extraQtyMinus = extraQtyMinus + Double.valueOf(qty);
                            } catch (NumberFormatException | NullPointerException ex) {

                            }
                        } else {
                            try {
                                extraQtyMinus = extraQtyMinus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, exQty, companyCode, mainFrame));
                            } catch (NumberFormatException | NullPointerException ex) {
                            }
                        }
                    }
                } catch (NullPointerException ex) {
                }

            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchPurchaseRegister(String ic) {
        String sqlV = "SELECT voucherNumber FROM PURCHASE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from PURCHASE_REGISTER_ITEM_LIST where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemPlusDetail(sqlI);
        }
    }

    private void fetchSaleReturn(String ic) {
        String sqlV = "SELECT voucherNumber FROM SALE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from SALE_RETURN_ITEM_LIST where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemPlusDetail(sqlI);
        }
    }

    private void fetchPurchaseReturn(String ic) {
        String sqlV = "SELECT voucherNumber FROM PURCHASE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from PURCHASE_RETURN_ITEM_LIST where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemMinusDetail(sqlI);
        }
    }

    private void fetchItemPlusDetail(String sqlI) {
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String unitName = rs.getString("unitName");
                String qty = rs.getString("quantity");
                if (unit.equalsIgnoreCase(unitName)) {
                    try {
                        quantityPlus = quantityPlus + Double.valueOf(qty);
                    } catch (NumberFormatException | NullPointerException ex) {

                    }
                } else {
                    try {
                        quantityPlus = quantityPlus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, qty, companyCode, mainFrame));
                    } catch (NumberFormatException | NullPointerException ex) {
                    }
                }
                try {
                    if (rs.getString("taxClass").equalsIgnoreCase("Quantity")) {
                        String exQty = rs.getString("atTheRate");
                        if (unit.equalsIgnoreCase(unitName)) {
                            try {
                                extraQtyPlus = extraQtyPlus + Double.valueOf(qty);
                            } catch (NumberFormatException | NullPointerException ex) {

                            }
                        } else {
                            try {
                                extraQtyPlus = extraQtyPlus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, exQty, companyCode, mainFrame));
                            } catch (NumberFormatException | NullPointerException ex) {
                            }
                        }
                    }
                } catch (NullPointerException ex) {
                }

            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchItemCreation(String ic) {
        String sql = "select * from ITEM_DETAIL where itemCode = ? AND companyCode = ? AND selfDevCost is not null";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ic);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    quantityPlus = quantityPlus + Double.valueOf(rs.getString("selfDevCost"));
                } catch (NumberFormatException | NullPointerException ex) {
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchProductionGene(String ic) {
        String sqlV = "SELECT voucherNumber FROM PRODUCTION_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from PRODUCTION_VOUCHER_ITEM_GENERATED where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemGenPlusDetail(sqlI);
        }
    }

    private void fetchProductionCons(String ic) {
        String sqlV = "SELECT voucherNumber FROM PRODUCTION_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND voucherNumber is not null";
        ArrayList<String> vNL = new ReportUtils().getVoucherNumberList(sqlV, mainFrame, companyCode);
        String sqlI = "SELECT * from PRODUCTION_VOUCHER_ITEM_CONSUMED where itemCode = '" + ic + "' AND (";
        int count = 0;
        for (String s : vNL) {
            if (count == vNL.size() - 1) {
                sqlI = sqlI + "voucherNumber = '" + s + "' )";
            } else {
                sqlI = sqlI + "voucherNumber = '" + s + "' OR ";
            }
            count++;
        }
        if (vNL.size() > 0) {
            fetchItemConsMinusDetail(sqlI);
        }
    }
    
    private void fetchItemGenPlusDetail(String sqlI) {
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String unitName = rs.getString("unitName");
                String qty = rs.getString("quantity");
                if (unit.equalsIgnoreCase(unitName)) {
                    try {
                        quantityPlus = quantityPlus + Double.valueOf(qty);
                    } catch (NumberFormatException | NullPointerException ex) {

                    }
                } else {
                    try {
                        quantityPlus = quantityPlus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, qty, companyCode, mainFrame));
                    } catch (NumberFormatException | NullPointerException ex) {
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void fetchItemConsMinusDetail(String sqlI) {
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlI);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String unitName = rs.getString("unitName");
                String qty = rs.getString("quantity");
                if (unit.equalsIgnoreCase(unitName)) {
                    try {
                        quantityMinus = quantityMinus + Double.valueOf(qty);
                    } catch (NumberFormatException | NullPointerException ex) {

                    }
                } else {
                    try {
                        quantityMinus = quantityMinus + Double.valueOf(new ReportUtils().getConvertedQuantity(unitName, qty, companyCode, mainFrame));
                    } catch (NumberFormatException | NullPointerException ex) {
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
