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
import Business.Organization.LabOrganization;
import Business.Organization.PharmacistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MedicalHelpWorkRequest;
import Business.WorkQueue.LabProcessWorkRequest;
import Business.WorkQueue.PharmacistWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author snehaswaroop
 */
public class AssignChildJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PharmacistOrganization pharmacistOrganization;
    private DoctorOrganization doctororganization;
    private EcoSystem business;
    MedicalHelpWorkRequest request;
    private ChildDirectory childdirectory;
    private Child child;
    private LabOrganization labOrganization;
    double temperature;
    double pulserate;
    double BP;
    double respirationrate;
    Network network;
    
    
    public AssignChildJPanel(JPanel userProcessContainer, MedicalHelpWorkRequest request, Child child, UserAccount userAccount, DoctorOrganization doctororganization, Enterprise enterprise, EcoSystem business, ChildDirectory childdirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.childdirectory = childdirectory;
        this.child = child;
        this.doctororganization = doctororganization;
        this.business = business;
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.equals(enterprise)) {
                    network = net;
                }
            }
        }
        getChildDetails();
        displayImage();
        populateLabTable();
        populateMedicationTable();
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        btnMale.setEnabled(false);
        btnFemale.setEnabled(false);
        txtMark.setEnabled(false);
        lblName.setEnabled(false);
        lblAge.setEnabled(false);
        lblGender.setEnabled(false);
        lblMark.setEnabled(false);
    }
    
    public void populateLabTable() {
        DefaultTableModel model = (DefaultTableModel) tblLab.getModel();
        model.setRowCount(0);
        for (WorkRequest labrequest : userAccount.getWorkQueue().getWorkRequestList()) {
            if (labrequest instanceof MedicalHelpWorkRequest || labrequest instanceof LabProcessWorkRequest) {
                if (labrequest.getChildId() == child.getChildId()) {
                    Object[] row = new Object[model.getColumnCount()];
                    row[0] = labrequest;
                    row[1] = labrequest.getChildId();
                    row[2] = labrequest.getChildName();
                    row[3] = labrequest.getReceiver();
                    row[4] = labrequest.getStatus();
                    if (labrequest instanceof MedicalHelpWorkRequest) {
                        String result = ((MedicalHelpWorkRequest) labrequest).getTestResult();
                        row[5] = result == null ? "Waiting" : result;
                    } else if (labrequest instanceof LabProcessWorkRequest) {
                        String result = ((LabProcessWorkRequest) labrequest).getResult();
                        row[5] = result == null ? "Waiting" : result;
                    }
                    model.addRow(row);
                }
            }
        }
    }
    
    public void populateMedicationTable() {
        DefaultTableModel model = (DefaultTableModel) tblMedication.getModel();
        model.setRowCount(0);
        for (WorkRequest pharrequest : userAccount.getWorkQueue().getWorkRequestList()) {
            if (pharrequest instanceof MedicalHelpWorkRequest || pharrequest instanceof PharmacistWorkRequest) {
                if (pharrequest.getChildId() == child.getChildId()) {
                    Object[] row = new Object[model.getColumnCount()];
                    row[0] = pharrequest;
                    row[1] = request.getChildId();
                    row[2] = request.getChildName();
                    row[3] = pharrequest.getReceiver();
                    if (pharrequest instanceof MedicalHelpWorkRequest) {
                        String result = ((MedicalHelpWorkRequest) pharrequest).getTestResult();
                        row[4] = result == null ? "Prescribed Medicine" : result;
                    } else if (pharrequest instanceof PharmacistWorkRequest) {
                        String result = ((PharmacistWorkRequest) pharrequest).getResult();
                        row[4] = result == null ? "Waiting" : result;
                    }
                    if (pharrequest instanceof MedicalHelpWorkRequest) {
                        String medicalPrescription = ((MedicalHelpWorkRequest) pharrequest).getPrescription();
                        row[5] = medicalPrescription == null ? "" : medicalPrescription;
                    } else if (pharrequest instanceof PharmacistWorkRequest) {
                        String medicalPrescription = ((PharmacistWorkRequest) pharrequest).getPrescription();
                        row[5] = medicalPrescription == null ? "" : medicalPrescription;
                    }
                    model.addRow(row);
                }
            }
        }
    }

    private void getChildDetails() {
        displayImage();
        txtName.setText(child.getName());
        txtAge.setText(String.valueOf(child.getChildAge()));
        if (child.getGender().equalsIgnoreCase("male")) {
            btnMale.setSelected(true);
        } else {
            btnFemale.setSelected(true);
        }
        txtMark.setText(child.getIdentificationMark());
        txtTemp.setText(String.valueOf(child.getBodytemp()));
        txtPulse.setText(String.valueOf(child.getPulseRate()));
        txtBP.setText(String.valueOf(child.getBP()));
        txtRR.setText(String.valueOf(child.getRespirationRate()));
        if (child.getBodytemp() == 0.0 || child.getBP() == 0.0 || child.getPulseRate() == 0.0 || child.getRespirationRate() == 0.0) {
            btnRequestTest.setEnabled(false);
            btnPrescribeMedication.setEnabled(false);
        } else {
            btnRequestTest.setEnabled(true);
            btnPrescribeMedication.setEnabled(true);
        }
        displayImage();
    }
    
    public void displayImage() {
        BufferedImage image = null; //Buffered image object
        String filename = child.getImageDetails(); //Getting the filepath and storing into the string
        try {
            image = ImageIO.read(new File(filename));  //Reading the filename and storing it in image
        } catch (Exception e) { //Generic exception if something goes wrong while reading the image
            JOptionPane.showMessageDialog(null, "File not found");
            //Setting the image to the icon and then passing it ot he image JLabel  
        }
            ImageIcon icon = new ImageIcon(image);
            lblChildPic.setIcon(icon);
        
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
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMark = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPulseRate = new javax.swing.JLabel();
        lblRespiratoryRate = new javax.swing.JLabel();
        lblBP = new javax.swing.JLabel();
        txtTemp = new javax.swing.JTextField();
        txtPulse = new javax.swing.JTextField();
        txtRR = new javax.swing.JTextField();
        txtBP = new javax.swing.JTextField();
        btnRequestTest = new javax.swing.JButton();
        btnPrescribeMedication = new javax.swing.JButton();
        ScrollPaneLabWork = new javax.swing.JScrollPane();
        tblLab = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedication = new javax.swing.JTable();
        lblLabWork = new javax.swing.JLabel();
        lblMedicationHistory = new javax.swing.JLabel();
        btnMale = new javax.swing.JRadioButton();
        btnFemale = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblChildPic = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERSONAL INFORMATION");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 350, 20));

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 120, 30));

        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAge.setText("Age");
        add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, 20));

        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGender.setText("Gender");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 130, 20));

        lblMark.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMark.setText("Identification Mark");
        add(lblMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 140, 20));

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 210, 30));

        txtMark.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(txtMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 210, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VITAL SIGNS");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 340, 20));

        lblTemp.setText("Body Temperature");
        add(lblTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 130, 20));

        lblPulseRate.setText("Pulse Rate");
        add(lblPulseRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 110, 20));

        lblRespiratoryRate.setText("Respiratory Rate");
        add(lblRespiratoryRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 120, -1));

        lblBP.setText("Blood Pressure");
        add(lblBP, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 140, 20));
        add(txtTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 160, 30));
        add(txtPulse, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 160, -1));
        add(txtRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 160, -1));
        add(txtBP, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 160, -1));

        btnRequestTest.setText("Request Lab Test");
        btnRequestTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTestActionPerformed(evt);
            }
        });
        add(btnRequestTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 150, -1));

        btnPrescribeMedication.setText("Prescribe Medication");
        btnPrescribeMedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeMedicationActionPerformed(evt);
            }
        });
        add(btnPrescribeMedication, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, 160, 30));

        tblLab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Test Requested", "Child ID", "Child Name", "Receiver", "Message", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPaneLabWork.setViewportView(tblLab);

        add(ScrollPaneLabWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 850, 90));

        tblMedication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Child ID", "Child Name", "Receiver", "Status", "Medication Prescribed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMedication);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, 850, 90));

        lblLabWork.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblLabWork.setText("Lab Work History");
        add(lblLabWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 200, 20));

        lblMedicationHistory.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblMedicationHistory.setText("Medication History");
        add(lblMedicationHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 190, -1));

        btnMale.setText("Male");
        add(btnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        btnFemale.setText("Female");
        add(btnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 120, -1));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 70, 30));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 90, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kids.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 860, 660));
        add(lblChildPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, 180));
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 210, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTestActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DoctorRequestLab", new DoctorRequestLab(userProcessContainer, userAccount, enterprise, child, childdirectory, request ,business));
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnRequestTestActionPerformed

    private void btnPrescribeMedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeMedicationActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DoctorPrescibeMedicine", new DoctorPrescibeMedicine(userProcessContainer, userAccount,  enterprise ,child, childdirectory,request ,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPrescribeMedicationActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorJPanel panel = (DoctorJPanel) component;
        panel.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (txtTemp.getText().isEmpty() || txtPulse.getText().isEmpty() || txtRR.getText().isEmpty() || txtBP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vital Signs cannot be empty");
            return;
        } else {
            try {
                temperature = Double.parseDouble(txtTemp.getText());
                if (temperature <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Body Temperature should be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Body Temperature should be numeric");
                return;
            }
            try {
                pulserate = Double.parseDouble(txtPulse.getText());
                if (pulserate <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Pulse Rate should be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Pulse Rate should be numeric");
                return;
            }
            try {
                BP = Double.parseDouble(txtBP.getText());
                if (BP <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Bloodpressure should be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Blood Pressure should be numeric");
                return;
            }
            try {
                respirationrate = Double.parseDouble(txtRR.getText());
                if (respirationrate <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Respiration rate should be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Repiration Rate should be numeric");
                return;
            }
        }
        child.setBP(BP);
        child.setBodytemp(temperature);
        child.setPulseRate(pulserate);
        child.setRespirationRate(respirationrate);
        txtTemp.setEnabled(true);
        txtPulse.setEnabled(true);
        txtBP.setEnabled(true);
        txtRR.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Vital Signs have been added.");
        btnRequestTest.setEnabled(true);
        btnPrescribeMedication.setEnabled(true);

    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPaneLabWork;
    private javax.swing.JButton btnBack;
    private javax.swing.JRadioButton btnFemale;
    private javax.swing.JRadioButton btnMale;
    private javax.swing.JButton btnPrescribeMedication;
    private javax.swing.JButton btnRequestTest;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBP;
    private javax.swing.JLabel lblChildPic;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblLabWork;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblMedicationHistory;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPulseRate;
    private javax.swing.JLabel lblRespiratoryRate;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JTable tblLab;
    private javax.swing.JTable tblMedication;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBP;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPulse;
    private javax.swing.JTextField txtRR;
    private javax.swing.JTextField txtTemp;
    // End of variables declaration//GEN-END:variables
}
