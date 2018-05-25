package ui.voucher.saleandpurchase.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.saleandpurchase.SaleReturn;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class SaleReturnHandler {

    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;
    private final SaleReturn saleOrder;

    /**
     *
     * @param mainFrame
     * @param saleOrder
     */
    public SaleReturnHandler(MainFrame mainFrame, SaleReturn saleOrder) {
        this.mainFrame = mainFrame;
        this.saleOrder = saleOrder;

    }

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean fetchSaleReturnInformation(String companyCode, JTable saleOrderListTable, Connection conn) {
        boolean status = false;
        removeAllRows(saleOrderListTable);
        String sql = "select * from SALE_RETURN_DETAIL where companyCode = ?";
        DefaultTableModel model = (DefaultTableModel) saleOrderListTable.getModel();
        Object rowData[] = {null, null, null, null, null};
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
                String accountNumber = rs.getString("accountNumber");
                saleOrderListTable.getModel().setValueAt(accountNumber, row, 3);
                String customerName = new FetchVoucherData().getAccountName(accountNumber, companyCode, mainFrame.getConnection2());
                saleOrderListTable.getModel().setValueAt(customerName, row, 4);
                saleOrderListTable.getModel().setValueAt(rs.getDate("dateForVoucher").toString(), row, 2);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean checkVoucherNumberIsValidOrNot(String companyCode, String voucherNumber, Connection conn) {
        boolean status = true;
        String sql = "select voucherNumber from SALE_RETURN_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            status = !rs.next();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean saveSaleReturnInfo(SaleReturn aThis, Connection conn, String companyCode) {
        boolean status = false;
        String sql1 = "insert into SALE_RETURN_DETAIL values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, aThis.getVoucherNumber());
            ps.setString(2, aThis.getAccountNumber());
            ps.setTimestamp(3, aThis.getDateT());
            ps.setString(4, aThis.getAddress());
            ps.setString(5, aThis.getOtherDetails());
            ps.setString(6, aThis.getSumOfRows());
            ps.setString(7, aThis.getTotalAmount());
            ps.setString(8, aThis.getIsCash());
            ps.setString(9, aThis.getIsBank());
            ps.setString(10, aThis.getCreditAmount());
            ps.setString(11, aThis.getCreditType());
            ps.setString(12, aThis.getCreditDay());
            ps.setTimestamp(13, aThis.getCreditDate());
            ps.setString(14, aThis.getDebitAmount());
            ps.setString(15, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aThis.getIsCash().equalsIgnoreCase("Y")) {
            status = false;
            String sql = "insert into SALE_RETURN_CASH_DETAIL (amount,accountNumber,voucherNumber,companyCode) values (?,?,?,?)";
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(sql);
                ps.setString(1, aThis.getCashAmount());
                ps.setString(2, aThis.getCashAccountNumber());
                ps.setString(3, aThis.getVoucherNumber());
                ps.setString(4, companyCode);
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (aThis.getIsBank().equalsIgnoreCase("Y")) {
            status = false;
            String sql = "insert into SALE_RETURN_BANK_DETAIL (amount,accountNumber,voucherNumber,companyCode) values (?,?,?,?)";
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(sql);
                ps.setString(1, aThis.getBankAmount());
                ps.setString(2, aThis.getBankAccountNumber());
                ps.setString(3, aThis.getVoucherNumber());
                ps.setString(4, companyCode);
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    public boolean saveItemOrderInfo(SaleReturn aThis, Connection conn, String companyCode, JTable itemTable) {
        boolean status = false;
        String sql2 = "insert into SALE_RETURN_ITEM_LIST (itemCode,unitName,quantity,rate,itemAmount,billSundry,taxClass,atTheRate,nature,miscAmount,totalRowAmount, expiryDate,voucherNumber,companyCode) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        for (int i = 0; i < itemTable.getRowCount() - 1; i++) {
            if (itemTable.getModel().getValueAt(i, 1) != null || itemTable.getModel().getValueAt(i, 8) != null) {
                try {
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql2);
                    ps.setString(1, aThis.getItemTableValue(i, 1));
                    ps.setString(2, aThis.getItemTableValue(i, 4));
                    ps.setString(3, aThis.getItemTableValue(i, 5));
                    ps.setString(4, aThis.getItemTableValue(i, 6));
                    ps.setString(5, aThis.getItemTableValue(i, 7));
                    ps.setString(6, aThis.getItemTableValue(i, 8));
                    ps.setString(7, aThis.getItemTableValue(i, 9));
                    ps.setString(8, aThis.getItemTableValue(i, 10));
                    ps.setString(9, aThis.getItemTableValue(i, 11));
                    ps.setString(10, aThis.getItemTableValue(i, 12));
                    ps.setString(11, aThis.getItemTableValue(i, 13));
                    ps.setTimestamp(12, aThis.getItemTableTimeValue(i, 14));
                    ps.setString(13, aThis.getVoucherNumber());
                    ps.setString(14, companyCode);
                    ps.executeUpdate();
                    conn.commit();
                    status = true;
                } catch (SQLException ex) {
                    Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return status;
    }

    public boolean saveBillSundryInfo(SaleReturn aThis, Connection conn, String companyCode, JTable billSundryTable) {
        boolean status = false;
        String sql = "insert into SALE_RETURN_BILL_SUNDRY_LIST (billSundry,atTheRate,taxClass,nature,amount,voucherNumber,companyCode) values (?,?,?,?,?,?,?)";
        for (int i = 0; i < billSundryTable.getRowCount() - 1; i++) {
            if (billSundryTable.getModel().getValueAt(i, 0) != null) {
                try {
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, aThis.getBillSundryTableValue(i, 0));
                    ps.setString(2, aThis.getBillSundryTableValue(i, 1));
                    ps.setString(3, aThis.getBillSundryTableValue(i, 2));
                    ps.setString(4, aThis.getBillSundryTableValue(i, 3));
                    ps.setString(5, aThis.getBillSundryTableValue(i, 4));
                    ps.setString(6, aThis.getVoucherNumber());
                    ps.setString(7, companyCode);
                    ps.executeUpdate();
                    conn.commit();
                    status = true;
                } catch (SQLException ex) {
                    status = false;
                    Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return status;
    }

    public boolean deleteVoucherNumber(String companyCode, String voucherNumber, Connection conn) {
        boolean status = false;
        String sql = "delete from SALE_RETURN_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchDataOfSaleReturn(String companyCode, String voucherNumber, SaleReturn aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from SALE_RETURN_DETAIL where voucherNumber = ? AND companyCode = ?";
        boolean isCash = false;
        boolean isBank = false;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setVoucherNu(rs.getString("voucherNumber"));
                String accountNumber = rs.getString("accountNumber");
                aThis.setAccountNumber(accountNumber);
                String customerName = new FetchVoucherData().getAccountName(accountNumber, companyCode, mainFrame.getConnection2());
                aThis.setCustomerName(customerName);
                aThis.setDatee(rs.getTimestamp("dateForVoucher"));
                aThis.setAddress(rs.getString("address"));
                aThis.setOtherDetails(rs.getString("otherDetails"));
                aThis.setSumOfRows(rs.getString("amount"));
                aThis.setTotalAmount(rs.getString("totalAmount"));
                if (rs.getString("isCash").equalsIgnoreCase("Y")) {
                    isCash = true;
                }
                if (rs.getString("isBank").equalsIgnoreCase("Y")) {
                    isBank = true;
                }
                aThis.setCreditAmount(rs.getString("creditAmount"), rs.getString("creditType"), rs.getString("creditDay"), rs.getTimestamp("creditDate"));
                aThis.setDebitAmount(rs.getString("debitAmount"));
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isCash) {
            status = false;
            String query = "select * from SALE_RETURN_CASH_DETAIL where voucherNumber = ? AND companyCode = ?";
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(query);
                ps.setString(1, voucherNumber);
                ps.setString(2, companyCode);
                rs = ps.executeQuery();
                if(rs.next()) {
                    aThis.setCashAmount(rs.getString("amount"));
                    aThis.setCashAccNo(rs.getString("accountNumber"));
                }
                conn.commit();
                status = true;
            } catch (SQLException ex) {

            }
        }
        if (isBank) {
            status = false;
            String query = "select * from SALE_RETURN_BANK_DETAIL where voucherNumber = ? AND companyCode = ?";
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(query);
                ps.setString(1, voucherNumber);
                ps.setString(2, companyCode);
                rs = ps.executeQuery();
                if(rs.next()) {
                    aThis.setBankAmount(rs.getString("amount"));
                    aThis.setBankAccNo(rs.getString("accountNumber"));
                }
                conn.commit();
                status = true;
            } catch (SQLException ex) {

            }
        }
        return status;
    }

    public boolean fetchItemDetail(String companyCode, String voucherNumber, JTable itemTable, SaleReturn aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from SALE_RETURN_ITEM_LIST where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null, null, null, null, null, null, null, null, null};
            model.addRow(data);
            itemTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                itemTable.setModel(model);
                itemTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String itemCode = rs.getString("itemCode");
                itemTable.getModel().setValueAt(itemCode, rowCount, 1);
                String itemName = new FetchVoucherData().getItemName(itemCode, companyCode, mainFrame.getConnection2());
                itemTable.getModel().setValueAt(itemName, rowCount, 2);
                String storeName = new FetchVoucherData().getStoreName(itemCode, companyCode, mainFrame.getConnection2());
                itemTable.getModel().setValueAt(storeName, rowCount, 3);
                itemTable.getModel().setValueAt(rs.getString("unitName"), rowCount, 4);
                itemTable.getModel().setValueAt(rs.getString("quantity"), rowCount, 5);
                itemTable.getModel().setValueAt(rs.getString("rate"), rowCount, 6);
                itemTable.getModel().setValueAt(rs.getString("itemAmount"), rowCount, 7);
                itemTable.getModel().setValueAt(rs.getString("billSundry"), rowCount, 8);
                itemTable.getModel().setValueAt(rs.getString("taxClass"), rowCount, 9);
                itemTable.getModel().setValueAt(rs.getString("atTheRate"), rowCount, 10);
                itemTable.getModel().setValueAt(rs.getString("nature"), rowCount, 11);
                itemTable.getModel().setValueAt(rs.getString("miscAmount"), rowCount, 12);
                itemTable.getModel().setValueAt(rs.getString("totalRowAmount"), rowCount, 13);
                itemTable.getModel().setValueAt(rs.getDate("expiryDate"), rowCount, 14);
                rowCount++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchBillSundryDetail(String companyCode, String voucherNumber, JTable billSundryTable, SaleReturn aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from SALE_RETURN_BILL_SUNDRY_LIST where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) billSundryTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null};
            model.addRow(data);
            billSundryTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                billSundryTable.setModel(model);
                billSundryTable.getModel().setValueAt(rs.getString("billSundry"), rowCount, 0);
                billSundryTable.getModel().setValueAt(rs.getString("atTheRate"), rowCount, 1);
                billSundryTable.getModel().setValueAt(rs.getString("taxClass"), rowCount, 2);
                billSundryTable.getModel().setValueAt(rs.getString("nature"), rowCount, 3);
                billSundryTable.getModel().setValueAt(rs.getString("amount"), rowCount, 4);
                rowCount++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SaleReturnHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unitName;
    }
}
