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
public class JournalOnlyCreditAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private ArrayList<String> accountGroups;
    private boolean isFinished = false;
    private final ArrayList<String> forGroup;

    public JournalOnlyCreditAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1, ArrayList<String> forGroup) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
        reportUtils = new ReportUtils();
        this.forGroup = forGroup;
    }

    public double run() {
        return doInBackground();
    }

    private double doInBackground() {
        double amountMinusSide = 0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        accountGroups = new ArrayList<>();
        accountGroups = reportUtils.getAccountGroups(mainFrame, companyCode, forGroup);
        amountMinusSide = amountMinusSide + getFromJournalVoucherCredit();
        System.out.println("Total Pr Of Fixed Assets : " + amountMinusSide);
        isFinished = true;
        return Math.abs(amountMinusSide);
    }


    private double getFromJournalVoucherCredit() {
        String sqlV = "SELECT voucherNumber FROM JOURNAL_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlSC = "SELECT creditAccountNumber,creditAmount FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where voucherNumber = ?";
        return performOperationOnVoucherCreditMode(sqlV, sqlSC);
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
                    if (accountGroups.contains(groupName)) {
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

    public boolean isFinished() {
        return isFinished;
    }

}
