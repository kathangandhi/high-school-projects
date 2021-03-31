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
 ***  ALTERED 6/11/2008 BY JOHN L. M. SCHRAM for PreAPCS GridWorld Lab 04
 ***  Rocks and Flowers are removed.
 ***  Location is added.
 ***  Students need to add Barry.move, Barry.turn, and Barry.moveTo(new Location())
 ***  inside for loop control structures to create different patterns.
 ***  This is the student, starting file.
 ************************************************************************************
 */


import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Bug Barry = new Bug();
        world.add(Barry);
        world.show();

        // Do NOT alter anything above this line!
        /////////////////////////////////////////////////////////////////////


        // The line below makes the bug start at row 8, column 1.
 		// Remember the top row is row 0 and the left most column is column 0.
		Barry.moveTo(new Location(1,9));
		
		int k;
		Barry.move();
		
		for (k=0; k<=5; k++)
		{
		  Barry.turn();
		}
		
		
		for (k=0; k<=2; k++)
		{
		  Barry.move();
		}
		
		for (k=0; k<=5; k++)
		{
		  Barry.turn();
		}
		
		
		for (k=0; k<=8; k++)
		{
		  Barry.move();
		}
		
		for (k=0; k<=5; k++)
		{
		  Barry.turn();
		}
		
		
		for (k=0; k<=2; k++)
		{
		  Barry.move();
		}
		
		for (k=0; k<=5; k++)
		{
		  Barry.turn();
		}
		
		
		for (k=0; k<=4; k++)
		{
		  Barry.move();
		}
		
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		
		for (k=0; k<=1; k++)
		{
		  Barry.move();
		}
		
		Barry.moveTo(new Location(1,0));
		
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		
		
		for (k=0; k<=7; k++)
		{
		  Barry.move();
		}
		
		Barry.moveTo(new Location(5,0));
		
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		
		for (k=0; k<=3; k++)
		{
		  Barry.move();
		}
		
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		
		Barry.move();
		
		Barry.moveTo(new Location(5,0));
		
		Barry.turn();
		Barry.turn();
		Barry.turn();
		Barry.turn();
		
		for (k=0; k<=2; k++)
		{
		  Barry.move();
		}
		
		
		
		
		
		
		
		
		



        /////////////////////////////////////////////////////////////////////
        // Do NOT alter anything below this line!
    }
}
