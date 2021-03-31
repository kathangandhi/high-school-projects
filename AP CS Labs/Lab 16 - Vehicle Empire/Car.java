import java.util.*;
import java.io.*;
public class Car extends Automobile{
    private double mpg;
    
    public Car(String type, int year, double msrp, double mpg){
        super(msrp,type,year);
        this.mpg = mpg;
    }
    
    @Override
    public double getPrice(){
        if(mpg >= 30.0)
            return 0.9*super.getMSRP();
        return super.getMSRP();
    }
    
    @Override
    public String getInfo(){
        return getYear()+" "+getType()+", "+mpg+" mpg, $"+getPrice();
    }
}
