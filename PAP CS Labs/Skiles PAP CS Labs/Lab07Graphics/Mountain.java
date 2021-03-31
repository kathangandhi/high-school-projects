import java.awt.*;
import java.applet.*;

public class Mountain
{
   public static void Mountain(Graphics g,int x1,int y1,int x2, int y2, int x3, int y3)
   {
    Expo.setColor(g,Expo.brown);
    Expo.fillPolygon(g,x1,y1,x2,y2,x3,y3);
   }
   public static void Snowcap(Graphics g,int x1,int y1,int hr,int vr,int va,int ha)
   {
    Expo.setColor(g,Expo.white);
    Expo.fillArc(g,x1,y1,hr,vr,va,ha);
   }
    public static void River(Graphics g,int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4)
   {
    Expo.setColor(g,Expo.lightBlue);
    Expo.fillPolygon(g,x1,y1,x2,y2,x3,y3,x4,y4);
   }
}