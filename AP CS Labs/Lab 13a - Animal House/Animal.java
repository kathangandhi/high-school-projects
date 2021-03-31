import java.util.*;
public class Animal{
    private String name;
    private int birthYear;
    private Animal friend;
    private ArrayList<Toy> toys;
    private static int currentYear;
   
    public Animal(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
        toys = new ArrayList<Toy>();
        currentYear = 2017;
    }
    
    public void addToy(Toy newToy){
        toys.add(newToy);
    }
    
    public void setFriend(Animal other){
        friend = other;
    }
    
    public ArrayList<Toy> getToys(){
        return toys;
    }
    
    public int getAge(){
        return currentYear-birthYear;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        String returner = "Hello, I am "+name+". I am "+getAge()+" years old.";
        if(friend!=null)
            returner += "\nI have a friend named "+friend.getName();
        else
            returner += "\nI have no friends";
        returner += "\nI have the following toys: "+toys.toString();   
        
        return returner;
    }
}
