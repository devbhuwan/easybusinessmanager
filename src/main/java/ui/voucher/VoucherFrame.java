package ui.voucher;

import ui.voucher.saleandpurchase.SaleReturn;
import ui.voucher.saleandpurchase.SaleRegister;
import ui.voucher.saleandpurchase.PurchaseReturn;
import ui.voucher.saleandpurchase.PurchaseOrder;
import ui.voucher.saleandpurchase.SaleOrder;
import ui.voucher.saleandpurchase.PurchaseRegister;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.voucher.doubleentry.*;
import ui.voucher.production.ProductionVoucher;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class VoucherFrame extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final ImageGet imageGet = new ImageGet();
    private SaleOrder saleOrder;
    private PurchaseOrder purchaseOrder;
    private SaleRegister saleRegister;
    private PurchaseRegister purchaseRegister;
    private SaleReturn saleReturn;
    private PurchaseReturn purchaseReturn;
    private PaymentVoucher paymentVoucher;
    private ReceiptVoucher receiptVoucher;
    private JournalVoucher journalVoucher;
    private ProductionVoucher productionVoucher;
    private final String companyCode;
    private final Connection conn;
    private final FeatureFrame featureFrame;
    private DepositOrWithdraw depositOrWithdraw;

    /**
     * Creates new form Master
     *
     * @param mainFrame
     * @param featureFrame
     * @param companyCode
     * @param conn
     */
    public VoucherFrame(MainFrame mainFrame, FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        addButtonOnLabel(saleOrderButton, saleOrderLabel);
        addButtonOnLabel(purchaseOrderButton, purchaseOrderLabel);
        addButtonOnLabel(saleRegisterButton, saleRegisterLabel);
        addButtonOnLabel(purchaseRegisterButton, purchaseRegisterLabel);
        addButtonOnLabel(saleReturnButton, saleReturnLabel);
        addButtonOnLabel(purchaseReturnButton, purchaseReturnLabel);
        addButtonOnLabel(paymentVoucherButton, paymentVoucherLabel);
        addButtonOnLabel(receiptVoucherButton, receiptVoucherLabel);
        addButtonOnLabel(journalVoucherButton, journalVoucherLabel);
        addButtonOnLabel(productionButton, productionLabel);
        addButtonOnLabel(depositOrWithdrawButton, depositOrWithdrawLabel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        saleOrderButton = new javax.swing.JButton();
        purchaseOrderButton = new javax.swing.JButton();
        saleRegisterButton = new javax.swing.JButton();
        purchaseRegisterButton = new javax.swing.JButton();
        saleReturnButton = new javax.swing.JButton();
        purchaseReturnButton = new javax.swing.JButton();
        paymentVoucherButton = new javax.swing.JButton();
        receiptVoucherButton = new javax.swing.JButton();
        journalVoucherButton = new javax.swing.JButton();
        productionButton = new javax.swing.JButton();
        depositOrWithdrawButton = new javax.swing.JButton();
        subMenuContainer = new javax.swing.JLayeredPane();
        saleOrderLabel = new javax.swing.JLabel();
        purchaseOrderLabel = new javax.swing.JLabel();
        saleRegisterLabel = new javax.swing.JLabel();
        purchaseRegisterLabel = new javax.swing.JLabel();
        saleReturnLabel = new javax.swing.JLabel();
        purchaseReturnLabel = new javax.swing.JLabel();
        bottomLabel = new javax.swing.JLabel();
        paymentVoucherLabel = new javax.swing.JLabel();
        receiptVoucherLabel = new javax.swing.JLabel();
        journalVoucherLabel = new javax.swing.JLabel();
        productionLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        depositOrWithdrawLabel = new javax.swing.JLabel();
        headerTitleLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        containerPanel = new javax.swing.JPanel();

        saleOrderButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        saleOrderButton.setText("Sale Order");
        saleOrderButton.setBorder(null);
        saleOrderButton.setBorderPainted(false);
        saleOrderButton.setContentAreaFilled(false);
        saleOrderButton.setFocusPainted(false);
        saleOrderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, saleOrderLabel, org.jdesktop.beansbinding.ELProperty.create("${focusCycleRoot}"), saleOrderButton, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        saleOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleOrderButtonActionPerformed(evt);
            }
        });
        saleOrderButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                saleOrderButtonFocusLost(evt);
            }
        });

        purchaseOrderButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        purchaseOrderButton.setText("Purchase Order");
        purchaseOrderButton.setBorder(null);
        purchaseOrderButton.setBorderPainted(false);
        purchaseOrderButton.setContentAreaFilled(false);
        purchaseOrderButton.setFocusPainted(false);
        purchaseOrderButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseOrderButtonActionPerformed(evt);
            }
        });
        purchaseOrderButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchaseOrderButtonFocusLost(evt);
            }
        });

        saleRegisterButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        saleRegisterButton.setText("Sale Register");
        saleRegisterButton.setBorder(null);
        saleRegisterButton.setBorderPainted(false);
        saleRegisterButton.setContentAreaFilled(false);
        saleRegisterButton.setFocusPainted(false);
        saleRegisterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saleRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleRegisterButtonActionPerformed(evt);
            }
        });
        saleRegisterButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                saleRegisterButtonFocusLost(evt);
            }
        });

        purchaseRegisterButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        purchaseRegisterButton.setText("Purchase Register");
        purchaseRegisterButton.setBorder(null);
        purchaseRegisterButton.setBorderPainted(false);
        purchaseRegisterButton.setContentAreaFilled(false);
        purchaseRegisterButton.setFocusPainted(false);
        purchaseRegisterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseRegisterButtonActionPerformed(evt);
            }
        });
        purchaseRegisterButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchaseRegisterButtonFocusLost(evt);
            }
        });

        saleReturnButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        saleReturnButton.setText("Sale Return");
        saleReturnButton.setBorder(null);
        saleReturnButton.setBorderPainted(false);
        saleReturnButton.setContentAreaFilled(false);
        saleReturnButton.setFocusPainted(false);
        saleReturnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saleReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleReturnButtonActionPerformed(evt);
            }
        });
        saleReturnButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                saleReturnButtonFocusLost(evt);
            }
        });

        purchaseReturnButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        purchaseReturnButton.setText("Purchase Return");
        purchaseReturnButton.setBorder(null);
        purchaseReturnButton.setBorderPainted(false);
        purchaseReturnButton.setContentAreaFilled(false);
        purchaseReturnButton.setFocusPainted(false);
        purchaseReturnButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purchaseReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseReturnButtonActionPerformed(evt);
            }
        });
        purchaseReturnButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                purchaseReturnButtonFocusLost(evt);
            }
        });

        paymentVoucherButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        paymentVoucherButton.setText("Payment Voucher");
        paymentVoucherButton.setBorder(null);
        paymentVoucherButton.setBorderPainted(false);
        paymentVoucherButton.setContentAreaFilled(false);
        paymentVoucherButton.setFocusPainted(false);
        paymentVoucherButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        paymentVoucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentVoucherButtonActionPerformed(evt);
            }
        });
        paymentVoucherButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                paymentVoucherButtonFocusLost(evt);
            }
        });

        receiptVoucherButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        receiptVoucherButton.setText("Receipt Voucher");
        receiptVoucherButton.setBorder(null);
        receiptVoucherButton.setBorderPainted(false);
        receiptVoucherButton.setContentAreaFilled(false);
        receiptVoucherButton.setFocusPainted(false);
        receiptVoucherButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        receiptVoucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptVoucherButtonActionPerformed(evt);
            }
        });
        receiptVoucherButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                receiptVoucherButtonFocusLost(evt);
            }
        });

        journalVoucherButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        journalVoucherButton.setText("Journal Voucher");
        journalVoucherButton.setBorder(null);
        journalVoucherButton.setBorderPainted(false);
        journalVoucherButton.setContentAreaFilled(false);
        journalVoucherButton.setFocusPainted(false);
        journalVoucherButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        journalVoucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journalVoucherButtonActionPerformed(evt);
            }
        });
        journalVoucherButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                journalVoucherButtonFocusLost(evt);
            }
        });

        productionButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        productionButton.setText("Production");
        productionButton.setBorder(null);
        productionButton.setBorderPainted(false);
        productionButton.setContentAreaFilled(false);
        productionButton.setFocusPainted(false);
        productionButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        productionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productionButtonActionPerformed(evt);
            }
        });
        productionButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                productionButtonFocusLost(evt);
            }
        });

        depositOrWithdrawButton.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        depositOrWithdrawButton.setText("Deposit/Withdraw");
        depositOrWithdrawButton.setBorder(null);
        depositOrWithdrawButton.setBorderPainted(false);
        depositOrWithdrawButton.setContentAreaFilled(false);
        depositOrWithdrawButton.setFocusPainted(false);
        depositOrWithdrawButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        depositOrWithdrawButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                depositOrWithdrawButtonFocusLost(evt);
            }
        });
        depositOrWithdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositOrWithdrawButtonActionPerformed(evt);
            }
        });

        subMenuContainer.setBackground(new java.awt.Color(255, 255, 255));
        subMenuContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        subMenuContainer.setOpaque(true);

        saleOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        purchaseOrderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        saleRegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        purchaseRegisterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        saleReturnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        purchaseReturnLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bottomLabel.setOpaque(true);

        paymentVoucherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        receiptVoucherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        journalVoucherLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        productionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Voucher");
        jLabel2.setOpaque(true);

        depositOrWithdrawLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout subMenuContainerLayout = new javax.swing.GroupLayout(subMenuContainer);
        subMenuContainer.setLayout(subMenuContainerLayout);
        subMenuContainerLayout.setHorizontalGroup(
            subMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saleRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(purchaseOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(purchaseRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saleReturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(purchaseReturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(paymentVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(receiptVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(journalVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(productionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(saleOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(depositOrWithdrawLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        subMenuContainerLayout.setVerticalGroup(
            subMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subMenuContainerLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(saleOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(purchaseOrderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(saleRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(purchaseRegisterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(saleReturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(purchaseReturnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(paymentVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(receiptVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(journalVoucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(productionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(depositOrWithdrawLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subMenuContainer.setLayer(saleOrderLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(purchaseOrderLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(saleRegisterLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(purchaseRegisterLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(saleReturnLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(purchaseReturnLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(bottomLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(paymentVoucherLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(receiptVoucherLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(journalVoucherLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(productionLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenuContainer.setLayer(depositOrWithdrawLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        headerTitleLabel.setBackground(new java.awt.Color(0, 0, 255));
        headerTitleLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        headerTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitleLabel.setOpaque(true);

        jScrollPane2.setBorder(null);

        containerPanel.setPreferredSize(new java.awt.Dimension(950, 580));

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(containerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(subMenuContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(subMenuContainer))
                .addGap(1, 1, 1))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseOrderButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Purchase Order");
        activeBackground(purchaseOrderButton, purchaseOrderLabel);
        hideAllContentArea();
        if (purchaseOrder == null) {
            addPurchaseOrderFrame();
        } else {
            purchaseOrder.setVisible(true);
        }
    }//GEN-LAST:event_purchaseOrderButtonActionPerformed

    private void purchaseOrderButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseOrderButtonFocusLost
        //noActiveBackground(purchaseOrderButton, purchaseOrderLabel);
    }//GEN-LAST:event_purchaseOrderButtonFocusLost

    private void saleReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleReturnButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Sale Return");
        activeBackground(saleReturnButton, saleReturnLabel);
        hideAllContentArea();
        if (saleReturn == null) {
            addSaleReturnFrame();
        } else {
            saleReturn.setVisible(true);
        }
    }//GEN-LAST:event_saleReturnButtonActionPerformed

    private void saleReturnButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saleReturnButtonFocusLost
        //noActiveBackground(saleReturnButton, saleReturnLabel);
    }//GEN-LAST:event_saleReturnButtonFocusLost

    private void paymentVoucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentVoucherButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Payment Voucher");
        activeBackground(paymentVoucherButton, paymentVoucherLabel);
        hideAllContentArea();
        if (paymentVoucher == null) {
            addPaymentVoucherFrame();
        } else {
            paymentVoucher.setVisible(true);
        }
    }//GEN-LAST:event_paymentVoucherButtonActionPerformed

    private void paymentVoucherButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paymentVoucherButtonFocusLost
        //noActiveBackground(paymentVoucherButton, paymentVoucherLabel);
    }//GEN-LAST:event_paymentVoucherButtonFocusLost

    private void saleOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleOrderButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Sale Order");
        activeBackground(saleOrderButton, saleOrderLabel);
        hideAllContentArea();
        if (saleOrder == null) {
            addSaleOrderFrame();
        } else {
            saleOrder.setVisible(true);
        }
    }//GEN-LAST:event_saleOrderButtonActionPerformed

    private void saleOrderButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saleOrderButtonFocusLost
        //noActiveBackground(saleOrderButton, saleOrderLabel);
    }//GEN-LAST:event_saleOrderButtonFocusLost

    private void receiptVoucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptVoucherButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Receipt Voucher");
        activeBackground(receiptVoucherButton, receiptVoucherLabel);
        hideAllContentArea();
        if (receiptVoucher == null) {
            addReceiptVoucherFrame();
        } else {
            receiptVoucher.setVisible(true);
        }
    }//GEN-LAST:event_receiptVoucherButtonActionPerformed

    private void receiptVoucherButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receiptVoucherButtonFocusLost
        //noActiveBackground(receiptVoucherButton, receiptVoucherLabel);
    }//GEN-LAST:event_receiptVoucherButtonFocusLost

    private void purchaseReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseReturnButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Purchase Return");
        activeBackground(purchaseReturnButton, purchaseReturnLabel);
        hideAllContentArea();
        if (purchaseReturn == null) {
            addPurchaseReturnFrame();
        } else {
            purchaseReturn.setVisible(true);
        }
    }//GEN-LAST:event_purchaseReturnButtonActionPerformed

    private void purchaseReturnButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseReturnButtonFocusLost
        //noActiveBackground(purchaseReturnButton, purchaseReturnLabel);
    }//GEN-LAST:event_purchaseReturnButtonFocusLost

    private void saleRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleRegisterButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Sale Register");
        activeBackground(saleRegisterButton, saleRegisterLabel);
        hideAllContentArea();
        if (saleRegister == null) {
            addSaleRegisterFrame();
        } else {
            saleRegister.setVisible(true);
        }
    }//GEN-LAST:event_saleRegisterButtonActionPerformed

    private void saleRegisterButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saleRegisterButtonFocusLost
        // noActiveBackground(saleRegisterButton, saleRegisterLabel);
    }//GEN-LAST:event_saleRegisterButtonFocusLost

    private void journalVoucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalVoucherButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Journal Voucher");
        activeBackground(journalVoucherButton, journalVoucherLabel);
        hideAllContentArea();
        if (journalVoucher == null) {
            addJournalVoucherFrame();
        } else {
            journalVoucher.setVisible(true);
        }
    }//GEN-LAST:event_journalVoucherButtonActionPerformed

    private void journalVoucherButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_journalVoucherButtonFocusLost
        //noActiveBackground(journalVoucherButton, journalVoucherLabel);
    }//GEN-LAST:event_journalVoucherButtonFocusLost

    private void purchaseRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseRegisterButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Purchase Register");
        activeBackground(purchaseRegisterButton, purchaseRegisterLabel);
        hideAllContentArea();
        if (purchaseRegister == null) {
            addPurchaseRegisterFrame();
        } else {
            purchaseRegister.setVisible(true);
        }
    }//GEN-LAST:event_purchaseRegisterButtonActionPerformed

    private void purchaseRegisterButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_purchaseRegisterButtonFocusLost
        //noActiveBackground(purchaseRegisterButton, purchaseRegisterLabel);
    }//GEN-LAST:event_purchaseRegisterButtonFocusLost

    private void productionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productionButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Production");
        activeBackground(productionButton, productionLabel);
        hideAllContentArea();
        if (productionVoucher == null) {
            addProductionFrame();
        } else {
            productionVoucher.setVisible(true);
        }
    }//GEN-LAST:event_productionButtonActionPerformed

    private void productionButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_productionButtonFocusLost
        //noActiveBackground(productionButton, productionLabel);
    }//GEN-LAST:event_productionButtonFocusLost

    private void depositOrWithdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositOrWithdrawButtonActionPerformed
        resetAllActiveButton();
        headerTitleLabel.setText("Deposit/Withdraw");
        activeBackground(depositOrWithdrawButton, depositOrWithdrawLabel);
        hideAllContentArea();
        if (depositOrWithdraw == null) {
            addDepositWithdrawFrame();
        } else {
            depositOrWithdraw.setVisible(true);
        }
    }//GEN-LAST:event_depositOrWithdrawButtonActionPerformed

    private void depositOrWithdrawButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositOrWithdrawButtonFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_depositOrWithdrawButtonFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottomLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton depositOrWithdrawButton;
    private javax.swing.JLabel depositOrWithdrawLabel;
    private javax.swing.JLabel headerTitleLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton journalVoucherButton;
    private javax.swing.JLabel journalVoucherLabel;
    private javax.swing.JButton paymentVoucherButton;
    private javax.swing.JLabel paymentVoucherLabel;
    private javax.swing.JButton productionButton;
    private javax.swing.JLabel productionLabel;
    private javax.swing.JButton purchaseOrderButton;
    private javax.swing.JLabel purchaseOrderLabel;
    private javax.swing.JButton purchaseRegisterButton;
    private javax.swing.JLabel purchaseRegisterLabel;
    private javax.swing.JButton purchaseReturnButton;
    private javax.swing.JLabel purchaseReturnLabel;
    private javax.swing.JButton receiptVoucherButton;
    private javax.swing.JLabel receiptVoucherLabel;
    private javax.swing.JButton saleOrderButton;
    private javax.swing.JLabel saleOrderLabel;
    private javax.swing.JButton saleRegisterButton;
    private javax.swing.JLabel saleRegisterLabel;
    private javax.swing.JButton saleReturnButton;
    private javax.swing.JLabel saleReturnLabel;
    private javax.swing.JLayeredPane subMenuContainer;
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
        if (saleOrder != null) {
            saleOrder.setVisible(false);
        }
        if (purchaseOrder != null) {
            purchaseOrder.setVisible(false);
        }
        if (saleRegister != null) {
            saleRegister.setVisible(false);
        }
        if (purchaseRegister != null) {
            purchaseRegister.setVisible(false);
        }
        if (saleReturn != null) {
            saleReturn.setVisible(false);
        }
        if (purchaseReturn != null) {
            purchaseReturn.setVisible(false);
        }
        if (paymentVoucher != null) {
            paymentVoucher.setVisible(false);
        }
        if (receiptVoucher != null) {
            receiptVoucher.setVisible(false);
        }
        if (journalVoucher != null) {
            journalVoucher.setVisible(false);
        }
        if (productionVoucher != null) {
            productionVoucher.setVisible(false);
        }
        if (depositOrWithdraw != null) {
            depositOrWithdraw.setVisible(false);
        }
    }

    public void setNullToAllWindows() {
        if (saleOrder != null) {
            saleOrder = null;
        }
        if (purchaseOrder != null) {
            purchaseOrder = null;
        }
        if (saleRegister != null) {
            saleRegister = null;
        }
        if (purchaseRegister != null) {
            saleReturn = null;
        }
        if (saleReturn != null) {
            purchaseRegister = null;
        }
        if (purchaseReturn != null) {
            purchaseReturn = null;
        }
        if (paymentVoucher != null) {
            paymentVoucher = null;
        }
        if (receiptVoucher != null) {
            receiptVoucher = null;
        }
        if (journalVoucher != null) {
            journalVoucher = null;
        }
        if (productionVoucher != null) {
            productionVoucher = null;
        }
        if (depositOrWithdraw != null) {
            depositOrWithdraw = null;
        }
    }

    private void addSaleOrderFrame() {
        saleOrder = new SaleOrder(mainFrame, companyCode, conn);
        containerPanel.add(saleOrder);
        saleOrder.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        saleOrder.setVoucherNumber(companyCode, conn);
        saleOrder.setVisible(true);
    }

    private void addPurchaseOrderFrame() {
        purchaseOrder = new PurchaseOrder(mainFrame, companyCode, conn);
        containerPanel.add(purchaseOrder);
        purchaseOrder.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        purchaseOrder.setVoucherNumber(companyCode, conn);
        purchaseOrder.setVisible(true);
    }

    private void addSaleRegisterFrame() {
        saleRegister = new SaleRegister(mainFrame, companyCode, conn);
        containerPanel.add(saleRegister);
        saleRegister.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        saleRegister.setVoucherNumber(companyCode, conn);
        saleRegister.setVisible(true);
    }

    private void addPurchaseRegisterFrame() {
        purchaseRegister = new PurchaseRegister(mainFrame, companyCode, conn);
        containerPanel.add(purchaseRegister);
        purchaseRegister.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        purchaseRegister.setVoucherNumber(companyCode, conn);
        purchaseRegister.setVisible(true);
    }

    private void addSaleReturnFrame() {
        saleReturn = new SaleReturn(mainFrame, companyCode, conn);
        containerPanel.add(saleReturn);
        saleReturn.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        saleReturn.setVoucherNumber(companyCode, conn);
        saleReturn.setVisible(true);
    }

    private void addPurchaseReturnFrame() {
        purchaseReturn = new PurchaseReturn(mainFrame, companyCode, conn);
        containerPanel.add(purchaseReturn);
        purchaseReturn.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        purchaseReturn.setVoucherNumber(companyCode, conn);
        purchaseReturn.setVisible(true);
    }

    private void addPaymentVoucherFrame() {
        paymentVoucher = new PaymentVoucher(mainFrame, companyCode, conn);
        containerPanel.add(paymentVoucher);
        paymentVoucher.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        paymentVoucher.setVoucherNumber(companyCode, conn);
        paymentVoucher.setVisible(true);
    }

    private void addReceiptVoucherFrame() {
        receiptVoucher = new ReceiptVoucher(mainFrame, companyCode, conn);
        containerPanel.add(receiptVoucher);
        receiptVoucher.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        receiptVoucher.setVoucherNumber(companyCode, conn);
        receiptVoucher.setVisible(true);
    }

    private void addJournalVoucherFrame() {
        journalVoucher = new JournalVoucher(mainFrame, companyCode, conn);
        containerPanel.add(journalVoucher);
        journalVoucher.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        journalVoucher.setVoucherNumber(companyCode, conn);
        journalVoucher.setVisible(true);
    }

    private void addProductionFrame() {
        productionVoucher = new ProductionVoucher(mainFrame, companyCode, conn);
        containerPanel.add(productionVoucher);
        productionVoucher.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        productionVoucher.setVoucherNumber(companyCode, conn);
        productionVoucher.setVisible(true);
    }
    
    private void addDepositWithdrawFrame() {
        depositOrWithdraw = new DepositOrWithdraw(mainFrame, companyCode, conn);
        containerPanel.add(depositOrWithdraw);
        depositOrWithdraw.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        depositOrWithdraw.setVoucherNumber(companyCode, conn);
        depositOrWithdraw.setVisible(true);
    }

    public void resetAllActiveButton() {
        noActiveBackground(saleOrderButton, saleOrderLabel);
        noActiveBackground(purchaseOrderButton, purchaseOrderLabel);
        noActiveBackground(saleRegisterButton, saleRegisterLabel);
        noActiveBackground(purchaseRegisterButton, purchaseRegisterLabel);
        noActiveBackground(saleReturnButton, saleReturnLabel);
        noActiveBackground(purchaseReturnButton, purchaseReturnLabel);
        noActiveBackground(paymentVoucherButton, paymentVoucherLabel);
        noActiveBackground(receiptVoucherButton, receiptVoucherLabel);
        noActiveBackground(journalVoucherButton, journalVoucherLabel);
        noActiveBackground(productionButton, productionLabel);
        noActiveBackground(depositOrWithdrawButton, depositOrWithdrawLabel);
    }
}
