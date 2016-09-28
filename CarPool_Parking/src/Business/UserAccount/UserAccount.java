/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Person.Person;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Vivek    
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private double payment;
    private int trips;

    public UserAccount() {
        workQueue = new WorkQueue();
        trips=0;
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getTrips() {
        return trips;
    }

    public void setTrips(boolean tripxs) {
        int history = getTrips();
        if(tripxs){
            history++;
            trips = history;
        }
        else
        {
            history--;
            trips = history;
        }
    }

    
    @Override
    public String toString() {
        return username;
    }
    
    
}