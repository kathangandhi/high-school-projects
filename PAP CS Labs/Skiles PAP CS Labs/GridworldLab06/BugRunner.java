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
 ***  ALTERED 6/12/2008 BY JOHN L. M. SCHRAM for PreAPCS GridWorld Lab 05
 ***  java.awt is added for Color objects.
 ***  Students need to add Barry.move, Barry.turn, and Barry.moveTo(new Location())
 ***  inside control structures to create flags of the world.
 ***  The setColor commands will be necessary to make this work.
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

        Bug Barry = new Bug();
        world.add(Barry);
        Barry.moveTo(new Location(0,0));
        Barry.turn();
        Barry.turn();
      
        
        Bug Benny = new Bug();
        world.add(Benny);
        Benny.moveTo(new Location(9,9));
        Benny.setColor(Color.blue);
        Benny.turn();
        Benny.turn();
        Benny.turn();
        Benny.turn();
        Benny.turn();
        Benny.turn();
        
        for(int j=1;j<=9;j++)
        {
          Barry.move();
          Benny.move();
          
        }
        for(int j=1;j<=2;j++)
          {
           Benny.turn();
           Barry.turn();
           }
        for(int k=8;k>=1;k-=2)
        {
        for(int r=1;r<=2;r++)
        {
         for(int j=1;j<=k;j++)
         {
           Barry.move();
           Benny.move();
         
         }
         for(int j=1;j<=2;j++)
          {
           Benny.turn();
           Barry.turn();
           }
         
        }
        }



        /////////////////////////////////////////////////////////////////////
        // Do NOT alter anything below this line!
    }
}

