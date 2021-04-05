package Business;

import Business.Adopter.AdopterDirectory;
import Business.Child.ChildDirectory;
import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
    public static ChildDirectory configureDirectory(){
        ChildDirectory directory = ChildDirectory.getInstance();
        return directory;
    }
    
    //returns user directory.
    public static AdopterDirectory configureUserDirectory(){
        AdopterDirectory directory = AdopterDirectory.getInstance();
        return directory;
    }
}
