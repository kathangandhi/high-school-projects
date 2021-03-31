

public class player
{
  private double bank;
  private String name;
  
  public player(String n, double b)
  {
   name=n;
   bank=b;
  }
  
  public void play(slotMachine m)
  {
  if(bank<25)
  {
   System.out.println("Not enough money");  
  } 
  else
  {
   bank-=25;
   bank += m.play(25);
  }
  }
  
  public double getBank()
  {
   return bank;  
  }
}
