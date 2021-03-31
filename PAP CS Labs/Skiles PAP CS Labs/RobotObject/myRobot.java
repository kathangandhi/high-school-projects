
import java.awt.*;
import java.applet.*;


public class myRobot extends Applet
{
	

	public void paint(Graphics g)
	{


	//Part 1 - These will create three robots using the default constructor
	robot sam = new robot(g);
	sam.changeColor(g,"blue");
	robot pam = new robot(g);
	robot marty = new robot(g);
    sam.showRobot(g);
    pam.showRobot(g);
    marty.showRobot(g);

		
	//Part 2 - These will create two robots using overloaded constructors 
	robot ted = new robot(g, 200, 200);
	robot randy = new robot(g, 400, 300, "red");
    
    ted.showRobot(g);
    randy.showRobot(g);
	}

}

class robot
{
	private int xPos;
	private int yPos;
	private String color;
	
	
	robot(Graphics g)
	{
	 int colors=Expo.random(1,3);
	 if (colors==1)
     {
         color="red";
     }
     else if (colors==2)
     {
         color="blue";
     }
     else if (colors==3)
     {
         color="green";
     }
     xPos=Expo.random(300,700);
	 yPos=Expo.random(100,550);
	}
	
	robot(Graphics g,int x, int y)
	{
	 int colors=Expo.random(1,3);
	 if (colors==1)
     {
         color="red";
     }
     else if (colors==2)
     {
         color="blue";
     }
     else if (colors==3)
     {
         color="green";
     }
	 xPos=x;
	 yPos=y;
	}
	
	robot(Graphics g,int x, int y, String colors)
	{
	 if (colors.equals("blue"))
     {
         color="blue";
     }
     else if (colors.equals("red"))
     {
         color="red";
     }
     else if (colors.equals("green"))
     {
         color="green";
     }
	 xPos=x;
	 yPos=y;
	}
	
    public void showRobot(Graphics g)
    {
        if (color.equals("blue"))
     {
         Expo.setColor(g,Expo.blue);
     }
     else if (color.equals("red"))
     {
         Expo.setColor(g,Expo.red);
     }
     else if (color.equals("green"))
     {
         Expo.setColor(g,Expo.green);
     }
     Expo.fillRectangle(g,xPos-75,yPos-50,xPos+75,yPos+50);
     Expo.setColor(g,Expo.black);
     Expo.drawCircle(g,xPos,yPos,100);
    }
    
    public void changeColor(Graphics g, String colors)
    {
     color=colors;
    }
}

