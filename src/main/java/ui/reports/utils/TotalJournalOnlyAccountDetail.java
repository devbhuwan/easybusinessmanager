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
public class TotalJournalOnlyAccountDetail {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private final ArrayList<String> forGroups;
    private final ReportUtils reportUtils;
    private String fromDate;
    private String toDate;
    private ArrayList<String> accountGroups;
    private ArrayList<String> voucherGroups;
    private ArrayList<String> accountNumbers;
    private ArrayList<Double> accountAmount;
    private ArrayList<String> groupNames;
    private boolean isFinished = false;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param cal
     * @param cal1
     * @param forGroups
     */
    public TotalJournalOnlyAccountDetail(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1, ArrayList<String> forGroups) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
        this.forGroups = forGroups;
        reportUtils = new ReportUtils();
    }

    public void runIn() {
        doInBackground();
    }

    private void doInBackground() {
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        accountGroups = new ArrayList<>();
        accountGroups = reportUtils.getAccountGroups(mainFrame, companyCode, forGroups);
        setAccountDetail();
        isFinished = true;
    }

    private void setAccountDetail() {
        voucherGroups = new ArrayList<>();
        accountNumbers = new ArrayList<>();
        accountAmount = new ArrayList<>();
        groupNames = new ArrayList<>();
        String sql = "SELECT voucherNumber FROM JOURNAL_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                voucherGroups.add(rs.getString("voucherNumber"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        addDebitSide();
        addCreditSide();
        for (String accN : accountNumbers) {
            double plusAmount = getFromDebitSide();
            double minusAmount = getFromCreditSide();
            accountAmount.add(accountNumbers.indexOf(accN), Math.abs(plusAmount - minusAmount));
        }
    }

    private void addDebitSide() {
        if (voucherGroups.size() > 0) {
            String sqlDS = "Select distinct debitAccountNumber FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where ";
            int count = 0;
            for (String voucherGroup : voucherGroups) {
                count++;
                if (voucherGroups.size() != count) {
                    sqlDS = sqlDS + "voucherNumber = " + voucherGroup + " OR ";
                } else {
                    sqlDS = sqlDS + "voucherNumber = " + voucherGroup;
                }
            }
            try {
                Connection conn = mainFrame.getConnection();
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement(sqlDS);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String acc = rs.getString("debitAccountNumber");
                    String accG = reportUtils.getGroupName(mainFrame, acc, companyCode);
                    if (accountGroups.contains(accG)) {
                        if (!accountNumbers.contains(acc)) {
                            accountNumbers.add(acc);
                            accountAmount.add(0.0);
                            groupNames.add(accG);
                        }
                    }
                }
                conn.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addCreditSide() {
        if (voucherGroups.size() > 0) {
            String sqlDS = "Select distinct creditAccountNumber FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where ";
            int count = 0;
            for (String voucherGroup : voucherGroups) {
                count++;
                if (voucherGroups.size() != count) {
                    sqlDS = sqlDS + "voucherNumber = " + voucherGroup + " OR ";
                } else {
                    sqlDS = sqlDS + "voucherNumber = " + voucherGroup;
                }
            }
            try {
                Connection conn = mainFrame.getConnection();
                conn.setAutoCommit(false);
                PreparedStatement ps = conn.prepareStatement(sqlDS);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String acc = rs.getString("creditAccountNumber");
                    String accG = reportUtils.getGroupName(mainFrame, acc, companyCode);
                    if (accountGroups.contains(accG)) {
                        if (!accountNumbers.contains(acc)) {
                            accountNumbers.add(acc);
                            accountAmount.add(0.0);
                            groupNames.add(accG);
                        }
                    }
                }
                conn.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private double getFromDebitSide() {
        double amount = 0;
        String sqlDS = "Select debitAmount FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where debitAccountNumber = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlDS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    amount = amount + Double.valueOf(rs.getString("debitAmount"));
                } catch (NullPointerException | NumberFormatException ex) {
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double getFromCreditSide() {
        double amount = 0;
        String sqlDS = "Select creditAmount FROM JOURNAL_VOUCHER_ACCOUNTS_DETAIL_FOR_DEBIT where creditAccountNumber = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlDS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    amount = amount + Double.valueOf(rs.getString("creditAmount"));
                } catch (NullPointerException | NumberFormatException ex) {
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    public ArrayList<String> getAccountNumbers() {
        return accountNumbers;
    }

    public ArrayList<Double> getAccountAmount() {
        return accountAmount;
    }

    public ArrayList<String> getGroupNames() {
        return groupNames;
    }

    public boolean getIsFinished() {
        return isFinished;
    }
}
