import java.util.*;
import java.io.*;
public abstract class Automobile implements Vehicle{
    private double msrp;
    private String type;
    private int year;
    
    public Automobile(double msrp, String type, int year){
        this.msrp = msrp;
        this.type = type;
        this.year = year;
    }
    
    public double getMSRP(){
        return msrp;
    }
    
    public String getType(){
        return type;
    }
    
    public int getYear(){
        return year;
    }
    
    @Override
    public String getInfo(){
        return year+" "+type;     
    }
}
