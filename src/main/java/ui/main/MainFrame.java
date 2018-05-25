package ui.main;

import dbutils.CreateConnectionAccess;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.feature.FeatureFrame;
import ui.images.ImageGet;
import ui.welcome.WelcomeFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class MainFrame extends javax.swing.JFrame {

    private WelcomeFrame welcomeFrame;
    private ExitDialog exitDialog;
    private FeatureFrame featureFrame;
    private Connection c1;
    private Connection c2;
    private Connection c3;
    private Connection c4;
    private Connection cExtra;
    private final Connection tempConn;
    private boolean show = true;
    private String dbDir;

    /**
     * Creates new form MainFrame
     *
     * @param tempConn
     */
    public MainFrame(Connection tempConn) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        looksAndFeel();
        initComponents();
        this.tempConn = tempConn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        twitterButton = new javax.swing.JButton();
        faceBookButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        containerScrollPane = new javax.swing.JScrollPane();
        containerPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Business Manager (Standard Edition) v1.0.0");
        setIconImage(new ImageGet().getBuzLogo().getImage());
        setMinimumSize(new java.awt.Dimension(800, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        headerPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));

        twitterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/twitter.png"))); // NOI18N
        twitterButton.setBorder(null);
        twitterButton.setBorderPainted(false);
        twitterButton.setContentAreaFilled(false);
        twitterButton.setFocusPainted(false);
        twitterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                twitterButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                twitterButtonMouseExited(evt);
            }
        });

        faceBookButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        faceBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/facebook.png"))); // NOI18N
        faceBookButton.setBorder(null);
        faceBookButton.setBorderPainted(false);
        faceBookButton.setContentAreaFilled(false);
        faceBookButton.setFocusPainted(false);
        faceBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                faceBookButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                faceBookButtonMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/logo (Copy).png"))); // NOI18N
        jLabel4.setText("Business Manager");

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 2, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("(version 1.0)");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(faceBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(twitterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(twitterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
            .addComponent(faceBookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerScrollPane.setBorder(null);
        containerScrollPane.setPreferredSize(new Dimension(
            this.getWidth(),this.getHeight()-62));

    containerPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentResized(java.awt.event.ComponentEvent evt) {
            containerPanelComponentResized(evt);
        }
    });

    javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
    containerPanel.setLayout(containerPanelLayout);
    containerPanelLayout.setHorizontalGroup(
        containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1000, Short.MAX_VALUE)
    );
    containerPanelLayout.setVerticalGroup(
        containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 521, Short.MAX_VALUE)
    );

    containerScrollPane.setViewportView(containerPanel);

    jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 1000, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 2, Short.MAX_VALUE)
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(containerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(containerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
            .addGap(0, 0, 0)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void containerPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_containerPanelComponentResized
        if (show) {
            welcomeFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
            welcomeFrame.setVisible(true);
            show = false;
        }
    }//GEN-LAST:event_containerPanelComponentResized

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.loadExitPanel();
    }//GEN-LAST:event_formWindowClosing

    private void faceBookButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faceBookButtonMouseEntered
        faceBookButton.setOpaque(true);
        faceBookButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
    }//GEN-LAST:event_faceBookButtonMouseEntered

    private void faceBookButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_faceBookButtonMouseExited
        faceBookButton.setOpaque(false);
    }//GEN-LAST:event_faceBookButtonMouseExited

    private void twitterButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twitterButtonMouseEntered
        twitterButton.setOpaque(true);
        twitterButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
    }//GEN-LAST:event_twitterButtonMouseEntered

    private void twitterButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twitterButtonMouseExited
        twitterButton.setOpaque(false);
    }//GEN-LAST:event_twitterButtonMouseExited

    private void looksAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerPanel;
    private javax.swing.JScrollPane containerScrollPane;
    private javax.swing.JButton faceBookButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton twitterButton;
    // End of variables declaration//GEN-END:variables

    public void loadExitPanel() {
        exitDialog = new ExitDialog(this, true);
        exitDialog.setLocationRelativeTo(this);
        exitDialog.setVisible(true);
    }

    public void loadAllFeatureForOpenedCompany(String companyCode) {
        featureFrame = new FeatureFrame(this, companyCode);
        containerPanel.add(featureFrame);
        featureFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        featureFrame.setVisible(true);
    }

    public void resetAllFeatureForOpenedCompany() {
        featureFrame.setVisible(false);
        featureFrame = null;
        welcomeFrame.setVisible(true);
    }

    public Connection getConnection() {
        return c1;
    }

    public Connection getConnection2() {
        return c2;
    }

    public Connection getConnection3() {
        return c3;
    }

    public Connection getConnection4() {
        return c4;
    }

    public void setWelcomeFrame() {
        welcomeFrame = new WelcomeFrame(this);
        containerPanel.add(welcomeFrame);
        welcomeFrame.setBounds(0, 0, containerPanel.getWidth(), containerPanel.getHeight());
        welcomeFrame.setVisible(true);
        this.setVisible(true);
    }

    public void setFeatures(String string, String string0) {

    }

    public Connection getConnection5() {
        return tempConn;
    }

    public void setConnections(String companyCode) {
        this.dbDir = getDBDir(companyCode);
        if (dbDir != null) {
            this.c1 = new CreateConnectionAccess().getConnection(dbDir);
            this.c2 = new CreateConnectionAccess().getConnection(dbDir);
            this.c3 = new CreateConnectionAccess().getConnection(dbDir);
            this.c4 = new CreateConnectionAccess().getConnection(dbDir);
            this.cExtra = new CreateConnectionAccess().getConnection(dbDir);
        } else {
            JOptionPane.showMessageDialog(this, "Database file is corrupted.", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    private String getDBDir(String companyCode) {
        String dbDirector = null;
        try {
            tempConn.setAutoCommit(false);
            String sql = "select companyDBPath from COMPANY_INFO where companyCode = ?";
            PreparedStatement ps = tempConn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dbDirector = rs.getString("companyDBPath");
            }
            tempConn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbDirector;
    }

    public void closeConnection() {
        if (tempConn != null) {
            try {
                tempConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void closeConnectionCompany() {
        try {
            if (c1 != null) {
                c1.close();
            }
            if (c2 != null) {
                c2.close();
            }
            if (c3 != null) {
                c3.close();
            }
            if (c4 != null) {
                c4.close();
            }
            if(cExtra != null) {
                cExtra.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getDBDir() {
        return dbDir;
    }

    public Connection getConnectionExtra() {
        return cExtra;
    }
}
