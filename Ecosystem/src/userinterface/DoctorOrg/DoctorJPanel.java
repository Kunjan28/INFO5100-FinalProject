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
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class DoctorJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DoctorOrganization doctororganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    ChildDirectory directory;
    Child child;
    Network network;
    
    public DoctorJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise , EcoSystem business, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.doctororganization = (DoctorOrganization)organization;
        this.enterprise = enterprise;
        this.directory = directory;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        for(Network net: business.getNetworkList()){
        for(Enterprise ent: net.getEnterpriseDirectory().getEnterpriseList()){
            if(ent.equals(enterprise)){
              network= net;
            }
        }
        }
        populateRequestTable();
        System.out.println("this is " + enterprise.getName());
    }
    
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblDoctor.getModel();
        model.setRowCount(0);
        for (WorkRequest request : doctororganization.getWorkQueue().getWorkRequestList()){
        business.getWorkQueue().getWorkRequestList();
        if(request instanceof DoctorWorkRequest){
            Object[] row = new Object[model.getColumnCount()];
            row[0] = request;
            row[1] = request.getChildId();
            //row[2] = request.getName();
            row[3] = request.getStatus();
            row[4] = request.getSender().getEmployee().getName();
            row[5] = request.getReceiver() == null ? null: request.getReceiver().getEmployee().getName();
            String result = ((DoctorWorkRequest) request).getTestResult();
            row[5] = result == null ? "Waiting" : result;
            model.addRow(row);
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

        lblDoctorPic = new javax.swing.JLabel();
        lblDoctorOrganisation = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctor = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDoctorPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doctoricon.png"))); // NOI18N
        add(lblDoctorPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 180));

        lblDoctorOrganisation.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblDoctorOrganisation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoctorOrganisation.setText("DOCTOR ORGANISATION");
        add(lblDoctorOrganisation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 540, 30));

        tblDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Child ID", "Child Name", "Status", "Sender", "Receiver", "Comments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDoctor);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 730, 120));

        btnAssignToMe.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 170, -1));

        btnProcess.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, 130, -1));

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refreshIcon.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 140, 30));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hosp.jpeg"))); // NOI18N
        add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 660, 430));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Enterprise");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 20));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 130, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDoctor.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a child from table");
            return;
            }
        DoctorWorkRequest request = (DoctorWorkRequest) tblDoctor.getValueAt(selectedRow, 0);
//        request.setReceiver(userAccount);
//        request.setStatus("Under Examination");
                if (request.getStatus().equalsIgnoreCase("Under Examination") || request.getStatus().equalsIgnoreCase("Pending") || request.getStatus().equalsIgnoreCase("Medicine Prescribed") || request.getStatus().equalsIgnoreCase("Medical Test Requested")) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
                } else {
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                }
                populateRequestTable();
                JOptionPane.showMessageDialog(null, "Request has successfully assigned");
        populateRequestTable();
        btnProcess.setEnabled(true);
    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDoctor.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a child from table before proceeding");
            return;
        }
        DoctorWorkRequest request = (DoctorWorkRequest)tblDoctor.getValueAt(selectedRow,0);
        request.setTestResult("Under Examination");
        System.out.println("Requesting child ID: " + request.getChildId());
        for(Child c: directory.getChildList()){
            System.out.println("inside for loop: "+directory);
            if(c.getChildId()==request.getChildId()){
                child = c;
            }
        }
        AssignChildJPanel assignedChildJPanel = new AssignChildJPanel(userProcessContainer ,request, child ,userAccount, doctororganization,enterprise , business, directory);
        userProcessContainer.add("AssignedChildJPanel", assignedChildJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();        
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoctorOrganisation;
    private javax.swing.JLabel lblDoctorPic;
    private javax.swing.JLabel lblImg;
    private javax.swing.JTable tblDoctor;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
