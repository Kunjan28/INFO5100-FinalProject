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
import Business.Organization.Organization;
//pjpjp import Business.Organization.Orphanage.ChildCareOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.EducationalHelpWorkRequest;
//pjpj import Business.WorkQueue.DoctorWorkRequest;
//pjpj import Business.WorkQueue.FinanceCCWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 12013
 */
public class ViewCompleteChildDetails extends javax.swing.JPanel {

    /**
     * Creates new form ViewCompleteChildDetails
     */
    JPanel userProcessContainer;
    Child child;
   UserAccount account;
    ChildCareOrganization organization;
   Enterprise enterprise;
   EcoSystem business;
   ChildDirectory directory;
       Network network;
	
    ViewCompleteChildDetails(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, Child child) {
          initComponents();
        this.userProcessContainer=userProcessContainer;
        this.child = child;
        this.account=account;
        this.organization=(ChildCareOrganization) organization;
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
        disableInput();
         nameTextField.setText(child.getName());
//        ageComboBox.setSelectedIndex(child.getChildAge());
//pjpj        txtDOB.setText(child.getChildAge());
        if(child.getGender().equalsIgnoreCase("Male")){
            maleRDB.setSelected(true);
        }
        else if(child.getGender().equalsIgnoreCase("female")){
            femaleRDB.setSelected(true);
        }
        jXDatePicker1.setDate(child.getRegistrationDate());
        txtMark.setText(child.getIdentificationMark());
        bpText.setText(String.valueOf(child.getBP()));
        pulseText.setText(String.valueOf(child.getPulseRate()));
        tempText.setText(String.valueOf(child.getBodytemp()));
        respRateText.setText(String.valueOf(child.getRespirationRate()));
        medicalTextArea.setText(child.getMedicalStatus());
       // imageTextField.setText(child.getImageDetails());
        displayImage();
        populaterequestTable();
     
        btnRequestFunds.setEnabled(!child.isFinancialHelp());
        requestMedicalHelpBtn.setEnabled(!child.isMedicalHelp());
        
        
        
    }
    public void displayImage(){
        BufferedImage image = null; //Buffered image object
        String filename = child.getImageDetails(); //Getting the filepath and storing into the string
        
        
        try{
            image = ImageIO.read(new File(filename));  //Reading the filename and storing it in image
        }catch(Exception e){ //Generic exception if something goes wrong while reading the image
            JOptionPane.showMessageDialog(null, "File not found");
        }
       
  //Setting the image to the icon and then passing it ot he image JLabel    
  
ImageIcon icon = new ImageIcon(image);
   lblPic.setIcon(icon);
    
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        buttonGroup1 = new javax.swing.ButtonGroup();
        nameTextField = new javax.swing.JTextField();
        lblDOB = new javax.swing.JLabel();
        maleRDB = new javax.swing.JRadioButton();
        femaleRDB = new javax.swing.JRadioButton();
        lblGender = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        lblPic = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblPersonalInfo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMedicalInfo = new javax.swing.JLabel();
        tempText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        respRateText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicalTextArea = new javax.swing.JTextArea();
        lblRegistDate = new javax.swing.JLabel();
        lblIdenMark = new javax.swing.JLabel();
        btnRequestFunds = new javax.swing.JButton();
        requestMedicalHelpBtn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblBP = new javax.swing.JLabel();
        bpText = new javax.swing.JTextField();
        lblPulse = new javax.swing.JLabel();
        pulseText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        txtDOB = new javax.swing.JTextField();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        txtMark = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 190, 30));

        lblDOB.setText("Age");
        add(lblDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 100, 30));

        maleRDB.setText("Male");
        maleRDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRDBActionPerformed(evt);
            }
        });
        add(maleRDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, -1, -1));

        femaleRDB.setText("Female");
        add(femaleRDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 100, 50));

        lblGender.setText("Gender");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 130, 30));

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("View Child Details");
        add(lblHeading, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 223, 40));
        add(lblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 180));

        lblName.setText("Name");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 110, 30));

        lblPersonalInfo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblPersonalInfo.setText("Personal Info");
        add(lblPersonalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 121, 20));

        jLabel7.setText("Temperature");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 27));

        lblMedicalInfo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMedicalInfo.setText("Medical Info");
        add(lblMedicalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 143, -1));

        tempText.setMinimumSize(new java.awt.Dimension(50, 50));
        add(tempText, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 190, 30));

        jLabel9.setText("Respiration Rate");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, 27));

        respRateText.setMinimumSize(new java.awt.Dimension(50, 50));
        add(respRateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 190, -1));

        jLabel10.setText("Medical History:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, -1, 25));

        medicalTextArea.setColumns(20);
        medicalTextArea.setRows(5);
        jScrollPane1.setViewportView(medicalTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 370, 90));

        lblRegistDate.setText("Registration Date");
        add(lblRegistDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 130, 30));

        lblIdenMark.setText("Identification mark");
        add(lblIdenMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 130, 30));

        btnRequestFunds.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnRequestFunds.setText("Request Funds");
        btnRequestFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestFundsActionPerformed(evt);
            }
        });
        add(btnRequestFunds, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 740, 180, 30));

        requestMedicalHelpBtn.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        requestMedicalHelpBtn.setText("Request Medical Help");
        requestMedicalHelpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedicalHelpBtnActionPerformed(evt);
            }
        });
        add(requestMedicalHelpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 740, 180, 30));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackIcon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 40, 30));

        lblBP.setText("Blood Pressure");
        add(lblBP, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 100, 30));

        bpText.setMinimumSize(new java.awt.Dimension(50, 50));
        add(bpText, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, 190, -1));

        lblPulse.setText("Pulse Rate");
        add(lblPulse, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, -1, 27));

        pulseText.setMinimumSize(new java.awt.Dimension(50, 50));
        add(pulseText, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 190, -1));

        tblRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Child Id", "Sender", "Receiver", "Result", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblRequest);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, 890, 104));
        add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 190, 30));
        add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 190, 30));
        add(txtMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/kids5.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 1010, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewChildDetails dwjp = (ViewChildDetails) component;
        dwjp.populateChildTable();
        //dwjp.populateWorkRequest();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void requestMedicalHelpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedicalHelpBtnActionPerformed
     RequestMedicalHelp rqmh = new RequestMedicalHelp(userProcessContainer, account, organization, enterprise, business, directory, child);
     this.userProcessContainer.add("RequestMedicalHelp", rqmh);
     CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
     layout.next(userProcessContainer);
    }//GEN-LAST:event_requestMedicalHelpBtnActionPerformed

    private void btnRequestFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestFundsActionPerformed
         
       String data = "";
       
       
        //System.out.println("date:"+data);
        RequestFinanceHelp rfhp = new RequestFinanceHelp(userProcessContainer,  account,  organization,  enterprise,  business,  directory, child, data);
       this.userProcessContainer.add("RequestFinanceHelp", rfhp);
       CardLayout layout = (CardLayout)userProcessContainer.getLayout();
       layout.next(userProcessContainer);
       
       
       
    }//GEN-LAST:event_btnRequestFundsActionPerformed

    private void maleRDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRDBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpText;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestFunds;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton femaleRDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblBP;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblIdenMark;
    private javax.swing.JLabel lblMedicalInfo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPersonalInfo;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblPulse;
    private javax.swing.JLabel lblRegistDate;
    private javax.swing.JRadioButton maleRDB;
    private javax.swing.JTextArea medicalTextArea;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField pulseText;
    private javax.swing.JButton requestMedicalHelpBtn;
    private javax.swing.JTextField respRateText;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField tempText;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtMark;
    // End of variables declaration//GEN-END:variables

    public void disableInput(){
      txtDOB.setEnabled(false);
    femaleRDB.setEnabled(false);
      bpText.setEnabled(false);
      txtMark.setEnabled(false);
      jXDatePicker1.setEnabled(false);
      maleRDB.setEnabled(false);
      medicalTextArea.setEnabled(false);
      nameTextField.setEnabled(false);
    pulseText.setEnabled(false);
    
    respRateText.setEnabled(false);
    
    tempText.setEnabled(false);
    }
    
    public void populaterequestTable() {
        DefaultTableModel dtms = (DefaultTableModel) tblRequest.getModel();
        dtms.setRowCount(0);
        
        for(WorkRequest request: account.getWorkQueue().getWorkRequestList()){
           if(request.getChildId()==child.getChildId()){
               System.out.println(child.getMedicalStatus());
            Object[] row = new Object[dtms.getColumnCount()];
           row[0]=request;
           row[1]=request.getChildId();
           row[2]=request.getSender();
           row[3]=request.getReceiver();
           if(request instanceof DoctorWorkRequest){
             String result = ((DoctorWorkRequest) request).getTestResult();
            String remarks = ((DoctorWorkRequest) request).getRemarks();
             row[5]=remarks;
            row[4] = result == null ? "Waiting" : result;
           }
           if(request instanceof EducationalHelpWorkRequest) {
               row[4] = request.getStatus();
               row[5] = ((EducationalHelpWorkRequest) request).getRemarks();
           }
           dtms.addRow(row);
           }
        }
    }
}
