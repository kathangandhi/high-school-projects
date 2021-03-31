import java.util.*;

public class BankAccountRunner
{
   public static void main(String args[])
   {
    Scanner input=new Scanner(System.in);
    BankAccount kathan=new BankAccount("Kathan",100000);
    BankAccount charly=new BankAccount("Charly",10000);
    BankAccount sumedh=new BankAccount("Sumedh",1000);
    
    //1
    System.out.println("Kathan has: "+kathan.balance);
    System.out.println("Charly has: "+charly.balance);
    System.out.println("Sumedh has: "+sumedh.balance);
    if(charly.balance>kathan.balance&&charly.balance>sumedh.balance)
    {
     System.out.println("Charly has the most money");
    }
    else if(kathan.balance>charly.balance&&kathan.balance>sumedh.balance)
    {
     System.out.println("Kathan has the most money");
    }
    else if(sumedh.balance>charly.balance&&sumedh.balance>kathan.balance)
    {
     System.out.println("Sumedh has the most money");
    }
    System.out.println();
    //2
    System.out.println("Enter the amount you want to withdraw");
    double amount=input.nextDouble();
    kathan.withdraw(amount);
    System.out.println("You have: "+kathan.balance);
    
    //3
    System.out.println("Enter Bank Balance: ");
    double bala=input.nextDouble();
    input.nextLine();
    System.out.println("Enter Name: ");
    String naam=input.nextLine();
    BankAccount object=new BankAccount(naam, bala);
    System.out.println("Name: "+object.name);
    System.out.println("Balance: "+object.balance);
    
   }
}
