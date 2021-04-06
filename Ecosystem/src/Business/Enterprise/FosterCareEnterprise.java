/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Kunjan
 */
public class FosterCareEnterprise extends Enterprise{

    public FosterCareEnterprise(String name) {
        super(name, EnterpriseType.FosterCare); //Enterprise type is orphanage
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
