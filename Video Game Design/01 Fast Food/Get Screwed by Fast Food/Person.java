import java.util.*;

/**
 * Person represents the player, his/her attributes, and his/her actions
 *
 * @author Kathan Gandhi
 * @version 08/21/2019
 */
public class Person{
    private String name;
    private int calLevel;
    private double money;
    private int[] calRange;
    private Menu m;

    public Person(String name, Menu m){
        this.name = name;
        this.calLevel = 2500;
        this.money = 75;

        this.calRange = new int[2];
        this.calRange[0] = (2500-150) - (int)Math.round(Math.random()*150);
        this.calRange[1] = (2500+150) + (int)Math.round(Math.random()*150);

        this.m = m;
    }

    public String getName(){
        return this.name;
    }

    public int getCalLevel(){
        return this.calLevel;
    }
    
    public int[] getCalRange(){
        return this.calRange;
    }

    public double getMoney(){
        return this.money;
    }
    
    public void addMoney(){
        this.money += 60;
    }

    public boolean didPersonLose(){
        if(this.money <= 0)
            return true;
        if(calLevel >= calRange[0] && calLevel <= calRange[1])
            return false;
        return true;
    }

    public void makeChoice(int choice){
        Food eat = m.getAvailable().get(choice-1);
        this.calLevel += eat.getCal();
        this.money -= eat.getPrice(); 
    }

    public ArrayList<Food> getMenu(){
        return m.makeAvailable();
    }

    public void burnCal(){
        this.calLevel -= 250+(int)(Math.random()*100);
    }

    public String toString(){
        String toReturn = name+": \nCalorie Range: "+Arrays.toString(calRange);
        toReturn += "\nCalorie Level: "+calLevel+"\nMoney: "+money; 
        return toReturn;
    }
}
