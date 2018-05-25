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
public class BankAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private ArrayList<String> bankAccountsGroup;
    private boolean isFinished = false;

    public BankAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
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
        double bankAmountPlusSide = 0;
        double bankAmountMinusSide = 0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        bankAccountsGroup = new ArrayList<>();
        bankAccountsGroup = reportUtils.getAccountGroups(mainFrame, companyCode, "Bank Accounts");
        //adding
        bankAmountPlusSide = bankAmountPlusSide + getFromSaleRegister();
        bankAmountPlusSide = bankAmountPlusSide + getFromPurchaseReturn();
        bankAmountPlusSide = bankAmountPlusSide + getFromReceiptVoucher();
        bankAmountPlusSide = bankAmountPlusSide + getFromJournalVoucherDebit();
        bankAmountPlusSide = bankAmountPlusSide + getFromDeposit();
        System.out.println("###Bank###");
        System.out.println("Plus : " + bankAmountPlusSide);
        bankAmountMinusSide = bankAmountMinusSide + getFromSaleReturn();
        bankAmountMinusSide = bankAmountMinusSide + getFromPurchaseRegister();
        bankAmountMinusSide = bankAmountMinusSide + getFromPaymentVoucher();
        bankAmountMinusSide = bankAmountMinusSide + getFromJournalVoucherCredit();
        bankAmountMinusSide = bankAmountMinusSide + getFromWithDraw();
        System.out.println("Minus : " + bankAmountMinusSide);
        isFinished = true;
        return Math.abs(bankAmountPlusSide - bankAmountMinusSide);
    }

    private double getFromSaleRegister() {
        String sqlR = "SELECT voucherNumber FROM SALE_REGISTER_DETAIL where companyCode = ? AND isBank = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM SALE_REGISTER_BANK_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromSaleReturn() {
        String sqlR = "SELECT voucherNumber FROM SALE_RETURN_DETAIL where companyCode = ? AND isBank = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM SALE_RETURN_BANK_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseRegister() {
        String sqlR = "SELECT voucherNumber FROM PURCHASE_REGISTER_DETAIL where companyCode = ? AND isBank = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM PURCHASE_REGISTER_BANK_DETAIL where voucherNumber = ?";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseReturn() {
        String sqlR = "SELECT voucherNumber FROM PURCHASE_RETURN_DETAIL where companyCode = ? AND isBank = 'Y' AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "SELECT amount FROM PURCHASE_RETURN_BANK_DETAIL where voucherNumber = ?";
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
                    if (bankAccountsGroup.contains(groupName)) {
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
                    if (bankAccountsGroup.contains(groupName)) {
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
