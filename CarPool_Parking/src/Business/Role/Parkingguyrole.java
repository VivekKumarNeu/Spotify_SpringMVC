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
import Interface.Parking.ParkingMainJPanel;
import Interface.Parking.ParkingWorkRequestJPanel;
import Interface.Parking.inofficeparingJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public class Parkingguyrole extends Role {
    
      @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
      //  return new ParkingWorkRequestJPanel(userProcessContainer, account,organization);
    
       // for new enterprise
        return new ParkingWorkRequestJPanel(userProcessContainer, account, null,enterprise,system);
    }
}
