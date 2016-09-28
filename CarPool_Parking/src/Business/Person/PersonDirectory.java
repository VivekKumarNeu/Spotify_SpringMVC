/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Vivek
 */
public class PersonDirectory {
 
    public ArrayList<Person> personList;
    
    public PersonDirectory(){
    personList = new ArrayList<>();
    }
    
    public Person createPerson(String name,String gen,long phonenumber,String address,int amount){
        Person person = new Person();
        person.setPersonName(name);
        person.setGender(gen);
        person.setPonenumber(phonenumber);
        person.setAddress(address);
        person.setAmount(amount);
        personList.add(person);
        return person;
    }
    
}
