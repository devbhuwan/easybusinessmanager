package ui.setting;

import ui.setting.features.AddUserDialog;
import ui.company.*;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.setting.features.ChangePasswordDialog;
import ui.setting.features.DeleteUserDialog;
import ui.setting.features.ModifyUserDialog;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class SettingFrame extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private CreateCompanyFrame createCompanyFrame;
    private final MainFrame mainFrame;
    private OpenCompanyFrame openCompanyFrame;
    private final FeatureFrame featureFrame;
    private final String companyCode;
    private final Connection conn;
    private CloseCompanyDialog closeCompany;
    private AddUserDialog addUserDialog;
    private ModifyUserDialog modifyUserDialog;
    private DeleteUserDialog deleteUserDialog;
    private ChangePasswordDialog changePassworDialog;

    /**
     * Creates new form WelcomeFrame
     *
     * @param mainFrame
     * @param featureFrame
     * @param companyCode
     * @param conn
     */
    public SettingFrame(MainFrame mainFrame, FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        addButtonOnLabel(addNewUserButton, addNewUserLabel);
        addButtonOnLabel(editUserButton, editUserLabel);
        addButtonOnLabel(deleteUserButton, deleteUserLabel);
        addButtonOnLabel(changePasswordButton, changePasswordLabel);
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        headerTitle.setText("Settings");
        addNewUserButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNewUserButton = new javax.swing.JButton();
        editUserButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        changePasswordButton = new javax.swing.JButton();
        subMenu = new javax.swing.JLayeredPane();
        addNewUserLabel = new javax.swing.JLabel();
        editUserLabel = new javax.swing.JLabel();
        deleteUserLabel = new javax.swing.JLabel();
        changePasswordLabel = new javax.swing.JLabel();
        headerTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        addNewUserButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        addNewUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/add_user.png"))); // NOI18N
        addNewUserButton.setText("Add New User");
        addNewUserButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        addNewUserButton.setContentAreaFilled(false);
        addNewUserButton.setFocusPainted(false);
        addNewUserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addNewUserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addNewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addNewUserButtonMouseEntered(evt);
            }
        });
        addNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserButtonActionPerformed(evt);
            }
        });

        editUserButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        editUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/edit_user.png"))); // NOI18N
        editUserButton.setText("Edit User");
        editUserButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        editUserButton.setContentAreaFilled(false);
        editUserButton.setFocusPainted(false);
        editUserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editUserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editUserButtonMouseExited(evt);
            }
        });
        editUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        deleteUserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/remove_user.png"))); // NOI18N
        deleteUserButton.setText("Delete User");
        deleteUserButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        deleteUserButton.setContentAreaFilled(false);
        deleteUserButton.setFocusPainted(false);
        deleteUserButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteUserButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteUserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteUserButtonMouseExited(evt);
            }
        });
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        changePasswordButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        changePasswordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/CRISTAL KEY.png"))); // NOI18N
        changePasswordButton.setText("Change Password");
        changePasswordButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        changePasswordButton.setContentAreaFilled(false);
        changePasswordButton.setFocusPainted(false);
        changePasswordButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        changePasswordButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        changePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePasswordButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePasswordButtonMouseExited(evt);
            }
        });
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordButtonActionPerformed(evt);
            }
        });

        addNewUserLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        addNewUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addNewUserLabelMouseExited(evt);
            }
        });

        editUserLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        deleteUserLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        changePasswordLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout subMenuLayout = new javax.swing.GroupLayout(subMenu);
        subMenu.setLayout(subMenuLayout);
        subMenuLayout.setHorizontalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(deleteUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(changePasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(addNewUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(editUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        subMenuLayout.setVerticalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(editUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(changePasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(addNewUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(deleteUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        subMenu.setLayer(addNewUserLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(editUserLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(deleteUserLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(changePasswordLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        headerTitle.setBackground(new java.awt.Color(102, 102, 102));
        headerTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        headerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitle.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(headerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserButtonActionPerformed
        addNewUserFrameFrame();
    }//GEN-LAST:event_addNewUserButtonActionPerformed

    private void addNewUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewUserButtonMouseEntered
        hoverBackground(addNewUserButton, addNewUserLabel);
    }//GEN-LAST:event_addNewUserButtonMouseEntered

    private void addNewUserLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewUserLabelMouseExited
        noActiveBackground(addNewUserButton, addNewUserLabel);
    }//GEN-LAST:event_addNewUserLabelMouseExited

    private void editUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserButtonActionPerformed
        addModifyUserFrameFrame();
    }//GEN-LAST:event_editUserButtonActionPerformed

    private void editUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUserButtonMouseEntered
        hoverBackground(editUserButton, editUserLabel);

    }//GEN-LAST:event_editUserButtonMouseEntered

    private void editUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editUserButtonMouseExited
        noActiveBackground(editUserButton, editUserLabel);
    }//GEN-LAST:event_editUserButtonMouseExited

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        addDeleteUserFrameFrame();
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void deleteUserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserButtonMouseEntered
        hoverBackground(deleteUserButton, deleteUserLabel);
    }//GEN-LAST:event_deleteUserButtonMouseEntered

    private void deleteUserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserButtonMouseExited
        noActiveBackground(deleteUserButton, deleteUserLabel);

    }//GEN-LAST:event_deleteUserButtonMouseExited

    private void changePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordButtonActionPerformed
        addChangeUserFrameFrame();
    }//GEN-LAST:event_changePasswordButtonActionPerformed

    private void changePasswordButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordButtonMouseEntered
        hoverBackground(changePasswordButton, changePasswordLabel);
    }//GEN-LAST:event_changePasswordButtonMouseEntered

    private void changePasswordButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordButtonMouseExited
        noActiveBackground(changePasswordButton, changePasswordLabel);
    }//GEN-LAST:event_changePasswordButtonMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewUserButton;
    private javax.swing.JLabel addNewUserLabel;
    private javax.swing.JButton changePasswordButton;
    private javax.swing.JLabel changePasswordLabel;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JLabel deleteUserLabel;
    private javax.swing.JButton editUserButton;
    private javax.swing.JLabel editUserLabel;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane subMenu;
    // End of variables declaration//GEN-END:variables

    private void addButtonOnLabel(JButton btn, JLabel label) {
        label.add(btn);
        btn.setBounds(25, 15, 150, 150);
        btn.setVisible(true);
    }

    private void noActiveBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.black);
        label.setIcon(null);
        btn.setBorderPainted(true);
    }

    private void hoverBackground(JButton btn, JLabel label) {
        noActiveBackground(addNewUserButton, addNewUserLabel);
        noActiveBackground(editUserButton, editUserLabel);
        noActiveBackground(deleteUserButton, deleteUserLabel);
        noActiveBackground(changePasswordButton, changePasswordLabel);
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getHoverMainButtonIcon());
        btn.setBorderPainted(false);
    }

    private void addNewUserFrameFrame() {
        addUserDialog = new AddUserDialog(mainFrame, true, companyCode, conn, companyCode);
        addUserDialog.setLocationRelativeTo(mainFrame);
        addUserDialog.setVisible(true);
    }

    public void setNullToAllWindows() {
    }

    private void addModifyUserFrameFrame() {
        modifyUserDialog = new ModifyUserDialog(mainFrame, true, companyCode, conn, companyCode);
        modifyUserDialog.setLocationRelativeTo(mainFrame);
        modifyUserDialog.setVisible(true);
    }

    private void addDeleteUserFrameFrame() {
        deleteUserDialog = new DeleteUserDialog(mainFrame, true, companyCode, conn, companyCode);
        deleteUserDialog.setLocationRelativeTo(mainFrame);
        deleteUserDialog.setVisible(true);
    }

    private void addChangeUserFrameFrame() {
        changePassworDialog = new ChangePasswordDialog(mainFrame, true, companyCode, conn, companyCode);
        changePassworDialog.setLocationRelativeTo(mainFrame);
        changePassworDialog.setVisible(true);
    }
}
