/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.HashMap;
import org.javatuples.Pair;
import org.javatuples.Triplet;

/**
 *
 * @author Vivek
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private PersonDirectory persondirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
     public enum Type{
        Admin("Admin Organization"), CarOwner("Car Owner Organization"), CarUser("Caruser Organization"), Parking("Parking Organization"),TechSupport("Technical Organization"),TechPerson("TechnicalPerson Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        
        this.name = name;
        
        workQueue = new WorkQueue();
        if(name != null){
        if(name.equals("Caruser Organization") || name.equals("Car Owner Organization"))
            persondirectory = new PersonDirectory();
        else
            employeeDirectory = new EmployeeDirectory();
        }else 
        {
        employeeDirectory = new EmployeeDirectory();
        }
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    
        public abstract ArrayList<Role> getSupportedRole();

        public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PersonDirectory getPersondirectory() {
        return persondirectory;
    }

    public void setPersondirectory(PersonDirectory persondirectory) {
        this.persondirectory = persondirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public HashMap<String,Object> getsourcedestinationBoston()
    {
     
        Pair<Double,Double> ClearwayStreet = new Pair<>(42.345293,-71.086127);
        Pair<Double,Double> BostonHarbour = new Pair<>(42.356089,-71.050341);
        Pair<Double,Double> NorthEnd = new Pair<>(42.364786,-71.053428);        
        Pair<Double,Double> WashingtonStreet = new Pair<>(42.373491,-71.065846);
        Pair<Double,Double> OliverStreet = new Pair<>(42.355884,-71.052979);
        Pair<Double,Double> Aquarium = new Pair<>(42.359697,-71.051799);
        Pair<Double,Double> FortPoint = new Pair<>(42.349647,-71.048970);
        Pair<Double,Double> StuartStreet = new Pair<>(42.349403,-71.072640);
        Pair<Double,Double> BostonCollege = new Pair<>(42.335477,-71.168516);
        Pair<Double,Double> HarvardSquare = new Pair<>(42.373675,-71.119153);
        Pair<Double,Double> CambridgeSideGalleria = new Pair<>(42.368301,-71.075151);
        Pair<Double,Double> PresenditialLibrary = new Pair<>(42.314512,-71.040506);
        Pair<Double,Double> QuencyMarket = new Pair<>(42.359657,-71.054290);
                
        HashMap<String,Object> Bostonmap = new HashMap<>();
        Bostonmap.put("Clearway Street",ClearwayStreet);
        Bostonmap.put("Boston Harbour",BostonHarbour);
        Bostonmap.put("NorthEnd",NorthEnd);
        Bostonmap.put("Washigton street",WashingtonStreet);
        Bostonmap.put("Oliver street",OliverStreet);
        Bostonmap.put("Aquarium",Aquarium);
        Bostonmap.put("Fort Point",FortPoint);
        Bostonmap.put("Stuart street",StuartStreet);
	Bostonmap.put("Boston College",BostonCollege);
        Bostonmap.put("Harvard Square",HarvardSquare);
	Bostonmap.put("CambridgeSide Galleria",CambridgeSideGalleria);
	Bostonmap.put("Presenditial Library",PresenditialLibrary);
	Bostonmap.put("Quency market",QuencyMarket);

        return Bostonmap;
    }
    
}
