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
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Donor.DonorChildSelectionJPanel;
;

/**
 *
 * @author Kunjan
 */
public class DonorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectorDirectory,DonorDirectory donorDirectory) {
        return new DonorChildSelectionJPanel(userProcessContainer, account, organization,enterprise, business,udirectorDirectory,directory,donorDirectory);
    }
    
}
