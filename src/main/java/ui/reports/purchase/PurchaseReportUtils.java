/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.purchase;

import ui.reports.bankbook.*;
import ui.reports.cashbook.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class PurchaseReportUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private boolean isFinsihed;
    private PurchaseRegisterPurRepotThread prt;

    public PurchaseReportUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run() {
        prt = new PurchaseRegisterPurRepotThread(mainFrame, reportTable, selectedAccNo, companyCode,cal,cal1);
        prt.run();
        isFinsihed = true;
        addRow();
        addRow();
    }

    public boolean getIsFinished() {
        return isFinsihed;
    }

    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        Object[] data = {null, null, null, null, null, null};
        model.addRow(data);
        reportTable.setModel(model);
    }
}
