import java.util.*;
public class Toy{
    private String name;
    
    public Toy(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "A "+this.getName();
    }
    
    @Override
    public boolean equals(Object obj){
        Toy other = (Toy) obj;
        return this.name.equals(other.getName());
    }
}
