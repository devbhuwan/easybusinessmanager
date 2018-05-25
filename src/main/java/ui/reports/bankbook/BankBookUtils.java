/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.bankbook;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.main.MainFrame;
import ui.reports.cashbook.JournalCashThread;
import ui.reports.cashbook.PaymentCashThread;
import ui.reports.cashbook.ReceiptCashThread;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class BankBookUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private SaleRegisterBankThread srt;
    private boolean isFinsihed;
    private SaleReturnBankThread srt1;
    private PurchaseRegisterBankThread prt;
    private PurchaseReturnBankThread prt1;
    private PaymentCashThread pay;
    private ReceiptCashThread rec;
    private DepositAndWithdrawBankThread depWith;
    private JournalCashThread jou;

    public BankBookUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;

    }

    public void run() {
        srt = new SaleRegisterBankThread(mainFrame, reportTable, selectedAccNo, companyCode);
        srt1 = new SaleReturnBankThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt = new PurchaseRegisterBankThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt1 = new PurchaseReturnBankThread(mainFrame, reportTable, selectedAccNo, companyCode);
        pay = new PaymentCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        rec = new ReceiptCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        jou = new JournalCashThread(mainFrame, reportTable, selectedAccNo, companyCode);
        depWith = new DepositAndWithdrawBankThread(mainFrame, reportTable, selectedAccNo, companyCode);
        srt.run(cal, cal1);
        srt1.run(cal, cal1);
        prt.run(cal, cal1);
        prt1.run(cal, cal1);
        pay.run(cal, cal1);
        rec.run(cal, cal1);
        jou.run(cal, cal1);
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
