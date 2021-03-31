import java.awt.*;
import java.util.*;

public class SandLab
{
    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;

    //do not add any more fields!
    private int[][] grid;
    private SandDisplay display; //SandDisplay is the GUI class

    public SandLab(int numRows, int numCols)
    {
        String[] names = new String[4];

        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";

        display = new SandDisplay("Falling Sand", numRows, numCols, names);
        grid = new int[numRows][numCols];
    }

    /** called when the user clicks on a location using the given tool */
    private void locationClicked(int row, int col, int tool)
    {
        grid[row][col] = tool;
    }

    /** copies each element of grid into the display*/
    public void updateDisplay()
    {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == EMPTY)
                    display.setColor(i,j,Color.BLACK);
                else if(grid[i][j] == METAL)
                    display.setColor(i,j,Color.GRAY);
                else if(grid[i][j] == SAND)
                    display.setColor(i,j,Color.YELLOW);
                else if(grid[i][j] == WATER)
                    display.setColor(i,j,Color.BLUE);
            }
        }
    }

    /** called repeatedly, causes one random particle to maybe do something */
    public void step()
    {
        int row = (int)(Math.random()*grid.length);
        int col = (int)(Math.random()*grid[row].length);

        if(checkType(row,col,SAND)){
            if(checkType(row+1,col,EMPTY)){
                switchDown(row,col,EMPTY,SAND);
            }
            if(checkType(row+1,col,WATER)){
                switchDown(row,col,WATER,SAND);
            }
        }
        
        if(checkType(row,col,WATER)){
            if(checkType(row+1,col,EMPTY)){
                switchDown(row,col,EMPTY,WATER);
            }
            else if(checkType(row,col+1,EMPTY)){
                switchRight(row,col,EMPTY,WATER);
            }
            else if(checkType(row,col-1,EMPTY)){
                switchLeft(row,col,EMPTY,WATER);
            }
            else if(checkType(row+1,col,SAND)){
                switchDown(row,col,SAND,WATER);
            }
        }
    }

    private boolean checkType(int row, int col, int tool){
        if((col >= 0 && col < grid[0].length && row >= 0 && row < grid.length))
            return (grid[row][col] == tool);
        else
            return false;
    }

    private void switchDown(int row, int col, int newTool, int oriTool){
        grid[row][col] = newTool;
        grid[row+1][col] = oriTool;
    }

    private void switchLeft(int row, int col, int newTool, int oriTool){
        if(col > 0){
            grid[row][col] = newTool;
            grid[row][col-1] = oriTool;
        }
    }
    
    private void switchRight(int row, int col, int newTool, int oriTool){
        if(col < grid[row].length-1){
            grid[row][col] = newTool;
            grid[row][col+1] = oriTool;
        }
    }

    //do not modify!
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();

            updateDisplay();

            display.repaint();

            display.pause(1);  //wait for redrawing and for mouse

            int[] mouseLoc = display.getMouseLocation();

            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
