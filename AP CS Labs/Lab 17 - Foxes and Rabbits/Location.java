import java.util.*;
import java.io.*;

public class Location{
    private int row;//to represent the row no. of 2d location
    private int col;//to represent the column no. of 2d location

    /**
     * Represent a row and column.
     * @param row The row.
     * @param col The column.
     */
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    /**
     * Return a string with row and col
     * @return <code>row, col</code>
     */
    @Override
    public String toString(){
        return row+", "+col;
    }
    
    /**
     * Check if two objects are equal
     * @param Object to be compared
     * @return if <code>row</code> and <code>col</code> of both objects match
     */
    @Override
    public boolean equals(Object obj){
        Location l = (Location) obj;
        return (this.row == l.getRow() && this.col == l.getCol());
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    /**
     * Use the top 16 bits for the row value and the bottom for
     * the column. Except for very big grids, this should give a
     * unique hash code for each (row, col) pair.
     * @return A hashcode for the location.
     */
    @Override
    public int hashCode()
    {
        //don't mess with this
        return (row << 16) + col;
    }
}
