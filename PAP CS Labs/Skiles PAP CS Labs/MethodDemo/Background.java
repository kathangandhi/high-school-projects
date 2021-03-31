import java.awt.*;
import java.applet.*;

public class Background
{
    
     public static void drawSky(Graphics g)
     {
        //Draw Sky
        Expo.setColor(g, Expo.blue);
        Expo.fillRectangle(g, 0, 0, 1000, 325);
        Expo.setColor(g, Expo.green);
        Expo.fillRectangle(g, 0, 325, 1000, 650);
     }
    
     public static void drawSun(Graphics g)
     {
        //Draw Sky
        Expo.setColor(g, Expo.yellow);
        Expo.fillStar(g, 850, 125, 100, 100);
     }
    
     public static void drawClouds(Graphics g)
     {
        //Draw Sky
        Expo.setColor(g, Expo.white);
        Expo.fillCircle(g, 300, 100, 50);
        Expo.fillCircle(g, 250, 125, 50);
        Expo.fillCircle(g, 325, 115, 50);
        Expo.fillCircle(g, 375, 100, 50);
        Expo.fillCircle(g, 325, 130, 50);
     }
    
    
}
