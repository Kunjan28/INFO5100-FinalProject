/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdopterRegisteration;

import Business.Adopter.Adopter;
import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdopterOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdopterWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class CheckStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form checkStatusJPanel
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
    
    public CheckStatusJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, AdopterDirectory udirectory, int uid, ChildDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.udirectory = udirectory;
        this.account = account;
        this.enterprise = enterprise;
        this.business = business;
        this.adopterorganization = (AdopterOrganization) organization;
        this.uid = uid;
        this.directory = directory;
        for (Adopter a : udirectory.getAdoptersList()) {
            if (a.getUsername().equals(account.getUsername())) {
                adopter = a;
            }
        }
        populateTable();
    }
    
    private void populateTable() {
        DefaultTableModel dtms = (DefaultTableModel) tblReq.getModel();
        dtms.setRowCount(0);

        for (WorkRequest req : adopterorganization.getWorkQueue().getWorkRequestList()) {
            if (req instanceof AdopterWorkRequest) {
                if (req.getUserId() == adopter.getUserId()) {
                    Object[] row = new Object[dtms.getColumnCount()];
                    row[0] = req;
                    row[1] = ((AdopterWorkRequest) req).getBgcStatus();
                    row[2] = ((AdopterWorkRequest) req).getFinanceStatus();
                    dtms.addRow(row);

                    bgcstatus = ((AdopterWorkRequest) req).getBgcStatus();
                    financestatus = ((AdopterWorkRequest) req).getFinanceStatus();
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
        tblRequest = new javax.swing.JScrollPane();
        tblReq = new javax.swing.JTable();
        btnProceed = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setText("TRACK YOUR STATUS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 260, 20));

        tblReq.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Message", "BGC Status", "Criminal Check Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRequest.setViewportView(tblReq);

        add(tblRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 860, 130));

        btnProceed.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnProceed.setText("Proceed");
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });
        add(btnProceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 150, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kids 2.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 920, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
        if (tblReq.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        } else if ("Approved".equals(bgcstatus) && "Approved".equals((financestatus))) {
            ChildSelectionJpanel csjp = new ChildSelectionJpanel(userProcessContainer, account, adopterorganization, enterprise, business, udirectory, uid, directory);
            this.userProcessContainer.add("ChildSelectionJPanel", csjp);
            CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else if ("Pending".equals(bgcstatus) || "Pending".equals(financestatus)) {
            JOptionPane.showMessageDialog(null, "Adoption request is still in process with the Investigation team");
        } else
            JOptionPane.showMessageDialog(null, "Adoption request denied by Investigation Team");
    }//GEN-LAST:event_btnProceedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProceed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable tblReq;
    private javax.swing.JScrollPane tblRequest;
    // End of variables declaration//GEN-END:variables
}
