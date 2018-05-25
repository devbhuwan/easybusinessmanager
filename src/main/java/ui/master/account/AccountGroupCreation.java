package ui.master.account;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.text.MessageFormat;
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
public class AccountGroupCreation extends javax.swing.JPanel {

    private final String companyCode;
    private String accountGroup;
    private final Connection conn;
    private String companyName;

    /**
     * Creates new form AccountCreation
     *
     * @param companyCode
     * @param conn
     */
    public AccountGroupCreation(String companyCode, Connection conn) {
        initComponents();
        this.companyCode = companyCode;
        this.conn = conn;
        listControl.setVisible(false);
        defaultControlShow();
        list.setVisible(false);
        contentPanel.setVisible(true);
        errorMessage.setOpaque(false);
        accounGroupListTable.setTableHeader(new TableUI().getTableHeaderUI(accounGroupListTable));
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setOpaque(false);
                errorMessage.setText(null);
            }
        });
        new FetchMasterData().accountGroup(underGroupCB, conn, companyCode);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        list = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accounGroupListTable = new javax.swing.JTable();
        contentPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        groupNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        underGroupCB = new javax.swing.JComboBox();
        commentsTF = new javax.swing.JTextField();
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

        accounGroupListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        accounGroupListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Group Name", "Primary", "Under Group", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        accounGroupListTable.setFocusable(false);
        accounGroupListTable.setRowHeight(23);
        accounGroupListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        accounGroupListTable.getTableHeader().setReorderingAllowed(false);
        accounGroupListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accounGroupListTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accounGroupListTable);
        if (accounGroupListTable.getColumnModel().getColumnCount() > 0) {
            accounGroupListTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            accounGroupListTable.getColumnModel().getColumn(1).setPreferredWidth(600);
            accounGroupListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            accounGroupListTable.getColumnModel().getColumn(3).setPreferredWidth(600);
            accounGroupListTable.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Group Details"));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Under Group :");

        groupNameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), groupNameTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Group Name :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Comments :");

        underGroupCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        underGroupCB.setMaximumRowCount(20);
        underGroupCB.setToolTipText("");
        underGroupCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), underGroupCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        underGroupCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                underGroupCBMouseEntered(evt);
            }
        });

        commentsTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), commentsTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(groupNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commentsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(underGroupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(underGroupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(commentsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {groupNameTF, jLabel2, jLabel3, jLabel4, underGroupCB});

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(groupNameTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(underGroupCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(commentsTF, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listButton))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listButton)
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if (new AccountHandler().checkAccountGroupIsValidOrNot(companyCode, groupNameTF.getText(), conn)) {
                if (new AccountHandler().saveAccountGroupInformation(companyCode, this, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Group name is already exist.");
                groupNameTF.requestFocusInWindow();
                groupNameTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (!checkPredefinedGroupOrNot(groupNameTF.getText().trim())) {
            if (validateUserInput()) {
                if (accountGroup.equalsIgnoreCase(groupNameTF.getText())) {
                    if (new AccountHandler().updateAccountGroupInformation(companyCode, this, accountGroup, conn)) {
                        this.enableAllField(false);
                        this.saveOrUpdateControlShow();
                    }
                } else {
                    if (new AccountHandler().checkAccountGroupIsValidOrNot(companyCode, groupNameTF.getText(), conn)) {
                        if (new AccountHandler().updateAccountGroupInformation(companyCode, this, accountGroup, conn)) {
                            this.enableAllField(false);
                            this.saveOrUpdateControlShow();
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Group name is already exist.");
                        groupNameTF.requestFocusInWindow();
                        groupNameTF.selectAll();
                    }
                }
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Predefined group can't be deleted.");
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.clearAllField();
        this.enableAllField(false);
        showCancelControl();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (!checkPredefinedGroupOrNot(groupNameTF.getText().trim())) {
            if (new AccountHandler().deleteAccountGroup(companyCode, groupNameTF.getText(), conn, this)) {
                this.clearAllField();
                this.enableAllField(false);
                this.deleteControlShow();
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Predefined group can't be deleted.");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            companyName = new FetchMasterData().getCompanyName(companyCode, conn);
            MessageFormat headerFormat = new MessageFormat("List Of Account Groups [ " + companyName + " (" + companyCode + ") ]");
            MessageFormat footerFormat = new MessageFormat("                                               Authorised Signature");
            accounGroupListTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
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
        if (new AccountHandler().fetchAccountGroupInformation(companyCode, accounGroupListTable, conn)) {
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

    private void accounGroupListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accounGroupListTableMouseClicked
        if (accounGroupListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && accounGroupListTable.getSelectedRow() > -1) {
                accountGroup = accounGroupListTable.getValueAt(accounGroupListTable.getSelectedRow(), 1).toString();
                if (new AccountHandler().fetchDataOfAccountGroup(companyCode, accountGroup, this, conn)) {
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
    }//GEN-LAST:event_accounGroupListTableMouseClicked

    private void underGroupCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underGroupCBMouseEntered
        new FetchMasterData().accountGroup(underGroupCB, conn, companyCode);
    }//GEN-LAST:event_underGroupCBMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accounGroupListTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField commentsTF;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLayeredPane controlMain;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField groupNameTF;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel list;
    private javax.swing.JButton listButton;
    private javax.swing.JLayeredPane listControl;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox underGroupCB;
    private javax.swing.JButton updateButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void clearAllField() {
        groupNameTF.setText(null);
        underGroupCB.setSelectedIndex(-1);
        commentsTF.setText(null);
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
        jLayeredPane1.setEnabled(b);
        jLabel2.setEnabled(b);
        groupNameTF.setEnabled(b);
        jLabel3.setEnabled(b);
        jLabel4.setEnabled(b);
        underGroupCB.setEnabled(b);
        commentsTF.setEnabled(b);
        errorMessage.setEnabled(b);
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
        if (!groupNameTF.getText().isEmpty()) {
            if ((underGroupCB.getSelectedIndex() > -1)) {
                status = true;
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, select under group.");
                groupNameTF.requestFocusInWindow();
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, enter the group name.");
            groupNameTF.requestFocusInWindow();
        }
        return status;
    }

    public String getGroupName() {
        return groupNameTF.getText();
    }

    public String getUnderGroup() {
        return underGroupCB.getSelectedItem().toString();
    }

    public String getComments() {
        return commentsTF.getText();
    }

    public void setGroupName(String string) {
        groupNameTF.setText(string);
    }

    public void setUnderGroup(String string) {
        underGroupCB.setSelectedItem(string);
    }

    public void setComments(String string) {
        commentsTF.setText(string);
    }

    public void showDeleteErrorMessage() {
        errorMessage.setOpaque(true);
        errorMessage.setText("Group Name is in Used. So can't delete.");
        groupNameTF.requestFocusInWindow();
    }

    private boolean checkPredefinedGroupOrNot(String groupName) {
        if (groupName != null) {
            return groupName.equalsIgnoreCase("Advance Income")
                    || groupName.equalsIgnoreCase("Appreciation")
                    || groupName.equalsIgnoreCase("Bank Accounts")
                    || groupName.equalsIgnoreCase("Bank O/D Account")
                    || groupName.equalsIgnoreCase("Capital Account")
                    || groupName.equalsIgnoreCase("Cash in hand")
                    || groupName.equalsIgnoreCase("Current Assets")
                    || groupName.equalsIgnoreCase("Current Liabilities")
                    || groupName.equalsIgnoreCase("Depreciation")
                    || groupName.equalsIgnoreCase("Drawing")
                    || groupName.equalsIgnoreCase("Duties & Taxes")
                    || groupName.equalsIgnoreCase("Expenses(Direct)")
                    || groupName.equalsIgnoreCase("Expenses(Indirect)")
                    || groupName.equalsIgnoreCase("Fixed Assets")
                    || groupName.equalsIgnoreCase("Income(Direct)")
                    || groupName.equalsIgnoreCase("Income(Indirect)")
                    || groupName.equalsIgnoreCase("Interest on Capital")
                    || groupName.equalsIgnoreCase("Investments")
                    || groupName.equalsIgnoreCase("Loan")
                    || groupName.equalsIgnoreCase("Loans & Advances")
                    || groupName.equalsIgnoreCase("Purchase")
                    || groupName.equalsIgnoreCase("Provision for Doubtful Debts")
                    || groupName.equalsIgnoreCase("Provisions/Expenses Payable")
                    || groupName.equalsIgnoreCase("Outstanding Expenses")
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
}
