// Lab07Bst.java
// The OOP Graphics Program


import java.awt.*;
import java.applet.*;


public class Lab07Bst extends Applet
{
	public void paint(Graphics g)
	{Background.Sky(g);
	 Background.Grass(g);
	 Background.Sun(g);
	 Mountain.Mountain(g,10,325,200,100,310,325);
	 Mountain.Mountain(g,310,325,410,100,510,325);
	 Mountain.Snowcap(g,200,100,100,40,168,199);
	 Mountain.Snowcap(g,410,100,100,40,170,190);
	 Mountain.River(g,270,220,250,400,230,400,250,200);
     Pool.Pool(g,260,495,100);
     Pool.Tree(g);
     Pool.Man(g);




	}

}



