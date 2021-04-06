/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Adopter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunjan
 */
public class AdopterDirectory {
    List<Adopter> adoptersList;
    private static AdopterDirectory udirectory;
    
    public static AdopterDirectory getInstance(){
       
        if(udirectory==null){
            udirectory=new AdopterDirectory();
        }
        return udirectory;  
    }

    public List<Adopter> getAdoptersList() {
        return adoptersList;
    }

    public void setAdoptersList(List<Adopter> adoptersList) {
        this.adoptersList = adoptersList;
    }

    public static AdopterDirectory getDirectory() {
        return udirectory;
    }

    public static void setDirectory(AdopterDirectory directory) {
        AdopterDirectory.udirectory = directory;
    }
    
    public AdopterDirectory() {
        adoptersList = new ArrayList<Adopter>();
    }
    
    public Adopter addAdopter(){
     Adopter adopter = new Adopter();
        adoptersList.add(adopter);
      return adopter;
    }
}
