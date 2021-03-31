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
		UrRobot sam = new UrRobot(2, 5, North, 6, Color.RED);
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.move();
		sam.move();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		sam.turnLeft();
		sam.turnLeft();
		sam.turnLeft();
		sam.move();
		
		








	}

	static
	{
		World.setVisible(true);
		World.readWorld("world.kwld");
		World.showSpeedControl(true);
	}
}
