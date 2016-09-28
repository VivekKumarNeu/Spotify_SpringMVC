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
import Interface.TechSupport.TechSupportMainJPanel;
import Interface.Webadminworkarea.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public class TechnicalpersonRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business) {
        return new TechSupportMainJPanel(userProcessContainer,account,organization,enterprise);
    }
}
