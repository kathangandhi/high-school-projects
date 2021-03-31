import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field{    
    private int depth, width;
    private Object[][] field;

    /**
     * Represent a field of the given dimensions.
     * @param depth The depth of the field.
     * @param width The width of the field.
     */
    public Field(int depth, int width){
        this.depth = depth;
        this.width = width;
        this.field = new Object[depth][width];
    }

    /** Empty the field */
    public void clear()
    {
        for(int r = 0; r < depth; r++){
            for(int c = 0; c < width; c++)
                field[r][c] = null;
        }
    }

    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param animal The animal to be placed.
     * @param row Row coordinate of the location.
     * @param col Column coordinate of the location.
     */
    public void place(Object animal, int row, int col){
        field[row][col] = animal;
    }

    /**
     * Place an animal at the given location.
     * If there is already an animal at the location it will
     * be lost.
     * @param animal The animal to be placed.
     * @param location Where to place the animal.
     */
    public void place(Object animal, Location location){
        field[location.getRow()][location.getCol()] = animal;
    }

    /**
     * Move an Object from one location in the field to another
     * @param oldLocation Object's old location
     * @param newLocation Object's new location
     */
    public void move(Location oldLocation, Location newLocation)
    {
        Object obj = getObjectAt(oldLocation);
        this.place(obj,newLocation);
        this.remove(oldLocation);
    }

    /**
     * Remove an Object from a particular location
     * @param location
     */
    public void remove(Location location)
    {
        field[location.getRow()][location.getCol()] = null;
    }

    /**
     * Return the animal at the given location, if any.
     * @param location Where in the field.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(Location location)
    {
        return field[location.getRow()][location.getCol()];
    }

    /**
     * Return the animal at the given location, if any.
     * @param row The desired row.
     * @param col The desired column.
     * @return The animal at the given location, or null if there is none.
     */
    public Object getObjectAt(int row, int col)
    {
        return field[row][col];
    }

    /**
     * Generate a shuffled List of locations adjacent to the given one - will 
     * not include the location itself. All locations will lie within the grid.
     * @param location The location from which to generate adjacencies.
     * @return A randomized list of locations adjacent to that given.
     */
    public List<Location> adjacentLocations(Location location)
    {
        List<Location> list = new ArrayList<Location>();
        if(location != null){
            for(int i = location.getRow()-1; i <= location.getRow()+1; i++){
                for(int j = location.getCol()-1; j <= location.getCol()+1; j++){
                    if(i==location.getRow()&&j==location.getCol())
                        continue;
                    if((i >= 0&&j >= 0)&&(i < field.length&&j < field[0].length)){
                        list.add(new Location(i,j));
                    }
                }
            }
        }
        Collections.shuffle(list);
        return list;
    }

    /**
     * Try to find a free location that is adjacent to the given location. 
     * If there is none, return null. The returned location will be within 
     * the valid bounds of the field.
     * @param location The location from which to generate an adjacency.
     * @return A valid free location within the grid area, or null if all
     *         locations around are full.
     */
    public Location freeAdjacentLocation(Location location)
    {
        //USED BY FOXES AND RABBITS TO MOVE RANDOMLY
        List<Location> list = adjacentLocations(location);

        for(int i = 0; i < list.size(); i++){
            if(getObjectAt(list.get(i)) == null)
                return list.get(i);
        }
        return null;
    }

    @Override
    public String toString() //quick picture of the state of the field, for debugging
    {
        String result = "";

        for (int r = 0; r < this.depth; r++)
        {
            for (int c = 0; c < this.width; c++)
            {
                Object obj = this.field[r][c];

                if (obj instanceof Rabbit)
                    result += "R\t";
                else if (obj instanceof Fox)
                    result += "F\t";
                else if (obj == null)
                    result += "n\t";
                else
                    result += "x\t";
            }
            result += "\n";
        }

        return result;
    }

    public int getDepth() { return this.depth; }

    public int getWidth() { return this.width; }
}
