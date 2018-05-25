package ui.reports;

import java.awt.Color;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.reports.selector.AccountWiseReportDialog;
import ui.reports.selector.DateWiseReportDialog;
import ui.reports.selector.DayWiseReportDialog;
import ui.reports.selector.ItemWiseReportDialog;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ReportFrame extends javax.swing.JPanel {

    private final MainFrame mainFrame;
    private final FeatureFrame featureFrame;
    private final String companyCode;
    private final Connection conn;
    private final ImageGet imageGet = new ImageGet();
    private DateWiseReportDialog dateWiseReport;
    private AccountWiseReportDialog accountWiseReport;
    private ItemWiseReportDialog itemWiseReport;
    private DayWiseReportDialog dayWiseReport;

    /**
     * Creates new form ReportFrame
     *
     * @param mainFrame
     * @param companyCode
     * @param featureFrame
     * @param conn
     */
    public ReportFrame(MainFrame mainFrame, FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        ratioAnalysisButton.setEnabled(false);
        cashFlowStatementButton.setEnabled(false);
        addButtonOnLabel(trailBalanceButton, trailBalanceLabel);
        addButtonOnLabel(tradingAccountButton, tradingAccountLabel);
        addButtonOnLabel(profitAndLossReportButton, profitAndLossReportLabel);
        addButtonOnLabel(balanceSheetButton, balanceSheetLabel);
        addButtonOnLabel(cashFlowStatementButton, cashFlowStatementLabel);
        addButtonOnLabel(accountStatementButton, accountStatementLabel);
        addButtonOnLabel(dayBookButton, dayBookLabel);
        addButtonOnLabel(cashBookButton, cashBookLabel);
        addButtonOnLabel(bankBookButton, bankBookLabel);
        addButtonOnLabel(journalBookButton, journalBookLabel);
        addButtonOnLabel(debitNoteReportButton, debitNoteReportLabel);
        addButtonOnLabel(creditNoteReportButton, creditNoteReportLabel);
        addButtonOnLabel(stockReportButton, stockReportLabel);
        addButtonOnLabel(saleReportButton, saleReportLabel);
        addButtonOnLabel(purchaseReportButton, purchaseReportLabel);
        addButtonOnLabel(productionReportButton, productionReportLabel);
        addButtonOnLabel(ratioAnalysisButton, ratioAnalysisLabel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trailBalanceButton = new javax.swing.JButton();
        tradingAccountButton = new javax.swing.JButton();
        profitAndLossReportButton = new javax.swing.JButton();
        balanceSheetButton = new javax.swing.JButton();
        cashFlowStatementButton = new javax.swing.JButton();
        accountStatementButton = new javax.swing.JButton();
        dayBookButton = new javax.swing.JButton();
        cashBookButton = new javax.swing.JButton();
        bankBookButton = new javax.swing.JButton();
        journalBookButton = new javax.swing.JButton();
        debitNoteReportButton = new javax.swing.JButton();
        creditNoteReportButton = new javax.swing.JButton();
        stockReportButton = new javax.swing.JButton();
        saleReportButton = new javax.swing.JButton();
        purchaseReportButton = new javax.swing.JButton();
        productionReportButton = new javax.swing.JButton();
        ratioAnalysisButton = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        finalReport = new javax.swing.JLayeredPane();
        trailBalanceLabel = new javax.swing.JLabel();
        tradingAccountLabel = new javax.swing.JLabel();
        profitAndLossReportLabel = new javax.swing.JLabel();
        balanceSheetLabel = new javax.swing.JLabel();
        cashFlowStatementLabel = new javax.swing.JLabel();
        accountsReport = new javax.swing.JLayeredPane();
        accountStatementLabel = new javax.swing.JLabel();
        dayBookLabel = new javax.swing.JLabel();
        cashBookLabel = new javax.swing.JLabel();
        bankBookLabel = new javax.swing.JLabel();
        journalBookLabel = new javax.swing.JLabel();
        debitAndCreditNoteReport = new javax.swing.JLayeredPane();
        debitNoteReportLabel = new javax.swing.JLabel();
        creditNoteReportLabel = new javax.swing.JLabel();
        otherReports = new javax.swing.JLayeredPane();
        stockReportLabel = new javax.swing.JLabel();
        saleReportLabel = new javax.swing.JLabel();
        purchaseReportLabel = new javax.swing.JLabel();
        productionReportLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ratioAnalysisReport = new javax.swing.JLayeredPane();
        ratioAnalysisLabel = new javax.swing.JLabel();

        trailBalanceButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        trailBalanceButton.setForeground(new java.awt.Color(255, 255, 255));
        trailBalanceButton.setText("Trial Balance");
        trailBalanceButton.setBorder(null);
        trailBalanceButton.setBorderPainted(false);
        trailBalanceButton.setContentAreaFilled(false);
        trailBalanceButton.setFocusPainted(false);
        trailBalanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trailBalanceButtonActionPerformed(evt);
            }
        });

        tradingAccountButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tradingAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        tradingAccountButton.setText("Trading Account");
        tradingAccountButton.setBorder(null);
        tradingAccountButton.setBorderPainted(false);
        tradingAccountButton.setContentAreaFilled(false);
        tradingAccountButton.setFocusPainted(false);
        tradingAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradingAccountButtonActionPerformed(evt);
            }
        });

        profitAndLossReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        profitAndLossReportButton.setForeground(new java.awt.Color(255, 255, 255));
        profitAndLossReportButton.setText("Profit And Loss Report");
        profitAndLossReportButton.setBorder(null);
        profitAndLossReportButton.setBorderPainted(false);
        profitAndLossReportButton.setContentAreaFilled(false);
        profitAndLossReportButton.setFocusPainted(false);
        profitAndLossReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profitAndLossReportButtonActionPerformed(evt);
            }
        });

        balanceSheetButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        balanceSheetButton.setForeground(new java.awt.Color(255, 255, 255));
        balanceSheetButton.setText("Balance Sheet");
        balanceSheetButton.setBorder(null);
        balanceSheetButton.setBorderPainted(false);
        balanceSheetButton.setContentAreaFilled(false);
        balanceSheetButton.setFocusPainted(false);
        balanceSheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceSheetButtonActionPerformed(evt);
            }
        });

        cashFlowStatementButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        cashFlowStatementButton.setForeground(new java.awt.Color(255, 255, 255));
        cashFlowStatementButton.setText("Cash Flow Statement");
        cashFlowStatementButton.setBorder(null);
        cashFlowStatementButton.setBorderPainted(false);
        cashFlowStatementButton.setContentAreaFilled(false);
        cashFlowStatementButton.setFocusPainted(false);
        cashFlowStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashFlowStatementButtonActionPerformed(evt);
            }
        });

        accountStatementButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        accountStatementButton.setForeground(new java.awt.Color(255, 255, 255));
        accountStatementButton.setText("Account Statement");
        accountStatementButton.setBorder(null);
        accountStatementButton.setBorderPainted(false);
        accountStatementButton.setContentAreaFilled(false);
        accountStatementButton.setFocusPainted(false);
        accountStatementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountStatementButtonActionPerformed(evt);
            }
        });

        dayBookButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        dayBookButton.setForeground(new java.awt.Color(255, 255, 255));
        dayBookButton.setText("Day Book");
        dayBookButton.setBorder(null);
        dayBookButton.setBorderPainted(false);
        dayBookButton.setContentAreaFilled(false);
        dayBookButton.setFocusPainted(false);
        dayBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayBookButtonActionPerformed(evt);
            }
        });

        cashBookButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        cashBookButton.setForeground(new java.awt.Color(255, 255, 255));
        cashBookButton.setText("Cash Book");
        cashBookButton.setBorder(null);
        cashBookButton.setBorderPainted(false);
        cashBookButton.setContentAreaFilled(false);
        cashBookButton.setFocusPainted(false);
        cashBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashBookButtonActionPerformed(evt);
            }
        });

        bankBookButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        bankBookButton.setForeground(new java.awt.Color(255, 255, 255));
        bankBookButton.setText("Bank Book");
        bankBookButton.setBorder(null);
        bankBookButton.setBorderPainted(false);
        bankBookButton.setContentAreaFilled(false);
        bankBookButton.setFocusPainted(false);
        bankBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankBookButtonActionPerformed(evt);
            }
        });

        journalBookButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        journalBookButton.setForeground(new java.awt.Color(255, 255, 255));
        journalBookButton.setText("Journal Book");
        journalBookButton.setBorder(null);
        journalBookButton.setBorderPainted(false);
        journalBookButton.setContentAreaFilled(false);
        journalBookButton.setFocusPainted(false);
        journalBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journalBookButtonActionPerformed(evt);
            }
        });

        debitNoteReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        debitNoteReportButton.setForeground(new java.awt.Color(255, 255, 255));
        debitNoteReportButton.setText("Debit Note Report");
        debitNoteReportButton.setBorder(null);
        debitNoteReportButton.setBorderPainted(false);
        debitNoteReportButton.setContentAreaFilled(false);
        debitNoteReportButton.setFocusPainted(false);
        debitNoteReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debitNoteReportButtonActionPerformed(evt);
            }
        });

        creditNoteReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        creditNoteReportButton.setForeground(new java.awt.Color(255, 255, 255));
        creditNoteReportButton.setText("Credit Note Report");
        creditNoteReportButton.setBorder(null);
        creditNoteReportButton.setBorderPainted(false);
        creditNoteReportButton.setContentAreaFilled(false);
        creditNoteReportButton.setFocusPainted(false);
        creditNoteReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditNoteReportButtonActionPerformed(evt);
            }
        });

        stockReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        stockReportButton.setForeground(new java.awt.Color(255, 255, 255));
        stockReportButton.setText("Stock Report");
        stockReportButton.setBorder(null);
        stockReportButton.setBorderPainted(false);
        stockReportButton.setContentAreaFilled(false);
        stockReportButton.setFocusPainted(false);
        stockReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockReportButtonActionPerformed(evt);
            }
        });

        saleReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        saleReportButton.setForeground(new java.awt.Color(255, 255, 255));
        saleReportButton.setText("Sale Report");
        saleReportButton.setBorder(null);
        saleReportButton.setBorderPainted(false);
        saleReportButton.setContentAreaFilled(false);
        saleReportButton.setFocusPainted(false);
        saleReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleReportButtonActionPerformed(evt);
            }
        });

        purchaseReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        purchaseReportButton.setForeground(new java.awt.Color(255, 255, 255));
        purchaseReportButton.setText("Purchase Report");
        purchaseReportButton.setBorder(null);
        purchaseReportButton.setBorderPainted(false);
        purchaseReportButton.setContentAreaFilled(false);
        purchaseReportButton.setFocusPainted(false);
        purchaseReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseReportButtonActionPerformed(evt);
            }
        });

        productionReportButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        productionReportButton.setForeground(new java.awt.Color(255, 255, 255));
        productionReportButton.setText("Production Report");
        productionReportButton.setBorder(null);
        productionReportButton.setBorderPainted(false);
        productionReportButton.setContentAreaFilled(false);
        productionReportButton.setFocusPainted(false);
        productionReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productionReportButtonActionPerformed(evt);
            }
        });

        ratioAnalysisButton.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        ratioAnalysisButton.setForeground(new java.awt.Color(255, 255, 255));
        ratioAnalysisButton.setText("Ratio Analysis");
        ratioAnalysisButton.setBorder(null);
        ratioAnalysisButton.setBorderPainted(false);
        ratioAnalysisButton.setContentAreaFilled(false);
        ratioAnalysisButton.setFocusPainted(false);
        ratioAnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratioAnalysisButtonActionPerformed(evt);
            }
        });

        header.setBackground(new java.awt.Color(0, 102, 102));
        header.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Accounting Reports");
        header.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        finalReport.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Final Report"));

        trailBalanceLabel.setBackground(new java.awt.Color(0, 102, 102));
        trailBalanceLabel.setOpaque(true);

        tradingAccountLabel.setBackground(new java.awt.Color(0, 102, 102));
        tradingAccountLabel.setOpaque(true);

        profitAndLossReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        profitAndLossReportLabel.setOpaque(true);

        balanceSheetLabel.setBackground(new java.awt.Color(0, 102, 102));
        balanceSheetLabel.setOpaque(true);

        cashFlowStatementLabel.setOpaque(true);

        javax.swing.GroupLayout finalReportLayout = new javax.swing.GroupLayout(finalReport);
        finalReport.setLayout(finalReportLayout);
        finalReportLayout.setHorizontalGroup(
            finalReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(finalReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profitAndLossReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trailBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tradingAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceSheetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashFlowStatementLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        finalReportLayout.setVerticalGroup(
            finalReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trailBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tradingAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profitAndLossReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceSheetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cashFlowStatementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        finalReport.setLayer(trailBalanceLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        finalReport.setLayer(tradingAccountLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        finalReport.setLayer(profitAndLossReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        finalReport.setLayer(balanceSheetLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        finalReport.setLayer(cashFlowStatementLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        accountsReport.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Accounts Report"));

        accountStatementLabel.setBackground(new java.awt.Color(0, 102, 102));
        accountStatementLabel.setOpaque(true);

        dayBookLabel.setBackground(new java.awt.Color(0, 102, 102));
        dayBookLabel.setOpaque(true);

        cashBookLabel.setBackground(new java.awt.Color(0, 102, 102));
        cashBookLabel.setOpaque(true);

        bankBookLabel.setBackground(new java.awt.Color(0, 102, 102));
        bankBookLabel.setOpaque(true);

        journalBookLabel.setBackground(new java.awt.Color(0, 102, 102));
        journalBookLabel.setOpaque(true);

        javax.swing.GroupLayout accountsReportLayout = new javax.swing.GroupLayout(accountsReport);
        accountsReport.setLayout(accountsReportLayout);
        accountsReportLayout.setHorizontalGroup(
            accountsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountsReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accountStatementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(journalBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        accountsReportLayout.setVerticalGroup(
            accountsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountsReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountStatementLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cashBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bankBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(journalBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        accountsReport.setLayer(accountStatementLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accountsReport.setLayer(dayBookLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accountsReport.setLayer(cashBookLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accountsReport.setLayer(bankBookLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        accountsReport.setLayer(journalBookLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        debitAndCreditNoteReport.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Debit And Credit Report"));

        debitNoteReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        debitNoteReportLabel.setOpaque(true);

        creditNoteReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        creditNoteReportLabel.setOpaque(true);

        javax.swing.GroupLayout debitAndCreditNoteReportLayout = new javax.swing.GroupLayout(debitAndCreditNoteReport);
        debitAndCreditNoteReport.setLayout(debitAndCreditNoteReportLayout);
        debitAndCreditNoteReportLayout.setHorizontalGroup(
            debitAndCreditNoteReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(debitAndCreditNoteReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(debitAndCreditNoteReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(debitNoteReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditNoteReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        debitAndCreditNoteReportLayout.setVerticalGroup(
            debitAndCreditNoteReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(debitAndCreditNoteReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(debitNoteReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditNoteReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        debitAndCreditNoteReport.setLayer(debitNoteReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        debitAndCreditNoteReport.setLayer(creditNoteReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        otherReports.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Other Reports"));

        stockReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        stockReportLabel.setOpaque(true);

        saleReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        saleReportLabel.setOpaque(true);

        purchaseReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        purchaseReportLabel.setOpaque(true);

        productionReportLabel.setBackground(new java.awt.Color(0, 102, 102));
        productionReportLabel.setOpaque(true);

        javax.swing.GroupLayout otherReportsLayout = new javax.swing.GroupLayout(otherReports);
        otherReports.setLayout(otherReportsLayout);
        otherReportsLayout.setHorizontalGroup(
            otherReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(otherReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saleReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purchaseReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productionReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        otherReportsLayout.setVerticalGroup(
            otherReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saleReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productionReportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        otherReports.setLayer(stockReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        otherReports.setLayer(saleReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        otherReports.setLayer(purchaseReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        otherReports.setLayer(productionReportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setBackground(new java.awt.Color(21, 86, 82));
        jLabel1.setOpaque(true);

        ratioAnalysisReport.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Ratio Analysis"));

        ratioAnalysisLabel.setOpaque(true);

        javax.swing.GroupLayout ratioAnalysisReportLayout = new javax.swing.GroupLayout(ratioAnalysisReport);
        ratioAnalysisReport.setLayout(ratioAnalysisReportLayout);
        ratioAnalysisReportLayout.setHorizontalGroup(
            ratioAnalysisReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratioAnalysisReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ratioAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ratioAnalysisReportLayout.setVerticalGroup(
            ratioAnalysisReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratioAnalysisReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ratioAnalysisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ratioAnalysisReport.setLayer(ratioAnalysisLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(otherReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(debitAndCreditNoteReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratioAnalysisReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(accountsReport, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(finalReport, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(debitAndCreditNoteReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ratioAnalysisReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(otherReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void balanceSheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceSheetButtonActionPerformed
        dateWiseReport = new DateWiseReportDialog(mainFrame, true, companyCode, "Balance Sheet Report");
        dateWiseReport.setLocationRelativeTo(mainFrame);
        dateWiseReport.setVisible(true);
    }//GEN-LAST:event_balanceSheetButtonActionPerformed

    private void trailBalanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailBalanceButtonActionPerformed
        dateWiseReport = new DateWiseReportDialog(mainFrame, true, companyCode, "Trial Balance");
        dateWiseReport.setLocationRelativeTo(mainFrame);
        dateWiseReport.setVisible(true);
    }//GEN-LAST:event_trailBalanceButtonActionPerformed

    private void profitAndLossReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profitAndLossReportButtonActionPerformed
        dateWiseReport = new DateWiseReportDialog(mainFrame, true, companyCode, "Profit and Loss Report");
        dateWiseReport.setLocationRelativeTo(mainFrame);
        dateWiseReport.setVisible(true);
    }//GEN-LAST:event_profitAndLossReportButtonActionPerformed

    private void accountStatementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountStatementButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Account Statement");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_accountStatementButtonActionPerformed

    private void dayBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayBookButtonActionPerformed
        dayWiseReport = new DayWiseReportDialog(mainFrame, true, companyCode, "Day Book");
        dayWiseReport.setLocationRelativeTo(mainFrame);
        dayWiseReport.setVisible(true);
    }//GEN-LAST:event_dayBookButtonActionPerformed

    private void cashBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashBookButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Cash Book");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_cashBookButtonActionPerformed

    private void journalBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalBookButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Journal Report");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_journalBookButtonActionPerformed

    private void debitNoteReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debitNoteReportButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Debit Note Report");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_debitNoteReportButtonActionPerformed

    private void creditNoteReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditNoteReportButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Credit Note Report");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_creditNoteReportButtonActionPerformed

    private void stockReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockReportButtonActionPerformed
        itemWiseReport = new ItemWiseReportDialog(mainFrame, true, companyCode, "Stock Report");
        itemWiseReport.setLocationRelativeTo(mainFrame);
        itemWiseReport.setVisible(true);
    }//GEN-LAST:event_stockReportButtonActionPerformed

    private void saleReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleReportButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Sale Report");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_saleReportButtonActionPerformed

    private void purchaseReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseReportButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Purchase Report");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_purchaseReportButtonActionPerformed

    private void productionReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productionReportButtonActionPerformed
        itemWiseReport = new ItemWiseReportDialog(mainFrame, true, companyCode, "Production Report");
        itemWiseReport.setLocationRelativeTo(mainFrame);
        itemWiseReport.setVisible(true);
    }//GEN-LAST:event_productionReportButtonActionPerformed

    private void bankBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankBookButtonActionPerformed
        accountWiseReport = new AccountWiseReportDialog(mainFrame, true, companyCode, "Bank Book");
        accountWiseReport.setLocationRelativeTo(mainFrame);
        accountWiseReport.setVisible(true);
    }//GEN-LAST:event_bankBookButtonActionPerformed

    private void tradingAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradingAccountButtonActionPerformed
        dateWiseReport = new DateWiseReportDialog(mainFrame, true, companyCode, "Trading Account Report");
        dateWiseReport.setLocationRelativeTo(mainFrame);
        dateWiseReport.setVisible(true);
    }//GEN-LAST:event_tradingAccountButtonActionPerformed

    private void cashFlowStatementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashFlowStatementButtonActionPerformed
        dateWiseReport = new DateWiseReportDialog(mainFrame, true, companyCode, "Cash Flow Statement");
        dateWiseReport.setLocationRelativeTo(mainFrame);
        dateWiseReport.setVisible(true);
    }//GEN-LAST:event_cashFlowStatementButtonActionPerformed

    private void ratioAnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratioAnalysisButtonActionPerformed

    }//GEN-LAST:event_ratioAnalysisButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountStatementButton;
    private javax.swing.JLabel accountStatementLabel;
    private javax.swing.JLayeredPane accountsReport;
    private javax.swing.JButton balanceSheetButton;
    private javax.swing.JLabel balanceSheetLabel;
    private javax.swing.JButton bankBookButton;
    private javax.swing.JLabel bankBookLabel;
    private javax.swing.JButton cashBookButton;
    private javax.swing.JLabel cashBookLabel;
    private javax.swing.JButton cashFlowStatementButton;
    private javax.swing.JLabel cashFlowStatementLabel;
    private javax.swing.JButton creditNoteReportButton;
    private javax.swing.JLabel creditNoteReportLabel;
    private javax.swing.JButton dayBookButton;
    private javax.swing.JLabel dayBookLabel;
    private javax.swing.JLayeredPane debitAndCreditNoteReport;
    private javax.swing.JButton debitNoteReportButton;
    private javax.swing.JLabel debitNoteReportLabel;
    private javax.swing.JLayeredPane finalReport;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton journalBookButton;
    private javax.swing.JLabel journalBookLabel;
    private javax.swing.JLayeredPane otherReports;
    private javax.swing.JButton productionReportButton;
    private javax.swing.JLabel productionReportLabel;
    private javax.swing.JButton profitAndLossReportButton;
    private javax.swing.JLabel profitAndLossReportLabel;
    private javax.swing.JButton purchaseReportButton;
    private javax.swing.JLabel purchaseReportLabel;
    private javax.swing.JButton ratioAnalysisButton;
    private javax.swing.JLabel ratioAnalysisLabel;
    private javax.swing.JLayeredPane ratioAnalysisReport;
    private javax.swing.JButton saleReportButton;
    private javax.swing.JLabel saleReportLabel;
    private javax.swing.JButton stockReportButton;
    private javax.swing.JLabel stockReportLabel;
    private javax.swing.JButton tradingAccountButton;
    private javax.swing.JLabel tradingAccountLabel;
    private javax.swing.JButton trailBalanceButton;
    private javax.swing.JLabel trailBalanceLabel;
    // End of variables declaration//GEN-END:variables

    private void addButtonOnLabel(JButton btn, JLabel label) {
        label.add(btn);
        btn.setBounds(0, 0, 200, 50);
        btn.setVisible(true);
    }

    private void noActiveBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.black);
        label.setIcon(null);
        btn.setBorderPainted(true);
    }

    private void hoverBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getHoverMainButtonIcon());
        btn.setBorderPainted(false);
    }

    public void setNullToAllWindows() {

    }
}
