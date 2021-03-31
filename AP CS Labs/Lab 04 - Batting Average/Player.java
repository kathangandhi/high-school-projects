/**
 * The Player class stores information about a baseball Player
 */
public class Player{
    private String name;
    private int number;//the kit number 
    private int atBats;//the total number of at-bats
    private int hits;//the total number of hits

    /**
     * The Player constructor that sets name and number. 
     * It sets atBats and hits to 0.<br>
     * ***Uses concept of constructor chaining*** 
     */
    public Player(String name, int number){
        this(name,number,0,0);
    }

    /**
     * The Player constructor that sets name, number, atBats, hits
     * @param name Name of player
     * @param number Kit number of Player
     * @param atBats Batting chances of the Player
     */
    public Player(String name, int number, int atBats, int hits){
        this.name = name;
        this.number = number;
        this.atBats = atBats;
        this.hits = hits;
    }

    /**
     * Calculates the batting average of the baseball player
     * @return batting average
     */
    public double getBattingAverage() {
        return Math.round((double) hits*1000/atBats);
        //return average number of hits in 1000 atBats
    }

    //getter methods for each variable in Player class
    
    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public int getAtBats(){
        return atBats;
    }

    public int getHits(){
        return hits;
    }
}
