/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import ui.main.MainFrame;
import ui.reports.ReportUtils;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ClosingStockAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private boolean isFinished = false;
    private Iterable<String> itemCode;
    private String iteCode;
    private String unit;
    private double quantityMinus;
    private double quantityPlus;
    private double rate;
    private double amount;

    public ClosingStockAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
        reportUtils = new ReportUtils();
    }

    public double run() {
        return doInBackground();
    }

    private double doInBackground() {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        Date date = reportUtils.getCompanyBeginnigDate(mainFrame.getConnection(), companyCode);
        cal.setTime(date);
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        itemCode = new ReportUtils().getItemList(mainFrame, companyCode);
        for (String ic : itemCode) {
            this.iteCode = ic;
            this.unit = new ReportUtils().getUnitName(ic, companyCode, mainFrame);
            this.quantityMinus = 0.0;
            this.quantityPlus = 0.0;
            this.rate = new ReportUtils().getRateForUnit(iteCode, unit, mainFrame, companyCode);
            fetchSaleRegister(ic);
            fetchPurchaseRegister(ic);
            fetchSaleReturn(ic);
            fetchPurchaseReturn(ic);
            fetchItemCreation(ic);
            fetchProductionGene(ic);
            fetchProductionCons(ic);
            this.amount = amount + Math.abs(quantityMinus - quantityPlus) * rate;
        }
        isFinished = true;
        return Math.abs(amount);
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

    boolean isFinished() {
        return isFinished;
    }
}
