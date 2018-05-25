/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.daybook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.reports.ReportUtils;
import ui.voucher.FetchVoucherData;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class DepositAndWithdrawThread {

    private final MainFrame mainFrame;
    private final JTable reportTable;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private final String companyCode;
    private Connection con;
    private PreparedStatement p;
    private ResultSet r;
    private int rowCount;

    public DepositAndWithdrawThread(MainFrame mainFrame, JTable reportTable, String companyCode) {
        this.mainFrame = mainFrame;
        this.reportTable = reportTable;
        this.companyCode = companyCode;
    }

    public void run(Calendar cal) {
        doInBackgroundProcess(cal);
    }

    private void doInBackgroundProcess(Calendar cal) {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        String fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        String toDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) + 1)));
        String sql = "select * from DEPOSIT_OR_WITHDRAW_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        try {
            conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            rowCount = reportTable.getRowCount();
            while (rs.next()) {
                String vN = rs.getString("voucherNumber");
                Date date = rs.getDate("dateForVoucher");
                if (new ReportUtils().checkDateIsValid(date, cal, cal)) {
                    checkDepositAccounts(vN, String.valueOf(date));
                    checkWithdrawAccounts(vN, String.valueOf(date));
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        Object[] data = {null, null, null, null, null, null};
        model.addRow(data);
        reportTable.setModel(model);
    }

    private void checkDepositAccounts(String vN, String date) {
        String sql = "select * from DEPOSIT_DETAIL where voucherNumber = ?";
        try {
            con = mainFrame.getConnection2();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);
            p.setString(1, vN);
            r = p.executeQuery();
            while (r.next()) {
                String cashAccNo = r.getString("cashAccNumber");
                String acNCash = new ReportUtils().getAccountName(cashAccNo,companyCode,mainFrame);
                String bankAccNo = r.getString("bankAccNumber");
                String acNBank = new ReportUtils().getAccountName(bankAccNo, companyCode, mainFrame);
                String amount = r.getString("depositedAmount");
                addRow();
                reportTable.setValueAt(rowCount + 1, rowCount, 0);
                reportTable.setValueAt(date, rowCount, 1);
                reportTable.setValueAt(vN, rowCount, 2);
                reportTable.setValueAt(cashAccNo, rowCount, 3);
                reportTable.setValueAt(acNCash, rowCount, 4);
                reportTable.setValueAt(null, rowCount, 5);
                reportTable.setValueAt(amount, rowCount, 6);
                reportTable.setValueAt("DEPOSIT", rowCount, 7);
                rowCount++;
                addRow();
                reportTable.setValueAt(rowCount + 1, rowCount, 0);
                reportTable.setValueAt(date, rowCount, 1);
                reportTable.setValueAt(vN, rowCount, 2);
                reportTable.setValueAt(bankAccNo, rowCount, 3);
                reportTable.setValueAt(acNBank, rowCount, 4);
                reportTable.setValueAt(amount, rowCount, 5);
                reportTable.setValueAt(null, rowCount, 6);
                reportTable.setValueAt("DEPOSIT", rowCount, 7);
                rowCount++;
            }
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void checkWithdrawAccounts(String vN, String date) {
        String sql = "select * from WITHDRAW_DETAIL where voucherNumber = ?";
        try {
            con = mainFrame.getConnection2();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);
            p.setString(1, vN);
            r = p.executeQuery();
            while (r.next()) {
                String cashAccNo = r.getString("cashAccNumber");
                String acNCash = new ReportUtils().getAccountName(cashAccNo,companyCode,mainFrame);
                String bankAccNo = r.getString("bankAccNumber");
                String acNBank = new ReportUtils().getAccountName(bankAccNo, companyCode, mainFrame);
                String amount = r.getString("withdrawAmount");
                addRow();
                reportTable.setValueAt(rowCount + 1, rowCount, 0);
                reportTable.setValueAt(date, rowCount, 1);
                reportTable.setValueAt(vN, rowCount, 2);
                reportTable.setValueAt(cashAccNo, rowCount, 3);
                reportTable.setValueAt(acNCash, rowCount, 4);
                reportTable.setValueAt(amount, rowCount, 5);
                reportTable.setValueAt(null, rowCount, 6);
                reportTable.setValueAt("WITHDRAW", rowCount, 7);
                rowCount++;
                addRow();
                reportTable.setValueAt(rowCount + 1, rowCount, 0);
                reportTable.setValueAt(date, rowCount, 1);
                reportTable.setValueAt(vN, rowCount, 2);
                reportTable.setValueAt(bankAccNo, rowCount, 3);
                reportTable.setValueAt(acNBank, rowCount, 4);
                reportTable.setValueAt(null, rowCount, 5);
                reportTable.setValueAt(amount, rowCount, 6);
                reportTable.setValueAt("WITHDRAW", rowCount, 7);
                rowCount++;
            }
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
