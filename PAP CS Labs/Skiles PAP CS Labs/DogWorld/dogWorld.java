

import java.awt.*;
import java.applet.*;

public class dogWorld extends Applet
{
    public void paint(Graphics g)
    {
       
        yard yard1 = new yard();
        yard1.showYard(g);
        
        house house1 = new house();
        house1.showHouse(g);
        
        dog dog1 = new dog();
        dog1.showDog(g);
        
        
    
    }

}



