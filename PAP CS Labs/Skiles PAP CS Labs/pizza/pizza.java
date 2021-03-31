import java.util.Scanner;

public class pizza
{
    public static void main(String args[]){
      Scanner input = new Scanner(System.in);
      
      
      double labor = 1.2;
      
      System.out.print("Enter the diameter:  ");
      double diameter = input.nextDouble();
      System.out.println();
      double materials = 0.05*diameter*diameter;
      double pizzaCost = materials + labor;
      System.out.println("The cost is "+pizzaCost+" dollars.");
    }
    
}   
