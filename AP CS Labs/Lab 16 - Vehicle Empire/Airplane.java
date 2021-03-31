import java.util.*;
import java.io.*;
public class Airplane extends Aircraft
{
    private boolean hasFirstClass;
    
    public Airplane(String type, int year, double cost, int passengers, boolean hasFirstClass){
        super(cost,type,year,passengers);
        this.hasFirstClass = hasFirstClass;
    }
    
    @Override
    public double getPrice(){
        if(hasFirstClass)
            return 1.1*getCost();
        return getCost();
    }
    
    @Override
    public String getInfo(){
        String toReturn = getYear()+" "+getType()+", "+getPassengers()+" passengers, $"+getPrice();
        if(hasFirstClass)
            toReturn += "\nHas first class";
        else
            toReturn += "\nNo first class";
        
        return toReturn;
    }
}
