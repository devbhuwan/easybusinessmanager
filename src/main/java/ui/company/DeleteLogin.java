package ui.company;

import businessmanager.securitymgr.EncryptionAndDecryption;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.main.MainFrame;
import ui.welcome.WelcomeFrame;

/**
 *
 * @author Bhuwan Upadhyay
 * @version 1.0.0
 */
public class DeleteLogin extends javax.swing.JDialog {

    private final Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;
    private final WelcomeFrame welcomeFrame;

    /**
     * Creates new form Login
     *
     * @param parent
     * @param modal
     * @param companyCode
     * @param welcomeFrame
     */
    public DeleteLogin(MainFrame parent, boolean modal, String companyCode, WelcomeFrame welcomeFrame) {
        super(parent, modal);
        this.mainFrame = parent;
        this.welcomeFrame = welcomeFrame;
        initComponents();
        companyCodeTF.setText(companyCode);
        companyCodeTF.setEditable(false);
        userCodeTF.requestFocusInWindow();
        errorLabel.setVisible(false);
        mainFrame.setConnections(companyCode);
        this.conn = mainFrame.getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        companyCodeTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        userCodeTF = new javax.swing.JTextField();
        layeredPane = new javax.swing.JLayeredPane();
        sep = new javax.swing.JSeparator();
        verifyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Company Code :");

        companyCodeTF.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        companyCodeTF.setForeground(new java.awt.Color(0, 153, 0));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Code :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");

        passwordField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        userCodeTF.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        userCodeTF.setForeground(new java.awt.Color(0, 153, 0));
        userCodeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userCodeTFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userCodeTF)
                    .addComponent(companyCodeTF)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(companyCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {companyCodeTF, jLabel1, jLabel2, jLabel3, passwordField, userCodeTF});

        layeredPane.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        layeredPane.setOpaque(true);

        verifyButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        verifyButton.setText("Verify");
        verifyButton.setBorderPainted(false);
        verifyButton.setFocusPainted(false);
        verifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        cancelButton.setText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layeredPaneLayout = new javax.swing.GroupLayout(layeredPane);
        layeredPane.setLayout(layeredPaneLayout);
        layeredPaneLayout.setHorizontalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layeredPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(verifyButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(23, 23, 23))
        );

        layeredPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, verifyButton});

        layeredPaneLayout.setVerticalGroup(
            layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredPaneLayout.createSequentialGroup()
                .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addGap(8, 8, 8))
        );

        layeredPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelButton, verifyButton});

        layeredPane.setLayer(sep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(verifyButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layeredPane.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/company/Keychain.png"))); // NOI18N
        jLabel4.setText("Login");
        jLabel4.setIconTextGap(-10);

        errorLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setText("User code does not match.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPane)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(layeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyButtonActionPerformed
        try {
            conn.setAutoCommit(false);
            String query = "select * from COMPANY_DETAIL where companyCode = ? and userCode = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCodeTF.getText());
            ps.setString(2, userCodeTF.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                if (passwordField.getText().equals(password)) {
                    deleteCompanyData(companyCodeTF.getText());
                } else {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Password does not match.");
                    Toolkit.getDefaultToolkit().beep();
                    passwordField.requestFocusInWindow();
                    passwordField.selectAll();
                }

            } else {
                try {
                    Connection c = mainFrame.getConnection2();
                    c.setAutoCommit(false);
                    String sql = "select * from USER_DETAIL where companyCode = ? AND userCode = ? AND userType = 'Admin'";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.setString(1, companyCodeTF.getText());
                    p.setString(2, userCodeTF.getText());
                    ResultSet r = p.executeQuery();
                    if (r.next()) {
                        String password = r.getString("password");
                        if (password.equals(password)) {
                            deleteCompanyData(companyCodeTF.getText());
                        } else {
                            errorLabel.setVisible(true);
                            errorLabel.setText("Password does not match.");
                            Toolkit.getDefaultToolkit().beep();
                            passwordField.requestFocusInWindow();
                            passwordField.selectAll();
                        }
                    } else {
                        errorLabel.setVisible(true);
                        errorLabel.setText("User Code does not match.");
                        Toolkit.getDefaultToolkit().beep();
                        userCodeTF.requestFocusInWindow();
                        userCodeTF.selectAll();
                    }
                    c.commit();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_verifyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
        mainFrame.closeConnectionCompany();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void userCodeTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userCodeTFKeyTyped
        errorLabel.setVisible(false);
        passwordField.select(0, 0);
    }//GEN-LAST:event_userCodeTFKeyTyped

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        errorLabel.setVisible(false);
    }//GEN-LAST:event_passwordFieldKeyTyped

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        passwordField.selectAll();
    }//GEN-LAST:event_passwordFieldFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField companyCodeTF;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLayeredPane layeredPane;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JSeparator sep;
    private javax.swing.JTextField userCodeTF;
    private javax.swing.JButton verifyButton;
    // End of variables declaration//GEN-END:variables

    private void deleteCompanyData(String companyCode) {
        try {
            Connection c = mainFrame.getConnection5();
            c.setAutoCommit(false);
            String query = "delete from COMPANY_INFO where companyCode = ?";
            ps = c.prepareStatement(query);
            ps.setString(1, companyCode);
            ps.executeUpdate();
            c.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            conn.setAutoCommit(false);
            String query = "delete from COMPANY_DETAIL where companyCode = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, companyCode);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        mainFrame.closeConnectionCompany();
        String envDirectory = System.getenv("ProgramFiles");
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/db_log/" + companyCode + "/", "buzmgrdb.accdb");
        Path pathD = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/db_log/" + companyCode + "/");
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(CompanyDBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Files.deleteIfExists(pathD);
        } catch (IOException ex) {
            Logger.getLogger(DeleteLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();

    }

}
