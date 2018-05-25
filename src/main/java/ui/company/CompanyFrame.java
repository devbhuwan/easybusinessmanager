package ui.company;

import businessmanager.backuprecovery.BackupDB;
import businessmanager.backuprecovery.RestoreDB;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class CompanyFrame extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private CreateCompanyFrame createCompanyFrame;
    private final MainFrame mainFrame;
    private OpenCompanyFrame openCompanyFrame;
    private final FeatureFrame featureFrame;
    private final String companyCode;
    private final Connection conn;
    private CloseCompanyDialog closeCompany;
    private BackupDB backupDB;
    private RestoreDB restoreDB;

    /**
     * Creates new form WelcomeFrame
     *
     * @param mainFrame
     * @param featureFrame
     * @param companyCode
     * @param conn
     */
    public CompanyFrame(MainFrame mainFrame, FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        addButtonOnLabel(editCompanyButton, editNewCompanyLabel);
        addButtonOnLabel(closeCompanyButton, closeCompanyButtonLabel);
        addButtonOnLabel(restoreButton, restoreLabel);
        addButtonOnLabel(backupCompanyButton, backupCompanyLabel);
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        headerTitle.setText("Your Company Utilities");
        restoreButton.setEnabled(false);
        editCompanyButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editCompanyButton = new javax.swing.JButton();
        closeCompanyButton = new javax.swing.JButton();
        backupCompanyButton = new javax.swing.JButton();
        restoreButton = new javax.swing.JButton();
        subMenu = new javax.swing.JLayeredPane();
        editNewCompanyLabel = new javax.swing.JLabel();
        backupCompanyLabel = new javax.swing.JLabel();
        closeCompanyButtonLabel = new javax.swing.JLabel();
        restoreLabel = new javax.swing.JLabel();
        headerTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        editCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        editCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/editCompany.png"))); // NOI18N
        editCompanyButton.setText("Modify Company");
        editCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        editCompanyButton.setContentAreaFilled(false);
        editCompanyButton.setFocusPainted(false);
        editCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editCompanyButtonMouseEntered(evt);
            }
        });
        editCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCompanyButtonActionPerformed(evt);
            }
        });

        closeCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        closeCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/closeCompany.png"))); // NOI18N
        closeCompanyButton.setText("Close Company");
        closeCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        closeCompanyButton.setContentAreaFilled(false);
        closeCompanyButton.setFocusPainted(false);
        closeCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        closeCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        closeCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeCompanyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeCompanyButtonMouseExited(evt);
            }
        });
        closeCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeCompanyButtonActionPerformed(evt);
            }
        });

        backupCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        backupCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/backupCompany.png"))); // NOI18N
        backupCompanyButton.setText("Backup Company");
        backupCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        backupCompanyButton.setContentAreaFilled(false);
        backupCompanyButton.setFocusPainted(false);
        backupCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backupCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backupCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backupCompanyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backupCompanyButtonMouseExited(evt);
            }
        });
        backupCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupCompanyButtonActionPerformed(evt);
            }
        });

        restoreButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        restoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/restart (Copy).png"))); // NOI18N
        restoreButton.setText("Restore Company");
        restoreButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        restoreButton.setContentAreaFilled(false);
        restoreButton.setFocusPainted(false);
        restoreButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        restoreButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        restoreButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restoreButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restoreButtonMouseExited(evt);
            }
        });
        restoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreButtonActionPerformed(evt);
            }
        });

        editNewCompanyLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        editNewCompanyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editNewCompanyLabelMouseExited(evt);
            }
        });

        backupCompanyLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        closeCompanyButtonLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        restoreLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout subMenuLayout = new javax.swing.GroupLayout(subMenu);
        subMenu.setLayout(subMenuLayout);
        subMenuLayout.setHorizontalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editNewCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(backupCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(closeCompanyButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        subMenuLayout.setVerticalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backupCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeCompanyButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editNewCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(restoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subMenu.setLayer(editNewCompanyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(backupCompanyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(closeCompanyButtonLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(restoreLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        headerTitle.setBackground(new java.awt.Color(109, 25, 53));
        headerTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        headerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitle.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(109, 25, 53));
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCompanyButtonActionPerformed

        addModifyCompanyFrame(companyCode);
    }//GEN-LAST:event_editCompanyButtonActionPerformed

    private void editCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCompanyButtonMouseEntered
        hoverBackground(editCompanyButton, editNewCompanyLabel);
    }//GEN-LAST:event_editCompanyButtonMouseEntered

    private void editNewCompanyLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editNewCompanyLabelMouseExited
        noActiveBackground(editCompanyButton, editNewCompanyLabel);
    }//GEN-LAST:event_editNewCompanyLabelMouseExited

    private void closeCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeCompanyButtonActionPerformed

        closeCompany = new CloseCompanyDialog(mainFrame, true);
        closeCompany.setLocationRelativeTo(mainFrame);
        closeCompany.setVisible(true);
        if (closeCompany.getActionC() == 1) {
            featureFrame.resetAllActiveWindows();
            mainFrame.closeConnectionCompany();
            featureFrame.goWelcomeWindowAndKillItSelf();
        } else {
            closeCompany.setVisible(false);
            closeCompany.dispose();
        }

    }//GEN-LAST:event_closeCompanyButtonActionPerformed

    private void closeCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeCompanyButtonMouseEntered
        hoverBackground(closeCompanyButton, closeCompanyButtonLabel);

    }//GEN-LAST:event_closeCompanyButtonMouseEntered

    private void closeCompanyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeCompanyButtonMouseExited
        noActiveBackground(closeCompanyButton, closeCompanyButtonLabel);
    }//GEN-LAST:event_closeCompanyButtonMouseExited

    private void backupCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupCompanyButtonActionPerformed
        addBackupFrame();
    }//GEN-LAST:event_backupCompanyButtonActionPerformed

    private void backupCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupCompanyButtonMouseEntered
        hoverBackground(backupCompanyButton, backupCompanyLabel);
    }//GEN-LAST:event_backupCompanyButtonMouseEntered

    private void backupCompanyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupCompanyButtonMouseExited
        noActiveBackground(backupCompanyButton, backupCompanyLabel);
    }//GEN-LAST:event_backupCompanyButtonMouseExited

    private void restoreButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreButtonMouseEntered
        hoverBackground(restoreButton, restoreLabel);
    }//GEN-LAST:event_restoreButtonMouseEntered

    private void restoreButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreButtonMouseExited
        noActiveBackground(restoreButton, restoreLabel);
    }//GEN-LAST:event_restoreButtonMouseExited

    private void restoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreButtonActionPerformed
        addRestoreFrame();
    }//GEN-LAST:event_restoreButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backupCompanyButton;
    private javax.swing.JLabel backupCompanyLabel;
    private javax.swing.JButton closeCompanyButton;
    private javax.swing.JLabel closeCompanyButtonLabel;
    private javax.swing.JButton editCompanyButton;
    private javax.swing.JLabel editNewCompanyLabel;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton restoreButton;
    private javax.swing.JLabel restoreLabel;
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
        noActiveBackground(editCompanyButton, editNewCompanyLabel);
        noActiveBackground(closeCompanyButton, closeCompanyButtonLabel);
        noActiveBackground(backupCompanyButton, backupCompanyLabel);
        noActiveBackground(restoreButton, restoreLabel);
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getHoverMainButtonIcon());
        btn.setBorderPainted(false);
    }

    private void addModifyCompanyFrame(String companyCode) {
        createCompanyFrame  = new CreateCompanyFrame(mainFrame, null, true);
        createCompanyFrame.setLocationRelativeTo(mainFrame);
        createCompanyFrame.setOperationMode("modify",companyCode);
        createCompanyFrame.setVisible(true);
    }

    private void addBackupFrame() {
        backupDB = new BackupDB(mainFrame, true, companyCode);
        backupDB.setLocationRelativeTo(mainFrame);
        backupDB.setVisible(true);
    }

    private void addRestoreFrame() {
        restoreDB = new RestoreDB(mainFrame, true, companyCode);
        restoreDB.setLocationRelativeTo(mainFrame);
        restoreDB.setVisible(true);
    }

}
