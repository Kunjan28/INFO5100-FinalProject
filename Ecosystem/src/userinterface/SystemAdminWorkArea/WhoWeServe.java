/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Child.Child;
import Business.EcoSystem;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Kunjan
 */
public class WhoWeServe extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem system;
    JFreeChart barChart;
    public WhoWeServe(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateBarGraphByGender();
        populateBarGraphByAge();
         populateBarGraphBySpecialNeed();
    }

     public void populateBarGraphByGender() {
 
        Map<String, Integer> hMap = new HashMap<>();
        
        int femaleCount = 0;
        int maleCount = 0;
        for(Child child:system.getDirectory().getChildList()) {
            if("Female".equalsIgnoreCase(child.getGender())){
                hMap.put("Female",femaleCount+1);
            }
            else{
                hMap.put("Male",maleCount+1);
            }
        }

        barChart = ChartFactory.createPieChart(
         "By Gender",                     
         createDataset(hMap),          
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );   
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
        /*chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel );*/ 
        
    }
     
     public void populateBarGraphByAge() {
        Map<String, Integer> hMap = new HashMap<>();
        
        int ageGrp1 = 0;
        int ageGrp2 = 0;
        int ageGrp3 = 0;
        for(Child child:system.getDirectory().getChildList()) {
            if(child.getChildAge()>=0 && child.getChildAge()<=5){
                hMap.put("AGES 0-5",ageGrp1+1);
            }
            else if(child.getChildAge()>5 && child.getChildAge()<=13){
                hMap.put("AGES 6-13",ageGrp2+1);
            }
            else {
                hMap.put("AGES 14-18",ageGrp3+1);
            }
        }
           
        
      
        barChart = ChartFactory.createPieChart(
         "By Age",                     
         createDataset(hMap),          
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );   
        jPanel3.removeAll();
        jPanel3.add(chartPanel, BorderLayout.CENTER);
        jPanel3.validate();
        /*chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel );*/ 
        
    }
     
    public void populateBarGraphBySpecialNeed() {
 
        Map<String, Integer> hMap = new HashMap<>();
        
        int yes = 0;
        int no = 0;
        for(Child child:system.getDirectory().getChildList()) {
            if(child.isIsSpecialChild()){
                hMap.put("Special Child",yes+1);
            }
            else{
                hMap.put("Normal Child",no+1);
            }
        }
           
        
      
        barChart = ChartFactory.createPieChart(
         "By Special Needs",                     
         createDataset(hMap),          
         true, true, false);
         
        ChartPanel chartPanel = new ChartPanel( barChart );   
        jPanel2.removeAll();
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.validate();
        /*chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
        setContentPane( chartPanel );*/ 
        
    }
    
    private PieDataset createDataset(Map<String, Integer> workReqMap) {
       
        final DefaultPieDataset dataset = new DefaultPieDataset();  

        for(String r : workReqMap.keySet()) {
            dataset.setValue(r, workReqMap.get(r));
        }               

        return dataset; 
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, 610));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 310, 610));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 600));
        jPanel3.setLayout(new java.awt.BorderLayout());
        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 310, 610));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("                                Who We Serve");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 525, 54));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
