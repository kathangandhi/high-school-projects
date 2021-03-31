import java.util.*;
public class Item{
    private String description;
    private String ability;
    private String chant;
    
    public Item(String desc, String ab, String access){
        description = desc;
        ability = ab;
        chant = access;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getAbility(){
        return ability;
    }
    
    public String getChant(){
        return chant;
    }
}
