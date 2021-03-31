
/**
 * The Food class is used to represent fast food items in the game
 *
 * @author Kathan Gandhi
 * @version 08/21/2019
 */
public class Food{
    private String name;
    private int cal;
    private double price;

    public Food(String name, int cal, double price){
        this.name = name;
        this.cal = cal;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getCal(){
        return this.cal;
    }

    public double getPrice(){
        return this.price;
    }
    
    public String toString(){
        return name+": \nCalories: "+cal+" Price: $"+price;
    }
}
