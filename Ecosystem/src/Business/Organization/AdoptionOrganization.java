/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.AdoptionRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Kunjan
 */
public class AdoptionOrganization extends Organization{

    public AdoptionOrganization() {
         super(Organization.Type.Adoption.getValue());
    
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdoptionRole());
        return roles;
    }
    
}




   
    