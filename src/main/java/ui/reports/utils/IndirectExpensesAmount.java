/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.util.ArrayList;
import java.util.Calendar;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class IndirectExpensesAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private JournalOnlyAmount totJournalOnlyAmount;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param cal
     * @param cal1

     */
    public IndirectExpensesAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
    }

    public double runIn() {
        return doInBackground();
    }

    private double doInBackground() {
        double expenses = 0;
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Expenses(Indirect)");
        forGroups.add("Depreciation");
        totJournalOnlyAmount = new JournalOnlyAmount(mainFrame, companyCode, cal, cal1, forGroups);
        expenses = expenses + totJournalOnlyAmount.run();
        return expenses;
    }
}
