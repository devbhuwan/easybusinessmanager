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
public class FixedAssetsAccDetail {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable secondReportTable;
    private final Calendar cal;
    private final Calendar cal1;
    private TotalJournalOnlyAccountDetail totAccountDetail;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param secondReportTable
     * @param cal
     * @param cal1
     */
    public FixedAssetsAccDetail(MainFrame mainFrame, String companyCode, JTable secondReportTable, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.secondReportTable = secondReportTable;
        this.cal = cal;
        this.cal1 = cal1;
    }

    public void runIn() {
        doInBackground();
    }

    private void doInBackground() {
        ArrayList<String> forGroups = new ArrayList<>();
        forGroups.add("Fixed Assets");
        totAccountDetail = new TotalJournalOnlyAccountDetail(mainFrame, companyCode, cal, cal1, forGroups);
        totAccountDetail.runIn();
        ArrayList<String> accNos = totAccountDetail.getAccountNumbers();
        ArrayList<Double> accAmounts = totAccountDetail.getAccountAmount();
        ArrayList<String> accGroups = totAccountDetail.getGroupNames();
    }
}
