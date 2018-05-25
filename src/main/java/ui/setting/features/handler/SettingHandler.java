package ui.setting.features.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import ui.setting.features.AddUserDialog;
import ui.setting.features.ChangePasswordDialog;
import ui.setting.features.DeleteUserDialog;
import ui.setting.features.ModifyUserDialog;

/**
 *
 * @author Vimal
 */
public class SettingHandler {

    private PreparedStatement ps;
    private ResultSet rs;

    public boolean checkUserCodeIsValidOrNot(String text, AddUserDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "select userCode from USER_DETAIL where userCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, text);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (!rs.next()) {
                status = true;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveUserInfo(AddUserDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "insert into USER_DETAIL values (?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getUserName());
            ps.setString(2, aThis.getUserCode());
            ps.setString(3, aThis.getUserPassword());
            ps.setString(4, aThis.getDescription());
            ps.setString(5, aThis.getUserType());
            ps.setString(6, aThis.getUserRights());
            ps.setString(7, aThis.getUserPermittedFeatures());
            ps.setString(8, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void fetchUserCode(JComboBox cb, String companyCode, Connection conn) {
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select userCode from USER_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                cb.addItem(rs.getString("userCode"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cb.setSelectedItem(selectedNo);
    }

    public void fetUserCodeRelatedData(String toString, ModifyUserDialog aThis, String companyCode, Connection conn) {
        String sql = "select * from USER_DETAIL where companyCode = ? AND userCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setUserName(rs.getString("userName"));
                aThis.setDescription(rs.getString("description"));
                aThis.setUserType(rs.getString("userType"));
                aThis.setUserRights(rs.getString("userRights"));
                aThis.setFeatureForUser(rs.getString("featureRights"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deleteUserCode(String toString, ModifyUserDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "delete from USER_DETAIL where companyCode = ? AND userCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateUserInfo(ModifyUserDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "insert into USER_DETAIL values (?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getUserName());
            ps.setString(2, aThis.getUserCode());
            ps.setString(3, aThis.getUserPassword());
            ps.setString(4, aThis.getDescription());
            ps.setString(5, aThis.getUserType());
            ps.setString(6, aThis.getUserRights());
            ps.setString(7, aThis.getUserPermittedFeatures());
            ps.setString(8, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public void fetUserName(String toString, DeleteUserDialog aThis, String companyCode, Connection conn) {
        String sql = "select userName from USER_DETAIL where companyCode = ? AND userCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setUserName(rs.getString("userName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean deleteUserCodeData(String toString, DeleteUserDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "delete from USER_DETAIL where companyCode = ? AND userCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateUserPassword(String toString, ChangePasswordDialog aThis, String companyCode, Connection conn) {
        boolean status = false;
        String sql = "update USER_DETAIL set password = ? where userCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getUserPassword());
            ps.setString(2, toString);
            ps.setString(3, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public void fetUserNameForChange(String toString, ChangePasswordDialog aThis, String companyCode, Connection conn) {
        String sql = "select userName from USER_DETAIL where companyCode = ? AND userCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, toString);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setUserName(rs.getString("userName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
