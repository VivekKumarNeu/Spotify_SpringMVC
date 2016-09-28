/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }
    
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

     public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.CarOwner.getValue())){
            organization = new CarownerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.CarUser.getValue())){
            organization = new CarUserOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Parking.getValue())){
            organization = new ParkingOrganization();
            organizationList.add(organization);        
        }
        else if (type.getValue().equals(Organization.Type.TechSupport.getValue())){
            organization = new TechnicalOrganization();
            organizationList.add(organization);        
        }
        else if (type.getValue().equals(Organization.Type.Admin.getValue())){
            organization = new ApplicationAdminOrganization();
            organizationList.add(organization);        
        } else if (type.getValue().equals(Organization.Type.TechPerson.getValue())){
            organization = new TechnicalPersonOrganization();
            organizationList.add(organization);        
        }
        return organization;
    
    
     }   
}
