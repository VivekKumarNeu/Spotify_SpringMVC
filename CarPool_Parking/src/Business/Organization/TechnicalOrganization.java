/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TechnicalRole;
import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class TechnicalOrganization extends Organization{
    
     public TechnicalOrganization() {
        super(Organization.Type.TechSupport.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TechnicalRole());
        return roles;
    }   
    
}
