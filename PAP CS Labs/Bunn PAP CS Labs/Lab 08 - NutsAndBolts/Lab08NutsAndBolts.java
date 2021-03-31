import java.util.*;

public class Lab08NutsAndBolts
{
   public static void main(String args[])
   {  Scanner input = new Scanner(System.in);
     
      //Problem 1  
      System.out.println("Enter an integer");
      int apples;
      apples = input.nextInt();
      if (apples>0)
      {
        System.out.println("Hello World");
        }
      
      System.out.println("Enter an integer");
      apples = input.nextInt(); 
      if (apples%2==0)
      {
        System.out.println("Omg it's so even");
        
        }
        else
       {
         System.out.println("It's so odd");
        
        }
        
      //Problem 2 
      int votingAge = 18;
      System.out.println("What's your age?");
      int actualAge = input.nextInt();
      if (actualAge>=votingAge)
      {
        System.out.println("You can vote");
        
        }
        else
       {
         System.out.println("You cannot vote");
        
        }
      
      // Problem 3
      System.out.println("Goose");
      
      //Nuts and Bolts App
      System.out.println("Bolts needed: ");
      int bolts = input.nextInt();
      System.out.println("Nuts needed: ");
      int nuts = input.nextInt();
      System.out.println("Washers needed: ");
      int washers = input.nextInt();
      if (nuts<bolts)
      {
        System.out.println("Error!Check Order: Too few nuts");
        
        }
      if (nuts>bolts)
      {
        System.out.println("Error!Check Order: Too few bolts");
       
        }
       if (2*washers!=nuts)
      {
        System.out.println("Error!Check Order: Too few washers");
        
       
        }  
      double total = ((5.0*bolts)+(3.0*nuts)+(washers))/100.0; 
      System.out.println("Total: "+ total);
      
     
      
      
    
    
    
    
    
    
    
    
    
    
    
    
    
      }
}
