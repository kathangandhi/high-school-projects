import java.util.*;
public class Player{
    private ArrayList<Item> inventory;
    private Room room;
    
    public Player(Room currentRoom){
        inventory = new ArrayList<Item>();
        room = currentRoom;
    }
    
    public void setRoom(Room newRoom){
        room = newRoom;
    }
    
    public Room getRoom(){
        return room;
    }
    
    public void addItem(Item tool){
        inventory.add(tool);
    }
    
    public boolean inventoryHas(Item tool){
        return inventory.contains(tool);
    }
}
