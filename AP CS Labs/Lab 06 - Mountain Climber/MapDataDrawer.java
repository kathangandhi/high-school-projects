import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapDataDrawer{
    /** the 2D array containing the elevations */
    private int[][] grid;

    /** constructor, parses input from the file into grid */
    public MapDataDrawer(String fileName, int rows, int cols) throws IOException{
        File fileTitle = new File(fileName);
        Scanner file = new Scanner(fileTitle);
        grid = new int[rows][cols];
        
        //loop to parse every integer into the array
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++)
                grid[row][col] = file.nextInt();
        }
    }

    /** 
     * The method that returns the smallest value in the 2D array
     * @return the min value in the entire grid 
     */
    public int findMin(){
        int smallest = Integer.MAX_VALUE;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] < smallest)
                    smallest = grid[row][col];
            }    
        }
        
        return smallest;
    }

    /** 
     * The method that returns the largest value in the 2D array
     * @return the max value in the entire grid 
     */
    public int findMax(){
        int largest = 0;
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] > largest)
                    largest = grid[row][col];
            }    
        }
        
        return largest; 
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     * @param g the Graphics object to use
     */
    public void drawMap(Graphics g){
        int min = findMin();
        int max = findMax();
        
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                int color = (grid[row][col] - min)*255/(max - min);//determines color value based on elevation
                g.setColor(new Color(color, color, color));
                g.fillRect(col, row, 1, 1);
            }    
        }
    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @param g the Graphics object
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        int start = grid[row][0];
        int distanceTracker = 0;
        g.fillRect(0, row, 1, 1);

        for(int col = 1; col < grid[0].length; col++){
            if(row==0){//if on top
                int rightNow = grid[row][col-1];//current spot
                int forward = grid[row][col];//spot ahead
                int down = grid[row+1][col];//spot diagonally below

                //going forward
                if(Math.abs(forward-rightNow) < Math.abs(down-rightNow)){
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(forward-rightNow);
                }
                //going below
                else
                if(Math.abs(down-rightNow) < Math.abs(forward-rightNow)){
                    row = row+1;
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(down-rightNow);
                }
                //if both are equal options, choose randomly
                else
                if(Math.abs(down-rightNow) == Math.abs(forward-rightNow)){
                    Random rand = new Random();
                    int dec = rand.nextInt(2);
                    if(dec==0){
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(forward-rightNow);
                    }
                    else{
                        row = row+1;
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(down-rightNow);
                    }
                }
            }
            else
            if(row==479){//if on bottom
                int rightNow = grid[row][col-1];//current spot
                int up = grid[row-1][col];//spot diagonally above
                int forward = grid[row][col];//spot ahead
                
                //going above
                if(Math.abs(up-rightNow) < Math.abs(forward-rightNow)){
                    row = row-1;
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(up-rightNow);
                }
                //going forward
                else 
                if(Math.abs(forward-rightNow) < Math.abs(up-rightNow)){
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(forward-rightNow);
                }
                //if both are equal options, choose randomly
                else
                if(Math.abs(forward-rightNow) == Math.abs(up-rightNow)){
                    Random rand = new Random();
                    int dec = rand.nextInt(2);
                    if(dec==0){
                        row = row-1;
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(up-rightNow);
                    }
                    else{
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(forward-rightNow);
                    }
                }
            }
            else{//all other conditions
                int rightNow = grid[row][col-1];//current spot
                int up = grid[row-1][col];//spot diagonally above
                int forward = grid[row][col];//spot ahead
                int down = grid[row+1][col];//spot diagonally below
                
                //going above
                if(Math.abs(up-rightNow) < Math.abs(forward-rightNow) && Math.abs(up-rightNow) < Math.abs(down-rightNow)){
                    row = row-1;
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(up-rightNow);
                }
                //going forward
                else 
                if(Math.abs(forward-rightNow) < Math.abs(up-rightNow) && Math.abs(forward-rightNow) < Math.abs(down-rightNow)){
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(forward-rightNow);
                }
                //going below
                else
                if(Math.abs(down-rightNow) < Math.abs(forward-rightNow) && Math.abs(down-rightNow) < Math.abs(up-rightNow)){
                    row = row+1;
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(down-rightNow);
                }
                //if above and below are equal options, choose randomly
                else
                if(Math.abs(down-rightNow) == Math.abs(up-rightNow)){
                    Random rand = new Random();
                    int dec = rand.nextInt(2);
                    if(dec==0){
                        row = row-1;
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(up-rightNow);
                    }
                    else{
                        row = row+1;
                        g.fillRect(col,row,1,1);
                        distanceTracker += Math.abs(down-rightNow);
                    }
                }
                //default go forward
                else{
                    g.fillRect(col,row,1,1);
                    distanceTracker += Math.abs(forward-rightNow);
                }
            }
        }
        
        return distanceTracker;
    }

    /** 
     * The method to find the most efficient path based on the greedy algorithm
     * @param g the Graphics object
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid. 
     */
    public int indexOfLowestElevPath(Graphics g){
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        
        for(int row = 0; row < grid.length; row++){
            if(drawLowestElevPath(g, row) < smallest){
                smallest = drawLowestElevPath(g, row);
                index = row;
            }
        }
        
        return index;
    }
}
