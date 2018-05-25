package ui.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ui.main.MainFrame;
import ui.welcome.WelcomeFrame;

/**
 *
 * @author Bhuwan
 */
public class CreateCompanyFrame extends javax.swing.JDialog {

    private final MainFrame mainFrame;
    private CompanyDetail cDetail;
    private ContactPersonDetail cpDetail;
    private SecurityDetail sDetail;
    private final CompanyDBUtils companyDBUtils;
    private CompanyInformation companyInformation;
    private final WelcomeFrame wf;
    private String operation;
    private String companyCode;

    /**
     * Creates new form WelcomeFrame
     *
     * @param parent
     * @param wf
     * @param modal
     */
    public CreateCompanyFrame(MainFrame parent, WelcomeFrame wf, boolean modal) {
        super(parent, modal);
        this.mainFrame = parent;
        this.wf = wf;
        this.companyDBUtils = new CompanyDBUtils(mainFrame);
        initComponents();
        this.setTitle("Company Creation");
        backButton.setEnabled(false);
        finishButton.setEnabled(false);
        addPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sep = new javax.swing.JSeparator();
        header = new javax.swing.JLabel();
        controlPane = new javax.swing.JLayeredPane();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        contentPane = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        header.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        header.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Create New Company");
        header.setOpaque(true);

        controlPane.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        controlPane.setOpaque(true);

        backButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground")));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        nextButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nextButton.setText("Next");
        nextButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground")));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        finishButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        finishButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        finishButton.setText("Finish");
        finishButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground")));
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground")));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPaneLayout = new javax.swing.GroupLayout(controlPane);
        controlPane.setLayout(controlPaneLayout);
        controlPaneLayout.setHorizontalGroup(
            controlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        controlPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, cancelButton, finishButton, nextButton});

        controlPaneLayout.setVerticalGroup(
            controlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(finishButton)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        controlPaneLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, cancelButton, finishButton, nextButton});

        controlPane.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        controlPane.setLayer(nextButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        controlPane.setLayer(finishButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        controlPane.setLayer(cancelButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        contentPane.setBackground(new java.awt.Color(255, 255, 255));
        contentPane.setOpaque(true);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(controlPane)
            .addComponent(contentPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPane)
                .addGap(0, 0, 0)
                .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(controlPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeFrame();
    }//GEN-LAST:event_formWindowClosing

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        closeFrame();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (cpDetail.isVisible()) {
            cpDetail.setVisible(false);
            cDetail.setVisible(true);
            backButton.setEnabled(false);
        } else if (sDetail.isVisible()) {
            sDetail.setVisible(false);
            cpDetail.setVisible(true);
            finishButton.setEnabled(false);
            nextButton.setEnabled(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (cDetail.isVisible() && cDetail.isValidation()) {
            cDetail.setVisible(false);
            cpDetail.setVisible(true);
            backButton.setEnabled(true);
        } else if (cpDetail.isVisible() && cpDetail.isValidation()) {
            cpDetail.setVisible(false);
            sDetail.setVisible(true);
            nextButton.setEnabled(false);
            finishButton.setEnabled(true);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        if (sDetail.isVisible() && sDetail.isValidation()) {
            if (operation != null) {
                if (operation.equalsIgnoreCase("Modify")) {
                    if (companyDBUtils.updateCompanyInformation(cDetail, cpDetail, sDetail, companyCode, mainFrame.getConnection())) {
                        sDetail.setVisible(false);
                        header.setText("Welcome");
                        backButton.setVisible(false);
                        nextButton.setVisible(false);
                        finishButton.setVisible(false);
                        cancelButton.setText(" Exit ");
                        companyInformation = new CompanyInformation(cDetail, cpDetail, sDetail);
                        contentPane.add(companyInformation);
                        companyInformation.setBounds(180, 26, 541, 374);
                        companyInformation.setVisible(true);
                    }
                }
            } else {
                if (companyDBUtils.saveCompanyInformation(cDetail, cpDetail, sDetail)) {
                    sDetail.setVisible(false);
                    header.setText("Welcome");
                    backButton.setVisible(false);
                    nextButton.setVisible(false);
                    finishButton.setVisible(false);
                    cancelButton.setText(" Exit ");
                    companyInformation = new CompanyInformation(cDetail, cpDetail, sDetail);
                    contentPane.add(companyInformation);
                    companyInformation.setBounds(180, 26, 541, 374);
                    companyInformation.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_finishButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLayeredPane contentPane;
    private javax.swing.JLayeredPane controlPane;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel header;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JSeparator sep;
    // End of variables declaration//GEN-END:variables

    private void addPanel() {
        cDetail = new CompanyDetail();
        contentPane.add(cDetail);
        cDetail.setBounds(64, 36, 774, 380);
        cDetail.setVisible(true);
        cpDetail = new ContactPersonDetail();
        contentPane.add(cpDetail);
        cpDetail.setBounds(78, 60, 746, 307);
        cpDetail.setVisible(false);
        sDetail = new SecurityDetail();
        contentPane.add(sDetail);
        sDetail.setBounds(158, 118, 585, 191);
        sDetail.setVisible(false);
    }

    private void closeFrame() {
        this.dispose();
    }

    void setOperationMode(String operation, String companyCode) {
        this.operation = operation;
        if (operation.equalsIgnoreCase("modify")) {
            this.companyCode = companyCode;
            fetchInformation();
            this.setTitle("Modify Company");
            header.setText("Modify Company");
        }

    }

    private void fetchInformation() {
        String sql = "SELECT * FROM COMPANY_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cDetail.setInformation(rs.getString("companyName"), rs.getString("companyAddress"), rs.getString("companyPhNo"), rs.getString("companyFaxNo"), rs.getString("companyEmail"), rs.getString("companyWebsite"), rs.getDate("financialYearFrom"), rs.getDate("booksBeginDate"), rs.getString("businessType"), rs.getBytes("companyLogo"));
                cpDetail.setInformation(rs.getString("cpName"), rs.getString("cpAddress"), rs.getString("cpPhNo"), rs.getString("cpFaxNo"), rs.getString("cpEmail"), rs.getString("cpWebsite"), rs.getString("cpRole"), rs.getBytes("cpPhoto"));
                sDetail.setInformation(rs.getString("userCode"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
