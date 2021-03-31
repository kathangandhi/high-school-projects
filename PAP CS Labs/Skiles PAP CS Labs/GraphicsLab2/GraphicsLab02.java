
import java.awt.*;
import java.applet.*;


public class GraphicsLab02 extends Applet
{

	public void paint(Graphics g)
	{
		//Background
		Expo.setColor(g,Expo.blue);
		Expo.fillRectangle(g,0,0,1000,250);
		Expo.setColor(g,Expo.green);
		Expo.fillRectangle(g,0,250,1000,350);
		Expo.setColor(g,Expo.brown);
		Expo.fillRectangle(g,0,350,1000,550);
		Expo.setColor(g,Expo.green);
		Expo.fillRectangle(g,0,550,1000,650);
		
		//Car 1
		Expo.setColor(g,Expo.gold);
		Expo.fillRectangle(g,175,345,450,425);
		Expo.fillRectangle(g,325,260,380,350);
		Expo.fillPolygon(g,380,260,380,350,450,350);
		Expo.setColor(g,Expo.silver);
		Expo.fillRectangle(g,350,275,375,325);
		Expo.fillPolygon(g,375,275,375,325,400,325);
		Expo.setColor(g,Expo.black);
		Expo.fillOval(g,237,425,37,35);
		Expo.fillOval(g,387,425,37,35);
		Expo.setColor(g,Expo.violet);
		Expo.fillOval(g,237,425,15,20);
		Expo.fillOval(g,387,425,15,20);
		
		//Car 2
		Expo.setColor(g,Expo.red);
		Expo.fillRectangle(g,600,350,900,400);
		Expo.fillPolygon(g,600,350,675,275,825,275,900,350);
		Expo.setColor(g,Expo.black);
		Expo.drawLine(g,750,300,750,375);
		Expo.setColor(g,Expo.silver);
		Expo.fillPolygon(g,625,350,675,300,675,350);
		Expo.fillRectangle(g,685,300,735,350);
		Expo.fillPolygon(g,825,300,825,350,875,350);
		Expo.fillRectangle(g,760,300,815,350);
		Expo.setColor(g,Expo.black);
		Expo.fillOval(g,657,400,37,35);
		Expo.fillOval(g,837,400,37,35);
		Expo.setColor(g,Expo.violet);
		Expo.fillOval(g,657,400,15,20);
		Expo.fillOval(g,837,400,15,20);
		
		//Tree
		Expo.setColor(g,Expo.brown);
		Expo.fillRectangle(g,200,100,250,300);
		Expo.setColor(g,Expo.green);
		Expo.fillCircle(g,225,75,25);
		Expo.fillCircle(g,200,75,25);
		Expo.fillCircle(g,200,100,25);
		Expo.fillCircle(g,200,75,25);
		Expo.fillCircle(g,250,75,25);
		Expo.fillCircle(g,250,100,25);
		Expo.fillCircle(g,175,100,25);
		Expo.fillCircle(g,200,50,25);
		Expo.fillCircle(g,225,50,25);
		Expo.fillCircle(g,250,50,25);
		Expo.fillCircle(g,300,50,25);
		Expo.fillCircle(g,200,50,25);
		Expo.fillCircle(g,250,50,25);
		Expo.fillCircle(g,270,10,25);
		Expo.fillCircle(g,300,100,25);
		Expo.fillCircle(g,200,100,25);
		Expo.fillCircle(g,250,75,25);
		Expo.fillCircle(g,275,100,25);
		Expo.fillCircle(g,275,50,50);
		Expo.fillCircle(g,200,50,50);
		Expo.fillCircle(g,200,100,50);
		
		//Sun
		Expo.setColor(g,Expo.yellow);
		Expo.fillCircle(g,875,100,60);
		Expo.fillPolygon(g,900,50,925,75,950,25);
		Expo.fillPolygon(g,925,75,925,100,950,87);
		Expo.fillPolygon(g,925,100,925,125,975,125);
		Expo.fillPolygon(g,925,125,900,150,925,175);
		Expo.fillPolygon(g,850,150,900,150,870,200);
		Expo.fillPolygon(g,840,150,830,100,775,140);
		Expo.fillPolygon(g,840,125,860,95,775,140);
		Expo.fillPolygon(g,850,75,860,50,825,30);
		Expo.fillPolygon(g,840,105,860,85,750,60);
		Expo.fillPolygon(g,840,80,860,50,820,50);
		Expo.fillPolygon(g,840,125,875,105,860,15);
		Expo.fillPolygon(g,840,125,900,105,880,5);
		
		//Clouds
		Expo.setColor(g,Expo.white);
		Expo.fillCircle(g,750,50,30);
		Expo.fillCircle(g,700,50,30);
		Expo.fillCircle(g,750,70,30);
		Expo.fillCircle(g,800,50,30);
		Expo.fillCircle(g,700,70,30);
		Expo.fillCircle(g,770,20,30);
		
        Expo.fillCircle(g,500,100,30);
		Expo.fillCircle(g,550,100,30);
		Expo.fillCircle(g,500,130,30);
		Expo.fillCircle(g,560,80,30);
		Expo.fillCircle(g,525,120,30);
		Expo.fillCircle(g,550,40,30);
		Expo.fillCircle(g,520,30,30);
		Expo.fillCircle(g,520,60,30);
		
		//Plane
		Expo.setColor(g,Expo.grey);
		Expo.fillOval(g,400,50,50,10);
		Expo.fillRectangle(g,440,30,450,50);
		Expo.setColor(g,Expo.silver);
		Expo.fillPolygon(g,395,42,405,42,402,20,398,20);
		Expo.fillPolygon(g,395,58,405,58,402,80,398,88);
		Expo.setColor(g,Expo.black);
		Expo.drawPoint(g,355,50);
		Expo.drawPoint(g,365,50);
		Expo.drawPoint(g,375,50);
		Expo.drawPoint(g,385,50);
		Expo.drawPoint(g,395,50);
		Expo.drawPoint(g,405,50);
		Expo.drawPoint(g,415,50);
		Expo.drawPoint(g,425,50);
		Expo.drawPoint(g,435,50);
		Expo.drawPoint(g,445,50);
		
		//Bird
		Expo.fillOval(g,200,100,25,10);
		Expo.fillOval(g,190,92,15,12);
		Expo.fillPolygon(g,220,100,225,85,225,100);
		Expo.fillPolygon(g,175,87,170,92,175,97);
		Expo.setColor(g,Expo.white);
		Expo.drawPoint(g,180,90);
		
		
		
		
		
		
		
		
		
		
		
		




	}

}


