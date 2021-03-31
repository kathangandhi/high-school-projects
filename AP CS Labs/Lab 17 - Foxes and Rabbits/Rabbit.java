import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit{
    /* Characteristics shared by all rabbits (static fields). */

    private static final int    BREEDING_AGE = 5;
    private static final int    MAX_AGE = 15;
    private static final double BREEDING_PROBABILITY = 0.22;
    private static final int    MAX_LITTER_SIZE = 6;

    /* Individual characteristics (instance fields). */

    private int      age;
    private boolean  alive;
    private Field    field;
    private Location location; //stores a reference to this Rabbit's current location

    /**
     * Create a new rabbit. A rabbit is created with age zero (a new born).
     * @param the <code>Location</code> to set
     * @param the <code>Field</code> of the <code>Rabbit</code>
     */
    public Rabbit(Field field, Location location){
        this.age = 0;
        this.alive = true;
        this.field = field;
        this.location = location;
    }

    /**
     * Sets the <code>Location</code> of this <code>Rabbit</code> in the <code>Field</code>
     * @param the <code>Location</code> to set
     */
    public void setLocation(Location location){
        field.place(this,location);
    }

    /** Method called when a Rabbit becomes deceased */
    public void setDead(){
        alive = false;
        if(location != null){
            field.remove(location);
            this.location = null;
            this.field = null;
        }
    }

    /**
     * Increase the Rabbit's age.
     * This could result in the rabbit's death.
     */
    private void incrementAge(){
        age++;
        if(this.age >= Rabbit.MAX_AGE){
            setDead();
        }
    }

    /**
     * Check if <code>Rabbit</code> is alive
     * @return true if the <code>Rabbit</code> is alive.
     */
    public boolean isAlive(){
        return alive;
    }

    /**
     * A rabbit can breed if it has reached breeding age.
     * @return true if the rabbit can breed, false otherwise.
     */
    private boolean canBreed(){
        return(this.age >= Rabbit.BREEDING_AGE);
    }

    /**
     * Return a string with <code>Rabbit</code>'s information
     * @return <code>Rabbit</code>'s info
     */
    @Override
    public String toString(){
        return "Rabbit, "+age+" y/o, at "+location.toString();
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed(){
        double chance = 1-Math.random();
        if(canBreed() && (chance < Rabbit.BREEDING_PROBABILITY)){
            int babies = (int)(Math.random()*Rabbit.MAX_LITTER_SIZE);
            return babies;
        }
        return 0;
    }

    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     */
    public void run(){
        incrementAge();  
        if(!this.isAlive())
            return;

        Location loc = field.freeAdjacentLocation(location);
        if(loc != null){
            int babies = breed();
            if(babies != 0){
                for(int i = 0; i < babies; i++){
                    Location l = field.freeAdjacentLocation(this.location);
                    if(l != null){
                        Rabbit baby = new Rabbit(this.field,l);
                        baby.setLocation(l);
                    }
                }
            }

            Location move = field.freeAdjacentLocation(this.location);
            if(move != null)
                field.move(location,move);
            else
                this.setDead();
        }
        else
            setDead();
    }
}
