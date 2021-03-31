

import java.util.*;

public class speedingTicket
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Speeding Ticket Lab");
		System.out.println();
		
		System.out.print("What was the speed limit? >>>" );
		int speedlimit = input.nextInt();
		System.out.print("How fast was the car travelling? >>>" );
		int speed = input.nextInt();
		System.out.print("Did it occur in a shool zone? [Y/N] >>>" );
		input.nextLine();
		String school = input.nextLine();
		int difference = speed - speedlimit;
		int extra;
		int multiplier;
		if (difference > 30)
		{
		  extra = 160;
		  
        }
         else 
		  {
		    extra = 0;
		  }

         if (school.equalsIgnoreCase ("Y"))
		{
		  multiplier = 2;
		  
        }
        else 
		  {
		    multiplier = 1;
		  }
		
        int charge = multiplier*((75 + extra) + 6*(difference));
        System.out.print("Ticket Amount >>>"+charge );
		
        
		
		





		System.out.println();
	}
}
