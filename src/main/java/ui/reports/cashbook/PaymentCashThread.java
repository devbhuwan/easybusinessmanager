/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.cashbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class PaymentCashThread {

    private final MainFrame mainFrame;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private final String companyCode;
    private Connection con;
    private PreparedStatement p;
    private ResultSet r;
    private int rowCount;
    private boolean show;

    public PaymentCashThread(MainFrame mainFrame, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run(Calendar cal,Calendar cal1) {
        doInBackgroundProcess(cal,cal1);
    }

    private void doInBackgroundProcess(Calendar cal, Calendar cal1) {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        String fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        String toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        String sql = "select voucherNumber,dateForVoucher from PAYMENT_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") ORDER by dateForVoucher desc";
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
                if (new ReportUtils().checkDateIsValid(date, cal, cal1)) {
                    checkAccounts(vN, String.valueOf(date));
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

    private void checkAccounts(String vN, String date) {
        String sql = "select * from PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT,PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where (PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT.voucherNumber = ? ) AND (PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT.voucherNumber = ?) AND (PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT.ID = PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT.ID)";
        try {
            con = mainFrame.getConnection2();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);
            p.setString(1, vN);
            p.setString(2, vN);
            r = p.executeQuery();
            while (r.next()) {
                String aNC = r.getString("creditAccountNumber");
                if (selectedAccNo.contains(aNC)) {
                    String amountC = r.getString("creditAmount");
                    String sNo = r.getString("debitAccountNumber");
                    String acNC = new ReportUtils().getAccountName(sNo, companyCode, mainFrame);
                    addRow();
                    reportTable.setValueAt(rowCount + 1, rowCount, 0);
                    reportTable.setValueAt(date, rowCount, 1);
                    reportTable.setValueAt(vN, rowCount, 2);
                    reportTable.setValueAt(sNo, rowCount, 3);
                    reportTable.setValueAt(acNC, rowCount, 4);
                    reportTable.setValueAt(amountC, rowCount, 5);
                    reportTable.setValueAt(null, rowCount, 6);
                    reportTable.setValueAt("PAYMENT VOUCHER", rowCount, 7);
                    rowCount++;
                }
            }
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
