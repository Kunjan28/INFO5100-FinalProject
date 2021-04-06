/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;



import Business.Role.ChildCareRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Kunjan
 */
public class ChildCareOrganization extends Organization {

  
    public ChildCareOrganization() {
       super(Organization.Type.ChildCare.getValue());
      
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ChildCareRole());
        return roles;
    }
    
  
     
}
