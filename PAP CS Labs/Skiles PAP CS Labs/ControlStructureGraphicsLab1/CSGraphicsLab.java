// GraphicsLab02st.java
// This is the student, starting version of Graphics Lab 02 which is divided into 8 cells.
// The first cell -- "Draw Red Horizontal Lines" -- is provided as an example.
// Students need to complete the other 7 cells on their own.

import java.awt.*;
import java.applet.*;

public class CSGraphicsLab extends Applet
{
	public void paint(Graphics g)
	{
		// Draw Grid
		Expo.drawLine(g,250,0,250,650);
		Expo.drawLine(g,500,0,500,650);
		Expo.drawLine(g,750,0,750,650);
		Expo.drawLine(g,0,325,1000,325);

		int x1, y1, x2, y2, x, y, r;

		// Draw Red Horizontal Lines
		Expo.setColor(g,Expo.red);
		x1 = 0;
		y1 = 5;
		x2 = 250;
		y2 = 5;
		
		for (int j = 1; j <= 32; j++)
		{
			Expo.drawLine(g,x1,y1,x2,y2);
			y1 += 10;
			y2 += 10;
		}


		// Draw Blue Vertical Lines
		Expo.setColor(g,Expo.blue);
		x1 = 255;
		y1 = 0;
		x2 = 255;
		y2 = 325;
		
		for (int j = 1; j <= 25; j++)
		{
			Expo.drawLine(g,x1,y1,x2,y2);
			x1 += 10;
			x2 += 10;
		}





		// Draw Gray Diagonal Dots
		Expo.setColor(g,Expo.gray);
		x1 = 505;
		y1 = 275;
		
		for (int j = 1; j <= 25; j++)
		{
			Expo.drawPoint(g,x1,y1);
			x1 += 10;
			y1 -= 10;
		}






		// Draw Green Concentric Circles
		Expo.setColor(g,Expo.green);
		x1 = 882;
		y1 = 157;
		r = 5;
		
		for (int j = 1; j <= 25; j++)
		{
			Expo.drawCircle(g,x1,y1,r);
			r += 5;
		}






		// Draw Purple Concentric Ovals
		Expo.setColor(g,Expo.purple);
		x1 = 125;
		y1 = 500;
		x = 10;
		y = 15;
		
		for (int j = 1; j <= 15; j++)
		{
			Expo.drawOval(g,x1,y1,x,y);
			x += 5;
			y += 10;
		}






		// Draw Pink Concentric Arcs
		Expo.setColor(g,Expo.pink);
		x1 = 250;
		y1 = 650;
		x = 5;
		y = 10;
		x2 = 0;
		y2 = 90;
		
		for (int j = 1; j <= 25; j++)
		{
			Expo.drawArc(g,x1,y1,x,y,x2,y2);
			x += 10;
			y += 10;
		}





		// Draw Brown Concentric Rectangles
		Expo.setColor(g,Expo.pink);
		x1 = 612;
		y1 = 475;
		x2 = 637;
		y2 = 525;
		
		for (int j = 1; j <= 12; j++)
		{
			Expo.drawRectangle(g,x1,y1,x2,y2);
			x1 -= 10;
		    y1 -= 10;
		    x2 += 10;
		    y2 += 10;
		}






		// Draw Gold Sphere
		Expo.setColor(g,Expo.gold);
		x1 = 875;
		y1 = 500;
		x2 = 5;
		y2 = 125;
		
		for (int j = 1; j <= 12; j++)
		{
			Expo.drawOval(g,x1,y1,x2,y2);
			x2 += 10;
		    
		}
        
		Expo.setColor(g,Expo.gold);
		x1 = 875;
		y1 = 500;
		x2 = 120;
		y2 = 5;
		
		for (int j = 1; j <= 12; j++)
		{
			Expo.drawOval(g,x1,y1,x2,y2);
			y2 += 10;
		    
		}






	}
}




