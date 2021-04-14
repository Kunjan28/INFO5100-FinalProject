/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;

/**
 *
 * @author Kunjan
 */
public class AdoptionAdminRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory,DonorDirectory donorDirectory) {
        return new AdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business, directory, udirectory,donorDirectory);
    }
    
    @Override
    public String toString(){
        return (RoleType.AdoptionAdmin.getValue());
    }

}
