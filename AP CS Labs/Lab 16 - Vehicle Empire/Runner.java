import static java.lang.System.out;
import java.util.*;
public class Runner
{
    public static void main(String[] args)
    {
        List<Vehicle> list = new ArrayList<Vehicle>();
        
        list.add(new Car("Honda Civic", 2000, 9000, 32.0));
        list.add(new Truck("Chevy Silverado", 2013, 17000, 2500));
        list.add(new Airplane("Cessna 206", 1997, 400000, 6, true));
        
        Helicopter helicopter = new Helicopter("Bell 206L", 1986, 660000, 7, false);
        
        list.add(helicopter);

        for (Vehicle v : list)
            out.println(v.getInfo() + "\n");
            
        out.println("Helicopter monthly payment >>> $" + helicopter.getMonthlyPayment());
    }
}