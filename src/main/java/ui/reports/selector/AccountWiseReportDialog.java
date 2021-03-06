package ui.reports.selector;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import ui.main.MainFrame;
import ui.reports.ReportUtils;
import ui.reports.finalr.AccountStatement;
import ui.reports.finalr.BankBookReport;
import ui.reports.finalr.CashBookReport;
import ui.reports.finalr.CreditNoteReport;
import ui.reports.finalr.DebitNoteReport;
import ui.reports.finalr.JournalReport;
import ui.reports.finalr.PurchaseReport;
import ui.reports.finalr.SalesReport;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AccountWiseReportDialog extends javax.swing.JDialog {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final String msg;
    private PreparedStatement ps;
    private ResultSet rs;
    private int totalHeight = 0;
    private int count = 0;
    private JournalReport journalReport;
    private CashBookReport cashBook;
    private BankBookReport bankBook;
    private PurchaseReport purchaseReport;
    private SalesReport saleReport;
    private DebitNoteReport debitReport;
    private CreditNoteReport creditReport;
    private AccountStatement accountantStatement;

    /**
     * Creates new form MonthWiseReportDialog
     *
     * @param mainFrame
     * @param modal
     * @param companyCode
     * @param msg
     */
    public AccountWiseReportDialog(MainFrame mainFrame, boolean modal, String companyCode, String msg) {
        super(mainFrame, modal);
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.msg = msg;
        dateChooserCombo1.setFormat(1);
        dateChooserCombo2.setFormat(1);
        Calendar c = Calendar.getInstance();
        Date temp = new ReportUtils().getCompanyBeginnigDate(mainFrame.getConnection(), companyCode);
        c.setTime(temp);
        dateChooserCombo1.setSelectedDate(c);
        dateChooserCombo1.setMinDate(c);
        dateChooserCombo2.setMinDate(c);
        headerTitle.setText(msg);
        this.setTitle(msg);
        switch (msg) {
            case "Journal Report":
                fetchAccountNumber(companyCode);
                break;
            case "Account Statement":
                fetchAccountNumber(companyCode);
                break;
            case "Cash Book":
                fetchAccountNumberOfGroup(companyCode, "Cash in hand");
                break;
            case "Bank Book":
                fetchAccountNumberOfGroup(companyCode, "Bank Accounts");
                break;
            case "Purchase Report":
                fetchAccountNumberOfGroup(companyCode, "Purchase");
                break;
            case "Sale Report":
                fetchAccountNumberOfGroup(companyCode, "Sale");
                break;
            case "Debit Note Report":
                fetchAccountNumberOfGroup(companyCode, "Purchase");
                break;
            case "Credit Note Report":
                fetchAccountNumberOfGroup(companyCode, "Sale");
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        accNoScrollPane = new javax.swing.JScrollPane();
        accNoList = new javax.swing.JPanel();
        selectAndUnselectAllCHB = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        showButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerTitle.setBackground(new java.awt.Color(0, 153, 153));
        headerTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        headerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitle.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Date From :");

        dateChooserCombo1.setNothingAllowed(false);
        dateChooserCombo1.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 13));
        dateChooserCombo1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserCombo1OnSelectionChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Date To :");

        dateChooserCombo2.setNothingAllowed(false);
        dateChooserCombo2.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 13));
        dateChooserCombo2.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserCombo2OnSelectionChange(evt);
            }
        });

        accNoScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        accNoScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        accNoScrollPane.setPreferredSize(new java.awt.Dimension(510, 316));

        accNoList.setBackground(new java.awt.Color(255, 255, 255));
        accNoList.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        accNoList.setPreferredSize(new java.awt.Dimension(510, 300));

        javax.swing.GroupLayout accNoListLayout = new javax.swing.GroupLayout(accNoList);
        accNoList.setLayout(accNoListLayout);
        accNoListLayout.setHorizontalGroup(
            accNoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        accNoListLayout.setVerticalGroup(
            accNoListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        accNoScrollPane.setViewportView(accNoList);

        selectAndUnselectAllCHB.setBackground(new java.awt.Color(255, 255, 255));
        selectAndUnselectAllCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        selectAndUnselectAllCHB.setText("Select All / Unselect All");
        selectAndUnselectAllCHB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAndUnselectAllCHBActionPerformed(evt);
            }
        });

        jLabel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Account Number");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectAndUnselectAllCHB)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accNoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(accNoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAndUnselectAllCHB)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        showButton.setBackground(new java.awt.Color(0, 153, 153));
        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(0, 153, 153));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66)
                .addComponent(showButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton)
                .addGap(32, 32, 32))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exitButton, showButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        Calendar c = dateChooserCombo1.getSelectedDate();
        Calendar c1 = dateChooserCombo2.getSelectedDate();
        int co = 0;
        if ((c1.getTimeInMillis() - c.getTimeInMillis()) > 0) {
            ArrayList<String> selectedAccNo = new ArrayList<>();
            for (Component com : accNoList.getComponents()) {
                JCheckBox box = (JCheckBox) com;
                if (box.isSelected()) {
                    selectedAccNo.add(box.getText());
                    co++;
                }
            }
            switch (msg) {
                case "Journal Report":
                    journalReport = new JournalReport(mainFrame, companyCode, this);
                    journalReport.setDates(c, c1);
                    journalReport.setLocationRelativeTo(mainFrame);
                    journalReport.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    journalReport.setVisible(true);
                    break;
                case "Cash Book":
                    cashBook = new CashBookReport(mainFrame, companyCode, this);
                    cashBook.setDates(c, c1);
                    cashBook.setLocationRelativeTo(mainFrame);
                    cashBook.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    cashBook.setVisible(true);
                    break;
                case "Bank Book":
                    bankBook = new BankBookReport(mainFrame, companyCode, this);
                    bankBook.setDates(c, c1);
                    bankBook.setLocationRelativeTo(mainFrame);
                    bankBook.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    bankBook.setVisible(true);
                    break;
                case "Purchase Report":
                    purchaseReport = new PurchaseReport(mainFrame, companyCode, this);
                    purchaseReport.setDates(c, c1);
                    purchaseReport.setLocationRelativeTo(mainFrame);
                    purchaseReport.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    purchaseReport.setVisible(true);
                    break;
                case "Sale Report":
                    saleReport = new SalesReport(mainFrame, companyCode, this);
                    saleReport.setDates(c, c1);
                    saleReport.setLocationRelativeTo(mainFrame);
                    saleReport.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    saleReport.setVisible(true);
                    break;
                case "Debit Note Report":
                    debitReport = new DebitNoteReport(mainFrame, companyCode, this);
                    debitReport.setDates(c, c1);
                    debitReport.setLocationRelativeTo(mainFrame);
                    debitReport.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    debitReport.setVisible(true);
                    break;
                case "Credit Note Report":
                    creditReport = new CreditNoteReport(mainFrame, companyCode, this);
                    creditReport.setDates(c, c1);
                    creditReport.setLocationRelativeTo(mainFrame);
                    creditReport.fetchInfo(selectedAccNo);
                    this.setVisible(false);
                    creditReport.setVisible(true);
                    break;

                case "Account Statement":
                    int ccc = accNoList.getComponentCount();
                    if (ccc == co) {
                        accountantStatement = new AccountStatement(mainFrame, companyCode, this);
                        accountantStatement.setDates(c, c1);
                        accountantStatement.setLocationRelativeTo(mainFrame);
                        accountantStatement.fetchInfo(selectedAccNo);
                        this.setVisible(false);
                        accountantStatement.setVisible(true);
                    }
                    break;

            }
        } else {
            errorMessage.setText("Please, Select date approriately.");
        }

    }//GEN-LAST:event_showButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void selectAndUnselectAllCHBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAndUnselectAllCHBActionPerformed
        if (selectAndUnselectAllCHB.isSelected()) {
            for (Component c : accNoList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(true);
            }
        } else {
            for (Component c : accNoList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(false);
            }
        }
    }//GEN-LAST:event_selectAndUnselectAllCHBActionPerformed

    private void dateChooserCombo1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnSelectionChange


    }//GEN-LAST:event_dateChooserCombo1OnSelectionChange

    private void dateChooserCombo2OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo2OnSelectionChange

    }//GEN-LAST:event_dateChooserCombo2OnSelectionChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accNoList;
    private javax.swing.JScrollPane accNoScrollPane;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox selectAndUnselectAllCHB;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables

    private void fetchAccountNumber(String companyCode) {
        totalHeight = 0;
        String sql = "select accountNumber from ACCOUNT_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNo = rs.getString("accountNumber");
                JCheckBox box = new JCheckBox(accountNo);
                accNoList.add(box, count);
                box.setBounds(0, count * 20, accNoList.getWidth(), 20);
                box.setBackground(Color.white);
                totalHeight = totalHeight + 20;
                box.setVisible(true);
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AccountWiseReportDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        accNoList.setPreferredSize(new Dimension(accNoScrollPane.getWidth() - 100, totalHeight));
    }

    private void fetchAccountNumberOfGroup(String companyCode, String group) {
        ArrayList<String> cashAccNo = new ReportUtils().getAccountNumber(companyCode, group, mainFrame);
        for (String s : cashAccNo) {
            JCheckBox box = new JCheckBox(s);
            accNoList.add(box, count);
            box.setBounds(0, count * 20, accNoList.getWidth(), 20);
            box.setBackground(Color.white);
            totalHeight = totalHeight + 20;
            box.setVisible(true);
            count++;
        }
        accNoList.setPreferredSize(new Dimension(accNoScrollPane.getWidth() - 100, totalHeight));
    }
}
