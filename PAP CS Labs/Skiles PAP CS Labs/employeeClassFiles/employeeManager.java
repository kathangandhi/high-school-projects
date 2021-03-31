
public class employeeManager
{
   public static void main(String Args[])
   {
       employee charlie = new employee();
       charlie.setName("Charlie", "Burnett");
       charlie.setWage(11.5);
       
       employee brandi = new employee("Brandi", "Gulde");
       brandi.setWage(10);
              
       employee teller = new employee("Teller", "Jones", 15);
       
       //Add 3 additional employees, witn YOU as employee #4.Each should have a first and last name, and wage
       
       
       //Add your additional three employees to the Employe Report here.	
	   employee kathan = new employee();
       kathan.setName("Kathan", "Gandhi");
       kathan.setWage(100);
       
       employee charly = new employee("Charly", "Jin");
       charly.setWage(20);
              
       employee mused = new employee("Mused", "Kamarathi", 2);
       
       //Add 3 additional employees, witn YOU as employee #4.Each should have a first and last name, and wage
       
       
       System.out.println();
       System.out.println("Employee Report");
       System.out.println("................................................................");
       System.out.println("ID \tName\t\tPayment");
       System.out.println(charlie.getID() +"\t"+ charlie.getName() +"\t$"+ charlie.calculatePayment(50)); 
       System.out.println(brandi.getID() +"\t"+ brandi.getName() +"\t$"+ brandi.calculatePayment(45)); 
       System.out.println(teller.getID() +"\t"+ teller.getName() +"\t$"+ teller.calculatePayment(30)); 
       System.out.println(kathan.getID() +"\t"+ kathan.getName() +"\t$"+ kathan.calculatePayment(1000)); 
       System.out.println(charly.getID() +"\t"+ charly.getName() +"\t$"+ charly.calculatePayment(53)); 
       System.out.println(mused.getID() +"\t"+ mused.getName() +"\t$"+ mused.calculatePayment(2)); 

       System.out.println();
       System.out.println("There are a total of " + employee.count + " employees.");
       
       
       
    }
    
}
