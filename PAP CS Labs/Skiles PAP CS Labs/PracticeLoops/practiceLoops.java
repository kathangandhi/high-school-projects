
import java.awt.*;
import java.applet.*;


public class practiceLoops extends Applet
{

    public void paint(Graphics g)
    {
    
    int x1 = 200 ;
    int y1 = 200;
    int x2 = 600;
    int y2 = 200;
    int r = 50;
    
    
    Expo.setColor(g, Color.red);
    Expo.drawRectangle(g, 200, 200,600, 600); 
    Expo.setColor(g, Color.blue);
    int i;
    for(i = 0; i <= 40; i++)
    {
     Expo.drawLine(g, x1, y1, x2, y2);
     y1+=10;
     y2+=10;
    }
    
    //Fixed Repetition Loop
  
    for(i = 0; i < 50; i++)
    {
      //Expo.drawLine(g, x1, y1, x2, y2);
      x1 += 10;
      x2 += 20;
      
    }
    
    x1 = 150;
    y1 = 100;
   
    for (i = 0; i<=5; i++)
    {
      Expo.fillStar(g, x1, y1, r, 5);
      x1 += 100;
    }
   
    for (i = 0; i<=5; i++)
    {
      Expo.fillStar(g, x1, y1, r, 5);
      x1 += 100;
      y1 += 100;
    }
    
    //Open Repetition Loop


    }

}


