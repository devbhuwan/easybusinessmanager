package ui.voucher.production.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.production.ProductionVoucher;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ProductionHandler {

    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;
    private final ProductionVoucher aThis;

    public ProductionHandler(MainFrame mainFrame, ProductionVoucher aThis) {
        this.mainFrame = mainFrame;
        this.aThis = aThis;

    }

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean fetchProductionVoucherInformation(String companyCode, JTable saleOrderListTable, Connection conn) {
        boolean status = false;
        removeAllRows(saleOrderListTable);
        String sql = "select * from PRODUCTION_VOUCHER_DETAIL where companyCode = ?";

        DefaultTableModel model = (DefaultTableModel) saleOrderListTable.getModel();
        Object rowData[] = {null, null, null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                saleOrderListTable.getModel().setValueAt(row + 1, row, 0);
                saleOrderListTable.getModel().setValueAt(rs.getString("voucherNumber"), row, 1);
                saleOrderListTable.getModel().setValueAt(rs.getDate("dateForVoucher").toString(), row, 2);
                saleOrderListTable.getModel().setValueAt(rs.getString("narration"), row, 3);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean checkVoucherNumberIsValidOrNot(String companyCode, String voucherNumber, Connection conn) {
        boolean status = true;
        String sql = "select voucherNumber from PRODUCTION_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = false;
            } else {
                status = true;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveProductionVoucherInfo(ProductionVoucher aThis, Connection conn, String companyCode) {
        boolean status = false;
        String sql1 = "insert into PRODUCTION_VOUCHER_DETAIL values (?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, aThis.getVoucherNumber());
            ps.setTimestamp(2, aThis.getDateT());
            ps.setString(3, aThis.getNarration());
            ps.setString(4, aThis.getItemGenratedTotal());
            ps.setString(5, aThis.getItemConsumedTotal());
            ps.setString(6, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    /**
     *
     * @param aThis
     * @param conn
     * @param companyCode
     * @param itemTable
     * @param msg
     * @return
     */
    public boolean saveItemGeneratedInfo(ProductionVoucher aThis, Connection conn, String companyCode, JTable itemTable, String msg) {
        boolean status = false;
        String sql = null;
        switch (msg) {
            case "generated":
                sql = "insert into PRODUCTION_VOUCHER_ITEM_GENERATED (itemCode,unitName,quantity,rate,amount,expiryDate,voucherNumber,companyCode) values (?,?,?,?,?,?,?,?)";
                break;

            case "consumed":
                sql = "insert into PRODUCTION_VOUCHER_ITEM_CONSUMED (itemCode,unitName,quantity,rate,amount,expiryDate,voucherNumber,companyCode) values (?,?,?,?,?,?,?,?)";
                break;
        }

        for (int i = 0; i < itemTable.getRowCount() - 1; i++) {
            if (itemTable.getModel().getValueAt(i, 1) != null) {
                try {
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, aThis.getItemCode(i, itemTable));
                    ps.setString(2, aThis.getUnit(i, itemTable));
                    ps.setString(3, aThis.getQuantity(i, itemTable));
                    ps.setString(4, aThis.getRate(i, itemTable));
                    ps.setString(5, aThis.getItemAmount(i, itemTable));
                    ps.setString(6, aThis.getExpiryDate(i,itemTable));
                    ps.setString(7, aThis.getVoucherNumber());
                    ps.setString(8, companyCode);
                    ps.executeUpdate();
                    conn.commit();
                    status = true;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        return status;
    }

    public boolean deleteVoucherNumber(String companyCode, String voucherNumber, Connection conn) {
        boolean status = false;
        String sql = "delete from PRODUCTION_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";
        
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfProductionVoucher(String companyCode, String voucherNumber, ProductionVoucher aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from PRODUCTION_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setVoucherNu(rs.getString("voucherNumber"));
                aThis.setDatee(rs.getTimestamp("dateForVoucher"));
                aThis.setNarration(rs.getString("narration"));
                aThis.setItemGeneratedTotal(rs.getString("generatedAmount"));
                aThis.setItemConsumedTotal(rs.getString("consumedAmount"));
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchItemDetail(String companyCode, String voucherNumber, JTable itemTable, ProductionVoucher aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from PRODUCTION_VOUCHER_ITEM_GENERATED where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null,null};
            model.addRow(data);
            itemTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                itemTable.setModel(model);
                itemTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String itemCode = rs.getString("itemCode");
                itemTable.getModel().setValueAt(itemCode, rowCount, 1);
                String itemName = new FetchVoucherData().getItemName(itemCode, companyCode, mainFrame.getConnection2());
                String storeName = new FetchVoucherData().getStoreName(itemCode, companyCode, mainFrame.getConnection2());
                itemTable.getModel().setValueAt(itemName, rowCount, 2);
                itemTable.getModel().setValueAt(storeName, rowCount, 3);
                itemTable.getModel().setValueAt(rs.getString("unitName"), rowCount, 4);
                itemTable.getModel().setValueAt(rs.getString("quantity"), rowCount, 5);
                itemTable.getModel().setValueAt(rs.getString("rate"), rowCount, 6);
                itemTable.getModel().setValueAt(rs.getString("amount"), rowCount, 7);
                itemTable.getModel().setValueAt(rs.getString("expiryDate"), rowCount, 8);
                rowCount++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchItemDetail1(String companyCode, String voucherNumber, JTable itemTable, ProductionVoucher aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from PRODUCTION_VOUCHER_ITEM_CONSUMED where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null, null};
            model.addRow(data);
            itemTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                itemTable.setModel(model);
                itemTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String itemCode = rs.getString("itemCode");
                itemTable.getModel().setValueAt(itemCode, rowCount, 1);
                String itemName = new FetchVoucherData().getItemName(itemCode, companyCode, mainFrame.getConnection2());
                String storeName = new FetchVoucherData().getStoreName(itemCode, companyCode, mainFrame.getConnection2());
                itemTable.getModel().setValueAt(itemName, rowCount, 2);
                itemTable.getModel().setValueAt(storeName, rowCount, 3);
                itemTable.getModel().setValueAt(rs.getString("unitName"), rowCount, 4);
                itemTable.getModel().setValueAt(rs.getString("quantity"), rowCount, 5);
                itemTable.getModel().setValueAt(rs.getString("rate"), rowCount, 6);
                itemTable.getModel().setValueAt(rs.getString("amount"), rowCount, 7);
                itemTable.getModel().setValueAt(rs.getString("expiryDate"), rowCount, 8);
                rowCount++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public String getUnitName(String toString, String companyCode, Connection conn) {
        String unitName = null;
        String sql = "select unitName from ITEM_DETAIL where companyCode = ? AND itemCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            rs = ps.executeQuery();
            if (rs.next()) {
                unitName = rs.getString("unitName");
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return unitName;
    }

}
