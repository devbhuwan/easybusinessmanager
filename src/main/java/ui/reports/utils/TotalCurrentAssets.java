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
public class TotalCurrentAssets {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private BankAmount totBankAmount;
    private CurrentAssetCashAmount totCashAmount;
    private AccReceivableAmount totAccReceivable;
    private JournalOnlyAmount totJournalOnlyAmount;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param firstReportTable
     * @param cal
     * @param cal1
     */
    public TotalCurrentAssets(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1) {
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
        double currentAssets = 0;
        System.out.println("### Current Assests ###");
        //Bank Amount
        totBankAmount = new BankAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totBankAmount.run();
        //Cash Amount
        totCashAmount = new CurrentAssetCashAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totCashAmount.run();
        //Accounts Recievable
        totAccReceivable = new AccReceivableAmount(mainFrame, companyCode, cal, cal1);
        currentAssets = currentAssets + totAccReceivable.run();
        // --> Sundry Debtors
        // --> Loans and Advances
        //Securities and Deposits
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Sundry Debtors");
        forGroups.add("Loans & Advances");
        forGroups.add("Security & Deposits(Assets)");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        currentAssets = currentAssets + totJournalOnlyAmount.run();
        if (totBankAmount.isFinished() && totCashAmount.isFinished() && totAccReceivable.isFinished() && totJournalOnlyAmount.isFinished()) {
            firstReportTable.setValueAt(currentAssets, 2, 2);
        }

    }
}
