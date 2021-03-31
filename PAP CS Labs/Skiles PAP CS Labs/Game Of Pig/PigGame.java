import java.util.*;

public class PigGame
{
    static Scanner input = new Scanner(System.in);
    private int goal;
        
    
    Player player1 = new Player("Pig 1");
    Player player2 = new Player("Pig 2");
    
    
    public PigGame(int goalPoints)
    {
        // initialise instance variables
        goal = goalPoints;
        
        System.out.println("Player 1 Name:");
        String name1=input.nextLine();
        player1.setName(name1);
        
        System.out.println("Player 2 Name:");
        String name2=input.nextLine();
        player2.setName(name2);
    }
    
    public void play()
    {
        printInstructions();
        System.out.println("Let's Begin");
        do
        {
         player1.takeTurn();
         if (player1.score<10)
          player2.takeTurn();
        }while(player1.score<goal&&player2.score<goal);
        
        if(player1.score>10)
         System.out.println("The Winner is "+player1.name);
        else if(player2.score>10)
         System.out.println("The Winner is "+player2.name);
    }
    
    public void printInstructions()
    {
       System.out.println();
       System.out.println("Welcome to Game of Pig");
       System.out.println("In this game, you have the choice to roll/hold");
       System.out.println("You must determine the goal value before starting");
       System.out.println("If a player rolls, the value on the die gets added to the score");
       System.out.println("Whoever reaches the score wins");
       System.out.println();
       
    }
}
