/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.production;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;

/**
 *
 * @author Vimal
 */
public class ProductionReportUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> itemCode;
    private final String companyCode;
    private boolean isFinsihed;
    private ProductionVoucherProReThread pro;

    /**
     *
     * @param mainFrame
     * @param cal
     * @param cal1
     * @param firstReportTable
     * @param itemCode
     * @param companyCode
     */
    public ProductionReportUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable firstReportTable, ArrayList<String> itemCode, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = firstReportTable;
        this.itemCode = itemCode;
        this.companyCode = companyCode;

    }

    public void run() {
        pro = new ProductionVoucherProReThread(mainFrame, reportTable, itemCode, companyCode, cal, cal1);
        pro.run();
        isFinsihed = true;
        addRow();
        addRow();
    }

    public boolean getIsFinished() {
        return isFinsihed;
    }

    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        Object[] data = {null, null, null, null, null, null,null};
        model.addRow(data);
        reportTable.setModel(model);
    }
}
