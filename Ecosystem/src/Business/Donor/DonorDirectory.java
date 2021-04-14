/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kunjan
 */
public class DonorDirectory {
    List<Donor> donorsList;
    private static DonorDirectory donordirectory;
    
    public static DonorDirectory getInstance(){
       
        if(donordirectory==null){
            donordirectory=new DonorDirectory();
        }
        return donordirectory;  
    }

    public List<Donor> getDonorsList() {
        return donorsList;
    }

    public void setDonorsList(List<Donor> donorsList) {
        this.donorsList = donorsList;
    }

   
    public static DonorDirectory getDirectory() {
        return donordirectory;
    }

    public static void setDirectory(DonorDirectory directory) {
        DonorDirectory.donordirectory = directory;
    }
    
    public DonorDirectory() {
        donorsList = new ArrayList<Donor>();
    }
    
    public Donor addDonor(){
     Donor donor = new Donor();
        donorsList.add(donor);
      return donor;
    }
}
