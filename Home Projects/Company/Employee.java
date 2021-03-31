import java.util.*;
public class Employee{
    private Information stats;
    private int workHours;
    private double salary;
    private String role;
    
    public Employee(Information stats, int workHours, double salary, String role){
        this.workHours = workHours;
        this.salary = salary;
        this.stats = stats;
        this.role = role;
    }
    
    public void addBonus(double bonus){
        salary += bonus;
    }
    
    @Override
    public String toString(){
        String toReturn = new String();
        toReturn += "Biometrics: \n"+stats.toString();
        toReturn += "\nRole: "+role;
        toReturn += "\nWork Hours: "+workHours+" Salary: $"+salary+"\n\n";
        return toReturn;
    }
}
