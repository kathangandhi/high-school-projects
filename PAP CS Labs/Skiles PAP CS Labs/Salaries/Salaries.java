

public class Salaries
{
   public static void main (String args[]){
    //Problem 1
    String hi = "Hi";
    String Mom = "Mom";
    System.out.println(hi+", "+Mom);
    //Problem 2
    String hi2 = "Hi,";
    String Mom2 = "Mom!";
    System.out.println(hi2+Mom2);
    //Problem 3
    String someName = "Bob";
    String hello = "Hello,";
    System.out.println(hello+someName+"!");
    //Problem 4
    String world = "World";
    String goodbye = "Goodbye";
    System.out.println(hello+world+"..."+goodbye);
    //Problem 5
    System.out.println("Nothing");
    //Salaries
    int hourlyrate = 8;
    System.out.println("Hourly Rate >>> "+hourlyrate);
    int hourswork = 10;
    System.out.println("Hours Worked >>> "+hourswork);
    int overtimehours = 5;
    double overtimerate = 1.5*hourlyrate;
    System.out.println("Overtime Hours >>> "+overtimehours);
    double totalsalary = (hourlyrate*hourswork)+(overtimehours*overtimerate);
    System.out.println("Total Salary >>> "+totalsalary);
    double taxrate = 0.25;
    double netsalary = totalsalary - (0.25*totalsalary);
    System.out.println("Net Salary >>> "+netsalary);
   
   
   
   
   
   
   
   
   
    
    
    }
}
