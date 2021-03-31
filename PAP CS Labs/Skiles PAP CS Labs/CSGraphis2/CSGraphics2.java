
import java.awt.*;
import java.applet.*;


public class CSGraphics2 extends Applet
{
	public void paint(Graphics g)
	{
		int width = 980;
		int height = 630;
		int x1 = 10;
		int y1 = 640;
		int x2 = 990;
		int y2 = 640;
		g.drawRect(10,10,width,height);
		
		//Draw bottom left corner
		Expo.setColor(g,Color.black);
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,x1,630,990,y2);
		  y2-=20;
		  x1+=31;
		  
		  }
		
		//Draw bottom right corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,10,y1,x2,640);
		  y1-=20;
		  x2-=31;
		  
		  }
		
		 x1 = 10;
		 y1 = 10;
		 x2 = 990;
		 y2 = 640;
		
		//Draw top right corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,990,y2,x2,10);
		  y2-=20;
		  x2-=31;
		  
		  }
		 
		 x1 = 10;
		 y1 = 10;
		 x2 = 990;
		 y2 = 640;
		
		 //Draw top left corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,10,y1,x2,10);
		  y1+=20;
		  x2-=31;
		  
		  }
		  
		Expo.drawRectangle(g,250,163,750,480);
		Expo.setColor(g,Color.black);
		
		 x1 = 250;
		 y1 = 487;
		 x2 = 750;
		 y2 = 487;
		
		 //Draw bottom left corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,x1,487,750,y2);
		  y2-=10;
		  x1+=16;
		  
		  }
		
		//Draw bottom right corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,250,y1,x2,487);
		  y1-=10;
		  x2-=16;
		  
		  }
		
		 x1 = 250;
		 y1 = 487;
		 x2 = 750;
		 y2 = 487;
		
		//Draw top right corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,750,y2,x2,163);
		  y2-=10;
		  x2-=16;
		  
		  }
		 
		 x1 = 250;
		 y1 = 487;
		 x2 = 750;
		 y2 = 487;
		
		 //Draw top left corner
		for (int j=0;j<32;j++){
		  Expo.drawLine(g,250,y1,x1,163);
		  y1-=10;
		  x1+=16;
		  
		  }
		
		  
		  
	}
}

