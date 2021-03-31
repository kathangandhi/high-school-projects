import java.util.*;
public class Vehicle{
    private String type;
    private int year;
    private double price;
    
    public Vehicle(int y,String t,double p){
        year = y;
        type = t;
        price = p;
    }
    
    public String getType(){
        return type;
    }
    
    public int getYear(){
        return year;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getInfo(){
        return year+" "+type;
    }
}
