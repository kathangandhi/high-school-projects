

public class BankAccount
{
  String name;
  double balance;
  
  public BankAccount(String n, double bal)
  {
    name=n;
    balance=bal;
  }
  
  public void deposit(double amt)
  {
    balance+=amt;    
  }
  
  public void withdraw(double amt)
  {
    balance-=amt;  
  }
  
}
