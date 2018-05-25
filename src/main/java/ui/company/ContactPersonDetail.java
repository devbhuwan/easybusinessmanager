package ui.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
 * @version 1.0.0
 */
public class ContactPersonDetail extends javax.swing.JPanel {

    private final ImageGet imageGet = new ImageGet();
    private File cpPhotoFile;
    private ImageIcon image;

    /**
     * Creates new form CompanyDetail
     *
     */
    public ContactPersonDetail() {
        initComponents();
        contactPersonPhoto.setIcon(imageGet.getDefaultUserPhoto());
        bindingGroup.addBindingListener(new AbstractBindingListener() {

            @Override
            public void targetChanged(Binding binding, PropertyStateEvent event) {
                super.targetChanged(binding, event);
                errorMessage.setText(null);
                errorMessage.setIcon(null);
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

        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        contactPersonPhotoChooserChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addressTF = new javax.swing.JTextField();
        phoneNumberTF = new javax.swing.JTextField();
        faxNumberTF = new javax.swing.JTextField();
        emailAddressTF = new javax.swing.JTextField();
        websiteUrlTF = new javax.swing.JTextField();
        cpRoleCB = new javax.swing.JComboBox();
        contactPersonImage = new javax.swing.JLayeredPane();
        logoHeader = new javax.swing.JLabel();
        contactPersonPhoto = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        errorMessage = new javax.swing.JLabel();

        a1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        a1.setForeground(new java.awt.Color(51, 51, 51));

        a2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        a2.setForeground(new java.awt.Color(51, 51, 51));

        a3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        a3.setForeground(new java.awt.Color(51, 51, 51));

        a4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        a4.setForeground(new java.awt.Color(51, 51, 51));

        a5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        a5.setForeground(new java.awt.Color(51, 51, 51));

        contactPersonPhotoChooserChooser.setFileFilter(new ImageFileFiter());

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Person Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("CP Name :");

        nameTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${text}"), nameTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nameTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTFFocusLost(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("CP Role :");

        addressTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), addressTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        phoneNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), phoneNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        faxNumberTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a2, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), faxNumberTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        emailAddressTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a3, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), emailAddressTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        websiteUrlTF.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a4, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), websiteUrlTF, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        cpRoleCB.setBackground(java.awt.SystemColor.activeCaption);
        cpRoleCB.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        cpRoleCB.setMaximumRowCount(19);
        cpRoleCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Director", "Manager", "Other", "Owner", "Partner", "Propriter" }));
        cpRoleCB.setSelectedIndex(-1);
        cpRoleCB.setBorder(null);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, a1, org.jdesktop.beansbinding.ELProperty.create("${labelFor.foreground}"), cpRoleCB, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        cpRoleCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cpRoleCBFocusLost(evt);
            }
        });

        contactPersonImage.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));

        logoHeader.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        logoHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoHeader.setText("Cp Photo");
        logoHeader.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background")));
        logoHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout contactPersonImageLayout = new javax.swing.GroupLayout(contactPersonImage);
        contactPersonImage.setLayout(contactPersonImageLayout);
        contactPersonImageLayout.setHorizontalGroup(
            contactPersonImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contactPersonPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        contactPersonImageLayout.setVerticalGroup(
            contactPersonImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contactPersonImageLayout.createSequentialGroup()
                .addComponent(logoHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contactPersonPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        contactPersonImage.setLayer(logoHeader, javax.swing.JLayeredPane.DEFAULT_LAYER);
        contactPersonImage.setLayer(contactPersonPhoto, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpRoleCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(websiteUrlTF, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(faxNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contactPersonImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addressTF, cpRoleCB, emailAddressTF, faxNumberTF, nameTF, phoneNumberTF, websiteUrlTF});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(phoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(websiteUrlTF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contactPersonImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpRoleCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel9, nameTF});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cpRoleCB, emailAddressTF, faxNumberTF, phoneNumberTF, websiteUrlTF});

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void nameTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTFFocusLost

    }//GEN-LAST:event_nameTFFocusLost

    private void cpRoleCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cpRoleCBFocusLost

    }//GEN-LAST:event_cpRoleCBFocusLost

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        int returnVal = contactPersonPhotoChooserChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            cpPhotoFile = contactPersonPhotoChooserChooser.getSelectedFile();
            if (cpPhotoFile.toString().endsWith(".png") || cpPhotoFile.toString().endsWith(".jpg")) {
                image = new ImageIcon(cpPhotoFile.getAbsolutePath());
                contactPersonPhoto.setIcon(imageGet.resizeimage(image));
            } else {
                contactPersonPhoto.setIcon(imageGet.getDefaultUserPhoto());
                cpPhotoFile = imageGet.getDefaultUserPhotoFile();
            }

        } else {
            contactPersonPhoto.setIcon(imageGet.getDefaultUserPhoto());
            cpPhotoFile = imageGet.getDefaultUserPhotoFile();
        }
    }//GEN-LAST:event_uploadButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JTextField addressTF;
    private javax.swing.JLayeredPane contactPersonImage;
    private javax.swing.JLabel contactPersonPhoto;
    private javax.swing.JFileChooser contactPersonPhotoChooserChooser;
    private javax.swing.JComboBox cpRoleCB;
    private javax.swing.JTextField emailAddressTF;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JTextField faxNumberTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
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

    String getWebsite() {
        return websiteUrlTF.getText();
    }

    String getRole() {
        return cpRoleCB.getSelectedItem().toString();
    }

    InputStream getCPPhotoStream() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(imageGet.getDefaultUserPhotoFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContactPersonDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if (cpPhotoFile != null) {
                fileInputStream = new FileInputStream(cpPhotoFile);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return fileInputStream;
    }

    int getLength() {
        if (cpPhotoFile != null) {
            return (int) cpPhotoFile.length();
        } else {
            return 0;
        }

    }

    ImageIcon getCPPhoto() {
        return (ImageIcon) contactPersonPhoto.getIcon();
    }

    boolean isValidation() {
        boolean status = false;
        if (!nameTF.getText().isEmpty()) {
            if (cpRoleCB.getSelectedIndex() > -1) {
                status = true;
            } else {
                errorMessage.setText("!!! Please, select to the contact person role.");
                errorMessage.setIcon(imageGet.getAlertIcon());
            }
        } else {
            errorMessage.setText("!!! Please, enter to the contact person name.");
            errorMessage.setIcon(imageGet.getAlertIcon());
        }
        return status;
    }

    void setInformation(String cN, String add, String ph, String fax, String email, String web, String role, byte[] binaryStream) {
        nameTF.setText(cN);
        addressTF.setText(add);
        phoneNumberTF.setText(add);
        faxNumberTF.setText(add);
        emailAddressTF.setText(add);
        websiteUrlTF.setText(add);
        cpRoleCB.setSelectedItem(role);
        contactPersonPhoto.setIcon(new ImageIcon(binaryStream));
    }

}
