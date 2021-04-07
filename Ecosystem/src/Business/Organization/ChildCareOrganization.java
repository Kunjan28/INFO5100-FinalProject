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

  String name;
    public ChildCareOrganization(String name) {
        super(name);
        this.name=name;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ChildCareRole());
        return roles;
    }
    
     @Override
    public Type getType() {
        return  Organization.Type.ChildCare;
    }
     
    
  
     
}
