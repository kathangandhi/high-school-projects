
import java.util.*;
public class Lab12GuessingGame
{
 public static void main(String args[])
 { Scanner input = new Scanner(System.in);
   
   //Problem 1
   System.out.println("Enter an integer: ");
   int cycle = input.nextInt();
   int i = 1;
   while(i<=cycle)
   {
     System.out.print(i+" ");
     i++;
    }
   System.out.println();
   //Problem 2
   System.out.println("Enter an integer: ");
   cycle = input.nextInt();
   int sum = (cycle*(cycle+1))/2; 
   System.out.println("Sum of nos. from 1 to "+cycle+" :"+sum);
   
   //Problem 3
   System.out.println("Enter an even integer: ");
   cycle = input.nextInt();
   sum = 2*(cycle/4*((cycle/2)+1)); 
   System.out.println("Sum of even nos. from 2 to "+cycle+" :"+sum);
   
   //Riddle
   System.out.println("What do you call a person that does not have all his fingers on one hand?");
   System.out.println("human");
   
   //Problem 4
   System.out.println("Enter an integer: ");
   cycle = input.nextInt();
   sum = 7*(cycle/14*((cycle/7)+1)); 
   System.out.println("Sum of nos. from 1 to "+cycle+" :"+sum);
   
   //Guessing Game
   int guesses = 7;
   Random randomGen = new Random(); //you only need to do this once!      
   int number = randomGen.nextInt(1000) + 1;
   System.out.println("Let's play the Guessing Game...");
   System.out.println("You have 7 guesses, and you will get the following hints: ");
   System.out.println("Whether you are too high");
   System.out.println("Whether you are too low");
   System.out.println();
   for (i=1;i<=7;i++)
   {
    System.out.print("Guess"+i+" :");
    int guess = input.nextInt();
    guesses-=1;
    if(guess==number)
    {
     System.out.println("You win...Congratulations!");
    }
    else if(guess<number)
    {
     System.out.println("Too low...try again");
     System.out.println("No.of guesses remaining: "+guesses);
    }
    else
    {
     System.out.println("Too high...try again");
     System.out.println("No.of guesses remaining: "+guesses);
    }
    if (guess!=number&&guesses==0)
    {
     System.out.println("You Lose"); 
    }
  }
  System.out.println("The no. was = "+number);
  
}}
