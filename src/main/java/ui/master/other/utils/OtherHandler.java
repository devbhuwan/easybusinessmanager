package ui.master.other.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.master.other.BillSundryCreation;
import ui.master.other.UnitCreation;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class OtherHandler {

    private PreparedStatement ps;
    private ResultSet rs;

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean checkBillSundryIsValidOrNot(String companyCode, String billSundryName, Connection conn) {
        boolean status = false;
        String sql = "select billSundryName from BILL_SUNDRY_DETAIL where billSundryName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, billSundryName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (!rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveBillSundryInformation(String companyCode, BillSundryCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into BILL_SUNDRY_DETAIL values (?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getBillSundry());
            ps.setString(2, aThis.getComments());
            ps.setString(3, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateBillSundryInformation(String companyCode, BillSundryCreation aThis, String billSundryName, Connection conn) {
        boolean status = false;
        String sql = "update BILL_SUNDRY_DETAIL set billSundryName = ?, comments = ? where billSundryName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getBillSundry());
            ps.setString(2, aThis.getComments());
            ps.setString(3, billSundryName);
            ps.setString(4, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean deleteBillSundry(String companyCode, String billSundryName, Connection conn) {
        boolean status = false;
        String sql = "delete from BILL_SUNDRY_DETAIL where companyCode = ? and billSundryName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, billSundryName);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchBillSundryInformation(String companyCode, JTable billSundryNameListTable, Connection conn) {
        boolean status = false;
        removeAllRows(billSundryNameListTable);
        String sql = "select * from BILL_SUNDRY_DETAIL where companyCode = ?";

        DefaultTableModel model = (DefaultTableModel) billSundryNameListTable.getModel();
        Object rowData[] = {null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                billSundryNameListTable.getModel().setValueAt(row + 1, row, 0);
                billSundryNameListTable.getModel().setValueAt(rs.getString("billSundryName"), row, 1);
                row++;

            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfBillSundry(String companyCode, String billSundryName, BillSundryCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from BILL_SUNDRY_DETAIL where billSundryName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, billSundryName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setBillSundry(rs.getString("billSundryName"));
                aThis.setComments(rs.getString("comments"));
                status = true;
            } else {
                status = false;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean checkUnitIsValidOrNot(String companyCode, String text, Connection conn) {
        boolean status = false;
        String sql = "select unitName from UNIT_DETAIL where unitName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, text);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (!rs.next()) {
                status = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean saveUnitInformation(String companyCode, UnitCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into UNIT_DETAIL values (?,?,?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getUnitName());
            ps.setString(2, aThis.getUnitAbb());
            ps.setString(3, aThis.getUnitType());
            ps.setString(4, aThis.getDecimalPlace());
            ps.setString(5, aThis.getPrimaryUnit());
            ps.setString(6, aThis.getPerUnit());
            ps.setString(7, aThis.description());
            ps.setString(8, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateUnitInformation(String companyCode, UnitCreation aThis, String text, Connection conn) {
        boolean status = false;
        String sql = "update UNIT_DETAIL set unitName = ?, unitAbbreviation = ?, unitType = ?,decimalPlace=?,primaryUnit=?,perUnit=?,description=? where companyCode = ? and unitName = ? ";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getUnitName());
            ps.setString(2, aThis.getUnitAbb());
            ps.setString(3, aThis.getUnitType());
            ps.setString(4, aThis.getDecimalPlace());
            ps.setString(5, aThis.getPrimaryUnit());
            ps.setString(6, aThis.getPerUnit());
            ps.setString(7, aThis.description());
            ps.setString(8, companyCode);
            ps.setString(9, text);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean deleteUnit(String companyCode, String text, Connection conn) {
        boolean status = false;
        String sql = "delete from UNIT_DETAIL where companyCode = ? and unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, text);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchunitInformation(String companyCode, JTable unitListTable, Connection conn) {
        boolean status = false;
        removeAllRows(unitListTable);
        String sql = "select * from UNIT_DETAIL where companyCode = ?";

        DefaultTableModel model = (DefaultTableModel) unitListTable.getModel();
        Object rowData[] = {null, null,null,null,null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                unitListTable.getModel().setValueAt(row + 1, row, 0);
                unitListTable.getModel().setValueAt(rs.getString("unitName"), row, 1);
                unitListTable.getModel().setValueAt(rs.getString("unitAbbreviation"), row, 2);
                unitListTable.getModel().setValueAt(rs.getString("unitType"), row, 3);
                unitListTable.getModel().setValueAt(rs.getString("primaryUnit"), row, 4);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfUnit(String companyCode, String unitName, UnitCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from UNIT_DETAIL where unitName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, unitName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setUnitName(rs.getString("unitName"));
                aThis.setUnitAbb(rs.getString("unitAbbreviation"));
                if(rs.getString("unitType").equalsIgnoreCase("Single")) {
                    aThis.setUnitSingleType(rs.getString("decimalPlace"));
                } else {
                    aThis.setUnitCompaoundType(rs.getString("primaryUnit"),rs.getString("perUnit"));
                }
                aThis.setDescription(rs.getString("description"));
                status = true;
            } else {
                status = false;
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
