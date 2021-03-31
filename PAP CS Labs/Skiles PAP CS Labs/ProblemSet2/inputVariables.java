
import java.util.Scanner;

public class inputVariables
{
   public static void main(String[] args)
   {
    Scanner input = new Scanner(System.in);
    
    /*System.out.println("Sample Input");
    //Input String
    System.out.print("Enter Your Name: ");
    String name = input.nextLine();
    System.out.println("Hello " + name);
    
    //Input Integer
    System.out.print("Enter Your Age: ");

    System.out.println("You are " + age + " years old");
    
    //Input Double
    System.out.print("Enter your hourly wage: ");
    double wage = input.nextDouble();
    System.out.println("You make " + wage + " dollars per hour");*/
    
    
    System.out.println("Problem 2");
    System.out.println("Enter value = ");
    int test = input.nextInt();
    int result = test%2;
    System.out.println("Result: "+result);
    System.out.println();
    //Solve problem 2 here
    
    System.out.println("Problem 3");
    System.out.println("Enter value of gallons = ");
    double gallons = input.nextInt();
    System.out.println("Enter value of miles = ");
    double miles = input.nextInt();
    double mileage = miles/gallons;
    System.out.println("Mileage: "+mileage);
    //Solve problem 3 here
    
    
    System.out.println();
    System.out.println("Problem 4");
    int salary = 200;
    System.out.println("Enter gross sales = ");
    int sales = input.nextInt();
    int totalsalary = salary + 9*sales/100;
    System.out.println("The total salary is "+totalsalary);
    //Solve problem 4 here
       
   }
}
