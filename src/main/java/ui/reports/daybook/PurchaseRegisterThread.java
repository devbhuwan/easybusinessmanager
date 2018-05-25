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
public class PurchaseRegisterThread {

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

    public PurchaseRegisterThread(MainFrame mainFrame, JTable reportTable, String companyCode) {
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
        String sql = "select * from PURCHASE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        try {
            conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            rowCount = reportTable.getRowCount();
            while (rs.next()) {
                String vN = rs.getString("voucherNumber");
                String accNo = rs.getString("accountNumber");
                String accName = new FetchVoucherData().getAccountName(accNo, companyCode, mainFrame.getConnection2());
                Date date = rs.getDate("dateForVoucher");
                if (new ReportUtils().checkDateIsValid(date, cal, cal)) {
                    String totAmt = rs.getString("totalAmount");
                    String creditAmt = rs.getString("creditAmount");
                    String debitAmt = rs.getString("debitAmount");
                    addRow();
                    reportTable.setValueAt(rowCount + 1, rowCount, 0);
                    reportTable.setValueAt(date, rowCount, 1);
                    reportTable.setValueAt(vN, rowCount, 2);
                    reportTable.setValueAt(null, rowCount, 3);
                    reportTable.setValueAt("Purchase A/c", rowCount, 4);
                    reportTable.setValueAt(totAmt, rowCount, 5);
                    reportTable.setValueAt(null, rowCount, 6);
                    reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                    rowCount++;
                    boolean b1 = checkCashPay(vN, rowCount, date);
                    boolean b2 = checkBankPay(vN, rowCount, date);
                    if (!b1 && !b2) {
                        addRow();
                        reportTable.setValueAt(accNo, rowCount, 3);
                        reportTable.setValueAt(accName, rowCount, 4);
                        reportTable.setValueAt(null, rowCount, 5);
                        reportTable.setValueAt(totAmt, rowCount, 6);
                        reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                        rowCount++;
                    } else {
                        try {
                            Double.valueOf(creditAmt);
                            addRow();
                            reportTable.setValueAt(accNo, rowCount, 3);
                            reportTable.setValueAt(accName, rowCount, 4);
                            reportTable.setValueAt(creditAmt, rowCount, 5);
                            reportTable.setValueAt(null, rowCount, 6);
                            reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                            rowCount++;
                        } catch (NullPointerException | NumberFormatException ex) {

                        }
                        try {
                            Double.valueOf(debitAmt);
                            addRow();
                            reportTable.setValueAt(accNo, rowCount, 3);
                            reportTable.setValueAt(accName, rowCount, 4);
                            reportTable.setValueAt(null, rowCount, 5);
                            reportTable.setValueAt(debitAmt, rowCount, 6);
                            reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                            rowCount++;
                        } catch (NullPointerException | NumberFormatException ex) {

                        }
                    }
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

    private boolean checkCashPay(String vN, int row, Date date) {
        boolean status = false;
        String sql = "SELECT * FROM PURCHASE_REGISTER_CASH_DETAIL where companyCode = ? AND voucherNumber = ?";
        try {
            con = mainFrame.getConnection2();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);
            p.setString(1, companyCode);
            p.setString(2, vN);
            r = p.executeQuery();
            if (r.next()) {
                status = true;
                String amt = r.getString("amount");
                String accNo = r.getString("accountNumber");
                addRow();
                String accName = new ReportUtils().getAccountName(accNo, companyCode, mainFrame);
                reportTable.setValueAt(accNo, row, 3);
                reportTable.setValueAt(accName, row, 4);
                reportTable.setValueAt(null, rowCount, 5);
                reportTable.setValueAt(amt, rowCount, 6);
                reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                rowCount++;
            }
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    private boolean checkBankPay(String vN, int row, Date date) {
        boolean status = false;
        String sql = "SELECT * FROM PURCHASE_REGISTER_BANK_DETAIL where companyCode = ? AND voucherNumber = ?";
        try {
            con = mainFrame.getConnection2();
            con.setAutoCommit(false);
            p = con.prepareStatement(sql);
            p.setString(1, companyCode);
            p.setString(2, vN);
            r = p.executeQuery();
            if (r.next()) {
                status = true;
                String amt = r.getString("amount");
                String accNo = r.getString("accountNumber");
                addRow();
                String accName = new FetchVoucherData().getAccountName(accNo, companyCode, mainFrame.getConnection3());
                reportTable.setValueAt(accNo, row, 3);
                reportTable.setValueAt(accName, row, 4);
                reportTable.setValueAt(null, rowCount, 5);
                reportTable.setValueAt(amt, rowCount, 6);
                reportTable.setValueAt("PURCHASE REGISTER", rowCount, 7);
                rowCount++;
            }
            con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
