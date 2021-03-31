import java.util.*;
public class Inventory{
    private ArrayList<Vehicle> vehicles;

    public Inventory(){
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public void listInventory(){
        for(Vehicle v: vehicles){
            System.out.println(v.getInfo());
        }
    }
}