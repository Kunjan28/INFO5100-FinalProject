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
import Business.Organization.PharmacistOrganization;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PharmacyOrganisation.PharmacyWorkArea;


/**
 *
 * @author Kunjan
 */
public class PharmacistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory childdirectory, AdopterDirectory adopterdirectory,DonorDirectory donorDirectory) {
       return new PharmacyWorkArea(userProcessContainer, account, (PharmacistOrganization)organization,enterprise, business,childdirectory);
    }
    
    @Override
    public String toString(){
        return (RoleType.Pharmacist.getValue());
    }
    
}
