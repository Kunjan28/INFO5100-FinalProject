/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacistOrganization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.PharmacyOrganisation.PharmacistJPanel;
import userinterface.labOrganisation.LabJPanel;

/**
 *
 * @author raunak
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ChildDirectory directory,AdopterDirectory udirectorDirectory) {
        //return null;
    return new LabJPanel(userProcessContainer, account, organization, business);
    }
    
    @Override
    public String toString(){
        return (RoleType.LabAssistant.getValue());
    }
     
}
