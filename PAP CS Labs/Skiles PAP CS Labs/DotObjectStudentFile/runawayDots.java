
import java.awt.Graphics;
import java.applet.*;
import java.awt.Color;


public class runawayDots extends Applet
{
public void paint(Graphics g)
{
 Dot dot1 = new Dot();
 Dot dot2 = new Dot();
 World world = new World();
 world.showWorld(g);
 //Comment out the two lines below after the showDot(g) method is complete.
 //dot1.showDot(g);
// dot2.showDot(g);
 //Uncomment and run after showDot() is working.
 
 for(int i=0; i< 300; i++)
 {
  dot1.moveDot(g);
  dot2.moveDot(g);
  try
  {
   Thread.sleep(50);  
  }
  catch(Exception e){}
 }
 
}
}
class Dot
{
 //Add private class variables here, you need an xPos, yPos, and color.
private int xPos;
private int yPos;
private String color;

public Dot()
{
  //Get a random starting position for the dot AND a random color or red, blue, or green.
  xPos=Expo.random(100,750);
  yPos=Expo.random(100,450);
  int Color=Expo.random(1,3);
  if(Color==1)
  {
   color="Red"; 
  }
  else if(Color==2)
  {
   color="Blue"; 
  }
  else if(Color==3)
  {
   color="Green"; 
  }
}
public void showDot(Graphics g)
{
  //Display the dots initial starting position.
  if(color.equals("Red"))
  {
   Expo.setColor(g,Expo.red); 
  }
  else if(color.equals("Blue"))
  {
   Expo.setColor(g,Expo.blue);  
  }
  else if(color.equals("Green"))
  {
   Expo.setColor(g,Expo.green);   
  }
  Expo.fillCircle(g,xPos,yPos,50);
}
public void moveDot(Graphics g)
{
  //Move the dot one position up, down, left, or right randomly selected
  int direction = Expo.random(1,4);
  int newX=xPos;
  int newY=yPos;
  if(direction==1)//right
  {
    removeDot(g);
    newX=newX+10;
   if(newX>=750)
    {
        xPos=newX-15;
        showDot(g);
    }
   else
    {
        xPos=newX;
        showDot(g);  
    }
  }
  else if(direction==2)
  {
      removeDot(g);
      newX=newX-10;
   if(newX<=100)
    {
        xPos=newX+15;
        showDot(g);
    }
   else
    {
        xPos=newX;
        showDot(g);  
    }
  }
  else if(direction==3)
  {
     removeDot(g);
     newY=newY+10;
   if(newY>450)
   { 
     yPos=newY-15;
     showDot(g);
    } 
   else
   {
     yPos=newY;
     showDot(g);
   }
  }
  else if(direction==4)
  {
   removeDot(g);
   newY=newY-10;
   if(newY<=100)
   {
     yPos=newY+15;
     showDot(g);
    } 
   else
   {
     yPos=newY;
     showDot(g);
   }
  }
  
  
}
private void removeDot(Graphics g)
{
  //Removes the dot by drawing a white circle over the dot
  Expo.setColor(g,Expo.white);
  Expo.fillCircle(g,xPos,yPos,50);
} 
}
class World
{
 private int x1, y1, x2, y2;
 World()
 {
  x1 = 50;
  y1 = 50;
  x2=800;
  y2=500;
 }
 public void showWorld(Graphics g)
 {
  Expo.drawRectangle(g, x1, y1, x2, y2);
 }

}
