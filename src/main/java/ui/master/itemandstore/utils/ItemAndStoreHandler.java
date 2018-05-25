package ui.master.itemandstore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ui.master.itemandstore.ItemCreation;
import ui.master.itemandstore.ItemGroupCreation;
import ui.master.itemandstore.StoreCreation;
import ui.master.itemandstore.StoreGroupCreation;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ItemAndStoreHandler {

    private PreparedStatement ps;
    private ResultSet rs;

    private void removeAllRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public boolean checkItemCodeIsValidOrNot(String companyCode, String itemCode, Connection conn) {
        boolean status = false;
        String sql = "select itemCode from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, itemCode);
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

    public boolean saveItemInformation(String companyCode, ItemCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ITEM_DETAIL values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getItemCode());
            ps.setString(2, aThis.getItemName());
            ps.setString(3, aThis.getItemGroup());
            ps.setString(4, aThis.getStoreName());
            ps.setString(5, aThis.getStoreGroup());
            ps.setString(6, aThis.getUnitName());
            ps.setString(7, aThis.getSalePrice());
            ps.setString(8, aThis.getPurchasePrice());
            ps.setString(9, aThis.getMRP());
            ps.setString(10, aThis.getSelfDevCost());
            ps.setString(11, aThis.getDescription());
            ps.setString(12, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateItemInformation(String companyCode, ItemCreation aThis, String itemCode, Connection conn) {
        boolean status = false;
        String sql = "update ITEM_DETAIL set itemName = ?, itemCode = ?, itemGroup = ?, storeName = ?, storeGroup = ?, unitName = ?, salePrice = ?, purchasePrice = ?, mrp = ?, selfDevCost = ?, description = ? where itemCode = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getItemName());
            ps.setString(2, aThis.getItemCode());
            ps.setString(3, aThis.getItemGroup());
            ps.setString(4, aThis.getStoreName());
            ps.setString(5, aThis.getStoreGroup());
            ps.setString(6, aThis.getUnitName());
            ps.setString(7, aThis.getSalePrice());
            ps.setString(8, aThis.getPurchasePrice());
            ps.setString(9, aThis.getMRP());
            ps.setString(10, aThis.getSelfDevCost());
            ps.setString(11, aThis.getDescription());
            ps.setString(12, itemCode);
            ps.setString(13, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }


    public boolean deleteItemCode(String companyCode, String itemCode, Connection conn) {
        boolean status = false;
        String sql = "delete from ITEM_DETAIL where companyCode = ? and itemCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, itemCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchItemInformation(String companyCode, JTable itemListTable, Connection conn) {
        boolean status = false;
        removeAllRows(itemListTable);
        String sql = "select * from ITEM_DETAIL where companyCode = ?";

        DefaultTableModel model = (DefaultTableModel) itemListTable.getModel();
        Object rowData[] = {null, null, null, null, null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                itemListTable.getModel().setValueAt(row + 1, row, 0);
                itemListTable.getModel().setValueAt(rs.getString("itemName"), row, 1);
                itemListTable.getModel().setValueAt(rs.getString("itemCode"), row, 2);
                itemListTable.getModel().setValueAt(rs.getString("itemGroup"), row, 3);
                itemListTable.getModel().setValueAt(rs.getString("storeName"), row, 4);
                itemListTable.getModel().setValueAt(rs.getString("storeGroup"), row, 5);
                itemListTable.getModel().setValueAt(rs.getString("unitName"), row, 6);
                row++;

            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfItem(String companyCode, String itemCode, ItemCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, itemCode);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setItemCode(rs.getString("itemCode"));
                aThis.setItemName(rs.getString("itemName"));
                aThis.setItemGroup(rs.getString("itemGroup"));
                aThis.setStoreName(rs.getString("storeName"));
                aThis.setStoreGroup(rs.getString("storeGroup"));
                aThis.setUnitName(rs.getString("unitName"));
                aThis.setSalePrice(rs.getString("salePrice"));
                aThis.setPurchasePrice(rs.getString("purchasePrice"));
                aThis.setMRP(rs.getString("mrp"));
                aThis.setSelfDevCost(rs.getString("selfDevCost"));
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

    public boolean checkItemGroupIsValidOrNot(String companyCode, String groupName, Connection conn) {
        boolean status = false;
        String sql = "select * from ITEM_GROUP_DETAIL where groupName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, groupName);
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

    public boolean saveItemGroupInformation(String companyCode, ItemGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into ITEM_GROUP_DETAIL values (?,?,?)";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getGroupName());
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

    public boolean updateItemGroupInformation(String companyCode, ItemGroupCreation aThis, String groupName, Connection conn) {
        boolean status = false;
        String sql = "update ITEM_GROUP_DETAIL set groupName = ?, comments = ? where groupName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getGroupName());
            ps.setString(2, aThis.getComments());
            ps.setString(3, groupName);
            ps.setString(4, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean deleteItemGroup(String companyCode, String groupName, Connection conn) {
        boolean status = false;
        String sql = "delete from ITEM_GROUP_DETAIL where companyCode = ? and groupName";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, groupName);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchItemGroupInformation(String companyCode, JTable itemGroupListTable, Connection conn) {
        boolean status = false;
        removeAllRows(itemGroupListTable);
        String sql = "select * from ITEM_GROUP_DETAIL where companyCode = ?";

        DefaultTableModel model = (DefaultTableModel) itemGroupListTable.getModel();
        Object rowData[] = {null, null, null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                itemGroupListTable.getModel().setValueAt(row + 1, row, 0);
                itemGroupListTable.getModel().setValueAt(rs.getString("groupName"), row, 1);
                itemGroupListTable.getModel().setValueAt(rs.getString("comments"), row, 2);
                row++;

            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfItemGroup(String companyCode, String groupName, ItemGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from ITEM_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, groupName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setGroupName(rs.getString("groupName"));
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

    public boolean checkStoreIsValidOrNot(String companyCode, String storeName, Connection conn) {
        boolean status = false;
        String sql = "select storeName from STORE_DETAIL where storeName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, storeName);
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

    public boolean saveStoreInformation(String companyCode, StoreCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into STORE_DETAIL values (?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getStoreName());
            ps.setString(2, aThis.getStoreGroup());
            ps.setString(3, aThis.getComments());
            ps.setString(4, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean updateStoreInformation(String companyCode, StoreCreation aThis, String storeName, Connection conn) {
        boolean status = false;
        String sql = "update STORE_DETAIL set storeName = ?, storeGroup = ?, comments = ? where storeName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getStoreName());
            ps.setString(2, aThis.getStoreGroup());
            ps.setString(3, aThis.getComments());
            ps.setString(4, storeName);
            ps.setString(5, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }


    public boolean deleteStore(String companyCode, String storeName, Connection conn) {
        boolean status = false;
        String sql = "delete from STORE_DETAIL where companyCode = ? and sotreName =?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, storeName);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchStoreInformation(String companyCode, JTable storeListTable, Connection conn) {
        boolean status = false;
        removeAllRows(storeListTable);
        String sql = "select * from STORE_DETAIL where companyCode = ?";
        DefaultTableModel model = (DefaultTableModel) storeListTable.getModel();
        Object rowData[] = {null, null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                storeListTable.getModel().setValueAt(row + 1, row, 0);
                storeListTable.getModel().setValueAt(rs.getString("storeName"), row, 1);
                storeListTable.getModel().setValueAt(rs.getString("storeGroup"), row, 2);
                row++;
            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfStore(String companyCode, String storeName, StoreCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from STORE_DETAIL where storeName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, storeName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setStoreName(rs.getString("storeName"));
                aThis.setStoreGroup(rs.getString("storeGroup"));
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

    public boolean checkStoreGroupIsValidOrNot(String companyCode, String storeGroup, Connection conn) {
        boolean status = false;
        String sql = "select groupName from STORE_GROUP_DETAIL where groupName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, storeGroup);
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

    public boolean saveStoreGroupInformation(String companyCode, StoreGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "insert into STORE_GROUP_DETAIL values (?,?,?)";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getStoreGroup());
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

    public boolean updateStoreGroupInformation(String companyCode, StoreGroupCreation aThis, String groupName, Connection conn) {
        boolean status = false;
        String sql = "update STORE_GROUP_DETAIL set groupName = ?, comments = ? where groupName = ? AND companyCode = ?";

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, aThis.getStoreGroup());
            ps.setString(2, aThis.getComments());
            ps.setString(3, groupName);
            ps.setString(4, companyCode);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean deleteStoreGroup(String companyCode, String storeGroup, Connection conn) {
        boolean status = false;
        String sql = "delete STORE_GROUP_DETAIL where companyCode = ? and groupName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, storeGroup);
            ps.executeUpdate();
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchStoreGroupInformation(String companyCode, JTable storeGroupListTable, Connection conn) {
        boolean status = false;
        removeAllRows(storeGroupListTable);
        String sql = "select * from STORE_GROUP_DETAIL where companyCode = ?";
        DefaultTableModel model = (DefaultTableModel) storeGroupListTable.getModel();
        Object rowData[] = {null, null};
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            int row = 0;
            while (rs.next()) {
                model.addRow(rowData);
                storeGroupListTable.getModel().setValueAt(row + 1, row, 0);
                storeGroupListTable.getModel().setValueAt(rs.getString("groupName"), row, 1);
                row++;

            }
            conn.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public boolean fetchDataOfStoreGroup(String companyCode, String groupName, StoreGroupCreation aThis, Connection conn) {
        boolean status = false;
        String sql = "select * from STORE_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, groupName);
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                aThis.setStoreGroup(rs.getString("groupName"));
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

}
