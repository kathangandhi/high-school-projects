/**
 * KarelSample.java  05/25/15
 *
 *
 */

import kareltherobot.UrRobot;
import kareltherobot.World;
import kareltherobot.Directions;
import java.awt.Color;

public class KarelSample implements Directions
{
	public static void main(String[] args)
	{
		UrRobot sam = new UrRobot(4, 6, North, 18, Color.RED);
		sam.turnLeft();
		sam.turnLeft();
		
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.pickBeeper();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.putBeeper();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.putBeeper();
		sam.move();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

		
		
		
		
		
	}

	static
	{
		World.setVisible(true);
		World.readWorld("world.kwld");
		World.showSpeedControl(true);
	}
}
