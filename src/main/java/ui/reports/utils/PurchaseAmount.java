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
public class PurchaseAmount {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private String fromDate;
    private String toDate;
    private final ReportUtils reportUtils;
    private boolean isFinished = false;

    public PurchaseAmount(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
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
        double purchaseAmountPlusSide = 0;
        double purchaseAmountMinusSide = 0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        purchaseAmountPlusSide = purchaseAmountPlusSide + getFromPurchaseRegister();
        System.out.println("Plus : " + purchaseAmountPlusSide);
        purchaseAmountMinusSide = purchaseAmountMinusSide + getFromPurchaseReturn();
        System.out.println("Minus : " + purchaseAmountMinusSide);
        isFinished = true;
        return Math.abs(purchaseAmountPlusSide - purchaseAmountMinusSide);
    }

    private double getFromPurchaseRegister() {
        String sqlR = "SELECT totalAmount FROM PURCHASE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND totalAmount IS NOT NULL";
        return performOperationOnRegOrRet(sqlR);
    }

    private double getFromPurchaseReturn() {
        String sqlR = "SELECT totalAmount FROM PURCHASE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND totalAmount IS NOT NULL";
        return performOperationOnRegOrRet(sqlR);
    }

    private double performOperationOnRegOrRet(String sqlR) {
        double amount = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlR);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                try {
                    amount = amount + Double.valueOf(rs.getString("totalAmount"));
                } catch (NullPointerException | NumberFormatException ex) {
                }
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
