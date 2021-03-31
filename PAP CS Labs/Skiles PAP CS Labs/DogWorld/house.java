import java.awt.*;
import java.applet.*;

class house
{
    //All parts of the dog house must be based off these x and y coordinates.
    private int x;
    private int y;
    
    public house()
    {
        //Start with the values below, but you may need to 
	    //modify them based on the sky coordinates you used.
	    //Select a random x value from 300 - 700.
	    x=Expo.random(300,700);
        //Select a random y value from 125 - 200
        y=Expo.random(125,200);
              
    }
    
    public void showHouse(Graphics g)
    {
     drawFrame(g);
     drawDoor(g);
    }
    
    private void drawFrame(Graphics g)
    {
        //This method must be called from the showHouse() method.
        Expo.setColor(g,Expo.white);
        Expo.fillPolygon(g,x-100,y,x,y-50,x+100,y);
        Expo.fillRectangle(g,x-70,y,x+70,y+150);
    }
    
    private void drawDoor(Graphics g)
    {
       //This method must be called from the showHouse() method.
       Expo.setColor(g,Expo.black);
       Expo.fillRectangle(g,x-50,y+50,x+50,y+150);
       Expo.fillCircle(g,x,y+50,50);
    }
    
    
}