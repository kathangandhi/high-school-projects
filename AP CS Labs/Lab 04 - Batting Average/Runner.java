import java.util.*;
import java.io.*;
/**
 * The driver class that tests Team and Player class
 */
public class Runner
{
    /**
     * The main method that tests  
     */
    public static void main(String args[]) throws FileNotFoundException{
        //code to parse data from the players.txt file
        File file = new File("players.txt");
        Scanner input = new Scanner(file);

        int size = input.nextInt();//sets size of Team having various Players
        Team liberty = new Team(size);//Team containing all Players

        //loop to initialise and store all the Players in the Team
        for(int i = 0; i < size; i++) 
            liberty.addPlayers(new Player(input.next(), input.nextInt(), input.nextInt(), input.nextInt()), i);

        liberty.printTeamStats();//prints out the statistics of the whole team
    }
}
