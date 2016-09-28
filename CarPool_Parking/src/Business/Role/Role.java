package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vivek
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Web Admin"),
        CarOwner("Car Owner"),
        CarUser("User"),
        Parkingperson("Parking guy"),
        TechSupport("Technical Person"),
        TechSupportperson("Technition person");
        
        private String value;
        private RoleType(String value){
            JOptionPane.showMessageDialog(null, "AAAA");
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
       return this.getClass().getName();        
    }
    
}