import java.util.*;

public class CalculatorLab
{
   public static void main (String args[])
   { Scanner input = new Scanner (System.in);
     //Problem 1
     System.out.print("Enter an integer ===> ");
     int a = input.nextInt();
     if (a==9)
     {
        System.out.println("#1");
        }
     
     //Problem 2
     System.out.print("Enter an integer ===> ");
     int b = input.nextInt();
     if (b<=20)
     {
        System.out.println("#2");
        }
    
     //Problem 3
     System.out.print("Enter an integer ===> ");
     int c = input.nextInt();
     if (c==5||c==6)
     {
        System.out.println("#3");
        }
        
     //Problem 4
     System.out.println("9 = L of a C means 9 lives of a cat");
     
     //Problem 5
     System.out.print("Enter an integer ===> ");
     int d = input.nextInt();
     if (d!=4)
     {
        System.out.println("#5");
        }
        
     //Problem 6
     System.out.print("Enter a double ===> ");
     double e = input.nextDouble();
     if (e<10||e>2||e!=7.5)
     {
        System.out.println("#6");
        }
    
     //Problem 7
     System.out.print("Enter a double ===> ");
     double f = input.nextDouble();
     if (f>=1||f<=20)
     {
        System.out.println("#7");
        }
    
     //Problem 8
     System.out.println("Assign character stats (15 points max) ===> ");
     System.out.println("Enter strengh(1 to 10) ===> ");
     int strength = input.nextInt();
     if (strength>10)
     {
        System.out.println("Invalid");
        }
    
    
     System.out.println("Enter health(1 to 10) ===> ");
     int health = input.nextInt();
     if (health>10)
     {
        System.out.println("Invalid");
        }
        
     System.out.println("Enter magic(1 to 10) ===> ");
     int magic = input.nextInt();
     if (magic>10)
     {
        System.out.println("Invalid");
        
    }
    
     int sum = health + strength + magic;
     
     if (sum<=15)
     {
       System.out.println("You are good to go"); 
        }
     else
     {
        System.out.println("Point limit exceeded. Default values assigned");
        System.out.println("strength = 5");
        System.out.println("health = 5");
        System.out.println("magic = 5");
        
       
        }
    
     //Calculator
     System.out.println("1 – addition (+)");
     System.out.println("2 – subtraction (-)");
     System.out.println("3 – multiplication (*)");
     System.out.println("4 – division (/)");
     System.out.println("5 – modulus (%) (calculates remainder");
     
     System.out.println("Enter the number of your desired operation from the menu above >>> ");
     int sign = input.nextInt();
     if (sign > 5)
     {
      System.out.println("Enter from 1 to 5");   
        }
     
     System.out.println("Enter first number >>> ");
     int num1 = input.nextInt();
     
     System.out.println("Enter second number >>> ");
     int num2 = input.nextInt();
     
     switch (sign)
     { case 1: int addition = num1 + num2;
               System.out.println(num1 +"+" +num2+ "=" +addition);
               break;
       case 2: int subtraction = num1 - num2;
               System.out.println(num1+ "-" +num2+ "=" +subtraction);
               break;
       case 3: int multiplication = num1 * num2;
               System.out.println(num1+ "into" +num2+ "=" +multiplication);
               break;
       case 4: int division = num1 / num2;
               System.out.println(num1+ "divided by" +num2+ "=" +division);
               break;
       case 5: int remainder = num1 * num2;
               System.out.println("When " +num1+ "is divided by " +num2+ ",the remainder is" +remainder);
       default: System.out.println("Try Again!");
       



        
        
        
        
        
        
        
        
        }
     
     
     

    
    
    
    
    }
}
