/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TotalCapital {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private JournalOnlyAmount totJournalOnlyAmount;
    private final int row;
    private final int col;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param firstReportTable
     * @param cal
     * @param cal1
     * @param row
     * @param col
     */
    public TotalCapital(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1,int row, int col) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.firstReportTable = firstReportTable;
        this.cal = cal;
        this.cal1 = cal1;
        this.row = row;
        this.col = col;
    }

    public void runIn() {
        doInBackground();
    }

    private void doInBackground() {
        double capital = 0;
        capital = capital + getOpeningStock();
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Capital Account");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        capital = capital + totJournalOnlyAmount.run();
        if (totJournalOnlyAmount.isFinished()) {
            firstReportTable.setValueAt(capital, row, col);
        }
    }
    
    private double getOpeningStock() {
        String sql = "SELECT purchasePrice,selfDevCost FROM ITEM_DETAIL where companyCode = ? AND selfDevCost IS NOT NULL";
        double openingStock = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pur = rs.getString("purchasePrice");
                String qty = rs.getString("selfDevCost");
                try {
                    openingStock = openingStock + Double.valueOf(pur) * Double.valueOf(qty);
                }catch(NullPointerException|NumberFormatException ex) {
                    openingStock = openingStock + 0;
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return openingStock;
    }
}
