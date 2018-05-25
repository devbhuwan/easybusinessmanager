package ui.voucher.saleandpurchase;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.feature.TableUI;
import ui.voucher.TableUtils;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.ListOfData;
import ui.voucher.saleandpurchase.utils.PurchaseOrderHandler;

/**
 *
 * @author Vimal
 */
public class PurchaseOrder extends javax.swing.JPanel {

    private ListOfData listOfData;
    private int selectedRow;
    private final MainFrame mainFrame;
    private final String companyCode;
    private String voucherNumber;
    private final Connection conn;
    private String primaryUnit;
    private String itemCode;
    private String billsundry;
    private String billOverallSUndry;
    private String unitName;
    private String totalItemAmount;
    private double itemTableTotalAmount = 0;
    private double totAmount = 0;
    private TableRowSorter<TableModel> sorter;
    private int selectedRow1;

    /**
     * Creates new form PurchaseOrder
     *
     * @param mainFrame
     * @param companyCode
     * @param conn
     */
    public PurchaseOrder(MainFrame mainFrame, String companyCode, Connection conn) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        dateChooserCombo1.setFormat(1);
        errorMessage.setOpaque(false);
        defaultControlShow();
        printButton.setEnabled(false);
        itemTable.setTableHeader(new TableUI().getTableHeaderUI(itemTable));
        billSundryTable.setTableHeader(new TableUI().getTableHeaderUI(billSundryTable));
        saleOrderListTable.setTableHeader(new TableUI().getTableHeaderUI(saleOrderListTable));
        billSundryTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(taxTypeClassCBB));
        billSundryTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(billSundryNatureCB));
        itemTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(quantityTF));
        itemTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(rateTF));
        itemTable.getColumnModel().getColumn(9).setCellEditor(new DefaultCellEditor(taxTypeClassCB));
        itemTable.getColumnModel().getColumn(11).setCellEditor(new DefaultCellEditor(natureCB));
        itemTable.getColumnModel().getColumn(10).setCellEditor(new DefaultCellEditor(atTheRateTF));
        itemTable.getColumnModel().getColumn(12).setCellEditor(new DefaultCellEditor(miscAmountTF));
        billSundryTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(aRateTF));
        billSundryTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(amountTF));
        new FetchVoucherData().fetchAccountNoSale(mainFrame, accountNumberCB, companyCode, conn);
        new FetchVoucherData().fetchAccountNameSale(mainFrame, accountNameCB, companyCode, conn);
        quantityTF.setEnabled(false);
        natureCB.setEnabled(false);
        rateTF.setEnabled(false);
        taxTypeClassCB.setEnabled(false);
        atTheRateTF.setEnabled(false);
        miscAmountTF.setEnabled(false);
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setOpaque(false);
                errorMessage.setText(null);

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        taxTypeClassCB = new javax.swing.JComboBox();
        natureCB = new javax.swing.JComboBox();
        billSundryNatureCB = new javax.swing.JComboBox();
        taxTypeClassCBB = new javax.swing.JComboBox();
        list = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        saleOrderListTable = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        searchBy = new javax.swing.JComboBox();
        searchKeyTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        quantityTF = new javax.swing.JFormattedTextField();
        rateTF = new javax.swing.JFormattedTextField();
        atTheRateTF = new javax.swing.JFormattedTextField();
        miscAmountTF = new javax.swing.JFormattedTextField();
        aRateTF = new javax.swing.JFormattedTextField();
        amountTF = new javax.swing.JFormattedTextField();
        container = new javax.swing.JPanel();
        contentPanel = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        voucherNumberTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        accountNumberCB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTA = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        billSundryTable = new javax.swing.JTable();
        removeRowBillSundry = new javax.swing.JButton();
        insertRowBillSundry = new javax.swing.JButton();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel15 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        otherDetailTA = new javax.swing.JTextArea();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        itemTableScroll = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        insertRowItemTable = new javax.swing.JButton();
        removeRowItemTable = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        accountNameCB = new javax.swing.JComboBox();
        quantityInfo = new javax.swing.JLabel();
        contolLP = new javax.swing.JLayeredPane();
        mainControl = new javax.swing.JLayeredPane();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();

        taxTypeClassCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        taxTypeClassCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fix Amount", "Percentage", "Quantity" }));
        taxTypeClassCB.setBorder(null);
        taxTypeClassCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taxTypeClassCBMouseClicked(evt);
            }
        });
        taxTypeClassCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                taxTypeClassCBItemStateChanged(evt);
            }
        });
        taxTypeClassCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                taxTypeClassCBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                taxTypeClassCBFocusLost(evt);
            }
        });

        natureCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        natureCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Additive", "Subtractive" }));
        natureCB.setBorder(null);
        natureCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                natureCBMouseClicked(evt);
            }
        });
        natureCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                natureCBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                natureCBFocusLost(evt);
            }
        });

        billSundryNatureCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        billSundryNatureCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Additive", "Subtractive" }));
        billSundryNatureCB.setBorder(null);
        billSundryNatureCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billSundryNatureCBMouseClicked(evt);
            }
        });
        billSundryNatureCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                billSundryNatureCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        billSundryNatureCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                billSundryNatureCBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                billSundryNatureCBFocusLost(evt);
            }
        });

        taxTypeClassCBB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        taxTypeClassCBB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fix Amount", "Percentage" }));
        taxTypeClassCBB.setBorder(null);
        taxTypeClassCBB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taxTypeClassCBBMouseClicked(evt);
            }
        });
        taxTypeClassCBB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                taxTypeClassCBBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        taxTypeClassCBB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                taxTypeClassCBBItemStateChanged(evt);
            }
        });
        taxTypeClassCBB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                taxTypeClassCBBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                taxTypeClassCBBFocusLost(evt);
            }
        });

        list.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        saleOrderListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        saleOrderListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Voucher Number", "Date", "Account Number", "Customer Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleOrderListTable.setFocusable(false);
        saleOrderListTable.setRowHeight(23);
        saleOrderListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        saleOrderListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleOrderListTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(saleOrderListTable);
        if (saleOrderListTable.getColumnModel().getColumnCount() > 0) {
            saleOrderListTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            saleOrderListTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            saleOrderListTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            saleOrderListTable.getColumnModel().getColumn(3).setPreferredWidth(300);
            saleOrderListTable.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Search By :");

        searchBy.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        searchBy.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        searchBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Account Number", "Customer Name", "Date", "Voucher Number" }));

        searchKeyTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        searchKeyTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchKeyTFCaretUpdate(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));

        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchKeyTF, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(searchBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKeyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jLayeredPane5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, searchKeyTF});

        jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(searchBy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(searchKeyTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane5)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        quantityTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        quantityTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityTFFocusLost(evt);
            }
        });
        quantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTFKeyTyped(evt);
            }
        });

        rateTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        rateTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateTFFocusLost(evt);
            }
        });
        rateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rateTFKeyTyped(evt);
            }
        });

        atTheRateTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        atTheRateTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                atTheRateTFFocusLost(evt);
            }
        });
        atTheRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                atTheRateTFKeyTyped(evt);
            }
        });

        miscAmountTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        miscAmountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                miscAmountTFFocusLost(evt);
            }
        });
        miscAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                miscAmountTFKeyTyped(evt);
            }
        });

        aRateTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        aRateTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                aRateTFFocusLost(evt);
            }
        });
        aRateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aRateTFKeyTyped(evt);
            }
        });

        amountTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.##########"))));
        amountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountTFFocusLost(evt);
            }
        });
        amountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountTFKeyTyped(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        contentPanel.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Voucher Number :");

        voucherNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), voucherNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Account Number :");

        accountNumberCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        accountNumberCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), accountNumberCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        accountNumberCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountNumberCBMouseEntered(evt);
            }
        });
        accountNumberCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                accountNumberCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Account Name :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Address :");

        addressTA.setColumns(20);
        addressTA.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        addressTA.setRows(5);
        addressTA.setNextFocusableComponent(itemTable);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), addressTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(addressTA);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Date :");

        jLayeredPane2.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light"), 1, true));

        billSundryTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        billSundryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Bill Sundry", "@", "Tax Class", "Nature", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billSundryTable.setColumnSelectionAllowed(true);
        billSundryTable.setPreferredSize(new java.awt.Dimension(2000, 95));
        billSundryTable.setRowHeight(28);
        billSundryTable.setSelectionBackground(new java.awt.Color(51, 102, 255));
        billSundryTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        billSundryTable.setSurrendersFocusOnKeystroke(true);
        billSundryTable.getTableHeader().setReorderingAllowed(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), billSundryTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        billSundryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billSundryTableMouseClicked(evt);
            }
        });
        billSundryTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                billSundryTableFocusGained(evt);
            }
        });
        billSundryTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                billSundryTableKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(billSundryTable);
        billSundryTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (billSundryTable.getColumnModel().getColumnCount() > 0) {
            billSundryTable.getColumnModel().getColumn(0).setPreferredWidth(500);
            billSundryTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            billSundryTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            billSundryTable.getColumnModel().getColumn(3).setPreferredWidth(400);
            billSundryTable.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        removeRowBillSundry.setBackground(new java.awt.Color(255, 255, 255));
        removeRowBillSundry.setForeground(new java.awt.Color(255, 0, 0));
        removeRowBillSundry.setText("Remove Row");
        removeRowBillSundry.setFocusPainted(false);
        removeRowBillSundry.setNextFocusableComponent(addButton);
        removeRowBillSundry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowBillSundryActionPerformed(evt);
            }
        });

        insertRowBillSundry.setBackground(new java.awt.Color(255, 255, 255));
        insertRowBillSundry.setText("Insert Row");
        insertRowBillSundry.setFocusPainted(false);
        insertRowBillSundry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRowBillSundryActionPerformed(evt);
            }
        });

        jLayeredPane6.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLayeredPane6.setOpaque(true);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total Amount :");

        totalAmount.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        totalAmount.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(255, 255, 255));
        totalAmount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalAmount.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(totalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane6.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(totalAmount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(insertRowBillSundry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeRowBillSundry)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insertRowBillSundry)
                        .addComponent(removeRowBillSundry))
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jLayeredPane2.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(removeRowBillSundry, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(insertRowBillSundry, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setText("Other Details :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("(If any) ");

        otherDetailTA.setColumns(20);
        otherDetailTA.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), otherDetailTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(otherDetailTA);

        dateChooserCombo1.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.BOLD, 12));
        dateChooserCombo1.setLocked(true);

        itemTableScroll.setBackground(new java.awt.Color(255, 255, 255));
        itemTableScroll.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        itemTableScroll.setPreferredSize(new java.awt.Dimension(900, 100));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(2000, 10000));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        itemTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemTable.setForeground(new java.awt.Color(0, 0, 255));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Item Code", "Item Name", "Store", "Unit", "Quantity", "Rate", "Item Amount", "Bill Sundry", "Tax Class", "@", "Nature", "Misc. Amount", "Total Row Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemTable.setCellSelectionEnabled(true);
        itemTable.setPreferredSize(new java.awt.Dimension(2000, 10000));
        itemTable.setRowHeight(30);
        itemTable.setSelectionBackground(new java.awt.Color(0, 153, 0));
        itemTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemTable.setSurrendersFocusOnKeystroke(true);
        itemTable.getTableHeader().setReorderingAllowed(false);
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        itemTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemTableFocusGained(evt);
            }
        });
        itemTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemTableKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemTableKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(itemTable);
        itemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (itemTable.getColumnModel().getColumnCount() > 0) {
            itemTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            itemTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            itemTable.getColumnModel().getColumn(2).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(3).setPreferredWidth(400);
            itemTable.getColumnModel().getColumn(4).setPreferredWidth(400);
            itemTable.getColumnModel().getColumn(5).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(6).setPreferredWidth(300);
            itemTable.getColumnModel().getColumn(7).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(8).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(9).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(10).setPreferredWidth(300);
            itemTable.getColumnModel().getColumn(11).setPreferredWidth(500);
            itemTable.getColumnModel().getColumn(12).setPreferredWidth(400);
            itemTable.getColumnModel().getColumn(13).setPreferredWidth(500);
        }

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 2000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 10000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        itemTableScroll.setViewportView(jLayeredPane1);

        jLayeredPane3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLayeredPane3.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Amount :");

        amount.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        amount.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amount.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(amount, javax.swing.JLayeredPane.DEFAULT_LAYER);

        insertRowItemTable.setBackground(new java.awt.Color(255, 255, 255));
        insertRowItemTable.setText("Insert Row");
        insertRowItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRowItemTableActionPerformed(evt);
            }
        });

        removeRowItemTable.setBackground(new java.awt.Color(255, 255, 255));
        removeRowItemTable.setForeground(new java.awt.Color(255, 0, 0));
        removeRowItemTable.setText("Remove Row");
        removeRowItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowItemTableActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));

        accountNameCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        accountNameCB.setBorder(null);
        accountNameCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountNameCBMouseEntered(evt);
            }
        });
        accountNameCB.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                accountNameCBPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        quantityInfo.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        quantityInfo.setForeground(new java.awt.Color(0, 204, 0));
        quantityInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addComponent(insertRowItemTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowItemTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accountNumberCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(voucherNumberTF)))
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(accountNameCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountNumberCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insertRowItemTable)
                        .addComponent(removeRowItemTable)
                        .addComponent(quantityInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)))
                        .addGap(58, 58, 58))))
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {accountNumberCB, dateChooserCombo1, jLabel1, jLabel2, jLabel3, jLabel6, voucherNumberTF});

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {insertRowItemTable, removeRowItemTable});

        contentPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(voucherNumberTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(accountNumberCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(dateChooserCombo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(itemTableScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(insertRowItemTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(removeRowItemTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(errorMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(accountNameCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(quantityInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentPanel)
                .addGap(0, 0, 0))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentPanel)
                .addGap(0, 0, 0))
        );

        contolLP.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorder(null);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.setBorder(null);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setBorder(null);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(null);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(null);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainControlLayout = new javax.swing.GroupLayout(mainControl);
        mainControl.setLayout(mainControlLayout);
        mainControlLayout.setHorizontalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainControlLayout.setVerticalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        mainControl.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(saveButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(editButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(printButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contolLPLayout = new javax.swing.GroupLayout(contolLP);
        contolLP.setLayout(contolLPLayout);
        contolLPLayout.setHorizontalGroup(
            contolLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contolLPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        contolLPLayout.setVerticalGroup(
            contolLPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contolLPLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        contolLP.setLayer(mainControl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(contolLP)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contolLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void insertRowBillSundryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRowBillSundryActionPerformed
        new TableUtils().addingBillSundryTableRow(billSundryTable);
    }//GEN-LAST:event_insertRowBillSundryActionPerformed

    private void removeRowBillSundryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowBillSundryActionPerformed
        new TableUtils().removingBillSundryTableRow(billSundryTable);
        calculateTotalAmount();
    }//GEN-LAST:event_removeRowBillSundryActionPerformed

    private void billSundryTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billSundryTableFocusGained
        errorMessage.setOpaque(false);
        errorMessage.setText(null);
    }//GEN-LAST:event_billSundryTableFocusGained

    private void billSundryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billSundryTableMouseClicked
        billSundryTableControl();
    }//GEN-LAST:event_billSundryTableMouseClicked

    private void removeRowItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowItemTableActionPerformed
        int sr = itemTable.getSelectedRow();
        if (sr > -1 && sr < itemTable.getRowCount()) {
            if (itemTable.getModel().getValueAt(sr, 1) != null) {
                int count = 1;
                for (int i = sr + 1; i < itemTable.getRowCount() - 1; i++) {
                    if (itemTable.getModel().getValueAt(i, 1) == null) {
                        count++;
                    } else {
                        break;
                    }
                }
                int[] rows = new int[count];
                for (int i = 0; i < count; i++) {
                    rows[i] = sr + i;
                }
                for (int i = rows.length - 1; i >= 0; i--) {
                    new TableUtils().removingItemTableRows(itemTable, rows[i]);
                }
                updateTotalValueItemTable();
                calculateAmount();
                calculateTotalAmount();
            } else {
                new TableUtils().removingItemTableRows(itemTable, sr);
                updateTotalValueItemTable();
                calculateAmount();
                calculateTotalAmount();
            }
        }

    }//GEN-LAST:event_removeRowItemTableActionPerformed

    private void insertRowItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRowItemTableActionPerformed
        new TableUtils().addingItemTable(itemTable);
    }//GEN-LAST:event_insertRowItemTableActionPerformed

    private void itemTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemTableFocusGained
        errorMessage.setOpaque(false);
        errorMessage.setText(null);
    }//GEN-LAST:event_itemTableFocusGained

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        list.setVisible(false);
        contolLP.setVisible(true);
        container.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        setVoucherNumber(companyCode, conn);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new PurchaseOrderHandler(mainFrame, this).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                if (new PurchaseOrderHandler(mainFrame, this).savePurchaseOrderInfo(this, conn, companyCode)) {
                    if (new PurchaseOrderHandler(mainFrame, this).saveItemOrderInfo(this, conn, companyCode, itemTable)) {
                        if (billSundryTable.getRowCount() > 1) {
                            if (new PurchaseOrderHandler(mainFrame, this).saveBillSundryInfo(this, conn, companyCode, billSundryTable)) {
                                this.enableAllField(false);
                                this.saveOrUpdateControlShow();
                            }
                        } else {
                            this.enableAllField(false);
                            this.saveOrUpdateControlShow();
                        }

                    }
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Voucher number is already exist.");
                voucherNumberTF.requestFocusInWindow();
                voucherNumberTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (voucherNumberTF.getText().equals(String.valueOf(voucherNumber))) {
                if (new PurchaseOrderHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                    if (new PurchaseOrderHandler(mainFrame, this).savePurchaseOrderInfo(this, conn, companyCode)) {
                        if (new PurchaseOrderHandler(mainFrame, this).saveItemOrderInfo(this, conn, companyCode, itemTable)) {
                            if (billSundryTable.getRowCount() > 1) {
                                if (new PurchaseOrderHandler(mainFrame, this).saveBillSundryInfo(this, conn, companyCode, billSundryTable)) {
                                    this.enableAllField(false);
                                    this.saveOrUpdateControlShow();
                                }
                            } else {
                                this.enableAllField(false);
                                this.saveOrUpdateControlShow();
                            }

                        }
                    }

                }

            } else {
                if (new PurchaseOrderHandler(mainFrame, this).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                    if (new PurchaseOrderHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                        if (new PurchaseOrderHandler(mainFrame, this).savePurchaseOrderInfo(this, conn, companyCode)) {
                            if (new PurchaseOrderHandler(mainFrame, this).saveItemOrderInfo(this, conn, companyCode, itemTable)) {
                                if (billSundryTable.getRowCount() > 1) {
                                    if (new PurchaseOrderHandler(mainFrame, this).saveBillSundryInfo(this, conn, companyCode, billSundryTable)) {
                                        this.enableAllField(false);
                                        this.saveOrUpdateControlShow();
                                    }
                                } else {
                                    this.enableAllField(false);
                                    this.saveOrUpdateControlShow();
                                }
                            }
                        }

                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Voucher number is already exist.");
                    voucherNumberTF.requestFocusInWindow();
                    voucherNumberTF.selectAll();
                }
            }
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.clearAllField();
        this.enableAllField(false);
        showCancelControl();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (new PurchaseOrderHandler(mainFrame, this).fetchPurchaseOrderInformation(companyCode, saleOrderListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight());
            container.setVisible(false);
            list.setVisible(true);
            contolLP.setVisible(false);
            backButton.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new PurchaseOrderHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumberTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

    }//GEN-LAST:event_printButtonActionPerformed

    private void saleOrderListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleOrderListTableMouseClicked
        if (saleOrderListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && saleOrderListTable.getSelectedRow() > -1) {
                voucherNumber = saleOrderListTable.getValueAt(saleOrderListTable.getSelectedRow(), 1).toString();
                if (new PurchaseOrderHandler(mainFrame, this).fetchDataOfPurchaseOrder(companyCode, voucherNumber, this, conn)) {
                    if (new PurchaseOrderHandler(mainFrame, this).fetchItemDetail(companyCode, voucherNumber, itemTable, this, conn)) {
                        if (new PurchaseOrderHandler(mainFrame, this).fetchBillSundryDetail(companyCode, voucherNumber, billSundryTable, this, conn)) {
                            list.setVisible(false);
                            container.setVisible(true);
                            contolLP.setVisible(true);
                            this.remove(list);
                            enableAllField(true);
                            showEditOrListControl();
                        }
                    }
                }
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_saleOrderListTableMouseClicked

    private void taxTypeClassCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_taxTypeClassCBItemStateChanged
        if (itemTable.getSelectedRow() > -1) {
            itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 10);
            itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 12);
            if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) != null) {
                updateItemBillSundry(itemTable.getSelectedRow());
            }
        }
    }//GEN-LAST:event_taxTypeClassCBItemStateChanged

    private void taxTypeClassCBBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_taxTypeClassCBBItemStateChanged
        if (billSundryTable.getSelectedRow() > -1) {
            billSundryTable.getModel().setValueAt(null, billSundryTable.getSelectedRow(), 1);
            billSundryTable.getModel().setValueAt(null, billSundryTable.getSelectedRow(), 4);
            updateTotalValueItemTable();
        }
    }//GEN-LAST:event_taxTypeClassCBBItemStateChanged

    private void taxTypeClassCBBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_taxTypeClassCBBPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_taxTypeClassCBBPopupMenuWillBecomeInvisible

    private void billSundryNatureCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_billSundryNatureCBPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_billSundryNatureCBPopupMenuWillBecomeInvisible

    private void quantityTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTFKeyTyped
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 1) == null || itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 4) == null) {
            evt.consume();
        } else {
            if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }
            } else if (evt.getKeyChar() == '.') {
                if (quantityTF.getText().isEmpty()) {
                    evt.consume();
                } else if (quantityTF.getText().contains(".")) {
                    evt.consume();
                }
            }
        }
    }//GEN-LAST:event_quantityTFKeyTyped

    private void atTheRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atTheRateTFKeyTyped
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) == null || itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 9) == null) {
            evt.consume();
        } else {
            switch (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 9).toString()) {
                case "Fix Amount":
                    evt.consume();
                    break;
                default:
                    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                        if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                            Toolkit.getDefaultToolkit().beep();
                            evt.consume();
                        }
                    } else if (evt.getKeyChar() == '.') {
                        if (atTheRateTF.getText().isEmpty()) {
                            evt.consume();
                        } else if (atTheRateTF.getText().contains(".")) {
                            evt.consume();
                        }
                    }
                    break;
            }
        }
    }//GEN-LAST:event_atTheRateTFKeyTyped

    private void miscAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_miscAmountTFKeyTyped
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) == null || itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 9) == null) {
            evt.consume();
        } else {
            switch (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 9).toString()) {
                case "Fix Amount":
                    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                        if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                            Toolkit.getDefaultToolkit().beep();
                            evt.consume();
                        }
                    } else if (evt.getKeyChar() == '.') {
                        if (miscAmountTF.getText().isEmpty()) {
                            evt.consume();
                        } else if (miscAmountTF.getText().contains(".")) {
                            evt.consume();
                        }
                    }
                    break;
                case "Percentage":
                    evt.consume();
                    break;
                case "Quantity":
                    evt.consume();
                    break;
            }
        }
    }//GEN-LAST:event_miscAmountTFKeyTyped

    private void aRateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aRateTFKeyTyped
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) == null || billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 2) == null) {
            evt.consume();
        } else {
            switch (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 2).toString()) {
                case "Fix Amount":
                    evt.consume();
                    break;
                case "Percentage":
                    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                        if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                            Toolkit.getDefaultToolkit().beep();
                            evt.consume();
                        }
                    } else if (evt.getKeyChar() == '.') {
                        if (aRateTF.getText().isEmpty()) {
                            evt.consume();
                        } else if (aRateTF.getText().contains(".")) {
                            evt.consume();
                        }
                    }
                    break;
            }
        }
    }//GEN-LAST:event_aRateTFKeyTyped

    private void amountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountTFKeyTyped
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) == null || billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 2) == null) {
            evt.consume();
        } else {
            switch (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 2).toString()) {
                case "Fix Amount":
                    if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                        if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                            Toolkit.getDefaultToolkit().beep();
                            evt.consume();
                        }
                    } else if (evt.getKeyChar() == '.') {
                        if (amountTF.getText().isEmpty()) {
                            evt.consume();
                        } else if (amountTF.getText().contains(".")) {
                            evt.consume();
                        }
                    }
                    break;
                case "Percentage":
                    evt.consume();
                    break;
            }
        }
    }//GEN-LAST:event_amountTFKeyTyped

    private void searchKeyTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchKeyTFCaretUpdate
        TableModel model = saleOrderListTable.getModel();
        sorter = new TableRowSorter<>(model);
        saleOrderListTable.setRowSorter(sorter);
        String text = searchKeyTF.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            switch (searchBy.getSelectedItem().toString()) {
                case "Account Number":
                    sorter.setRowFilter(RowFilter.regexFilter(text, 3));
                    break;
                case "Customer Name":
                    sorter.setRowFilter(RowFilter.regexFilter(text, 4));
                    break;
                case "Date":
                    sorter.setRowFilter(RowFilter.regexFilter(text, 2));
                    break;
                case "Voucher Number":
                    sorter.setRowFilter(RowFilter.regexFilter(text, 1));
                    break;

            }

        }

    }//GEN-LAST:event_searchKeyTFCaretUpdate

    private void itemTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            quantityTF.setEnabled(false);
            rateTF.setEnabled(false);
            taxTypeClassCB.setEnabled(false);
            natureCB.setEnabled(false);
            atTheRateTF.setEnabled(false);
            miscAmountTF.setEnabled(false);
            itemTableControl();
        }
    }//GEN-LAST:event_itemTableKeyTyped

    private void accountNumberCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountNumberCBMouseEntered
        new FetchVoucherData().fetchAccountNoSale(mainFrame, accountNumberCB, companyCode, conn);
    }//GEN-LAST:event_accountNumberCBMouseEntered

    private void accountNumberCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_accountNumberCBPopupMenuWillBecomeInvisible
        retriveAccountName();
    }//GEN-LAST:event_accountNumberCBPopupMenuWillBecomeInvisible

    private void accountNameCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountNameCBMouseEntered
        new FetchVoucherData().fetchAccountNameSale(mainFrame, accountNameCB, companyCode, conn);
    }//GEN-LAST:event_accountNameCBMouseEntered

    private void accountNameCBPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_accountNameCBPopupMenuWillBecomeInvisible
        retriveAccountNumber();
    }//GEN-LAST:event_accountNameCBPopupMenuWillBecomeInvisible

    private void itemTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemTableKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (itemTable.getSelectedColumn() == 4) {
                    itemTableScroll.getHorizontalScrollBar().setValue(0);
                } else if (itemTable.getSelectedColumn() == 8) {
                    itemTableScroll.getHorizontalScrollBar().setValue(500);
                } else if (itemTable.getSelectedColumn() == 12) {
                    itemTableScroll.getHorizontalScrollBar().setValue(1000);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (itemTable.getSelectedColumn() == 4) {
                    itemTableScroll.getHorizontalScrollBar().setValue(400);
                } else if (itemTable.getSelectedColumn() == 8) {
                    itemTableScroll.getHorizontalScrollBar().setValue(1000);
                } else if (itemTable.getSelectedColumn() == 12) {
                    itemTableScroll.getHorizontalScrollBar().setValue(1600);
                }
                break;
            case KeyEvent.VK_UP:
                if (itemTable.getSelectedRow() > -1) {
                    int i = itemTable.getSelectedRow();
                    itemTableScroll.getVerticalScrollBar().setValue(i * 25);

                }
                break;
            case KeyEvent.VK_DOWN:
                if (itemTable.getSelectedRow() > -1) {
                    int i = itemTable.getSelectedRow();
                    if (i != 0 && i % 5 == 0) {
                        itemTableScroll.getVerticalScrollBar().setValue(++i * 25);
                    }
                }
                break;
        }
    }//GEN-LAST:event_itemTableKeyPressed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked
        itemTableControl();
    }//GEN-LAST:event_itemTableMouseClicked

    private void quantityTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityTFFocusLost
        int i = itemTable.getSelectedRow();
        updateItemAmount(i);
        updateTotalValueItemTable();
        calculateAmount();
        quantityTF.setEnabled(false);
    }//GEN-LAST:event_quantityTFFocusLost

    private void rateTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateTFFocusLost
        quantityTFFocusLost(evt);
        rateTF.setEnabled(false);
    }//GEN-LAST:event_rateTFFocusLost

    private void rateTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateTFKeyTyped
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 1) == null || itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 4) == null) {
            evt.consume();
        } else {
            if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
                if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                    Toolkit.getDefaultToolkit().beep();
                    evt.consume();
                }
            } else if (evt.getKeyChar() == '.') {
                if (rateTF.getText().isEmpty()) {
                    evt.consume();
                } else if (rateTF.getText().contains(".")) {
                    evt.consume();
                }
            }
        }
    }//GEN-LAST:event_rateTFKeyTyped

    private void atTheRateTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atTheRateTFFocusLost
        updateItemBillSundry(itemTable.getSelectedRow());
        updateTotalValueItemTable();
        calculateAmount();
        atTheRateTF.setEnabled(false);
    }//GEN-LAST:event_atTheRateTFFocusLost

    private void miscAmountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_miscAmountTFFocusLost
        updateItemBillSundry(itemTable.getSelectedRow());
        updateTotalValueItemTable();
        calculateAmount();
        miscAmountTF.setEnabled(false);
    }//GEN-LAST:event_miscAmountTFFocusLost

    private void taxTypeClassCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taxTypeClassCBFocusLost
        calculateAmount();
        taxTypeClassCB.setEnabled(false);
    }//GEN-LAST:event_taxTypeClassCBFocusLost

    private void natureCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_natureCBFocusLost
        updateTotalValueItemTable();
        calculateAmount();
        natureCB.setEnabled(false);
    }//GEN-LAST:event_natureCBFocusLost

    private void taxTypeClassCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taxTypeClassCBFocusGained
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) != null) {
            taxTypeClassCB.setEnabled(true);
        } else {
            taxTypeClassCB.setEnabled(false);
        }
    }//GEN-LAST:event_taxTypeClassCBFocusGained

    private void taxTypeClassCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTypeClassCBMouseClicked
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) != null) {
            taxTypeClassCB.setEnabled(true);
        } else {
            taxTypeClassCB.setEnabled(false);
        }
    }//GEN-LAST:event_taxTypeClassCBMouseClicked

    private void natureCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_natureCBMouseClicked
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) != null) {
            natureCB.setEnabled(true);
        } else {
            natureCB.setEnabled(false);
        }
    }//GEN-LAST:event_natureCBMouseClicked

    private void natureCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_natureCBFocusGained
        if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 8) != null) {
            natureCB.setEnabled(true);
        } else {
            natureCB.setEnabled(false);
        }
    }//GEN-LAST:event_natureCBFocusGained

    private void billSundryTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billSundryTableKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            aRateTF.setEnabled(false);
            amountTF.setEnabled(false);
            taxTypeClassCBB.setEnabled(false);
            billSundryNatureCB.setEnabled(false);
            billSundryTableControl();
        }
    }//GEN-LAST:event_billSundryTableKeyTyped

    private void aRateTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aRateTFFocusLost
        updateBillSundry(billSundryTable.getSelectedRow());
        calculateTotalAmount();
    }//GEN-LAST:event_aRateTFFocusLost

    private void amountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTFFocusLost
        updateBillSundry(billSundryTable.getSelectedRow());
        calculateTotalAmount();
    }//GEN-LAST:event_amountTFFocusLost

    private void billSundryNatureCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billSundryNatureCBFocusGained
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) != null) {
            billSundryNatureCB.setEnabled(true);
        } else {
            billSundryNatureCB.setEnabled(false);
        }
    }//GEN-LAST:event_billSundryNatureCBFocusGained

    private void billSundryNatureCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billSundryNatureCBFocusLost

        updateBillSundry(billSundryTable.getSelectedRow());
        calculateTotalAmount();
    }//GEN-LAST:event_billSundryNatureCBFocusLost

    private void billSundryNatureCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billSundryNatureCBMouseClicked
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) != null) {
            billSundryNatureCB.setEnabled(true);
        } else {
            billSundryNatureCB.setEnabled(false);
        }
    }//GEN-LAST:event_billSundryNatureCBMouseClicked

    private void taxTypeClassCBBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taxTypeClassCBBFocusGained
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) != null) {
            taxTypeClassCBB.setEnabled(true);
        } else {
            taxTypeClassCBB.setEnabled(false);
        }
    }//GEN-LAST:event_taxTypeClassCBBFocusGained

    private void taxTypeClassCBBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_taxTypeClassCBBFocusLost
        updateBillSundry(billSundryTable.getSelectedRow());
        calculateTotalAmount();
    }//GEN-LAST:event_taxTypeClassCBBFocusLost

    private void taxTypeClassCBBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taxTypeClassCBBMouseClicked
        if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) != null) {
            taxTypeClassCBB.setEnabled(true);
        } else {
            taxTypeClassCBB.setEnabled(false);
        }
    }//GEN-LAST:event_taxTypeClassCBBMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField aRateTF;
    private javax.swing.JComboBox accountNameCB;
    private javax.swing.JComboBox accountNumberCB;
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressTA;
    private javax.swing.JLabel amount;
    private javax.swing.JFormattedTextField amountTF;
    private javax.swing.JFormattedTextField atTheRateTF;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox billSundryNatureCB;
    private javax.swing.JTable billSundryTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel container;
    private javax.swing.JLayeredPane contentPanel;
    private javax.swing.JLayeredPane contolLP;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton insertRowBillSundry;
    private javax.swing.JButton insertRowItemTable;
    private javax.swing.JTable itemTable;
    private javax.swing.JScrollPane itemTableScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel list;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JFormattedTextField miscAmountTF;
    private javax.swing.JComboBox natureCB;
    private javax.swing.JTextArea otherDetailTA;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel quantityInfo;
    private javax.swing.JFormattedTextField quantityTF;
    private javax.swing.JFormattedTextField rateTF;
    private javax.swing.JButton removeRowBillSundry;
    private javax.swing.JButton removeRowItemTable;
    private javax.swing.JTable saleOrderListTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox searchBy;
    private javax.swing.JTextField searchKeyTF;
    private javax.swing.JComboBox taxTypeClassCB;
    private javax.swing.JComboBox taxTypeClassCBB;
    private javax.swing.JLabel totalAmount;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField voucherNumberTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void showListOfData(String s, JTable table, String companyCode) {
        listOfData = new ListOfData(mainFrame, true, table, companyCode);
        if (s.equalsIgnoreCase("UnitName")) {
            listOfData.setUnitName(primaryUnit);
        }
        listOfData.setTypeOfRate("purchase");
        listOfData.addData(s);
        listOfData.setLocationRelativeTo(mainFrame);
        listOfData.setVisible(true);
        if (s.equalsIgnoreCase("UnitName")) {
            quantityInfo.setText("Quantity Available: " + listOfData.getMaxQuantity());
        }
    }

    /**
     *
     * @param companyCode
     * @param conn
     */
    public void setVoucherNumber(String companyCode, Connection conn) {
        voucherNumberTF.setText(new FetchVoucherData().getNextPurchaseOrderVoucherNo(companyCode, conn));
    }

    private void clearAllField() {
        accountNumberCB.setSelectedIndex(-1);
        accountNameCB.setSelectedIndex(-1);
        addressTA.setText(null);
        voucherNumberTF.setText(null);
        dateChooserCombo1.setSelectedDate(Calendar.getInstance());
        DefaultTableModel model = (DefaultTableModel) itemTable.getModel();
        model.setRowCount(0);
        Object[] data = {null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        model.addRow(data);
        itemTable.setModel(model);
        otherDetailTA.setText(null);
        DefaultTableModel model1 = (DefaultTableModel) billSundryTable.getModel();
        model1.setRowCount(0);
        Object[] data1 = {null, null, null, null};
        model1.addRow(data1);
        billSundryTable.setModel(model1);

    }

    private void enableAllField(boolean b) {
        errorMessage.setEnabled(b);
        jLabel2.setEnabled(b);
        accountNumberCB.setEnabled(b);
        jLabel3.setEnabled(b);
        accountNameCB.setEnabled(b);
        jLabel4.setEnabled(b);
        jScrollPane1.setEnabled(b);
        addressTA.setEnabled(b);
        jLabel1.setEnabled(b);
        voucherNumberTF.setEnabled(b);
        jLabel6.setEnabled(b);
        dateChooserCombo1.setEnabled(b);
        jScrollPane4.setEnabled(b);
        otherDetailTA.setEnabled(b);
        itemTableScroll.setEnabled(b);
        jLayeredPane1.setEnabled(b);
        jScrollPane2.setEnabled(b);
        itemTable.setEnabled(b);
        jLayeredPane3.setEnabled(b);
        jLabel11.setEnabled(b);
        amount.setEnabled(b);
        insertRowItemTable.setEnabled(b);
        removeRowItemTable.setEnabled(b);
        jLayeredPane2.setEnabled(b);
        jScrollPane3.setEnabled(b);
        billSundryTable.setEnabled(b);
        removeRowBillSundry.setEnabled(b);
        insertRowBillSundry.setEnabled(b);
        jLayeredPane6.setEnabled(b);
        jLabel15.setEnabled(b);
        totalAmount.setEnabled(b);
    }

    private boolean validateUserInput() {
        boolean status = false;
        if (accountNumberCB.getSelectedIndex() > -1) {
            if (!voucherNumberTF.getText().isEmpty()) {
                if (itemTable.getRowCount() > 1) {
                    int rowCount = itemTable.getRowCount();
                    for (int row = 0; row < (rowCount - 1); row++) {
                        if (itemTable.getModel().getValueAt(row, 1) != null) {
                            if (itemTable.getModel().getValueAt(row, 4) != null) {
                                if (itemTable.getModel().getValueAt(row, 5) != null) {
                                    if (itemTable.getModel().getValueAt(row, 6) != null) {
                                        if (itemTable.getModel().getValueAt(row, 8) != null) {
                                            if (checkBillSundryValidation(row)) {
                                                status = true;
                                            }
                                        } else {
                                            status = true;
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, select the rate for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                        break;
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, select the quantity for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                    break;
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the unit for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                break;
                            }
                        } else if (itemTable.getModel().getValueAt(row, 8) != null) {
                            boolean check = false;
                            for (int i = row; i >= 0; i--) {
                                if (itemTable.getModel().getValueAt(i, 1) != null) {
                                    check = true;
                                    break;
                                }
                            }
                            if (!check) {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the item code for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                break;
                            } else if (checkBillSundryValidation(row)) {
                                status = true;
                            }

                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the item code for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                            break;
                        }
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Please, enter item information.");
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, enter voucher number.");
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, enter account number number.");
        }

        if (status) {
            if (billSundryTable.getRowCount() > 1) {
                int rowCount = billSundryTable.getRowCount();
                for (int row = 0; row < rowCount - 1; row++) {
                    if (billSundryTable.getModel().getValueAt(row, 0) != null) {
                        if (billSundryTable.getModel().getValueAt(row, 2) != null) {
                            switch (billSundryTable.getModel().getValueAt(row, 2).toString()) {
                                case "Fix Amount":
                                    if (billSundryTable.getModel().getValueAt(row, 4) != null) {
                                        if (billSundryTable.getModel().getValueAt(row, 3) != null) {
                                            status = true;
                                        } else {
                                            status = false;
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, select the nature for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                        }
                                    } else {
                                        status = false;
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Misc. Amount can't be left empty for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                    }
                                    break;
                                case "Percentage":
                                    if (billSundryTable.getModel().getValueAt(row, 1) != null) {
                                        if (billSundryTable.getModel().getValueAt(row, 3) != null) {
                                            status = true;
                                        } else {
                                            status = false;
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, select the nature for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                        }
                                    } else {
                                        status = false;
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("@ can't be left empty for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                                    }
                                    break;
                            }
                        } else {
                            status = false;
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the tax class for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                            break;
                        }
                    } else {
                        status = true;
                    }
                }
            }
        }
        return status;
    }

    private void defaultControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

    }

    private void addControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void saveOrUpdateControlShow() {
        addButton.setEnabled(true);
        saveButton.setEnabled(false);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    private void deleteControlShow() {
        addButton.setEnabled(true);
        saveButton.setEnabled(false);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        deleteButton.setEnabled(false);
    }

    private void showEditOrListControl() {
        addButton.setEnabled(false);
        saveButton.setEnabled(false);
        updateButton.setEnabled(true);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(true);
    }

    private void showCancelControl() {
        addButton.setEnabled(true);
        saveButton.setEnabled(false);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        deleteButton.setEnabled(false);
    }

    /**
     *
     * @return
     */
    public String getAccountNumber() {
        return accountNumberCB.getSelectedItem().toString();
    }

    /**
     *
     * @return
     */
    public String getCustomerName() {
        return accountNameCB.getSelectedItem().toString();
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return addressTA.getText();
    }

    /**
     *
     * @return
     */
    public Timestamp getDateT() {
        Calendar cal = dateChooserCombo1.getSelectedDate();
        Date date = cal.getTime();
        return new Timestamp(date.getTime());
    }

    /**
     *
     * @return
     */
    public String getOtherDetails() {
        return otherDetailTA.getText();
    }

    /**
     *
     * @return
     */
    public String getVoucherNumber() {
        return voucherNumberTF.getText();
    }

    /**
     *
     * @return
     */
    public String getTotalAmount() {
        return totalAmount.getText();
    }

    /**
     *
     * @return
     */
    public String getSumOfRows() {
        return amount.getText();
    }

    /**
     *
     * @param i
     * @param c
     * @return
     */
    public String getItemTableValue(int i, int c) {
        if (itemTable.getModel().getValueAt(i, c) != null) {
            return itemTable.getModel().getValueAt(i, c).toString();
        } else {
            return null;
        }
    }

    /**
     *
     * @param i
     * @param c
     * @return
     */
    public String getBillSundryTableValue(int i, int c) {
        if (billSundryTable.getModel().getValueAt(i, c) != null) {
            return billSundryTable.getModel().getValueAt(i, c).toString();
        } else {
            return null;
        }
    }

    /**
     *
     * @param aLong
     */
    public void setAccountNumber(String aLong) {
        accountNumberCB.setSelectedItem(aLong);
    }

    /**
     *
     * @param string
     */
    public void setCustomerName(String string) {
        accountNameCB.setSelectedItem(string);
    }

    /**
     *
     * @param string
     */
    public void setAddress(String string) {
        addressTA.setText(string);
    }

    /**
     *
     * @param aLong
     */
    public void setVoucherNu(String aLong) {
        voucherNumberTF.setText(String.valueOf(aLong));
    }

    /**
     *
     * @param timestamp
     */
    public void setDatee(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dateChooserCombo1.setSelectedDate(calendar);
    }

    /**
     *
     * @param string
     */
    public void setOtherDetails(String string) {
        otherDetailTA.setText(string);
    }

    /**
     *
     * @param aDouble
     */
    public void setSumOfRows(String aDouble) {
        amount.setText(roundTwoDecimals(Double.valueOf(aDouble)));
    }

    /**
     *
     * @param aDouble
     */
    public void setTotalAmount(String aDouble) {
        totalAmount.setText(roundTwoDecimals(Double.valueOf(aDouble)));
    }

    /**
     *
     * @param i
     */
    public void updateItemBillSundry(int i) {
        double itemAmount = 0.0;
        int rootRow = 0;
        if (i > -1) {
            if (itemTable.getModel().getValueAt(i, 1) != null) {
                if (itemTable.getModel().getValueAt(i, 7) != null) {
                    itemAmount = Double.valueOf(itemTable.getModel().getValueAt(i, 7).toString());
                    rootRow = i;
                }
            } else {
                for (int j = i; j >= 0; j--) {
                    if (itemTable.getModel().getValueAt(j, 1) != null) {
                        if (itemTable.getModel().getValueAt(j, 7) != null) {
                            itemAmount = Double.valueOf(itemTable.getModel().getValueAt(j, 7).toString());
                            rootRow = j;
                        }
                        break;
                    }
                }
            }
        }
        calculateBillSundry(rootRow, itemAmount);
    }

    private void calculateBillSundry(int rootRow, double itemAmount) {
        for (int i = rootRow; i < itemTable.getRowCount(); i++) {
            if (i == rootRow) {
                if (itemTable.getModel().getValueAt(i, 8) != null) {
                    Object taxClass = itemTable.getModel().getValueAt(i, 9);
                    if (taxClass != null) {
                        switch (taxClass.toString()) {
                            case "Percentage":
                                double sundryValue = 0;
                                if (itemTable.getModel().getValueAt(i, 10) != null) {
                                    sundryValue = itemAmount * Double.valueOf(itemTable.getModel().getValueAt(i, 10).toString()) / 100;
                                }
                                itemTable.getModel().setValueAt(roundTwoDecimals(sundryValue), i, 12);
                                break;
                        }
                    }
                }
            } else if (itemTable.getModel().getValueAt(i, 1) == null) {
                if (itemTable.getModel().getValueAt(i, 8) != null) {
                    Object taxClass = itemTable.getModel().getValueAt(i, 9);
                    if (taxClass != null) {
                        switch (taxClass.toString()) {
                            case "Percentage":
                                double sundryValue = 0;
                                if (itemTable.getModel().getValueAt(i, 10) != null) {
                                    sundryValue = itemAmount * Double.valueOf(itemTable.getModel().getValueAt(i, 10).toString()) / 100;
                                }
                                itemTable.getModel().setValueAt(sundryValue, i, 12);
                                break;
                        }
                    }
                }
            } else {
                break;
            }
        }

    }

    private void resetAllRespectiveBillSundry(int seRow) {
        for (int i = seRow; i < itemTable.getRowCount(); i++) {
            if (i == seRow) {
                itemTable.getModel().setValueAt(null, i, 9);
                itemTable.getModel().setValueAt(null, i, 10);
                itemTable.getModel().setValueAt(null, i, 11);
                itemTable.getModel().setValueAt(null, i, 12);
            } else {
                if (itemTable.getModel().getValueAt(i, 1) == null) {
                    itemTable.getModel().setValueAt(null, i, 9);
                    itemTable.getModel().setValueAt(null, i, 10);
                    itemTable.getModel().setValueAt(null, i, 11);
                    itemTable.getModel().setValueAt(null, i, 12);
                } else {
                    break;
                }
            }
        }
        updateTotalValueItemTable();
        calculateAmount();
    }

    /**
     *
     */
    public void updateTotalValueItemTable() {
        int count = 0;
        double rowAmount = 0;
        for (int i = 0; i < itemTable.getRowCount(); i++) {
            if (itemTable.getModel().getValueAt(i, 1) != null) {
                rowAmount = 0;
                count = i;
                if (itemTable.getModel().getValueAt(i, 7) != null) {
                    rowAmount = Double.valueOf(itemTable.getModel().getValueAt(i, 7).toString());
                }
                if (itemTable.getModel().getValueAt(i, 8) != null) {
                    if (itemTable.getModel().getValueAt(i, 11) != null) {
                        if (itemTable.getModel().getValueAt(i, 12) != null) {
                            if (itemTable.getModel().getValueAt(i, 9) != null) {
                                if (!itemTable.getModel().getValueAt(i, 9).toString().equalsIgnoreCase("Quantity")) {
                                    switch (itemTable.getModel().getValueAt(i, 11).toString()) {
                                        case "Additive":
                                            String temp = itemTable.getModel().getValueAt(i, 12).toString();
                                            if (!temp.isEmpty()) {
                                                rowAmount = rowAmount + Double.valueOf(temp);
                                            }
                                            break;
                                        case "Subtractive":
                                            String temp1 = itemTable.getModel().getValueAt(i, 12).toString();
                                            if (!temp1.isEmpty()) {
                                                rowAmount = rowAmount - Double.valueOf(temp1);
                                            }
                                            break;
                                    }
                                }
                            }

                        }
                    }
                }
            } else {
                if (itemTable.getModel().getValueAt(i, 8) != null) {
                    if (itemTable.getModel().getValueAt(i, 11) != null) {
                        if (itemTable.getModel().getValueAt(i, 12) != null) {
                            if (itemTable.getModel().getValueAt(i, 9) != null) {
                                if (!itemTable.getModel().getValueAt(i, 9).toString().equalsIgnoreCase("Quantity")) {
                                    switch (itemTable.getModel().getValueAt(i, 11).toString()) {
                                        case "Additive":
                                            String temp = itemTable.getModel().getValueAt(i, 12).toString();
                                            if (!temp.isEmpty()) {
                                                rowAmount = rowAmount + Double.valueOf(temp);
                                            }
                                            break;
                                        case "Subtractive":
                                            String temp1 = itemTable.getModel().getValueAt(i, 12).toString();
                                            if (!temp1.isEmpty()) {
                                                rowAmount = rowAmount - Double.valueOf(temp1);
                                            }
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            itemTable.getModel().setValueAt(roundTwoDecimals(rowAmount), count, 13);
        }
    }

    /**
     *
     */
    public void calculateAmount() {
        itemTableTotalAmount = 0;
        for (int i = 0; i < itemTable.getRowCount(); i++) {
            if (itemTable.getModel().getValueAt(i, 13) != null) {
                itemTableTotalAmount = itemTableTotalAmount + Double.valueOf(itemTable.getModel().getValueAt(i, 13).toString());
            }
        }
        amount.setText(roundTwoDecimals(itemTableTotalAmount));
        calculateTotalAmount();
    }

    /**
     *
     * @param i
     */
    public void updateBillSundry(int i) {
        if (billSundryTable.getModel().getValueAt(i, 0) != null) {
            Object taxClass = billSundryTable.getModel().getValueAt(i, 2);
            if (taxClass != null) {
                switch (taxClass.toString()) {
                    case "Percentage":
                        double sundryValue = 0;
                        double total = 0;
                        if (amount.getText() != null) {
                            total = Double.valueOf(amount.getText());
                        }
                        if (billSundryTable.getModel().getValueAt(i, 1) != null) {
                            sundryValue = total * Double.valueOf(billSundryTable.getModel().getValueAt(i, 1).toString()) / 100;
                        }
                        billSundryTable.getModel().setValueAt(roundTwoDecimals(sundryValue), i, 4);
                        break;
                }
            }
        }

    }

    /**
     *
     */
    public void calculateTotalAmount() {
        if (!amount.getText().isEmpty()) {
            totAmount = Double.valueOf(amount.getText());
        }
        for (int i = 0; i < billSundryTable.getRowCount(); i++) {
            if (billSundryTable.getModel().getValueAt(i, 0) != null) {
                if (billSundryTable.getModel().getValueAt(i, 4) != null) {
                    if (billSundryTable.getModel().getValueAt(i, 3) != null) {
                        switch (billSundryTable.getModel().getValueAt(i, 3).toString()) {
                            case "Additive":
                                String temp = billSundryTable.getModel().getValueAt(i, 4).toString();
                                if (!temp.isEmpty()) {
                                    totAmount = totAmount + Double.valueOf(temp);
                                }

                                break;
                            case "Subtractive":
                                String temp1 = billSundryTable.getModel().getValueAt(i, 4).toString();
                                if (!temp1.isEmpty()) {
                                    totAmount = totAmount - Double.valueOf(temp1);
                                }
                        }
                    }
                }
            }
        }
        totalAmount.setText(roundTwoDecimals(totAmount));
    }

    private boolean checkBillSundryValidation(int row) {
        boolean status = false;
        if (itemTable.getModel().getValueAt(row, 9) != null) {
            switch (itemTable.getModel().getValueAt(row, 9).toString()) {
                case "Fix Amount":
                    if (itemTable.getModel().getValueAt(row, 11) != null) {
                        if (itemTable.getModel().getValueAt(row, 12) != null) {
                            status = true;
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the misc. amount for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the nature for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                    }
                    break;
                case "Percentage":
                    if (itemTable.getModel().getValueAt(row, 10) != null) {
                        if (itemTable.getModel().getValueAt(row, 11) != null) {
                            status = true;
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the nature for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the @ for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                    }
                    break;
                case "Quantity":
                    if (itemTable.getModel().getValueAt(row, 10) != null) {
                        if (itemTable.getModel().getValueAt(row, 11) != null) {
                            status = true;
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the nature for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the @ for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
                    }
                    break;
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, select the tax class for row " + itemTable.getModel().getValueAt(row, 0).toString() + ".");
        }
        return status;
    }

    /**
     *
     * @param i
     */
    public void updateItemAmount(int i) {
        if (i > -1) {
            if (itemTable.getModel().getValueAt(i, 1) != null) {
                if (itemTable.getModel().getValueAt(i, 4) != null) {
                    String uName = itemTable.getModel().getValueAt(i, 4).toString();
                    if (itemTable.getModel().getValueAt(i, 5) != null) {
                        double quantity = Double.valueOf(itemTable.getModel().getValueAt(i, 5).toString());
                        if (itemTable.getValueAt(i, 7) != null) {
                            totalItemAmount = itemTable.getValueAt(i, 7).toString();
                        }
                        if (itemTable.getValueAt(i, 6) != null) {
                            double price = Double.valueOf(itemTable.getValueAt(i, 6).toString());
                            if (getUnitType(uName, conn).equalsIgnoreCase("Single")) {
                                itemTable.getModel().setValueAt(roundTwoDecimals(quantity * price), i, 7);
                            } else {
                                int j = 0;
                                double itemAmount = quantity * price;
                                String perUnit = new FetchVoucherData().getPerUnit(uName, conn);
                                itemAmount = itemAmount * Double.valueOf(perUnit);
                                String primaryU = new FetchVoucherData().getPrimaryUnit(uName, conn);
                                for (;;) {
                                    if (getUnitType(primaryU, conn).equalsIgnoreCase("Single")) {
                                        break;
                                    } else {
                                        perUnit = new FetchVoucherData().getPerUnit(primaryU, conn);
                                        itemAmount = itemAmount * Double.valueOf(perUnit);
                                        primaryU = new FetchVoucherData().getPrimaryUnit(primaryU, conn);

                                    }

                                    j++;
                                    if (j > 20) {
                                        break;
                                    }
                                }
                                itemTable.getModel().setValueAt(roundTwoDecimals(itemAmount), i, 7);
                            }
                        }
                    }
                }
            }
            if (totalItemAmount != null) {
                if (itemTable.getValueAt(i, 7) != null) {
                    if (!totalItemAmount.equalsIgnoreCase(itemTable.getValueAt(i, 7).toString())) {
                        updateItemBillSundry(i);
                    }
                }

            }
        }
    }

    /**
     *
     * @param d
     * @return
     */
    public String roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    private void retriveAccountNumber() {
        if (accountNameCB.getSelectedIndex() > -1) {
            accountNumberCB.setSelectedItem(new FetchVoucherData().getAccountNo(accountNameCB.getSelectedItem().toString(), companyCode, conn));
        } else {
            accountNumberCB.setSelectedIndex(-1);
        }
    }

    private void retriveAccountName() {
        if (accountNumberCB.getSelectedIndex() > -1) {
            accountNameCB.setSelectedItem(new FetchVoucherData().getAccountName(accountNumberCB.getSelectedItem().toString(), companyCode, conn));
        } else {
            accountNameCB.setSelectedIndex(-1);
        }
    }

    private void itemTableControl() {
        errorMessage.setText(null);
        errorMessage.setOpaque(false);
        selectedRow = itemTable.getSelectedRow();
        if (selectedRow > -1) {
            if (itemTable.getSelectedRow() == itemTable.getRowCount() - 1) {
                new TableUtils().addingItemTable(itemTable);
            } else if (itemTable.getSelectedColumn() == 1) {
                updateTotalValueItemTable();
                calculateAmount();
                if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                    itemCode = itemTable.getModel().getValueAt(selectedRow, 1).toString();

                }
                showListOfData("ItemCode", itemTable, companyCode);
                if (itemCode != null) {
                    if (!itemCode.equalsIgnoreCase(itemTable.getModel().getValueAt(selectedRow, 1).toString())) {
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 4);
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 5);
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 7);
                        resetAllRespectiveBillSundry(selectedRow);
                        quantityInfo.setText(null);
                    }
                } else if (itemTable.getModel().getValueAt(selectedRow, 8) != null) {
                    if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                        resetAllRespectiveBillSundry(selectedRow);
                    }
                }
            } else if (itemTable.getSelectedColumn() == 2) {
                updateTotalValueItemTable();
                calculateAmount();
                if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                    itemCode = itemTable.getModel().getValueAt(selectedRow, 1).toString();
                }
                showListOfData("ItemName", itemTable, companyCode);
                if (itemCode != null) {
                    if (!itemCode.equalsIgnoreCase(itemTable.getModel().getValueAt(selectedRow, 1).toString())) {
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 4);
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 5);
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 7);
                        resetAllRespectiveBillSundry(selectedRow);
                        quantityInfo.setText(null);
                    }
                } else if (itemTable.getModel().getValueAt(selectedRow, 8) != null) {
                    if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                        resetAllRespectiveBillSundry(selectedRow);
                    }
                }
            } else if (itemTable.getSelectedColumn() == 4) {
                updateTotalValueItemTable();
                calculateAmount();
                if (itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 1) != null) {
                    primaryUnit = new PurchaseOrderHandler(mainFrame, this).getUnitName(itemTable.getModel().getValueAt(itemTable.getSelectedRow(), 1).toString(), companyCode, conn);
                    if (itemTable.getModel().getValueAt(selectedRow, 4) != null) {
                        unitName = itemTable.getModel().getValueAt(selectedRow, 4).toString();
                    }
                    showListOfData("UnitName", itemTable, companyCode);
                    if (unitName != null) {
                        if (!unitName.equalsIgnoreCase(itemTable.getModel().getValueAt(selectedRow, 4).toString())) {
                            itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 5);
                            itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 7);
                            resetAllRespectiveBillSundry(selectedRow);
                        }
                    }
                }
            } else if (itemTable.getSelectedColumn() == 8) {
                updateTotalValueItemTable();
                calculateAmount();
                if (itemTable.getModel().getValueAt(selectedRow, 8) != null) {
                    billsundry = itemTable.getModel().getValueAt(selectedRow, 8).toString();
                }
                showListOfData("BillSundry", itemTable, companyCode);
                if (billsundry != null) {
                    if (!billsundry.equalsIgnoreCase(itemTable.getModel().getValueAt(selectedRow, 8).toString())) {
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 10);
                        itemTable.getModel().setValueAt(null, itemTable.getSelectedRow(), 12);
                    }
                }
            } else if (itemTable.getSelectedColumn() == 5) {
                if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                    if (itemTable.getModel().getValueAt(selectedRow, 4) != null) {
                        quantityTF.setEnabled(true);
                    }
                }
            } else if (itemTable.getSelectedColumn() == 6) {
                if (itemTable.getModel().getValueAt(selectedRow, 1) != null) {
                    rateTF.setEnabled(true);
                }
            } else if (itemTable.getSelectedColumn() == 10) {
                if (itemTable.getModel().getValueAt(selectedRow, 8) != null) {
                    if (itemTable.getModel().getValueAt(selectedRow, 9) != null) {
                        if (!itemTable.getModel().getValueAt(selectedRow, 9).toString().equalsIgnoreCase("Fix Amount")) {
                            atTheRateTF.setEnabled(true);
                        }
                    }
                }
            } else if (itemTable.getSelectedColumn() == 12) {
                if (itemTable.getModel().getValueAt(selectedRow, 8) != null) {
                    if (itemTable.getModel().getValueAt(selectedRow, 9) != null) {
                        if (itemTable.getModel().getValueAt(selectedRow, 9).toString().equalsIgnoreCase("Fix Amount")) {
                            miscAmountTF.setEnabled(true);
                        }
                    }
                }
            }

        }
    }

    private void billSundryTableControl() {
        errorMessage.setText(null);
        errorMessage.setOpaque(false);
        selectedRow1 = billSundryTable.getSelectedRow();
        if (selectedRow1 > -1) {
            if (selectedRow1 == billSundryTable.getRowCount() - 1) {
                new TableUtils().addingBillSundryTableRow(billSundryTable);
            } else if (billSundryTable.getSelectedRow() > -1) {
                if (billSundryTable.getSelectedColumn() == 0) {
                    if (billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0) != null) {
                        billOverallSUndry = billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0).toString();
                    }
                    showListOfData("BillSundry", billSundryTable, companyCode);
                    if (billOverallSUndry != null) {
                        if (!billOverallSUndry.equalsIgnoreCase(billSundryTable.getModel().getValueAt(billSundryTable.getSelectedRow(), 0).toString())) {
                            billSundryTable.getModel().setValueAt(null, billSundryTable.getSelectedRow(), 1);
                            billSundryTable.getModel().setValueAt(null, billSundryTable.getSelectedRow(), 4);
                        }
                    }
                    updateBillSundry(billSundryTable.getSelectedRow());
                    calculateTotalAmount();
                } else if (billSundryTable.getSelectedColumn() == 1) {
                    if (billSundryTable.getModel().getValueAt(selectedRow1, 0) != null) {
                        if (billSundryTable.getModel().getValueAt(selectedRow1, 2) != null) {
                            if (!billSundryTable.getModel().getValueAt(selectedRow1, 2).toString().equalsIgnoreCase("Fix Amount")) {
                                aRateTF.setEnabled(true);
                            }
                        }
                    }
                } else if (billSundryTable.getSelectedColumn() == 4) {
                    if (billSundryTable.getModel().getValueAt(selectedRow1, 0) != null) {
                        if (billSundryTable.getModel().getValueAt(selectedRow1, 2) != null) {
                            if (billSundryTable.getModel().getValueAt(selectedRow1, 2).toString().equalsIgnoreCase("Fix Amount")) {
                                amountTF.setEnabled(true);
                            }
                        }
                    }
                }
            }

        }
    }

    private String getUnitType(String unitName, Connection conn) {
        return new FetchVoucherData().getUnitType(unitName, conn);
    }

}
