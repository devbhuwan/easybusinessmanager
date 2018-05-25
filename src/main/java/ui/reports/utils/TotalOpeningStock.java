/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TotalOpeningStock {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;

    public TotalOpeningStock(MainFrame mainFrame, String companyCode,JTable firstReportTable) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.firstReportTable = firstReportTable;
    }
    
    public void runIn() {
        doInBackground();
    }

    private void doInBackground() {
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
        firstReportTable.setValueAt(openingStock, 0, 2);
    }
}
