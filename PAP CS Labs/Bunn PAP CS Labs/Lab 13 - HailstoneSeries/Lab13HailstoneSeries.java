
import java.util.*;
public class Lab13HailstoneSeries
{
  public static void main(String args[]) 
  { Scanner input = new Scanner(System.in);
      
    //Problem 1
    int userInput = 1;
    int sum = 0;
    while(userInput!=0)
    {System.out.println("Enter an integer(or 0 to quit): ");
     userInput = input.nextInt();
     sum+=userInput;
    }
    System.out.println("Sum of Integers: "+sum);
    
    //Riddle
    int x = 8;
    System.out.println("Jo's Age: "+x);
    
    //Problem 2
    int month = 0;
    int potency = 100;
    while(potency>=50)
    {
     System.out.print("Month: "+month+"    ");
     month++;
     System.out.println("Potency: "+potency);
     potency=(potency*88/100);
     
    }
    System.out.println("Discard");
    
    //Problem 3
    int pin = 1234;
    int userPin = 0;
    int i=1;
    while(userPin!=pin&&i<=3)
    {
     System.out.println("Enter pin: ");
     userPin = input.nextInt();
     i=i+1;
     if(userPin==pin)
     {
      System.out.println("Welcome! You are now logged in");
     }
     else 
     if(userPin!=pin)
     {
      System.out.println("Invalid PIN! Access denied");
      if(i==4)
      {System.out.println("Your account has been locked.");
       System.out.println("Try again in 1 Minute.");
      }
     }
     
     }
    
    //Hailstone Series
    System.out.println("Enter an integer from 1 to 1000: ");
    int hailstone = input.nextInt();
    i=1;
    int max=0;
    while(hailstone>1)
    {
     System.out.println(hailstone);
     i++;
     if (hailstone%2==0)
     {
      hailstone/=2;
     }
     else
     {
      hailstone=(hailstone*3)+1;   
     }
     max=Math.max(hailstone,max);
    }
    System.out.println("1");
    System.out.println("Series took "+i+" steps to reach value of 1");
    System.out.println("The maximum no. in the series is: "+max);
    
    
    
    
    }
}
