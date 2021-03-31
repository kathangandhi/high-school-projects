import java.util.*;
public class Room 
{
    private String description; 
    private HashMap<String, Room> exits;
    private Item item;
    
    public Room(String desc,Item it){
        description = desc;
        exits = new HashMap<>();
        item = it;
    }
    
    /**
     * Initializes the exits for this room object
     * 
     * The Room parameter should be passed in as null if there is no exit in that direction
     */
    public void setExits(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    
    /** Return a String showing all the possible exits a Room has */
    public String getExitString(){
        String result = "   Exits >>> ";        
        Set<String> keys = exits.keySet();//Set must be imported, in java.util package        
        
        for (String exit : keys) {          
            result += " " + exit;
        }         
        
        if(item != null)
            result += "\n   Item >>> "+item.getDescription()+" that can "+item.getAbility();
        
        return result;
    }
    
    public String getDescription() { return description;}
    
    public Item getItem() {return item;}
    
    public Room getExit(String direction){
        return exits.get(direction);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        Room other = (Room) obj;
        return this.description.equals(other.getDescription());
    }
}
