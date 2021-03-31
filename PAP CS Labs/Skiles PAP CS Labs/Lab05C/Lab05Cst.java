// Lab05Cst.java
// Fixing All Types of Errors
// This is the student, starting version of Lab 05C.
// It contains several errors.  Some are "Compile Errors".
// Some are "Run-time Errors".  Some are "Logic Errors".
// Students need to find and fix all errors in this program.


public class Lab05Cst
{
   public static void main(String args[])
   {
      System.out.println("Lab 05C, 100 Point Version");
      System.out.println();
      System.out.println("Fixing All Types of Errors");
      System.out.println();

      String name="Kathan Gandhi";
      int num1 = 100;
      int num2 = 200;
      int num3 = 300;
      int num4 = 400;

      int amount = 4;

      double average = (num1 + num2 + num3 + num4) / amount;

      // You may NOT alter the next <println> statement,
      // but you still need to make it display your name.
      System.out.println("By: " + name);

      System.out.println("Average: " + average);
      System.out.println();
   }
}

