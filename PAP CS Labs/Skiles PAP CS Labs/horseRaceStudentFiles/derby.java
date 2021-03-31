 

import java.awt.Graphics;
import java.applet.*;
import java.awt.Color;

 public class derby extends Applet
 {

    boolean horseA = false;
    boolean horseB = false;
    boolean horseC = false;
    boolean winnerC = false;
    boolean winner = true;

    public void paint(Graphics g)
    {
     horse A = new horse("Chicken Soup", 10);
     horse B = new horse("Choppy Bunny", 8);
     horse C = new horse("True Wonder", 9);
    
     track Track=new track();
     Track.showTrack(g);
     
     Track.addHorse(1,A);
     Track.addHorse(2,B);
     Track.addHorse(3,C);
     
     A.showHorse(g);
     B.showHorse(g);
     C.showHorse(g);
     
     do
     {
      A.run(g);
      B.run(g);
      C.run(g);
      
      horseA=Track.checkFinish(A.getPosition());
      horseB=Track.checkFinish(B.getPosition());
      horseC=Track.checkFinish(C.getPosition());
      
      try
      {
       Thread.sleep(100);
      }
      catch (Exception e) {}
      
      
      
     }
     while(horseA!=winner&&horseB!=winner&&horseC!=winner);
     Expo.setFont(g,"Arial",100,36);
     if(horseA=true)
     Expo.drawString(g,A.getName()+" has won.",200,300);
     else if(horseB=true)
     Expo.drawString(g,B.getName()+" has won.",200,300);
     else if(horseC=true)
     Expo.drawString(g,C.getName()+" has won.",200,300);
     
     
     
    }
 }

 