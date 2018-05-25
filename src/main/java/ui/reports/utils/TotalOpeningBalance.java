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
public class TotalOpeningBalance {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private BankAmount totBankAmount;
    private CurrentAssetCashAmount totCashAmount;
    private AccReceivableAmount totAccReceivable;
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
    public TotalOpeningBalance(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1, int row, int col) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.firstReportTable = firstReportTable;
        this.cal = cal;
        this.cal1 = cal1;
        this.row = row;
        this.col = col;
    }

    /**
     *
     * @param s
     */
    public void runIn(String s) {
        doInBackground(s);
    }

    private void doInBackground(String s) {
        double currentAssets = 0;
        totCashAmount = new CurrentAssetCashAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totCashAmount.run();
        totBankAmount = new BankAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totBankAmount.run();
        if (totCashAmount.isFinished()) {
            if (s.equalsIgnoreCase("start")) {
                firstReportTable.setValueAt("Total Opening Balance", row, col - 1);
                firstReportTable.setValueAt(currentAssets, row, col);
            } else if(s.equalsIgnoreCase("final")){
                firstReportTable.setValueAt("Total Closing Balance", row, col - 2);
                firstReportTable.setValueAt(currentAssets, row, col);
            }

        }

    }
}
