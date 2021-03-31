import java.util.*;
import java.io.*;

public class Tombstone{
    //attributes of the tombstone representing a deceased person
    String name;
    String burialDate; 
    double age;
    String address;
    
    /**
     * Tombstone contstructor to initialise attributes of the deceased person
     * @param name name of person
     * @param age age of person
     * @param burialDate the date the person was buried
     * @param address the used-to-be address of the person
     */
    public Tombstone(String name, String burialDate, double age, String address){
        this.name = name;
        this.burialDate = burialDate;
        this.age = age;
        this.address = address;
    }

    //getter and setter methods
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public String getDate(){
        return burialDate;
    }
    
    public void setDate(String d){
        burialDate = d;
    }
    
    public double getAge(){
        return age;
    }
    
    public void setAge(int a){
        age = a;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String a){
        address = a;
    }
}
