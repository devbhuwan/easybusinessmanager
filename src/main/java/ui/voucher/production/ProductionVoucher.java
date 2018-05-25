package ui.voucher.production;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.feature.TableUI;
import ui.voucher.TableUtils;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.ListOfData;
import ui.voucher.production.utils.ProductionHandler;

/**
 *
 * @author Vimal
 */
public class ProductionVoucher extends javax.swing.JPanel {

    private ListOfData listOfData;
    private int selectedRow;
    private final MainFrame mainFrame;
    private final String companyCode;
    private String voucherNumber;
    private final Connection conn;
    private String itemCodeGenerated;
    private String itemCodeConsumed;
    private String primaryUnitCons;
    private String unitNameGenerated;
    private String unitNameConsumed;
    private String itemNameGenerated;
    private String primaryUnitGen;
    private String tableType;

    /**
     * Creates new form ProductionVoucher
     *
     * @param mainFrame
     * @param companyC
     * @param co
     */
    public ProductionVoucher(MainFrame mainFrame, String companyC, Connection co) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyC;
        this.conn = co;
        dateChooserCombo1.setFormat(1);
        errorMessage.setOpaque(false);
        defaultControlShow();
        printButton.setEnabled(false);
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setOpaque(false);
                errorMessage.setText(null);
            }
        });
        itemGeneratedTable.setTableHeader(new TableUI().getTableHeaderUI(itemGeneratedTable));
        saleOrderListTable.setTableHeader(new TableUI().getTableHeaderUI(saleOrderListTable));
        itemConsumedTable.setTableHeader(new TableUI().getTableHeaderUI(itemConsumedTable));
        itemGeneratedTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(quantityItemGenTF));
        itemGeneratedTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(rateGenTF));
        itemGeneratedTable.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(expiryDateForGen));
        itemConsumedTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(quantityItemConsTF));
        itemConsumedTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(rateConTF));
        itemConsumedTable.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(expiryDateForCon));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        list = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        saleOrderListTable = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        quantityItemGenTF = new javax.swing.JTextField();
        quantityItemConsTF = new javax.swing.JTextField();
        rateGenTF = new javax.swing.JTextField();
        rateConTF = new javax.swing.JTextField();
        expiryDateForCon = new javax.swing.JTextField();
        expiryDateForGen = new javax.swing.JTextField();
        controlLayer = new javax.swing.JLayeredPane();
        mainControl = new javax.swing.JLayeredPane();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        voucherNumberTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        narrationTA = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemGeneratedTable = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        amountGenerated = new javax.swing.JLabel();
        insertRowItemTable = new javax.swing.JButton();
        removeRowItemTable = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemConsumedTable = new javax.swing.JTable();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel12 = new javax.swing.JLabel();
        amountConsumed = new javax.swing.JLabel();
        insertRowItemTable1 = new javax.swing.JButton();
        removeRowItemTable1 = new javax.swing.JButton();
        quantityInfoGen = new javax.swing.JLabel();
        quantityInfoCon = new javax.swing.JLabel();

        list.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        saleOrderListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        saleOrderListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Voucher Number", "Date", "Narration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            saleOrderListTable.getColumnModel().getColumn(3).setPreferredWidth(800);
        }

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Search By :");

        jComboBox1.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Account Number", "Customer Name", "Date", "Voucher Number" }));
        jComboBox1.setSelectedIndex(-1);

        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

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
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
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
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jLayeredPane5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, jTextField1});

        jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
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

        quantityItemGenTF.setText("jTextField2");
        quantityItemGenTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                quantityItemGenTFCaretUpdate(evt);
            }
        });
        quantityItemGenTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityItemGenTFFocusLost(evt);
            }
        });
        quantityItemGenTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityItemGenTFKeyTyped(evt);
            }
        });

        quantityItemConsTF.setText("jTextField2");
        quantityItemConsTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                quantityItemConsTFCaretUpdate(evt);
            }
        });
        quantityItemConsTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityItemConsTFFocusLost(evt);
            }
        });
        quantityItemConsTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityItemConsTFKeyTyped(evt);
            }
        });

        rateGenTF.setText("jTextField2");
        rateGenTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                rateGenTFCaretUpdate(evt);
            }
        });
        rateGenTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateGenTFFocusLost(evt);
            }
        });
        rateGenTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rateGenTFKeyTyped(evt);
            }
        });

        rateConTF.setText("jTextField2");
        rateConTF.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                rateConTFCaretUpdate(evt);
            }
        });
        rateConTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateConTFFocusLost(evt);
            }
        });
        rateConTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rateConTFKeyTyped(evt);
            }
        });

        expiryDateForCon.setText("jTextField2");

        expiryDateForGen.setText("jTextField2");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(914, 565));

        controlLayer.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

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

        javax.swing.GroupLayout controlLayerLayout = new javax.swing.GroupLayout(controlLayer);
        controlLayer.setLayout(controlLayerLayout);
        controlLayerLayout.setHorizontalGroup(
            controlLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlLayerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlLayerLayout.setVerticalGroup(
            controlLayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlLayerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        controlLayer.setLayer(mainControl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        contentPanel.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Voucher Number :");

        voucherNumberTF.setEditable(false);
        voucherNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), voucherNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Narration :");

        narrationTA.setColumns(20);
        narrationTA.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        narrationTA.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), narrationTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(narrationTA);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Date :");

        dateChooserCombo1.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.BOLD, 12));
        dateChooserCombo1.setLocked(true);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Item Generated", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"))); // NOI18N

        itemGeneratedTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        itemGeneratedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Item Code", "Item Name", "Store", "Unit", "Quantity", "Rate", "Item Amount", "Expiry Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemGeneratedTable.setCellSelectionEnabled(true);
        itemGeneratedTable.setPreferredSize(new java.awt.Dimension(450, 200));
        itemGeneratedTable.setRowHeight(30);
        itemGeneratedTable.setSelectionBackground(new java.awt.Color(0, 102, 102));
        itemGeneratedTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemGeneratedTable.getTableHeader().setReorderingAllowed(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemGeneratedTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        itemGeneratedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemGeneratedTableMouseClicked(evt);
            }
        });
        itemGeneratedTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemGeneratedTableFocusGained(evt);
            }
        });
        itemGeneratedTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemGeneratedTableKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(itemGeneratedTable);
        itemGeneratedTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (itemGeneratedTable.getColumnModel().getColumnCount() > 0) {
            itemGeneratedTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            itemGeneratedTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            itemGeneratedTable.getColumnModel().getColumn(2).setPreferredWidth(500);
            itemGeneratedTable.getColumnModel().getColumn(3).setPreferredWidth(500);
            itemGeneratedTable.getColumnModel().getColumn(4).setPreferredWidth(400);
            itemGeneratedTable.getColumnModel().getColumn(5).setPreferredWidth(300);
            itemGeneratedTable.getColumnModel().getColumn(6).setPreferredWidth(300);
            itemGeneratedTable.getColumnModel().getColumn(7).setPreferredWidth(500);
            itemGeneratedTable.getColumnModel().getColumn(8).setPreferredWidth(400);
        }

        jLayeredPane3.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light"), 1, true));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Amount :");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));

        amountGenerated.setBackground(new java.awt.Color(0, 204, 255));
        amountGenerated.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        amountGenerated.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountGenerated.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));
        amountGenerated.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(amountGenerated, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(amountGenerated, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(amountGenerated, javax.swing.JLayeredPane.DEFAULT_LAYER);

        insertRowItemTable.setBackground(new java.awt.Color(255, 255, 255));
        insertRowItemTable.setText("Insert Row");
        insertRowItemTable.setFocusPainted(false);
        insertRowItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRowItemTableActionPerformed(evt);
            }
        });

        removeRowItemTable.setBackground(new java.awt.Color(255, 255, 255));
        removeRowItemTable.setForeground(new java.awt.Color(255, 0, 0));
        removeRowItemTable.setText("Remove Row");
        removeRowItemTable.setFocusPainted(false);
        removeRowItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowItemTableActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Item Consumed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"))); // NOI18N

        itemConsumedTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        itemConsumedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Item Code", "Item Name", "Store", "Unit", "Quantity", "Rate", "Item Amount", "Expiry Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemConsumedTable.setCellSelectionEnabled(true);
        itemConsumedTable.setPreferredSize(new java.awt.Dimension(450, 200));
        itemConsumedTable.setRowHeight(30);
        itemConsumedTable.setSelectionBackground(new java.awt.Color(0, 102, 102));
        itemConsumedTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemConsumedTable.getTableHeader().setReorderingAllowed(false);
        itemConsumedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemConsumedTableMouseClicked(evt);
            }
        });
        itemConsumedTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemConsumedTableFocusGained(evt);
            }
        });
        itemConsumedTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemConsumedTableKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(itemConsumedTable);
        itemConsumedTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (itemConsumedTable.getColumnModel().getColumnCount() > 0) {
            itemConsumedTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            itemConsumedTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            itemConsumedTable.getColumnModel().getColumn(2).setPreferredWidth(500);
            itemConsumedTable.getColumnModel().getColumn(3).setPreferredWidth(500);
            itemConsumedTable.getColumnModel().getColumn(4).setPreferredWidth(400);
            itemConsumedTable.getColumnModel().getColumn(5).setPreferredWidth(300);
            itemConsumedTable.getColumnModel().getColumn(6).setPreferredWidth(300);
            itemConsumedTable.getColumnModel().getColumn(7).setPreferredWidth(500);
            itemConsumedTable.getColumnModel().getColumn(8).setPreferredWidth(400);
        }

        jLayeredPane6.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light"), 1, true));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Amount :");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));

        amountConsumed.setBackground(new java.awt.Color(0, 204, 255));
        amountConsumed.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        amountConsumed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        amountConsumed.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));
        amountConsumed.setOpaque(true);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(amountConsumed, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(amountConsumed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jLayeredPane6.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(amountConsumed, javax.swing.JLayeredPane.DEFAULT_LAYER);

        insertRowItemTable1.setBackground(new java.awt.Color(255, 255, 255));
        insertRowItemTable1.setText("Insert Row");
        insertRowItemTable1.setFocusPainted(false);
        insertRowItemTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertRowItemTable1ActionPerformed(evt);
            }
        });

        removeRowItemTable1.setBackground(new java.awt.Color(255, 255, 255));
        removeRowItemTable1.setForeground(new java.awt.Color(255, 0, 0));
        removeRowItemTable1.setText("Remove Row");
        removeRowItemTable1.setFocusPainted(false);
        removeRowItemTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowItemTable1ActionPerformed(evt);
            }
        });

        quantityInfoGen.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        quantityInfoGen.setForeground(new java.awt.Color(0, 204, 0));
        quantityInfoGen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        quantityInfoCon.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        quantityInfoCon.setForeground(new java.awt.Color(0, 204, 0));
        quantityInfoCon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(voucherNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(errorMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(insertRowItemTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowItemTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(insertRowItemTable1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowItemTable1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityInfoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voucherNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insertRowItemTable)
                        .addComponent(removeRowItemTable))
                    .addComponent(quantityInfoGen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(quantityInfoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertRowItemTable1)
                            .addComponent(removeRowItemTable1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooserCombo1, jLabel1, jLabel6, voucherNumberTF});

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {insertRowItemTable, removeRowItemTable});

        contentPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(voucherNumberTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(dateChooserCombo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(insertRowItemTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(removeRowItemTable, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(errorMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(insertRowItemTable1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(removeRowItemTable1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(quantityInfoGen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contentPanel.setLayer(quantityInfoCon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlLayer)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(controlLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void removeRowItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowItemTableActionPerformed
        new TableUtils().removingItemTableRow(itemGeneratedTable, selectedRow);
        calculateItemGeneratedAmount();
    }//GEN-LAST:event_removeRowItemTableActionPerformed

    private void insertRowItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRowItemTableActionPerformed
        new TableUtils().addingItemTable(itemGeneratedTable);
        calculateItemConsumedAmount();
    }//GEN-LAST:event_insertRowItemTableActionPerformed

    private void itemGeneratedTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemGeneratedTableFocusGained
        errorMessage.setOpaque(false);
        errorMessage.setText(null);

    }//GEN-LAST:event_itemGeneratedTableFocusGained

    private void itemGeneratedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemGeneratedTableMouseClicked
        tableType = "generated";
        errorMessage.setOpaque(false);
        errorMessage.setText(null);
        selectedRow = itemGeneratedTable.getSelectedRow();
        if (evt.getClickCount() > 1) {
            if (itemGeneratedTable.getSelectedRow() == itemGeneratedTable.getRowCount() - 1) {
                new TableUtils().addingItemTable(itemGeneratedTable);
                evt.consume();
            } else if (itemGeneratedTable.getSelectedColumn() == 1) {
                if (itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1) != null) {
                    itemCodeGenerated = itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1).toString();
                }
                showListOfData("ItemCode", itemGeneratedTable, companyCode);
                if (itemCodeGenerated != null) {
                    if (!itemCodeGenerated.equalsIgnoreCase(itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1).toString())) {
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 4);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 5);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 6);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 7);
                    }
                }
            } else if (itemGeneratedTable.getSelectedColumn() == 2) {
                if (itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1) != null) {
                    itemNameGenerated = itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1).toString();
                }
                showListOfData("ItemName", itemGeneratedTable, companyCode);
                if (itemNameGenerated != null) {
                    if (!itemNameGenerated.equalsIgnoreCase(itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1).toString())) {
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 4);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 5);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 6);
                        itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 7);
                    }
                }
            } else if (itemGeneratedTable.getSelectedColumn() == 4) {
                if (itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1) != null) {
                    primaryUnitGen = new ProductionHandler(mainFrame, this).getUnitName(itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1).toString(), companyCode, conn);
                    if (itemGeneratedTable.getModel().getValueAt(selectedRow, 4) != null) {
                        unitNameGenerated = itemGeneratedTable.getModel().getValueAt(selectedRow, 4).toString();
                    }
                    showListOfData("UnitName", itemGeneratedTable, companyCode);
                    if (unitNameGenerated != null) {
                        if (!unitNameGenerated.equalsIgnoreCase(itemGeneratedTable.getModel().getValueAt(selectedRow, 4).toString())) {
                            itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 6);
                            itemGeneratedTable.getModel().setValueAt(null, itemGeneratedTable.getSelectedRow(), 7);
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_itemGeneratedTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        list.setVisible(false);
        contentPanel.setVisible(true);
        controlLayer.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        setVoucherNumber(companyCode, conn);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new ProductionHandler(mainFrame, this).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                if (new ProductionHandler(mainFrame, this).saveProductionVoucherInfo(this, conn, companyCode)) {
                    if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemGeneratedTable, "generated")) {
                        if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemConsumedTable, "consumed")) {

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
                if (new ProductionHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                    if (new ProductionHandler(mainFrame, this).saveProductionVoucherInfo(this, conn, companyCode)) {
                        if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemGeneratedTable, "generated")) {
                            if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemConsumedTable, "consumed")) {
                                this.enableAllField(false);
                                this.saveOrUpdateControlShow();
                            }
                        }
                    }

                }
            } else {
                if (new ProductionHandler(mainFrame, this).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                    if (new ProductionHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                        if (new ProductionHandler(mainFrame, this).saveProductionVoucherInfo(this, conn, companyCode)) {
                            if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemGeneratedTable, "generated")) {
                                if (new ProductionHandler(mainFrame, this).saveItemGeneratedInfo(this, conn, companyCode, itemConsumedTable, "consumed")) {
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
        if (new ProductionHandler(mainFrame, this).fetchProductionVoucherInformation(companyCode, saleOrderListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight());
            contentPanel.setVisible(false);
            list.setVisible(true);
            controlLayer.setVisible(false);
            backButton.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new ProductionHandler(mainFrame, this).deleteVoucherNumber(companyCode, voucherNumberTF.getText(), conn)) {
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
                if (new ProductionHandler(mainFrame, this).fetchDataOfProductionVoucher(companyCode, voucherNumber, this, conn)) {
                    if (new ProductionHandler(mainFrame, this).fetchItemDetail(companyCode, voucherNumber, itemGeneratedTable, this, conn)) {
                        if (new ProductionHandler(mainFrame, this).fetchItemDetail1(companyCode, voucherNumber, itemConsumedTable, this, conn)) {
                            list.setVisible(false);
                            controlLayer.setVisible(true);
                            contentPanel.setVisible(true);
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

    private void itemGeneratedTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemGeneratedTableKeyTyped

    }//GEN-LAST:event_itemGeneratedTableKeyTyped

    private void itemConsumedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemConsumedTableMouseClicked
        tableType = "consumed";
        errorMessage.setOpaque(false);
        errorMessage.setText(null);
        selectedRow = itemConsumedTable.getSelectedRow();
        if (evt.getClickCount() > 1) {
            if (itemConsumedTable.getSelectedRow() == itemConsumedTable.getRowCount() - 1) {
                new TableUtils().addingItemTable(itemConsumedTable);
                evt.consume();
            } else if (itemConsumedTable.getSelectedColumn() == 1) {
                if (itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1) != null) {
                    itemCodeConsumed = itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1).toString();
                }
                showListOfData("ItemCode", itemConsumedTable, companyCode);
                if (itemCodeConsumed != null) {
                    if (!itemCodeConsumed.equalsIgnoreCase(itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1).toString())) {
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 4);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 5);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 6);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 7);
                    }
                }
            } else if (itemConsumedTable.getSelectedColumn() == 2) {
                if (itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1) != null) {
                    itemCodeConsumed = itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1).toString();
                }
                showListOfData("ItemName", itemConsumedTable, companyCode);
                if (itemCodeConsumed != null) {
                    if (!itemCodeConsumed.equalsIgnoreCase(itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1).toString())) {
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 4);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 5);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 6);
                        itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 7);
                    }
                }
            } else if (itemConsumedTable.getSelectedColumn() == 4) {
                if (itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1) != null) {
                    primaryUnitCons = new ProductionHandler(mainFrame, this).getUnitName(itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1).toString(), companyCode, conn);
                    if (itemConsumedTable.getModel().getValueAt(selectedRow, 4) != null) {
                        unitNameConsumed = itemConsumedTable.getModel().getValueAt(selectedRow, 4).toString();
                    }
                    showListOfData("UnitName", itemConsumedTable, companyCode);
                    if (unitNameConsumed != null) {
                        if (!unitNameConsumed.equalsIgnoreCase(itemConsumedTable.getModel().getValueAt(selectedRow, 4).toString())) {
                            itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 6);
                            itemConsumedTable.getModel().setValueAt(null, itemConsumedTable.getSelectedRow(), 7);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_itemConsumedTableMouseClicked

    private void itemConsumedTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemConsumedTableFocusGained
        errorMessage.setOpaque(false);
        errorMessage.setText(null);
    }//GEN-LAST:event_itemConsumedTableFocusGained

    private void itemConsumedTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemConsumedTableKeyTyped

    }//GEN-LAST:event_itemConsumedTableKeyTyped

    private void insertRowItemTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertRowItemTable1ActionPerformed
        new TableUtils().addingItemTable(itemConsumedTable);
    }//GEN-LAST:event_insertRowItemTable1ActionPerformed

    private void removeRowItemTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowItemTable1ActionPerformed
        new TableUtils().removingItemTableRow(itemConsumedTable, selectedRow);
    }//GEN-LAST:event_removeRowItemTable1ActionPerformed

    private void quantityItemGenTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityItemGenTFKeyTyped
        if (itemGeneratedTable.getModel().getValueAt(itemGeneratedTable.getSelectedRow(), 1) == null) {
            evt.consume();
        } else {
            checkFloat(evt);
        }
    }//GEN-LAST:event_quantityItemGenTFKeyTyped

    private void quantityItemConsTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityItemConsTFKeyTyped
        if (itemConsumedTable.getModel().getValueAt(itemConsumedTable.getSelectedRow(), 1) == null) {
            evt.consume();
        } else {
            checkFloat(evt);
        }
    }//GEN-LAST:event_quantityItemConsTFKeyTyped

    private void rateGenTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateGenTFKeyTyped
        quantityItemGenTFKeyTyped(evt);
    }//GEN-LAST:event_rateGenTFKeyTyped

    private void rateConTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateConTFKeyTyped
        checkFloat(evt);
    }//GEN-LAST:event_rateConTFKeyTyped

    private void quantityItemGenTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_quantityItemGenTFCaretUpdate
        int i = itemGeneratedTable.getSelectedRow();
        updateItemGeneratedAmount(i);
        calculateItemGeneratedAmount();
    }//GEN-LAST:event_quantityItemGenTFCaretUpdate

    private void quantityItemConsTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_quantityItemConsTFCaretUpdate
        int i = itemConsumedTable.getSelectedRow();
        updateItemConsumedAmount(i);
        calculateItemConsumedAmount();
    }//GEN-LAST:event_quantityItemConsTFCaretUpdate

    private void rateGenTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_rateGenTFCaretUpdate
        quantityItemGenTFCaretUpdate(evt);
    }//GEN-LAST:event_rateGenTFCaretUpdate

    private void rateConTFCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_rateConTFCaretUpdate
        quantityItemConsTFCaretUpdate(evt);
    }//GEN-LAST:event_rateConTFCaretUpdate

    private void quantityItemGenTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityItemGenTFFocusLost
        int i = itemGeneratedTable.getSelectedRow();
        updateItemGeneratedAmount(i);
        calculateItemGeneratedAmount();
    }//GEN-LAST:event_quantityItemGenTFFocusLost

    private void rateGenTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateGenTFFocusLost
        quantityItemGenTFFocusLost(evt);
    }//GEN-LAST:event_rateGenTFFocusLost

    private void quantityItemConsTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityItemConsTFFocusLost
        int i = itemConsumedTable.getSelectedRow();
        updateItemConsumedAmount(i);
        calculateItemConsumedAmount();
    }//GEN-LAST:event_quantityItemConsTFFocusLost

    private void rateConTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateConTFFocusLost
        quantityItemConsTFFocusLost(evt);
    }//GEN-LAST:event_rateConTFFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountConsumed;
    private javax.swing.JLabel amountGenerated;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLayeredPane contentPanel;
    private javax.swing.JLayeredPane controlLayer;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField expiryDateForCon;
    private javax.swing.JTextField expiryDateForGen;
    private javax.swing.JButton insertRowItemTable;
    private javax.swing.JButton insertRowItemTable1;
    private javax.swing.JTable itemConsumedTable;
    private javax.swing.JTable itemGeneratedTable;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel list;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JTextArea narrationTA;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel quantityInfoCon;
    private javax.swing.JLabel quantityInfoGen;
    private javax.swing.JTextField quantityItemConsTF;
    private javax.swing.JTextField quantityItemGenTF;
    private javax.swing.JTextField rateConTF;
    private javax.swing.JTextField rateGenTF;
    private javax.swing.JButton removeRowItemTable;
    private javax.swing.JButton removeRowItemTable1;
    private javax.swing.JTable saleOrderListTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField voucherNumberTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void showListOfData(String s, JTable table, String companyCode) {
        listOfData = new ListOfData(mainFrame, true, table, companyCode);
        switch (tableType) {
            case "generated":
                listOfData.setUnitGenName(primaryUnitGen);
                listOfData.setTypeOfRate("purchase");
                if (s.equalsIgnoreCase("UnitName")) {
                    quantityInfoGen.setText("Quantity Available: " + listOfData.getMaxQuantity());
                }
                break;
            case "consumed":
                listOfData.setUnitConsName(primaryUnitCons);
                listOfData.setTypeOfRate("purchase");
                if (s.equalsIgnoreCase("UnitName")) {
                    quantityInfoCon.setText("Quantity Available: " + listOfData.getMaxQuantity());
                }
                break;
        }
        listOfData.addData(s);
        listOfData.setLocationRelativeTo(mainFrame);
        listOfData.setVisible(true);
    }

    public void setVoucherNumber(String companyCode, Connection conn) {
        voucherNumberTF.setText(new FetchVoucherData().getNextProductionVoucherVoucherNo(companyCode, conn));
    }

    private void clearAllField() {
        narrationTA.setText(null);
        voucherNumberTF.setText(null);
        dateChooserCombo1.setSelectedDate(Calendar.getInstance());
        DefaultTableModel model = (DefaultTableModel) itemGeneratedTable.getModel();
        model.setRowCount(0);
        Object[] data = {null, null, null, null, null, null};
        model.addRow(data);
        itemGeneratedTable.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) itemConsumedTable.getModel();
        model1.setRowCount(0);
        Object[] data1 = {null, null, null, null, null, null};
        model1.addRow(data1);
        itemConsumedTable.setModel(model1);
        amountGenerated.setText(null);
        amountConsumed.setText(null);
    }

    private void enableAllField(boolean b) {
        errorMessage.setEnabled(b);
        jLabel4.setEnabled(b);
        jScrollPane1.setEnabled(b);
        narrationTA.setEnabled(b);
        jLabel1.setEnabled(b);
        voucherNumberTF.setEnabled(b);
        jLabel6.setEnabled(b);
        dateChooserCombo1.setEnabled(b);
        jScrollPane2.setEnabled(b);
        itemGeneratedTable.setEnabled(b);
        jLayeredPane3.setEnabled(b);
        jLabel11.setEnabled(b);
        amountGenerated.setEnabled(b);
        insertRowItemTable.setEnabled(b);
        removeRowItemTable.setEnabled(b);
        jScrollPane3.setEnabled(b);
        jLayeredPane6.setEnabled(b);
    }

    private boolean validateUserInput() {
        boolean status = false;
        if (!voucherNumberTF.getText().isEmpty()) {
            int rowCount = itemGeneratedTable.getRowCount();
            int rowCount1 = itemConsumedTable.getRowCount();
            if (rowCount > 1 && rowCount1 > 1) {
                for (int row = 0; row < (rowCount - 1); row++) {
                    if (itemGeneratedTable.getModel().getValueAt(row, 1) != null) {
                        if (itemGeneratedTable.getModel().getValueAt(row, 2) != null) {
                            if (itemGeneratedTable.getModel().getValueAt(row, 3) != null) {
                                if (itemGeneratedTable.getModel().getValueAt(row, 4) != null) {
                                    if (itemGeneratedTable.getModel().getValueAt(row, 5) != null) {
                                        if (itemGeneratedTable.getModel().getValueAt(row, 6) != null) {
                                            status = true;
                                        } else {
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, enter rate at row " + row + " of item generated");
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, enter quantity at row " + row + " of item generated");
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, enter unit at row " + row + " of item generated");
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, enter store name at row " + row + " of item generated");
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, enter item name at row " + row + " of item generated");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, enter item code at row " + row + " of item generated");
                    }
                }

                if (status) {
                    status = false;
                    for (int row = 0; row < (rowCount1 - 1); row++) {
                        if (itemConsumedTable.getModel().getValueAt(row, 1) != null) {
                            if (itemConsumedTable.getModel().getValueAt(row, 2) != null) {
                                if (itemConsumedTable.getModel().getValueAt(row, 3) != null) {
                                    if (itemConsumedTable.getModel().getValueAt(row, 4) != null) {
                                        if (itemConsumedTable.getModel().getValueAt(row, 5) != null) {
                                            if (itemConsumedTable.getModel().getValueAt(row, 6) != null) {
                                                status = true;
                                            } else {
                                                errorMessage.setOpaque(true);
                                                errorMessage.setText("Please, enter amount at row " + row + " of item consumed");
                                            }
                                        } else {
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, enter rate at row " + row + " of item consumed");
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, enter quantity at row " + row + " of item consumed");
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, enter store name at row " + row + " of item consumed");
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, enter item name at row " + row + " of item consumed");
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, enter item code at row " + row + " of item consumed");
                        }
                    }
                }

            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please item details.");
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please enter the voucher number.");
        }
        if (status) {
            status = false;
            if (amountConsumed.getText().equalsIgnoreCase(amountGenerated.getText())) {
                status = true;
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Generated and consumed amount should be equal");
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

    public Timestamp getDateT() {
        Calendar cal = dateChooserCombo1.getSelectedDate();
        Date date = cal.getTime();
        return new Timestamp(date.getTime());
    }

    public String getVoucherNumber() {
        return voucherNumberTF.getText();
    }

    public String getNarration() {
        return narrationTA.getText();
    }

    public String getItemGenratedTotal() {
        return amountGenerated.getText();
    }

    public String getItemConsumedTotal() {
        return amountConsumed.getText();
    }

    public String getItemCode(int i, JTable itemGeneratedTable) {
        return itemGeneratedTable.getModel().getValueAt(i, 1).toString();
    }

    public String getUnit(int i, JTable itemGeneratedTable) {
        return itemGeneratedTable.getModel().getValueAt(i, 4).toString();
    }

    public String getQuantity(int i, JTable itemGeneratedTable) {
        return itemGeneratedTable.getModel().getValueAt(i, 5).toString();
    }

    public String getRate(int i, JTable itemGeneratedTable) {
        return itemGeneratedTable.getModel().getValueAt(i, 6).toString();
    }

    public String getItemAmount(int i, JTable itemGeneratedTable) {
        return itemGeneratedTable.getModel().getValueAt(i, 7).toString();
    }

    public void setNarration(String string) {
        narrationTA.setText(string);
    }

    public void setVoucherNu(String aLong) {
        voucherNumberTF.setText(String.valueOf(aLong));
    }

    public void setDatee(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        dateChooserCombo1.setSelectedDate(calendar);
    }

    public void setItemGeneratedTotal(String aDouble) {
        amountGenerated.setText(String.valueOf(aDouble));
    }

    public void setItemConsumedTotal(String aDouble) {
        amountConsumed.setText(String.valueOf(aDouble));
    }

    private void checkFloat(KeyEvent evt) {
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }

    private void updateItemGeneratedAmount(int i) {
        if (i > -1) {
            if (itemGeneratedTable.getModel().getValueAt(i, 1) != null) {
                if (itemGeneratedTable.getModel().getValueAt(i, 4) != null) {
                    String uName = itemGeneratedTable.getModel().getValueAt(i, 4).toString();
                    if (itemGeneratedTable.getModel().getValueAt(i, 5) != null) {
                        double quantity = Double.valueOf(itemGeneratedTable.getModel().getValueAt(i, 5).toString());
                        if (itemGeneratedTable.getValueAt(i, 6) != null) {
                            double price = Double.valueOf(itemGeneratedTable.getValueAt(i, 6).toString());
                            if (getUnitType(uName, conn).equalsIgnoreCase("Single")) {
                                itemGeneratedTable.getModel().setValueAt(roundTwoDecimals(quantity * price), i, 7);
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
                                itemGeneratedTable.getModel().setValueAt(roundTwoDecimals(itemAmount), i, 7);
                            }
                        }

                    }
                }
            }
        }
    }

    private void calculateItemGeneratedAmount() {
        Double totalItemAmount = 0.0;
        for (int i = 0; i < itemGeneratedTable.getRowCount() - 1; i++) {
            try {
                totalItemAmount = totalItemAmount + Double.valueOf(itemGeneratedTable.getModel().getValueAt(i, 7).toString());
            } catch (NullPointerException | NumberFormatException ex) {
            }
        }
        amountGenerated.setText(String.valueOf(totalItemAmount));
    }

    private void updateItemConsumedAmount(int i) {
        if (i > -1) {
            if (itemConsumedTable.getModel().getValueAt(i, 1) != null) {
                if (itemConsumedTable.getModel().getValueAt(i, 4) != null) {
                    String uName = itemConsumedTable.getModel().getValueAt(i, 4).toString();
                    if (itemConsumedTable.getModel().getValueAt(i, 5) != null) {
                        double quantity = Double.valueOf(itemConsumedTable.getModel().getValueAt(i, 5).toString());
                        if (itemConsumedTable.getValueAt(i, 6) != null) {
                            double price = Double.valueOf(itemConsumedTable.getValueAt(i, 6).toString());
                            if (getUnitType(uName, conn).equalsIgnoreCase("Single")) {
                                itemConsumedTable.getModel().setValueAt(roundTwoDecimals(quantity * price), i, 7);
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
                                itemConsumedTable.getModel().setValueAt(roundTwoDecimals(itemAmount), i, 7);
                            }
                        }

                    }
                }
            }
        }
    }

    private void calculateItemConsumedAmount() {
        Double totalItemAmount = 0.0;
        for (int i = 0; i < itemConsumedTable.getRowCount() - 1; i++) {
            try {
                totalItemAmount = totalItemAmount + Double.valueOf(itemConsumedTable.getModel().getValueAt(i, 7).toString());
            } catch (NullPointerException | NumberFormatException ex) {
            }
        }
        amountConsumed.setText(String.valueOf(totalItemAmount));
    }

    private String getUnitType(String unitName, Connection conn) {
        return new FetchVoucherData().getUnitType(unitName, conn);
    }

    public String roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    public String getExpiryDate(int i, JTable itemTable) {
        try {
            return itemTable.getValueAt(i, 8).toString();
        } catch (NullPointerException ex) {
            return null;
        }
    }
}
