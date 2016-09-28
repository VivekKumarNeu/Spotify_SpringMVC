/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.CarOwner.CarOwnerMenuPageJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public class CarOwnerRole extends Role{
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        //return new MenuPageJPanel(userProcessContainer, system);
        return new CarOwnerMenuPageJPanel(userProcessContainer,account,organization,enterprise,system);
        
    }
    
}
