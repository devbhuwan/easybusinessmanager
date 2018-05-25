package ui.master;

import java.awt.Color;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.master.account.*;
import ui.master.itemandstore.*;
import ui.master.other.*;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class MasterFrame extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final FeatureFrame featureFrame;
    private final ImageGet imageGet = new ImageGet();
    private AccountCreation accountCreation;
    private AccountGroupCreation accountGroupCreation;
    private CustomerCreation customerCreation;
    private VendorCreation vendorCreation;
    private ItemCreation itemCreation;
    private ItemGroupCreation itemGroupCreation;
    private StoreCreation storeCreation;
    private StoreGroupCreation storeGroupCreation;
    private BillSundryCreation billSundryCreation;
    private UnitCreation unitCreation;
    private final String companyCode;
    private final Connection conn;

    /**
     * Creates new form Master
     *
     * @param mainFrame
     * @param featureFrame
     * @param companyCode
     * @param conn
     *
     */
    public MasterFrame(MainFrame mainFrame, final FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        addButtonOnLabel(accountCreationButton, accountCreationLabel);
        addButtonOnLabel(accountGroupCreationButton, accountGroupCreationLabel);
        addButtonOnLabel(customerCreationButton, customerCreationLabel);
        addButtonOnLabel(vendorCreationButton, vendorCreationLabel);
        addButtonOnLabel(itemCreationButton, itemCreationLabel);
        addButtonOnLabel(itemGroupCreationButton, itemGroupCreationLabel);
        addButtonOnLabel(storeCreationButton, storeCreationLabel);
        addButtonOnLabel(storeGroupCreationButton, storeGroupCreationLabel);
        addButtonOnLabel(unitCreationButton, unitCreationLabel);
        addButtonOnLabel(billSundryCreationButton, billSundryLabel);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        accountCreationButton = new javax.swing.JButton();
        accountGroupCreationButton = new javax.swing.JButton();
        customerCreationButton = new javax.swing.JButton();
        vendorCreationButton = new javax.swing.JButton();
        itemCreationButton = new javax.swing.JButton();
        itemGroupCreationButton = new javax.swing.JButton();
        storeCreationButton = new javax.swing.JButton();
        storeGroupCreationButton = new javax.swing.JButton();
        unitCreationButton = new javax.swing.JButton();
        billSundryCreationButton = new javax.swing.JButton();
        subMenuContainer = new javax.swing.JLayeredPane();
        accountCreationLabel = new javax.swing.JLabel();
        accountGroupCreationLabel = new javax.swing.JLabel();
        customerCreationLabel = new javax.swing.JLabel();
        vendorCreationLabel = new javax.swing.JLabel();
        itemCreationLabel = new javax.swing.JLabel();
        itemGroupCreationLabel = new javax.swing.JLabel();
        bottomLabel = new javax.swing.JLabel();
        storeCreationLabel = new javax.swing.JLabel();
        storeGroupCreationLabel = new javax.swing.JLabel();
        unitCreationLabel = new javax.swing.JLabel();
        billSundryLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        headerTitleLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();

        accountCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        accountCreationButton.setText("Account Creation ");
        accountCreationButton.setBorder(null);
        accountCreationButton.setBorderPainted(false);
        accountCreationButton.setContentAreaFilled(false);
        accountCreationButton.setFocusPainted(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), accountCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        accountCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountCreationButtonActionPerformed(evt);
            }
        });
        accountCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                accountCreationButtonFocusLost(evt);
            }
        });

        accountGroupCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        accountGroupCreationButton.setText("Account Group    ");
        accountGroupCreationButton.setBorder(null);
        accountGroupCreationButton.setBorderPainted(false);
        accountGroupCreationButton.setContentAreaFilled(false);
        accountGroupCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), accountGroupCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        accountGroupCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountGroupCreationButtonActionPerformed(evt);
            }
        });
        accountGroupCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                accountGroupCreationButtonFocusLost(evt);
            }
        });

        customerCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        customerCreationButton.setText("Customer Creation");
        customerCreationButton.setBorder(null);
        customerCreationButton.setBorderPainted(false);
        customerCreationButton.setContentAreaFilled(false);
        customerCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), customerCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        customerCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerCreationButtonActionPerformed(evt);
            }
        });
        customerCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerCreationButtonFocusLost(evt);
            }
        });

        vendorCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        vendorCreationButton.setText("Vendor Creation  ");
        vendorCreationButton.setBorder(null);
        vendorCreationButton.setBorderPainted(false);
        vendorCreationButton.setContentAreaFilled(false);
        vendorCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), vendorCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        vendorCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorCreationButtonActionPerformed(evt);
            }
        });
        vendorCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vendorCreationButtonFocusLost(evt);
            }
        });

        itemCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        itemCreationButton.setText("Item Creation    ");
        itemCreationButton.setBorder(null);
        itemCreationButton.setBorderPainted(false);
        itemCreationButton.setContentAreaFilled(false);
        itemCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        itemCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreationButtonActionPerformed(evt);
            }
        });
        itemCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemCreationButtonFocusLost(evt);
            }
        });

        itemGroupCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        itemGroupCreationButton.setText("Item Group       ");
        itemGroupCreationButton.setBorder(null);
        itemGroupCreationButton.setBorderPainted(false);
        itemGroupCreationButton.setContentAreaFilled(false);
        itemGroupCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), itemGroupCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        itemGroupCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGroupCreationButtonActionPerformed(evt);
            }
        });
        itemGroupCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemGroupCreationButtonFocusLost(evt);
            }
        });

        storeCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        storeCreationButton.setText("Store Creation   ");
        storeCreationButton.setBorder(null);
        storeCreationButton.setBorderPainted(false);
        storeCreationButton.setContentAreaFilled(false);
        storeCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), storeCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        storeCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeCreationButtonActionPerformed(evt);
            }
        });
        storeCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                storeCreationButtonFocusLost(evt);
            }
        });

        storeGroupCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        storeGroupCreationButton.setText("Store Group      ");
        storeGroupCreationButton.setBorder(null);
        storeGroupCreationButton.setBorderPainted(false);
        storeGroupCreationButton.setContentAreaFilled(false);
        storeGroupCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), storeGroupCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        storeGroupCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeGroupCreationButtonActionPerformed(evt);
            }
        });
        storeGroupCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                storeGroupCreationButtonFocusLost(evt);
            }
        });

        unitCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        unitCreationButton.setText("Unit Creation    ");
        unitCreationButton.setBorder(null);
        unitCreationButton.setBorderPainted(false);
        unitCreationButton.setContentAreaFilled(false);
        unitCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), unitCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        unitCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitCreationButtonActionPerformed(evt);
            }
        });
        unitCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                unitCreationButtonFocusLost(evt);
            }
        });

        billSundryCreationButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        billSundryCreationButton.setText("Bill Sundry      ");
        billSundryCreationButton.setBorder(null);
        billSundryCreationButton.setBorderPainted(false);
        billSundryCreationButton.setContentAreaFilled(false);
        billSundryCreationButton.setFocusPainted(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), billSundryCreationButton, org.jdesktop.beansbinding.BeanProperty.create("action"));
        bindingGroup.addBinding(binding);

        billSundryCreationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billSundryCreationButtonActionPerformed(evt);
            }
        });
        billSundryCreationButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                billSundryCreationButtonFocusLost(evt);
            }
        });

        subMenuContainer.setBackground(new java.awt.Color(255, 255, 255));
        subMenuContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        subMenuContainer.setOpaque(true);

        accountCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        accountGroupCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        customerCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        vendorCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        itemCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        itemGroupCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bottomLabel.setOpaque(true);

        storeCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        storeGroupCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        unitCreationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        billSundryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 153, 0));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Master");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout subMenuContainerLayout = new javax.swing.GroupLayout(subMenuContainer);
        subMenuContainer.setLayout(subMenuContainerLayout);
        subMenuContainerLayout.setHorizontalGroup(
            subMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customerCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(accountGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(vendorCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(itemGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(storeCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(storeGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(unitCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(billSundryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(accountCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        subMenuContainerLayout.setVerticalGroup(
            subMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subMenuContainerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(accountCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(accountGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(customerCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(vendorCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(itemCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(itemGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(storeCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(storeGroupCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(unitCreationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(billSundryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(bottomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subMenuContainer.setLayer(accountCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(accountGroupCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(customerCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(vendorCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(itemCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(itemGroupCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(bottomLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(storeCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(storeGroupCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(unitCreationLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(billSundryLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        headerTitleLabel.setBackground(new java.awt.Color(255, 153, 0));
        headerTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleLabel.setOpaque(true);

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subMenuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(containerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subMenuContainer)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void accountGroupCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountGroupCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Account Group Creation");
        activeBackground(accountGroupCreationButton, accountGroupCreationLabel);
        hideAllContentArea();
        if (accountGroupCreation == null) {
            addAccountGroupCreationFrame();
        } else {
            accountGroupCreation.setVisible(true);
        }
    }//GEN-LAST:event_accountGroupCreationButtonActionPerformed

    private void accountGroupCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountGroupCreationButtonFocusLost
        //noActiveBackground(accountGroupCreationButton, accountGroupCreationLabel);
    }//GEN-LAST:event_accountGroupCreationButtonFocusLost

    private void itemCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Item Creation");
        activeBackground(itemCreationButton, itemCreationLabel);
        hideAllContentArea();
        if (itemCreation == null) {
            addItemCreationFrame();
        } else {
            itemCreation.setVisible(true);
        }
    }//GEN-LAST:event_itemCreationButtonActionPerformed

    private void itemCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemCreationButtonFocusLost
        //noActiveBackground(itemCreationButton, itemCreationLabel);
    }//GEN-LAST:event_itemCreationButtonFocusLost

    private void storeCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Store Creation");
        activeBackground(storeCreationButton, storeCreationLabel);
        hideAllContentArea();
        if (storeCreation == null) {
            addStoreCreationFrame();
        } else {
            storeCreation.setVisible(true);
        }
    }//GEN-LAST:event_storeCreationButtonActionPerformed

    private void storeCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_storeCreationButtonFocusLost
        //noActiveBackground(storeCreationButton, storeCreationLabel);
    }//GEN-LAST:event_storeCreationButtonFocusLost

    private void accountCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Account Creation");
        activeBackground(accountCreationButton, accountCreationLabel);
        hideAllContentArea();
        if (accountCreation == null) {
            addAccountCreationFrame();
        } else {
            accountCreation.setVisible(true);
        }
    }//GEN-LAST:event_accountCreationButtonActionPerformed

    private void accountCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountCreationButtonFocusLost
        //noActiveBackground(accountCreationButton, accountCreationLabel);
    }//GEN-LAST:event_accountCreationButtonFocusLost

    private void storeGroupCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeGroupCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Store Group Creation");
        activeBackground(storeGroupCreationButton, storeGroupCreationLabel);
        hideAllContentArea();
        if (storeGroupCreation == null) {
            addStoreGroupCreationFrame();
        } else {
            storeGroupCreation.setVisible(true);
        }
    }//GEN-LAST:event_storeGroupCreationButtonActionPerformed

    private void storeGroupCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_storeGroupCreationButtonFocusLost
        //noActiveBackground(storeGroupCreationButton, storeGroupCreationLabel);
    }//GEN-LAST:event_storeGroupCreationButtonFocusLost

    private void itemGroupCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGroupCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Item Group Creation");
        activeBackground(itemGroupCreationButton, itemGroupCreationLabel);
        hideAllContentArea();
        if (itemGroupCreation == null) {
            addItemGroupCreationFrame();
        } else {
            itemGroupCreation.setVisible(true);
        }
    }//GEN-LAST:event_itemGroupCreationButtonActionPerformed

    private void itemGroupCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemGroupCreationButtonFocusLost
        //noActiveBackground(itemGroupCreationButton, itemGroupCreationLabel);
    }//GEN-LAST:event_itemGroupCreationButtonFocusLost

    private void customerCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Customer Creation");
        activeBackground(customerCreationButton, customerCreationLabel);
        hideAllContentArea();
        if (customerCreation == null) {
            addCustomerCreationFrame();
        } else {
            customerCreation.setVisible(true);
        }
    }//GEN-LAST:event_customerCreationButtonActionPerformed

    private void customerCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerCreationButtonFocusLost
        //noActiveBackground(customerCreationButton, customerCreationLabel);
    }//GEN-LAST:event_customerCreationButtonFocusLost

    private void unitCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Unit Creation");
        activeBackground(unitCreationButton, unitCreationLabel);
        hideAllContentArea();
        if (unitCreation == null) {
            addUnitCreationFrame();
        } else {
            unitCreation.setVisible(true);
        }
    }//GEN-LAST:event_unitCreationButtonActionPerformed

    private void unitCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_unitCreationButtonFocusLost
        //noActiveBackground(unitCreationButton, unitCreationLabel);
    }//GEN-LAST:event_unitCreationButtonFocusLost

    private void vendorCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Vendor Creation");
        activeBackground(vendorCreationButton, vendorCreationLabel);
        hideAllContentArea();
        if (vendorCreation == null) {
            addVendorCreationFrame();
        } else {
            vendorCreation.setVisible(true);
        }
    }//GEN-LAST:event_vendorCreationButtonActionPerformed

    private void vendorCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vendorCreationButtonFocusLost
        //noActiveBackground(vendorCreationButton, vendorCreationLabel);
    }//GEN-LAST:event_vendorCreationButtonFocusLost

    private void billSundryCreationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billSundryCreationButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Bill Sundry Creation");
        activeBackground(billSundryCreationButton, billSundryLabel);
        hideAllContentArea();
        if (billSundryCreation == null) {
            addBillSundryCreationFrame();
        } else {
            billSundryCreation.setVisible(true);
        }
    }//GEN-LAST:event_billSundryCreationButtonActionPerformed

    private void billSundryCreationButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billSundryCreationButtonFocusLost
        //noActiveBackground(billSundryCreationButton, billSundryLabel);
    }//GEN-LAST:event_billSundryCreationButtonFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountCreationButton;
    private javax.swing.JLabel accountCreationLabel;
    private javax.swing.JButton accountGroupCreationButton;
    private javax.swing.JLabel accountGroupCreationLabel;
    private javax.swing.JButton billSundryCreationButton;
    private javax.swing.JLabel billSundryLabel;
    private javax.swing.JLabel bottomLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton customerCreationButton;
    private javax.swing.JLabel customerCreationLabel;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JButton itemCreationButton;
    private javax.swing.JLabel itemCreationLabel;
    private javax.swing.JButton itemGroupCreationButton;
    private javax.swing.JLabel itemGroupCreationLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton storeCreationButton;
    private javax.swing.JLabel storeCreationLabel;
    private javax.swing.JButton storeGroupCreationButton;
    private javax.swing.JLabel storeGroupCreationLabel;
    private javax.swing.JLayeredPane subMenuContainer;
    private javax.swing.JButton unitCreationButton;
    private javax.swing.JLabel unitCreationLabel;
    private javax.swing.JButton vendorCreationButton;
    private javax.swing.JLabel vendorCreationLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void addButtonOnLabel(JButton btn, JLabel label) {
        label.add(btn);
        btn.setBounds(0, 0, 150, 40);
        btn.setVisible(true);
    }

    private void activeBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getActiveButtonIcon());
    }

    private void noActiveBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.black);
        label.setIcon(null);
    }

    private void hideAllContentArea() {
        if (accountCreation != null) {
            accountCreation.setVisible(false);
        }
        if (accountGroupCreation != null) {
            accountGroupCreation.setVisible(false);
        }
        if (customerCreation != null) {
            customerCreation.setVisible(false);
        }
        if (vendorCreation != null) {
            vendorCreation.setVisible(false);
        }
        if (itemCreation != null) {
            itemCreation.setVisible(false);
        }
        if (itemGroupCreation != null) {
            itemGroupCreation.setVisible(false);
        }
        if (storeCreation != null) {
            storeCreation.setVisible(false);
        }
        if (storeGroupCreation != null) {
            storeGroupCreation.setVisible(false);
        }
        if (unitCreation != null) {
            unitCreation.setVisible(false);
        }
        if (billSundryCreation != null) {
            billSundryCreation.setVisible(false);
        }

    }

    private void addAccountGroupCreationFrame() {
        accountGroupCreation = new AccountGroupCreation(companyCode, conn);
        containerPanel.add(accountGroupCreation);
        accountGroupCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        accountGroupCreation.setVisible(true);
    }

    private void addItemCreationFrame() {
        itemCreation = new ItemCreation(companyCode, conn);
        containerPanel.add(itemCreation);
        itemCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        itemCreation.setVisible(true);
    }

    private void addStoreCreationFrame() {
        storeCreation = new StoreCreation(companyCode, conn);
        containerPanel.add(storeCreation);
        storeCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        storeCreation.setVisible(true);
    }

    private void addAccountCreationFrame() {
        accountCreation = new AccountCreation(companyCode, conn);
        containerPanel.add(accountCreation);
        accountCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        accountCreation.setVisible(true);
    }

    private void addStoreGroupCreationFrame() {
        storeGroupCreation = new StoreGroupCreation(companyCode, conn);
        containerPanel.add(storeGroupCreation);
        storeGroupCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        storeGroupCreation.setVisible(true);
    }

    private void addItemGroupCreationFrame() {
        itemGroupCreation = new ItemGroupCreation(companyCode, conn);
        containerPanel.add(itemGroupCreation);
        itemGroupCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        itemGroupCreation.setVisible(true);
    }

    private void addCustomerCreationFrame() {
        customerCreation = new CustomerCreation(companyCode, conn);
        containerPanel.add(customerCreation);
        customerCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        customerCreation.setVisible(true);
    }

    private void addUnitCreationFrame() {
        unitCreation = new UnitCreation(companyCode, conn);
        containerPanel.add(unitCreation);
        unitCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        unitCreation.setVisible(true);
    }

    private void addVendorCreationFrame() {
        vendorCreation = new VendorCreation(companyCode, conn);
        containerPanel.add(vendorCreation);
        vendorCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        vendorCreation.setVisible(true);
    }

    private void addBillSundryCreationFrame() {
        billSundryCreation = new BillSundryCreation(companyCode, conn);
        containerPanel.add(billSundryCreation);
        billSundryCreation.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        billSundryCreation.setVisible(true);
    }

    public void setNullToAllWindows() {
        if (accountCreation != null) {
            accountCreation = null;
        }
        if (accountGroupCreation != null) {
            accountGroupCreation = null;
        }
        if (customerCreation != null) {
            customerCreation = null;
        }
        if (vendorCreation != null) {
            vendorCreation = null;
        }
        if (itemCreation != null) {
            itemCreation = null;
        }
        if (itemGroupCreation != null) {
            itemGroupCreation = null;
        }
        if (storeCreation != null) {
            storeCreation = null;
        }
        if (storeGroupCreation != null) {
            storeGroupCreation = null;
        }
        if (unitCreation != null) {
            unitCreation = null;
        }
        if (billSundryCreation != null) {
            billSundryCreation = null;
        }

    }

    public void resetAllActiveButton(){
        noActiveBackground(accountCreationButton, accountCreationLabel);
        noActiveBackground(accountGroupCreationButton, accountGroupCreationLabel);
        noActiveBackground(customerCreationButton, customerCreationLabel);
        noActiveBackground(vendorCreationButton, vendorCreationLabel);
        noActiveBackground(itemCreationButton, itemCreationLabel);
        noActiveBackground(itemGroupCreationButton, itemGroupCreationLabel);
        noActiveBackground(storeCreationButton, storeCreationLabel);
        noActiveBackground(storeGroupCreationButton, storeGroupCreationLabel);
        noActiveBackground(unitCreationButton, unitCreationLabel);
        noActiveBackground(billSundryCreationButton, billSundryLabel);
    }
}
