/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.Donor.DonorDirectory;
import Business.EcoSystem;
import Business.Enterprise.AdoptionEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FosterCareEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import userinterface.AdopterRoleAdmin.AdoptionUnitWorkRequestJPanel;
import userinterface.FundingRoleAdmin.FundingUnitWorkRequestJPanel;

/**
 *
 * @author MyPC1
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem business;

    Enterprise enterprise;
    
    //JPanel userProcessContainer;
    //Enterprise enterprise;
    //EcoSystem business;
    Network network;
    UserAccount account;
    Organization organization;
    AdopterDirectory udirectory;
    ChildDirectory directory;
    DonorDirectory donorDirectory;
   
    
    public AdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory,DonorDirectory donorDirectory) {
        initComponents();
        System.out.println("here");
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.udirectory = udirectory;
        this.directory = directory;
        this.donorDirectory = donorDirectory;
        manageRequestPanel.setVisible(false);
        if ("Adoption".equalsIgnoreCase(this.enterprise.getEnterpriseType().getValue()) || "Funding".equalsIgnoreCase(this.enterprise.getEnterpriseType().getValue())) {
            manageRequestPanel.setVisible(true);
        }
        manageOrganisation();
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
    
    private void manageOrganisation(){
        ManageOrganizationJPanel panel = new ManageOrganizationJPanel(rightSystemAdminPanel, enterprise.getOrganizationDirectory(), enterprise);
        rightSystemAdminPanel.add("ManageNetworkJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
     }
    
    private void manageEmployee(){
        ManageEmployeeJPanel panel = new ManageEmployeeJPanel(rightSystemAdminPanel, enterprise.getOrganizationDirectory());
        rightSystemAdminPanel.add("ManageEnterpriseJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
        
    }
    
    private void manageUser(){
        ManageUserAccountJPanel panel = new ManageUserAccountJPanel(rightSystemAdminPanel, enterprise, business);
        rightSystemAdminPanel.add("ManageEnterpriseAdminJPanel",panel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }
    
    private void manageRequests(){
         if("Adoption".equalsIgnoreCase(this.enterprise.getEnterpriseType().getValue())){
               AdoptionUnitWorkRequestJPanel vOUWRJP = new AdoptionUnitWorkRequestJPanel(rightSystemAdminPanel, account, enterprise, business,udirectory);
        rightSystemAdminPanel.add("manageOrganizationJPanel", vOUWRJP);
         }
         else if("Funding".equalsIgnoreCase(this.enterprise.getEnterpriseType().getValue())){
             FundingUnitWorkRequestJPanel vOUWRJP = new FundingUnitWorkRequestJPanel(rightSystemAdminPanel, account, enterprise, business,udirectory,donorDirectory);
        rightSystemAdminPanel.add("manageOrganizationJPanel", vOUWRJP);
         }
        
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
        manageNetworkPanel = new javax.swing.JPanel();
        manageOrganisation = new javax.swing.JLabel();
        manageEnterprise = new javax.swing.JPanel();
        manageEmployee = new javax.swing.JLabel();
        manageEnterpriseAdmin = new javax.swing.JPanel();
        manageUser = new javax.swing.JLabel();
        manageRequestPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ManageRequest = new javax.swing.JLabel();
        lblSelectedNode1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jSeparator2 = new javax.swing.JSeparator();
        rightSystemAdminPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(215, 81, 81));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new java.awt.BorderLayout());

        systemAdminPanel.setBackground(new java.awt.Color(255, 204, 153));
        systemAdminPanel.setPreferredSize(new java.awt.Dimension(1338, 840));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 148));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 148));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkPanel.setBackground(new java.awt.Color(255, 204, 153));
        manageNetworkPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageNetworkPanelMousePressed(evt);
            }
        });

        manageOrganisation.setBackground(new java.awt.Color(255, 204, 153));
        manageOrganisation.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        manageOrganisation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageOrganisation.setText("Manage Organisation");
        manageOrganisation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageOrganisationMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageNetworkPanelLayout = new javax.swing.GroupLayout(manageNetworkPanel);
        manageNetworkPanel.setLayout(manageNetworkPanelLayout);
        manageNetworkPanelLayout.setHorizontalGroup(
            manageNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageNetworkPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(manageOrganisation, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        manageNetworkPanelLayout.setVerticalGroup(
            manageNetworkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageNetworkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageOrganisation, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(manageNetworkPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, -1));

        manageEnterprise.setBackground(new java.awt.Color(255, 204, 153));
        manageEnterprise.setPreferredSize(new java.awt.Dimension(264, 48));
        manageEnterprise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEnterpriseMousePressed(evt);
            }
        });

        manageEmployee.setBackground(new java.awt.Color(255, 204, 153));
        manageEmployee.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageEmployee.setText("Manage Employee");
        manageEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEmployeeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageEnterpriseLayout = new javax.swing.GroupLayout(manageEnterprise);
        manageEnterprise.setLayout(manageEnterpriseLayout);
        manageEnterpriseLayout.setHorizontalGroup(
            manageEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        manageEnterpriseLayout.setVerticalGroup(
            manageEnterpriseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEnterpriseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(manageEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 280, 50));

        manageEnterpriseAdmin.setBackground(new java.awt.Color(255, 204, 153));
        manageEnterpriseAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageEnterpriseAdminMousePressed(evt);
            }
        });

        manageUser.setBackground(new java.awt.Color(255, 204, 153));
        manageUser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        manageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageUser.setText("Manage User");
        manageUser.setPreferredSize(new java.awt.Dimension(115, 16));

        javax.swing.GroupLayout manageEnterpriseAdminLayout = new javax.swing.GroupLayout(manageEnterpriseAdmin);
        manageEnterpriseAdmin.setLayout(manageEnterpriseAdminLayout);
        manageEnterpriseAdminLayout.setHorizontalGroup(
            manageEnterpriseAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageEnterpriseAdminLayout.createSequentialGroup()
                .addComponent(manageUser, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        manageEnterpriseAdminLayout.setVerticalGroup(
            manageEnterpriseAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageEnterpriseAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageUser, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(manageEnterpriseAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 88, 280, 40));

        manageRequestPanel.setBackground(new java.awt.Color(255, 204, 153));
        manageRequestPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageRequestPanelMousePressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/stats.png"))); // NOI18N

        ManageRequest.setBackground(new java.awt.Color(255, 204, 153));
        ManageRequest.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ManageRequest.setText("Manage Request");
        ManageRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ManageRequestMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageRequestPanelLayout = new javax.swing.GroupLayout(manageRequestPanel);
        manageRequestPanel.setLayout(manageRequestPanelLayout);
        manageRequestPanelLayout.setHorizontalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageRequestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ManageRequest, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        manageRequestPanelLayout.setVerticalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRequestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(manageRequestPanelLayout.createSequentialGroup()
                .addComponent(ManageRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(manageRequestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 280, 40));

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

    private void manageOrganisationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageOrganisationMousePressed
        manageOrganisation();
    }//GEN-LAST:event_manageOrganisationMousePressed

    private void manageNetworkPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageNetworkPanelMousePressed
        // TODO add your handling code here:
        manageOrganisation();
    }//GEN-LAST:event_manageNetworkPanelMousePressed

    private void manageEmployeeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmployeeMousePressed
      manageEmployee();
    }//GEN-LAST:event_manageEmployeeMousePressed

    private void manageEnterpriseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEnterpriseMousePressed
        // TODO add your handling code here:
      manageEmployee();
    }//GEN-LAST:event_manageEnterpriseMousePressed

    private void manageEnterpriseAdminMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminMousePressed
       manageUser();
    }//GEN-LAST:event_manageEnterpriseAdminMousePressed

    private void ManageRequestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageRequestMousePressed
        // TODO add your handling code here:
        manageRequests();
    }//GEN-LAST:event_ManageRequestMousePressed

    private void manageRequestPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageRequestPanelMousePressed
        // TODO add your handling code here:
          manageRequests();
    }//GEN-LAST:event_manageRequestPanelMousePressed

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
         DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode1.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTree1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ManageRequest;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblSelectedNode1;
    private javax.swing.JLabel manageEmployee;
    private javax.swing.JPanel manageEnterprise;
    private javax.swing.JPanel manageEnterpriseAdmin;
    private javax.swing.JPanel manageNetworkPanel;
    private javax.swing.JLabel manageOrganisation;
    private javax.swing.JPanel manageRequestPanel;
    private javax.swing.JLabel manageUser;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    // End of variables declaration//GEN-END:variables
}
