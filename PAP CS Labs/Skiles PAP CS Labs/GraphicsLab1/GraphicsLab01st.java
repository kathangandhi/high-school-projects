// GraphicsLab01st.java
// The Expo Graphics Program
// This is the student, starting version, of Graphics Lab 01.


import java.awt.*;
import java.applet.*;


public class GraphicsLab01st extends Applet
{

	public void paint(Graphics g)
	{
		// DRAW CUBE
		Expo.drawLine(g,50,300,50,50);
		Expo.drawLine(g,50,50,300,50);
		Expo.drawLine(g,50,50,150,150);
		Expo.drawLine(g,50,300,150,400);
		Expo.drawLine(g,150,150,150,400);
		Expo.drawLine(g,150,400,400,400);
		Expo.drawLine(g,50,300,300,300);
		Expo.drawLine(g,50,300,50,50);
		Expo.drawLine(g,300,300,400,400);
		Expo.drawLine(g,300,50,300,300);
		Expo.drawLine(g,300,50,400,150);
		Expo.drawLine(g,400,150,400,400);
		Expo.drawLine(g,150,150,400,150);
		Expo.drawCircle(g,225,225,125);
		Expo.drawOval(g,225,225,125,100);
		Expo.drawOval(g,225,225,125,75);
		Expo.drawOval(g,225,225,125,50);
		Expo.drawOval(g,225,225,125,25);
		Expo.drawOval(g,225,225,100,125);
		Expo.drawOval(g,225,225,75,125);
		Expo.drawOval(g,225,225,50,125);
		Expo.drawOval(g,225,225,25,125);
		
		
		
		






		// DRAW TARGET
		Expo.fillCircle(g,600,200,125);
		Expo.setColor(g,Expo.white);
		Expo.fillCircle(g,600,200,100);
		Expo.setColor(g,Expo.blue);
		Expo.fillCircle(g,600,200,75);
		Expo.setColor(g,Expo.red);
		Expo.fillCircle(g,600,200,50);
		Expo.setColor(g,Expo.yellow);
		Expo.fillCircle(g,600,200,25);
		Expo.setColor(g,Expo.black);
		






		// DRAW TRIANGLE
		Expo.drawLine(g,900,75,900,275);
		Expo.drawLine(g,800,275,1000,275);
		Expo.drawLine(g,800,275,900,75);
		Expo.drawLine(g,900,75,1000,275);
		Expo.drawLine(g,840,187,1000,275);
		Expo.drawLine(g,800,275,957,187);
		






		// DRAW SMILEY FACE
		Expo.setColor(g,Expo.yellow);
		Expo.fillOval(g,700,450,100,100);
		Expo.setColor(g,Expo.white);
		Expo.fillOval(g,675,400,25,25);
		Expo.fillOval(g,725,400,25,25);
		Expo.setColor(g,Expo.black);
		Expo.drawPoint(g,675,400);
		Expo.drawPoint(g,725,400);
		Expo.drawArc(g,700,450,50,50,90,270);
		Expo.drawArc(g,675,400,25,30,270,90);
		Expo.drawArc(g,725,400,25,30,270,90);
		
		






		// DRAW LHS
		Expo.setColor(g,Expo.black);
		Expo.drawRectangle(g,75,425,125,600);
		Expo.fillRectangle(g,75,425,125,600);
		Expo.drawRectangle(g,125,550,200,600);
		Expo.fillRectangle(g,125,550,200,600);
		Expo.drawRectangle(g,225,425,275,600);
		Expo.fillRectangle(g,225,425,275,600);
		Expo.drawRectangle(g,275,500,325,525);
		Expo.fillRectangle(g,275,500,325,525);
		Expo.drawRectangle(g,325,425,375,600);
		Expo.fillRectangle(g,325,425,375,600);
		Expo.drawRectangle(g,400,425,450,525);
		Expo.fillRectangle(g,400,425,450,525);
		Expo.drawRectangle(g,450,425,525,475);
		Expo.fillRectangle(g,450,425,525,475);
		Expo.drawRectangle(g,450,500,525,525);
		Expo.fillRectangle(g,450,500,525,525);
		Expo.drawRectangle(g,475,525,525,600);
		Expo.fillRectangle(g,475,525,525,600);
		Expo.drawRectangle(g,400,550,500,600);
		Expo.fillRectangle(g,400,550,500,600);
		






	}

}


