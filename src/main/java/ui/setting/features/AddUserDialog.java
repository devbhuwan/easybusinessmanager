package ui.setting.features;

import businessmanager.securitymgr.EncryptionAndDecryption;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.tree.TreeModel;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.main.MainFrame;
import ui.setting.features.handler.*;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AddUserDialog extends javax.swing.JDialog {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final Connection conn;
    private final String msg;
    private PreparedStatement ps;
    private ResultSet rs;
    private TreeModel treeModel;
    private int totalHeight = 0;

    private final String options[] = {
        "Edit Company",
        "Delete Company",
        "Backup Company",
        "Account Creation",
        "Account Group Creation",
        "Customer Creation",
        "Vendor Creation",
        "Item Creation",
        "Item Group Creation",
        "Store Creation",
        "Store Group Creation",
        "Currency Convertor",
        "Unit Creation",
        "Bill Sundry Creation",
        "Sale Order",
        "Purchase Order",
        "Sale Register",
        "Purchase Register",
        "Sale Return",
        "Purchase Return",
        "Payment Voucher",
        "Receipt Voucher",
        "Journal Voucher",
        "Debit Note",
        "Credit Note",
        "Production Voucher",
        "Balance Sheet",
        "Trail Balance",
        "Profit And Loss Report",
        "Account Statement",
        "Day Book",
        "Cash Book",
        "Bank Book",
        "Journal Book",
        "Debit Note Report",
        "Credit Note Report",
        "Stock Report",
        "Sale Report",
        "Purchase Report",
        "Production Report",
        "Add User",
        "Edit User",
        "Delete User",
        "Change Password"
    };

    /**
     * Creates new form MonthWiseReportDialog
     *
     * @param mainFrame
     * @param modal
     * @param companyCode
     * @param conn
     * @param msg
     */
    public AddUserDialog(MainFrame mainFrame, boolean modal, String companyCode, Connection conn, String msg) {
        super(mainFrame, modal);

        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        this.msg = msg;
        totalHeight = 0;
        addButton.setEnabled(false);
        int count = 0;
        for (int i = 0; i < 44; i++) {
            JCheckBox box = new JCheckBox(options[i]);
            accNoList.add(box, count);
            box.setBounds(0, count * 20, accNoList.getWidth(), 20);
            box.setBackground(Color.white);
            totalHeight = totalHeight + 20;
            box.setVisible(true);
            count++;
        }
        accNoList.setPreferredSize(new Dimension(accNoScrollPane.getWidth() - 100, totalHeight));
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void sourceChanged(Binding binding, PropertyStateEvent event) {
                super.sourceChanged(binding, event); //To change body of generated methods, choose Tools | Templates.
                if (selectAllCHB.isSelected() && selectAndUnselectAllCHB.isSelected()) {
                    adminstrativeUserCB.setSelected(true);
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        headerTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        selectAndUnselectAllCHB = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userNameTF = new javax.swing.JTextField();
        userCodeTF = new javax.swing.JTextField();
        passwordF = new javax.swing.JPasswordField();
        verifyPF = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        standardUserCB = new javax.swing.JRadioButton();
        adminstrativeUserCB = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        saveCHB = new javax.swing.JCheckBox();
        updateCHB = new javax.swing.JCheckBox();
        deleteCHB = new javax.swing.JCheckBox();
        printCHB = new javax.swing.JCheckBox();
        selectAllCHB = new javax.swing.JCheckBox();
        accNoScrollPane = new javax.swing.JScrollPane();
        accNoList = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Company Modules");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Company Modules");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Company Modules");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Company Modules");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 204, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Company Modules");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerTitle.setBackground(new java.awt.Color(0, 153, 153));
        headerTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        headerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitle.setText("Add New User");
        headerTitle.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        selectAndUnselectAllCHB.setBackground(new java.awt.Color(255, 255, 255));
        selectAndUnselectAllCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        selectAndUnselectAllCHB.setText("Select All / Unselect All");
        selectAndUnselectAllCHB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectAndUnselectAllCHBItemStateChanged(evt);
            }
        });

        jLabel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Software Features Acess Permission");
        jLabel1.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("User Name :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Password :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("User Code :");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Verify :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Description :");

        userNameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        userCodeTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        passwordF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        verifyPF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        description.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(description);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifyPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14)
                        .addComponent(userNameTF)))
                .addGap(21, 21, 21))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verifyPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, passwordF, userCodeTF, userNameTF, verifyPF});

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "User Type", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12))); // NOI18N

        standardUserCB.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(standardUserCB);
        standardUserCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        standardUserCB.setText("Standard User");
        standardUserCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                standardUserCBItemStateChanged(evt);
            }
        });

        adminstrativeUserCB.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(adminstrativeUserCB);
        adminstrativeUserCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        adminstrativeUserCB.setText("Adminstrator User");
        adminstrativeUserCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                adminstrativeUserCBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(standardUserCB)
                .addGap(18, 18, 18)
                .addComponent(adminstrativeUserCB)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(standardUserCB)
                    .addComponent(adminstrativeUserCB))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")), "User Rights", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12))); // NOI18N

        saveCHB.setBackground(new java.awt.Color(255, 255, 255));
        saveCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        saveCHB.setText("Save");

        updateCHB.setBackground(new java.awt.Color(255, 255, 255));
        updateCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        updateCHB.setText("Update");

        deleteCHB.setBackground(new java.awt.Color(255, 255, 255));
        deleteCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        deleteCHB.setText("Delete");

        printCHB.setBackground(new java.awt.Color(255, 255, 255));
        printCHB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        printCHB.setText("Print");

        selectAllCHB.setBackground(new java.awt.Color(255, 255, 255));
        selectAllCHB.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        selectAllCHB.setText("Select All");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jLabel1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), selectAllCHB, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        selectAllCHB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectAllCHBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveCHB)
                            .addComponent(deleteCHB))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(printCHB)
                            .addComponent(updateCHB)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(selectAllCHB)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveCHB)
                    .addComponent(updateCHB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteCHB)
                    .addComponent(printCHB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectAllCHB)
                .addGap(10, 10, 10))
        );

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
            .addGap(0, 336, Short.MAX_VALUE)
        );

        accNoScrollPane.setViewportView(accNoList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(selectAndUnselectAllCHB)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addComponent(accNoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(accNoScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectAndUnselectAllCHB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        saveButton.setBackground(new java.awt.Color(0, 153, 153));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(0, 153, 153));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 153, 153));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(32, 32, 32))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, cancelButton, saveButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateUserInput()) {
            if (new SettingHandler().checkUserCodeIsValidOrNot(userCodeTF.getText(), this, companyCode, conn)) {
                if (new SettingHandler().saveUserInfo(this, companyCode, conn)) {
                    disableComponent(false);
                    addButton.setEnabled(true);
                    saveButton.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        disableComponent(false);
        saveButton.setEnabled(false);
        addButton.setEnabled(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        clearAllFields();
        disableComponent(true);
        saveButton.setEnabled(true);
        addButton.setEnabled(false);

    }//GEN-LAST:event_addButtonActionPerformed

    private void selectAllCHBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectAllCHBItemStateChanged
        if (selectAllCHB.isSelected()) {
            setRigths(Boolean.TRUE);
        } else {
            setRigths(false);
        }
    }//GEN-LAST:event_selectAllCHBItemStateChanged

    private void selectAndUnselectAllCHBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectAndUnselectAllCHBItemStateChanged
        if (selectAndUnselectAllCHB.isSelected()) {
            softwareFeaturesMake(true);
        } else {
            setRigths(false);
        }
    }//GEN-LAST:event_selectAndUnselectAllCHBItemStateChanged

    private void adminstrativeUserCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminstrativeUserCBItemStateChanged
        if (adminstrativeUserCB.isSelected()) {
            softwareFeaturesMake(Boolean.TRUE);
            setRigths(true);
            disableAdminComponent(Boolean.FALSE);
        }
    }//GEN-LAST:event_adminstrativeUserCBItemStateChanged

    private void standardUserCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_standardUserCBItemStateChanged
        if (standardUserCB.isSelected()) {
            softwareFeaturesMake(false);
            setRigths(false);
            disableAdminComponent(true);
        }
    }//GEN-LAST:event_standardUserCBItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accNoList;
    private javax.swing.JScrollPane accNoScrollPane;
    private javax.swing.JButton addButton;
    private javax.swing.JRadioButton adminstrativeUserCB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox deleteCHB;
    private javax.swing.JTextPane description;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordF;
    private javax.swing.JCheckBox printCHB;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox saveCHB;
    private javax.swing.JCheckBox selectAllCHB;
    private javax.swing.JCheckBox selectAndUnselectAllCHB;
    private javax.swing.JRadioButton standardUserCB;
    private javax.swing.JCheckBox updateCHB;
    private javax.swing.JTextField userCodeTF;
    private javax.swing.JTextField userNameTF;
    private javax.swing.JPasswordField verifyPF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void softwareFeaturesMake(Boolean b) {
        for (int i = 0; i < 44; i++) {
            JCheckBox box = (JCheckBox) accNoList.getComponent(i);
            box.setSelected(b);
        }
        selectAllCHB.setSelected(b);
        selectAndUnselectAllCHB.setSelected(b);
    }

    private void disableAdminComponent(Boolean b) {
        accNoList.setEnabled(b);
        for (int i = 0; i < 44; i++) {
            JCheckBox box = (JCheckBox) accNoList.getComponent(i);
            box.setEnabled(b);
        }
        saveCHB.setEnabled(b);
        updateCHB.setEnabled(b);
        deleteCHB.setEnabled(b);
        printCHB.setEnabled(b);
        selectAllCHB.setEnabled(b);
        selectAndUnselectAllCHB.setEnabled(b);
    }

    private void setRigths(Boolean b) {
        saveCHB.setSelected(b);
        updateCHB.setSelected(b);
        deleteCHB.setSelected(b);
        printCHB.setSelected(b);
    }

    private boolean validateUserInput() {
        boolean status = false;
        if (!userNameTF.getText().isEmpty()) {
            if (!userCodeTF.getText().isEmpty()) {
                if (!passwordF.getText().isEmpty()) {
                    if (passwordF.getText().equals(verifyPF.getText())) {
                        if (standardUserCB.isSelected() || adminstrativeUserCB.isSelected()) {
                            status = true;
                        } else {
                            JOptionPane.showMessageDialog(this, "Please select user type.", "Error", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Passwoed does not match.", "Error", JOptionPane.WARNING_MESSAGE);
                        verifyPF.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter password.", "Error", JOptionPane.WARNING_MESSAGE);
                    passwordF.requestFocusInWindow();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter user code.", "Error", JOptionPane.WARNING_MESSAGE);
                userCodeTF.requestFocusInWindow();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter user name.", "Error", JOptionPane.WARNING_MESSAGE);
            userNameTF.requestFocusInWindow();
        }
        return status;
    }

    private void clearAllFields() {
        userNameTF.setText(null);
        userCodeTF.setText(null);
        passwordF.setText(null);
        verifyPF.setText(null);
        description.setText(null);
        selectAllCHB.setSelected(false);
        selectAndUnselectAllCHB.setSelected(false);
        standardUserCB.setSelected(false);
        adminstrativeUserCB.setSelected(false);

    }

    private void disableComponent(boolean b) {
        userNameTF.setEnabled(b);
        userCodeTF.setEnabled(b);
        passwordF.setEnabled(b);
        verifyPF.setEnabled(b);
        standardUserCB.setEnabled(b);
        adminstrativeUserCB.setEnabled(b);
        disableAdminComponent(b);
    }

    public String getUserName() {
        return userNameTF.getText();
    }

    public String getUserCode() {
        return userCodeTF.getText();
    }

    public String getUserType() {
        String s = null;
        if (standardUserCB.isSelected()) {
            s = "Standard";
        } else if (adminstrativeUserCB.isSelected()) {
            s = "Admin";
        }
        return s;
    }

    public String getUserRights() {
        String s = null;
        if (standardUserCB.isSelected()) {
            if (saveCHB.isSelected()) {
                s = s + "@Save";
            }
            if (updateCHB.isSelected()) {
                s = s + "@Update";
            }
            if (deleteCHB.isSelected()) {
                s = s + "@Delete";
            }
            if (printCHB.isSelected()) {
                s = s + "@Print";
            }
        } else if (adminstrativeUserCB.isSelected()) {
            s = "All";
        }
        return s;
    }

    public String getUserPermittedFeatures() {
        String s = null;
        if (standardUserCB.isSelected()) {
            for (int i = 0; i < 44; i++) {
                JCheckBox box = (JCheckBox) accNoList.getComponent(i);
                if (box.isSelected()) {
                    s = s + "@" + box.getText();
                }
            }
        } else if (adminstrativeUserCB.isSelected()) {
            s = "All";
        }
        return s;
    }

    public String getUserPassword() {
        byte pss[] = EncryptionAndDecryption.encrypt(passwordF.getText().toString());
        return passwordF.getText().toString();
    }

    public String getDescription() {
        return description.getText();
    }

}
