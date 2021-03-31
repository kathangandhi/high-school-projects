
import java.awt.*;
import java.applet.*;

public class Pool
{
   public static void Pool(Graphics g,int x1, int y1, int r)
   {
    Expo.setColor(g,Expo.lightBlue);
    Expo.fillCircle(g,x1,y1,r);
   }
   public static void Tree(Graphics g)
   {
    Expo.setColor(g,Expo.brown);
    Expo.fillRectangle(g,800,400,850,600);
    Expo.setColor(g,Expo.darkGreen);
    for(int k=1;k<=100;k++)
    {int x1=Expo.random(775,875); 
     int y1=Expo.random(380,300);
     int r=Expo.random(1,50);
     Expo.fillCircle(g,x1,y1,r);
    }
   }
   public static void Man(Graphics g)
   {
    Expo.setColor(g,Expo.tan);
    Expo.fillCircle(g,500,400,25);
    Expo.setColor(g,Expo.black);
    Expo.fillCircle(g,490,400,5);
    Expo.fillCircle(g,510,400,5);
    Expo.fillArc(g,500,390,25,20,270,90);
    Expo.drawArc(g,500,410,5,2,90,270);
    Expo.setColor(g,Expo.red);
    Expo.fillRectangle(g,480,425,520,475);
    Expo.setColor(g,Expo.blue);
    Expo.fillRectangle(g,480,475,520,525);
    Expo.setColor(g,Expo.black); 
    Expo.drawLine(g,480,435,460,440);
    Expo.drawLine(g,520,435,540,440);
    Expo.drawLine(g,490,525,490,550);
    Expo.drawLine(g,510,525,510,550);
   }
}