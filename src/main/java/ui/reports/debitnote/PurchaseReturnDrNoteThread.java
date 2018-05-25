/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.debitnote;

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

/**
 *
 * @author Vimal
 */
public class PurchaseReturnDrNoteThread {

    private final MainFrame mainFrame;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private int rowCount;

    /**
     *
     * @param mainFrame
     * @param reportTable
     * @param selectedAccNo
     * @param companyCode
     * @param cal
     * @param cal1
     */
    public PurchaseReturnDrNoteThread(MainFrame mainFrame, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;

    }

    public void run() {
        doInBackgrounProcess();
    }

    private void doInBackgrounProcess() {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        String fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        String toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        String sql = "SELECT * from PURCHASE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") ORDER BY dateForVoucher asc";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            rowCount = reportTable.getRowCount();
            while (rs.next()) {
                String vN = rs.getString("voucherNumber");
                Date date = rs.getDate("dateForVoucher");
                if (new ReportUtils().checkDateIsValid(date, cal, cal1)) {
                    String aN = rs.getString("accountNumber");
                    if (selectedAccNo.contains(aN)) {
                        String totA = rs.getString("totalAmount");
                        double totCr = 0;
                        if (rs.getString("isBank").equalsIgnoreCase("Y")) {
                            String sqlB = "SELECT amount FROM PURCHASE_RETURN_BANK_DETAIL where voucherNumber = ?";
                            Connection con = mainFrame.getConnection2();
                            con.setAutoCommit(false);
                            PreparedStatement p = con.prepareStatement(sqlB);
                            p.setString(1, vN);
                            ResultSet r = p.executeQuery();
                            if (r.next()) {
                                try {
                                    totCr = totCr + Double.valueOf(r.getString("amount"));
                                } catch (NullPointerException | NumberFormatException ex) {
                                }
                            }
                            con.commit();
                        }

                        if (rs.getString("isCash").equalsIgnoreCase("Y")) {
                            String sqlB = "SELECT amount FROM PURCHASE_RETURN_CASH_DETAIL where voucherNumber = ?";
                            Connection con = mainFrame.getConnection2();
                            con.setAutoCommit(false);
                            PreparedStatement p = con.prepareStatement(sqlB);
                            p.setString(1, vN);
                            ResultSet r = p.executeQuery();
                            if (r.next()) {
                                try {
                                    totCr = totCr + Double.valueOf(r.getString("amount"));
                                } catch (NullPointerException | NumberFormatException ex) {
                                }
                            }
                            con.commit();
                        }
                        addRow();
                        String accName = new ReportUtils().getAccountName(aN, companyCode, mainFrame);
                        reportTable.setValueAt(rowCount + 1, rowCount, 0);
                        reportTable.setValueAt(date, rowCount, 1);
                        reportTable.setValueAt(vN, rowCount, 2);
                        reportTable.setValueAt(aN, rowCount, 3);
                        reportTable.setValueAt(accName, rowCount, 4);
                        reportTable.setValueAt(totCr, rowCount, 5);
                        reportTable.setValueAt(totA, rowCount, 6);
                        reportTable.setValueAt(Double.valueOf(totA) < Double.valueOf(totCr) ? String.valueOf((Math.abs(Double.valueOf(totA) - totCr))) + " (Payable)" : String.valueOf((Math.abs(Double.valueOf(totA) - totCr))) + " (Recievable)", rowCount, 7);
                        rowCount++;
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

}
