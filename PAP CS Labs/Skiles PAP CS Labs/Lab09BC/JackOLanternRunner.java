import java.awt.*;
import java.applet.*;
import java.awt.*;

public class JackOLanternRunner extends Applet
{
  public void paint(Graphics g)
  {
    JackOLantern j= new JackOLantern();
    j.drawPumpkin(g);
    j.drawFace(g);
  }

}

class pumpkin
{
  protected int x,y;
  
  public pumpkin()
  {
    x=500;
    y=325;
  }
  
  public void drawPumpkin(Graphics g)
  {
    Expo.setColor(g,Expo.yellow);
    Expo.fillOval(g,x,y,200,150);
    Expo.setColor(g,Expo.green);
    Expo.fillRectangle(g,x-10,y-200,x+10,y-150);
  }
  
}

class JackOLantern extends pumpkin
{
  public void drawFace(Graphics g)
  {
    Expo.setColor(g,Expo.black);
    Expo.fillCircle(g,x-100,y-75,30);
    Expo.fillCircle(g,x+100,y-75,30);
    Expo.fillRegularPolygon(g,x,y,40,3);
    Expo.fillArc(g,x,y+75,100,50,90,270);
    
  }
}