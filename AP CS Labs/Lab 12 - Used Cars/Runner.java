import java.util.*;
public class Runner{
    public static void main(String args[]){
        Car honda = new Car(2017,"Honda CR-V",32.0,25999.9);
        Truck ford = new Truck(2012,"Ford F-150",3000,12999.9);
        Scooter harley = new Scooter(2016,"Harley Davidson Pride",250,18999.9);
        
        Inventory i = new Inventory();
        i.addVehicle(honda);
        i.addVehicle(ford);
        i.addVehicle(harley);
        
        i.listInventory();
    }
}
