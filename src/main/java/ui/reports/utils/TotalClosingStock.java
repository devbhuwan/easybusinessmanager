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
public class TotalClosingStock {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private ClosingStockAmount closingAmount;
    private final int row;
    private final int col;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param firstReportTable
     * @param cal
     * @param cal1
     */
    public TotalClosingStock(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1,int row, int col) {
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
        double closeAmount = 0;
        System.out.println("### Closing Stock ###");
        closingAmount = new ClosingStockAmount(mainFrame, companyCode, cal, cal1);
        closeAmount = closeAmount + closingAmount.run();
        if (closingAmount.isFinished()) {
            firstReportTable.setValueAt(closeAmount, row, col);
        }

    }
}
