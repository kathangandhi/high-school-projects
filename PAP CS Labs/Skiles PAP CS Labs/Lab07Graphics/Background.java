import java.awt.*;
import java.applet.*;

public class Background
{
   public static void Sky(Graphics g)
   {
    Expo.setColor(g,Expo.blue);
    Expo.fillRectangle(g,0,0,1000,325);
   }
   
    public static void Grass(Graphics g)
   {
    Expo.setColor(g,Expo.green);
    Expo.fillRectangle(g,0,325,1000,650);
   }
   
   public static void Sun(Graphics g)
   {
    Expo.setColor(g,Expo.yellow);
    Expo.fillStar(g,850,100,75,100);
   }
   }

