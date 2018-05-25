package ui.master.account.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.master.account.AccountCreation;
import ui.master.account.AccountGroupCreation;
import ui.master.account.CustomerCreation;
import ui.master.account.VendorCreation;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AccountHandler {

    private PreparedStatement ps;
    private ResultSet rs;

    public boolean checkAccountNumberIsValidOrNot(String companyCode, String accountNumber, Connection conn) {
        boolean status = false;
        String sql = "select accountNumber from ACCOUNT_DETAIL where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (!rs.next()) {
                status = true;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean saveAccountInformation(String companyCode, AccountCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ACCOUNT_DETAIL values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getAccName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, "Account");
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setTimestamp(8, aThis.getDate());
            ps.setString(9, aThis.getDescription());
            ps.setString(10, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean updateAccountInformation(String companyCode, AccountCreation aThis, String accountNumber, Connection conn) {
        boolean status = false;
        String sql = "update ACCOUNT_DETAIL set accountNumber = ?, accountName = ?,groupName = ?, description = ? where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getAccName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, aThis.getDescription());
            ps.setString(5, accountNumber);
            ps.setString(6, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean deleteAccountNumber(String companyCode, String accountNumber, Connection conn) {
        boolean status = false;
        String sql = "delete from ACCOUNT_DETAIL where accountNumber = ? and companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchAccountInformation(String companyCode, JTable accountListTable, Connection conn, String type) {
        boolean status = false;
        removeAllRows(accountListTable);
        String sql = null;
        switch (type) {
            case "Account":
                sql = "select * from ACCOUNT_DETAIL where companyCode = ? and groupName <> 'Sale'";
                break;
            case "Customer":
                sql = "select * from ACCOUNT_DETAIL where companyCode = ? and groupName = 'Sale'";
                break;
            case "Vendor":
                sql = "select * from ACCOUNT_DETAIL where companyCode = ? and groupName = 'Purchase'";
                break;
        }
        DefaultTableModel model = (DefaultTableModel) accountListTable.getModel();
        Object rowData[] = {null, null, null, null, null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                String acccountNumber = rs.getString("accountNumber");
                String accountName = rs.getString("accountName");
                String groupName = rs.getString("groupName");
                if (type.equalsIgnoreCase("Account")) {
                    if (!groupName.equalsIgnoreCase("Purchase")) {
                        model.addRow(rowData);
                        accountListTable.getModel().setValueAt(row + 1, row, 0);
                        accountListTable.getModel().setValueAt(acccountNumber, row, 1);
                        accountListTable.getModel().setValueAt(accountName, row, 2);
                        accountListTable.getModel().setValueAt(groupName, row, 3);
                        row++;
                    }
                } else {
                    model.addRow(rowData);
                    accountListTable.getModel().setValueAt(row + 1, row, 0);
                    accountListTable.getModel().setValueAt(acccountNumber, row, 1);
                    accountListTable.getModel().setValueAt(accountName, row, 2);
                    accountListTable.getModel().setValueAt(groupName, row, 3);
                    row++;
                }

            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchDataOfAccount(String companyCode, String accountNumber, AccountCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ACCOUNT_DETAIL where accountNumber = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setAccountNumber(rs.getString("accountNumber"));
                aThis.setAccountName(rs.getString("accountName"));
                aThis.setGroupName(rs.getString("groupName"));
                aThis.setDescription(rs.getString("description"));
                status = true;
            } else {
                status = false;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean checkAccountGroupIsValidOrNot(String companyCode, String groupName, Connection conn) {
        boolean status = false;
        String sql = "select groupName from ACCOUNT_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, groupName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (!rs.next()) {
                status = true;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean saveAccountGroupInformation(String companyCode, AccountGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ACCOUNT_GROUP_DETAIL values (?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getGroupName());
            ps.setString(2, null);
            ps.setString(3, aThis.getUnderGroup());
            ps.setString(4, aThis.getComments());
            ps.setString(5, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean updateAccountGroupInformation(String companyCode, AccountGroupCreation aThis, String accountGroup, Connection conn) {
        boolean status = false;
        String sql = "update ACCOUNT_GROUP_DETAIL set groupName = ?, underGroup = ?, comments = ? where groupName = ? and companyCode =?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getGroupName());
            ps.setString(2, aThis.getUnderGroup());
            ps.setString(3, aThis.getComments());
            ps.setString(4, accountGroup);
            ps.setString(5, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean deleteAccountGroup(String companyCode, String groupName, Connection conn, AccountGroupCreation aThis) {
        boolean status = false;
        String sql = "delete from ACCOUNT_GROUP_DETAIL where companyCode = ? and groupName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, groupName);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchAccountGroupInformation(String companyCode, JTable accounGroupListTable, Connection conn) {
        boolean status;
        removeAllRows(accounGroupListTable);
        String sql2 = "select * from ACCOUNT_GROUP_DETAIL where companyCode = ?";
        int row = 0;
        DefaultTableModel model = (DefaultTableModel) accounGroupListTable.getModel();
        Object rowData[] = {null, null, null, null};

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql2);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(rowData);
                accounGroupListTable.getModel().setValueAt(row + 1, row, 0);
                accounGroupListTable.getModel().setValueAt(rs.getString("groupName"), row, 1);
                accounGroupListTable.getModel().setValueAt(rs.getString("primaryNature"), row, 2);
                accounGroupListTable.getModel().setValueAt(rs.getString("underGroup"), row, 3);
                accounGroupListTable.getModel().setValueAt(rs.getString("comments"), row, 4);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            status = false;
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchDataOfAccountGroup(String companyCode, String accountGroup, AccountGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ACCOUNT_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountGroup);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setGroupName(rs.getString("groupName"));
                aThis.setUnderGroup(rs.getString("underGroup"));
                aThis.setComments(rs.getString("comments"));
                status = true;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean saveCustomerInformation(String companyCode, CustomerCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ACCOUNT_DETAIL values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getCusName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, "Customer");
            ps.setString(5, aThis.getAddress());
            ps.setString(6, aThis.getPhNo());
            ps.setString(7, aThis.getFaxNo());
            ps.setTimestamp(8, aThis.getDateT());
            ps.setString(9, aThis.getDescription());
            ps.setString(10, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean updateCustomerInformation(String companyCode, CustomerCreation aThis, String accountNumber, Connection conn) {
        boolean status = false;
        String sql = "update ACCOUNT_DETAIL set accountNumber = ?, accountName = ?,groupName=?, address=?, phNo=?, faxNo=?, dateForAccount = ?, description = ? where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getCusName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, aThis.getAddress());
            ps.setString(5, aThis.getPhNo());
            ps.setString(6, aThis.getFaxNo());
            ps.setTimestamp(7, aThis.getDateT());
            ps.setString(8, aThis.getDescription());
            ps.setString(9, accountNumber);
            ps.setString(10, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchDataOfCustomer(String companyCode, String accountNumber, CustomerCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ACCOUNT_DETAIL where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setAccountNumber(rs.getString("accountNumber"));
                aThis.setCusName(rs.getString("accountName"));
                aThis.setGroupName(rs.getString("groupName"));
                aThis.setAddress(rs.getString("address"));
                aThis.setPhoneNumber(rs.getString("phNo"));
                aThis.setFaxNo(rs.getString("faxNo"));
                aThis.setDateT(rs.getTimestamp("dateForAccount"));
                aThis.setDescription(rs.getString("description"));
                status = true;
            } else {
                status = false;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean saveVednorInformation(String companyCode, VendorCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ACCOUNT_DETAIL values (?,?,?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getCusName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, "Vendor");
            ps.setString(5, aThis.getAddress());
            ps.setString(6, aThis.getPhNo());
            ps.setString(7, aThis.getFaxNo());
            ps.setTimestamp(8, aThis.getDateT());
            ps.setString(9, aThis.getDescription());
            ps.setString(10, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean updateVendorInformation(String companyCode, VendorCreation aThis, String accountNumber, Connection conn) {
        boolean status = false;
        String sql = "update ACCOUNT_DETAIL set accountNumber = ?, accountName = ?,groupName=?, address=?, phNo=?, faxNo=?, dateForAccount = ?, description = ? where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getAccNumber());
            ps.setString(2, aThis.getCusName());
            ps.setString(3, aThis.getGroupName());
            ps.setString(4, aThis.getAddress());
            ps.setString(5, aThis.getPhNo());
            ps.setString(6, aThis.getFaxNo());
            ps.setTimestamp(7, aThis.getDateT());
            ps.setString(8, aThis.getDescription());
            ps.setString(9, accountNumber);
            ps.setString(10, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public boolean fetchDataOfVednor(String companyCode, String accountNumber, VendorCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ACCOUNT_DETAIL where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, accountNumber);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setAccountNumber(rs.getString("accountNumber"));
                aThis.setCusName(rs.getString("accountName"));
                aThis.setGroupName(rs.getString("groupName"));
                aThis.setAddress(rs.getString("address"));
                aThis.setPhoneNumber(rs.getString("phNo"));
                aThis.setFaxNo(rs.getString("faxNo"));
                aThis.setDateT(rs.getTimestamp("dateForAccount"));
                aThis.setDescription(rs.getString("description"));
                status = true;
            } else {
                status = false;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
