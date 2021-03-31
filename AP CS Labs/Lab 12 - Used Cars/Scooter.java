import java.util.*;
public class Scooter extends Vehicle{
    private int traction;

    public Scooter(int y,String t,int tr,double p){
        super(y,t,p);
        traction = tr;
    }
    
    @Override
    public String getInfo(){
        return getYear()+" "+getType()+", "+traction+" traction, $"+getPrice();
    }
}
