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
public class TotalInDeCurrentLiabilities {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private JournalOnlyDebitAmount totJournalOnlyDebitAmount;
    private JournalOnlyCreditAmount totJournalOnlyCreditAmount;
    private final int row;
    private final int col;
    private IncreseAndDecreaseAccPayableAmount totIncreaseDecreaseAccRe;

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
    public TotalInDeCurrentLiabilities(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1, int row, int col) {
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
        double increase = 0;
        double decrease = 0;
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Sundry Creditors");
        forGroups.add("Outstanding Expenses");
        forGroups.add("Advance Income");
        forGroups.add("Provisions/Expenses Payable");
        forGroups.add("Loan");
        forGroups.add("Bank O/D Account");
        totJournalOnlyDebitAmount = new JournalOnlyDebitAmount(mainFrame, companyCode, cal, cal1, forGroups);
        decrease = decrease + totJournalOnlyDebitAmount.run();
        totJournalOnlyCreditAmount = new JournalOnlyCreditAmount(mainFrame, companyCode, cal, cal1, forGroups);
        increase = increase + totJournalOnlyCreditAmount.run();
        totIncreaseDecreaseAccRe = new IncreseAndDecreaseAccPayableAmount(mainFrame, companyCode, cal, cal1);
        totIncreaseDecreaseAccRe.run();
        increase = increase + totIncreaseDecreaseAccRe.getAmountIncresePayable();
        decrease = decrease + totIncreaseDecreaseAccRe.getAmountIncresePayable();
        if (totJournalOnlyCreditAmount.isFinished() && totJournalOnlyDebitAmount.isFinished() && totIncreaseDecreaseAccRe.isFinished()) {
            firstReportTable.setValueAt(decrease, row, col);
            firstReportTable.setValueAt(increase, row + 1, col + 1);
        }
    }
}
