package ui.master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class FetchMasterData {

    private PreparedStatement ps;
    private ResultSet rs;

    public void accountGroup(JComboBox cb, Connection conn, String companyCode) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select groupName from ACCOUNT_GROUP_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupName");
                if (!groupName.equalsIgnoreCase("Sale") && !groupName.equalsIgnoreCase("Purchase")) {
                    cb.addItem(groupName);
                }

            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        cb.setSelectedItem(currentSelectedItem);
    }

    public void fetchItemGoup(JComboBox cb, String companyCode, Connection conn) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select groupName from ITEM_GROUP_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("groupName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(currentSelectedItem);
    }

    public void setStoreName(JComboBox cb, String companyCode, Connection conn) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select storeName from STORE_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("storeName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(currentSelectedItem);
    }

    public void setStoreGroup(JComboBox cb, String companyCode, Connection conn) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select groupName from STORE_GROUP_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("groupName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(currentSelectedItem);
    }

    public void fetchUnitName(JComboBox cb, String companyCode, Connection conn) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select unitName from UNIT_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("unitName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(currentSelectedItem);
    }

    public void primaryUnit(JComboBox cb, Connection conn, String companyCode) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select unitName from UNIT_DETAIL where companyCode = ? and unitType = 'Single'";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("unitName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(currentSelectedItem);
    }

    public String getCompanyName(String companyCode, Connection conn) {
        String companyName = null;
        String sql = "select companyName from COMPANY_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                companyName = rs.getString("companyName");
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return companyName;
    }

    public void accountUnderGroup(JComboBox cb, Connection conn, String companyCode) {
        Object currentSelectedItem = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select * from ACCOUNT_GROUP_DETAIL where companyCode = ?";
        try {
            
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupName");
                String underGroup = rs.getString("underGroup");
                if (!groupName.equalsIgnoreCase("Sale") && !groupName.equalsIgnoreCase("Purchase")) {
                    try {
                        if (underGroup.length() != 0) {
                            cb.addItem(groupName);
                        }
                    } catch (NullPointerException ex) {
                    }

                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        cb.setSelectedItem(currentSelectedItem);
    }
}
