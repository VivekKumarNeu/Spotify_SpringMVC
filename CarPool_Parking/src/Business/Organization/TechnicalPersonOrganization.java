/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TechnicalRole;
import Business.Role.TechnicalpersonRole;
import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class TechnicalPersonOrganization extends Organization{
    
    
     public TechnicalPersonOrganization() {
        super(Organization.Type.TechPerson.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TechnicalpersonRole());
        return roles;
    }   
    
}
