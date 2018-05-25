/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.cashbook;

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
public class CashBookUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private SaleRegisterCashThread srt;
    private boolean isFinsihed;
    private SaleReturnCashThread srt1;
    private PurchaseRegisterCashThread prt;
    private PurchaseReturnCashThread prt1;
    private PaymentCashThread pay;
    private ReceiptCashThread rec;
    private DepositAndWithdrawCashThread depWith;
    private JournalCashThread jou;

    public CashBookUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run() {
        srt = new SaleRegisterCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        srt1 = new SaleReturnCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt = new PurchaseRegisterCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt1 = new PurchaseReturnCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        pay = new PaymentCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        rec = new ReceiptCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        jou = new JournalCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        depWith = new DepositAndWithdrawCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        srt.run(cal,cal1);
        srt1.run(cal,cal1);
        prt.run(cal,cal1);
        prt1.run(cal,cal1);
        pay.run(cal,cal1);
        rec.run(cal,cal1);
        jou.run(cal,cal1);
        depWith.run(cal,cal1);
        isFinsihed = true;
        addRow();
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
