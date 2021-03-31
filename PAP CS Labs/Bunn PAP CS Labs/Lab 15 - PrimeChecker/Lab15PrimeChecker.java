
import java.util.*;

public class Lab15PrimeChecker
{
 public static void main(String args[])
 {
   Scanner input = new Scanner(System.in);
   
   //Prime Checking APP
   System.out.println("Enter a whole number");
   int number = input.nextInt();
   int count=1;
   int divider=1; 
   
   while(Math.round(number/2)>divider&&count>0)
   { 
     divider++;
     if(number%divider==0)
     {
       count--;
       System.out.println("The no. is divisible");
        }
     
    
     
     
     
   
    }
   
    
   if(Math.round(number/2)==divider)
   {
    System.out.println("The no. is prime");
    }
  
    }
    }

