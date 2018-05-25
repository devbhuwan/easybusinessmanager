package ui.voucher.doubleentry;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ui.feature.TableUI;
import ui.main.MainFrame;
import ui.reports.print.PaymentNotesTaker;
import ui.reports.print.action.VoucherPrint;
import ui.voucher.FetchVoucherData;
import ui.voucher.ListOfData;
import ui.voucher.TableUtils;
import ui.voucher.doubleentry.utils.PaymentVoucherHandler;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class PaymentVoucher extends javax.swing.JPanel {

    private ListOfData listOfData;
    private final MainFrame mainFrame;
    private final String companyCode;
    private final Connection conn;
    private String voucherNumber;
    private int selectedRow;
    private TableRowSorter<TableModel> doubleEntryListTableSorter;
    private String saveType;
    private PaymentNotesTaker notesTaker;
    private VoucherPrint print;
    private String notes;

    /**
     * Creates new form PaymentVoucher
     *
     * @param mainFrame
     * @param companyC
     * @param co
     */
    public PaymentVoucher(MainFrame mainFrame, String companyC, Connection co) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyC;
        this.conn = co;
        errorMessage.setOpaque(false);
        defaultControlShow();
        doubleEntryTable.setTableHeader(new TableUI().getTableHeaderUI(doubleEntryTable));
        doubleEntryListTable.setTableHeader(new TableUI().getTableHeaderUI(doubleEntryListTable));
        doubleEntryTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(debitAmountTF));
        doubleEntryTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(creditAmountTF));
        dateChooserCombo.setFormat(1);
        debitAmountTF.setEnabled(false);
        creditAmountTF.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        list = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        doubleEntryListTable = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        debitAmountTF = new javax.swing.JTextField();
        creditAmountTF = new javax.swing.JTextField();
        mainControl = new javax.swing.JLayeredPane();
        df = new javax.swing.JLayeredPane();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();
        doubleEntryTableScroll = new javax.swing.JScrollPane();
        doubleEntryTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        voucherNumberTF = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateChooserCombo = new datechooser.beans.DateChooserCombo();
        totalDebit = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalCredit = new javax.swing.JLabel();
        inserRowButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        removeRowButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        otherDetailTA = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        list.setBackground(new java.awt.Color(255, 255, 255));

        doubleEntryListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        doubleEntryListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Voucher Number", "Date", "Total Debit", "Total Credit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        doubleEntryListTable.setFocusable(false);
        doubleEntryListTable.setRowHeight(23);
        doubleEntryListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        doubleEntryListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleEntryListTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(doubleEntryListTable);
        if (doubleEntryListTable.getColumnModel().getColumnCount() > 0) {
            doubleEntryListTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            doubleEntryListTable.getColumnModel().getColumn(1).setPreferredWidth(700);
            doubleEntryListTable.getColumnModel().getColumn(2).setPreferredWidth(600);
            doubleEntryListTable.getColumnModel().getColumn(3).setPreferredWidth(500);
            doubleEntryListTable.getColumnModel().getColumn(4).setPreferredWidth(500);
        }

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Search By :");

        searchField.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), searchField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        searchField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchFieldCaretUpdate(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setOpaque(true);

        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jButton1.setText("GO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(1, 1, 1))
        );
        jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(searchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane5)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        debitAmountTF.setText("jTextField1");
        debitAmountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                debitAmountTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                debitAmountTFFocusLost(evt);
            }
        });
        debitAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                debitAmountTFKeyTyped(evt);
            }
        });

        creditAmountTF.setText("jTextField1");
        creditAmountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                creditAmountTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                creditAmountTFFocusLost(evt);
            }
        });
        creditAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                creditAmountTFKeyTyped(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        mainControl.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

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

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorder(null);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
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

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(null);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dfLayout = new javax.swing.GroupLayout(df);
        df.setLayout(dfLayout);
        dfLayout.setHorizontalGroup(
            dfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dfLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dfLayout.setVerticalGroup(
            dfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dfLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(dfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        df.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(saveButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(editButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        df.setLayer(printButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainControlLayout = new javax.swing.GroupLayout(mainControl);
        mainControl.setLayout(mainControlLayout);
        mainControlLayout.setHorizontalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainControlLayout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        mainControlLayout.setVerticalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(df, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        mainControl.setLayer(df, javax.swing.JLayeredPane.DEFAULT_LAYER);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

        doubleEntryTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        doubleEntryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Acc. No.", "Acc. Name", "DEBIT", "Acc. No.", "Acc. Name", "CREDIT", "Narration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        doubleEntryTable.setCellSelectionEnabled(true);
        doubleEntryTable.setRowHeight(30);
        doubleEntryTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        doubleEntryTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        doubleEntryTable.setSurrendersFocusOnKeystroke(true);
        doubleEntryTable.getTableHeader().setReorderingAllowed(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), doubleEntryTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        doubleEntryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleEntryTableMouseClicked(evt);
            }
        });
        doubleEntryTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                doubleEntryTableFocusGained(evt);
            }
        });
        doubleEntryTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                doubleEntryTableKeyTyped(evt);
            }
        });
        doubleEntryTableScroll.setViewportView(doubleEntryTable);
        doubleEntryTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (doubleEntryTable.getColumnModel().getColumnCount() > 0) {
            doubleEntryTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            doubleEntryTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            doubleEntryTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            doubleEntryTable.getColumnModel().getColumn(3).setPreferredWidth(405);
            doubleEntryTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            doubleEntryTable.getColumnModel().getColumn(5).setPreferredWidth(400);
            doubleEntryTable.getColumnModel().getColumn(6).setPreferredWidth(300);
            doubleEntryTable.getColumnModel().getColumn(7).setPreferredWidth(400);
        }

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setOpaque(true);

        jLabel5.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("@@@@@@");
        jLabel5.setOpaque(true);

        jLabel4.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("@@@@@@  ");
        jLabel4.setOpaque(true);

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Giver Side");
        jLabel3.setOpaque(true);

        jLabel2.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Receiver Side");
        jLabel2.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Voucher Number :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), voucherNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Date :");
        jLabel6.setFocusable(false);

        totalDebit.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        totalDebit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        totalDebit.setForeground(new java.awt.Color(255, 255, 255));
        totalDebit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalDebit.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total CREDIT :");

        totalCredit.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        totalCredit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        totalCredit.setForeground(new java.awt.Color(255, 255, 255));
        totalCredit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCredit.setOpaque(true);

        inserRowButton.setBackground(new java.awt.Color(255, 255, 255));
        inserRowButton.setText("Insert Row");
        inserRowButton.setFocusPainted(false);
        inserRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserRowButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total DEBIT :");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        removeRowButton.setBackground(new java.awt.Color(255, 255, 255));
        removeRowButton.setForeground(new java.awt.Color(255, 0, 0));
        removeRowButton.setText("Remove Row");
        removeRowButton.setFocusPainted(false);
        removeRowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowButtonActionPerformed(evt);
            }
        });

        otherDetailTA.setColumns(20);
        otherDetailTA.setRows(5);
        otherDetailTA.setFocusable(false);
        otherDetailTA.setNextFocusableComponent(addButton);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), otherDetailTA, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(otherDetailTA);

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel17.setText("Other Details :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("(If any) ");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doubleEntryTableScroll)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(voucherNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(containerLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(containerLayout.createSequentialGroup()
                                        .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11))))))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(inserRowButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        containerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {totalCredit, totalDebit});

        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(voucherNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(dateChooserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)))
                .addGap(0, 0, 0)
                .addComponent(doubleEntryTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inserRowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(totalCredit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalDebit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        containerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooserCombo, jLabel1, jLabel6, voucherNumberTF});

        containerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainControl)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void doubleEntryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleEntryTableMouseClicked
        if (doubleEntryTable.getSelectedColumn() == 3 || doubleEntryTable.getSelectedColumn() == 6) {
            doubleEntryTableControl();
        } else {
            if (evt.getClickCount() > 1) {
                doubleEntryTableControl();
            }
        }

    }//GEN-LAST:event_doubleEntryTableMouseClicked

    private void doubleEntryTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_doubleEntryTableFocusGained
        if (doubleEntryTable.getSelectedRow() > -1 && doubleEntryTable.getSelectedRow() < doubleEntryTable.getRowCount()) {
            if (doubleEntryTable.getSelectedColumn() == 3) {
                if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 3) != null) {
                    if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 4) != null) {
                        doubleEntryTable.getModel().setValueAt(doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 3), doubleEntryTable.getSelectedRow(), 6);
                    }
                }
            } else if (doubleEntryTable.getSelectedColumn() == 6) {
                if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 6) != null) {
                    if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 1) != null) {
                        doubleEntryTable.getModel().setValueAt(doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 6), doubleEntryTable.getSelectedRow(), 3);
                    }

                }
            } else {
                if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 3) != null) {
                    if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 4) != null) {
                        doubleEntryTable.getModel().setValueAt(doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 3), doubleEntryTable.getSelectedRow(), 6);
                    }
                }
                if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 6) != null) {
                    if (doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 1) != null) {
                        doubleEntryTable.getModel().setValueAt(doubleEntryTable.getModel().getValueAt(doubleEntryTable.getSelectedRow(), 6), doubleEntryTable.getSelectedRow(), 3);
                    }

                }
            }

        }
        setTotalValues();
    }//GEN-LAST:event_doubleEntryTableFocusGained

    private void inserRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserRowButtonActionPerformed
        new TableUtils().addingDoubleEntryTableRow(doubleEntryTable);
    }//GEN-LAST:event_inserRowButtonActionPerformed

    private void removeRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowButtonActionPerformed
        new TableUtils().removingDoubleEntryTableRow(doubleEntryTable, selectedRow);
    }//GEN-LAST:event_removeRowButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        setVoucherNumber(companyCode, conn);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new PaymentVoucherHandler(mainFrame).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherInfo(this, conn, companyCode)) {
                    if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherAccountsInfo(this, conn, companyCode, doubleEntryTable)) {
                        this.enableAllField(false);
                        this.saveOrUpdateControlShow();
                    }
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Voucher number is already exist.");
                voucherNumberTF.requestFocusInWindow();
                voucherNumberTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (voucherNumberTF.getText().equals(String.valueOf(voucherNumber))) {
                if (new PaymentVoucherHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                    if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherInfo(this, conn, companyCode)) {
                        if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherAccountsInfo(this, conn, companyCode, doubleEntryTable)) {
                            this.enableAllField(false);
                            this.saveOrUpdateControlShow();
                        }
                    }

                }
            } else {
                if (new PaymentVoucherHandler(mainFrame).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                    if (new PaymentVoucherHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                        if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherInfo(this, conn, companyCode)) {
                            if (new PaymentVoucherHandler(mainFrame).savePaymentVoucherAccountsInfo(this, conn, companyCode, doubleEntryTable)) {
                                this.enableAllField(false);
                                this.saveOrUpdateControlShow();
                            }
                        }

                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Voucher number is already exist.");
                    voucherNumberTF.requestFocusInWindow();
                    voucherNumberTF.selectAll();
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.clearAllField();
        this.enableAllField(false);
        showCancelControl();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (new PaymentVoucherHandler(mainFrame).fetchPaymentVoucherInformation(companyCode, doubleEntryListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight());
            container.setVisible(false);
            list.setVisible(true);
            mainControl.setVisible(false);
            backButton.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new PaymentVoucherHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumberTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        notesTaker = new PaymentNotesTaker(mainFrame, this, true);
        notesTaker.setLocationRelativeTo(this);
        notesTaker.setVisible(true);
    }//GEN-LAST:event_printButtonActionPerformed

    private void doubleEntryListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleEntryListTableMouseClicked
        if (doubleEntryListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && doubleEntryListTable.getSelectedRow() > -1) {
                voucherNumber = doubleEntryListTable.getValueAt(doubleEntryListTable.getSelectedRow(), 1).toString();
                if (new PaymentVoucherHandler(mainFrame).fetchDataOfPaymentVoucher(companyCode, voucherNumber, this, conn)) {
                    if (new PaymentVoucherHandler(mainFrame).fetchAccountDetail(companyCode, voucherNumber, doubleEntryTable, this, conn)) {
                        list.setVisible(false);
                        container.setVisible(true);
                        mainControl.setVisible(true);
                        this.remove(list);
                        enableAllField(true);
                        showEditOrListControl();
                    }
                }
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_doubleEntryListTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        list.setVisible(false);
        mainControl.setVisible(true);
        container.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchFieldCaretUpdate

    }//GEN-LAST:event_searchFieldCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void debitAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_debitAmountTFKeyTyped

        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (debitAmountTF.getText().isEmpty()) {
                evt.consume();
            } else if (debitAmountTF.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_debitAmountTFKeyTyped

    private void creditAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creditAmountTFKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (creditAmountTF.getText().isEmpty()) {
                evt.consume();
            } else if (creditAmountTF.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_creditAmountTFKeyTyped

    private void debitAmountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_debitAmountTFFocusLost
        debitAmountTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_debitAmountTFFocusLost

    private void creditAmountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_creditAmountTFFocusLost
        creditAmountTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_creditAmountTFFocusLost

    private void doubleEntryTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doubleEntryTableKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            debitAmountTF.setEnabled(false);
            creditAmountTF.setEnabled(false);
            doubleEntryTableControl();
        }
    }//GEN-LAST:event_doubleEntryTableKeyTyped

    private void debitAmountTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_debitAmountTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_debitAmountTFFocusGained

    private void creditAmountTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_creditAmountTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_creditAmountTFFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel container;
    private javax.swing.JTextField creditAmountTF;
    private datechooser.beans.DateChooserCombo dateChooserCombo;
    private javax.swing.JTextField debitAmountTF;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLayeredPane df;
    private javax.swing.JTable doubleEntryListTable;
    private javax.swing.JTable doubleEntryTable;
    private javax.swing.JScrollPane doubleEntryTableScroll;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton inserRowButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel list;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JTextArea otherDetailTA;
    private javax.swing.JButton printButton;
    private javax.swing.JButton removeRowButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel totalCredit;
    private javax.swing.JLabel totalDebit;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField voucherNumberTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void showListOfData(String s, JTable table, String companyCode) {
        listOfData = new ListOfData(mainFrame, true, table, companyCode);
        listOfData.addData(s);
        listOfData.setLocationRelativeTo(mainFrame);
        listOfData.setVisible(true);
    }

    private void defaultControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

    }

    private void addControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
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

    public void setVoucherNumber(String companyCode, Connection conn) {
        voucherNumberTF.setText(new FetchVoucherData().getNextPaymentVoucherNo(companyCode, conn));
    }

    private void clearAllField() {
        voucherNumberTF.setText(null);
        dateChooserCombo.setSelectedDate(Calendar.getInstance());
        DefaultTableModel model = (DefaultTableModel) doubleEntryTable.getModel();
        model.setRowCount(0);
        Object[] data = {null, null, null, null, null, null, null, null};
        model.addRow(data);
        doubleEntryTable.setModel(model);
        otherDetailTA.setText(null);
        totalDebit.setText(null);
        totalCredit.setText(null);
    }

    private void enableAllField(boolean b) {
        jLabel1.setEnabled(b);
        errorMessage.setEnabled(b);
        voucherNumberTF.setEnabled(b);
        jLabel6.setEnabled(b);
        dateChooserCombo.setEnabled(b);
        doubleEntryTableScroll.setEnabled(b);
        doubleEntryTable.setEnabled(b);
        jLabel8.setEnabled(b);
        jLabel8.setEnabled(b);
        totalDebit.setEnabled(b);
        jLabel11.setEnabled(b);
        totalCredit.setEnabled(b);
        inserRowButton.setEnabled(b);
        removeRowButton.setEnabled(b);
        jLabel17.setEnabled(b);
        jLabel18.setEnabled(b);
        jScrollPane4.setEnabled(b);
        otherDetailTA.setEnabled(b);
        jLabel2.setEnabled(b);
        jLabel3.setEnabled(b);
        jLabel4.setEnabled(b);
        jLabel5.setEnabled(b);
    }

    private boolean validateUserInput() {
        boolean status = false;
        if (!voucherNumberTF.getText().isEmpty()) {
            if (doubleEntryTable.getRowCount() > 1) {
                int rowCount = doubleEntryTable.getRowCount();
                for (int row = 0; row < (rowCount - 1); row++) {
                    if (doubleEntryTable.getModel().getValueAt(row, 1) != null) {
                        if (doubleEntryTable.getModel().getValueAt(row, 2) != null) {
                            if ((doubleEntryTable.getModel().getValueAt(row, 3) != null)) {
                                if ((doubleEntryTable.getModel().getValueAt(row, 4) != null)) {
                                    if ((doubleEntryTable.getModel().getValueAt(row, 5) != null)) {
                                        if ((doubleEntryTable.getModel().getValueAt(row, 6) != null)) {
                                            status = true;
                                        } else {
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, select the credit amount for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the debit amount for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the account name for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                    }

                    if (doubleEntryTable.getModel().getValueAt(row, 4) != null) {
                        status = false;
                        if (doubleEntryTable.getModel().getValueAt(row, 5) != null) {
                            if ((doubleEntryTable.getModel().getValueAt(row, 6) != null)) {
                                if ((doubleEntryTable.getModel().getValueAt(row, 1) != null)) {
                                    if ((doubleEntryTable.getModel().getValueAt(row, 2) != null)) {
                                        if ((doubleEntryTable.getModel().getValueAt(row, 3) != null)) {
                                            status = true;
                                        } else {
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, select the debit amount for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in receiver side.");
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the credit amount for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the account name for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please, select the account number for row " + doubleEntryTable.getModel().getValueAt(row, 0).toString() + " in giver side.");
                    }
                    if(doubleEntryTable.getModel().getValueAt(row, 1) == null && doubleEntryTable.getModel().getValueAt(row, 4) == null) {
                        status = false;
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Please remove row + " + row + ".");
                    }
                }

            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, enter accounts information.");
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Please, enter voucher number.");
        }

        return status;
    }

    public String getVoucherNumber() {
        return voucherNumberTF.getText();
    }

    public Timestamp getDateT() {
        Calendar c = dateChooserCombo.getSelectedDate();
        Date d = c.getTime();
        return new Timestamp(d.getTime());
    }

    public String getOtherDetails() {
        return otherDetailTA.getText();
    }

    public String getTotalCredit() {
        return totalCredit.getText();
    }

    public String getTotalDebit() {
        return totalDebit.getText();
    }

    public String getTableDate(int i, int col) {
        try {
            return doubleEntryTable.getModel().getValueAt(i, col).toString();
        } catch (NullPointerException ex) {
            return null;
        }

    }

    public void setAVoucherNumber(String aLong) {
        voucherNumberTF.setText(String.valueOf(aLong));
    }

    public void setDatee(Timestamp timestamp) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(timestamp.getTime()));
        dateChooserCombo.setSelectedDate(c);
    }

    public void setOtherDetails(String string) {
        otherDetailTA.setText(string);
    }

    public void setTotalCredit(String aDouble) {
        totalCredit.setText(String.valueOf(aDouble));
    }

    public void setTotalDebit(String aDouble) {
        totalDebit.setText(String.valueOf(aDouble));
    }

    private void setTotalValues() {
        double totalDebitAmt = 0;
        double totalCreditAmt = 0;
        for (int i = 0; i < (doubleEntryTable.getRowCount() - 1); i++) {
            if (doubleEntryTable.getModel().getValueAt(i, 1) != null) {
                if (doubleEntryTable.getModel().getValueAt(i, 3) != null) {
                    try {
                        totalDebitAmt = totalDebitAmt + Double.valueOf(doubleEntryTable.getModel().getValueAt(i, 3).toString());
                    } catch(NullPointerException|NumberFormatException ex) {
                        totalDebitAmt = totalDebitAmt + 0;
                    }
                    
                }
            }
            if (doubleEntryTable.getModel().getValueAt(i, 4) != null) {
                if (doubleEntryTable.getModel().getValueAt(i, 6) != null) {
                    try {
                        totalCreditAmt = totalCreditAmt + Double.valueOf(doubleEntryTable.getModel().getValueAt(i, 6).toString());
                    } catch(NullPointerException|NumberFormatException ex) {
                        totalCreditAmt = totalCreditAmt + 0;
                    }
                    
                }
            }

        }
        totalDebit.setText(roundDecimals(totalDebitAmt));
        totalCredit.setText(roundDecimals(totalCreditAmt));
    }

    public String roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    private void doubleEntryTableControl() {
        errorMessage.setText(null);
        errorMessage.setOpaque(false);
        selectedRow = doubleEntryTable.getSelectedRow();
        if (selectedRow > -1) {
            if (doubleEntryTable.getSelectedRow() == doubleEntryTable.getRowCount() - 1) {
                new TableUtils().addingDoubleEntryTableRow(doubleEntryTable);
            } else {
                switch (doubleEntryTable.getSelectedColumn()) {
                    case 1:
                        showListOfData("paymentdebitaccno", doubleEntryTable, companyCode);
                        break;
                    case 2:
                        showListOfData("paymentdebitaccname", doubleEntryTable, companyCode);
                        break;
                    case 3:
                        if (doubleEntryTable.getModel().getValueAt(selectedRow, 1) != null) {
                            debitAmountTF.setEnabled(true);
                        }
                        break;
                    case 4:
                        showListOfData("paymentcreditaccno", doubleEntryTable, companyCode);
                        break;
                    case 5:
                        showListOfData("paymentcreditaccname", doubleEntryTable, companyCode);
                        break;
                    case 6:
                        if (doubleEntryTable.getModel().getValueAt(selectedRow, 4) != null) {
                            creditAmountTF.setEnabled(true);
                        }

                }

            }
        }
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
                    printV(notes, reportName);
                    notesTaker.dispose();
                } else {
                    notesTaker.setVisible(true);
                }
            } else {
                printV(notes, reportName);
                notesTaker.dispose();
            }
        } else {
            printV(notes, reportName);
            notesTaker.dispose();
        }
    }

    private void printV(String notes, String reportName) {
        this.notes = notes;
        Object rN = "PAYMENT VOUCHER";
        Object vN = voucherNumberTF.getText();
        Calendar cal = dateChooserCombo.getSelectedDate();
        Object debit = totalDebit.getText();
        Object credit = totalCredit.getText();
        print = new VoucherPrint(mainFrame, companyCode, doubleEntryTable, reportName);
        print.prepareModel();
        print.prepareParams(rN, vN, cal, notes, debit, credit);
        print.print();
        notesTaker.dispose();
    }
}
