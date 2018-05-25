/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.util.Calendar;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TotalPurchase {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private PurchaseAmount totPurchase;
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
    public TotalPurchase(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1,int row, int col) {
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
        double purchase = 0;
        totPurchase = new PurchaseAmount(mainFrame, companyCode, cal, cal1);
        purchase = purchase + totPurchase.run();
        if (totPurchase.isFinished()) {
            firstReportTable.setValueAt(purchase, row, col);
        }
    }
}
