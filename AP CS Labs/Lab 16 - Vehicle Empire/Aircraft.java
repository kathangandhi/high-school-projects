import java.util.*;
import java.io.*;
public abstract class Aircraft implements Vehicle{
    private double cost;
    private String type;
    private int year;
    private int passengers;
    
    public Aircraft(double cost, String type, int year, int passengers){
        this.cost = cost;
        this.type = type;
        this.year = year;
        this.passengers = passengers;
    }
    
    public double getCost(){
        return cost;
    }
    
    public String getType(){
        return type;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getPassengers(){
        return passengers;
    }
    
    @Override
    public String getInfo(){
        return year+" "+type+", "+passengers+" passengers";
    }
}
