/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        IncidentUnitManager("Rescue Manager"),
        EmergencyUnitAdmin("Help Center Admin"),
        VoluntaryUnitAdmin("Unit Reporting Admin"),
        SceneManager("Voluntary Member"),
        PoliceHead("Adoption Center Head"),
        FireSafetyHead("Food Services Admin"),
        MedicalAgencyHead("Vet Supervisor"),
        PersonalAdmin("User Admin"),
        ReportingAdmin("Rescue Team Admin"),
        FireFighter("mm"),
        DisasterHead("Voluntary Head");
      
        
        
        private String value;
        private RoleType(String value){
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
            Network network,
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}