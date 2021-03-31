// Lab09Ast.java
// This is the student, starting file of Lab 09A.
// This file provides the completed Tree class which is the superclass for the PineTree class.
// The PineTree class is provided, but students need to write the redefined <drawLeaves> method.
// XmasTree will inherit from PineTree and is not provided.


import java.awt.*;
import java.applet.*;


public class Lab09Ast extends Applet
{
	public void paint(Graphics g)
	{
		XmasTree left = new XmasTree(250,300);
		left.drawTrunk(g);
		left.drawLeaves(g);
		left.drawBalls(g);
        left.drawMinis(g);
        left.drawStar(g);
        left.drawPresents(g);
        
        XmasTree right = new XmasTree(750,400);
		right.drawTrunk(g);
		right.drawLeaves(g);
		right.drawBalls(g);
        right.drawMinis(g);
        right.drawStar(g);
        right.drawPresents(g);
	}
}



class Tree
{
	// Do NOT alter this Tree class in any way!

	protected int x,y;

	public Tree()
	{
		x = 500;
		y = 400;
	}

	public void drawTrunk(Graphics g)
	{
		Expo.setColor(g,Expo.brown);
		Expo.fillRectangle(g,x-25,y-5,x+25,y+200);
	}

	public void drawLeaves(Graphics g)
	{
		Expo.setColor(g,Expo.darkGreen);
		Expo.fillCircle(g,x,y-100,100);
	}
}



class PineTree extends Tree
{
  public void drawLeaves(Graphics g)
  {
       /*Expo.setColor(g,Expo.green);
       Expo.fillRegularPolygon(g,x,y-100,190,3);*/
       Expo.setColor(g,Expo.green);
       Expo.fillRegularPolygon(g,x,y-70,130,3);
       Expo.fillRegularPolygon(g,x,y-150,100,3);
       Expo.fillRegularPolygon(g,x,y-200,80,3);
  }

  
}

class XmasTree extends PineTree
{
  public XmasTree(int xCor, int yCor)
  {
       x=xCor;
       y=yCor;
  }
  
  public void drawBalls(Graphics g)
  {
        Expo.setColor(g,Expo.red);
        Expo.fillCircle(g,x,y-150,10);
        Expo.fillCircle(g,x-25,y-125,10);
        Expo.fillCircle(g,x+10,y-75,10);
        Expo.fillCircle(g,x-30,y-100,10);
        Expo.fillCircle(g,x+15,y-100,10);
        Expo.fillCircle(g,x-20,y-175,10);
        Expo.fillCircle(g,x,y-35,10);
        Expo.fillCircle(g,x-30,y-40,10);
        Expo.fillCircle(g,x+30,y-115,10);
        Expo.fillCircle(g,x+25,y-175,10);
  }

  public void drawMinis(Graphics g)
  {
        Expo.setColor(g,Expo.white);
        Expo.fillStar(g,x+50,y-20,12,8);
        Expo.fillStar(g,x-60,y-15,12,8);
        Expo.fillStar(g,x,y-200,12,8);
        Expo.fillStar(g,x-60,y-75,12,8);
        Expo.fillStar(g,x+25,y-200,12,8);
        Expo.fillStar(g,x-30,y-150,12,8);
        Expo.fillStar(g,x+50,y-125,12,8);
        Expo.fillStar(g,x-30,y-190,12,8);
        Expo.fillStar(g,x-20,y-75,12,8);
        Expo.fillStar(g,x+45,y-70,12,8);

        
  }

  public void drawStar(Graphics g)
  {
        Expo.setColor(g,Expo.yellow);
        Expo.fillStar(g,x,y-300,50,5);
  }
  
  public void drawPresents(Graphics g)
  {
        Expo.setColor(g,Expo.red);
        Expo.fillRectangle(g,x-250,y+75,x-100,y+200);
        Expo.setColor(g,Expo.blue);
        Expo.fillRectangle(g,x+100,y+75,x+250,y+200);
        Expo.setColor(g,Expo.yellow);
        Expo.fillRectangle(g,x-180,y+75,x-170,y+200);
        Expo.fillRectangle(g,x-250,y+132,x-100,y+142);
        Expo.fillRectangle(g,x+170,y+75,x+180,y+200);
        Expo.fillRectangle(g,x+100,y+132,x+250,y+142);
        
       
        
  }
}
