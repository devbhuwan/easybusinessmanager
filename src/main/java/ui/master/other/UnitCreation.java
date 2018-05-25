package ui.master.other;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.text.MessageFormat;
import javax.swing.JTable;
import ui.feature.TableUI;
import ui.master.FetchMasterData;
import ui.master.other.utils.OtherHandler;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class UnitCreation extends javax.swing.JPanel {

    private final String companyCode;
    private final Connection conn;
    private String unitName;
    private String companyName;

    /**
     * Creates new form AccountCreation
     *
     * @param companyCode
     * @param conn
     */
    public UnitCreation(String companyCode, Connection conn) {
        initComponents();
        this.companyCode = companyCode;
        listControl.setVisible(false);
        defaultControlShow();
        list.setVisible(false);
        contentPanel.setVisible(true);
        this.conn = conn;
        unitListTable.setTableHeader(new TableUI().getTableHeaderUI(unitListTable));
        new FetchMasterData().fetchUnitName(primaryUnitCB, companyCode, conn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        unitListTable = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        contentPanel = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        unitNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unitAbbTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        singleRB = new javax.swing.JRadioButton();
        compRB = new javax.swing.JRadioButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        decimalPlaceCB = new javax.swing.JComboBox();
        perUnitFT = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTA = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        primaryUnitCB = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        listButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();
        controlMain = new javax.swing.JLayeredPane();
        mainControl = new javax.swing.JLayeredPane();
        addButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        listControl = new javax.swing.JLayeredPane();
        printButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        list.setBackground(new java.awt.Color(255, 255, 255));

        unitListTable.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        unitListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. N.", "Unit Name", "Unit Abbreviation", "Unit Type", "Primary Unit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        unitListTable.setFocusable(false);
        unitListTable.setRowHeight(23);
        unitListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        unitListTable.getTableHeader().setReorderingAllowed(false);
        unitListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unitListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(unitListTable);
        if (unitListTable.getColumnModel().getColumnCount() > 0) {
            unitListTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            unitListTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            unitListTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            unitListTable.getColumnModel().getColumn(3).setPreferredWidth(250);
            unitListTable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
            .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
            .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(listLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Unit Details"));

        unitNameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Unit Name :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Unit Abbreviation :");

        unitAbbTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Unit Type :");

        singleRB.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(singleRB);
        singleRB.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        singleRB.setText("Single");
        singleRB.setFocusPainted(false);
        singleRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                singleRBItemStateChanged(evt);
            }
        });
        singleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRBActionPerformed(evt);
            }
        });

        compRB.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(compRB);
        compRB.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        compRB.setText("Compound");
        compRB.setFocusPainted(false);
        compRB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                compRBItemStateChanged(evt);
            }
        });
        compRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compRBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(singleRB)
                        .addGap(18, 18, 18)
                        .addComponent(compRB))
                    .addComponent(unitAbbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitAbbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(singleRB)
                    .addComponent(compRB))
                .addContainerGap())
        );
        jLayeredPane1.setLayer(unitNameTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(unitAbbTF, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(singleRB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(compRB, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Other Details"));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Decimal Places :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Per Unit :");

        decimalPlaceCB.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        decimalPlaceCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3" }));
        decimalPlaceCB.setSelectedIndex(-1);
        decimalPlaceCB.setBorder(null);

        perUnitFT.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        perUnitFT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                perUnitFTKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Description :");

        descriptionTA.setColumns(20);
        descriptionTA.setRows(5);
        jScrollPane1.setViewportView(descriptionTA);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setText("Primary Unit :");

        primaryUnitCB.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        primaryUnitCB.setBorder(null);
        primaryUnitCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                primaryUnitCBMouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("{ 1 Unit Name = Per Unit * Primary Unit }");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(perUnitFT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(primaryUnitCB, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(decimalPlaceCB, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(197, 197, 197)))
                .addGap(30, 30, 30))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(decimalPlaceCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(primaryUnitCB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(perUnitFT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLayeredPane2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {decimalPlaceCB, jLabel11, jLabel5, jLabel7, perUnitFT, primaryUnitCB});

        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(decimalPlaceCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(perUnitFT, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(primaryUnitCB, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        listButton.setBackground(new java.awt.Color(255, 255, 255));
        listButton.setText("List");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        errorMessage.setBackground(new java.awt.Color(255, 255, 255));
        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(204, 0, 0));
        errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorMessage.setOpaque(true);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listButton))
                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLayeredPane1)
                        .addComponent(jLayeredPane2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listButton)
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        controlMain.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));

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

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorder(null);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
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

        javax.swing.GroupLayout mainControlLayout = new javax.swing.GroupLayout(mainControl);
        mainControl.setLayout(mainControlLayout);
        mainControlLayout.setHorizontalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        mainControlLayout.setVerticalGroup(
            mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainControlLayout.createSequentialGroup()
                        .addGroup(mainControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mainControl.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(saveButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainControl.setLayer(editButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        printButton.setBackground(new java.awt.Color(255, 255, 255));
        printButton.setText("Print");
        printButton.setBorder(null);
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listControlLayout = new javax.swing.GroupLayout(listControl);
        listControl.setLayout(listControlLayout);
        listControlLayout.setHorizontalGroup(
            listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        listControlLayout.setVerticalGroup(
            listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listControlLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(listControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        listControl.setLayer(printButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        listControl.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout controlMainLayout = new javax.swing.GroupLayout(controlMain);
        controlMain.setLayout(controlMainLayout);
        controlMainLayout.setHorizontalGroup(
            controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        controlMainLayout.setVerticalGroup(
            controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(controlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
        controlMain.setLayer(mainControl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        controlMain.setLayer(listControl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(controlMain, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.clearAllField();
        this.enableAllField(true);
        this.addControlShow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new OtherHandler().checkUnitIsValidOrNot(companyCode, unitNameTF.getText(), conn)) {
                if (new OtherHandler().saveUnitInformation(companyCode, this, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Bill sundry name is already exist.");
                unitNameTF.requestFocusInWindow();
                unitNameTF.selectAll();
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (validateUserInput()) {
            if (unitNameTF.getText().equalsIgnoreCase(unitName)) {
                if (new OtherHandler().updateUnitInformation(companyCode, this, unitName, conn)) {
                    this.enableAllField(false);
                    this.saveOrUpdateControlShow();
                }
            } else {
                if (new OtherHandler().checkUnitIsValidOrNot(companyCode, unitNameTF.getText(), conn)) {
                    if (new OtherHandler().updateUnitInformation(companyCode, this, unitName, conn)) {
                        this.enableAllField(false);
                        this.saveOrUpdateControlShow();
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Unit name is already exist.");
                    unitNameTF.requestFocusInWindow();
                    unitNameTF.selectAll();
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.clearAllField();
        this.enableAllField(false);
        showCancelControl();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (new OtherHandler().deleteUnit(companyCode, unitNameTF.getText(), conn)) {
            this.clearAllField();
            this.enableAllField(false);
            this.deleteControlShow();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            companyName = new FetchMasterData().getCompanyName(companyCode, conn);
            MessageFormat headerFormat = new MessageFormat("List Of Units [ " + companyName + " (" + companyCode + ") ]");
            MessageFormat footerFormat = new MessageFormat("                                               Authorised Signature");
            unitListTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException pe) {
            System.err.println("Error printing: " + pe.getMessage());
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        list.setVisible(false);
        contentPanel.setVisible(true);
        listControl.setVisible(false);
        mainControl.setVisible(true);
        this.remove(list);
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (new OtherHandler().fetchunitInformation(companyCode, unitListTable, conn)) {
            this.add(list);
            list.setBounds(0, 0, this.getWidth(), this.getHeight() - 45);
            contentPanel.setVisible(false);
            list.setVisible(true);
            mainControl.setVisible(false);
            listControl.setVisible(true);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        editButtonActionPerformed(evt);
    }//GEN-LAST:event_listButtonActionPerformed

    private void singleRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRBActionPerformed

    }//GEN-LAST:event_singleRBActionPerformed

    private void compRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compRBActionPerformed

    }//GEN-LAST:event_compRBActionPerformed

    private void primaryUnitCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_primaryUnitCBMouseEntered
        new FetchMasterData().fetchUnitName(primaryUnitCB, companyCode, conn);
    }//GEN-LAST:event_primaryUnitCBMouseEntered

    private void unitListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unitListTableMouseClicked
        if (unitListTable.getRowCount() > 0) {
            if (evt.getClickCount() > 1 && unitListTable.getSelectedRow() > -1) {
                unitName = unitListTable.getValueAt(unitListTable.getSelectedRow(), 1).toString();
                if (new OtherHandler().fetchDataOfUnit(companyCode, unitName, this, conn)) {
                    list.setVisible(false);
                    contentPanel.setVisible(true);
                    listControl.setVisible(false);
                    mainControl.setVisible(true);
                    this.remove(list);
                    enableAllField(true);
                    showEditOrListControl();

                }
            }
        }
    }//GEN-LAST:event_unitListTableMouseClicked

    private void singleRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_singleRBItemStateChanged
        if (singleRB.isSelected()) {
            jLabel11.setVisible(false);
            primaryUnitCB.setVisible(false);
            primaryUnitCB.setSelectedIndex(-1);
            perUnitFT.setText(null);
            jLabel7.setVisible(false);
            perUnitFT.setVisible(false);
            jLabel2.setVisible(false);
            jLabel5.setVisible(true);
            decimalPlaceCB.setVisible(true);
        }
    }//GEN-LAST:event_singleRBItemStateChanged

    private void compRBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_compRBItemStateChanged
        if (compRB.isSelected()) {
            jLabel5.setVisible(false);
            decimalPlaceCB.setSelectedIndex(-1);
            decimalPlaceCB.setVisible(false);
            jLabel11.setVisible(true);
            primaryUnitCB.setVisible(true);
            jLabel7.setVisible(true);
            perUnitFT.setVisible(true);
            jLabel2.setVisible(true);

        }
    }//GEN-LAST:event_compRBItemStateChanged

    private void perUnitFTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_perUnitFTKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != '.') {
            if ((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) {
                Toolkit.getDefaultToolkit().beep();
                evt.consume();
            }
        } else if (evt.getKeyChar() == '.') {
            if (perUnitFT.getText().isEmpty()) {
                evt.consume();
            } else if (perUnitFT.getText().contains(".")) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_perUnitFTKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton compRB;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLayeredPane controlMain;
    private javax.swing.JComboBox decimalPlaceCB;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionTA;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel list;
    private javax.swing.JButton listButton;
    private javax.swing.JLayeredPane listControl;
    private javax.swing.JLayeredPane mainControl;
    private javax.swing.JFormattedTextField perUnitFT;
    private javax.swing.JComboBox primaryUnitCB;
    private javax.swing.JButton printButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton singleRB;
    private javax.swing.JTextField unitAbbTF;
    private javax.swing.JTable unitListTable;
    private javax.swing.JTextField unitNameTF;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private void clearAllField() {
        unitNameTF.setText(null);
        unitAbbTF.setText(null);
        singleRB.setSelected(false);
        compRB.setSelected(false);
        decimalPlaceCB.setSelectedIndex(-1);
        primaryUnitCB.setSelectedIndex(-1);
        perUnitFT.setText(null);
        descriptionTA.setText(null);
    }

    private void addControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    private void enableAllField(boolean b) {
        jLayeredPane1.setEnabled(b);
        unitNameTF.setEnabled(b);
        jLabel3.setEnabled(b);
        jLabel4.setEnabled(b);
        unitAbbTF.setEnabled(b);
        jLabel10.setEnabled(b);
        singleRB.setEnabled(b);
        compRB.setEnabled(b);
        jLayeredPane2.setEnabled(b);
        jLabel5.setEnabled(b);
        jLabel11.setEnabled(b);
        jLabel7.setEnabled(b);
        jLabel1.setEnabled(b);
        jScrollPane1.setEnabled(b);
        jLabel2.setEnabled(b);
        decimalPlaceCB.setEnabled(b);
        primaryUnitCB.setEnabled(b);
        perUnitFT.setEnabled(b);
        descriptionTA.setEnabled(b);
    }

    private void defaultControlShow() {
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        updateButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        editButton.setEnabled(false);

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

    private boolean validateUserInput() {
        boolean status = false;
        if (!unitNameTF.getText().isEmpty()) {
            if (!unitAbbTF.getText().isEmpty()) {
                if (singleRB.isSelected()) {
                    if (decimalPlaceCB.getSelectedIndex() > -1) {
                        status = true;
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Select decimal place is required.");
                        decimalPlaceCB.requestFocusInWindow();
                    }
                } else if (compRB.isSelected()) {
                    if (primaryUnitCB.getSelectedIndex() > -1) {
                        if (!perUnitFT.getText().isEmpty()) {
                            status = true;
                        } else {
                            errorMessage.setOpaque(true);
                            errorMessage.setText("Per unit is required.");
                            perUnitFT.requestFocusInWindow();
                        }
                    } else {
                        errorMessage.setOpaque(true);
                        errorMessage.setText("Select primary unit.");
                        primaryUnitCB.requestFocusInWindow();
                    }
                } else {
                    errorMessage.setOpaque(true);
                    errorMessage.setText("Unit type is required.");
                }
            } else {
                errorMessage.setOpaque(true);
                errorMessage.setText("Unit abbreviation is required.");
                unitAbbTF.requestFocusInWindow();
            }
        } else {
            errorMessage.setOpaque(true);
            errorMessage.setText("Unit name is required.");
            unitNameTF.requestFocusInWindow();
        }
        return status;
    }

    public String getUnitName() {
        return unitNameTF.getText();
    }

    public String getUnitAbb() {
        return unitAbbTF.getText();
    }

    public String getUnitType() {
        if (singleRB.isSelected()) {
            return "Single";
        } else {
            return "Compound";
        }
    }

    public String getDecimalPlace() {
        if (singleRB.isSelected()) {
            if (decimalPlaceCB.getSelectedIndex() > -1) {
                return decimalPlaceCB.getSelectedItem().toString();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public String getPrimaryUnit() {
        if (compRB.isSelected()) {
            if (primaryUnitCB.getSelectedIndex() > -1) {
                return primaryUnitCB.getSelectedItem().toString();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    public String getPerUnit() {
        if (compRB.isSelected()) {
            return perUnitFT.getText();
        } else {
            return null;
        }
        
    }

    public String description() {
        return descriptionTA.getText();
    }

    public void setUnitName(String string) {
        unitNameTF.setText(string);
    }

    public void setUnitAbb(String string) {
        unitAbbTF.setText(string);
    }

    public void setUnitSingleType(String string) {
        singleRB.setSelected(true);
        decimalPlaceCB.setSelectedItem(string);
        compRB.setSelected(false);
        primaryUnitCB.setSelectedIndex(-1);
        perUnitFT.setText(null);
    }

    public void setUnitCompaoundType(String string, String string0) {
        singleRB.setSelected(false);
        decimalPlaceCB.setSelectedIndex(-1);
        compRB.setSelected(true);
        primaryUnitCB.setSelectedItem(string);
        perUnitFT.setText(string0);
    }

    public void setDescription(String string) {
        descriptionTA.setText(string);
    }
}
