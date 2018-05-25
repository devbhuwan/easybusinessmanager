package ui.voucher.doubleentry.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.doubleentry.PaymentVoucher;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class PaymentVoucherHandler {

    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;

    /**
     *
     * @param mainFrame
     */
    public PaymentVoucherHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

    }

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean checkVoucherNumberIsValidOrNot(String companyCode, String voucherNumber, Connection conn) {
        boolean status = true;
        String sql = "select voucherNumber from PAYMENT_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";
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

    public boolean savePaymentVoucherInfo(PaymentVoucher aThis, Connection conn, String companyCode) {
        boolean status = false;
        String sql1 = "insert into PAYMENT_VOUCHER_DETAIL values (?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, aThis.getVoucherNumber());
            ps.setTimestamp(2, aThis.getDateT());
            ps.setString(3, aThis.getOtherDetails());
            ps.setString(4, aThis.getTotalCredit());
            ps.setString(5, aThis.getTotalDebit());
            ps.setString(6, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean savePaymentVoucherAccountsInfo(PaymentVoucher aThis, Connection conn, String companyCode, JTable doubleEntryTable) {
        boolean status = false;
        String sql = "insert into PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT (debitAccountNumber,debitAmount,narration,voucherNumber,companyCode) values (?,?,?,?,?)";
        String query = "insert into PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT (creditAccountNumber,creditAmount,narration,voucherNumber,companyCode) values (?,?,?,?,?)";
        for (int i = 0; i < doubleEntryTable.getRowCount() - 1; i++) {
            if (doubleEntryTable.getModel().getValueAt(i, 1) != null && doubleEntryTable.getModel().getValueAt(i, 4) != null) {
                try {
                    conn.setAutoCommit(false);
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, aThis.getTableDate(i, 1));
                    ps.setString(2, aThis.getTableDate(i, 3));
                    ps.setString(3, aThis.getTableDate(i, 7));
                    ps.setString(4, aThis.getVoucherNumber());
                    ps.setString(5, companyCode);
                    ps.executeUpdate();
                    conn.commit();
                    status = true;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(query);
                ps.setString(1, aThis.getTableDate(i, 4));
                ps.setString(2, aThis.getTableDate(i, 6));
                ps.setString(3, aThis.getTableDate(i, 7));
                ps.setString(4, aThis.getVoucherNumber());
                ps.setString(5, companyCode);
                ps.executeUpdate();
                conn.commit();
                status = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }

    public boolean deleteVoucherNumber(String companyCode, String voucherNumber, Connection conn) {
        boolean status = false;
        String sql = "delete from PAYMENT_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";

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

    public boolean fetchPaymentVoucherInformation(String companyCode, JTable saleOrderListTable, Connection conn) {
        boolean status = false;
        removeAllRows(saleOrderListTable);
        String sql = "select * from PAYMENT_VOUCHER_DETAIL where companyCode = ?";

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
                saleOrderListTable.getModel().setValueAt(rs.getDate("dateForVoucher").toString(), row, 2);
                saleOrderListTable.getModel().setValueAt(rs.getString("totalCredit"), row, 3);
                saleOrderListTable.getModel().setValueAt(rs.getString("totalDebit"), row, 4);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfPaymentVoucher(String companyCode, String voucherNumber, PaymentVoucher aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from PAYMENT_VOUCHER_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setAVoucherNumber(rs.getString("voucherNumber"));
                aThis.setDatee(rs.getTimestamp("dateForVoucher"));
                aThis.setOtherDetails(rs.getString("otherDetails"));
                aThis.setTotalCredit(rs.getString("totalCredit"));
                aThis.setTotalDebit(rs.getString("totalDebit"));
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchAccountDetail(String companyCode, String voucherNumber, JTable doubleEntryTable, PaymentVoucher aThis, Connection conn) {
        boolean status = false;
        String sqlDebit = "select * from PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlDebit);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) doubleEntryTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null, null};
            model.addRow(data);
            doubleEntryTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                doubleEntryTable.setModel(model);
                doubleEntryTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String debitAccNumber = rs.getString("debitAccountNumber");
                doubleEntryTable.getModel().setValueAt(debitAccNumber, rowCount, 1);
                String debitAccName = new FetchVoucherData().getAccountName(debitAccNumber, companyCode, mainFrame.getConnection2());
                doubleEntryTable.getModel().setValueAt(debitAccName, rowCount, 2);
                doubleEntryTable.getModel().setValueAt(rs.getString("debitAmount"), rowCount, 3);
                rowCount++;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sqlCredit = "select * from PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlCredit);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            while (rs.next()) {
                String creditAccNumber = rs.getString("creditAccountNumber");
                doubleEntryTable.getModel().setValueAt(creditAccNumber, rowCount, 4);
                String creditAccName = new FetchVoucherData().getAccountName(creditAccNumber, companyCode, mainFrame.getConnection2());
                doubleEntryTable.getModel().setValueAt(creditAccName, rowCount, 5);
                doubleEntryTable.getModel().setValueAt(rs.getString("creditAmount"), rowCount, 6);
                doubleEntryTable.getModel().setValueAt(rs.getString("narration"), rowCount, 7);
                rowCount++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
