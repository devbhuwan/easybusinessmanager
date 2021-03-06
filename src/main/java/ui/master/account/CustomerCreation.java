package ui.master.account;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.feature.TableUI;
import ui.master.FetchMasterData;
import ui.master.account.utils.AccountHandler;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class CustomerCreation extends javax.swing.JPanel {

    private final String companyCode;
    private String accountNumber;
    private final Connection conn;
    private String companyName;

    /**
     * Creates new form AccountCreation
     *
     * @param companyCode
     * @param conn
     */
    public CustomerCreation(String companyCode, Connection conn) {
        initComponents();
        this.companyCode = companyCode;
        this.conn = conn;
        listControl.setVisible(false);
        defaultControlShow();
        list.setVisible(false);
        contentPanel.setVisible(true);
        errorMessage.setOpaque(false);
        dateChooserCombo.setFormat(1);
        accountListTable.setTableHeader(new TableUI().getTableHeaderUI(accountListTable));
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event); //To change body of generated methods, choose Tools | Templates.
                errorMessage.setOpaque(false);
                errorMessage.setText(null);
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        list = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountListTable = new javax.swing.JTable();
        contentPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        customerNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        accountNumberTF = new javax.swing.JTextField();
        accountGroupCB = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        phNoTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        faxNoTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dateChooserCombo = new datechooser.beans.DateChooserCombo();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTA = new javax.swing.JTextArea();
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

        accountListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        accountListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Account Number", "Customer Name", "Account Group"
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
        accountListTable.setFocusable(false);
        accountListTable.setRowHeight(23);
        accountListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accountListTable.getTableHeader().setReorderingAllowed(false);
        accountListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(accountListTable);
        if (accountListTable.getColumnModel().getColumnCount() > 0) {
            accountListTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            accountListTable.getColumnModel().getColumn(1).setPreferredWidth(400);
            accountListTable.getColumnModel().getColumn(2).setPreferredWidth(500);
            accountListTable.getColumnModel().getColumn(3).setPreferredWidth(500);
        }

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Account Details"));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Account Group :");

        customerNameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), customerNameTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Customer Name :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Account Number :");

        accountNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), accountNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        accountGroupCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        accountGroupCB.setMaximumRowCount(20);
        accountGroupCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sale" }));
        accountGroupCB.setSelectedIndex(-1);
        accountGroupCB.setToolTipText("");
        accountGroupCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), accountGroupCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Phone Number :");

        phNoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), phNoTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        phNoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phNoTFKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setText("Address :");

        addressTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), addressTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setText("Fax Number :");

        faxNoTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), faxNoTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        faxNoTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                faxNoTFKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setText("Date :");

        dateChooserCombo.setNothingAllowed(false);
        dateChooserCombo.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 12));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(phNoTF)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12))
                                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                        .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customerNameTF)
                            .addComponent(accountGroupCB, 0, 437, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(accountGroupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(faxNoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {accountGroupCB, accountNumberTF, addressTF, customerNameTF, dateChooserCombo, faxNoTF, jLabel10, jLabel11, jLabel12, jLabel13, jLabel2, jLabel3, jLabel4, phNoTF});

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(customerNameTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(accountNumberTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(accountGroupCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(phNoTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(addressTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(faxNoTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(dateChooserCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Other Details"));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Description :");

        descriptionTA.setColumns(20);
        descriptionTA.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), descriptionTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(descriptionTA);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if (new AccountHandler().checkAccountNumberIsValidOrNot(companyCode, accountNumberTF.getText(), conn)) {
                if (new AccountHandler().saveCustomerInformation(companyCode, this, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Account number is already exist.");
                accountNumberTF.requestFocusInWindow();
                accountNumberTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (accountNumber.equalsIgnoreCase(accountNumberTF.getText())) {
                if (new AccountHandler().updateCustomerInformation(companyCode, this, accountNumber, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                if (new AccountHandler().checkAccountNumberIsValidOrNot(companyCode, accountNumberTF.getText(), conn)) {
                    if (new AccountHandler().updateCustomerInformation(companyCode, this, accountNumber, conn)) {
                        this.enableAllField(false);
                        this.saveOrUpdateControlShow();
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Account number is already exist.");
                    accountNumberTF.requestFocusInWindow();
                    accountNumberTF.selectAll();
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
        if (new AccountHandler().deleteAccountNumber(companyCode, accountNumberTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            companyName = new FetchMasterData().getCompanyName(companyCode, conn);
            MessageFormat headerFormat = new MessageFormat("List Of Customers [ " + companyName + " (" + companyCode + ") ]");
            MessageFormat footerFormat = new MessageFormat("                                               Authorised Signature");
            accountListTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
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
        if (new AccountHandler().fetchAccountInformation(companyCode, accountListTable, conn, "Customer")) {
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

    private void phNoTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phNoTFKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        }
    }//GEN-LAST:event_phNoTFKeyTyped

    private void faxNoTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_faxNoTFKeyTyped
        phNoTFKeyTyped(evt);
    }//GEN-LAST:event_faxNoTFKeyTyped

    private void accountListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountListTableMouseClicked
        if (accountListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && accountListTable.getSelectedRow() > -1) {
                accountNumber = accountListTable.getValueAt(accountListTable.getSelectedRow(), 1).toString();
                if (new AccountHandler().fetchDataOfCustomer(companyCode, accountNumber, this, conn)) {
                    list.setVisible(false);
                    contentPanel.setVisible(true);
                    listControl.setVisible(false);
                    mainControl.setVisible(true);
                    this.remove(list);
                    enableAllField(true);
                    showEditOrListControl();

                }
            }
        }
    }//GEN-LAST:event_accountListTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountGroupCB;
    private javax.swing.JTable accountListTable;
    private javax.swing.JTextField accountNumberTF;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressTF;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLayeredPane controlMain;
    private javax.swing.JTextField customerNameTF;
    private datechooser.beans.DateChooserCombo dateChooserCombo;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionTA;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField faxNoTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel list;
    private javax.swing.JButton listButton;
    private javax.swing.JLayeredPane listControl;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JTextField phNoTF;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void clearAllField() {
        accountGroupCB.setSelectedIndex(-1);
        customerNameTF.setText(null);
        accountNumberTF.setText(null);
        phNoTF.setText(null);
        faxNoTF.setText(null);
        addressTF.setText(null);
        dateChooserCombo.setSelectedDate(Calendar.getInstance());
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
        jLabel2.setEnabled(b);
        jLabel3.setEnabled(b);
        jLabel4.setEnabled(b);
        customerNameTF.setEnabled(b);
        accountNumberTF.setEnabled(b);
        accountGroupCB.setEnabled(b);
        jLabel10.setEnabled(b);
        phNoTF.setEnabled(b);
        jLabel11.setEnabled(b);
        addressTF.setEnabled(b);
        jLabel12.setEnabled(b);
        faxNoTF.setEnabled(b);
        jLabel13.setEnabled(b);
        dateChooserCombo.setEnabled(b);
        jLayeredPane2.setEnabled(b);
        jScrollPane1.setEnabled(b);
        descriptionTA.setEnabled(b);
        jLabel1.setEnabled(b);
        descriptionTA.setEditable(b);
        descriptionTA.setEnabled(b);
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
        if (accountGroupCB.getSelectedIndex() > -1) {
            if (!customerNameTF.getText().isEmpty()) {
                if (!accountNumberTF.getText().isEmpty()) {
                    status = true;
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Please, enter the account number.");
                    accountNumberTF.requestFocusInWindow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, enter the customer name.");
                customerNameTF.requestFocusInWindow();
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, select account group.");
            accountGroupCB.requestFocusInWindow();
        }
        return status;
    }

    public String getGroupName() {
        return accountGroupCB.getSelectedItem().toString();
    }

    public String getCusName() {
        return customerNameTF.getText();
    }
    public String getAccNumber() {
        return accountNumberTF.getText();
    }

    public String getAddress() {
        return addressTF.getText();
    }

    public String getPhNo() {
        return phNoTF.getText();
    }

    public String getFaxNo() {
        return faxNoTF.getText();
    }

    public Timestamp getDateT() {
        java.util.Calendar cal = dateChooserCombo.getSelectedDate();
        java.util.Date date = cal.getTime();
        return new Timestamp(date.getTime());
    }

    public String getDescription() {
        return descriptionTA.getText();
    }

    public void setGroupName(String string) {
        accountGroupCB.setSelectedItem(string);
    }

    public void setCusName(String string) {
        customerNameTF.setText(string);
    }

    public void setAccountNumber(String aLong) {
        accountNumberTF.setText(aLong);
    }

    public void setAddress(String string) {
        addressTF.setText(string);
    }

    public void setPhoneNumber(String string) {
        phNoTF.setText(string);
    }

    public void setFaxNo(String string) {
        faxNoTF.setText(string);
    }

    public void setDateT(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        Calendar cal = dateChooserCombo.getSelectedDate();
        cal.setTime(date);
        dateChooserCombo.setSelectedDate(cal);
    }

    public void setDescription(String string) {
        descriptionTA.setText(string);
    }
}
