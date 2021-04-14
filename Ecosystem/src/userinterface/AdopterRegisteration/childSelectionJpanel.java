/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRegisteration;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.Child.Child;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdopterOrganization;
import Business.Organization.ChildCareOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ChildCareAdoptionWorkRequest;
import Business.WorkQueue.ChildCareWorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class childSelectionJpanel extends javax.swing.JPanel {

    /**
     * Creates new form childStatusJpanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory udirectory;
    AdopterOrganization adopterorganization;
    Adopter adopter;
    String bgcstatus,financestatus;
    int uid;
    ChildDirectory directory;
    ChildCareWorkRequest request;
    
    public childSelectionJpanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory, int uid, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.udirectory=udirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.adopterorganization =(AdopterOrganization) organization;
        this.uid = uid;
        this.directory = directory;
    //if condition for enabling proceed with adoption button if BGC and fin checks are approved
       for(Adopter a: udirectory.getAdoptersList()){
           if(a.getUsername().equals(account.getUsername())){
               adopter=a;
           }
       }
        populateChildTable();
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
        tblChild = new javax.swing.JTable();
        btnAdopt = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHILD SELECTION");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 383, -1));

        tblChild.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Child ID", "Child Name", "Gender", "Age", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblChild);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 710, 150));

        btnAdopt.setText("Adopt");
        btnAdopt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptActionPerformed(evt);
            }
        });
        add(btnAdopt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdoptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblChild.getSelectedRow();
        if(selectedRow<0){
            return;
        }
        Child ch = (Child) tblChild.getValueAt(selectedRow, 0);
        ChildCareAdoptionWorkRequest adc = new ChildCareAdoptionWorkRequest();
        adc.setChildId(ch.getChildId());
        adc.setUserId(uid);
        adc.setUserName(adopter.getName());
        adc.setMessage("I want to adopt");
          Organization org = null;
        for (Network network : business.getNetworkList()){
           // getNetworkList().getOrganizationDirectory().getOrganizationList()
            System.out.println("ye hai network: "+network);
            for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("ye hai enterprise: "+ent);
                for(Organization organization: ent.getOrganizationDirectory().getOrganizationList()){
                    System.out.println("ye hai org: "+organization);
                       
                    if (organization instanceof ChildCareOrganization){

                        org = organization;
                        System.out.println("ye hai org: "+org);
                        break;
                    } 
                }
            }
        }
        
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(adc);
            account.getWorkQueue().getWorkRequestList().add(adc);
            business.getWorkQueue().getWorkRequestList().add(adc);
        } 
        
        adopter.setFlag(false);
    }//GEN-LAST:event_btnAdoptActionPerformed
    
    public void populateChildTable(){

    DefaultTableModel dtms = (DefaultTableModel)tblChild.getModel();
    dtms.setRowCount(0);
    for(Child child: directory.getChildList()){
        System.out.println("inside for");
        if(child.getStatus().equalsIgnoreCase("Acquired") || child.getStatus().startsWith("Adopted by "+adopter.getName())){
          Object[] row = new Object[dtms.getColumnCount()];
            System.out.println("child"+child);
          row[0]=child;
          row[1]=child.getName();
          row[2]=child.getGender();
          row[3]=child.getChildAge();
          row[4]=child.getStatus();
          
          dtms.addRow(row);
       }
    }
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdopt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChild;
    // End of variables declaration//GEN-END:variables
}
