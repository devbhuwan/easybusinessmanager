/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.print;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ui.main.MainFrame;

/**
 *
 * @author Vimal
 */
public class PrintUtils {

    public ArrayList<String> getCompanyName(String companyCode, MainFrame mainFrame) {
        ArrayList<String> companyDetail = new ArrayList<>();
        String sql = "SELECT * from COMPANY_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                companyDetail.add(rs.getString("companyName"));
                companyDetail.add("PAN#");
                companyDetail.add("ADD. " + rs.getString("companyAddress") + "      TEL. " + rs.getString("companyPhNo"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return companyDetail;
    }
    
    public ArrayList<String> getAccountDetail(String companyCode, MainFrame mainFrame, String accountNumber) {
        ArrayList<String> companyDetail = new ArrayList<>();
        String sql = "SELECT * from ACCOUNT_DETAIL where companyCode = ? AND accountNumber = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, accountNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                companyDetail.add(accountNumber + " " + rs.getString("accountName"));
                companyDetail.add("ADD. " + rs.getString("address") + "   TEL. " + rs.getString("phNo"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return companyDetail;
    }

}
