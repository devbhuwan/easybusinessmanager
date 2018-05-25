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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import ui.feature.TableUI;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.reports.accountstatement.AccountStatementUtils;
import ui.reports.daybook.DayBookUtils;
import ui.reports.print.DayNotesTaker;
import ui.reports.print.action.AccountWiseReport2Print;
import ui.reports.selector.AccountWiseReportDialog;
import ui.reports.selector.DayWiseReportDialog;

/**
 *
 * @author Vimal
 */
public class DayBook extends javax.swing.JFrame implements TableModelListener {

    private final MainFrame mainFrame;
    private final String companyCode;
    private Calendar cal;
    private final DayWiseReportDialog dialog;
    private DayBookUtils jru;
    private DayNotesTaker notesTaker;
    private String notes;
    private AccountWiseReport2Print print;

    /**
     * Creates new form TradingAccountReport
     *
     * @param mainFrame
     * @param companyCode
     * @param dialog
     */
    public DayBook(MainFrame mainFrame, String companyCode, DayWiseReportDialog dialog) {
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
        jLabel1 = new javax.swing.JLabel();
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
        setTitle("Day Book");
        setIconImage(new ImageGet().getBuzLogo().getImage());
        setMinimumSize(new java.awt.Dimension(1013, 409));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        dateFromL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        dateFromL.setForeground(new java.awt.Color(0, 0, 255));

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Day Book");
        jLabel3.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Date");

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

            },
            new String [] {
                "S. N.", "Date", "Voucher Number ", "Account Number", "Account Name", "Debit Amount", "Credit Amount", "Transaction By"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
            firstReportTable.getColumnModel().getColumn(4).setPreferredWidth(500);
            firstReportTable.getColumnModel().getColumn(5).setPreferredWidth(400);
            firstReportTable.getColumnModel().getColumn(6).setPreferredWidth(400);
            firstReportTable.getColumnModel().getColumn(7).setPreferredWidth(500);
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
                .addComponent(firstPanelScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateFromL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
         if (firstReportTable.getRowCount() > 2) {
            notesTaker = new DayNotesTaker(this, true);
            notesTaker.setLocationRelativeTo(this);
            notesTaker.setVisible(true);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) firstReportTable.getModel();
        model.setRowCount(0);
        fetchInfo();
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void firstReportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstReportTableMouseClicked

    }//GEN-LAST:event_firstReportTableMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dateFromL;
    private javax.swing.JScrollPane firstPanelScrollPane;
    private javax.swing.JTable firstReportTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JButton printButton;
    private javax.swing.JButton reloadButton;
    // End of variables declaration//GEN-END:variables

    public void setDates(Calendar date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        cal = date;
        String fromDate = format.format(cal.getTime());
        dateFromL.setText(fromDate);
    }

    public void fetchInfo() {
        reloadButton.setVisible(false);
        firstPanelScrollPane.setVisible(false);
        loadingLabel.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                jru = new DayBookUtils(mainFrame, cal, firstReportTable, companyCode);
                jru.run();
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
        if (jru.getIsFinished()) {
            loadingLabel.setVisible(false);
            firstPanelScrollPane.setVisible(true);
            reloadButton.setVisible(true);
        }
    }

    private void setFirstTableTotalValues() {
        Double debit = 0.0;
        Double credit = 0.0;
        addRow();
        addRow();
        for (int i = 0; i < firstReportTable.getRowCount() - 2; i++) {
            try {
                debit = debit + Double.valueOf(firstReportTable.getValueAt(i, 5).toString());
            } catch (NumberFormatException | NullPointerException ex) {
            }
            try {
                credit = credit + Double.valueOf(firstReportTable.getValueAt(i, 6).toString());
            } catch (NumberFormatException | NullPointerException ex) {
            }
        }

        firstReportTable.setValueAt("GRAND TOTAL", firstReportTable.getRowCount() - 1, 4);
        firstReportTable.setValueAt(debit, firstReportTable.getRowCount() - 1, 5);
        firstReportTable.setValueAt(credit, firstReportTable.getRowCount() - 1, 6);
        int count = 1;
        for (int i = 0; i < firstReportTable.getRowCount() - 2; i++) {
            if (firstReportTable.getValueAt(i, 0) != null) {
                firstReportTable.setValueAt(count++, i, 0);
            }
        }
    }

    private void addRow() {
        DefaultTableModel model = (DefaultTableModel) firstReportTable.getModel();
        Object[] data = {null, null, null, null, null, null};
        model.addRow(data);
        firstReportTable.setModel(model);
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
                    print = new AccountWiseReport2Print(mainFrame, companyCode, firstReportTable, notes, cal, cal, reportName, "DAY BOOK");
                    print.prepare();
                    print.print();
                    notesTaker.dispose();
                } else {
                    notesTaker.setVisible(true);
                }
            } else {
                this.notes = notes;
                print = new AccountWiseReport2Print(mainFrame, companyCode, firstReportTable, notes, cal, cal, reportName, "DAY BOOK");
                print.prepare();
                print.print();
                notesTaker.dispose();
            }
        } else {
            this.notes = notes;
            print = new AccountWiseReport2Print(mainFrame, companyCode, firstReportTable, notes, cal, cal, reportName, "DAY BOOK");
            print.prepare();
            print.print();
            notesTaker.dispose();
        }
    }
}
