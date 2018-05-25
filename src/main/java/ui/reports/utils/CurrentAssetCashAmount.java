/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import ui.main.MainFrame;
import ui.reports.ReportUtils;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class CurrentAssetCashAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private ArrayList<String> cashAccountsGroup;
    private boolean isFinished = false;

    public CurrentAssetCashAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
        reportUtils = new ReportUtils();
    }

    public double run() {
        return doInBackground();
    }

    private double doInBackground() {
        double cashAmountPlusSide = 0;
        double cashAmountMinusSide = 0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        cashAccountsGroup = new ArrayList<>();
        cashAccountsGroup = reportUtils.getAccountGroups(mainFrame, companyCode, "Cash in hand");
        //adding
        cashAmountPlusSide = cashAmountPlusSide + getFromSaleRegister();
        cashAmountPlusSide = cashAmountPlusSide + getFromPurchaseReturn();
        cashAmountPlusSide = cashAmountPlusSide + getFromReceiptVoucher();
        cashAmountPlusSide = cashAmountPlusSide + getFromJournalVoucherDebit();
        cashAmountPlusSide = cashAmountPlusSide + getFromWithDraw();
        System.out.println("###Cash###");
        System.out.println("Plus : "+cashAmountPlusSide);
        cashAmountMinusSide = cashAmountMinusSide + getFromSaleReturn();
        cashAmountMinusSide = cashAmountMinusSide + getFromPurchaseRegister();
        cashAmountMinusSide = cashAmountMinusSide + getFromPaymentVoucher();
        cashAmountMinusSide = cashAmountMinusSide + getFromJournalVoucherCredit();
        cashAmountMinusSide = cashAmountMinusSide + getFromDeposit();
        System.out.println("Minus : "+cashAmountMinusSide);
        isFinished = true;
        return Math.abs(cashAmountPlusSide - cashAmountMinusSide);
    }

    private double getFromSaleRegister() {
        String sqlR = "SELECT voucherNumber FROM SALE_REGISTER_DETAIL where companyCode = ? AND isCash = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM SALE_REGISTER_CASH_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromSaleReturn() {
        String sqlR = "SELECT voucherNumber FROM SALE_RETURN_DETAIL where companyCode = ? AND isCash = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM SALE_RETURN_CASH_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseRegister() {
        String sqlR = "SELECT voucherNumber FROM PURCHASE_REGISTER_DETAIL where companyCode = ? AND isCash = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM PURCHASE_REGISTER_CASH_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseReturn() {
        String sqlR = "SELECT voucherNumber FROM PURCHASE_RETURN_DETAIL where companyCode = ? AND isCash = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM PURCHASE_RETURN_CASH_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double performOperationOnRegOrRet(String sqlR, String sqlB) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlR);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Connection con = mainFrame.getConnection2();
                con.setAutoCommit(false);
                PreparedStatement p = conn.prepareStatement(sqlB);
                p.setString(1, rs.getString("voucherNumber"));
                ResultSet r = p.executeQuery();
                if (r.next()) {
                    try {
                        amount = amount + Double.valueOf(r.getString("amount"));
                    } catch (NullPointerException | NumberFormatException ex) {
                    }
                }
                con.commit();
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double getFromPaymentVoucher() {
        String sqlV = "SELECT voucherNumber FROM PAYMENT_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlS = "SELECT creditAccountNumber,creditAmount FROM PAYMENT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where voucherNumber = ?";
        return performOperationOnVoucherCreditMode(sqlV, sqlS);
    }

    private double getFromReceiptVoucher() {
        String sqlV = "SELECT voucherNumber FROM RECEIPT_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlS = "SELECT debitAccountNumber,debitAmount FROM RECEIPT_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where voucherNumber = ?";
        return performOperationOnVoucherDebitMode(sqlV, sqlS);
    }

    private double getFromJournalVoucherDebit() {
        String sqlV = "SELECT voucherNumber FROM JOURNAL_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlSD = "SELECT debitAccountNumber,debitAmount FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where voucherNumber = ?";
        return performOperationOnVoucherDebitMode(sqlV, sqlSD);
    }

    private double getFromJournalVoucherCredit() {
        String sqlV = "SELECT voucherNumber FROM JOURNAL_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlSC = "SELECT creditAccountNumber,creditAmount FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where voucherNumber = ?";
        return performOperationOnVoucherCreditMode(sqlV, sqlSC);
    }

    private double getFromDeposit() {
        String sqlDW = "SELECT voucherNumber FROM DEPOSIT_OR_WITHDRAW_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlD = "SELECT depositedAmount FROM DEPOSIT_DETAIL where voucherNumber = ?";
        return performOperationONDeposit(sqlDW, sqlD);
    }

    private double getFromWithDraw() {
        String sqlDW = "SELECT voucherNumber FROM DEPOSIT_OR_WITHDRAW_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlD = "SELECT withdrawAmount FROM WITHDRAW_DETAIL where voucherNumber = ?";
        return performOperationONWithDraw(sqlDW, sqlD);
    }

    private double performOperationOnVoucherCreditMode(String sqlV, String sqlS) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlV);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Connection con = mainFrame.getConnection2();
                con.setAutoCommit(false);
                PreparedStatement p = conn.prepareStatement(sqlS);
                p.setString(1, rs.getString("voucherNumber"));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    String accountNumber = r.getString("creditAccountNumber");
                    String groupName = reportUtils.getGroupName(mainFrame, accountNumber, companyCode);
                    if (cashAccountsGroup.contains(groupName)) {
                        try {
                            amount = amount + Double.valueOf(r.getString("creditAmount"));
                        } catch (NullPointerException | NumberFormatException ex) {
                        }
                    }
                }
                con.commit();
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double performOperationOnVoucherDebitMode(String sqlV, String sqlS) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlV);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Connection con = mainFrame.getConnection2();
                con.setAutoCommit(false);
                PreparedStatement p = conn.prepareStatement(sqlS);
                p.setString(1, rs.getString("voucherNumber"));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    String accountNumber = r.getString("debitAccountNumber");
                    String groupName = reportUtils.getGroupName(mainFrame, accountNumber, companyCode);
                    if (cashAccountsGroup.contains(groupName)) {
                        try {
                            amount = amount + Double.valueOf(r.getString("debitAmount"));
                        } catch (NullPointerException | NumberFormatException ex) {
                        }
                    }
                }
                con.commit();
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double performOperationONDeposit(String sqlDW, String sqlD) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlDW);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Connection con = mainFrame.getConnection2();
                con.setAutoCommit(false);
                PreparedStatement p = conn.prepareStatement(sqlD);
                p.setString(1, rs.getString("voucherNumber"));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    try {
                        amount = amount + Double.valueOf(r.getString("depositedAmount"));
                    } catch (NullPointerException | NumberFormatException ex) {
                    }
                }
                con.commit();
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double performOperationONWithDraw(String sqlDW, String sqlD) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlDW);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Connection con = mainFrame.getConnection2();
                con.setAutoCommit(false);
                PreparedStatement p = conn.prepareStatement(sqlD);
                p.setString(1, rs.getString("voucherNumber"));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    try {
                        amount = amount + Double.valueOf(r.getString("withdrawAmount"));
                    } catch (NullPointerException | NumberFormatException ex) {
                    }
                }
                con.commit();
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
