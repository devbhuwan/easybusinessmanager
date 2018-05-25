/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.voucher;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class TableUtils {

    public TableUtils() {
    }

    public void addingItemTable(JTable itemTable) {
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        itemTable.getModel().setValueAt(itemTable.getRowCount(), itemTable.getRowCount() - 1, 0);
        Object[] data = {null, null, null, null, null, null, null, null, null, null, null, null, null};
        model.addRow(data);
        itemTable.setModel(model);
    }

    public void removingItemTableRow(JTable itemTable, int selectedRow) {
        if ((itemTable.getSelectedRow() > -1) && (itemTable.getSelectedRow() < (itemTable.getRowCount() - 1))) {
            DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
            model.removeRow(itemTable.getSelectedRow());
            int temp = 0;
            for (int i = selectedRow; i < itemTable.getRowCount() - 1; i++) {
                itemTable.getModel().setValueAt(selectedRow + temp + 1, selectedRow + temp, 0);
                temp++;
            }
        }
    }

    public void removingItemTableRows(JTable itemTable, int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.removeRow(selectedRow);
        int temp = 0;
        for (int i = selectedRow; i < itemTable.getRowCount() - 1; i++) {
            itemTable.getModel().setValueAt(selectedRow + temp + 1, selectedRow + temp, 0);
            temp++;
        }
    }

    public void addingBillSundryTableRow(JTable billSundryTable) {
        DefaultTableModel model = (DefaultTableModel) billSundryTable.getModel();
        Object[] data = {null, null, null, null};
        model.addRow(data);
        billSundryTable.setModel(model);
    }

    public void removingBillSundryTableRow(JTable billSundryTable) {
        if ((billSundryTable.getSelectedRow() > -1) && (billSundryTable.getSelectedRow() < (billSundryTable.getRowCount() - 1))) {
            DefaultTableModel model = (DefaultTableModel) billSundryTable.getModel();
            model.removeRow(billSundryTable.getSelectedRow());
        }
    }

    public void addingDoubleEntryTableRow(JTable doubleEntryTable) {
        DefaultTableModel model = (DefaultTableModel) doubleEntryTable.getModel();
        doubleEntryTable.getModel().setValueAt(doubleEntryTable.getRowCount(), doubleEntryTable.getRowCount() - 1, 0);
        Object[] data = {null, null, null, null, null, null, null};
        model.addRow(data);
        doubleEntryTable.setModel(model);
    }

    public void removingDoubleEntryTableRow(JTable doubleEntryTable, int selectedRow) {
        if ((doubleEntryTable.getSelectedRow() > -1) && (doubleEntryTable.getSelectedRow() < (doubleEntryTable.getRowCount() - 1))) {
            DefaultTableModel model = (DefaultTableModel) doubleEntryTable.getModel();
            model.removeRow(doubleEntryTable.getSelectedRow());
            int temp = 0;
            for (int i = selectedRow; i < doubleEntryTable.getRowCount() - 1; i++) {
                doubleEntryTable.getModel().setValueAt(selectedRow + temp + 1, selectedRow + temp, 0);
                temp++;
            }
        }
    }

    public void addingAccountNoTableRow(JTable accountListTable) {
        DefaultTableModel model = (DefaultTableModel) accountListTable.getModel();
        Object[] data = {null, null};
        model.addRow(data);
        accountListTable.setModel(model);
    }

}
