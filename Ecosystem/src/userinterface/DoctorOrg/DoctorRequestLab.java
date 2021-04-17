/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorOrg;

import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.LabWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author snehaswaroop
 */
public class DoctorRequestLab extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private ChildDirectory childdirectory;
    private Child child;
    private  DoctorWorkRequest request;
    private  EcoSystem business;
    Network network;
    
    
    public DoctorRequestLab(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Child child, ChildDirectory childdirectory, DoctorWorkRequest request, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.child = child;
        this.childdirectory=childdirectory;
        this.business = business;
        this.request = request;
        for(Network net: business.getNetworkList()){
        for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
            if(ent.equals(enterprise)){
            network= net;
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
        jLabel2 = new javax.swing.JLabel();
        txtTest = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REQUEST LAB TEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 350, 20));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel2.setText("Test Description");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 140, 20));
        add(txtTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 270, 90));

        btnSave.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 110, 30));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 60, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lab.jpeg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 760, 470));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AssignChildJPanel panel = (AssignChildJPanel) component;
        panel.populateLabTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String message = txtTest.getText();
        if(message.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter test name");
        }
        else
        {
        LabWorkRequest labRequest = new LabWorkRequest();
        labRequest.setMessage(message);
        labRequest.setSender(userAccount);
        labRequest.setStatus("Sent");
        labRequest.setChildId(request.getChildId());
        labRequest.setChildName(request.getChildName());
        
        labRequest.setStatus("Medical Test Requested");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
           // if(this.network.equals(network)){
                if (organization instanceof LabOrganization){
                org = organization;
                break;
                }
      //        }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(labRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(labRequest);
        }  
        }
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AssignChildJPanel panel = (AssignChildJPanel) component;
        panel.populateLabTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtTest;
    // End of variables declaration//GEN-END:variables
}
