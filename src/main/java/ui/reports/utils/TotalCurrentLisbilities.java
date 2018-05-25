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
public class TotalCurrentLisbilities {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private AccPayableAmount totAccPayable;
    private JournalOnlyAmount totJournalOnlyAmount;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param firstReportTable
     * @param cal
     * @param cal1
     */
    public TotalCurrentLisbilities(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1) {
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
        double currentLiabilities = 0;
        System.out.println("### Current Liabilites ###");
        //Accounts Payable
        totAccPayable = new AccPayableAmount(mainFrame, companyCode, cal, cal1);
        currentLiabilities = currentLiabilities + totAccPayable.run();
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Sundry Creditors");
        forGroups.add("Provisions/Expenses Payable");
        forGroups.add("Advance Income");
        forGroups.add("Outstanding Expenses");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        currentLiabilities = currentLiabilities + totJournalOnlyAmount.run();
        if (totAccPayable.isFinished() && totJournalOnlyAmount.isFinished()) {
            firstReportTable.setValueAt(currentLiabilities, 2, 5);
        }

    }
}
