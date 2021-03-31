//Kathan Gandhi
   //3B
import java.util.*;

public class Lab05ChangeMaker
{ public static void main (String args[])
  { final double Pi = 3.1415;
   Scanner input = new Scanner(System.in);
   //Problem 1
   System.out.println("Enter an integer");
   int num1 = input.nextInt();
   num1 = num1 + 10;
   System.out.println("The answer is >>> "+num1);
   //Problem 2
   input.nextLine();
   System.out.println("Enter your name");
   String name1 = input.nextLine();
   System.out.println("Hello, "+name1);
   //Problem 3
   System.out.println("Enter a double integer");
   double something = input.nextDouble();
   something = (something)*(something);
   System.out.println("The answer is >>> "+something);
   //Problem 4
   input.nextLine();
   System.out.println("What belongs to you, but others use it more?");
   String name = input.nextLine();
   //Problem 5
   System.out.println("Enter your name ");
   String name2 = input.nextLine();
   System.out.println("Enter your age");
   int age = input.nextInt();
   System.out.println(name2+" is "+age+" years old.");
   //Problem 6
   System.out.println("Enter an integer");
   int radius = input.nextInt();
   double radius2 = Pi*(radius*radius);
   System.out.println("The answer is >>> "+radius2);
   //Problem 7
   System.out.println("Enter a double integer");
   double time = input.nextDouble();
   time = 10*time;
   System.out.println("Distance travelled >>> "+time);
   //Problem 8
   input.nextLine();
   System.out.println("Enter your name");
   System.out.println(name1+name1+name1);
   //Change Maker
   System.out.println("Enter change amount >>> ");
   int cents = input.nextInt();
   int dollars = cents/100;
   int quarters = (cents%100)/25;
   int dimes = ((cents%100)%25)/10;
   int leftover = ((cents%100)%25)%10;
   System.out.println("No. of dollars >>> "+ dollars);
   System.out.println("No. of quarters >>> "+ quarters); 
   System.out.println("No.of dimes >>> "+ dimes);    
   System.out.println("No. of cents >>> "+ leftover);    
    
    
    
    
    
    
    
    }
    
   
   
}
