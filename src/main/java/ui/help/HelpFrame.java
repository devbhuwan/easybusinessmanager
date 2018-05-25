package ui.help;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.feature.FeatureFrame;
import ui.help.about.AboutDialog;
import ui.images.ImageGet;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class HelpFrame extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private final MainFrame mainFrame;
    private final FeatureFrame featureFrame;
    private final String companyCode;
    private final Connection conn;
    private AboutDialog aboutDialog;

    /**
     * Creates new form WelcomeFrame
     *
     * @param mainFrame
     * @param featureFrame
     * @param companyCode
     * @param conn
     */
    public HelpFrame(MainFrame mainFrame, FeatureFrame featureFrame, String companyCode, Connection conn) {
        initComponents();
        addButtonOnLabel(helpContentButton, helpContentaddNewUserLabel);
//        addButtonOnLabel(shurtcutKeysButton, shurtcutKeysLabel);
//        addButtonOnLabel(reportIssuesButton, reportIssuesLabel);
        addButtonOnLabel(abountButton, aboutLabel);
        this.mainFrame = mainFrame;
        this.featureFrame = featureFrame;
        this.companyCode = companyCode;
        this.conn = conn;
        headerTitle.setText("Help & Support");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        helpContentButton = new javax.swing.JButton();
        abountButton = new javax.swing.JButton();
        subMenu = new javax.swing.JLayeredPane();
        helpContentaddNewUserLabel = new javax.swing.JLabel();
        shurtcutKeysLabel = new javax.swing.JLabel();
        reportIssuesLabel = new javax.swing.JLabel();
        aboutLabel = new javax.swing.JLabel();
        headerTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        helpContentButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        helpContentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/AlienAqua Help (Copy).png"))); // NOI18N
        helpContentButton.setText("Help Contents");
        helpContentButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        helpContentButton.setContentAreaFilled(false);
        helpContentButton.setFocusPainted(false);
        helpContentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpContentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        helpContentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helpContentButtonMouseEntered(evt);
            }
        });
        helpContentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpContentButtonActionPerformed(evt);
            }
        });

        abountButton.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        abountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/help.png"))); // NOI18N
        abountButton.setText("About");
        abountButton.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.light")));
        abountButton.setContentAreaFilled(false);
        abountButton.setFocusPainted(false);
        abountButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abountButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abountButtonMouseExited(evt);
            }
        });
        abountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abountButtonActionPerformed(evt);
            }
        });

        helpContentaddNewUserLabel.setPreferredSize(new java.awt.Dimension(200, 200));
        helpContentaddNewUserLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                helpContentaddNewUserLabelMouseExited(evt);
            }
        });

        shurtcutKeysLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        reportIssuesLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        aboutLabel.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout subMenuLayout = new javax.swing.GroupLayout(subMenu);
        subMenu.setLayout(subMenuLayout);
        subMenuLayout.setHorizontalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(reportIssuesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(helpContentaddNewUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(shurtcutKeysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        subMenuLayout.setVerticalGroup(
            subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(subMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(shurtcutKeysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subMenuLayout.createSequentialGroup()
                        .addComponent(helpContentaddNewUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(reportIssuesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        subMenu.setLayer(helpContentaddNewUserLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(shurtcutKeysLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(reportIssuesLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        subMenu.setLayer(aboutLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        headerTitle.setBackground(new java.awt.Color(0, 153, 51));
        headerTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        headerTitle.setForeground(new java.awt.Color(255, 255, 255));
        headerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerTitle.setOpaque(true);

        jLabel1.setBackground(new java.awt.Color(0, 153, 51));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(subMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void helpContentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpContentButtonActionPerformed
        addHelpContents();
    }//GEN-LAST:event_helpContentButtonActionPerformed

    private void helpContentButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpContentButtonMouseEntered
        hoverBackground(helpContentButton, helpContentaddNewUserLabel);
    }//GEN-LAST:event_helpContentButtonMouseEntered

    private void helpContentaddNewUserLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpContentaddNewUserLabelMouseExited
        noActiveBackground(helpContentButton, helpContentaddNewUserLabel);
    }//GEN-LAST:event_helpContentaddNewUserLabelMouseExited

    private void abountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abountButtonActionPerformed
        addAboutFrame();
    }//GEN-LAST:event_abountButtonActionPerformed

    private void abountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abountButtonMouseEntered
        hoverBackground(abountButton, aboutLabel);
    }//GEN-LAST:event_abountButtonMouseEntered

    private void abountButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abountButtonMouseExited
        noActiveBackground(abountButton, aboutLabel);
    }//GEN-LAST:event_abountButtonMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abountButton;
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JLabel headerTitle;
    private javax.swing.JButton helpContentButton;
    private javax.swing.JLabel helpContentaddNewUserLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel reportIssuesLabel;
    private javax.swing.JLabel shurtcutKeysLabel;
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
        noActiveBackground(helpContentButton, helpContentaddNewUserLabel);
//        noActiveBackground(shurtcutKeysButton, shurtcutKeysLabel);
//        noActiveBackground(reportIssuesButton, reportIssuesLabel);
        noActiveBackground(abountButton, aboutLabel);
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getHoverMainButtonIcon());
        btn.setBorderPainted(false);
    }

    private void addHelpContents() {
        String envDirectory = System.getenv("ProgramFiles");
        Path path = Paths.get(envDirectory + "/Business Manager/help/", "help.pdf");
        try {
            if (Files.exists(path)) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler "+path.toAbsolutePath());
                p.waitFor();

            } else {

                System.out.println("File is not exists");

            }

            System.out.println("Done");

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void setNullToAllWindows() {
    }

    private void addShurtcutKeysFrame() {

    }

    private void addReportIssues() {

    }

    private void addAboutFrame() {
        aboutDialog = new AboutDialog(mainFrame, true);
        aboutDialog.setLocationRelativeTo(mainFrame);
        aboutDialog.setBounds(aboutDialog.getLocation().x - 100, aboutDialog.getLocation().y + 53, 1015, 565);
        aboutDialog.setVisible(true);
    }
}
