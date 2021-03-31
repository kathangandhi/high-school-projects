/**
 * The Team class organises a collection of Players in a team 
 */
public class Team{
    private Player[] players;//the array that stores all Player objects
    
    /**
     * Default constructor
     */
    public Team(){
        players = new Player[9];//9 is the default size of a baseball team
    }
    
    /**
     * Team constructor that initialises players array of size numPlayers
     */
    public Team(int numPlayers){
        players = new Player[numPlayers];
    }
    
    /**
     * Prints out information of each team member using 
     * the getter methods and getAverage() method
     */
    public void printTeamStats(){
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i].getName()+"\t #"
                               +players[i].getNumber()+"\t average >>> "
                               +(int) players[i].getBattingAverage());
        }
    }
    
    /**
     * Adds new Player p to the array at index specified
     */
    public void addPlayers(Player p, int index){
        players[index] = p;
    }
}
