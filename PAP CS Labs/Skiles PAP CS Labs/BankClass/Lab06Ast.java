// Lab06Ast.java
// The First Bank Program
// Object Methods and Output Formatting
// This is the student, starting version of Lab 06A.

import java.text.DecimalFormat;

public class Lab06Ast
{
	public static void main(String args[])
	{
      // Create DecimalFormat and Bank Objects
      DecimalFormat money = new DecimalFormat("$00,000.00");
      Bank tom  = new Bank();
      Bank suzy = new Bank(1600,32000);
      Bank bill = new Bank(8000,Expo.random(20000,90000));
      

      // Display Final Balances
      System.out.println("Initial Balances: ");
      System.out.println("Tom's Initial Checking Balance: "+money.format(tom.getChecking()));
      System.out.println("Tom's Initial Savings Balance: "+money.format(tom.getSavings()));
      System.out.println("Suzy's Initial Checking Balance: "+money.format(suzy.getChecking()));
      System.out.println("Suzy's Initial Savings Balance: "+money.format(suzy.getSavings()));
      System.out.println("Bill's Initial Checking Balance: "+money.format(bill.getChecking()));
      System.out.println("Bill's Initial Savings Balance: "+money.format(bill.getSavings()));







      // Deposits and Withdrawals
      tom.checkingDeposit(500);
      tom.savingsDeposit(7000);
      bill.checkingWithdrawal(8000);
      suzy.savingsWithdrawal(20000);
      suzy.checkingDeposit(20000);
      bill.savingsWithdrawal(bill.getSavings());
      System.out.println();
 




      // Display Final Balances
      System.out.println("Final Balances: ");
      System.out.println("Tom's Final Checking Balance: "+money.format(tom.getChecking()));
      System.out.println("Tom's Final Savings Balance: "+money.format(tom.getSavings()));
      System.out.println("Suzy's Final Checking Balance: "+money.format(suzy.getChecking()));
      System.out.println("Suzy's Final Savings Balance: "+money.format(suzy.getSavings()));
      System.out.println("Bill's Final Checking Balance: "+money.format(bill.getChecking()));
      System.out.println("Bill's Final Savings Balance: "+money.format(bill.getSavings()));







	}
}
