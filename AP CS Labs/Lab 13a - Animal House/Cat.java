import java.util.*;
public class Cat extends Animal{
    private int numLives;
    
    public Cat(String name, int birthYear, int numLives){
        super(name,birthYear);
        this.numLives = numLives;
    }
    
    public Cat(String name, int age){
        this(name, age, 9);
    }
    
    public int getLives(){
        return numLives;
    }
    
    @Override
    public String toString(){
        String returner = "";
        returner += super.toString();
        returner += "\nI have "+this.getLives()+" lives.";
        return returner;
    }
}
