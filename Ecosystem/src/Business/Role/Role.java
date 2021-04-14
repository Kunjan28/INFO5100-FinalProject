/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.Donor.DonorDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        ChildCare("Child Care"),
        FosterCare("Foster Care Admin"),
        ChildRegistration("Child Registeration Organization"), 
        Finance ("Finance Organization"),
        AdoptionAdmin("Adoption Admin Organization"), 
        Adoption("Adoption Organization"), 
        Adopter("Adopter Organization"),
        CriminalCheck("Criminal Check Organization"),
        FinanceCheck("Finance Check Organization"),
        Pharmacist("Pharmacy Organization"),
        Donor("Donor Organization");
        
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory,DonorDirectory donorDirectory);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}