/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.finalr;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import ui.feature.TableUI;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.reports.selector.DateWiseReportDialog;
import ui.reports.utils.TotalBandOD;
import ui.reports.utils.TotalCapital;
import ui.reports.utils.TotalCashFlowLoan;
import ui.reports.utils.TotalDirectExpenses;
import ui.reports.utils.TotalDrawings;
import ui.reports.utils.TotalExceptCashCurrentAssets;
import ui.reports.utils.TotalInDeCurrentLiabilities;
import ui.reports.utils.TotalIncomes;
import ui.reports.utils.TotalIndirectExpenses;
import ui.reports.utils.TotalInvestment;
import ui.reports.utils.TotalLoanAndAdvance;
import ui.reports.utils.TotalLoanRepaymenPaid;
import ui.reports.utils.TotalLoanRepaymenReceived;
import ui.reports.utils.TotalPurchase;
import ui.reports.utils.TotalPurchaseOfFixedAssets;
import ui.reports.utils.TotalSale;
import ui.reports.utils.TotalSaleOfFixedAssets;
import ui.reports.utils.TotalSaleOfInvestment;

/**
 *
 * @author Vimal
 */
public class CashFlowReport extends javax.swing.JFrame implements TableModelListener {

    private final MainFrame mainFrame;
    private final String companyCode;
    private Calendar cal;
    private Calendar cal1;
    private final DateWiseReportDialog dialog;
    private TotalPurchase totPurchase;
    private TotalDirectExpenses totDirectExpenses;
    private TotalSale totSale;
    private TotalIndirectExpenses totIndirectEx;
    private TotalIncomes totIncome;
    private TotalInvestment totInvest;
    private TotalLoanAndAdvance totLoanAndAd;
    private TotalCapital totCap;
    private TotalDrawings totDra;
    private TotalCashFlowLoan totLoan;
    private TotalBandOD totBOD;

    /**
     * Creates new form TradingAccountReport
     *
     * @param mainFrame
     * @param companyCode
     * @param dialog
     */
    public CashFlowReport(MainFrame mainFrame, String companyCode, DateWiseReportDialog dialog) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.dialog = dialog;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        firstReportTable.setTableHeader(new TableUI().getTableHeaderUI(firstReportTable));
        firstReportTable.getModel().addTableModelListener((TableModelListener) this);
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
        reloadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cash Flow Statement");
        setIconImage(new ImageGet().getBuzLogo().getImage());
        setMinimumSize(new java.awt.Dimension(1013, 409));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        dateFromL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        dateFromL.setForeground(new java.awt.Color(0, 0, 255));

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cash Flow Statement");
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
                {null, "From Operating Activities", null, null},
                { new Integer(1), "Sales A/c", null, null},
                { new Integer(2), "Purchase A/c", null, null},
                { new Integer(3), "Direct Expenses", null, null},
                { new Integer(4), "Indirect Expenses", null, null},
                { new Integer(5), "Incomes", null, null},
                { new Integer(6), "Decrease in except cash Current Assets", null, null},
                { new Integer(7), "Increase in except cash Current Assets", null, null},
                { new Integer(8), "Increase in Current Liabilities", null, null},
                { new Integer(9), "Decrease in Current Liabilities", null, null},
                {null, "From Investing Activities", null, null},
                { new Integer(1), "Sale of Fixed Assets", null, null},
                { new Integer(2), "Purchase of Fixed Assets", null, null},
                { new Integer(3), "Investment", null, null},
                { new Integer(4), "Sale of Investment", null, null},
                { new Integer(5), "Loan Repayment Received", null, null},
                { new Integer(6), "Loans and Advances", null, null},
                {null, "From Financing Activities", null, null},
                { new Integer(1), "Capital", null, null},
                { new Integer(2), "Drawings", null, null},
                { new Integer(3), "Loan", null, null},
                { new Integer(4), "Loan Repayment Paid", null, null},
                { new Integer(5), "Bank O/D", null, null},
                {null, null, null, null},
                {null, "Total Debit", null, null},
                {null, null, null, null}
            },
            new String [] {
                "S. N.", "Description", "Cash Inflows", "Cash Outflows"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class
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
            firstReportTable.getColumnModel().getColumn(3).setPreferredWidth(400);
        }

        loadingLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(51, 51, 51));
        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/loader.gif"))); // NOI18N
        loadingLabel.setText("Loading...");
        loadingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

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
        this.dispose();
        dialog.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        

    }//GEN-LAST:event_printButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        for (int i = 0; i < firstReportTable.getRowCount(); i++) {
            firstReportTable.setValueAt(null, i, 2);
            firstReportTable.setValueAt(null, i, 3);
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
        loadingLabel.setVisible(true);

        new Thread(new Runnable() {
            private TotalLoanRepaymenPaid totLoaRePa;
            private TotalSaleOfFixedAssets totSaleFA;
            private TotalPurchaseOfFixedAssets totPurFA;
            private TotalSaleOfInvestment totSaleInv;
            private TotalLoanRepaymenReceived totLoaRe;
            private TotalExceptCashCurrentAssets totExceptCash;
            private TotalInDeCurrentLiabilities totCurrent;

            @Override
            public void run() {
                totSale = new TotalSale(mainFrame, companyCode, firstReportTable, cal, cal1, 1, 2);
                totPurchase = new TotalPurchase(mainFrame, companyCode, firstReportTable, cal, cal1, 2, 3);
                totDirectExpenses = new TotalDirectExpenses(mainFrame, companyCode, firstReportTable, cal, cal1, 3, 3);
                totIndirectEx = new TotalIndirectExpenses(mainFrame, companyCode, firstReportTable, cal, cal1, 4, 3);
                totIncome = new TotalIncomes(mainFrame, companyCode, firstReportTable, cal, cal1, 5, 2);
                totExceptCash = new TotalExceptCashCurrentAssets(mainFrame, companyCode, firstReportTable, cal, cal1, 6, 2);
                totCurrent = new TotalInDeCurrentLiabilities(mainFrame, companyCode, firstReportTable, cal, cal1, 8, 2);
                totSaleFA = new TotalSaleOfFixedAssets(mainFrame, companyCode, firstReportTable, cal, cal1, 11, 2);
                totPurFA = new TotalPurchaseOfFixedAssets(mainFrame, companyCode, firstReportTable, cal, cal1, 12, 3);
                totInvest = new TotalInvestment(mainFrame, companyCode, firstReportTable, cal, cal1, 13, 3);
                totSaleInv = new TotalSaleOfInvestment(mainFrame, companyCode, firstReportTable, cal, cal1, 14, 2);
                totLoaRe = new TotalLoanRepaymenReceived(mainFrame, companyCode, firstReportTable, cal, cal1, 15, 2);
                totLoanAndAd = new TotalLoanAndAdvance(mainFrame, companyCode, firstReportTable, cal, cal1, 16, 3);
                totCap = new TotalCapital(mainFrame, companyCode, firstReportTable, cal, cal1, 18, 2);
                totDra = new TotalDrawings(mainFrame, companyCode, firstReportTable, cal, cal1, 19, 3);
                totLoan = new TotalCashFlowLoan(mainFrame, companyCode, firstReportTable, cal, cal1, 20, 2);
                totLoaRePa = new TotalLoanRepaymenPaid(mainFrame, companyCode, firstReportTable, cal, cal1, 21, 3);
                totBOD = new TotalBandOD(mainFrame, companyCode, firstReportTable, cal, cal1, 22, 2);
                totSale.runIn();
                totPurchase.runIn();
                totDirectExpenses.runIn();
                totIndirectEx.runIn();
                totIncome.runIn();
                totExceptCash.runIn();
                totCurrent.runIn();
                totSaleFA.runIn();
                totPurFA.runIn();
                totInvest.runIn();
                totSaleInv.runIn();
                totLoaRe.runIn();
                totLoanAndAd.runIn();
                totCap.runIn();
                totDra.runIn();
                totLoan.runIn();
                totLoaRePa.runIn();
                totBOD.runIn();
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
        if (totBOD.isIsFinished()) {
            loadingLabel.setVisible(false);
            firstPanelScrollPane.setVisible(true);
            reloadButton.setVisible(true);
        }

    }

    private void setFirstTableTotalValues() {
        Double debit = 0.0;
        Double credit = 0.0;
        for (int i = 0; i < firstReportTable.getRowCount() - 3; i++) {
            try {
                debit = debit + Double.valueOf(firstReportTable.getValueAt(i, 2).toString());
            } catch (NumberFormatException | NullPointerException ex) {
            }
            try {
                credit = credit + Double.valueOf(firstReportTable.getValueAt(i, 3).toString());
            } catch (NumberFormatException | NullPointerException ex) {
            }
        }
        firstReportTable.setValueAt(debit, firstReportTable.getRowCount() - 2, 2);
        firstReportTable.setValueAt(credit, firstReportTable.getRowCount() - 2, 3);
        Double sepAmount = Math.abs(debit - credit);
        if (debit > credit) {
            firstReportTable.setValueAt("BALANCE", firstReportTable.getRowCount() - 1, 1);
            firstReportTable.setValueAt(sepAmount, firstReportTable.getRowCount() - 1, 2);
        } else {
            firstReportTable.setValueAt(null, firstReportTable.getRowCount() - 1, 1);
            firstReportTable.setValueAt(null, firstReportTable.getRowCount() - 1, 2);

        }
    }

}
