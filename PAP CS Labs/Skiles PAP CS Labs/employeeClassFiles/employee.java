

public class employee
{
  private String fName;
  private String lName;
  private double wage;
  private int ID;
  public static int count=0;
  private double payment;
  
  public employee()
  {
   fName="Blank";
   lName="Blank";
   wage=0.0;
   ID=count;
   count++;
   confirm();
  }
  
  public employee(String f, String l){
   fName=f;
   lName=l;
   wage=0.0;
   ID=count;
   count++;
   confirm();
  }
  
  public employee(String f, String l, double w)
  {
   fName=f;
   lName=l;
   wage=w;
   ID=count;
   count++;
   confirm();
  }
  
  public employee(String f, String l, double w, int i)
  {
   fName=f;
   lName=l;
   wage=w;
   ID=i;
   count++;
  }
  
  private void confirm()
  {
   System.out.println("Employee "+fName+" "+lName+" has been created");
  }
  
  public void setName(String f, String l)
  {
   fName=f;
   lName=l;
  }
  
  public String getName()
  {
   return fName+" "+lName;   
  }
  
  public void setWage(double w)
  {
   wage=w;  
  }
  
  public double getWage()
  {
   return wage;  
  }
  
  public int getID()
  {
   return ID;  
  }
  
  public double calculatePayment(int hours)
  {
   if(hours<=40)
   {
    payment=wage*hours;
    return payment;
   }
   else
   {
    int difference=hours-40;
    payment=(wage*hours)+(wage*difference)/2;
    return payment;
   }
  }
}
