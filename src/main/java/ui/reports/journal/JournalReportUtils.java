/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.journal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class JournalReportUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private JournalThread journal;
    private boolean isFinsihed;

    public JournalReportUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run() {
        journal = new JournalThread(mainFrame, reportTable, selectedAccNo, companyCode);
        journal.run(cal,cal1);
        isFinsihed = true;
    }
    
    public boolean getIsFinished() {
        return isFinsihed;
    }
}
