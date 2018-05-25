/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.production;

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
public class ProductionVoucherProReThread {

    private final MainFrame mainFrame;
    private final JTable reportTable;
    private final ArrayList<String> selectedItemCode;
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
    public ProductionVoucherProReThread(MainFrame mainFrame, JTable reportTable, ArrayList<String> selectedItemCode, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.reportTable = reportTable;
        this.selectedItemCode = selectedItemCode;
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
        String sql = "SELECT * from PRODUCTION_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") ORDER BY dateForVoucher desc";
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
                    String sqlG = "SELECT * FROM PRODUCTION_VOUCHER_ITEM_GENERATED where voucherNumber = ?";
                    Connection con = mainFrame.getConnection2();
                    con.setAutoCommit(false);
                    PreparedStatement p = con.prepareStatement(sqlG);
                    p.setString(1, vN);
                    ResultSet r = p.executeQuery();
                    while (r.next()) {
                        String iC = r.getString("itemCode");
                        if (selectedItemCode.contains(iC)) {
                            String iN = new ReportUtils().getItemName(iC, companyCode, mainFrame);
                            addRow();
                            reportTable.setValueAt(rowCount + 1, rowCount, 0);
                            reportTable.setValueAt(date, rowCount, 1);
                            reportTable.setValueAt(vN, rowCount, 2);
                            reportTable.setValueAt(iC, rowCount, 3);
                            reportTable.setValueAt(iN, rowCount, 4);
                            reportTable.setValueAt(r.getString("unitName"), rowCount, 5);
                            reportTable.setValueAt(r.getString("quantity"), rowCount, 6);
                            reportTable.setValueAt(r.getString("rate"), rowCount, 7);
                            reportTable.setValueAt(r.getString("amount"), rowCount, 8);
                            reportTable.setValueAt(r.getString("expiryDate"), rowCount, 9);
                            rowCount++;
                        }
                    }
                    con.commit();
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
