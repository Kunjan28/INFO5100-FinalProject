/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FosterCare.ChildRegistrationRole;

import Business.Child.Child;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.FosterCare.ChildRegistrationRole.ViewChildTable;
import userinterface.FosterCare.ChildCare.AcquireChild;

/**
 *
 * @author 12013
 */
public class ViewChildDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewChildDetailsJPanel
     */
    JPanel userProcessContainer;
    Child child;

    public ViewChildDetailsJPanel(JPanel userProcessContainer, Child child) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.child = child;
        nameTextField.setText(child.getName());
        cmbAge.setSelectedIndex(child.getChildAge());
        if (child.getGender().equalsIgnoreCase("Male")) {
            maleRDB.setSelected(true);
        } else if (child.getGender().equalsIgnoreCase("female")) {
            femaleRDB.setSelected(true);
        }
        jXDatePicker1.setDate(child.getRegistrationDate());
        jTextArea1.setText(child.getIdentificationMark());
        imageTextField.setText(child.getImageDetails());
        displayImage();
        disableInput();
        jXDatePicker1.getMonthView().setUpperBound(new Date());
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
   imageLable.setIcon(icon);
    
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        maleRDB = new javax.swing.JRadioButton();
        femaleRDB = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        imageLable = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        lblPhoto = new javax.swing.JLabel();
        imageTextField = new javax.swing.JTextField();
        uploadBtn = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        cmbAge = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIEW CHILD DETAILS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 520, 40));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 150, 30));

        nameTextField.setEnabled(false);
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 210, 30));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Age");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 150, 30));

        buttonGroup1.add(maleRDB);
        maleRDB.setText("Male");
        maleRDB.setEnabled(false);
        add(maleRDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 120, 30));

        buttonGroup1.add(femaleRDB);
        femaleRDB.setText("Female");
        femaleRDB.setEnabled(false);
        add(femaleRDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 143, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Gender");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 150, 30));

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 133, 33));

        saveBtn.setText("Save");
        saveBtn.setEnabled(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 133, 33));

        CancelBtn.setText("Cancel");
        CancelBtn.setEnabled(false);
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });
        add(CancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 133, 33));
        add(imageLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BackIcon.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 120, 30));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Identification mark");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 150, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 230, 80));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Registration Date");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 150, 30));

        lblPhoto.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoto.setText("Photo");
        add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 150, 33));

        imageTextField.setEnabled(false);
        imageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageTextFieldActionPerformed(evt);
            }
        });
        add(imageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 210, 30));

        uploadBtn.setText("Update Photo");
        uploadBtn.setEnabled(false);
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });
        add(uploadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 114, 30));

        jXDatePicker1.setEnabled(false);
        add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/kids.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 970, 480));

        cmbAge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));
        add(cmbAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 210, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewChildTable dwjp = (ViewChildTable) component;
        dwjp.poplulateTable();
//        dwjp.populateChildRequestTable();
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        enableInput();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
       disableInput();
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            if(!validation()){
                String childName = nameTextField.getText();
                String ageString = cmbAge.getSelectedItem().toString();
                int childAge = Integer.parseInt(ageString);
                String gender = "";
                if(maleRDB.isSelected()){
                    gender = "Male";
                }
                else if(femaleRDB.isSelected()){
                    gender = "Female";
                }
                Date date = jXDatePicker1.getDate();
                DateFormat formatit = new SimpleDateFormat("yyyy-MM-dd");
                String temp = formatit.format(date);
                Date regDate = new Date();
                try {
                    regDate = formatit.parse(temp);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewChildDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                String identificationMark = jTextArea1.getText();
                
                 child.setChildAge(childAge);
                child.setChildId(child.getChildId());
                child.setName(childName);
                child.setIdentificationMark(identificationMark);
                child.setImageDetails(imageTextField.getText());
                child.setRegistrationDate(regDate);
                child.setGender(gender);
                
                
                ViewChildDetailsJPanel viewChildJpanel = new ViewChildDetailsJPanel(userProcessContainer, child);
                this.userProcessContainer.add("ViewChildDetailsJPanel", viewChildJpanel);
                CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } } catch (ParseException ex) {
            Logger.getLogger(ViewChildDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
   imageTextField.setEnabled(true);
        browseImageFile();
    }//GEN-LAST:event_uploadBtnActionPerformed

    private void imageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageTextFieldActionPerformed

private void enableInput(){
CancelBtn.setEnabled(true);
//nameTextField2.setEnabled(true);
femaleRDB.setEnabled(true);
imageLable.setEnabled(true);

btnBack.setEnabled(true);
jScrollPane1.setEnabled(true);
jTextArea1.setEnabled(true);
jXDatePicker1.setEnabled(true);
maleRDB.setEnabled(true);
nameTextField.setEnabled(true);
saveBtn.setEnabled(true);
updateBtn.setEnabled(true);
uploadBtn.setEnabled(true);
}
private void disableInput(){
    CancelBtn.setEnabled(false);
//nameTextField2.setEnabled(false);
femaleRDB.setEnabled(false);

imageTextField.setEnabled(false);

jScrollPane1.setEnabled(false);
jTextArea1.setEnabled(false);
jXDatePicker1.setEnabled(false);
maleRDB.setEnabled(false);
nameTextField.setEnabled(false);
saveBtn.setEnabled(false);
updateBtn.setEnabled(true);
uploadBtn.setEnabled(false);
}

   private String browseImageFile() {
           JFileChooser chooseFile = new JFileChooser();
        chooseFile.showOpenDialog(null);
        File file = chooseFile.getSelectedFile();
        String filePath = file.getPath();
        System.out.println(filePath);
        imageTextField.setText(filePath);
        return filePath;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbAge;
    private javax.swing.JRadioButton femaleRDB;
    private javax.swing.JLabel imageLable;
    private javax.swing.JTextField imageTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JRadioButton maleRDB;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration//GEN-END:variables

 public boolean validation() throws ParseException {
//         Date date = new Date();
      DateFormat formait = new SimpleDateFormat("yyyy/MM/dd");
      //String format = formait.format(date);
//     Date todayDate = formait.parse(format);
//     
     String selectedFormaString ="";
      try{
      Date selected = jXDatePicker1.getDate();
    selectedFormaString = formait.format(selected);
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null, "Please select the registration date");
      return true;
     }
//     Date selectedDate = formait.parse(selectedFormaString);
 
     if(nameTextField.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Please enter the name of the child");
         return true;
     }
     else if(!validateName()){
         JOptionPane.showMessageDialog(null, "Please enter the name in the correct format(No special characters)");
         return true;
     }
// pjpj    else if(ageComboBox.getSelectedIndex()==0){
//          JOptionPane.showMessageDialog(null, "Please provide the age of the child");
//         return true;
//     }
     else if(!maleRDB.isSelected()&& !femaleRDB.isSelected()){
         JOptionPane.showMessageDialog(null, "Please select the gender of the child");
         return true;
     }
//     else if(selectedDate.after(todayDate)){
//         JOptionPane.showMessageDialog(null, "Registration date cannot be before");
//         return true;
//     }
     else if(selectedFormaString.isEmpty())
     {
        JOptionPane.showMessageDialog(null, "Please select the registration date");
         return true;  
     }
     else if(jTextArea1.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Please enter the identification mark. If there are none, please write NA/None");
         return true;
     }
     else if(!validateIdentity()){
         JOptionPane.showMessageDialog(null, "No special character in identification mark");
         return true;
     }
     else if(imageTextField.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Please select the image of the child");
         return true;
     }
      
      else
       return false;
    }
    
    
    
       public boolean validateName(){
    boolean b=false;
    Pattern p = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    String name = nameTextField.getText();
    Matcher m = p.matcher(name);
    b = m.matches();
    return b;
}  

    private boolean validateIdentity() {
         boolean b=false;
    Pattern p = Pattern.compile("^[A-Za-z0-9. ]*$");
    String name = jTextArea1.getText();
    Matcher m = p.matcher(name);
    b = m.matches();
    return b;
    }

}

