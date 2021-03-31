


public class TextLab08st
{
	public static void main (String args[])
	{
		System.out.println("Text Lab 08");
		Bank tom = new Bank("Tom Smith");
		Bank sue = new Bank("Sue Brown", 3000);
		Bank bob = new Bank("Bob Jones", 5000, 10000);

        tom.showBalances();
        sue.showBalances();
        bob.showBalances();

        System.out.println("Tom deposits $1000 in checking and $5000 in savings.");
        tom.checkingDeposit(1000);
        tom.savingsDeposit(5000);
        tom.showBalances();

        System.out.println("Bob withdraws $7000 from checking.");
        bob.checkingWithdrawal(7000);
        bob.showBalances();

        System.out.println("Tom withdraws $4000 from savings.");
        tom.savingsWithdrawal(4000);
        tom.showBalances();

        System.out.println("Sue withdraws $4000 from checking.");
        sue.checkingWithdrawal(4000);
        sue.showBalances();

       

        System.out.println("Bob transfers $5000 from savings to checking.");
        bob.transferToChecking(5000);
        bob.showBalances();

        System.out.println("Sue transfers $2000 from checking to savings.");
        sue.transferToSavings(2000);
        sue.showBalances();


       

       	System.out.println("Tom deposits 75% of a $10,000 paycheck in checking");
       	System.out.println("and puts the rest in savings.");
       	tom.splitDeposit(10000,75);
       	tom.showBalances();

        
	}
}

