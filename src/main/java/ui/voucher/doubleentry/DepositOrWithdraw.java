package ui.voucher.doubleentry;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ui.feature.TableUI;
import ui.main.MainFrame;
import ui.voucher.FetchVoucherData;
import ui.voucher.ListOfData;
import ui.voucher.TableUtils;
import ui.voucher.doubleentry.utils.DepositOrWithdrawHandler;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class DepositOrWithdraw extends javax.swing.JPanel {

    private ListOfData listOfData;
    private final MainFrame mainFrame;
    private final String companyCode;
    private final Connection conn;
    private String voucherNumber;
    private int selectedRow;
    private TableRowSorter<TableModel> doubleEntryListTableSorter;
    private String saveType;
    private int selectedRow1;

    /**
     * Creates new form DepositOrWithdraw
     *
     * @param mainFrame
     * @param companyC
     * @param co
     */
    public DepositOrWithdraw(MainFrame mainFrame, String companyC, Connection co) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyC;
        this.conn = co;
        errorMessage.setOpaque(false);
        defaultControlShow();
        printButton.setEnabled(false);
        depositTable.setTableHeader(new TableUI().getTableHeaderUI(depositTable));
        withDrawTable.setTableHeader(new TableUI().getTableHeaderUI(withDrawTable));
        doubleEntryListTable.setTableHeader(new TableUI().getTableHeaderUI(doubleEntryListTable));
        depositTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(depositAmountTF));
        depositTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(depositedSlipNoTF));
        withDrawTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(withdrawAmountTF));
        withDrawTable.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(checkOrATMnoTF));

        dateChooserCombo.setFormat(1);
        depositAmountTF.setEnabled(false);
        withdrawAmountTF.setEnabled(false);
        depositedSlipNoTF.setEnabled(false);
        checkOrATMnoTF.setEnabled(false);
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
        depositAmountTF = new javax.swing.JTextField();
        withdrawAmountTF = new javax.swing.JTextField();
        depositedSlipNoTF = new javax.swing.JTextField();
        checkOrATMnoTF = new javax.swing.JTextField();
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
        depositTableScroll = new javax.swing.JScrollPane();
        depositTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        voucherNumberTF = new javax.swing.JTextField();
        errorMessage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dateChooserCombo = new datechooser.beans.DateChooserCombo();
        depositAmountLabel = new javax.swing.JLabel();
        inserRowButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        removeRowButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        otherDetailTA = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        inserRowButton1 = new javax.swing.JButton();
        removeRowButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        withdrawnAmountLabel = new javax.swing.JLabel();
        doubleEntryTableScroll1 = new javax.swing.JScrollPane();
        withDrawTable = new javax.swing.JTable();

        list.setBackground(new java.awt.Color(255, 255, 255));

        doubleEntryListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        doubleEntryListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Voucher Number", "Date", "Total Deposit", "Total Withdraw"
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
        doubleEntryListTable.getTableHeader().setReorderingAllowed(false);
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

        depositAmountTF.setText("jTextField1");
        depositAmountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                depositAmountTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                depositAmountTFFocusLost(evt);
            }
        });
        depositAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depositAmountTFKeyTyped(evt);
            }
        });

        withdrawAmountTF.setText("jTextField1");
        withdrawAmountTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                withdrawAmountTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                withdrawAmountTFFocusLost(evt);
            }
        });
        withdrawAmountTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                withdrawAmountTFKeyTyped(evt);
            }
        });

        depositedSlipNoTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                depositedSlipNoTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                depositedSlipNoTFFocusLost(evt);
            }
        });

        checkOrATMnoTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                checkOrATMnoTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                checkOrATMnoTFFocusLost(evt);
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

        depositTableScroll.setBackground(new java.awt.Color(255, 255, 255));
        depositTableScroll.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Deposit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"))); // NOI18N

        depositTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        depositTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Cash Acc. No.", "Cash Acc. Name", "Bank Acc. No.", "Bank Acc. Name", "Deposited Amount", "Deposit Slip No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        depositTable.setCellSelectionEnabled(true);
        depositTable.setRowHeight(30);
        depositTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        depositTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        depositTable.setSurrendersFocusOnKeystroke(true);
        depositTable.getTableHeader().setReorderingAllowed(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), depositTable, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        depositTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositTableMouseClicked(evt);
            }
        });
        depositTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                depositTableFocusGained(evt);
            }
        });
        depositTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depositTableKeyTyped(evt);
            }
        });
        depositTableScroll.setViewportView(depositTable);
        depositTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (depositTable.getColumnModel().getColumnCount() > 0) {
            depositTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            depositTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            depositTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            depositTable.getColumnModel().getColumn(3).setPreferredWidth(405);
            depositTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            depositTable.getColumnModel().getColumn(5).setPreferredWidth(400);
            depositTable.getColumnModel().getColumn(6).setPreferredWidth(300);
        }

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Voucher Number :");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, errorMessage, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), voucherNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(255, 0, 0));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Date :");
        jLabel6.setFocusable(false);

        depositAmountLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        depositAmountLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        depositAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        depositAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        depositAmountLabel.setOpaque(true);

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
        jLabel8.setText("Total Deposited Amount :");
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

        inserRowButton1.setBackground(new java.awt.Color(255, 255, 255));
        inserRowButton1.setText("Insert Row");
        inserRowButton1.setFocusPainted(false);
        inserRowButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserRowButton1ActionPerformed(evt);
            }
        });

        removeRowButton1.setBackground(new java.awt.Color(255, 255, 255));
        removeRowButton1.setForeground(new java.awt.Color(255, 0, 0));
        removeRowButton1.setText("Remove Row");
        removeRowButton1.setFocusPainted(false);
        removeRowButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRowButton1ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Total Withdrawn Amount :");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        withdrawnAmountLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        withdrawnAmountLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        withdrawnAmountLabel.setForeground(new java.awt.Color(255, 255, 255));
        withdrawnAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        withdrawnAmountLabel.setOpaque(true);

        doubleEntryTableScroll1.setBackground(new java.awt.Color(255, 255, 255));
        doubleEntryTableScroll1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "Withdraw", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"))); // NOI18N

        withDrawTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        withDrawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "S. N.", "Cash Acc. No.", "Cash Acc. Name", "Bank Acc. No.", "Bank Acc. Name", "Withdrawn Amount", "Cheque/ATM Bill No."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        withDrawTable.setCellSelectionEnabled(true);
        withDrawTable.setRowHeight(30);
        withDrawTable.setSelectionBackground(new java.awt.Color(0, 153, 153));
        withDrawTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        withDrawTable.setSurrendersFocusOnKeystroke(true);
        withDrawTable.getTableHeader().setReorderingAllowed(false);
        withDrawTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                withDrawTableMouseClicked(evt);
            }
        });
        withDrawTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                withDrawTableFocusGained(evt);
            }
        });
        withDrawTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                withDrawTableKeyTyped(evt);
            }
        });
        doubleEntryTableScroll1.setViewportView(withDrawTable);
        withDrawTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (withDrawTable.getColumnModel().getColumnCount() > 0) {
            withDrawTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            withDrawTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            withDrawTable.getColumnModel().getColumn(2).setPreferredWidth(400);
            withDrawTable.getColumnModel().getColumn(3).setPreferredWidth(405);
            withDrawTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            withDrawTable.getColumnModel().getColumn(5).setPreferredWidth(400);
            withDrawTable.getColumnModel().getColumn(6).setPreferredWidth(300);
        }

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(inserRowButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(withdrawnAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(doubleEntryTableScroll1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(depositTableScroll)
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
                                        .addGap(0, 108, Short.MAX_VALUE))
                                    .addGroup(containerLayout.createSequentialGroup()
                                        .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(11, 11, 11))))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(inserRowButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeRowButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(depositAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
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
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depositTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inserRowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeRowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(depositAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doubleEntryTableScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(withdrawnAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(inserRowButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeRowButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        containerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dateChooserCombo, jLabel1, jLabel6, voucherNumberTF});

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

    private void depositTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositTableMouseClicked
        if (depositTable.getSelectedColumn() == 5 || depositTable.getSelectedColumn() == 6) {
            depositTableControl();
        } else {
            if (evt.getClickCount() > 1) {
                depositTableControl();
            }
        }
    }//GEN-LAST:event_depositTableMouseClicked

    private void depositTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositTableFocusGained

        setTotalValues();
    }//GEN-LAST:event_depositTableFocusGained

    private void inserRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserRowButtonActionPerformed
        new TableUtils().addingDoubleEntryTableRow(depositTable);
    }//GEN-LAST:event_inserRowButtonActionPerformed

    private void removeRowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowButtonActionPerformed
        new TableUtils().removingDoubleEntryTableRow(depositTable, selectedRow);
    }//GEN-LAST:event_removeRowButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        setVoucherNumber(companyCode, conn);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new DepositOrWithdrawHandler(mainFrame).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                if (new DepositOrWithdrawHandler(mainFrame).saveDepositOrWithdrawInfo(this, conn, companyCode)) {
                    if (new DepositOrWithdrawHandler(mainFrame).saveDepositAccountsInfo(this, conn, companyCode, depositTable)) {
                        if (new DepositOrWithdrawHandler(mainFrame).saveWithdrawAccountsInfo(this, conn, companyCode, withDrawTable)) {
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
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (voucherNumberTF.getText().equals(String.valueOf(voucherNumber))) {
                if (new DepositOrWithdrawHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                    if (new DepositOrWithdrawHandler(mainFrame).saveDepositOrWithdrawInfo(this, conn, companyCode)) {
                        if (new DepositOrWithdrawHandler(mainFrame).saveDepositAccountsInfo(this, conn, companyCode, depositTable)) {
                            if (new DepositOrWithdrawHandler(mainFrame).saveWithdrawAccountsInfo(this, conn, companyCode, withDrawTable)) {
                                this.enableAllField(false);
                                this.saveOrUpdateControlShow();
                            }
                        }
                    }

                }
            } else {
                if (new DepositOrWithdrawHandler(mainFrame).checkVoucherNumberIsValidOrNot(companyCode, voucherNumberTF.getText(), conn)) {
                    if (new DepositOrWithdrawHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumber, conn)) {
                        if (new DepositOrWithdrawHandler(mainFrame).saveDepositOrWithdrawInfo(this, conn, companyCode)) {
                            if (new DepositOrWithdrawHandler(mainFrame).saveDepositAccountsInfo(this, conn, companyCode, depositTable)) {
                                if (new DepositOrWithdrawHandler(mainFrame).saveWithdrawAccountsInfo(this, conn, companyCode, depositTable)) {
                                    this.enableAllField(false);
                                    this.saveOrUpdateControlShow();
                                }
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
        if (new DepositOrWithdrawHandler(mainFrame).fetchDepositOrWithdrawInformation(companyCode, doubleEntryListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight());
            container.setVisible(false);
            list.setVisible(true);
            mainControl.setVisible(false);
            backButton.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new DepositOrWithdrawHandler(mainFrame).deleteVoucherNumber(companyCode, voucherNumberTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed

    }//GEN-LAST:event_printButtonActionPerformed

    private void doubleEntryListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleEntryListTableMouseClicked
        if (doubleEntryListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && doubleEntryListTable.getSelectedRow() > -1) {
                voucherNumber = doubleEntryListTable.getValueAt(doubleEntryListTable.getSelectedRow(), 1).toString();
                if (new DepositOrWithdrawHandler(mainFrame).fetchDataOfDepositOrWithdraw(companyCode, voucherNumber, this, conn)) {
                    if (new DepositOrWithdrawHandler(mainFrame).fetchAccountDetail(companyCode, voucherNumber, depositTable, withDrawTable, this, conn)) {
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

    private void withdrawAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withdrawAmountTFKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (withdrawAmountTF.getText().isEmpty()) {
                evt.consume();
            } else if (withdrawAmountTF.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_withdrawAmountTFKeyTyped

    private void withdrawAmountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_withdrawAmountTFFocusLost
        withdrawAmountTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_withdrawAmountTFFocusLost

    private void depositTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depositTableKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            depositAmountTF.setEnabled(false);
            depositedSlipNoTF.setEnabled(false);
            depositTableControl();
        }
    }//GEN-LAST:event_depositTableKeyTyped

    private void withdrawAmountTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_withdrawAmountTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_withdrawAmountTFFocusGained

    private void inserRowButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserRowButton1ActionPerformed
        new TableUtils().addingDoubleEntryTableRow(withDrawTable);
    }//GEN-LAST:event_inserRowButton1ActionPerformed

    private void removeRowButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRowButton1ActionPerformed
        new TableUtils().removingDoubleEntryTableRow(withDrawTable, selectedRow1);
    }//GEN-LAST:event_removeRowButton1ActionPerformed

    private void withDrawTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withDrawTableMouseClicked
        if (withDrawTable.getSelectedColumn() == 5 || withDrawTable.getSelectedColumn() == 6) {
            withdrawTableControl();
        } else {
            if (evt.getClickCount() > 1) {
                withdrawTableControl();
            }
        }
    }//GEN-LAST:event_withDrawTableMouseClicked

    private void withDrawTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_withDrawTableFocusGained
        setTotalValues();
    }//GEN-LAST:event_withDrawTableFocusGained

    private void withDrawTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withDrawTableKeyTyped
        if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        } else {
            withdrawAmountTF.setEnabled(false);
            checkOrATMnoTF.setEnabled(false);
            withdrawTableControl();
        }
    }//GEN-LAST:event_withDrawTableKeyTyped

    private void depositAmountTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depositAmountTFKeyTyped

        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (depositAmountTF.getText().isEmpty()) {
                evt.consume();
            } else if (depositAmountTF.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_depositAmountTFKeyTyped

    private void depositAmountTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositAmountTFFocusLost
        depositAmountTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_depositAmountTFFocusLost

    private void depositAmountTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositAmountTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_depositAmountTFFocusGained

    private void depositedSlipNoTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositedSlipNoTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_depositedSlipNoTFFocusGained

    private void depositedSlipNoTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_depositedSlipNoTFFocusLost
        depositedSlipNoTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_depositedSlipNoTFFocusLost

    private void checkOrATMnoTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkOrATMnoTFFocusGained
        if (saveButton.isEnabled()) {
            saveType = "save";
            saveButton.setEnabled(false);
        } else if (updateButton.isEnabled()) {
            saveType = "update";
            updateButton.setEnabled(false);
        }
    }//GEN-LAST:event_checkOrATMnoTFFocusGained

    private void checkOrATMnoTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkOrATMnoTFFocusLost
        checkOrATMnoTF.setEnabled(false);
        switch (saveType) {
            case "save":
                saveButton.setEnabled(true);
                break;
            case "update":
                updateButton.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_checkOrATMnoTFFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField checkOrATMnoTF;
    private javax.swing.JPanel container;
    private datechooser.beans.DateChooserCombo dateChooserCombo;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel depositAmountLabel;
    private javax.swing.JTextField depositAmountTF;
    private javax.swing.JTable depositTable;
    private javax.swing.JScrollPane depositTableScroll;
    private javax.swing.JTextField depositedSlipNoTF;
    private javax.swing.JLayeredPane df;
    private javax.swing.JTable doubleEntryListTable;
    private javax.swing.JScrollPane doubleEntryTableScroll1;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton inserRowButton;
    private javax.swing.JButton inserRowButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JButton removeRowButton1;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField voucherNumberTF;
    private javax.swing.JTable withDrawTable;
    private javax.swing.JTextField withdrawAmountTF;
    private javax.swing.JLabel withdrawnAmountLabel;
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
        voucherNumberTF.setText(new FetchVoucherData().getNextDepositOrWithdrawNo(companyCode, conn));
    }

    private void clearAllField() {
        voucherNumberTF.setText(null);
        dateChooserCombo.setSelectedDate(Calendar.getInstance());
        DefaultTableModel model = (DefaultTableModel) depositTable.getModel();
        model.setRowCount(0);
        Object[] data = {null, null, null, null, null, null, null, null};
        model.addRow(data);
        depositTable.setModel(model);
        DefaultTableModel model1 = (DefaultTableModel) withDrawTable.getModel();
        model1.setRowCount(0);
        Object[] data1 = {null, null, null, null, null, null, null, null};
        model1.addRow(data1);
        withDrawTable.setModel(model1);
        otherDetailTA.setText(null);
        depositAmountLabel.setText(null);
        withdrawnAmountLabel.setText(null);
    }

    private void enableAllField(boolean b) {
        jLabel1.setEnabled(b);
        errorMessage.setEnabled(b);
        voucherNumberTF.setEnabled(b);
        jLabel6.setEnabled(b);
        dateChooserCombo.setEnabled(b);
        depositTableScroll.setEnabled(b);
        depositTable.setEnabled(b);
        jLabel8.setEnabled(b);
        jLabel8.setEnabled(b);
        depositAmountLabel.setEnabled(b);
        withdrawnAmountLabel.setEnabled(b);
        inserRowButton.setEnabled(b);
        removeRowButton.setEnabled(b);
        jLabel17.setEnabled(b);
        jScrollPane4.setEnabled(b);
        otherDetailTA.setEnabled(b);
        inserRowButton1.setEnabled(b);
        removeRowButton1.setEnabled(b);
        doubleEntryTableScroll1.setEnabled(b);
        withDrawTable.setEnabled(b);

    }

    private boolean validateUserInput() {
        boolean status = false;
        if (!voucherNumberTF.getText().isEmpty()) {
            if (depositTable.getRowCount() < 1 && withDrawTable.getRowCount() < 1) {
                status = false;
                errorMessage.setOpaque(true);
                errorMessage.setText("Please, enter deposit or withdraw information.");
            } else {
                if (depositTable.getRowCount() > 1) {
                    int rowCount = depositTable.getRowCount();
                    for (int row = 0; row < (rowCount - 1); row++) {
                        if (depositTable.getModel().getValueAt(row, 1) != null) {
                            if (depositTable.getModel().getValueAt(row, 2) != null) {
                                if ((depositTable.getModel().getValueAt(row, 3) != null)) {
                                    if ((depositTable.getModel().getValueAt(row, 4) != null)) {
                                        if ((depositTable.getModel().getValueAt(row, 5) != null)) {
                                            status = true;
                                        } else {

                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, enter deposited amount for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                            break;
                                        }
                                    } else {

                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, select bank account name for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                        break;
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, select the bank account number for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                    break;
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the cash account name for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                break;
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the cash account number for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                            break;
                        }
                    }

                }
                if (withDrawTable.getRowCount() > 1) {
                    status = false;
                    int rowCount = withDrawTable.getRowCount();
                    for (int row = 0; row < (rowCount - 1); row++) {
                        if (withDrawTable.getModel().getValueAt(row, 1) != null) {
                            if (withDrawTable.getModel().getValueAt(row, 2) != null) {
                                if ((withDrawTable.getModel().getValueAt(row, 3) != null)) {
                                    if ((withDrawTable.getModel().getValueAt(row, 4) != null)) {
                                        if ((withDrawTable.getModel().getValueAt(row, 5) != null)) {
                                            status = true;
                                        } else {
                                            errorMessage.setOpaque(true);
                                            errorMessage.setText("Please, enter withdraw amount for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                            break;
                                        }
                                    } else {
                                        errorMessage.setOpaque(true);
                                        errorMessage.setText("Please, select bank account name for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                        break;
                                    }
                                } else {
                                    errorMessage.setOpaque(true);
                                    errorMessage.setText("Please, select the bank account number for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                    break;
                                }
                            } else {
                                errorMessage.setOpaque(true);
                                errorMessage.setText("Please, select the cash account name for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                                break;
                            }
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Please, select the cash account number for row " + depositTable.getModel().getValueAt(row, 0).toString() + ".");
                            break;
                        }
                    }
                }
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

    public String getTotalWithDrawAmt() {
        return withdrawnAmountLabel.getText();
    }

    public String getTotalDepositedAmt() {
        return depositAmountLabel.getText();
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

    public void setTotalWithdrawAmt(String s) {
        withdrawnAmountLabel.setText(s);
    }

    public void setTotalDepositedAmt(String s) {
        depositAmountLabel.setText(s);
    }

    private void setTotalValues() {
        double totalDepositAmt = 0;
        double totalWithdrawAmt = 0;
        for (int i = 0; i < (depositTable.getRowCount() - 1); i++) {
            if (depositTable.getModel().getValueAt(i, 1) != null) {
                if (depositTable.getModel().getValueAt(i, 5) != null) {
                    try {
                        totalDepositAmt = totalDepositAmt + Double.valueOf(depositTable.getModel().getValueAt(i, 5).toString());
                    } catch (NumberFormatException ex) {
                        totalDepositAmt = totalDepositAmt + 0;
                    }

                }
            }
        }
        depositAmountLabel.setText(roundDecimals(totalDepositAmt));
        for (int i = 0; i < (withDrawTable.getRowCount() - 1); i++) {
            if (withDrawTable.getModel().getValueAt(i, 1) != null) {
                if (withDrawTable.getModel().getValueAt(i, 5) != null) {
                    try {
                        totalWithdrawAmt = totalWithdrawAmt + Double.valueOf(withDrawTable.getModel().getValueAt(i, 5).toString());
                    } catch (NumberFormatException ex) {
                        totalWithdrawAmt = totalWithdrawAmt + 0;
                    }

                }
            }
        }
        withdrawnAmountLabel.setText(roundDecimals(totalWithdrawAmt));
    }

    public String roundDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.######");
        String temp = String.valueOf(twoDForm.format(d));
        return temp;
    }

    private void depositTableControl() {
        errorMessage.setText(null);
        errorMessage.setOpaque(false);
        selectedRow = depositTable.getSelectedRow();
        if (selectedRow > -1) {
            if (depositTable.getSelectedRow() == depositTable.getRowCount() - 1) {
                new TableUtils().addingDoubleEntryTableRow(depositTable);
            } else {
                switch (depositTable.getSelectedColumn()) {
                    case 1:
                        showListOfData("cashaccno", depositTable, companyCode);
                        break;
                    case 2:
                        showListOfData("cashaccname", depositTable, companyCode);
                        break;
                    case 3:
                        showListOfData("bankaccno", depositTable, companyCode);
                        break;
                    case 4:
                        showListOfData("bankaccname", depositTable, companyCode);
                        break;
                    case 5:
                        if (depositTable.getModel().getValueAt(selectedRow, 1) != null && depositTable.getModel().getValueAt(selectedRow, 3) != null) {
                            depositAmountTF.setEnabled(true);
                        }
                        break;
                    case 6:
                        if (depositTable.getModel().getValueAt(selectedRow, 1) != null && depositTable.getModel().getValueAt(selectedRow, 3) != null) {
                            depositedSlipNoTF.setEnabled(true);
                        }

                }

            }
        }
    }

    private void withdrawTableControl() {
        errorMessage.setText(null);
        errorMessage.setOpaque(false);
        selectedRow1 = withDrawTable.getSelectedRow();
        if (selectedRow1 > -1) {
            if (withDrawTable.getSelectedRow() == withDrawTable.getRowCount() - 1) {
                new TableUtils().addingDoubleEntryTableRow(withDrawTable);
            } else {
                switch (withDrawTable.getSelectedColumn()) {
                    case 1:
                        showListOfData("cashaccno", withDrawTable, companyCode);
                        break;
                    case 2:
                        showListOfData("cashaccname", withDrawTable, companyCode);
                        break;
                    case 3:
                        showListOfData("bankaccno", withDrawTable, companyCode);
                        break;
                    case 4:
                        showListOfData("bankaccname", withDrawTable, companyCode);
                        break;
                    case 5:
                        if (withDrawTable.getModel().getValueAt(selectedRow1, 1) != null && withDrawTable.getModel().getValueAt(selectedRow1, 3) != null) {
                            withdrawAmountTF.setEnabled(true);
                        }
                        break;
                    case 6:
                        if (withDrawTable.getModel().getValueAt(selectedRow1, 1) != null && withDrawTable.getModel().getValueAt(selectedRow1, 3) != null) {
                            checkOrATMnoTF.setEnabled(true);
                        }

                }

            }
        }
    }

    public String getDepositTable(int row, int col) {
        try {
            return depositTable.getModel().getValueAt(row, col).toString();
        } catch (Exception ex) {
            return null;
        }

    }

    public String getWithDrawTable(int row, int col) {
        try {
            return withDrawTable.getModel().getValueAt(row, col).toString();
        } catch (Exception ex) {
            return null;
        }

    }
}
