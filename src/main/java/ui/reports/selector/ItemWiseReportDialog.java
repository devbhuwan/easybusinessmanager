package ui.reports.selector;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.ListModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import ui.main.MainFrame;
import ui.reports.ReportUtils;
import ui.reports.finalr.ProductionReport;
import ui.reports.finalr.StocksReport;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ItemWiseReportDialog extends javax.swing.JDialog implements ActionListener {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final String msg;
    private ListModel listModel;
    private PreparedStatement ps;
    private ResultSet rs;
    private TableCellEditor checkBoxEditor;
    private TableCellRenderer checkBoxRenderer;
    private int totalHeight = 0;
    private int totalHeight1 = 0;
    private int count;
    private ProductionReport productionReport;
    private StocksReport stockReport;

    /**
     * Creates new form MonthWiseReportDialog
     *
     * @param mainFrame
     * @param modal
     * @param companyCode
     * @param msg
     */
    public ItemWiseReportDialog(MainFrame mainFrame, boolean modal, String companyCode, String msg) {
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
            case "Production Report":
                fetchStoreName();
                break;
            case "Stock Report":
                fetchStoreName();
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkBox = new javax.swing.JCheckBox();
        headerTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        dateFromL = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        storeNameScrollPane = new javax.swing.JScrollPane();
        storeNameList = new javax.swing.JPanel();
        selectAndUnselectAllCHB = new javax.swing.JCheckBox();
        itemCodeScrollPane = new javax.swing.JScrollPane();
        itemNameList = new javax.swing.JPanel();
        selectAndUnselectAllCHB1 = new javax.swing.JCheckBox();
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

        dateFromL.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        dateFromL.setForeground(new java.awt.Color(0, 153, 153));
        dateFromL.setText("Date From :");

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

        storeNameScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        storeNameScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Store Names"));
        storeNameScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        storeNameScrollPane.setPreferredSize(new java.awt.Dimension(510, 316));

        storeNameList.setBackground(new java.awt.Color(255, 255, 255));
        storeNameList.setPreferredSize(new java.awt.Dimension(510, 300));

        javax.swing.GroupLayout storeNameListLayout = new javax.swing.GroupLayout(storeNameList);
        storeNameList.setLayout(storeNameListLayout);
        storeNameListLayout.setHorizontalGroup(
            storeNameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        storeNameListLayout.setVerticalGroup(
            storeNameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        storeNameScrollPane.setViewportView(storeNameList);

        selectAndUnselectAllCHB.setBackground(new java.awt.Color(255, 255, 255));
        selectAndUnselectAllCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        selectAndUnselectAllCHB.setText("Select All / Unselect All");
        selectAndUnselectAllCHB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAndUnselectAllCHBActionPerformed(evt);
            }
        });

        itemCodeScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        itemCodeScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Codes"));
        itemCodeScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        itemCodeScrollPane.setPreferredSize(new java.awt.Dimension(510, 316));

        itemNameList.setBackground(new java.awt.Color(255, 255, 255));
        itemNameList.setPreferredSize(new java.awt.Dimension(510, 300));

        javax.swing.GroupLayout itemNameListLayout = new javax.swing.GroupLayout(itemNameList);
        itemNameList.setLayout(itemNameListLayout);
        itemNameListLayout.setHorizontalGroup(
            itemNameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        itemNameListLayout.setVerticalGroup(
            itemNameListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        itemCodeScrollPane.setViewportView(itemNameList);

        selectAndUnselectAllCHB1.setBackground(new java.awt.Color(255, 255, 255));
        selectAndUnselectAllCHB1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        selectAndUnselectAllCHB1.setText("Select All / Unselect All");
        selectAndUnselectAllCHB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAndUnselectAllCHB1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(storeNameScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(dateFromL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(selectAndUnselectAllCHB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(itemCodeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectAndUnselectAllCHB1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateFromL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemCodeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(storeNameScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectAndUnselectAllCHB)
                    .addComponent(selectAndUnselectAllCHB1))
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
        ArrayList<String> selectedItem = new ArrayList<>();
        if ((c1.getTimeInMillis() - c.getTimeInMillis()) > 0) {
            for (Component com : itemNameList.getComponents()) {
                JCheckBox box = (JCheckBox) com;
                if (box.isSelected()) {
                    selectedItem.add(box.getText());
                }
            }
            switch (msg) {
                case "Production Report":
                    productionReport = new ProductionReport(mainFrame, companyCode, this);
                    productionReport.setDates(c, c1);
                    productionReport.setLocationRelativeTo(mainFrame);
                    productionReport.fetchInfo(selectedItem);
                    this.setVisible(false);
                    productionReport.setVisible(true);
                    break;
                case "Stock Report":
                    stockReport = new StocksReport(mainFrame, companyCode, this);
                    stockReport.setDates(c, c1);
                    stockReport.setLocationRelativeTo(mainFrame);
                    stockReport.fetchInfo(selectedItem);
                    this.setVisible(false);
                    stockReport.setVisible(true);
                    break;
            }
        } else {
            errorMessage.setText("Please, Select date approriately.");
        }

    }//GEN-LAST:event_showButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void dateChooserCombo2OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo2OnSelectionChange


    }//GEN-LAST:event_dateChooserCombo2OnSelectionChange

    private void dateChooserCombo1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnSelectionChange


    }//GEN-LAST:event_dateChooserCombo1OnSelectionChange

    private void selectAndUnselectAllCHBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAndUnselectAllCHBActionPerformed
        if (selectAndUnselectAllCHB.isSelected()) {
            for (Component c : storeNameList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(true);
            }
            actionPerformed(evt);
        } else {
            for (Component c : storeNameList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(false);
            }
            actionPerformed(evt);
        }
    }//GEN-LAST:event_selectAndUnselectAllCHBActionPerformed

    private void selectAndUnselectAllCHB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAndUnselectAllCHB1ActionPerformed
        if (selectAndUnselectAllCHB1.isSelected()) {
            for (Component c : itemNameList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(true);
            }
        } else {
            for (Component c : itemNameList.getComponents()) {
                JCheckBox box = (JCheckBox) c;
                box.setSelected(false);
            }
        }
    }//GEN-LAST:event_selectAndUnselectAllCHB1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkBox;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel dateFromL;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JScrollPane itemCodeScrollPane;
    private javax.swing.JPanel itemNameList;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox selectAndUnselectAllCHB;
    private javax.swing.JCheckBox selectAndUnselectAllCHB1;
    private javax.swing.JButton showButton;
    private javax.swing.JPanel storeNameList;
    private javax.swing.JScrollPane storeNameScrollPane;
    // End of variables declaration//GEN-END:variables

    private void fetchStoreName() {
        count = 0;
        totalHeight = 0;
        ArrayList<String> storeName = new ReportUtils().getStoreName(companyCode, mainFrame);
        for (String s : storeName) {
            JCheckBox box = new JCheckBox(s);
            storeNameList.add(box, count);
            box.setBounds(0, count * 20, storeNameList.getWidth(), 20);
            box.setBackground(Color.white);
            totalHeight = totalHeight + 20;
            box.setVisible(true);
            box.addActionListener((ActionListener) this);
            count++;
        }
        storeNameList.setPreferredSize(new Dimension(storeNameScrollPane.getWidth() - 100, totalHeight));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count = 0;
        totalHeight1 = 0;
        ArrayList<String> selectedStore = new ArrayList<>();

        for (Component c : itemNameList.getComponents()) {
            JCheckBox box = (JCheckBox) c;
            box.setVisible(false);
        }
        itemNameList.removeAll();
        for (Component c : storeNameList.getComponents()) {
            JCheckBox box = (JCheckBox) c;
            if (box.isSelected()) {
                selectedStore.add(box.getText());
            }
        }
        if (selectedStore.size() > 0) {
            ArrayList<String> allItems = new ReportUtils().getAllItems(companyCode, mainFrame, selectedStore);
            for (String s : allItems) {
                JCheckBox box = new JCheckBox(s);
                itemNameList.add(box, count);
                box.setBounds(0, count * 20, itemNameList.getWidth(), 20);
                box.setBackground(Color.white);
                totalHeight1 = totalHeight1 + 20;
                box.setVisible(true);
                count++;
            }
            itemNameList.setPreferredSize(new Dimension(itemCodeScrollPane.getWidth() - 100, totalHeight1));
        }

    }
}
