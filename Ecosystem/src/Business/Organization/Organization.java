/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Employee.EmployeeDirectory;

import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
  //  private ChildDirectory directory; // Added the child directory as the child data is manipulated at the organization level
    private int organizationID;
    private static int counter=0;
    
     public enum Type{
        Admin("Admin Organization"), Doctor("Doctor Organization"), Lab("Lab Organization"),Pharmacist("Pharmacy Organization"),
        OrphanageAdmin("Orphanage Admin Organization"), ChildCare("Child Care Organization"), ChildRegistration("Child Registeration Organization"), FinanceOrphanage ("Finance Organization"),
        AdoptionAdmin("Adoption Admin Organization"), Adoption("Adoption Organization"), CriminalCheck("Criminal Check Organization"), FinanceCheck("Finance Check Organization"),Adopter("Adopter Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory(); 
        //directory = new ChildDirectory(); // Creating a new directory during the call to the constructor
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

//    public ChildDirectory getChildDirectory() { //Child directory getter
//        return directory;
//    }

   

   
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
