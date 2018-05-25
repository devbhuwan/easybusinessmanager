/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.daybook;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.reports.ReportUtils;
import ui.reports.utils.TotalOpeningBalance;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class DayBookUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final JTable reportTable;
    private final String companyCode;
    private boolean isFinsihed;
    private SaleRegisterThread srt;
    private PurchaseRegisterThread prt;
    private SaleReturnThread srt1;
    private PurchaseReturnThread prt1;
    private PaymentThread py;
    private ReceiptThread re;
    private JournalThread jor;
    private DepositAndWithdrawThread dep;
    private ProductionThread prod;
    private TotalOpeningBalance ob;

    public DayBookUtils(MainFrame mainFrame, Calendar cal, JTable reportTable, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.reportTable = reportTable;
        this.companyCode = companyCode;
    }

    public void run() {
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        Date date = new ReportUtils().getCompanyBeginnigDate(mainFrame.getConnection(), companyCode);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        ob = new TotalOpeningBalance(mainFrame, companyCode, reportTable, c1, c, 0, 5);
        srt = new SaleRegisterThread(mainFrame, reportTable, companyCode);
        prt = new PurchaseRegisterThread(mainFrame, reportTable, companyCode);
        srt1 = new SaleReturnThread(mainFrame, reportTable, companyCode);
        prt1 = new PurchaseReturnThread(mainFrame, reportTable, companyCode);
        py = new PaymentThread(mainFrame, reportTable, companyCode);
        re = new ReceiptThread(mainFrame, reportTable, companyCode);
        jor = new JournalThread(mainFrame, reportTable, companyCode);
        dep = new DepositAndWithdrawThread(mainFrame, reportTable, companyCode);
        prod = new ProductionThread(mainFrame, reportTable, companyCode);
        addRow();
        ob.runIn("start");
        srt.run(cal);
        prt.run(cal);
        srt1.run(cal);
        prt1.run(cal);
        py.run(cal);
        re.run(cal);
        jor.run(cal);
        dep.run(cal);
        prod.run(cal, cal);
        ob = new TotalOpeningBalance(mainFrame, companyCode, reportTable, c1, cal, reportTable.getRowCount(), 6);
        addRow();
        ob.runIn("final");
        isFinsihed = true;
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
