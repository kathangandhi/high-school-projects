// Bank.java
// This is the student, starting version of the <Bank> class used with Text Lab 8.


public class Bank
{
	private double checkingBal;
	private double savingsBal;
	private String name;

	public Bank()
	{
		name = "...b.l.a.n.k...";
		checkingBal = 0.0;
		savingsBal  = 0.0;
	}

	public Bank(String n)
	{
		name = n;
		checkingBal = 0.0;
		savingsBal  = 0.0;
	}

	public Bank(String n, double c)
	{
		name = n;
		checkingBal = c;
	}
    
	public Bank(String n, double c, double s)
	{
		name = n;
		checkingBal = c;
		savingsBal  = s;
	}

	public double getChecking()
	{
		return checkingBal;
	}

	public double getSavings()
	{
		return savingsBal;
	}

	public double getCombined()
	{
		return checkingBal + savingsBal;
	}

	public void checkingDeposit(double amount)
	{
		checkingBal += amount;
	}

	public void savingsDeposit(double amount)
	{
		savingsBal += amount;
	}

	public void closeChecking()
	{
		checkingBal = 0;
	}

	public void closeSavings()
	{
		savingsBal = 0;
	}

	public void showBalances()
	{
		System.out.println();
		System.out.println("Account balances for " + name);
		System.out.println("Checking: $" + getChecking());
		System.out.println("Savings:  $" + getSavings());
		System.out.println("Combined: $" + getCombined());
		System.out.println();
	}
	
	public void checkingWithdrawal(double m)
	{
	   
	  if(checkingBal+savingsBal<=m)
	  {
	   System.out.println();
	   System.out.println("Insufficient Funds: Withdrawal refused.");
	   System.out.println("Check Returned...$40 fee assessed");
	   checkingBal-=40;
	   }
	  else if(checkingBal<=m&&checkingBal+savingsBal>m)
	  {
	   double difference=m-checkingBal;
	   savingsBal=savingsBal-difference;
	   checkingBal=0;
	   }
	  else
	  {
	   checkingBal-=m; 
	   }
     
     
	}
	
	public void savingsWithdrawal(int m)
	{
	  
	  if(savingsBal<=m)
	  {
	   System.out.println();
	   System.out.println("Insufficient Funds: Withdrawal refused.");
	   }
	  else
	  {
	   savingsBal-=m; 
	   }
     
     
	}
	
	public void transferToChecking(int n)
	{
	   savingsBal-=n;
	   checkingBal+=n;
	}
	
	public void transferToSavings(int n)
	{
	   checkingBal-=n;
	   savingsBal+=n;
	}
	
	public void splitDeposit(int check, int percent)
	{
	  checkingBal= checkingBal+(percent*check/100);
	  savingsBal=savingsBal+((100-percent)*check/100);
	}
}


