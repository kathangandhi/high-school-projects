import java.util.*;

public class Player
{   
    Scanner input = new Scanner(System.in);
    // instance variables - replace the example below with your own
    public int score;
    public String name;
    private String choice;
    //Die object
    Die die = new Die();
    
    public Player(String pName)
    {
        name=pName;
        score=0;
    }

    public void takeTurn()
    {
        System.out.println(name+" ,Do you want to roll/hold?");
        choice=input.nextLine();
        System.out.println();
        if(choice.equals("hold"))
            System.out.println("Holding");
        else if(choice.equals("roll"))
        {
            System.out.println("Rolling...");
            int roll=die.roll();
            System.out.println(name+" ,You got "+roll);
            System.out.println();
            score+=roll;
            System.out.println(name+" ,Your score is "+score);
        }
    }
    
    public void setName(String nameExample)
    {
     name=nameExample;
    }
}
