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
import Business.Enterprise.AdoptionEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FosterCareEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.ChildCareOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author snehaswaroop
 */
public class ChildCareWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    Organization organization;
    UserAccount account;
    ChildCareOrganization childCareOrganization;
    ChildDirectory directory;
    Child child;
    EcoSystem business;
    AcquireChild panel;
    AdopterDirectory udirectory;
    Adopter adopter;
    Role roler;
    Network network;
    
    
    public ChildCareWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.business = business;
        this.childCareOrganization=(ChildCareOrganization)organization;
        this.directory = directory;
        this.udirectory = udirectory;
        
        manageChildAreaJPanel();
        
        //populateTree();
//        organizationJComboBox.removeAllItems();
//        if(enterprise instanceof HospitalEnterprise){
//             organizationJComboBox.addItem(Organization.Type.Doctor);
//               organizationJComboBox.addItem(Organization.Type.Lab);
//               organizationJComboBox.addItem(Organization.Type.Pharmacist);
//        }
//        if(enterprise instanceof FosterCareEnterprise){
//          organizationJComboBox.addItem(Organization.Type.ChildCare);
//               organizationJComboBox.addItem(Organization.Type.ChildRegistration);
//               organizationJComboBox.addItem(Organization.Type.FinanceOrphanage);  
//        }
//        if(enterprise instanceof AdoptionEnterprise){
//           organizationJComboBox.addItem(Organization.Type.Adopter);
//               organizationJComboBox.addItem(Organization.Type.Adoption);
//               organizationJComboBox.addItem(Organization.Type.FinanceCheck); 
//                 organizationJComboBox.addItem(Organization.Type.CriminalCheck); 
//        }
        
    }
    
    public void populateTree(){
        DefaultTreeModel model=(DefaultTreeModel)jTree1.getModel();
        ArrayList<Network> networkList=business.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        Network network;
        Enterprise enterprise;
        Organization organization;
        
        DefaultMutableTreeNode networks=new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root=(DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i=0;i<networkList.size();i++){
            network=networkList.get(i);
            networkNode=new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList=network.getEnterpriseDirectory().getEnterpriseList();
            for(int j=0; j<enterpriseList.size();j++){
                enterprise=enterpriseList.get(j);
                enterpriseNode=new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList=enterprise.getOrganizationDirectory().getOrganizationList();
                for(int k=0;k<organizationList.size();k++){
                    organization=organizationList.get(k);
                    organizationNode=new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }
    
    private void manageChildAreaJPanel(){
        AcquireChild panel = new AcquireChild(rightSystemAdminPanel, account, childCareOrganization, enterprise, business, directory, udirectory);
        rightSystemAdminPanel.add("ManageNetworkJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
     }
    
    private void ViewChild(){
        ViewChildDetails panel = new ViewChildDetails(rightSystemAdminPanel, account, childCareOrganization, enterprise, business, directory, udirectory);
        rightSystemAdminPanel.add("ManageNetworkJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        systemAdminPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ChildWorkArea = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CC = new javax.swing.JLabel();
        lblViewChild = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ViewChild = new javax.swing.JLabel();
        lblSelectedNode1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSeparator2 = new javax.swing.JSeparator();
        rightSystemAdminPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 204, 153));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new java.awt.BorderLayout());

        systemAdminPanel.setBackground(new java.awt.Color(255, 204, 153));
        systemAdminPanel.setPreferredSize(new java.awt.Dimension(1338, 840));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 148));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 148));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChildWorkArea.setBackground(new java.awt.Color(255, 204, 153));
        ChildWorkArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChildWorkAreaMousePressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/worldwide.png"))); // NOI18N

        CC.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CC.setText("Child Care Area");
        CC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CCMousePressed(evt);
            }
        });

        javax.swing.GroupLayout ChildWorkAreaLayout = new javax.swing.GroupLayout(ChildWorkArea);
        ChildWorkArea.setLayout(ChildWorkAreaLayout);
        ChildWorkAreaLayout.setHorizontalGroup(
            ChildWorkAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChildWorkAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CC, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ChildWorkAreaLayout.setVerticalGroup(
            ChildWorkAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChildWorkAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChildWorkAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(ChildWorkArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, -1));

        lblViewChild.setBackground(new java.awt.Color(255, 204, 153));
        lblViewChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblViewChildMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/stats.png"))); // NOI18N

        ViewChild.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ViewChild.setText("View Child Details");
        ViewChild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewChildMousePressed(evt);
            }
        });

        javax.swing.GroupLayout lblViewChildLayout = new javax.swing.GroupLayout(lblViewChild);
        lblViewChild.setLayout(lblViewChildLayout);
        lblViewChildLayout.setHorizontalGroup(
            lblViewChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblViewChildLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewChild, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        lblViewChildLayout.setVerticalGroup(
            lblViewChildLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblViewChildLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(lblViewChildLayout.createSequentialGroup()
                .addComponent(ViewChild, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(lblViewChild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, -1));

        lblSelectedNode1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jPanel3.add(lblSelectedNode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 230, 30));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Selected Node:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, 30));

        jTree1.setBackground(new java.awt.Color(255, 204, 153));
        jTree1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTree1.setForeground(new java.awt.Color(0, 0, 0));
        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 250, 270));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 280, -1));

        rightSystemAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSystemAdminPanel.setPreferredSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout systemAdminPanelLayout = new javax.swing.GroupLayout(systemAdminPanel);
        systemAdminPanel.setLayout(systemAdminPanelLayout);
        systemAdminPanelLayout.setHorizontalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemAdminPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        systemAdminPanelLayout.setVerticalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(systemAdminPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void CCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CCMousePressed
        manageChildAreaJPanel();
    }//GEN-LAST:event_CCMousePressed

    private void ChildWorkAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChildWorkAreaMousePressed
        // TODO add your handling code here:
        manageChildAreaJPanel();
    }//GEN-LAST:event_ChildWorkAreaMousePressed

    private void ViewChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewChildMousePressed
        // TODO add your handling code here:
        ViewChild();
    }//GEN-LAST:event_ViewChildMousePressed

    private void lblViewChildMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewChildMousePressed
        // TODO add your handling code here:
          ViewChild();
    }//GEN-LAST:event_lblViewChildMousePressed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
         DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode1.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTree1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CC;
    private javax.swing.JPanel ChildWorkArea;
    private javax.swing.JLabel ViewChild;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblSelectedNode1;
    private javax.swing.JPanel lblViewChild;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    // End of variables declaration//GEN-END:variables
}
