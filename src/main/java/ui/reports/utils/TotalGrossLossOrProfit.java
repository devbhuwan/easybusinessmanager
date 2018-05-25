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
import ui.reports.utils.JournalOnlyAmount;
import ui.reports.utils.PurchaseAmount;
import ui.reports.utils.SaleAmount;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TotalGrossLossOrProfit {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private PurchaseAmount totPurchase;
    private JournalOnlyAmount totJournalOnlyAmount;
    private SaleAmount totSale;
    private ClosingStockAmount closingAmount;

    public TotalGrossLossOrProfit(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.firstReportTable = firstReportTable;
        this.cal = cal;
        this.cal1 = cal1;
    }

    public void runIn() {
        doInBackground();
    }

    private void doInBackground() {
        double debitAmount = 0;
        double creditAmount = 0;
        debitAmount = debitAmount + getOpeningStock();
        System.out.println("Opening S" + debitAmount);
        totPurchase = new PurchaseAmount(mainFrame, companyCode, cal, cal1);
        debitAmount = debitAmount + totPurchase.run();
        System.out.println("Pur " + debitAmount);
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Expenses(Direct)");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        debitAmount = debitAmount + totJournalOnlyAmount.run();
        totSale = new SaleAmount(mainFrame, companyCode, cal, cal1);
        creditAmount = creditAmount + totSale.run();
        closingAmount = new ClosingStockAmount(mainFrame, companyCode, cal, cal1);
        creditAmount = creditAmount + closingAmount.run();
        Double sepAmount = Math.abs(debitAmount - creditAmount);
        if (debitAmount > creditAmount) {
            firstReportTable.setValueAt("GROSS LOSS (b/d)", 0, 1);
            firstReportTable.setValueAt(sepAmount, 0, 2);
        } else if (creditAmount > debitAmount) {
            firstReportTable.setValueAt("GROSS PROFIT (b/d)", 0, 4);
            firstReportTable.setValueAt(sepAmount, 0, 5);
        } else {
            firstReportTable.setValueAt(null, 0, 0);
            firstReportTable.setValueAt("NO NET CHANGES OCCURRED", 0, 1);
            firstReportTable.setValueAt(null, 0, 2);
            firstReportTable.setValueAt(null, 0, 3);
            firstReportTable.setValueAt(null, 0, 4);
            firstReportTable.setValueAt(null, 0, 5);
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
                } catch (NullPointerException | NumberFormatException ex) {
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
