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
public class TotalExpenses {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable firstReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private JournalOnlyAmount totJournalOnlyAmount;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param firstReportTable
     * @param cal
     * @param cal1
     */
    public TotalExpenses(MainFrame mainFrame, String companyCode, JTable firstReportTable, Calendar cal, Calendar cal1) {
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
        double expenses = 0;
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Expenses(Direct)");
        forGroups.add("Expenses(Indirect)");
        forGroups.add("Duties & Taxes");
        forGroups.add("Depreciation");
        forGroups.add("Provision for Doubtful Debts");
        forGroups.add("Provision for Doubtful Debts");
        forGroups.add("Interest on Capital");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        expenses = expenses + totJournalOnlyAmount.run();
        if (totJournalOnlyAmount.isFinished()) {
            firstReportTable.setValueAt(expenses, 5, 2);
        }
    }
}
