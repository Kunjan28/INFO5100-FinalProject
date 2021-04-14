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
import userinterface.Adoption.FinanceCheck.FinanceWorkArea;


/**
 *
 * @author Kunjan
 */
public class FinanceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory, AdopterDirectory udirectory,DonorDirectory donorDirectory) {
        return new FinanceWorkArea(userProcessContainer,account, organization, enterprise,  business,  udirectory);
    }
    
    @Override
    public String toString(){
        return (RoleType.FinanceCheck.getValue());
    }
}
