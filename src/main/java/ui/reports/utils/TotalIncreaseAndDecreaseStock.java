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

/**
 *
 * @author Vimal
 */
public class TotalIncreaseAndDecreaseStock {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Calendar cal;
    private final Calendar cal1;
    private double decrease;
    private double increase;
    private boolean isFinished;
    private String toDate;
    private String fromDate;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param cal
     * @param cal1
     */
    public TotalIncreaseAndDecreaseStock(MainFrame mainFrame, String companyCode, Calendar cal, Calendar cal1) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.cal = cal;
        this.cal1 = cal1;
    }

    public void run() {
        doInBackground();

    }

    public double getIncrease() {
        return increase;
    }

    public double getDecrease() {
        return decrease;
    }

    boolean isFinished() {
        return isFinished;
    }

    private void doInBackground() {
        this.decrease = 0.0;
        this.increase = 0.0;
        SimpleDateFormat format = new SimpleDateFormat("#yyyy-MM-dd#");
        fromDate = format.format(new Date(String.valueOf(cal.get(Calendar.YEAR)) + "/" + String.valueOf(cal.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal.get(Calendar.DAY_OF_MONTH) - 1)));
        toDate = format.format(new Date(String.valueOf(cal1.get(Calendar.YEAR)) + "/" + String.valueOf(cal1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(cal1.get(Calendar.DAY_OF_MONTH) + 1)));
        increase = increase + getFromOpeningStock();
        increase = increase + getFromPurchaseRegister();
        increase = increase + getFromSaleReturn();
        decrease = decrease + getFromPurchaseReturn();
        decrease = decrease + getFromSaleRegister();
        perfromFromProduction();
        System.out.println("#Increase Stock#" + increase);
        System.out.println("#Decrease Stock#" + decrease);
        this.isFinished = true;
    }

    private double getFromSaleRegister() {
        String sqlR = "SELECT totalAmount FROM SALE_REGISTER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND totalAmount IS NOT NULL";
        return performOperationOnRegOrRet(sqlR);
    }

    private double getFromSaleReturn() {
        String sqlR = "SELECT totalAmount FROM SALE_RETURN_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ") AND totalAmount IS NOT NULL";
        return performOperationOnRegOrRet(sqlR);
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

    private double getFromOpeningStock() {
        String sql = "SELECT purchasePrice,selfDevCost FROM ITEM_DETAIL where companyCode = ? AND selfDevCost IS NOT NULL";
        double openingStock = 0;
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String pur = rs.getString("purchasePrice");
                String qty = rs.getString("selfDevCost");
                try {
                    openingStock = openingStock + Double.valueOf(pur) * Double.valueOf(qty);
                } catch (NullPointerException | NumberFormatException ex) {
                    openingStock = openingStock + 0;
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return openingStock;
    }

    private void perfromFromProduction() {
        String sql = "SELECT generatedAmount,consumedAmount FROM PRODUCTION_VOUCHER_DETAIL where companyCode = ? AND (dateForVoucher BETWEEN " + fromDate + " AND " + toDate + ")";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String gen = rs.getString("generatedAmount");
                String con = rs.getString("consumedAmount");
                try {
                    increase = increase + Double.valueOf(gen);
                } catch (NullPointerException | NumberFormatException ex) {

                }
                try {
                    decrease = decrease + Double.valueOf(con);
                } catch (NullPointerException | NumberFormatException ex) {

                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
