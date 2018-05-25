
package ui.welcome;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.company.CreateCompanyFrame;
import ui.company.DeleteOpenCompanyFrame;
import ui.company.OpenCompanyFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class WelcomeFrame extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private CreateCompanyFrame createCompanyFrame;
    private final MainFrame mainFrame;
    private OpenCompanyFrame openCompanyFrame;
    private DeleteOpenCompanyFrame deleteOpenCompanyFrame;

    /**
     * Creates new form WelcomeFrame
     *
     * @param mainFrame
     */
    public WelcomeFrame(MainFrame mainFrame) {
        initComponents();
        addButtonOnLabel(createCompanyButton, createNewCompanyLabel);
        addButtonOnLabel(openCompanyButton, openCompanyLabel);
        addButtonOnLabel(deleteCompanyButton, deleteCompanyLabel);
        addButtonOnLabel(exitButton, exitButtonLabel);
        this.mainFrame = mainFrame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createCompanyButton = new javax.swing.JButton();
        openCompanyButton = new javax.swing.JButton();
        deleteCompanyButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        subMenu = new javax.swing.JLayeredPane();
        createNewCompanyLabel = new javax.swing.JLabel();
        openCompanyLabel = new javax.swing.JLabel();
        deleteCompanyLabel = new javax.swing.JLabel();
        exitButtonLabel = new javax.swing.JLabel();

        createCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        createCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/createCompany.png"))); // NOI18N
        createCompanyButton.setText("Create Company");
        createCompanyButton.setToolTipText("Register Your Company");
        createCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        createCompanyButton.setContentAreaFilled(false);
        createCompanyButton.setFocusPainted(false);
        createCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createCompanyButtonMouseEntered(evt);
            }
        });
        createCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCompanyButtonActionPerformed(evt);
            }
        });

        openCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        openCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/openCompany.png"))); // NOI18N
        openCompanyButton.setText("Open Company");
        openCompanyButton.setToolTipText("Open Your Registered Company");
        openCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        openCompanyButton.setContentAreaFilled(false);
        openCompanyButton.setFocusPainted(false);
        openCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                openCompanyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                openCompanyButtonMouseExited(evt);
            }
        });
        openCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCompanyButtonActionPerformed(evt);
            }
        });

        deleteCompanyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        deleteCompanyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/deleteCompany.png"))); // NOI18N
        deleteCompanyButton.setText("Delete Company");
        deleteCompanyButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        deleteCompanyButton.setContentAreaFilled(false);
        deleteCompanyButton.setFocusPainted(false);
        deleteCompanyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteCompanyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteCompanyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteCompanyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteCompanyButtonMouseExited(evt);
            }
        });
        deleteCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCompanyButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/exit.png"))); // NOI18N
        exitButton.setText("Exit");
        exitButton.setToolTipText("Exit Application");
        exitButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        createNewCompanyLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        createNewCompanyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createNewCompanyLabelMouseExited(evt);
            }
        });

        openCompanyLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        deleteCompanyLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        exitButtonLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout subMenuLayout = new javax.swing.GroupLayout(subMenu);
        subMenu.setLayout(subMenuLayout);
        subMenuLayout.setHorizontalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createNewCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        subMenuLayout.setVerticalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(openCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(exitButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(createNewCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(deleteCompanyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        subMenu.setLayer(createNewCompanyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(openCompanyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(deleteCompanyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(exitButtonLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCompanyButtonActionPerformed
        addCreateCompanyFrame();
    }//GEN-LAST:event_createCompanyButtonActionPerformed

    private void createCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createCompanyButtonMouseEntered
        hoverBackground(createCompanyButton, createNewCompanyLabel);
    }//GEN-LAST:event_createCompanyButtonMouseEntered

    private void createNewCompanyLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createNewCompanyLabelMouseExited
        noActiveBackground(createCompanyButton, createNewCompanyLabel);
    }//GEN-LAST:event_createNewCompanyLabelMouseExited

    private void openCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCompanyButtonActionPerformed
        addOpenCompanyFrame();
    }//GEN-LAST:event_openCompanyButtonActionPerformed

    private void openCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCompanyButtonMouseEntered
        hoverBackground(openCompanyButton, openCompanyLabel);
    }//GEN-LAST:event_openCompanyButtonMouseEntered

    private void openCompanyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openCompanyButtonMouseExited
        noActiveBackground(openCompanyButton, openCompanyLabel);
    }//GEN-LAST:event_openCompanyButtonMouseExited

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        mainFrame.loadExitPanel();
        noActiveBackground(exitButton, exitButtonLabel);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        hoverBackground(exitButton, exitButtonLabel);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        noActiveBackground(exitButton, exitButtonLabel);
    }//GEN-LAST:event_exitButtonMouseExited

    private void deleteCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCompanyButtonActionPerformed
        deleteCompanyFrame();
    }//GEN-LAST:event_deleteCompanyButtonActionPerformed

    private void deleteCompanyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCompanyButtonMouseExited
        noActiveBackground(deleteCompanyButton, deleteCompanyLabel);
    }//GEN-LAST:event_deleteCompanyButtonMouseExited

    private void deleteCompanyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCompanyButtonMouseEntered
        hoverBackground(deleteCompanyButton, deleteCompanyLabel);
    }//GEN-LAST:event_deleteCompanyButtonMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createCompanyButton;
    private javax.swing.JLabel createNewCompanyLabel;
    private javax.swing.JButton deleteCompanyButton;
    private javax.swing.JLabel deleteCompanyLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel exitButtonLabel;
    private javax.swing.JButton openCompanyButton;
    private javax.swing.JLabel openCompanyLabel;
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
        noActiveBackground(exitButton, exitButtonLabel);
        noActiveBackground(createCompanyButton, createNewCompanyLabel);
        noActiveBackground(openCompanyButton, openCompanyLabel);
        noActiveBackground(deleteCompanyButton, deleteCompanyLabel);
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getHoverMainButtonIcon());
        btn.setBorderPainted(false);
    }

    private void addCreateCompanyFrame() {
        createCompanyFrame = new CreateCompanyFrame(mainFrame, this, true);
        createCompanyFrame.setLocationRelativeTo(mainFrame);
        createCompanyFrame.setLocation(createCompanyFrame.getLocation().x, createCompanyFrame.getLocation().y + 50);
        createCompanyFrame.setVisible(true);
        noActiveBackground(createCompanyButton, createNewCompanyLabel);
    }

    private void addOpenCompanyFrame() {
        openCompanyFrame = new OpenCompanyFrame(mainFrame, true, this);
        openCompanyFrame.setLocationRelativeTo(mainFrame);
        openCompanyFrame.setLocation(openCompanyFrame.getLocation().x, openCompanyFrame.getLocation().y + 50);
        openCompanyFrame.setVisible(true);
        noActiveBackground(openCompanyButton, openCompanyLabel);
    }

    private void deleteCompanyFrame() {
        deleteOpenCompanyFrame = new DeleteOpenCompanyFrame(mainFrame, true, this);
        deleteOpenCompanyFrame.setLocationRelativeTo(mainFrame);
        deleteOpenCompanyFrame.setLocation(deleteOpenCompanyFrame.getLocation().x, deleteOpenCompanyFrame.getLocation().y + 50);
        deleteOpenCompanyFrame.setVisible(true);
        noActiveBackground(deleteCompanyButton, deleteCompanyLabel);
    }
}
