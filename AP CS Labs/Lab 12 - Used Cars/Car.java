import java.util.*;
public class Car extends Vehicle{
    private double mpg;
    
     public Car(int y,String t,double m,double p){
        super(y,t,p);
        mpg = m;
    }
    
    
    public boolean greatGasMileage(){
        return (mpg >= 36);
    }
    
    @Override
    public String getInfo(){
        return getYear()+" "+getType()+", "+mpg+" mpg, $"+getPrice();
    }
}
