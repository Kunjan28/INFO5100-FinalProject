/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;




import Business.Enterprise.Enterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(String name,Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization(name);
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Pharmacist.getValue())){
            organization = new PharmacistOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ChildCare.getValue())){
            organization = new ChildCareOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ChildRegistration.getValue())){
            organization = new ChildRegistrationOrganization(name);
            organizationList.add(organization);
        }
       
        
        else if (type.getValue().equals(Type.CriminalCheck.getValue())){
            organization = new BackgroundAndCriminalCheckOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FinanceCheck.getValue())){
            organization = new FinanceCheckOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Adoption.getValue())){
            organization = new AdoptionOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Adopter.getValue())){
            organization = new AdopterOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Donor.getValue())){
            organization = new DonorOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FinanceOrganization.getValue())){
            organization = new FinanceOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    
}
    
     public boolean isUnique(String name){
        for(Organization organization : organizationList){
            if(name.equalsIgnoreCase(organization.getName())){
                return false;
            }
        }
        return true;
    }
    
}