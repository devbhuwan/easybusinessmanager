package ui.feature;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import ui.company.CompanyFrame;
import ui.help.HelpFrame;
import ui.images.ImageGet;
import ui.main.MainFrame;
import ui.master.MasterFrame;
import ui.reports.ReportFrame;
import ui.setting.SettingFrame;
import ui.voucher.VoucherFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class FeatureFrame extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private final MainFrame mainFrame;
    private final String companyCode;
    private CompanyFrame companyFrame;
    private MasterFrame masterFrame;
    private VoucherFrame voucherFrame;
    private ReportFrame reportFrame;
    private final Connection conn;
    private SettingFrame settingFrame;
    private HelpFrame helpFrame;

    /**
     * Creates new form FeatureFrame
     *
     * @param mainFrame
     * @param companyCode
     */
    public FeatureFrame(MainFrame mainFrame, String companyCode) {
        initComponents();
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        addButtonOnLabel(companyButton, companyLabel);
        addButtonOnLabel(masterButton, masterLabel);
        addButtonOnLabel(voucherButton, voucherLabel);
        addButtonOnLabel(reportButton, reportLabel);
        addButtonOnLabel(settingButton, settingLabel);
        addButtonOnLabel(helpButton, helpLabel);
        companyCodeLabel.setText(companyCode);
        this.conn = mainFrame.getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        companyButton = new javax.swing.JButton();
        masterButton = new javax.swing.JButton();
        voucherButton = new javax.swing.JButton();
        reportButton = new javax.swing.JButton();
        settingButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        mainMenuPanel = new javax.swing.JLayeredPane();
        masterLabel = new javax.swing.JLabel();
        companyLabel = new javax.swing.JLabel();
        voucherLabel = new javax.swing.JLabel();
        reportLabel = new javax.swing.JLabel();
        settingLabel = new javax.swing.JLabel();
        helpLabel = new javax.swing.JLabel();
        bottom = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        companyCodeLabel = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();

        companyButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        companyButton.setText("      Company");
        companyButton.setBorder(null);
        companyButton.setBorderPainted(false);
        companyButton.setContentAreaFilled(false);
        companyButton.setFocusPainted(false);
        companyButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        companyButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        companyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyButtonActionPerformed(evt);
            }
        });
        companyButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                companyButtonFocusLost(evt);
            }
        });

        masterButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        masterButton.setText("      Master");
        masterButton.setBorder(null);
        masterButton.setBorderPainted(false);
        masterButton.setContentAreaFilled(false);
        masterButton.setFocusPainted(false);
        masterButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        masterButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        masterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterButtonActionPerformed(evt);
            }
        });
        masterButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                masterButtonFocusLost(evt);
            }
        });

        voucherButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        voucherButton.setText("      Voucher");
        voucherButton.setBorder(null);
        voucherButton.setBorderPainted(false);
        voucherButton.setContentAreaFilled(false);
        voucherButton.setFocusPainted(false);
        voucherButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        voucherButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        voucherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voucherButtonActionPerformed(evt);
            }
        });
        voucherButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                voucherButtonFocusLost(evt);
            }
        });

        reportButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        reportButton.setText("      Report");
        reportButton.setBorder(null);
        reportButton.setBorderPainted(false);
        reportButton.setContentAreaFilled(false);
        reportButton.setFocusPainted(false);
        reportButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });
        reportButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                reportButtonFocusLost(evt);
            }
        });

        settingButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        settingButton.setText("      Setting");
        settingButton.setBorder(null);
        settingButton.setBorderPainted(false);
        settingButton.setContentAreaFilled(false);
        settingButton.setFocusPainted(false);
        settingButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        settingButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });
        settingButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                settingButtonFocusLost(evt);
            }
        });

        helpButton.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        helpButton.setText("      Help");
        helpButton.setBorder(null);
        helpButton.setBorderPainted(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setFocusPainted(false);
        helpButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        helpButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });
        helpButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                helpButtonFocusLost(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        mainMenuPanel.setOpaque(true);

        masterLabel.setBackground(new java.awt.Color(255, 255, 255));

        companyLabel.setBackground(new java.awt.Color(255, 255, 255));

        voucherLabel.setBackground(new java.awt.Color(255, 255, 255));

        reportLabel.setBackground(new java.awt.Color(255, 255, 255));

        settingLabel.setBackground(new java.awt.Color(255, 255, 255));

        helpLabel.setBackground(new java.awt.Color(255, 255, 255));

        bottom.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        bottom.setOpaque(true);

        jLabel1.setOpaque(true);

        companyCodeLabel.setBackground(java.awt.SystemColor.activeCaption);
        companyCodeLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        companyCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        companyCodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        companyCodeLabel.setOpaque(true);

        javax.swing.GroupLayout mainMenuPanelLayout = new javax.swing.GroupLayout(mainMenuPanel);
        mainMenuPanel.setLayout(mainMenuPanelLayout);
        mainMenuPanelLayout.setHorizontalGroup(
            mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(voucherLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(settingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(helpLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reportLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(masterLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(companyCodeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(companyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainMenuPanelLayout.setVerticalGroup(
            mainMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuPanelLayout.createSequentialGroup()
                .addComponent(companyCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(companyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(masterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(voucherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(reportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(settingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(helpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        mainMenuPanel.setLayer(masterLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(companyLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(voucherLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(reportLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(settingLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(helpLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(bottom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainMenuPanel.setLayer(companyCodeLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        containerPanel.setPreferredSize(new java.awt.Dimension(719, 452));

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
            .addComponent(mainMenuPanel)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void companyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyButtonActionPerformed
        hideAllContentArea();
        companyCodeLabel.setBackground(new java.awt.Color(109, 25, 53));
        bottom.setBackground(new java.awt.Color(109, 25, 53));
        resetAllButtonActive();
        activeBackground(companyButton, companyLabel);
        if (companyFrame == null) {
            addCompanyFrame();
        } else {
            companyFrame.setVisible(true);
        }
    }//GEN-LAST:event_companyButtonActionPerformed

    private void companyButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_companyButtonFocusLost
        //noActiveBackground(companyButton, companyLabel);
    }//GEN-LAST:event_companyButtonFocusLost

    private void masterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterButtonActionPerformed
        hideAllContentArea();
        companyCodeLabel.setBackground(new java.awt.Color(255, 153, 0));
        bottom.setBackground(new java.awt.Color(255, 153, 0));
        resetAllButtonActive();
        activeBackground(masterButton, masterLabel);
        if (masterFrame == null) {
            addMasterFrame();
        } else {
            masterFrame.setVisible(true);
        }
    }//GEN-LAST:event_masterButtonActionPerformed

    private void masterButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_masterButtonFocusLost
       // noActiveBackground(masterButton, masterLabel);
    }//GEN-LAST:event_masterButtonFocusLost

    private void voucherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voucherButtonActionPerformed
        hideAllContentArea();
        companyCodeLabel.setBackground(new java.awt.Color(0, 0, 255));
        bottom.setBackground(new java.awt.Color(0, 0, 255));
        resetAllButtonActive();
        activeBackground(voucherButton, voucherLabel);
        if (voucherFrame == null) {
            addVoucherFrame();
        } else {
            voucherFrame.setVisible(true);
        }
    }//GEN-LAST:event_voucherButtonActionPerformed

    private void voucherButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_voucherButtonFocusLost
        //noActiveBackground(voucherButton, voucherLabel);
    }//GEN-LAST:event_voucherButtonFocusLost

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        hideAllContentArea();
        resetAllButtonActive();
        activeBackground(reportButton, reportLabel);
        companyCodeLabel.setBackground(new java.awt.Color(0, 102, 102));
        bottom.setBackground(new java.awt.Color(0, 102, 102));
        if (reportFrame == null) {
            addReportFrame();
        } else {
            reportFrame.setVisible(true);
        }
    }//GEN-LAST:event_reportButtonActionPerformed

    private void reportButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reportButtonFocusLost
       // noActiveBackground(reportButton, reportLabel);
    }//GEN-LAST:event_reportButtonFocusLost

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingButtonActionPerformed
        hideAllContentArea();
        hideAllContentArea();
        resetAllButtonActive();
        activeBackground(settingButton, settingLabel);
        companyCodeLabel.setBackground(new java.awt.Color(102,102,102));
        bottom.setBackground(new java.awt.Color(102,102,102));
        if (settingFrame == null) {
            addSettingFrame();
        } else {
            settingFrame.setVisible(true);
        }

    }//GEN-LAST:event_settingButtonActionPerformed

    private void settingButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_settingButtonFocusLost
       // noActiveBackground(settingButton, settingLabel);
    }//GEN-LAST:event_settingButtonFocusLost

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        hideAllContentArea();
        hideAllContentArea();
        resetAllButtonActive();
        activeBackground(helpButton, helpLabel);
        companyCodeLabel.setBackground(new java.awt.Color(0,153,51));
        bottom.setBackground(new java.awt.Color(0,153,51));
        if (helpFrame == null) {
            addHelpFrame();
        } else {
            helpFrame.setVisible(true);
        }
    }//GEN-LAST:event_helpButtonActionPerformed

    private void helpButtonFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_helpButtonFocusLost
      //  noActiveBackground(helpButton, helpLabel);
    }//GEN-LAST:event_helpButtonFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bottom;
    private javax.swing.JButton companyButton;
    private javax.swing.JLabel companyCodeLabel;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane mainMenuPanel;
    private javax.swing.JButton masterButton;
    private javax.swing.JLabel masterLabel;
    private javax.swing.JButton reportButton;
    private javax.swing.JLabel reportLabel;
    private javax.swing.JButton settingButton;
    private javax.swing.JLabel settingLabel;
    private javax.swing.JButton voucherButton;
    private javax.swing.JLabel voucherLabel;
    // End of variables declaration//GEN-END:variables

    private void addButtonOnLabel(JButton btn, JLabel label) {
        label.add(btn);
        btn.setBounds(0, 0, 146, 40);
        btn.setForeground(Color.black);
        btn.setVisible(true);
    }

    private void activeBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.white);
        label.setIcon(imageGet.getActiveButtonIcon());
    }

    private void noActiveBackground(JButton btn, JLabel label) {
        btn.setForeground(Color.black);
        label.setIcon(null);
    }

    public void hideAllContentArea() {
        if (companyFrame != null) {
            companyFrame.setVisible(false);
        }
        if (masterFrame != null) {
            masterFrame.setVisible(false);
        }
        if (voucherFrame != null) {
            voucherFrame.setVisible(false);
        }
        if (reportFrame != null) {
            reportFrame.setVisible(false);
        }
        if (settingFrame != null) {
            settingFrame.setVisible(false);
        }
        if (helpFrame != null) {
            helpFrame.setVisible(false);
        }
    }

    private void addCompanyFrame() {
        companyFrame = new CompanyFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(companyFrame);
        companyFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        companyFrame.setVisible(true);
    }

    private void addMasterFrame() {
        masterFrame = new MasterFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(masterFrame);
        masterFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        masterFrame.setVisible(true);
    }

    private void addVoucherFrame() {
        voucherFrame = new VoucherFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(voucherFrame);
        voucherFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        voucherFrame.setVisible(true);
    }

    private void addReportFrame() {
        reportFrame = new ReportFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(reportFrame);
        reportFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        reportFrame.setVisible(true);
    }

    private void addSettingFrame() {
        settingFrame = new SettingFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(settingFrame);
        settingFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        settingFrame.setVisible(true);
    }

    private void addHelpFrame() {
        helpFrame = new HelpFrame(mainFrame, this, companyCode, conn);
        containerPanel.add(helpFrame);
        helpFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        helpFrame.setVisible(true);
    }

    public void resetAllActiveWindows() {
        if (masterFrame != null) {
            masterFrame.setNullToAllWindows();
        }
        if (voucherFrame != null) {
            voucherFrame.setNullToAllWindows();
        }
        if (reportFrame != null) {
            reportFrame.setNullToAllWindows();
        }
        if (settingFrame != null) {
            settingFrame.setNullToAllWindows();
        }
        if (helpFrame != null) {
            helpFrame.setNullToAllWindows();
        }
    }

    public void closeDatabaseConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(FeatureFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void goWelcomeWindowAndKillItSelf() {
        mainFrame.resetAllFeatureForOpenedCompany();
    }

    public void resetAllButtonActive() {
        noActiveBackground(companyButton, companyLabel);
        noActiveBackground(masterButton, masterLabel);
        noActiveBackground(voucherButton, voucherLabel);
        noActiveBackground(reportButton, reportLabel);
        noActiveBackground(settingButton, settingLabel);
        noActiveBackground(helpButton, helpLabel);
    }

}
