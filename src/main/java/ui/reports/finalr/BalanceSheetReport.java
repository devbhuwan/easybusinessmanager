/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.finalr;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import ui.feature.TableUI;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.reports.print.BalanceSheetNotesTaker;
import ui.reports.print.action.FinalReportPrint;
import ui.reports.selector.DateWiseReportDialog;
import ui.reports.utils.TotalAccPayable;
import ui.reports.utils.TotalAccRecievable;
import ui.reports.utils.TotalAdvanceIncome;
import ui.reports.utils.TotalAppreciation;
import ui.reports.utils.TotalBandOD;
import ui.reports.utils.TotalBankAmount;
import ui.reports.utils.TotalCapital;
import ui.reports.utils.TotalCashAmount;
import ui.reports.utils.TotalClosingStock;
import ui.reports.utils.TotalCurrentAssets;
import ui.reports.utils.TotalCurrentLisbilities;
import ui.reports.utils.TotalDepreciation;
import ui.reports.utils.TotalDrawings;
import ui.reports.utils.TotalExpenses;
import ui.reports.utils.TotalFixedAssets;
import ui.reports.utils.TotalIncomes;
import ui.reports.utils.TotalIntersetOnCapital;
import ui.reports.utils.TotalInvestment;
import ui.reports.utils.TotalLoan;
import ui.reports.utils.TotalLoanAndAdvance;
import ui.reports.utils.TotalNetLossOrProfit;
import ui.reports.utils.TotalOpeningStock;
import ui.reports.utils.TotalOtherAssets;
import ui.reports.utils.TotalOtherLiabilities;
import ui.reports.utils.TotalOutStandingExpense;
import ui.reports.utils.TotalProvisionAndDoubt;
import ui.reports.utils.TotalProvisionExpensesPay;
import ui.reports.utils.TotalPurchase;
import ui.reports.utils.TotalReserveAndSurplus;
import ui.reports.utils.TotalSale;
import ui.reports.utils.TotalSecuredLoan;
import ui.reports.utils.TotalSecurityAndDeposit;
import ui.reports.utils.TotalSundryCr;
import ui.reports.utils.TotalSundryDebtors;
import ui.reports.utils.TotalUnsecuredLoan;

/**
 *
 * @author Vimal
 */
public class BalanceSheetReport extends javax.swing.JFrame implements TableModelListener {

    private final MainFrame mainFrame;
    private final String companyCode;
    private Calendar cal;
    private Calendar cal1;
    private final DateWiseReportDialog dialog;
    private TotalOpeningStock totOpeningStock;
    private TotalFixedAssets totFixedAssets;
    private TotalCurrentAssets totCurrentAsset;
    private TotalInvestment totInvestment;
    private TotalExpenses totExpenses;
    private TotalDrawings totDrawing;
    private TotalPurchase totPurchase;
    private BalanceSheetNotesTaker notesTaker;
    private String notes;
    private FinalReportPrint print;

    /**
     * Creates new form TradingAccountReport
     *
     * @param mainFrame
     * @param companyCode
     * @param dialog
     */
    public BalanceSheetReport(MainFrame mainFrame, String companyCode, DateWiseReportDialog dialog) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.dialog = dialog;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        firstReportTable.setTableHeader(new TableUI().getTableHeaderUI(firstReportTable));
        secondReportTable.setTableHeader(new TableUI().getTableHeaderUI(secondReportTable));
        firstReportTable.getModel().addTableModelListener((TableModelListener) this);
        secondReportTable.getModel().addTableModelListener((TableModelListener) this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateFromL = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dateToL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        panelContainer = new javax.swing.JPanel();
        firstPanelScrollPane = new javax.swing.JScrollPane();
        firstReportTable = new javax.swing.JTable();
        loadingLabel = new javax.swing.JLabel();
        secondPanelScrollPane = new javax.swing.JScrollPane();
        secondReportTable = new javax.swing.JTable();
        reloadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balance Sheet Report");
        setIconImage(new ImageGet().getBuzLogo().getImage());
        setMinimumSize(new java.awt.Dimension(1013, 409));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        dateFromL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        dateFromL.setForeground(new java.awt.Color(0, 0, 255));

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Balance Sheet");
        jLabel3.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Date To :");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Date From :");

        dateToL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        dateToL.setForeground(new java.awt.Color(0, 0, 255));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.selectionBackground"));

        backButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        printButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        printButton.setText("Print");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addGap(21, 21, 21))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, printButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, printButton});

        firstPanelScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        firstReportTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        firstReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "Fixed Assets", null,  new Integer(1), "Capital", null},
                {null, "ADD: Appreciation     ", null, null, "", null},
                {null, "LESS: Depreciation", null, null, "LESS: Drawings", null},
                { new Integer(2), "Investments", null, null, "ADD: Interset On Capital", null},
                { new Integer(3), "Account Receivable", null,  new Integer(2), "Reserve and Surplus", null},
                {null, "LESS: Provision for Doubtful Debts", null,  new Integer(3), "Loan", null},
                {null, "Security and Deposits", null, null, "Secured Loan", null},
                {null, "Sundry Debtors", null, null, "Unsecured Loan", null},
                {null, "Loans and Advances", null, null, "Bank O/D", null},
                { new Integer(4), "Cash In hand", null,  new Integer(4), "Accounts Payable", null},
                { new Integer(5), "Bank", null, null, "Provision / Expenses Payable", null},
                { new Integer(6), "Stock In hand", null, null, "Outstanding Expenses", null},
                { new Integer(7), "Other Assets", null, null, "Advance Income", null},
                {null, null, null, null, "Sundry Creditors", null},
                {null, null, null,  new Integer(5), "Other Liabilities", null},
                {null, null, null, null, null, null},
                {null, "Total Assets", null, null, "Total Liabilities", null}
            },
            new String [] {
                "S. N.", "Assets", "Amount", "S. N.", "Liabilities", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        firstReportTable.setFocusable(false);
        firstReportTable.setRowHeight(25);
        firstReportTable.setSelectionBackground(new java.awt.Color(0, 0, 204));
        firstReportTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        firstReportTable.getTableHeader().setReorderingAllowed(false);
        firstReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstReportTableMouseClicked(evt);
            }
        });
        firstPanelScrollPane.setViewportView(firstReportTable);
        if (firstReportTable.getColumnModel().getColumnCount() > 0) {
            firstReportTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            firstReportTable.getColumnModel().getColumn(1).setPreferredWidth(500);
            firstReportTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            firstReportTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            firstReportTable.getColumnModel().getColumn(4).setPreferredWidth(600);
            firstReportTable.getColumnModel().getColumn(5).setPreferredWidth(400);
        }

        loadingLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(51, 51, 51));
        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/loader.gif"))); // NOI18N
        loadingLabel.setText("Loading...");
        loadingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        secondPanelScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        secondReportTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        secondReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Account Number", "Account Name", "Group Name", "Under Group", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        secondReportTable.setFocusable(false);
        secondReportTable.setRowHeight(25);
        secondReportTable.setSelectionBackground(new java.awt.Color(0, 0, 204));
        secondReportTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        secondReportTable.getTableHeader().setReorderingAllowed(false);
        secondPanelScrollPane.setViewportView(secondReportTable);
        if (secondReportTable.getColumnModel().getColumnCount() > 0) {
            secondReportTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            secondReportTable.getColumnModel().getColumn(1).setPreferredWidth(500);
            secondReportTable.getColumnModel().getColumn(1).setHeaderValue("Account Number");
            secondReportTable.getColumnModel().getColumn(2).setPreferredWidth(600);
            secondReportTable.getColumnModel().getColumn(3).setPreferredWidth(600);
            secondReportTable.getColumnModel().getColumn(3).setHeaderValue("Group Name");
            secondReportTable.getColumnModel().getColumn(4).setPreferredWidth(600);
            secondReportTable.getColumnModel().getColumn(5).setPreferredWidth(400);
        }

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContainerLayout.createSequentialGroup()
                    .addContainerGap(472, Short.MAX_VALUE)
                    .addComponent(loadingLabel)
                    .addContainerGap(473, Short.MAX_VALUE)))
            .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(secondPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContainerLayout.createSequentialGroup()
                    .addContainerGap(203, Short.MAX_VALUE)
                    .addComponent(loadingLabel)
                    .addContainerGap(204, Short.MAX_VALUE)))
            .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelContainerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(secondPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        reloadButton.setText("Reload");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFromL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateToL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reloadButton)
                .addContainerGap())
            .addComponent(panelContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateFromL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateToL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(reloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (firstPanelScrollPane.isVisible()) {
            this.dispose();
            dialog.setVisible(true);
        } else if (secondPanelScrollPane.isVisible()) {
            secondPanelScrollPane.setVisible(false);
            firstPanelScrollPane.setVisible(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
 if (firstReportTable.getRowCount() > 2) {
            notesTaker = new BalanceSheetNotesTaker(this, true);
            notesTaker.setLocationRelativeTo(this);
            notesTaker.setVisible(true);
        }       

    }//GEN-LAST:event_printButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        for (int i = 0; i < firstReportTable.getRowCount(); i++) {
            firstReportTable.setValueAt(null, i, 2);
            firstReportTable.setValueAt(null, i, 5);
        }
        fetchInfo();
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void firstReportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstReportTableMouseClicked

    }//GEN-LAST:event_firstReportTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dateFromL;
    private javax.swing.JLabel dateToL;
    private javax.swing.JScrollPane firstPanelScrollPane;
    private javax.swing.JTable firstReportTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JButton printButton;
    private javax.swing.JButton reloadButton;
    private javax.swing.JScrollPane secondPanelScrollPane;
    private javax.swing.JTable secondReportTable;
    // End of variables declaration//GEN-END:variables

    public void setDates(Calendar date, Calendar date1) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        cal = date;
        cal1 = date1;
        String fromDate = format.format(cal.getTime());
        String toDate = format.format(cal1.getTime());
        dateFromL.setText(fromDate);
        dateToL.setText(toDate);
    }

    public void fetchInfo() {
        reloadButton.setVisible(false);
        firstPanelScrollPane.setVisible(false);
        secondPanelScrollPane.setVisible(false);
        loadingLabel.setVisible(true);

        new Thread(new Runnable() {
            private TotalCapital totCapital;
            private TotalReserveAndSurplus totReserveAndSurPlus;
            private TotalCurrentLisbilities totCurrentLiabilities;
            private TotalLoan totLoan;
            private TotalSale totSale;
            private TotalIncomes totIncomes;
            private TotalAppreciation totAppreciation;
            private TotalDepreciation totDepreciation;
            private TotalAccRecievable totAccountRecievable;
            private TotalProvisionAndDoubt totProvisionAndDoubt;
            private TotalSecurityAndDeposit totSecAdnDep;
            private TotalSundryDebtors totSudryDr;
            private TotalLoanAndAdvance totLoanAndAd;
            private TotalBankAmount totBankAmt;
            private TotalCashAmount totCashAmt;
            private TotalClosingStock totStockInhand;
            private TotalOtherAssets totOtherAssets;
            private TotalNetLossOrProfit totNetLOrP;
            private TotalIntersetOnCapital totIntersetOnCap;
            private TotalSecuredLoan totSecuredLoan;
            private TotalUnsecuredLoan totUnsecuredLoan;
            private TotalBandOD totBankOd;
            private TotalAccPayable totAccPayable;
            private TotalProvisionExpensesPay totProPay;
            private TotalOutStandingExpense totOoutstanEx;
            private TotalAdvanceIncome totAdvanceIn;
            private TotalSundryCr totSundrCr;
            private TotalOtherLiabilities totOtherLia;

            @Override
            public void run() {
                totFixedAssets = new TotalFixedAssets(mainFrame, companyCode, firstReportTable, cal, cal1, 0, 2);
                totAppreciation = new TotalAppreciation(mainFrame, companyCode, firstReportTable, cal, cal1, 1, 2);
                totDepreciation = new TotalDepreciation(mainFrame, companyCode, firstReportTable, cal, cal1, 2, 2);
                totInvestment = new TotalInvestment(mainFrame, companyCode, firstReportTable, cal, cal1, 3, 2);
                totAccountRecievable = new TotalAccRecievable(mainFrame, companyCode, firstReportTable, cal, cal1, 7, 2);
                totProvisionAndDoubt = new TotalProvisionAndDoubt(mainFrame, companyCode, firstReportTable, cal, cal1, 5, 2);
                totSecAdnDep = new TotalSecurityAndDeposit(mainFrame, companyCode, firstReportTable, cal, cal1, 6, 2);
                totSudryDr = new TotalSundryDebtors(mainFrame, companyCode, firstReportTable, cal, cal1, 4, 2);
                totLoanAndAd = new TotalLoanAndAdvance(mainFrame, companyCode, firstReportTable, cal, cal1, 8, 2);
                totCashAmt = new TotalCashAmount(mainFrame, companyCode, firstReportTable, cal, cal1, 9, 2);
                totBankAmt = new TotalBankAmount(mainFrame, companyCode, firstReportTable, cal, cal1, 10, 2);
                totStockInhand = new TotalClosingStock(mainFrame, companyCode, firstReportTable, cal, cal1, 11, 2);
                totOtherAssets = new TotalOtherAssets(mainFrame, companyCode, firstReportTable, cal, cal1, 12, 2);

                totCapital = new TotalCapital(mainFrame, companyCode, firstReportTable, cal, cal1, 0, 5);
                totNetLOrP = new TotalNetLossOrProfit(mainFrame, companyCode, firstReportTable, cal, cal1);
                totDrawing = new TotalDrawings(mainFrame, companyCode, firstReportTable, cal, cal1, 2, 5);
                totIntersetOnCap = new TotalIntersetOnCapital(mainFrame, companyCode, firstReportTable, cal, cal1, 3, 5);
                totReserveAndSurPlus = new TotalReserveAndSurplus(mainFrame, companyCode, firstReportTable, cal, cal1, 4, 5);
                totSecuredLoan = new TotalSecuredLoan(mainFrame, companyCode, firstReportTable, cal, cal1, 6, 5);
                totUnsecuredLoan = new TotalUnsecuredLoan(mainFrame, companyCode, firstReportTable, cal, cal1, 7, 5);
                totBankOd = new TotalBandOD(mainFrame, companyCode, firstReportTable, cal, cal1, 8, 5);
                totAccPayable = new TotalAccPayable(mainFrame, companyCode, firstReportTable, cal, cal1, 13, 5);
                totProPay = new TotalProvisionExpensesPay(mainFrame, companyCode, firstReportTable, cal, cal1, 10, 5);
                totOoutstanEx = new TotalOutStandingExpense(mainFrame, companyCode, firstReportTable, cal, cal1, 11, 5);
                totAdvanceIn = new TotalAdvanceIncome(mainFrame, companyCode, firstReportTable, cal, cal1, 12, 5);
                totSundrCr = new TotalSundryCr(mainFrame, companyCode, firstReportTable, cal, cal1, 9, 5);
                totOtherLia = new TotalOtherLiabilities(mainFrame, companyCode, firstReportTable, cal, cal1, 14, 5);

                totFixedAssets.runIn();
                totAppreciation.runIn();
                totDepreciation.runIn();
                totInvestment.runIn();
                totAccountRecievable.runIn();
                totProvisionAndDoubt.runIn();
                totSecAdnDep.runIn();
                totSudryDr.runIn();
                totLoanAndAd.runIn();
                totBankAmt.runIn();
                totCashAmt.runIn();
                totStockInhand.runIn();
                totOtherAssets.runIn();

                totCapital.runIn();
                totNetLOrP.runIn();
                totDrawing.runIn();
                totIntersetOnCap.runIn();
                totReserveAndSurPlus.runIn();
                totSecuredLoan.runIn();
                totUnsecuredLoan.runIn();
                totBankOd.runIn();
                totAccPayable.runIn();
                totProPay.runIn();
                totOoutstanEx.runIn();
                totAdvanceIn.runIn();
                totSundrCr.runIn();
                totOtherLia.runIn();
                setFirstTableTotalValues();
            }
        }).start();
    }

    public String roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int leftCounter = 0;
        int rightCounter = 0;
        for (int i = 0; i < 15; i++) {
            if (firstReportTable.getValueAt(i, 2) != null) {
                leftCounter++;
            }
            if (firstReportTable.getValueAt(i, 5) != null) {
                rightCounter++;
            }
            if (leftCounter == 13 && rightCounter == 14) {
                loadingLabel.setVisible(false);
                firstPanelScrollPane.setVisible(true);
                reloadButton.setVisible(true);
            }
        }

    }

    private void setFirstTableTotalValues() {
        Double debitPlus = 0.0;
        Double creditPlus = 0.0;
        Double debitMinus = 0.0;
        Double creditMinus = 0.0;
        for (int i = 0; i < firstReportTable.getRowCount() - 2; i++) {
            try {
                switch (i) {
                    case 2:
                        debitMinus = debitMinus + Double.valueOf(firstReportTable.getValueAt(i, 2).toString());
                        break;
                    case 5:
                        debitMinus = debitMinus + Double.valueOf(firstReportTable.getValueAt(i, 2).toString());
                        break;
                    default:
                        debitPlus = debitPlus + Double.valueOf(firstReportTable.getValueAt(i, 2).toString());
                        break;
                }
            } catch (NumberFormatException | NullPointerException ex) {
            }
            try {
                switch (i) {
                    case 1:
                        if (firstReportTable.getValueAt(i, 4) != null) {
                            if (firstReportTable.getValueAt(i, 4).toString().startsWith("ADD")) {
                                creditPlus = creditPlus + Double.valueOf(firstReportTable.getValueAt(i, 5).toString());
                            } else if (firstReportTable.getValueAt(i, 4).toString().startsWith("LESS")) {
                                creditMinus = creditMinus + Double.valueOf(firstReportTable.getValueAt(i, 5).toString());
                            }
                        }
                        break;
                    case 2:
                        creditMinus = creditMinus + Double.valueOf(firstReportTable.getValueAt(i, 5).toString());
                        break;
                    default:
                        creditPlus = creditPlus + Double.valueOf(firstReportTable.getValueAt(i, 5).toString());

                }
            } catch (NumberFormatException | NullPointerException ex) {
            }
        }
        firstReportTable.setValueAt(Math.abs(debitMinus - debitPlus), 16, 2);
        firstReportTable.setValueAt(Math.abs(creditMinus - creditPlus), 16, 5);
    }
    
     public void printTable(String notes, String reportName) {
        String envDirectory = System.getenv("ProgramFiles");
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/reports/" + companyCode + "/");
        Path pathForReport = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/reports/" + companyCode + "/", reportName + ".pdf");
        if (Files.exists(path)) {
            if (Files.exists(pathForReport)) {
                notesTaker.setVisible(false);
                int optionPane = JOptionPane.showConfirmDialog(null, "Report already exist. \n Do you want override the file ?", "Warning", JOptionPane.WARNING_MESSAGE);
                if (optionPane == 0) {
                    this.notes = notes;
                    print = new FinalReportPrint(mainFrame, companyCode, firstReportTable, notes, cal, cal1, reportName, "BALANCE SHEET");
                    print.prepare();
                    print.print();
                    notesTaker.dispose();
                } else {
                    notesTaker.setVisible(true);
                }
            } else {
                this.notes = notes;
                print = new FinalReportPrint(mainFrame, companyCode, firstReportTable, notes, cal, cal1, reportName, "BALANCE SHEET");
                print.prepare();
                print.print();
                notesTaker.dispose();
            }
        } else {
            this.notes = notes;
            print = new FinalReportPrint(mainFrame, companyCode, firstReportTable, notes, cal, cal1, reportName, "BALANCE SHEET");
            print.prepare();
            print.print();
            notesTaker.dispose();
        }
    }
}
