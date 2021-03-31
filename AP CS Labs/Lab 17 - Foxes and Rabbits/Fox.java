import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox{
    /* Characteristics shared by all foxes (static fields). */

    private static final int    BREEDING_AGE = 10;
    private static final int    MAX_AGE = 20;
    private static final double BREEDING_PROBABILITY = 0.17;
    private static final int    MAX_LITTER_SIZE = 4;
    private static final int    RABBIT_FOOD_VALUE = 8;

    /* Individual characteristics (instance fields). */

    private int      age;
    private boolean  alive;
    private Field    field;
    private Location location;
    private int      foodLevel;

    /**
     * Create a fox. A fox is created as a new born (age zero
     * and not hungry).
     */
    public Fox(Field field, Location location){
        this.age = 0;
        this.alive = true;
        this.field = field;
        this.location = location;
        this.foodLevel = Fox.RABBIT_FOOD_VALUE;
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    private void incrementAge(){
        age++;
        if(this.age >= Fox.MAX_AGE)
            setDead();
    }

    public boolean isAlive(){
        return this.alive;
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger(){
        foodLevel--;
        if(foodLevel <= 0)
            setDead();
    }

    /** Method called when a Fox is no longer alive */
    public void setDead(){
        this.alive = false;
        if(location!=null){
            field.remove(location);
            this.location = null;
            this.field = null;
        }
    }

    /**
     * Sets the <code>Location</code> of this <code>fox</code> in the <code>Field</code>
     * @param the <code>Location</code> to set
     */
    public void setLocation(Location location){
        field.place(this,location);
    }

    /**
     * A fox can breed if it has reached breeding age.
     */
    private boolean canBreed()
    {
        return(this.age >= Fox.BREEDING_AGE);
    }

    /**
     * Tell the fox to look for rabbits adjacent to its current location.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        List<Location> adjacentLocations = field.adjacentLocations(this.location);

        for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
        {
            Object animal = field.getObjectAt(where);

            if (animal instanceof Rabbit) { //if this object is a rabbit...
                Rabbit rabbit = (Rabbit) animal;

                rabbit.setDead();

                this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

                return where;
            }
        }
        return null;
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed(){
        double chance = 1-Math.random();
        if(canBreed() && (chance < Fox.BREEDING_PROBABILITY)){
            int babies = (int)(Math.random()*Fox.MAX_LITTER_SIZE);
            return babies;
        }
        return 0;
    }

    /**
     * This is what the fox does most of the time: it hunts for rabbits. 
     * In the process, it might breed, die of hunger, or die of old age.
     */
    public void hunt(){
        incrementHunger();
        incrementAge();  
        if(this.age >= Fox.MAX_AGE)
            return;

        if(alive){
            Location loc = field.freeAdjacentLocation(location);
            if(loc != null){
                int babies = breed();
                if(babies != 0){
                    for(int i = 0; i < babies; i++){
                        Location l = field.freeAdjacentLocation(this.location);
                        if(l != null){
                            Fox baby = new Fox(this.field,l);
                            baby.setLocation(l);
                        }
                    }
                }

                Location food = findFood();
                if(food == null){
                    Location move = field.freeAdjacentLocation(this.location);
                    if(move != null)
                        field.move(location,move);
                    else
                        this.setDead();
                }
                else{
                    field.move(location,food);
                    foodLevel = RABBIT_FOOD_VALUE;
                }
            }
            else
                setDead();
        }
    }
}
