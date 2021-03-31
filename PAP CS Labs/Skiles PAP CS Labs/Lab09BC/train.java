import java.awt.*;
import java.applet.*;
import java.awt.*;

public class train extends Applet
{
  public void paint(Graphics g)
  {
    locomotive j= new locomotive(100,325,"Blue");
    j.drawCar(g);
    j.drawLocomotive(g);
    trainCar k= new trainCar(220,325,"Green");
    k.drawCar(g);
    trainCar l= new trainCar(340,325,"Yellow");
    l.drawCar(g);
    trainCar m= new trainCar(460,325,"Pink");
    m.drawCar(g);
    trainCar n= new trainCar(580,325,"Cyan");
    n.drawCar(g);
    kabooze o= new kabooze(700,325,"Red");
    o.drawCar(g);
    o.drawKabooze(g);
    
    
    
    
  }

}

class trainCar
{
  protected int x,y;
  protected String col;
  
  public trainCar(int xPos, int yPos, String color)
  {
    x=xPos;
    y=yPos;
    col=color;
  }
  
  public void drawCar(Graphics g)
  {
    if(col.equals("Green"))
     Expo.setColor(g,Expo.green);
    else if(col.equals("Blue"))
     Expo.setColor(g,Expo.blue);
    else if(col.equals("Yellow")) 
     Expo.setColor(g,Expo.yellow);
    else if(col.equals("Pink"))
     Expo.setColor(g,Expo.pink);
    else if(col.equals("Cyan"))
     Expo.setColor(g,Expo.cyan);
    else if(col.equals("Red"))
     Expo.setColor(g,Expo.red);
    Expo.fillRectangle(g,x-50,y-30,x+50,y+30);
    Expo.setColor(g,Expo.black);
    Expo.fillCircle(g,x-40,y+30,10);
    Expo.fillCircle(g,x+40,y+30,10);
    
  }
  
}

class kabooze extends trainCar
{
  public kabooze(int x, int y, String color)
  {
    super(x,y,color);
  }
    
  public void drawKabooze(Graphics g)
  {
    Expo.setColor(g,Expo.red);
    Expo.fillRectangle(g,x-40,y-35,x+40,y-30);
    Expo.setColor(g,Expo.black);
    Expo.fillRectangle(g,x-43,y-40,x+43,y-35);
    Expo.setColor(g,Expo.white);
    Expo.fillRectangle(g,x-30,y-10,x-20,y+10);
    Expo.fillRectangle(g,x+20,y-10,x+30,y+10);

  }
}

class locomotive extends trainCar
{
  public locomotive(int x, int y, String color)
  {
    super(x,y,color);
  }
    
  public void drawLocomotive(Graphics g)
  {
    Expo.setColor(g,Expo.black);
    Expo.fillPolygon(g,x-50,y+30,x-50,y+10,x-80,y+30);
    Expo.fillRectangle(g,x-20,y-50,x-10,y-30);
    Expo.fillArc(g,x-15,y-55,10,15,90,270);
  }  
}