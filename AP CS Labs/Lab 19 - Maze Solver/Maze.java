import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze
{
    private int[][] maze;
    private boolean exitFound;
    private int tempValue; 
    private int steps;
    
    /** Make sure to look at the format of the mazes in the maze text files */
    public Maze(String fileName) throws IOException{
        Scanner in = new Scanner(new File(fileName)); //for getting next int from the maze text file
        int size = in.nextInt();
        maze = new int[size][size];
        
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                maze[row][col] = in.nextInt();
            }
        }
    }
    
    /**
     * Helper method, makes the interface a little cleaner
     * 
     * The user doesn't have to know the solver should start at 0, 0
     * 
     * Also responsible for printing the final state of the maze
     */
    public void solve(){
        this.hasExitPath(0, 0, 0);
        System.out.println(this);
    }

    public void hasExitPath(int r, int c, int numSteps){
        if(r >= 0 && r < maze.length && c >= 0 && c < maze[r].length && maze[r][c] == 1){
            if(c == maze[r].length-1){
                exitFound = true;
                steps = numSteps+1;
                return;
            }
            else{
                tempValue = maze[r][c];
                maze[r][c] = 9;
                hasExitPath(r,c-1,numSteps+1);
                hasExitPath(r,c+1,numSteps+1);
                hasExitPath(r-1,c,numSteps+1);
                hasExitPath(r+1,c,numSteps+1);
                maze[r][c] = tempValue;
            }
        }
    }

    public String toString(){
        String output = new String();
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                output += maze[row][col]+"\t";
            }
            output += "\n";
        }

        if(exitFound)
            output += "\nExit found\n"+steps+" steps";
        else
            output += "\nExit not found\n"+steps+" steps";
        
        return output;
    }
}