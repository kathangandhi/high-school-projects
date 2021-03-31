import java.util.*;
public class Truck extends Vehicle{
    private int towing;
    
     public Truck(int y,String t,int tow,double p){
        super(y,t,p);
        towing = tow;
    }

    public boolean canTowBoat(){
        return (towing >= 2000);
    }
    
    @Override
    public String getInfo(){
        return getYear()+" "+getType()+", "+towing+" lbs. towing, $"+getPrice();
    }
}
