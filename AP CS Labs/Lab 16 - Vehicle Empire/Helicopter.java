import java.util.*;
import java.io.*;
public class Helicopter extends Aircraft implements Leasable
{
    private boolean canShootMissiles;
    
    public Helicopter(String type, int year, double cost, int passengers, boolean canShootMissiles){
        super(cost,type,year,passengers);
        this.canShootMissiles = canShootMissiles;
    }
    
    @Override
    public double getPrice(){
        if(canShootMissiles)
            return 1.25*getCost();
        return getCost();
    }
    
    @Override
    public String getInfo(){
        String toReturn = getYear()+" "+getType()+", "+getPassengers()+" passengers, $"+getPrice();
        if(canShootMissiles)
            toReturn += "\nShoots missiles";
        else
            toReturn += "\nDoes not shoot missiles";
        
        return toReturn;
    }
    
    @Override
    public double getMonthlyPayment(){
        return getPrice()/60.0;
    }
}