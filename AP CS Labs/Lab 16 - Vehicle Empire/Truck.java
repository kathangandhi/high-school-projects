import java.util.*;
import java.io.*;
public class Truck extends Automobile{
    private int towing;
    
    public Truck(String type, int year, double msrp, int towing){
        super(msrp,type,year);
        this.towing = towing;
    }
    
    @Override
    public double getPrice(){
        if(towing >= 5000)
            return 0.85*super.getMSRP();
        return super.getMSRP();
    }
    
    @Override
    public String getInfo(){
        return getYear()+" "+getType()+", "+towing+" lbs. towing, $"+getPrice();
    }
}
