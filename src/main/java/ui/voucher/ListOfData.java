package ui.voucher;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.main.MainFrame;

/**
 *
 * @author Vimal
 */
public class ListOfData extends javax.swing.JDialog {

    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    private String m;
    private Object itemCode, itemName, storeName, rate, accountName;
    private final JTable table;
    private final String companyCode;
    private DefaultListModel creditModel;
    private DefaultListModel debitModel;
    private DefaultListModel jModel;
    private Object accountNumber;
    private final Connection conn;
    private DefaultListModel defaultListModel;
    private final MainFrame mainFrame;
    private String primaryUnit;
    private String secondaryUnit;
    private String typeRate;
    private double maxQuantiy;
    private String primaryUn;
    private DefaultListModel mo;

    /**
     * Creates new form ListOfDate
     *
     * @param mainFrame
     * @param b
     * @param table
     * @param companyCode
     */
    public ListOfData(MainFrame mainFrame, boolean b, JTable table, String companyCode) {
        super(mainFrame, b);
        initComponents();
        this.mainFrame = mainFrame;
        this.table = table;
        this.companyCode = companyCode;
        this.conn = mainFrame.getConnection3();
        this.setTitle("List");
        list.requestFocusInWindow();
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        errorMessage = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        list.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        list.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setSelectionBackground(new java.awt.Color(0, 102, 102));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), list, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                listKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        errorMessage.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setOpaque(true);

        searchField.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        searchField.setForeground(new java.awt.Color(51, 153, 0));
        searchField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), searchField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        searchField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchFieldCaretUpdate(evt);
            }
        });
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/search.png"))); // NOI18N
        jLabel1.setOpaque(true);

        jLayeredPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLayeredPane1.setOpaque(true);

        title.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        jLayeredPane1.setLayer(title, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, searchField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        searchField.selectAll();
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchFieldCaretUpdate
        if (!searchField.getText().isEmpty()) {
            DefaultListModel model = (DefaultListModel) list.getModel();
            boolean status = false;
            for (int i = 0; i < model.getSize(); i++) {
                String item = model.getElementAt(i).toString();
                if (item.startsWith(searchField.getText()) || item.toLowerCase().startsWith(searchField.getText())) {
                    list.setSelectedIndex(i);
                    list.scrollRectToVisible(list.getCellBounds(i, i));
                    status = true;
                    errorMessage.setText(null);
                    break;
                } else {
                    status = false;
                }

            }
            if (!status) {
                Toolkit.getDefaultToolkit().beep();
                errorMessage.setText("!!NOT FOUND!!");
            }
        } else {
            errorMessage.setText(null);
        }

    }//GEN-LAST:event_searchFieldCaretUpdate

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        if (evt.getClickCount() > 1) {
            if (list.getSelectedIndex() > -1) {
                fetchSeletedData(list.getSelectedValue(), m, conn, companyCode);
            }
        }

    }//GEN-LAST:event_listMouseClicked

    private void listKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (list.getSelectedIndex() > -1) {
                fetchSeletedData(list.getSelectedValue(), m, conn, companyCode);
            }
        }
    }//GEN-LAST:event_listKeyTyped

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        listKeyTyped(evt);
    }//GEN-LAST:event_searchFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel title;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public void addData(String msg) {
        m = msg;
        switch (msg) {
            case "ItemName":
                title.setText("Select Item Name");
                sql = "select itemName from ITEM_DETAIL where companyCode = ?";
                fetchItemName(companyCode, conn);
                break;
            case "ItemCode":
                title.setText("Select Item Code");
                sql = "select itemCode from ITEM_DETAIL where companyCode = ?";
                fetchItemCode(companyCode, conn);
                break;
            case "UnitName":
                title.setText("Select Unit Name");
                sql = "select unitName from UNIT_DETAIL where companyCode = ? and primaryUnit = ?";
                fetchUnitName(companyCode, conn);
                break;
            case "BillSundry":
                title.setText("Select Bill Sundry Name");
                sql = "select billSundryName from BILL_SUNDRY_DETAIL where companyCode = ?";
                fetchBillSundryName(companyCode, conn);
                break;
            case "paymentdebitaccno":
                title.setText("Select Account Number");
                fetchPaymentVoucherAccNoUnderNature(companyCode, conn, "debit");
                break;
            case "paymentcreditaccno":
                title.setText("Select Account Number");
                fetchPaymentVoucherAccNoUnderNature(companyCode, conn, "credit");
                break;
            case "paymentdebitaccname":
                title.setText("Select Account Name");
                fetchPaymentVoucherAccNameUnderNature(companyCode, conn, "debit");
                break;
            case "paymentcreditaccname":
                title.setText("Select Account Name");
                fetchPaymentVoucherAccNameUnderNature(companyCode, conn, "credit");
                break;
            case "receiptdebitaccno":
                title.setText("Select Account Number");
                fetchReceiptVoucherAccNoUnderNature(companyCode, conn, "debit");
                break;
            case "receiptcreditaccno":
                title.setText("Select Account Number");
                fetchReceiptVoucherAccNoUnderNature(companyCode, conn, "credit");
                break;
            case "receiptdebitaccname":
                title.setText("Select Account Name");
                fetchReceiptVoucherAccNameUnderNature(companyCode, conn, "debit");
                break;
            case "receiptcreditaccname":
                title.setText("Select Account Name");
                fetchReceiptVoucherAccNameUnderNature(companyCode, conn, "credit");
                break;
            case "journaldebitaccno":
                title.setText("Select Account Number");
                fetchJournalVoucherAccNo(companyCode, conn);
                break;
            case "journaldebitaccname":
                title.setText("Select Account Name");
                fetchJournalVoucherAccName(companyCode, conn);
                break;
            case "journalcreditaccno":
                title.setText("Select Account Number");
                fetchJournalVoucherAccNo(companyCode, conn);
                break;
            case "journalcreditaccname":
                title.setText("Select Account Name");
                fetchJournalVoucherAccName(companyCode, conn);
                break;
            case "debitnotedebitaccno":
                title.setText("Select Account Number");
                fetchReceiptVoucherAccNoUnderNature(companyCode, conn, "debit");
                break;
            case "debitnotecreditaccno":
                title.setText("Select Account Number");
                fetchReceiptVoucherAccNoUnderNature(companyCode, conn, "credit");
                break;
            case "debitnotedebitaccname":
                title.setText("Select Account Name");
                fetchReceiptVoucherAccNameUnderNature(companyCode, conn, "debit");
                break;
            case "debitnotecreditaccname":
                title.setText("Select Account Name");
                fetchReceiptVoucherAccNameUnderNature(companyCode, conn, "credit");
                break;
            case "creditnotedebitaccno":
                title.setText("Select Account Number");
                fetchPaymentVoucherAccNoUnderNature(companyCode, conn, "debit");
                break;
            case "creditnotecreditaccno":
                title.setText("Select Account Number");
                fetchPaymentVoucherAccNoUnderNature(companyCode, conn, "credit");
                break;
            case "creditnotedebitaccname":
                title.setText("Select Account Name");
                fetchPaymentVoucherAccNameUnderNature(companyCode, conn, "debit");
                break;
            case "creditnotecreditaccname":
                title.setText("Select Account Name");
                fetchPaymentVoucherAccNameUnderNature(companyCode, conn, "credit");
                break;
            case "cashaccno":
                title.setText("Select Account Number");
                fetchCashAccNoUnderNature(companyCode, conn);
                break;
            case "cashaccname":
                title.setText("Select Account Name");
                fetchCashAccNameUnderNature(companyCode, conn);
                break;
            case "bankaccno":
                title.setText("Select Account Number");
                fetchBankAccNoUnderNature(companyCode, conn);
                break;
            case "bankaccname":
                title.setText("Select Account Name");
                fetchBankAccNameUnderNature(companyCode, conn);
                break;
        }
        
        this.defaultListModel = (DefaultListModel) list.getModel();
        if (list.getModel().getSize() > 0) {
            list.setSelectedIndex(0);

        }
    }

    private void fetchItemCode(String companyCode, Connection conn) {
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getString("itemCode"));
            }
            list.setModel(model);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void fetchItemName(String companyCode, Connection conn) {
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getString("itemName"));
            }
            list.setModel(model);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchBillSundryName(String companyCode, Connection conn) {
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            DefaultListModel model = new DefaultListModel();
            while (rs.next()) {
                model.addElement(rs.getString("billSundryName"));
            }
            list.setModel(model);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchSeletedData(Object selectedValue, String m, Connection conn, String companyCode) {
        switch (m) {
            case "ItemName":
                fetchItemNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(itemCode, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                table.getModel().setValueAt(storeName, table.getSelectedRow(), 3);
                table.getModel().setValueAt(rate, table.getSelectedRow(), 6);
                this.setVisible(false);
                this.dispose();
                break;
            case "ItemCode":
                if (table.getColumnCount() == 8) {
                    fetchItemCodeProductionRelData(selectedValue, conn, companyCode);
                    table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                    table.getModel().setValueAt(itemName, table.getSelectedRow(), 2);
                    table.getModel().setValueAt(storeName, table.getSelectedRow(), 3);
                    this.setVisible(false);
                    this.dispose();
                } else {
                    fetchItemCodeRelData(selectedValue, conn, companyCode);
                    table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                    table.getModel().setValueAt(itemName, table.getSelectedRow(), 2);
                    table.getModel().setValueAt(storeName, table.getSelectedRow(), 3);
                    table.getModel().setValueAt(rate, table.getSelectedRow(), 6);
                    this.setVisible(false);
                    this.dispose();
                }

                break;
            case "UnitName":
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                this.setVisible(false);
                this.dispose();
                break;
            case "BillSundry":
                if (table.getSelectedColumn() == 0) {
                    table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 0);
                } else if (table.getSelectedColumn() == 8) {
                    table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 8);
                }
                this.setVisible(false);
                this.dispose();
                break;
            case "paymentcreditaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "paymentdebitaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "paymentcreditaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 4);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "paymentdebitaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "receiptcreditaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "receiptdebitaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "receiptcreditaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 4);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "receiptdebitaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "journaldebitaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "journaldebitaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "journalcreditaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "journalcreditaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 4);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "debitnotecreditaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "debitnotedebitaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "debitnotecreditaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 4);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "debitnotedebitaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "creditnotecreditaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "creditnotedebitaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "creditnotecreditaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 4);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 5);
                this.setVisible(false);
                this.dispose();
                break;
            case "creditnotedebitaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
                
            case "cashaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 1);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "cashaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 1);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 2);
                this.setVisible(false);
                this.dispose();
                break;
            case "bankaccno":
                fetchAccountNumberRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 3);
                table.getModel().setValueAt(accountName, table.getSelectedRow(), 4);
                this.setVisible(false);
                this.dispose();
                break;
            case "bankaccname":
                fetchAccountNameRelData(selectedValue, conn, companyCode);
                table.getModel().setValueAt(accountNumber, table.getSelectedRow(), 3);
                table.getModel().setValueAt(selectedValue, table.getSelectedRow(), 4);
                this.setVisible(false);
                this.dispose();
                break;

        }
    }

    private void fetchItemNameRelData(Object selectedValue, Connection conn, String companyCode) {
        String sql1 = "select * from ITEM_DETAIL where itemName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, selectedValue.toString());
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                itemCode = rs.getString("itemCode");
                storeName = rs.getString("storeName");
                if (typeRate.equalsIgnoreCase("sale")) {
                    rate = rs.getString("salePrice");
                } else if(typeRate.equalsIgnoreCase("purchase")){
                    rate = rs.getString("purchasePrice");
                } else {
                    rate = null;
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchItemCodeRelData(Object selectedValue, Connection conn, String companyCode) {
        String sql1 = "select * from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, selectedValue.toString());
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                itemName = rs.getString("itemName");
                storeName = rs.getString("storeName");
                if (typeRate.equalsIgnoreCase("sale")) {
                    rate = rs.getString("salePrice");
                } else {
                    rate = rs.getString("purchasePrice");
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchPaymentVoucherAccNoUnderNature(String companyCode, Connection conn, String nature) {
        String query = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        debitModel = new DefaultListModel();
        creditModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkPaymentVoucherCreditAccountGroupNature(groupName)) {
                        creditModel.addElement(accNumber);
                    } else if (checkPaymentVoucherDebitAccountGroupNature(groupName)) {
                        debitModel.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkPaymentVoucherCreditAccountGroupNature(underGroup)) {
                                creditModel.addElement(accNumber);
                                break;
                            } else if (checkPaymentVoucherDebitAccountGroupNature(groupName)) {
                                debitModel.addElement(accNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (nature) {
            case "credit":
                list.setModel(creditModel);
                break;
            case "debit":
                list.setModel(debitModel);
                break;
        }
    }

    private void fetchPaymentVoucherAccNameUnderNature(String companyCode, Connection conn, String nature) {
        String query = "select accountName,groupName from ACCOUNT_DETAIL where companyCode = ?";
        debitModel = new DefaultListModel();
        creditModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accName = rs.getString("accountName");
                String groupName = rs.getString("groupName");

                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkPaymentVoucherCreditAccountGroupNature(groupName)) {
                        creditModel.addElement(accName);
                    } else if (checkPaymentVoucherDebitAccountGroupNature(groupName)) {
                        debitModel.addElement(accName);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkPaymentVoucherCreditAccountGroupNature(underGroup)) {
                                creditModel.addElement(accName);
                                break;
                            } else if (checkPaymentVoucherDebitAccountGroupNature(groupName)) {
                                debitModel.addElement(accName);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }

            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (nature) {
            case "credit":
                list.setModel(creditModel);
                break;
            case "debit":
                list.setModel(debitModel);
                break;
        }
    }

    private void fetchAccountNumberRelData(Object selectedValue, Connection conn, String companyCode) {
        String query = "select accountName from ACCOUNT_DETAIL where accountNumber = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, selectedValue.toString());
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                accountName = rs.getString("accountName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchAccountNameRelData(Object selectedValue, Connection conn, String companyCode) {
        String query = "select accountNumber from ACCOUNT_DETAIL where accountName = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, selectedValue.toString());
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                accountNumber = rs.getString("accountNumber");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchReceiptVoucherAccNoUnderNature(String companyCode, Connection conn, String nature) {
        String query = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        debitModel = new DefaultListModel();
        creditModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");

                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkReceiptVoucherDebitAccountGroupNature(groupName)) {
                        debitModel.addElement(accNumber);
                    } else if (checkRecieptVoucherCreditAccountGroupNature(groupName)) {
                        creditModel.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkReceiptVoucherDebitAccountGroupNature(underGroup)) {
                                debitModel.addElement(accNumber);
                                break;
                            } else if (checkRecieptVoucherCreditAccountGroupNature(groupName)) {
                                creditModel.addElement(accNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (nature) {
            case "credit":
                list.setModel(creditModel);
                break;
            case "debit":
                list.setModel(debitModel);
                break;
        }
    }

    private void fetchReceiptVoucherAccNameUnderNature(String companyCode, Connection conn, String nature) {
        String query = "select accountName,groupName from ACCOUNT_DETAIL where companyCode = ?";
        debitModel = new DefaultListModel();
        creditModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accName = rs.getString("accountName");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkReceiptVoucherDebitAccountGroupNature(groupName)) {
                        debitModel.addElement(accName);
                    } else if (checkRecieptVoucherCreditAccountGroupNature(groupName)) {
                        creditModel.addElement(accName);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkReceiptVoucherDebitAccountGroupNature(underGroup)) {
                                debitModel.addElement(accName);
                                break;
                            } else if (checkRecieptVoucherCreditAccountGroupNature(groupName)) {
                                creditModel.addElement(accName);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }

            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (nature) {
            case "credit":
                list.setModel(creditModel);
                break;
            case "debit":
                list.setModel(debitModel);
                break;
        }
    }

    private boolean checkPaymentVoucherCreditAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Bank Accounts") || groupName.equalsIgnoreCase("Bank O/D Account") || groupName.equalsIgnoreCase("Cash in hand")) {
                status = true;
            }
        }
        return status;
    }

    private boolean checkPaymentVoucherDebitAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Sundry Creditors") || groupName.equalsIgnoreCase("Sundry Debtors") || groupName.equalsIgnoreCase("Sale") || groupName.equalsIgnoreCase("Purchase")) {
                status = true;
            }
        }
        return status;
    }

    private boolean checkReceiptVoucherDebitAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Bank Accounts") || groupName.equalsIgnoreCase("Cash in hand")) {
                status = true;
            }
        }
        return status;
    }

    private boolean checkRecieptVoucherCreditAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Sundry Creditors") || groupName.equalsIgnoreCase("Sundry Debtors") || groupName.equalsIgnoreCase("Sale") || groupName.equalsIgnoreCase("Purchase")) {
                status = true;
            }
        }
        return status;
    }

    private void fetchJournalVoucherAccNo(String companyCode, Connection conn) {
        String query = "select accountNumber from ACCOUNT_DETAIL where companyCode = ?";
        jModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                jModel.addElement(rs.getString("accountNumber"));
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }

        list.setModel(jModel);
    }

    private void fetchJournalVoucherAccName(String companyCode, Connection conn) {
        String query = "select accountName from ACCOUNT_DETAIL where companyCode = ?";
        jModel = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                jModel.addElement(rs.getString("accountName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.setModel(jModel);
    }

    private boolean checkPredefinedGroupOrNot(String groupName) {
        if (groupName != null) {
            return groupName.equalsIgnoreCase("Bank Accounts")
                    || groupName.equalsIgnoreCase("Bank O/D Account")
                    || groupName.equalsIgnoreCase("Capital Account")
                    || groupName.equalsIgnoreCase("Cash in hand")
                    || groupName.equalsIgnoreCase("Current Assets")
                    || groupName.equalsIgnoreCase("Current Liabilities")
                    || groupName.equalsIgnoreCase("Duties & Taxes")
                    || groupName.equalsIgnoreCase("Expenses(Direct)")
                    || groupName.equalsIgnoreCase("Expenses(Indirect)")
                    || groupName.equalsIgnoreCase("Fixed Assets")
                    || groupName.equalsIgnoreCase("Income(Direct)")
                    || groupName.equalsIgnoreCase("Income(Indirect)")
                    || groupName.equalsIgnoreCase("Investments")
                    || groupName.equalsIgnoreCase("Loan")
                    || groupName.equalsIgnoreCase("Loans & Advances")
                    || groupName.equalsIgnoreCase("Purchase")
                    || groupName.equalsIgnoreCase("Provisions/Expenses Payable")
                    || groupName.equalsIgnoreCase("Reserves & Surplus")
                    || groupName.equalsIgnoreCase("Revenue")
                    || groupName.equalsIgnoreCase("Sale")
                    || groupName.equalsIgnoreCase("Secured Loans")
                    || groupName.equalsIgnoreCase("Security & Deposits(Assets)")
                    || groupName.equalsIgnoreCase("Sundry Creditors")
                    || groupName.equalsIgnoreCase("Sundry Debtors")
                    || groupName.equalsIgnoreCase("Suspense Account")
                    || groupName.equalsIgnoreCase("Unsecured Loans");
        } else {
            return false;
        }
    }

    private String getUnderGroupName(String groupName, String companyCode) {
        String underGroupName = null;
        String query = "select underGroup from ACCOUNT_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        Connection connn = mainFrame.getConnection();
        try {
            connn.setAutoCommit(false);
            PreparedStatement ps1 = connn.prepareStatement(query);
            ps1.setString(1, groupName);
            ps1.setString(2, companyCode);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                underGroupName = rs1.getString("underGroup");
            }
            connn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return underGroupName;
    }

    private void fetchUnitName(String companyCode, Connection conn) {
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, primaryUnit);
            rs = ps.executeQuery();
            DefaultListModel model = new DefaultListModel();
            model.addElement(primaryUnit);
            while (rs.next()) {
                secondaryUnit = rs.getString("unitName");
                model.addElement(secondaryUnit);
                for (;;) {
                    try {
                        Connection c = mainFrame.getConnection2();
                        c.setAutoCommit(false);
                        PreparedStatement p = c.prepareStatement(sql);
                        p.setString(1, companyCode);
                        p.setString(2, secondaryUnit);
                        ResultSet r = p.executeQuery();
                        if (r.next()) {
                            secondaryUnit = r.getString("unitName");
                            model.addElement(secondaryUnit);
                        } else {
                            break;
                        }
                        c.commit();
                    } catch (SQLException ex) {
                        Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            list.setModel(model);
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUnitName(String primaryUnit) {
        this.primaryUnit = primaryUnit;
    }

    public void setTypeOfRate(String s) {
        this.typeRate = s;
    }

    private void fetchItemCodeProductionRelData(Object selectedValue, Connection conn, String companyCode) {
        String sql1 = "select * from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql1);
            ps.setString(1, selectedValue.toString());
            ps.setString(2, companyCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                itemName = rs.getString("itemName");
                storeName = rs.getString("storeName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUnitConsName(String primaryUnitCons) {
        this.primaryUnit = primaryUnitCons;
    }

    public void setUnitGenName(String primaryUnitGen) {
        this.primaryUnit = primaryUnitGen;
    }

    public void fetchUnitRelData(String iC, Connection conn) {
        this.maxQuantiy = 0;
        String s  = "SELECT selfDevCost from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
       try {
           conn.setAutoCommit(false);
           PreparedStatement p = conn.prepareStatement(s);
            p.setString(1, iC);
            p.setString(2, companyCode);
            ResultSet r = p.executeQuery();
            if(r.next()) {
                try {
                    maxQuantiy = maxQuantiy + Double.valueOf(r.getString("selfDevCost"));
                }catch(NullPointerException|NumberFormatException ex) {}
            }
           conn.commit();
       }catch(SQLException ex) {
           ex.printStackTrace();
       }
        String sql1 = "select * from PURCHASE_REGISTER_ITEM_LIST where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql1);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy + Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy + temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql2 = "select * from PURCHASE_RETURN_ITEM_LIST where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql2);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy - Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy - temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql3 = "select * from SALE_REGISTER_ITEM_LIST where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql3);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy - Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy - temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql4 = "select * from SALE_RETURN_ITEM_LIST where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql4);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy + Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy + temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql5 = "select * from PRODUCTION_VOUCHER_ITEM_GENERATED where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql5);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy + Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy + temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql6 = "select * from PRODUCTION_VOUCHER_ITEM_CONSUMED where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql5);
            p.setString(1, iC);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String uName = r.getString("unitName");
                String quantity = r.getString("quantity");
                if (getUnitType(uName, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                    maxQuantiy = maxQuantiy - Double.valueOf(quantity);
                } else {
                    int j = 0;
                    String perUnit = new FetchVoucherData().getPerUnit(uName, mainFrame.getConnection2());
                    double temp = Double.valueOf(perUnit);
                    String primaryU = new FetchVoucherData().getPrimaryUnit(uName, mainFrame.getConnection2());
                    for (;;) {
                        if (getUnitType(primaryU, mainFrame.getConnection2()).equalsIgnoreCase("Single")) {
                            break;
                        } else {
                            perUnit = new FetchVoucherData().getPerUnit(primaryU, mainFrame.getConnection2());
                            temp = temp * Double.valueOf(perUnit);
                            primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, mainFrame.getConnection2());
                        }

                        j++;
                        if (j > 20) {
                            break;
                        }
                    }
                    maxQuantiy = maxQuantiy - temp * Double.valueOf(quantity);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMaxQuantity() {
        fetchUnitRelData(table.getModel().getValueAt(table.getSelectedRow(), 1).toString(), conn);
        return roundTwoDecimals(maxQuantiy) + " " + getUnitName(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
    }

    public String getMaxQuantity(int row) {
        fetchUnitRelData(table.getModel().getValueAt(row, 1).toString(), conn);
        return roundTwoDecimals(maxQuantiy);
    }

    public String roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    public String getUnitType(String unitName, Connection conn) {
        String unitType = null;
        String s = "select unitType from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(s);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                unitType = rs.getString("unitType");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unitType;
    }

    public String getPrimaryUnit(String unitName, Connection conn) {
        String primaryU = null;
        String query = "select primaryUnit from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                primaryU = rs.getString("primaryUnit");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return primaryU;
    }

    public String getPerUnit(String unitName, Connection conn) {
        String perUnit = null;
        String query = "select perUnit from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                perUnit = rs.getString("perUnit");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perUnit;
    }

    private String getUnitName(String itemCode) {
        String unitName = null;
        String query = "select unitName from ITEM_DETAIL where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, itemCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                unitName = rs.getString("unitName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unitName;
    }

    private void fetchCashAccNoUnderNature(String companyCode, Connection conn) {
        String query = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        mo = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkCashInHandAccountGroupNature(groupName)) {
                        mo.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkCashInHandAccountGroupNature(groupName)) {
                                mo.addElement(accNumber);
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.setModel(mo);
    }

    private void fetchCashAccNameUnderNature(String companyCode, Connection conn) {
        String query = "select accountName,groupName from ACCOUNT_DETAIL where companyCode = ?";
        mo = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountName");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkCashInHandAccountGroupNature(groupName)) {
                        mo.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkCashInHandAccountGroupNature(groupName)) {
                                mo.addElement(accNumber);
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.setModel(mo);
    }

    private void fetchBankAccNoUnderNature(String companyCode, Connection conn) {
        String query = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        mo = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkBankAccountGroupNature(groupName)) {
                        mo.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkBankAccountGroupNature(groupName)) {
                                mo.addElement(accNumber);
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.setModel(mo);
    }

    private void fetchBankAccNameUnderNature(String companyCode, Connection conn) {
        String query = "select accountName,groupName from ACCOUNT_DETAIL where companyCode = ?";
        mo = new DefaultListModel();
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accNumber = rs.getString("accountName");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkBankAccountGroupNature(groupName)) {
                        mo.addElement(accNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkBankAccountGroupNature(groupName)) {
                                mo.addElement(accNumber);
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 10) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.setModel(mo);
    }

    private boolean checkCashInHandAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Cash in hand")) {
                status = true;
            }
        }
        return status;
    }

    private boolean checkBankAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Bank Accounts")) {
                status = true;
            }
        }
        return status;
    }
}
