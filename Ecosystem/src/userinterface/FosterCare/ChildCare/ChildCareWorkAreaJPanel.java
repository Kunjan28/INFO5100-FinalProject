/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterCare.ChildCare;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
//import Business.Organization.Orphanage.ChildCareOrganization;
//import Business.Organization.Orphanage.ChildRegistrationOrganization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
//import Business.WorkQueue.ChildCareAdoptionWorkRequest;
//import Business.WorkQueue.ChildCareWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12013
 */
public class ChildCareWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChildCareWorkAreaJPanel
     */
    JPanel userProcessContainer;
     Enterprise enterprise;
     Organization organization;
     UserAccount account;
     ChildCareOrganization childCareOrganization;
    ChildDirectory directory;
    Child child;
    EcoSystem business;
    ChildCareWorkAreaJPanel panel;
     AdopterDirectory udirectory;
     Adopter adopter;
      Role roler;
         Network network;
      
    public ChildCareWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory) {
     initComponents();
    this.userProcessContainer=userProcessContainer;
    this.account=account;
    this.business = business;
    this.childCareOrganization=(ChildCareOrganization)organization;
    this.directory = directory;
    this.udirectory = udirectory;
    
         System.out.println("directory; "+directory.toString());
    this.enterprise=enterprise;
         valueLabel.setText(enterprise.getName());
         orgLabel.setText(childCareOrganization.getName());
        processBtn.setEnabled(false);
    
        for(Network net: business.getNetworkList()){
      for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
          if(ent.equals(enterprise)){
              network= net;
          }
      }
  }
        
         populateAdopterTable();
         populateChildTable();
         populateWorkRequest();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        orgLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        childTable = new javax.swing.JTable();
        viewChildBtn = new javax.swing.JButton();
        processBtn = new javax.swing.JButton();
        assignBtn = new javax.swing.JButton();
        deleteChildBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel.setText("<value>");

        orgLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orgLabel.setText("<value>");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Work Queue");

        workTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Child ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workTable);
        if (workTable.getColumnModel().getColumnCount() > 0) {
            workTable.getColumnModel().getColumn(2).setResizable(false);
            workTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Child details");

        childTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Child ID", "Child Name", "Age", "Gender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(childTable);
        if (childTable.getColumnModel().getColumnCount() > 0) {
            childTable.getColumnModel().getColumn(0).setResizable(false);
            childTable.getColumnModel().getColumn(1).setResizable(false);
            childTable.getColumnModel().getColumn(2).setResizable(false);
            childTable.getColumnModel().getColumn(3).setResizable(false);
            childTable.getColumnModel().getColumn(4).setResizable(false);
        }

        viewChildBtn.setText("View Child Details");
        viewChildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewChildBtnActionPerformed(evt);
            }
        });

        processBtn.setText("Process Request");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });

        assignBtn.setText("Assign to me");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });

        deleteChildBtn.setText("Delete Child");
        deleteChildBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteChildBtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Child Id", "Adopter Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setText("Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Adopter Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(247, 247, 247))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(viewChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(deleteChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteChildBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed
        int selectedRow = workTable.getSelectedRow();
       if(selectedRow<0){
           JOptionPane.showMessageDialog(null, "Please select a request"); 
           return;
       }
       WorkRequest re = (WorkRequest) workTable.getValueAt(selectedRow, 0);
      
        
       for(Child ch : directory.getChildList()){

           if(ch.getChildId()==re.getChildId()){

               child=ch;
           
           }
       }
       
        ProcessChildCareWorkRequest pccwr = new ProcessChildCareWorkRequest(userProcessContainer, organization, (ChildCareWorkRequest) re, directory, child, account, business);
        this.userProcessContainer.add("ProcessChildCareWorkRequest", pccwr);
       CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
       layout.next(userProcessContainer);
    }//GEN-LAST:event_processBtnActionPerformed

    private void viewChildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewChildBtnActionPerformed
      int selectedRow = childTable.getSelectedRow();
    
      
      if(selectedRow<0){
           JOptionPane.showMessageDialog(null, "Please select a child");
          return;
      }
      
          Child child = (Child) childTable.getValueAt(selectedRow, 0);      
        
       
        ViewCompleteChildDetails completeJapanel = new ViewCompleteChildDetails(userProcessContainer,account,organization,enterprise,business,directory, child);
       this.userProcessContainer.add("ViewCompleteChildDetails", completeJapanel);
       CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
       layout.next(userProcessContainer);
    }//GEN-LAST:event_viewChildBtnActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
       int selectedRow = workTable.getSelectedRow();
       if(selectedRow<0){
           JOptionPane.showMessageDialog(null, "Please select a request");
           return;
       }
       WorkRequest re = (WorkRequest) workTable.getValueAt(selectedRow, 0);
       re.setReceiver(account);
       re.setStatus("Pending with child care");
       populateWorkRequest();
        processBtn.setEnabled(true);
    }//GEN-LAST:event_assignBtnActionPerformed

    private void deleteChildBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteChildBtnActionPerformed
        int selectedRow = childTable.getSelectedRow();
        if(selectedRow<0){
             JOptionPane.showMessageDialog(null, "Please select a child");
            return;
        }
        Child ch = (Child) childTable.getValueAt(selectedRow, 0);
       int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the child?", "Alert", JOptionPane.YES_NO_CANCEL_OPTION);
       if(result==0){
        directory.removeChild(ch);
       }
        populateChildTable();
    }//GEN-LAST:event_deleteChildBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow<0){
             JOptionPane.showMessageDialog(null, "Please select a request");
            return;
        }
       
        ChildCareAdoptionWorkRequest req = (ChildCareAdoptionWorkRequest) jTable1.getValueAt(selectedRow, 0);
        req.setStatus("Approved");
        for(Child ch: directory.getChildList()){
            if(ch.getChildId()==req.getChildId()){
                ch.setStatus("Adopted by "+req.getUserName());
            }
        }
        
        
        
        populateAdopterTable();
    }//GEN-LAST:event_jButton1ActionPerformed
public void populateChildTable(){

    DefaultTableModel dtms = (DefaultTableModel)childTable.getModel();
    dtms.setRowCount(0);
    for(Child ch : directory.getChildList()){
        
   if(ch.getStatus().equalsIgnoreCase("Acquired") || ch.getStatus().startsWith("Adopted by")){
          Object[] row = new Object[dtms.getColumnCount()];
          row[0]=ch;
          row[1]=ch.getChildname();
          row[2]=ch.getChildAge();
          row[3]=ch.getChildGender();
          row[4]=ch.getStatus();
          
          dtms.addRow(row);
        }
    }
}

public void populateWorkRequest(){
    
    
    DefaultTableModel dtms = (DefaultTableModel)workTable.getModel();
       dtms.setRowCount(0);
    for(WorkRequest req : childCareOrganization.getWorkQueue().getWorkRequestList()){
     
       if(req instanceof ChildCareWorkRequest){
           
          Object[] row = new Object[dtms.getColumnCount()];
          row[0]=req;
          row[1]=req.getSender();
          row[2]=req.getReceiver();
          row[3]=req.getChildId();
          row[4]=req.getStatus();
          
          dtms.addRow(row);
           }
        
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JTable childTable;
    private javax.swing.JButton deleteChildBtn;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel orgLabel;
    private javax.swing.JButton processBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewChildBtn;
    private javax.swing.JTable workTable;
    // End of variables declaration//GEN-END:variables

    public void populateAdopterTable(){
        DefaultTableModel dtms = (DefaultTableModel) jTable1.getModel();
        dtms.setRowCount(0);
        for(WorkRequest req: business.getWorkQueue().getWorkRequestList()){
            if(req instanceof ChildCareAdoptionWorkRequest){

                
                    Object[] row = new Object[dtms.getColumnCount()];
                    row[0]=req;
                    row[1]=req.getChildId();
                    row[2]= ((ChildCareAdoptionWorkRequest) req).getUserName();
                    row[3]= req.getStatus();
                    dtms.addRow(row);
                }
            
        }
        
    }
    
    

}
