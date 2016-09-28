/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Organization.Organization;
import Business.Role.SystemAdminRole;
import Business.Role.TechnicalRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class ConfigureSystem {
 
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("carpool", "carpool", employee, null,new SystemAdminRole());
        
        return system;
    }
    
    
}
