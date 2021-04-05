/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
         private ChildDirectory directory;
         private AdopterDirectory adirectory;
//
//    public ChildDirectory getDirectory() {
//        return directory;
//    }
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
     //  directory = new ChildDirectory();
       //adirectory = new AdopterDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
//
//     public ChildDirectory getDirectory() {
//        return directory;
//    }
//
//    public AdopterDirectory getAdirectory() {
//        return adirectory;
//    }
//    
     
    @Override
    public String toString(){
        return name;
    }
    
}
