/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.accountstatement;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AccountStatementUtils {

    private final MainFrame mainFrame;
    private final Calendar cal;
    private final Calendar cal1;
    private final JTable reportTable;
    private final ArrayList<String> selectedAccNo;
    private final String companyCode;
    private SaleRegisterThread srt;
    private PurchaseRegisterThread prt;
    private SaleReturnThread srt1;
    private PurchaseReturnThread prt1;
    private PaymentThread payment;
    private ReceiptThread receipt;
    private JournalThread journal;
    private DepositAndWithdrawThread depositAndWithdraw;
    private boolean isFinsihed;

    public AccountStatementUtils(MainFrame mainFrame, Calendar cal, Calendar cal1, JTable reportTable, ArrayList<String> selectedAccNo, String companyCode) {
        this.mainFrame = mainFrame;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTable = reportTable;
        this.selectedAccNo = selectedAccNo;
        this.companyCode = companyCode;
    }

    public void run() {
        srt = new SaleRegisterThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt = new PurchaseRegisterThread(mainFrame, reportTable, selectedAccNo, companyCode);
        srt1 = new SaleReturnThread(mainFrame, reportTable, selectedAccNo, companyCode);
        prt1 = new PurchaseReturnThread(mainFrame, reportTable, selectedAccNo, companyCode);
        payment = new PaymentThread(mainFrame, reportTable, selectedAccNo, companyCode);
        receipt = new ReceiptThread(mainFrame, reportTable, selectedAccNo, companyCode);
        journal = new JournalThread(mainFrame, reportTable, selectedAccNo, companyCode);
        depositAndWithdraw = new DepositAndWithdrawThread(mainFrame, reportTable,selectedAccNo,companyCode);
        srt.run(cal,cal1);
        prt.run(cal,cal1);
        srt1.run(cal,cal1);
        prt1.run(cal,cal1);
        payment.run(cal,cal1);
        receipt.run(cal,cal1);
        journal.run(cal,cal1);
        depositAndWithdraw.run(cal,cal1);
        isFinsihed = true;
    }

    public boolean getIsFinished() {
        return isFinsihed;
    }
}
