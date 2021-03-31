
import java.util.*;
public class Lab10
{
  public static void main(String args[])
  { Scanner input = new Scanner(System.in);
    
    //Problem 1
    System.out.println("Enter num1: ");
    double num1 = input.nextDouble(); 
    System.out.println("Enter num2: ");
    double num2 = input.nextDouble();
    if(num1>num2)
    {
      System.out.println("Num1 is greater");
    
    }
     if(num2>num1)
    {
      System.out.println("Num2 is greater");
    
    }
    if(num1==num2)
    {
       System.out.println("Both are same");
    
    }
    
    //Problem 2
    System.out.println("Enter bill amount: ");
    double bill = input.nextDouble();
    double discount = 0;
    if (bill>=2000)
    {
     discount = 15.0;
    }
    if (bill>=1000&&bill<=2000)
    {
     discount = 10.0;
    }
    double total = (100-discount)/100*bill; 
    System.out.println("Bill with discounts(as applicable): "+total);
    
    //Problem 3
    System.out.println("Enter bill amount: ");
    bill = input.nextDouble();
    if (bill>=2000)
    {
     discount = 15.0;
    }
    if (bill>=1000&&bill<=2000)
    {
     discount = 10.0;
    }
    total = (100-discount)/100*bill; 
    System.out.println("Do you have a coupon?(true for yes and false for no)): ");
    boolean hasCoupon = input.nextBoolean();
    double coupon = 5.0;
    double grandTotal= total;
    if (hasCoupon == true)
    {
     grandTotal = grandTotal*95/100;
    }
    if(hasCoupon == false)
    {
     grandTotal = grandTotal;
    }
    System.out.println("Bill with discounts(as applicable): "+grandTotal);
    
    //Riddle
    System.out.println("What can you catch but not throw?");
    System.out.println("Answer is cold");
    
    //Problem 5
    System.out.println("Enter year no.: ");
    int year = input.nextInt();
    if(year%100!=0&&year%4==0||year%100!=0&&year%400==0)
    {
     System.out.println("It is a leap year");
    }
    if(year%100==0&&year%4==0&&year%400!=0)
    {
     System.out.println("It is not a leap year");
    }
    else
    {
     System.out.println("It is not a leap year");
    }
    
    //Problem 6
    System.out.println("Catalog:");
    System.out.println("1 - Paper");
    System.out.println("2 - Rock");
    System.out.println("3 - Scissors");
    System.out.println("Player 1: ");
    int player1 = input.nextInt();
    System.out.println("Player 2: ");
    int player2 = input.nextInt();
    if(player1==1&&player2==1)
    { 
     System.out.println("Players draw");
    }
    else
    if(player1==2&&player2==2)
    {
     System.out.println("Players draw");
    } 
    else
    if(player1==3&&player2==3)
    {
     System.out.println("Players draw");
    }
    else
    if(player1==1&&player2==2)
    {
     System.out.println("Paper covers rock... Player 1 wins!");
    }
    else
    if(player1==1&&player2==3)
    {
     System.out.println("Scissors cut paper... Player 2 wins!");
    }
    else
    if(player1==2&&player2==1)
    {
     System.out.println("Paper covers rock... Player 2 wins!");
    }
    else
    if(player1==2&&player2==3)
    {
     System.out.println("Rock smashes scissors... Player 1 wins!");
    }
    else
    if(player1==3&&player2==1)
    {
     System.out.println("Scissors cut paper... Player 1 wins!");
    }
    else
    if(player1==3&&player2==2)
    {
     System.out.println("Rock smashes scissors... Player 2 wins!");
    }
    
    //Basic Blackjack
    System.out.println("Player 1... Enter hand value: ");
    int hand1 = input.nextInt();
    System.out.println("Player 1... Enter hand value: ");
    int hand2 = input.nextInt();
    if (hand1>21&&hand2>21)
    {
     System.out.println("Both got busted");
    }
    if (hand1>hand2&&hand1<=21)
    {
     System.out.println("Player 1 Wins"); 
    }
    if (hand2>hand1&&hand2<=21)
    {
     System.out.println("Player 2 Wins"); 
    }
    if (hand1>hand2&&hand1>21)
    {
     System.out.println("Player 2 Wins"); 
    }
    if (hand2>hand1&&hand2>21)
    { 
     System.out.println("Player 1 Wins"); 
    }
    if (hand2==hand1)
    { 
     System.out.println("Rush"); 
    }
    
    
    
    
    }}
