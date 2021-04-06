/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;




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
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Pharmacist.getValue())){
            organization = new PharmacistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ChildCare.getValue())){
            organization = new ChildCareOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ChildRegistration.getValue())){
            organization = new ChildRegistrationOrganization();
            organizationList.add(organization);
        }
       
        
        else if (type.getValue().equals(Type.CriminalCheck.getValue())){
            organization = new BackgroundAndCriminalCheckOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FinanceCheck.getValue())){
            organization = new FinanceCheckOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Adoption.getValue())){
            organization = new AdoptionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Adopter.getValue())){
            organization = new AdopterOrganization();
            organizationList.add(organization);
        }
        return organization;
    
}
    
}