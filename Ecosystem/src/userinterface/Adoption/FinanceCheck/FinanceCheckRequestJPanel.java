/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Adoption.FinanceCheck;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FinanceCheckOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FinanceCheckProcessWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class FinanceCheckRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FinanceCheckRequestTable
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    EcoSystem business;
    AdopterDirectory adopterdirectory;
    FinanceCheckOrganization financeOrganization;
    Adopter adopter;
    
    public FinanceCheckRequestJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory adopterdirectory) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.adopterdirectory=adopterdirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.financeOrganization = (FinanceCheckOrganization)organization;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FINANCE CHECK REQUEST");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 383, -1));

        tblRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "User ID", "Adopter Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 960, 166));

        btnAssign.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });
        add(btnAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 145, -1));

        btnProcess.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 135, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finance.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 680, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }

        Object receiverval = tblRequest.getValueAt(selectedRow, 2);
        Object statusval = tblRequest.getValueAt(selectedRow, 5);

        if (receiverval == null) {
            WorkRequest re = (WorkRequest) tblRequest.getValueAt(selectedRow, 0);
            re.setReceiver(account);
            re.setStatus("Finance organization processing");
            populateWorkRequest();
        } else {
            if (statusval.equals("Approved") || statusval.equals("Denied")) {
                JOptionPane.showMessageDialog(null, "Please select some other request,this work request is already processed");
            } else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
            } else if (receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a workrequest");
            return;
        }
        WorkRequest req = (WorkRequest) tblRequest.getValueAt(selectedRow, 0);
        Object receiverval = tblRequest.getValueAt(selectedRow, 2);
        Object statusval = tblRequest.getValueAt(selectedRow, 5);
        for (Adopter a : adopterdirectory.getAdoptersList()) {
            if (a.getUserId() == req.getUserId()) {
                adopter = a;
            }
        }
        if (receiverval == null) {
            JOptionPane.showMessageDialog(null, "Please first assign it to yourself");
        } else {
            if (receiverval.equals(account.getUsername()) && statusval.equals("Finance organization processing")) {

                FinanceCheckProcess panel = new FinanceCheckProcess(userProcessContainer, account, financeOrganization, enterprise, business, adopterdirectory, (FinanceCheckProcessWorkRequest) req, adopter);
                this.userProcessContainer.add("FinanceCheckProcessRequestJPanel", panel);
                CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } else if ("Approved".equals(statusval) || "Denied".equals(statusval)) {
                JOptionPane.showMessageDialog(null, "The selected work request is already processed");
            } else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Please select the work request assigned to you to proceed");
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    public void populateWorkRequest() {

        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : financeOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof FinanceCheckProcessWorkRequest) {
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getUserId();
                row[4] = request.getName();
                row[5] = request.getStatus();
                dtm.addRow(row);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
