package ui.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdesktop.beansbinding.AbstractBindingListener;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.PropertyStateEvent;
import ui.images.ImageGet;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class CompanyDetail extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private File logoFile;
    private ImageIcon image;

    /**
     * Creates new form CompanyDetail
     *
     */
    public CompanyDetail() {
        initComponents();
        financialYearFrom.setFormat(1);
        booksBeginDate.setFormat(1);
        logo.setIcon(imageGet.getDefaultCompanyLogo());
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setIcon(null);
                errorMessage.setText(null);
                if (!nameTF.getText().isEmpty()) {
                    addAcceptIcon(nameTF, a1);
                } else {
                    addRejectIcon(nameTF, a1);
                }
                if (phoneNumberTF.getText().isEmpty()) {
                    a2.setVisible(false);
                } else if (phoneNumberTF.getText().matches("[0-9]*") && phoneNumberTF.getText().length() <= 20) {
                    addAcceptIcon(phoneNumberTF, a2);
                } else {
                    addRejectIcon(phoneNumberTF, a2);
                }
                if (faxNumberTF.getText().isEmpty()) {
                    a3.setVisible(false);
                } else if (faxNumberTF.getText().matches("[0-9]*") && faxNumberTF.getText().length() <= 20) {
                    addAcceptIcon(faxNumberTF, a3);
                } else {
                    addRejectIcon(faxNumberTF, a3);
                }
                if (emailAddressTF.getText().isEmpty()) {
                    a4.setVisible(false);
                } else if (emailAddressTF.getText().matches(".+@.+\\.[A-Za-z]+")) {
                    addAcceptIcon(emailAddressTF, a4);
                } else {
                    addRejectIcon(emailAddressTF, a4);
                }
                if (websiteUrlTF.getText().isEmpty()) {
                    a5.setVisible(false);
                } else if (websiteUrlTF.getText().matches("www+\\.+\\w+\\.+[a-z]*")) {
                    addAcceptIcon(websiteUrlTF, a5);
                } else {
                    addRejectIcon(websiteUrlTF, a5);
                }
            }

        });
    }

    private void addRejectIcon(JTextField f, JLabel l) {
        f.add(l);
        l.setIcon(imageGet.getRejectIcon());
        l.setBounds(f.getWidth() - 26, 2, 24, 22);
        l.setVisible(true);
        
    }

    private void addAcceptIcon(JTextField f, JLabel l) {
        f.add(l);
        l.setIcon(imageGet.getAcceptIcon());
        l.setBounds(f.getWidth() - 26, 2, 24, 22);
        l.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        companyLogoChooser = new javax.swing.JFileChooser();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        phoneNumberTF = new javax.swing.JTextField();
        faxNumberTF = new javax.swing.JTextField();
        emailAddressTF = new javax.swing.JTextField();
        websiteUrlTF = new javax.swing.JTextField();
        businessTypeCB = new javax.swing.JComboBox();
        financialYearFrom = new datechooser.beans.DateChooserCombo();
        booksBeginDate = new datechooser.beans.DateChooserCombo();
        companyLogo = new javax.swing.JLayeredPane();
        logoHeader = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        companyLogoChooser.setFileFilter(new ImageFileFiter());

        a1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        a1.setForeground(new java.awt.Color(204, 0, 0));
        a1.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        a1.setIconTextGap(10);

        a2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        a2.setForeground(new java.awt.Color(204, 0, 0));
        a2.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        a2.setIconTextGap(10);

        a3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        a3.setForeground(new java.awt.Color(204, 0, 0));
        a3.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        a3.setIconTextGap(10);

        a4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        a4.setForeground(new java.awt.Color(204, 0, 0));
        a4.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        a4.setIconTextGap(10);

        a5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        a5.setForeground(new java.awt.Color(204, 0, 0));
        a5.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        a5.setIconTextGap(10);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")), "Company Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Company Name :");

        nameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${text}"), nameTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Address :");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Phone Number :");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Fax Number :");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Email Address :");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Website URL :");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Financial Year From :");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("Books Begin Date :");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Business Type :");

        addressTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), addressTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        phoneNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a2, org.jdesktop.beansbinding.ELProperty.create("${text}"), phoneNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        faxNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a3, org.jdesktop.beansbinding.ELProperty.create("${text}"), faxNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        emailAddressTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a4, org.jdesktop.beansbinding.ELProperty.create("${text}"), emailAddressTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        websiteUrlTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a5, org.jdesktop.beansbinding.ELProperty.create("${text}"), websiteUrlTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        businessTypeCB.setBackground(java.awt.SystemColor.activeCaption);
        businessTypeCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        businessTypeCB.setMaximumRowCount(19);
        businessTypeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Accountant", "Architect", "Auto Repair Service", "Boutique", "Child Care", "Cleaning Service", "Construction", "Consulting With No Employees", "Retail", "Web Based Sales", "Shipping and Postal Services", "Restaurant", "Real State Agent", "Property Management", "Photographer", "Pet Care", "Personal Instructor", "IT Services", "Others" }));
        businessTypeCB.setSelectedIndex(-1);
        businessTypeCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), businessTypeCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        financialYearFrom.setCalendarBackground(new java.awt.Color(255, 255, 255));
        financialYearFrom.setNothingAllowed(false);
        financialYearFrom.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 12));
        financialYearFrom.setNavigateFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 12));

        booksBeginDate.setCalendarBackground(new java.awt.Color(255, 255, 255));
        booksBeginDate.setNothingAllowed(false);
        booksBeginDate.setFieldFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 12));
        booksBeginDate.setNavigateFont(new java.awt.Font("Trebuchet MS", java.awt.Font.PLAIN, 12));

        companyLogo.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));

        logoHeader.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        logoHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoHeader.setText("Company Logo");
        logoHeader.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));
        logoHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout companyLogoLayout = new javax.swing.GroupLayout(companyLogo);
        companyLogo.setLayout(companyLogoLayout);
        companyLogoLayout.setHorizontalGroup(
            companyLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        companyLogoLayout.setVerticalGroup(
            companyLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyLogoLayout.createSequentialGroup()
                .addComponent(logoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        companyLogo.setLayer(logoHeader, javax.swing.JLayeredPane.DEFAULT_LAYER);
        companyLogo.setLayer(logo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        uploadButton.setBackground(new java.awt.Color(255, 255, 255));
        uploadButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        uploadButton.setText("Upload");
        uploadButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        errorMessage.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        errorMessage.setForeground(new java.awt.Color(204, 0, 0));
        errorMessage.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        errorMessage.setIconTextGap(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(businessTypeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(nameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(booksBeginDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(financialYearFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(websiteUrlTF, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(faxNumberTF, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(phoneNumberTF, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addComponent(emailAddressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(companyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addressTF, businessTypeCB, emailAddressTF, faxNumberTF, nameTF, phoneNumberTF, websiteUrlTF});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(websiteUrlTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(financialYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(booksBeginDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(businessTypeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(companyLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, nameTF});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {booksBeginDate, businessTypeCB, emailAddressTF, faxNumberTF, financialYearFrom, phoneNumberTF, uploadButton, websiteUrlTF});

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        int returnVal = companyLogoChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            logoFile = companyLogoChooser.getSelectedFile();
            if (logoFile.toString().endsWith(".png") || logoFile.toString().endsWith(".jpg")) {
                image = new ImageIcon(logoFile.getAbsolutePath());
                logo.setIcon(imageGet.resizeimage(image));
            } else {
                logo.setIcon(imageGet.getDefaultCompanyLogo());
                logoFile = imageGet.getDefaultCompanyLogoFile();
            }
        } else {
            logo.setIcon(imageGet.getDefaultCompanyLogo());
            logoFile = imageGet.getDefaultCompanyLogoFile();
        }
    }//GEN-LAST:event_uploadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JTextField addressTF;
    private datechooser.beans.DateChooserCombo booksBeginDate;
    private javax.swing.JComboBox businessTypeCB;
    private javax.swing.JLayeredPane companyLogo;
    private javax.swing.JFileChooser companyLogoChooser;
    private javax.swing.JTextField emailAddressTF;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField faxNumberTF;
    private datechooser.beans.DateChooserCombo financialYearFrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoHeader;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField phoneNumberTF;
    private javax.swing.JButton uploadButton;
    private javax.swing.JTextField websiteUrlTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    String getCName() {
        return nameTF.getText();
    }

    String getAddress() {
        return addressTF.getText();
    }

    String getPhoneNumber() {
        return phoneNumberTF.getText();
    }

    String getFaxNumber() {
        return faxNumberTF.getText();
    }

    String getEmail() {
        return emailAddressTF.getText();
    }

    Timestamp getFinancialDate() {
        Calendar cal = financialYearFrom.getSelectedDate();
        Date date = cal.getTime();
        return new Timestamp(date.getTime());
    }

    Timestamp getBookBeginDate() {
        Calendar cal = booksBeginDate.getSelectedDate();
        Date date = cal.getTime();
        return new Timestamp(date.getTime());
    }

    String getWebsite() {
        return websiteUrlTF.getText();
    }

    String getBusinessType() {
        return businessTypeCB.getSelectedItem().toString();
    }

    int getLength() {
        if (logoFile != null) {
            return (int) logoFile.length();
        } else {
            return 0;
        }

    }

    InputStream getLogoFileStream() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(imageGet.getDefaultCompanyLogoFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompanyDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (logoFile != null) {
                fileInputStream = new FileInputStream(logoFile);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return fileInputStream;
    }

    ImageIcon getCompanyLogo() {
        return (ImageIcon) logo.getIcon();
    }

    boolean isValidation() {
        boolean status = false;
        if (!nameTF.getText().isEmpty()) {
            if (businessTypeCB.getSelectedIndex() > -1) {
                status = true;
            } else {
                errorMessage.setIcon(imageGet.getAlertIcon());
                errorMessage.setText("!!! Please, select to the business type. !!!");
                businessTypeCB.requestFocusInWindow();
            }
        } else {
            errorMessage.setIcon(imageGet.getAlertIcon());
            errorMessage.setText("!!! Please, enter the company name. !!!");
            nameTF.requestFocusInWindow();
        }
        return status;
    }

    void setInformation(String cN, String add, String ph, String fax, String email, String web, Date finan, Date book, String businessT, byte[] logoStream) {
        nameTF.setText(cN);
        addressTF.setText(add);
        phoneNumberTF.setText(add);
        faxNumberTF.setText(add);
        emailAddressTF.setText(add);
        websiteUrlTF.setText(add);
        Calendar c = Calendar.getInstance();
        c.setTime(finan);
        financialYearFrom.setSelectedDate(c);
        Calendar c1 = Calendar.getInstance();
        c1.setTime(book);
        booksBeginDate.setSelectedDate(c1);
        businessTypeCB.setSelectedItem(businessT);
        logo.setIcon(new ImageIcon(logoStream));
    }


}
