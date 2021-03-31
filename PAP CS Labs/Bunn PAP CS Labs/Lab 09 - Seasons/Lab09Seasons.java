
import java.util.*;
public class Lab09Seasons
{
   public static void main (String args[])
   { Scanner input = new Scanner(System.in);
     //Problem 1
     System.out.println("Left Pressure: ");
     int leftPressure = input.nextInt(); 
     System.out.println("Right Pressure: ");
     int rightPressure = input.nextInt(); 
     int difference = Math.abs(leftPressure - rightPressure);
     if (difference>4)
     {
      System.out.println("Warning: Uneven Tire Pressure");  
        }
     if (rightPressure<36)
     {
      System.out.println("Warning: Low Tire Pressure");  
        }   
      if (leftPressure<36)
     {
      System.out.println("Warning: Low Tire Pressure");  
        }      
     //Problem 2
     System.out.println("Ton!!!");
     
     //Problem 3
     System.out.println("What is your grade?: ");
     double grade = input.nextDouble();
     if(grade>=90){
      System.out.println("That's an A");
        
        }
     else if(grade>=80&&grade<90){
             System.out.println("That's a B");
        }   
     else if(grade>=70&&grade<80){
             System.out.println("That's a C");
        }   
     else if(grade>=60&&grade<70){
             System.out.println("That's a D");
        }   
     else if(grade>=60&&grade<70){
             System.out.println("You failed");
        }   
     
     //Seasons App
     System.out.println("What month is it?(1 - 12): ");
     int month = input.nextInt();   
     System.out.println("What day is it?(1 - 31): ");
     int day = input.nextInt();   
     
    if(month==9&&day>=16||10<=month&&month<12||month==12&&day<=15){
      System.out.println("Fall");  
        }
     else if(month==12&&day>=16||1<=month&&month<3||month==3&&day<=15){
             System.out.println("Winter");
        }   
     else if(month==3&&day>=16||4<=month&&month<6||month==6&&day<=15){
             System.out.println("Spring");
        }   
     else if(month==6&&day>=16||7<=month&&month<9||month==9&&day<=15){
             System.out.println("Summer");
        }   
     else {
             System.out.println("You are a retard");
        }   
     
    
    
    
    
    
    
    
    
    }
}
