import java.awt.*;
import java.applet.*;

class dog
{
    
    //All components of the dogs must be based of these x & y coordinates
    private int x;
    private int y;
    
    public dog()
    {
	 //Start with the values below, but you may need to 
	 //modify them based on the sky coordinates you used.        
	 //Randomly assign a  x value from 300 - 700
     x=Expo.random(300,700);
     //Randomly assign a y value from 325 - 500
     y=Expo.random(325,500);   
    }
    
    
    public dog(int xCord, int yCord)
    {
       //Initialize the private x and y values.  
       x=xCord;
       y=yCord;
    }
    
    public void showDog(Graphics g)
    {
      drawBody(g); 
      drawFace(g);  
    }
    
    private void drawBody(Graphics g)
    {
       //This method must be called from the showDog() method.
       
       //Draw tail (Create this last)
       Expo.setColor(g,Expo.tan);
       Expo.drawArc(g,x+95,y-20,10,10,90,180);
       Expo.drawArc(g,x+95,y-19,10,10,90,180);
       Expo.drawArc(g,x+95,y-18,10,10,90,180);
       Expo.drawArc(g,x+95,y-17,10,10,90,180);
       Expo.drawArc(g,x+95,y-16,10,10,90,180);
       Expo.drawArc(g,x+95,y-15,10,10,90,180);
       
       //Draw torso 
       Expo.setColor(g,Expo.tan);
       Expo.fillOval(g,x,y,100,50);
       
       
       //Draw legs
       Expo.fillOval(g,x-80,y+30,10,40);
       Expo.fillOval(g,x-60,y+30,10,30);
       Expo.fillOval(g,x+60,y+30,10,30);
       Expo.fillOval(g,x+80,y+30,10,40);
      
       
    }
    
    private void drawFace(Graphics g)
    {
        //Draw ears (Create this after creating the head)
        Expo.setColor(g,Expo.brown);
        Expo.fillPolygon(g,x-150,y-80,x-130,y-110,x-110,y-80);
        Expo.fillPolygon(g,x-30,y-80,x-50,y-110,x-70,y-80);
        
        //Draw head
        Expo.setColor(g,Expo.tan);
        Expo.fillCircle(g,x-90,y-50,50);
        Expo.setColor(g,Expo.black);
        Expo.drawCircle(g,x-90,y-50,50);
       
        
                
        
        //Draw nose and mouth
        Expo.setColor(g,Expo.brown);
        Expo.fillCircle(g,x-90,y-35,25);
        Expo.setColor(g,Expo.black);
        Expo.fillCircle(g,x-90,y-45,10);
        Expo.drawArc(g,x-100,y-30,10,5,90,270);
        Expo.drawArc(g,x-80,y-30,10,5,90,270);
        
        //Draw Eyes
        Expo.setColor(g,Expo.white);
        Expo.fillCircle(g,x-110,y-60,15);
        Expo.setColor(g,Expo.white);
        Expo.fillCircle(g,x-70,y-60,15);
        Expo.setColor(g,Expo.black);
        Expo.fillCircle(g,x-110,y-60,12);
        Expo.setColor(g,Expo.black);
        Expo.fillCircle(g,x-70,y-60,12);
        
        
        
    }
        
}