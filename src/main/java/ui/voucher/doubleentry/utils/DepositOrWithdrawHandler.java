package ui.voucher.doubleentry.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.doubleentry.DepositOrWithdraw;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class DepositOrWithdrawHandler {

    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;

    /**
     *
     * @param mainFrame
     */
    public DepositOrWithdrawHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

    }

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean checkVoucherNumberIsValidOrNot(String companyCode, String voucherNumber, Connection conn) {
        boolean status = true;
        String sql = "select voucherNumber from DEPOSIT_OR_WITHDRAW_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            status = !rs.next();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveDepositOrWithdrawInfo(DepositOrWithdraw aThis, Connection conn, String companyCode) {
        boolean status = false;
        String sql1 = "insert into DEPOSIT_OR_WITHDRAW_DETAIL values (?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, aThis.getVoucherNumber());
            ps.setTimestamp(2, aThis.getDateT());
            ps.setString(3, aThis.getTotalDepositedAmt());
            ps.setString(4, aThis.getTotalWithDrawAmt());
            ps.setString(5, aThis.getOtherDetails());
            ps.setString(6, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveDepositAccountsInfo(DepositOrWithdraw aThis, Connection conn, String companyCode, JTable doubleEntryTable) {
        boolean status = false;
        String sql = "insert into DEPOSIT_DETAIL (cashAccNumber,bankAccNumber,depositedAmount,depositedSlipNumber,voucherNumber,companyCode) values (?,?,?,?,?,?)";
        if (doubleEntryTable.getRowCount() > 1) {
            for (int i = 0; i < doubleEntryTable.getRowCount() - 1; i++) {
                if (doubleEntryTable.getModel().getValueAt(i, 1) != null && doubleEntryTable.getModel().getValueAt(i, 4) != null) {
                    try {
                        conn.setAutoCommit(false);
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, aThis.getDepositTable(i, 1));
                        ps.setString(2, aThis.getDepositTable(i, 3));
                        ps.setString(3, aThis.getDepositTable(i, 5));
                        ps.setString(4, aThis.getDepositTable(i, 6));
                        ps.setString(5, aThis.getVoucherNumber());
                        ps.setString(6, companyCode);
                        ps.executeUpdate();
                        conn.commit();
                        status = true;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            status = true;
        }
        return status;
    }

    public boolean saveWithdrawAccountsInfo(DepositOrWithdraw aThis, Connection conn, String companyCode, JTable doubleEntryTable) {
        boolean status = false;
        String query = "insert into WITHDRAW_DETAIL (cashAccNumber,bankAccNumber,withdrawAmount,checkOrATMNumber,voucherNumber,companyCode) values (?,?,?,?,?,?)";
        if (doubleEntryTable.getRowCount() > 1) {
            for (int i = 0; i < doubleEntryTable.getRowCount() - 1; i++) {
                if (doubleEntryTable.getModel().getValueAt(i, 1) != null) {
                    try {
                        conn.setAutoCommit(false);
                        ps = conn.prepareStatement(query);
                        ps.setString(1, aThis.getWithDrawTable(i, 1));
                        ps.setString(2, aThis.getWithDrawTable(i, 3));
                        ps.setString(3, aThis.getWithDrawTable(i, 5));
                        ps.setString(4, aThis.getWithDrawTable(i, 6));
                        ps.setString(5, aThis.getVoucherNumber());
                        ps.setString(6, companyCode);
                        ps.executeUpdate();
                        conn.commit();
                        status = true;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } else {
            status = true;
        }
        return status;
    }

    public boolean deleteVoucherNumber(String companyCode, String voucherNumber, Connection conn) {
        boolean status = false;
        String sql = "delete from DEPOSIT_OR_WITHDRAW_DETAIL where voucherNumber = ? AND companyCode = ?";

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

    public boolean fetchDepositOrWithdrawInformation(String companyCode, JTable saleOrderListTable, Connection conn) {
        boolean status = false;
        removeAllRows(saleOrderListTable);
        String sql = "select * from DEPOSIT_OR_WITHDRAW_DETAIL where companyCode = ?";

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
                saleOrderListTable.getModel().setValueAt(rs.getString("totalDepositAmount"), row, 3);
                saleOrderListTable.getModel().setValueAt(rs.getString("totalWithDrawAmount"), row, 4);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfDepositOrWithdraw(String companyCode, String voucherNumber, DepositOrWithdraw aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from DEPOSIT_OR_WITHDRAW_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setAVoucherNumber(rs.getString("voucherNumber"));
                aThis.setDatee(rs.getTimestamp("dateForVoucher"));
                aThis.setTotalDepositedAmt(rs.getString("totalDepositAmount"));
                aThis.setTotalWithdrawAmt(rs.getString("totalWithDrawAmount"));
                aThis.setOtherDetails(rs.getString("otherDetails"));
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchAccountDetail(String companyCode, String voucherNumber, JTable depositTable, JTable withdrawTable, DepositOrWithdraw aThis, Connection conn) {
        boolean status = false;
        String sqlDeposit = "select * from DEPOSIT_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlDeposit);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) depositTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null, null};
            model.addRow(data);
            depositTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                depositTable.setModel(model);
                depositTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String casAccno = rs.getString("cashAccNumber");
                depositTable.getModel().setValueAt(casAccno, rowCount, 1);
                String cashAccName = new FetchVoucherData().getAccountName(casAccno, companyCode, mainFrame.getConnection2());
                depositTable.getModel().setValueAt(cashAccName, rowCount, 2);
                String bankAccno = rs.getString("bankAccNumber");
                depositTable.getModel().setValueAt(bankAccno, rowCount, 3);
                String bankAccName = new FetchVoucherData().getAccountName(bankAccno, companyCode, mainFrame.getConnection2());
                depositTable.getModel().setValueAt(bankAccName, rowCount, 4);
                depositTable.getModel().setValueAt(rs.getString("depositedAmount"), rowCount, 5);
                depositTable.getModel().setValueAt(rs.getString("depositedSlipNumber"), rowCount, 6);
                rowCount++;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String sqlWithdraw = "select * from WITHDRAW_DETAIL where voucherNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlWithdraw);
            ps.setString(1, voucherNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            int rowCount = 0;
            DefaultTableModel model = (DefaultTableModel) withdrawTable.getModel();
            model.setRowCount(0);
            Object[] data = {null, null, null, null, null, null, null};
            model.addRow(data);
            withdrawTable.setModel(model);
            while (rs.next()) {
                model.addRow(data);
                withdrawTable.setModel(model);
                withdrawTable.getModel().setValueAt(rowCount + 1, rowCount, 0);
                String casAccno = rs.getString("cashAccNumber");
                withdrawTable.getModel().setValueAt(casAccno, rowCount, 1);
                String cashAccName = new FetchVoucherData().getAccountName(casAccno, companyCode, mainFrame.getConnection2());
                withdrawTable.getModel().setValueAt(cashAccName, rowCount, 2);
                String bankAccno = rs.getString("bankAccNumber");
                withdrawTable.getModel().setValueAt(bankAccno, rowCount, 3);
                String bankAccName = new FetchVoucherData().getAccountName(bankAccno, companyCode, mainFrame.getConnection2());
                withdrawTable.getModel().setValueAt(bankAccName, rowCount, 4);
                withdrawTable.getModel().setValueAt(rs.getString("withdrawAmount"), rowCount, 5);
                withdrawTable.getModel().setValueAt(rs.getString("checkOrATMNumber"), rowCount, 6);
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
