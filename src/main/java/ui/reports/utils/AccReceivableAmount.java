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
import java.util.Calendar;
import java.util.Date;
import ui.main.MainFrame;
import ui.reports.ReportUtils;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AccReceivableAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private boolean isFinished = false;

    public AccReceivableAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
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
        double amountReceivable = 0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        //adding
        amountReceivable = amountReceivable + getFromSaleRegister();
        amountReceivable = amountReceivable + getFromPurchaseReturn();
        amountReceivable = amountReceivable + getFromSaleReturn();
        amountReceivable = amountReceivable + getFromPurchaseRegister();
        amountReceivable = amountReceivable - getFromReceiptVoucher();
        System.out.println("Account Receivable : " + amountReceivable);
        isFinished = true;
        return Math.abs(amountReceivable);
    }

    private double getFromSaleRegister() {
        String sqlR = "SELECT totalAmount,isBank,isCash,debitAmount FROM SALE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "saleReg";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromSaleReturn() {
        String sqlR = "SELECT creditAmount FROM SALE_RETURN_DETAIL where companyCode = ? AND creditAmount IS NOT NULL AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "saleRet";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseRegister() {
        String sqlR = "SELECT debitAmount FROM PURCHASE_REGISTER_DETAIL where companyCode = ? AND debitAmount IS NOT NULL AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "purReg";
        return performOperationOnRegOrRet(sqlR, sqlB);
    }

    private double getFromPurchaseReturn() {
        String sqlR = "SELECT totalAmount,isBank,isCash,creditAmount FROM PURCHASE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlB = "purRet";
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
                double rAmount = 0;
                switch (sqlB) {
                    case "saleReg":
                        String totAmt = rs.getString("totalAmount");
                        if (rs.getString("isCash").equalsIgnoreCase("Y") || rs.getString("isBank").equalsIgnoreCase("Y")) {
                            try {
                                rAmount = Double.valueOf(rs.getString("debitAmount"));
                            } catch (NullPointerException | NumberFormatException ex) {
                            }
                        } else {
                            try {
                                rAmount = Double.valueOf(totAmt);
                            } catch (NullPointerException | NumberFormatException ex) {
                            }
                        }
                        break;
                    case "saleRet":
                        try {
                            rAmount = Double.valueOf(rs.getString("creditAmount"));
                        } catch (NullPointerException | NumberFormatException ex) {
                        }
                        break;
                    case "purReg":
                        try {
                            rAmount = Double.valueOf(rs.getString("debitAmount"));
                        } catch (NullPointerException | NumberFormatException ex) {
                        }
                        break;
                    case "purRet":
                        String toAmt = rs.getString("totalAmount");
                        if (rs.getString("isCash").equalsIgnoreCase("Y") || rs.getString("isBank").equalsIgnoreCase("Y")) {
                            
                            try {
                                rAmount = Double.valueOf(rs.getString("creditAmount"));
                            } catch (NullPointerException | NumberFormatException ex) {
                            }
                        } else {
                            try {
                                rAmount = Double.valueOf(toAmt);
                            } catch (NullPointerException | NumberFormatException ex) {
                            }
                        }
                        break;
                }
                amount = amount + rAmount;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }

    private double getFromReceiptVoucher() {
        String sqlV = "SELECT voucherNumber FROM RECEIPT_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        String sqlS = "SELECT creditAmount FROM RECEIPT_VOUCHER_ACCOUNTS_DETAIL_FOR_CREDIT where voucherNumber = ?";
        return performOperationOnVoucherCreditMode(sqlV, sqlS);
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
                    try {
                        amount = amount + Double.valueOf(r.getString("creditAmount"));
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
