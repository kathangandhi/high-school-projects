/**
 * The Player class - a simple intro to return in Java
 */
public class Player{
    String name;
    int number;
    
    /**
     * Player default constructor
     */
    public Player()
    {
        name = "Default";
        number = -1;
    }

    /**
     * Player constructor that initialises name and number
     * @param name Player name
     * @param number Player number
     */
    public Player(String name, int number)
    {
        this.name = name;
        this.number = number;
    }
    
    /**
     * Returns name and number of Player
     * @return Player name and number
     */
    public String playerInfo()
    {
        return ("Player: "+name+", #"+number);
    }
}
