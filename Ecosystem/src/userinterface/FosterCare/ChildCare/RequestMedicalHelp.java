/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterCare.ChildCare;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ChildCareOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MedicalHelpWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 12013
 */
public class RequestMedicalHelp extends javax.swing.JPanel {

    /**
     * Creates new form RequestMedicalHelp
     */
    JPanel userProcessContainer;
    Child child;
    UserAccount account;
    ChildCareOrganization organization;
    Enterprise enterprise;
    EcoSystem business;
    ChildDirectory directory;
    Network network;

    public RequestMedicalHelp(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, Child child) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.child = child;
        this.account = account;
        this.organization = (ChildCareOrganization) organization;
        this.enterprise = enterprise;
        this.business = business;
        this.directory = directory;
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.equals(enterprise)) {
                    network = net;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSymptoms = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Symptoms");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 87, 42));

        txtSymptoms.setColumns(20);
        txtSymptoms.setRows(5);
        jScrollPane1.setViewportView(txtSymptoms);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 310, 110));

        btnSubmit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 133, 33));

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("REQUEST MEDICAL HELP");
        add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 460, 30));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/docChild.jpeg"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 450, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (txtSymptoms.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the symptoms");
            return;
        }
        String symptoms = txtSymptoms.getText();
        child.setMedicalStatus(child.getMedicalStatus() + "\n" + symptoms + " on date " + new Date());
        child.setMedicalHelp(true);
        MedicalHelpWorkRequest docwrkreq = new MedicalHelpWorkRequest();
        docwrkreq.setStatus("Medically Unfit");
        docwrkreq.setMessage(symptoms);
        docwrkreq.setSender(account);
        docwrkreq.setChildId(child.getChildId());
        docwrkreq.setRemark("Request for Doctor");
        docwrkreq.setChildName(child.getName());
        Organization org = null;
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof DoctorOrganization) {
                        org = organization;
                        break;
                    }
                }
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(docwrkreq);
            account.getWorkQueue().getWorkRequestList().add(docwrkreq);
            business.getWorkQueue().getWorkRequestList().add(docwrkreq);
        }
        ViewCompleteChildDetails vccd = new ViewCompleteChildDetails(userProcessContainer, account, organization, enterprise, business, directory, child);
        this.userProcessContainer.add("ViewCompleteChildDetails", vccd);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewCompleteChildDetails panel = (ViewCompleteChildDetails) component;
        panel.populaterequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTextArea txtSymptoms;
    // End of variables declaration//GEN-END:variables
}
