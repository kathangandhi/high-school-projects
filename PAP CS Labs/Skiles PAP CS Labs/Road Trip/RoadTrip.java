
import java.util.* ;

public class RoadTrip
 {public static void main (String args[]){
   //Name:Kathan Gandhi
   //Period:3B
   final double Pi = 3.1415;
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
   //Road Trip
   System.out.println("Enter the vehicle's mileage");
   double vehicleMileage = input.nextDouble();
   System.out.println("Mileage >>> "+vehicleMileage);
   
   System.out.println("Enter the trip distance");
   double tripMiles = input.nextDouble();
   System.out.println("Trip Distance >>> "+tripMiles);
   
   System.out.println("Enter the average speed");
   double averageSpeed = input.nextDouble();
   System.out.println("Average Speed >>> "+averageSpeed);
   
   System.out.println("Enter the gas tank's capacity");
   double tankCapacity = input.nextDouble();
   System.out.println("Tank Capacity >>> "+tankCapacity);
   
   System.out.println("Enter the price of gas");
   double gasPrice = input.nextDouble();
   System.out.println("Gas Price >>> "+gasPrice );
   
   double gasneeded = tripMiles/vehicleMileage;
   System.out.println("Gallons of gas needed >>> "+gasneeded);
   double gascost = gasneeded*gasPrice;
   System.out.println("Gas Price for Trip >>> "+gascost);
   double stops = gasneeded/tankCapacity;
   System.out.println("No. of stops you will have to make >>> "+stops);
   double hours = tripMiles/averageSpeed;
   System.out.println("The amount of time you will have to drive >>> "+hours);
   
   
   
   
   
   
  }
 
}
