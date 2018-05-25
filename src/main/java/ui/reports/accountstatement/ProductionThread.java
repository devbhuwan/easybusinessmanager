/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.accountstatement;

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
public class ProductionThread {

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

    public ProductionThread(MainFrame mainFrame, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run(Calendar cal, Calendar cal1) {
        doInBackgroundProcess(cal, cal1);
    }

    private void doInBackgroundProcess(Calendar cal, Calendar cal1) {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        String fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        String toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        String sql = "select * from PRODUCTION_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") ORDER by dateForVoucher desc";
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
                    String genAmount = rs.getString("generatedAmount");
                    String conAmount = rs.getString("consumedAmount");
                    show = true;
                    try {
                        Double.valueOf(genAmount);
                        show = false;
                        addRow();
                        reportTable.setValueAt(rowCount + 1, rowCount, 0);
                        reportTable.setValueAt(date, rowCount, 1);
                        reportTable.setValueAt(vN, rowCount, 2);
                        reportTable.setValueAt(null, rowCount, 3);
                        reportTable.setValueAt("GENERATED A/C", rowCount, 4);
                        reportTable.setValueAt(genAmount, rowCount, 5);
                        reportTable.setValueAt(null, rowCount, 6);
                        reportTable.setValueAt("PRODUCTION", rowCount, 7);
                        rowCount++;
                    } catch (NullPointerException | NumberFormatException ex) {

                    }
                    try {
                        Double.valueOf(conAmount);
                        addRow();
                        if (show) {
                            reportTable.setValueAt(rowCount + 1, rowCount, 0);
                            reportTable.setValueAt(date, rowCount, 1);
                            reportTable.setValueAt(vN, rowCount, 2);
                        }
                        reportTable.setValueAt(null, rowCount, 3);
                        reportTable.setValueAt("CONSUMED A/C", rowCount, 4);
                        reportTable.setValueAt(null, rowCount, 5);
                        reportTable.setValueAt(conAmount, rowCount, 6);
                        reportTable.setValueAt("PRODUCTION", rowCount, 7);
                        rowCount++;
                    } catch (NullPointerException | NumberFormatException ex) {

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
