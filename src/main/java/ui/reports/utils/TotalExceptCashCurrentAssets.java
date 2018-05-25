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
public class TotalExceptCashCurrentAssets {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private JournalOnlyDebitAmount totJournalOnlyDebitAmount;
    private JournalOnlyCreditAmount totJournalOnlyCreditAmount;
    private final int row;
    private final int col;
    private TotalIncreaseAndDecreaseStock totIncreaseAndDecStock;
    private IncreaseAndDecreaseAccReceivableAmount totIncreaseDecreaseAccRe;

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
    public TotalExceptCashCurrentAssets(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1, int row, int col) {
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
        forGroups.add("Security & Deposits(Assets)");
        forGroups.add("Loans & Advances");
        forGroups.add("Sundry Debtors");
        forGroups.add("Investments");
        totJournalOnlyDebitAmount = new JournalOnlyDebitAmount(mainFrame, companyCode, cal, cal1, forGroups);
        increase = increase + totJournalOnlyDebitAmount.run();
        totJournalOnlyCreditAmount = new JournalOnlyCreditAmount(mainFrame, companyCode, cal, cal1, forGroups);
        decrease = decrease + totJournalOnlyCreditAmount.run();
        totIncreaseAndDecStock = new TotalIncreaseAndDecreaseStock(mainFrame, companyCode, cal, cal1);
        totIncreaseAndDecStock.run();
        increase = increase + totIncreaseAndDecStock.getIncrease();
        decrease = decrease + totIncreaseAndDecStock.getDecrease();
        totIncreaseDecreaseAccRe = new IncreaseAndDecreaseAccReceivableAmount(mainFrame, companyCode, cal, cal1);
        totIncreaseDecreaseAccRe.run();
        increase = increase + totIncreaseDecreaseAccRe.getAmountIncreseReceivable();
        decrease = decrease + totIncreaseDecreaseAccRe.getAmountDecreaseReceivable();

        if (totJournalOnlyCreditAmount.isFinished() && totJournalOnlyDebitAmount.isFinished() && totIncreaseAndDecStock.isFinished()) {
            firstReportTable.setValueAt(decrease, row, col);
            firstReportTable.setValueAt(increase, row + 1, col + 1);
        }
    }
}
