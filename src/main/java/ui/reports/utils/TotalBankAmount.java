/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TotalBankAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private BankAmount totBankAmount;
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
    public TotalBankAmount(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1, int row, int col) {
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
        double currentAssets = 0;
        totBankAmount = new BankAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totBankAmount.run();
        if (totBankAmount.isFinished()) {
            firstReportTable.setValueAt(currentAssets, row, col);
        }

    }
}
