import java.awt.*;
import java.applet.*;


public class methodDemo extends Applet
{
    public void paint(Graphics g)
    {
        //Draw Sky
        Background.drawSky(g);
        
        //Draw Sun
        Background.drawSun(g);
        
        //Draw Clouds
        Background.drawClouds(g);




    }

   
}





