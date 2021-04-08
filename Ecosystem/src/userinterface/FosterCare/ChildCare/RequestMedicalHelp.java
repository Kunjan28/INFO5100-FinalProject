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
import Business.WorkQueue.DoctorWorkRequest;
import java.awt.CardLayout;
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
        this.userProcessContainer=userProcessContainer;
        this.child=child;
        this.account=account;
        this.organization = (ChildCareOrganization) organization;
        this.enterprise=enterprise;
        this.business=business;
        this.directory=directory;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSymptoms = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Symptoms:");

        txtSymptoms.setColumns(20);
        txtSymptoms.setRows(5);
        jScrollPane1.setViewportView(txtSymptoms);

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Request Medical Help");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(451, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if(txtSymptoms.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter the symptoms");
            return;
        }
        
        String symptoms = txtSymptoms.getText();
        child.setMedicalStatus(child.getMedicalStatus()+"\n"+symptoms+" on date "+new Date());
        
        DoctorWorkRequest docwrkreq = new DoctorWorkRequest();
        docwrkreq.setStatus("Medically Unfit");
        docwrkreq.setMessage(symptoms);
        docwrkreq.setSender(account);
        docwrkreq.setChildId(child.getChildId());
        docwrkreq.setRemarks("Request for Doctor");
     
        /*
        The below set of code iterates through the network list and get the network
        Once the network is received then it iterates over all the enterprises present in the network
        It goes thought every organization in the enterprise.
        
        Once it has found the Doctor organization, it sets the organization as Doctor organization
        
        */
        Organization org = null;
        for (Network network : business.getNetworkList()){
           // getNetworkList().getOrganizationDirectory().getOrganizationList()
            System.out.println("network: "+network);
            for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
                
                for(Organization organization: ent.getOrganizationDirectory().getOrganizationList()){
                   
                
              //if(this.network.equals(network)){
                            if (organization instanceof DoctorOrganization){
                                
                                org = organization;
                                break;
                            }
                        //    }
            
        }
            }
        }
/*The below if code checks if there is some value for org. If there is then add the work request 
        - At the organization level, where other organization in the same enterprise can access it
        -At the account level, so the child registration can also see the request created
        - At the business level, as the request has to be transferred to a different organization in a different enterprise.
        */
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(docwrkreq);
          
            account.getWorkQueue().getWorkRequestList().add(docwrkreq);
             business.getWorkQueue().getWorkRequestList().add(docwrkreq);
    
        }
        
        ViewCompleteChildDetails vccd = new ViewCompleteChildDetails(userProcessContainer, account, organization, enterprise, business, directory, child);
        this.userProcessContainer.add("ViewCompleteChildDetails", vccd);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
        
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSymptoms;
    // End of variables declaration//GEN-END:variables
}
