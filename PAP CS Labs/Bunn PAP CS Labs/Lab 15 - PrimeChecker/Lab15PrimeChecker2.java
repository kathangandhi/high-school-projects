

import java.util.*;

public class Lab15PrimeChecker2
{
 public static void main(String args[])
 {
   Scanner input = new Scanner(System.in);
   
   //Prime Checking APP
   System.out.println("Enter start number");
   int number = input.nextInt();
   System.out.println("Enter end number");
   int number2 = input.nextInt(); 
   int count=1;
   int divider=1; 
   int amount=0;
   
   while(number2>number)
   {
    while(Math.round(number/2)>divider&&count>0)
    { 
     divider++;
     if(number%divider==0)
     {
       count--;
       
        }
     
    
     
     
     
   
     }
    
    
    if(Math.round(number/2)==divider)
    {
     amount++;
    }
    number++;
    }
    System.out.println("The no. of prime nos. in the range: "+amount);
    }
    }
