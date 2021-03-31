/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * @author Cay Horstmann
 *
 ************************************************************************************
 ***  ALTERED 05-14-07 BY LEON SCHRAM
 ***  A Flower object is added to the world in the main method.
 ************************************************************************************
 *
 ************************************************************************************
 ***  ALTERED 6/12/2008 BY JOHN L. M. SCHRAM for PreAPCS GridWorld Lab 06
 ***  Rocks and Flowers are removed.
 ***  Location is added.
 ***  java.awt is added for Color objects.
 ***  Students need to create a "horizontalLine" method that will draw a
 ***  horizontal line of flowers of a specified length, at a specified location,
 ***  in a specified color.
 ***  This is the student, starting file.
 ************************************************************************************
 */


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.*;


public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.show();

        // Do NOT alter anything above this line!
        /////////////////////////////////////////////////////////////////////

		//Dutch Flag
		/*horizontalLine(world,0,0,Color.red,9);
		horizontalLine(world,1,0,Color.red,9);
		horizontalLine(world,2,0,Color.red,9);
		horizontalLine(world,3,0,Color.white,9);
		horizontalLine(world,4,0,Color.white,9);
		horizontalLine(world,5,0,Color.white,9);
		horizontalLine(world,6,0,Color.white,9);
		horizontalLine(world,7,0,Color.blue,9);
		horizontalLine(world,8,0,Color.blue,9);
		horizontalLine(world,9,0,Color.blue,9);
		*/
		//German Flag
        /*horizontalLine(world,0,0,Color.black,9);
		horizontalLine(world,1,0,Color.black,9);
		horizontalLine(world,2,0,Color.black,9);
		horizontalLine(world,3,0,Color.red,9);
		horizontalLine(world,4,0,Color.red,9);
		horizontalLine(world,5,0,Color.red,9);
		horizontalLine(world,6,0,Color.red,9);
		horizontalLine(world,7,0,Color.yellow,9);
		horizontalLine(world,8,0,Color.yellow,9);
		horizontalLine(world,9,0,Color.yellow,9);
        */
        //Italian Flag
        /*verticalLine(world,0,0,Color.green,9);
		verticalLine(world,0,1,Color.green,9);
		verticalLine(world,0,2,Color.green,9);
		verticalLine(world,0,3,Color.white,9);
		verticalLine(world,0,4,Color.white,9);
		verticalLine(world,0,5,Color.white,9);
		verticalLine(world,0,6,Color.white,9);
		verticalLine(world,0,7,Color.red,9);
		verticalLine(world,0,8,Color.red,9);
		verticalLine(world,0,9,Color.red,9);
		*/
		//Texas Flag
		verticalLine(world,0,0,Color.blue,9);
        verticalLine(world,0,1,Color.blue,9);
		verticalLine(world,0,2,Color.blue,9);
		verticalLine(world,0,3,Color.blue,9);
		verticalLine(world,0,4,Color.blue,9);
		horizontalLine(world,5,4,Color.red,5);
		horizontalLine(world,6,4,Color.red,5);
		horizontalLine(world,7,4,Color.red,5);
		horizontalLine(world,8,4,Color.red,5);
		horizontalLine(world,9,4,Color.red,5);
		horizontalLine(world,0,4,Color.white,5);
		horizontalLine(world,1,4,Color.white,5);
		horizontalLine(world,2,4,Color.white,5);
		horizontalLine(world,3,4,Color.white,5);
		horizontalLine(world,4,4,Color.white,5);
		
		//US Flag
		/*verticalLine(world,0,0,Color.blue,4);
		verticalLine(world,0,1,Color.blue,4);
		verticalLine(world,0,2,Color.blue,4);
		verticalLine(world,0,3,Color.blue,4);
		verticalLine(world,0,4,Color.blue,4);
		horizontalLine(world,0,4,Color.red,5);
		horizontalLine(world,2,4,Color.red,5);
		horizontalLine(world,4,4,Color.red,5);
		horizontalLine(world,6,0,Color.red,9);
		horizontalLine(world,8,0,Color.red,9);
		horizontalLine(world,1,4,Color.white,5);
		horizontalLine(world,3,4,Color.white,5);
		horizontalLine(world,5,0,Color.white,9);
		horizontalLine(world,7,0,Color.white,9);
		horizontalLine(world,9,0,Color.white,9);*/
        
    }
   
    public static void horizontalLine(ActorWorld world,int row,int column, Color bugColor, int distance)
    {
     Bug someBug = new Bug(bugColor);
     world.add(someBug);
     someBug.moveTo(new Location (row,column));
     someBug.turn();
     someBug.turn();
     
     for (int j=1;j<=distance;j++)
     {
       someBug.move();
        }
    }
    
    public static void verticalLine(ActorWorld world,int row,int column, Color bugColor, int distance)
    {
     Bug someBug = new Bug(bugColor);
     world.add(someBug);
     someBug.moveTo(new Location (row,column));
     someBug.turn();
     someBug.turn();
     someBug.turn();
     someBug.turn();
     
     for (int j=1;j<=distance;j++)
     {
       someBug.move();
        }
    }


}




