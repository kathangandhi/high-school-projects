import java.awt.*;
import java.applet.*;

//This class does not need a constructor.

class yard
{
    
    public void showYard(Graphics g)
    {
        //The sky should fill approximately 1/3 of the applet.
        Expo.setColor(g,Expo.blue);
        Expo.fillRectangle(g,0,0,1000,220);
        //The grass should fill approximately 2/3 of the applet.
        Expo.setColor(g,Expo.green);
        Expo.fillRectangle(g,0,220,1000,650);
    }

}