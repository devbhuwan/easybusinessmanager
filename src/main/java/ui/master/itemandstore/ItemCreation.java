package ui.master.itemandstore;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.text.MessageFormat;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.feature.TableUI;
import ui.master.FetchMasterData;
import ui.master.itemandstore.utils.ItemAndStoreHandler;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ItemCreation extends javax.swing.JPanel {

    private final String companyCode;
    private String itemCode;
    private final Connection conn;
    private String companyName;

    /**
     * Creates new form AccountCreation
     *
     * @param companyCode
     * @param conn
     */
    public ItemCreation(String companyCode, Connection conn) {
        initComponents();
        this.companyCode = companyCode;
        listControl.setVisible(false);
        defaultControlShow();
        list.setVisible(false);
        contentPanel.setVisible(true);
        itemListTable.setTableHeader(new TableUI().getTableHeaderUI(itemListTable));
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setOpaque(false);
                errorMessage.setText(null);
            }
        });
        this.conn = conn;
        new FetchMasterData().fetchItemGoup(itemGroupCB, companyCode, conn);
        new FetchMasterData().setStoreName(storeNameCB, companyCode, conn);
        new FetchMasterData().setStoreGroup(storeGroupCB, companyCode, conn);
        new FetchMasterData().fetchUnitName(unitNameCB, companyCode, conn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        list = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemListTable = new javax.swing.JTable();
        contentPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        l1 = new javax.swing.JLabel();
        itemNameTF = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        itemCodeTF = new javax.swing.JTextField();
        itemGroupCB = new javax.swing.JComboBox();
        l4 = new javax.swing.JLabel();
        storeNameCB = new javax.swing.JComboBox();
        l5 = new javax.swing.JLabel();
        storeGroupCB = new javax.swing.JComboBox();
        l6 = new javax.swing.JLabel();
        unitNameCB = new javax.swing.JComboBox();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        salePriceFT = new javax.swing.JFormattedTextField();
        purchasePriceFT = new javax.swing.JFormattedTextField();
        selfDevCostFT = new javax.swing.JFormattedTextField();
        l10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTA = new javax.swing.JTextArea();
        l11 = new javax.swing.JLabel();
        mrpFT = new javax.swing.JFormattedTextField();
        listButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        controlMain = new javax.swing.JLayeredPane();
        mainControl = new javax.swing.JLayeredPane();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        listControl = new javax.swing.JLayeredPane();
        printButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        list.setBackground(new java.awt.Color(255, 255, 255));

        itemListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Item Name", "Item Code", "Item Group", "Store Name", "Store Group", "Unit Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemListTable.setFocusable(false);
        itemListTable.setRowHeight(23);
        itemListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemListTable.getTableHeader().setReorderingAllowed(false);
        itemListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(itemListTable);
        if (itemListTable.getColumnModel().getColumnCount() > 0) {
            itemListTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            itemListTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            itemListTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            itemListTable.getColumnModel().getColumn(3).setPreferredWidth(400);
            itemListTable.getColumnModel().getColumn(4).setPreferredWidth(400);
            itemListTable.getColumnModel().getColumn(5).setPreferredWidth(400);
            itemListTable.getColumnModel().getColumn(6).setPreferredWidth(200);
        }

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Item Details"));

        l1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l1.setText("Item Group :");

        itemNameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemNameTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        l2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l2.setText("Item Name :");

        l3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l3.setText("Item Code :");

        itemCodeTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemCodeTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        itemGroupCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        itemGroupCB.setMaximumRowCount(20);
        itemGroupCB.setToolTipText("");
        itemGroupCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemGroupCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        itemGroupCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemGroupCBMouseEntered(evt);
            }
        });

        l4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l4.setText("Store Name :");

        storeNameCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        storeNameCB.setMaximumRowCount(20);
        storeNameCB.setToolTipText("");
        storeNameCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), storeNameCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        storeNameCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                storeNameCBMouseEntered(evt);
            }
        });

        l5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l5.setText("Store Group :");

        storeGroupCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        storeGroupCB.setMaximumRowCount(20);
        storeGroupCB.setToolTipText("");
        storeGroupCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), storeGroupCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        storeGroupCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                storeGroupCBMouseEntered(evt);
            }
        });

        l6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l6.setText("Unit Name :");

        unitNameCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        unitNameCB.setMaximumRowCount(20);
        unitNameCB.setToolTipText("");
        unitNameCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), unitNameCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        unitNameCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                unitNameCBMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(l3)
                            .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(l2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(itemGroupCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(itemCodeTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                            .addComponent(l6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(unitNameCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                            .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(storeGroupCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jLayeredPane1Layout.createSequentialGroup()
                            .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(storeNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l1, l2, l3, l4, l5, l6});

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1)
                    .addComponent(itemGroupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4)
                    .addComponent(storeNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l5)
                    .addComponent(storeGroupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l6)
                    .addComponent(unitNameCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {itemNameTF, l1, l2, l3, l4, l5, l6});

        jLayeredPane1.setLayer(l1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(itemNameTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(l2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(l3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(itemCodeTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(itemGroupCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(l4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(storeNameCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(l5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(storeGroupCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(l6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(unitNameCB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Other Details"));

        l7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l7.setText("Sale Price :");

        l8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l8.setText("Purchase Price/Self Dev. Cost :");

        l9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l9.setText("Quantity :");

        salePriceFT.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), salePriceFT, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        salePriceFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                salePriceFTKeyTyped(evt);
            }
        });

        purchasePriceFT.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), purchasePriceFT, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        purchasePriceFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                purchasePriceFTKeyTyped(evt);
            }
        });

        selfDevCostFT.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), selfDevCostFT, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        selfDevCostFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                selfDevCostFTKeyTyped(evt);
            }
        });

        l10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l10.setText("Description :");

        descriptionTA.setColumns(20);
        descriptionTA.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), descriptionTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(descriptionTA);

        l11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        l11.setText("M. R. P. :");

        mrpFT.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), mrpFT, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        mrpFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mrpFTKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salePriceFT))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(l8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchasePriceFT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(l11)
                            .addComponent(l9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(selfDevCostFT)
                            .addComponent(mrpFT, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l7)
                    .addComponent(salePriceFT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l11)
                    .addComponent(mrpFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l8)
                    .addComponent(purchasePriceFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l9)
                    .addComponent(selfDevCostFT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLayeredPane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {l11, l7, l8, l9, mrpFT, purchasePriceFT, salePriceFT, selfDevCostFT});

        jLayeredPane2.setLayer(l7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(l8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(l9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(salePriceFT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(purchasePriceFT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(selfDevCostFT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(l10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(l11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(mrpFT, javax.swing.JLayeredPane.DEFAULT_LAYER);

        listButton.setBackground(new java.awt.Color(255, 255, 255));
        listButton.setText("List");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        errorMessage.setBackground(new java.awt.Color(255, 255, 255));
        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(204, 0, 0));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setOpaque(true);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listButton))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLayeredPane1)
                        .addComponent(jLayeredPane2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listButton)
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contentPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {errorMessage, listButton});

        controlMain.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

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

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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

        javax.swing.GroupLayout mainControlLayout = new javax.swing.GroupLayout(mainControl);
        mainControl.setLayout(mainControlLayout);
        mainControlLayout.setHorizontalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        mainControlLayout.setVerticalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainControlLayout.createSequentialGroup()
                        .addGroup(mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mainControl.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(saveButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(editButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(null);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listControlLayout = new javax.swing.GroupLayout(listControl);
        listControl.setLayout(listControlLayout);
        listControlLayout.setHorizontalGroup(
            listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        listControlLayout.setVerticalGroup(
            listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        listControl.setLayer(printButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        listControl.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout controlMainLayout = new javax.swing.GroupLayout(controlMain);
        controlMain.setLayout(controlMainLayout);
        controlMainLayout.setHorizontalGroup(
            controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        controlMainLayout.setVerticalGroup(
            controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        controlMain.setLayer(mainControl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        controlMain.setLayer(listControl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(controlMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new ItemAndStoreHandler().checkItemCodeIsValidOrNot(companyCode, itemCodeTF.getText(), conn)) {
                if (new ItemAndStoreHandler().saveItemInformation(companyCode, this, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Item code is already exist.");
                itemCodeTF.requestFocusInWindow();
                itemCodeTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (itemCodeTF.getText().equals(String.valueOf(itemCode))) {
                if (new ItemAndStoreHandler().updateItemInformation(companyCode, this, itemCode, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                if (new ItemAndStoreHandler().checkItemCodeIsValidOrNot(companyCode, itemCodeTF.getText(), conn)) {
                    if (new ItemAndStoreHandler().updateItemInformation(companyCode, this, itemCode, conn)) {
                        this.enableAllField(false);
                        this.saveOrUpdateControlShow();
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Item code is already exist.");
                    itemCodeTF.requestFocusInWindow();
                    itemCodeTF.selectAll();
                }
            }

        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.clearAllField();
        this.enableAllField(false);
        showCancelControl();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new ItemAndStoreHandler().deleteItemCode(companyCode, itemCodeTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            companyName = new FetchMasterData().getCompanyName(companyCode, conn);
            MessageFormat headerFormat = new MessageFormat("List Of Items [ " + companyName + " (" + companyCode + ") ]");
            MessageFormat footerFormat = new MessageFormat("                                               Authorised Signature");
            itemListTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException pe) {
            System.err.println("Error printing: " + pe.getMessage());
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        list.setVisible(false);
        contentPanel.setVisible(true);
        listControl.setVisible(false);
        mainControl.setVisible(true);
        this.remove(list);
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (new ItemAndStoreHandler().fetchItemInformation(companyCode, itemListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight() - 45);
            contentPanel.setVisible(false);
            list.setVisible(true);
            mainControl.setVisible(false);
            listControl.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        editButtonActionPerformed(evt);
    }//GEN-LAST:event_listButtonActionPerformed

    private void itemListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemListTableMouseClicked
        if (itemListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && itemListTable.getSelectedRow() > -1) {
                itemCode = itemListTable.getValueAt(itemListTable.getSelectedRow(), 2).toString();
                if (new ItemAndStoreHandler().fetchDataOfItem(companyCode, itemCode, this, conn)) {
                    System.out.println("Hello");
                    list.setVisible(false);
                    contentPanel.setVisible(true);
                    listControl.setVisible(false);
                    mainControl.setVisible(true);
                    this.remove(list);
                    enableAllField(true);
                    unitNameCB.setEnabled(false);
                    showEditOrListControl();

                }
            }
        }
    }//GEN-LAST:event_itemListTableMouseClicked

    private void itemGroupCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemGroupCBMouseEntered
        new FetchMasterData().fetchItemGoup(itemGroupCB, companyCode, conn);
    }//GEN-LAST:event_itemGroupCBMouseEntered

    private void storeNameCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeNameCBMouseEntered
        new FetchMasterData().setStoreName(storeNameCB, companyCode, conn);
    }//GEN-LAST:event_storeNameCBMouseEntered

    private void storeGroupCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeGroupCBMouseEntered
        new FetchMasterData().setStoreGroup(storeGroupCB, companyCode, conn);
    }//GEN-LAST:event_storeGroupCBMouseEntered

    private void unitNameCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unitNameCBMouseEntered
        new FetchMasterData().primaryUnit(unitNameCB, conn, companyCode);
    }//GEN-LAST:event_unitNameCBMouseEntered

    private void salePriceFTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salePriceFTKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (salePriceFT.getText().isEmpty()) {
                evt.consume();
            } else if (salePriceFT.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_salePriceFTKeyTyped

    private void purchasePriceFTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purchasePriceFTKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (purchasePriceFT.getText().isEmpty()) {
                evt.consume();
            } else if (purchasePriceFT.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_purchasePriceFTKeyTyped

    private void mrpFTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mrpFTKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (mrpFT.getText().isEmpty()) {
                evt.consume();
            } else if (mrpFT.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_mrpFTKeyTyped

    private void selfDevCostFTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_selfDevCostFTKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (selfDevCostFT.getText().isEmpty()) {
                evt.consume();
            } else if (selfDevCostFT.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_selfDevCostFTKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLayeredPane controlMain;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionTA;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField itemCodeTF;
    private javax.swing.JComboBox itemGroupCB;
    private javax.swing.JTable itemListTable;
    private javax.swing.JTextField itemNameTF;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JPanel list;
    private javax.swing.JButton listButton;
    private javax.swing.JLayeredPane listControl;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JFormattedTextField mrpFT;
    private javax.swing.JButton printButton;
    private javax.swing.JFormattedTextField purchasePriceFT;
    private javax.swing.JFormattedTextField salePriceFT;
    private javax.swing.JButton saveButton;
    private javax.swing.JFormattedTextField selfDevCostFT;
    private javax.swing.JComboBox storeGroupCB;
    private javax.swing.JComboBox storeNameCB;
    private javax.swing.JComboBox unitNameCB;
    private javax.swing.JButton updateButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void clearAllField() {
        itemNameTF.setText(null);
        itemCodeTF.setText(null);
        itemGroupCB.setSelectedIndex(-1);
        storeNameCB.setSelectedIndex(-1);
        storeGroupCB.setSelectedIndex(-1);
        unitNameCB.setSelectedIndex(-1);
        salePriceFT.setText(null);
        purchasePriceFT.setText(null);
        mrpFT.setText(null);
        selfDevCostFT.setText(null);
        descriptionTA.setText(null);
    }

    private void addControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void enableAllField(boolean b) {
        errorMessage.setEnabled(b);
        jLayeredPane1.setEnabled(b);
        l1.setEnabled(b);
        l2.setEnabled(b);
        l3.setEnabled(b);
        l4.setEnabled(b);
        l5.setEnabled(b);
        l6.setEnabled(b);
        l7.setEnabled(b);
        l8.setEnabled(b);
        l9.setEnabled(b);
        l10.setEnabled(b);
        l11.setEnabled(b);
        itemNameTF.setEnabled(b);
        itemCodeTF.setEnabled(b);
        itemGroupCB.setEnabled(b);
        storeGroupCB.setEnabled(b);
        storeNameCB.setEnabled(b);
        unitNameCB.setEnabled(b);
        salePriceFT.setEnabled(b);
        purchasePriceFT.setEnabled(b);
        mrpFT.setEnabled(b);
        selfDevCostFT.setEnabled(b);
        descriptionTA.setEnabled(b);
        jLayeredPane2.setEnabled(b);
        jScrollPane1.setEnabled(b);
        descriptionTA.setEditable(b);
    }

    private void defaultControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

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

    private boolean validateUserInput() {
        boolean status = false;
        if (!itemNameTF.getText().isEmpty()) {
            if (!itemCodeTF.getText().isEmpty()) {
                if (itemGroupCB.getSelectedIndex() > -1) {
                    if (storeNameCB.getSelectedIndex() > -1) {
                        if (storeGroupCB.getSelectedIndex() > -1) {
                            if (unitNameCB.getSelectedIndex() > -1) {
                                if (!salePriceFT.getText().isEmpty()) {
                                    if (!purchasePriceFT.getText().isEmpty()) {
                                        status = true;
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, enter purchase price for item.");
                                        purchasePriceFT.requestFocusInWindow();
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, enter sale price for item.");
                                    salePriceFT.requestFocusInWindow();
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the unit name.");
                                unitNameCB.requestFocusInWindow();
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the store group.");
                            storeGroupCB.requestFocusInWindow();
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the store name.");
                        storeNameCB.requestFocusInWindow();
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Please, select the item group.");
                    itemGroupCB.requestFocusInWindow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, enter the item code.");
                itemCodeTF.requestFocusInWindow();
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, enter the item name.");
            itemNameTF.requestFocusInWindow();
        }
        return status;
    }

    public String getItemName() {
        return itemNameTF.getText();
    }

    public String getItemCode() {
        return itemCodeTF.getText();
    }

    public String getItemGroup() {
        return itemGroupCB.getSelectedItem().toString();
    }

    public String getStoreName() {
        return storeNameCB.getSelectedItem().toString();
    }

    public String getStoreGroup() {
        return storeGroupCB.getSelectedItem().toString();
    }

    public String getUnitName() {
        return unitNameCB.getSelectedItem().toString();
    }

    public String getSalePrice() {
        return salePriceFT.getText();
    }

    public String getPurchasePrice() {
        return purchasePriceFT.getText();
    }

    public String getMRP() {
        return mrpFT.getText();
    }

    public String getSelfDevCost() {
        return selfDevCostFT.getText();
    }

    public String getDescription() {
        return descriptionTA.getText();
    }

    public void setItemName(String string) {
        itemNameTF.setText(string);
    }

    public void setItemCode(String aLong) {
        itemCodeTF.setText(aLong);
    }

    public void setItemGroup(String string) {
        itemGroupCB.setSelectedItem(string);
    }

    public void setStoreName(String string) {
        storeNameCB.setSelectedItem(string);
    }

    public void setStoreGroup(String string) {
        storeGroupCB.setSelectedItem(string);
    }

    public void setUnitName(String string) {
        unitNameCB.setSelectedItem(string);
    }

    public void setSalePrice(String aDouble) {
        salePriceFT.setText(aDouble);
    }

    public void setPurchasePrice(String aDouble) {
        purchasePriceFT.setText(aDouble);
    }

    public void setMRP(String aDouble) {
        mrpFT.setText(aDouble);
    }

    public void setSelfDevCost(String aDouble) {
        selfDevCostFT.setText(aDouble);
    }

    public void setDescription(String string) {
        descriptionTA.setText(string);
    }

}
