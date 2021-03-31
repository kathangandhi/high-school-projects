/**
 * Numbrix.java  6/11/2011
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 *
 * Solves Numbrix puzzles
 * http://www.parade.com/numbrix
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Represents a Numbrix puzzle.
 */
public class Numbrix
{
    /** The puzzle data */
    private int[][] grid;

    /** Indicates whether numbers are used in the original puzzle
     *  If the number n is used, then used[n] is true;  Otherwise it's false */
    private boolean[] used;

    /**
     * Constructs a Numbrix puzzle object.
     * @param fileName the name of the file containing the puzzle data.
     * @throws FileNotFoundException when fileName file does not exist.
     */
    public Numbrix(String fileName) throws FileNotFoundException{
        Scanner in = new Scanner(new File(fileName));
        int rows = in.nextInt();
        int cols = in.nextInt();
        grid = new int[rows][cols];
        used = new boolean[rows*cols+1];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                grid[i][j] = in.nextInt();
                used[grid[i][j]] = true;
            }
        }
    }

    /**
     * Finds all solutions to the Numbrix puzzle stored in grid by
     * calling recursiveSolve for every possible cell in grid that
     * originally contains a 0 or a 1.  Each of these calls should
     * attempt to solve the puzzle beginning with the number 1.
     */
    public void solve()
    {
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c]==0)
                    recursiveSolve(r,c,1);
            }
        }
    }

    /**
     * Attempts to solve the Numbrix puzzle by placing n in grid[r][c]
     * and then makeing recursive calls (up, down, left, and right) to
     * place n+1 and higher numbers.
     * @param r the row of the cell in which to place n.
     * @param c the column of the cell in which to place n.
     * @param n the number to place in grid[r][c].
     */
    private void recursiveSolve(int r, int c, int n){
        //case 1
        if(r < 0||c < 0||r >= grid.length||c >= grid[0].length)
            return;

        boolean zero = (grid[r][c] == 0);

        //case 2
        if(zero && used[n])
            return;

        //case 3
        if(!zero && grid[r][c] != n)
            return;

        //continue
        grid[r][c] = n;

        if(n == grid.length*grid[0].length)
            System.out.println(this);  
        else{
            //recursive calls for up, down, left, right
            recursiveSolve(r,c+1,n+1);
            recursiveSolve(r+1,c,n+1);
            recursiveSolve(r,c-1,n+1);
            recursiveSolve(r-1,c,n+1);
        }

        if(zero)
            grid[r][c] = 0;
    }

    /**
     * Returns a String which represents the puzzle.
     * @return the puzzle numbers with a tab after each number in a row
     *         and a new line character after each row.
     *         '-' characters should replace 0s in the output.
     */
    public String toString(){
        String gridOutput = new String();
        for(int[] line: grid){
            for(int spot: line){
                if(spot != 0)
                    gridOutput += spot+"\t";
                else
                    gridOutput += "-\t";
            }
            gridOutput += "\n";
        }

        return gridOutput;
    }
}