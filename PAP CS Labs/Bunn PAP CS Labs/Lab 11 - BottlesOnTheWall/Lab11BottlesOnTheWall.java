
import java.util.*;
public class Lab11BottlesOnTheWall
{
  public static void main(String args[])
  { Scanner input = new Scanner(System.in);
   
    //Problem 1
    int i=1;
    while(i<=9)
    {System.out.print(i);
     i++;
    }
    System.out.println(); 
   
    //Problem 2
    i=1;
    while(i<=9)
    {System.out.print(i+" ");
     i++;
    }
    System.out.println(); 
    
    //Problem 3
    i=1;
    while(i<=19)
    {System.out.print(i+" ");
     i+=2;
    }
    System.out.println(); 
    
    //Problem 4
    i=5;
    while(i<=50)
    {System.out.print(i+" ");
     i+=5;
    }
    System.out.println(); 
    
    //Problem 5
    i=10;
    while(i>=1)
    {System.out.print(i+" ");
     i--;
    }
    System.out.println(); 
    
    //Problem 6
    int j=-4;
    while(j>=-40)
    {System.out.print(j+" ");
     j-=4;
    }
    System.out.println(); 
    
    //Problem 7
    i=1;
    while(i<=256)
    {System.out.print(i+" ");
     i*=2;
    }
    System.out.println(); 
    
    //Problem 8
    i=1000;
    while(i>=3)
    {System.out.print(i+" ");
     i/=2;
    }
    System.out.println(); 
    
    //Problem 9
    i=1;
    j=1;
    while(i<9)
    {j=1;
     
     while(j<=2)
     {
      j++;
      i*=-1;  
      System.out.print(i+" ");  
        }
     i++; 
    }
    System.out.println(); 
    System.out.println();
    
    //Bottles on the wall
    System.out.println("Enter your age: ");
    int age = input.nextInt();
    if (age<21)
    {
     System.out.println("Minimum age is 21");
    }
    else
    {
     System.out.println("You are admitted");
     System.out.println("Menu: ");
    System.out.println("Coke - 1 ");
    System.out.println("Beer - 2 ");
    System.out.println("What would you like?(Enter the no.next to the drink) )");
    int choice = input.nextInt();
    String drink = "";
    if(choice==1)
    {
      drink = "Coke";
    }
    if(choice==2)
    {
     drink = "Beer";
    }
    System.out.println("You have chosen "+drink);
    int bottles = 99;
    int difference = bottles-1;
    while(bottles>0)
    {System.out.println(bottles+" bottles of "+drink+" on the wall");
     System.out.println(bottles+" bottles of "+drink);
     System.out.println("Take it down, pass it around, "+difference+" bottles of "+drink+" on the wall");
     bottles--;
     difference--;
    }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
