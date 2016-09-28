/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ApplicationAdminRole;
import Business.Role.CarUserRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class ApplicationAdminOrganization extends Organization{
    
        public ApplicationAdminOrganization() {
        super(Organization.Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ApplicationAdminRole());
        return roles;
    } 

}
