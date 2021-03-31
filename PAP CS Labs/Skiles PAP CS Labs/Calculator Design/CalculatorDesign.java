import java.util.*;

public class CalculatorDesign
{
   static Scanner input = new Scanner(System.in);
   
   public static void main(String args[])
   {
    showResults(menu());
   }
    
   static double menu()
   {
    System.out.println("Enter 1 for addition: ");
    System.out.println("Enter 2 for subtraction: ");
    System.out.println("Enter 3 for multiplication: ");
    System.out.println("Enter 4 for division: ");
    double n= input.nextDouble();
    return n;
    }
    
   static void showResults(double x)
   {
    System.out.println("Enter first no.");
    double num1=input.nextDouble();
    System.out.println("Enter second no.");
    double num2=input.nextDouble();
    if(x==1)
    {
      System.out.println(num1+" + "+num2+" = "+ add(num1, num2));
     }
    else if(x==2)
    {
      System.out.println(num1+" - "+num2+" = "+subtract(num1,num2));
        }
    else if(x==3)
    {
      System.out.println(num1+" * "+num2+" = "+multiply(num1,num2));
    }
    else if(x==4)
    {
      System.out.println(num1+" / "+num2+" = "+divide(num1,num2));
    }
    
    }
    
   static double add(double x, double y)
   {
     double result=x+y;
     return result;
    }
    
   static double subtract(double x, double y)
   {
     double result=x-y;
     return result;  
    }
    
   static double multiply(double x, double y)
   {
     double result=x*y;
     return result;   
    }
   
   static double divide(double x, double y)
   {
     double result=x/y;
     return result;   
    }
}
