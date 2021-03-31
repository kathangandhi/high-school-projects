import java.util.*;

public class MyStrings
{
    /** Square 2D array of MyString objects */
    private MyString[][] theStrings;
    
    /** 
     * constructor, instantiates the array 
     * @param rows the rows in the array
     * @param cold the columns in the array
     */
    public MyStrings(int rows, int cols)
    {
        theStrings = new MyString[rows][cols];
    }
    
    /** 
     * adds a MyString object to the array at [r][c]
     * @param s the String to add
     */
    public void addMyString(MyString s, int r, int c)
    {
        theStrings[r][c] = s;
    }
    
    /** 
     * returns a reference to the MyString object at [r][c] in words
     * @param r the row no. of desired element
     * @param c the column no. of desired element
     * @return the String at [r][c]
     */
    public MyString getMyStringAt(int r, int c)
    {
        return theStrings[r][c];
    }
    
    /** 
     * set the MyString's String value to the value of the parameter
     * @param newValue the String to replace with\
     * @param r the row of the swapped element
     * @param c the column of the swapped element
     */
    public void setMyStringAt(String newValue, int r, int c)
    {
        theStrings[r][c].setTheString(newValue);
    }
    
    
    /** returns the number of rows in theStrings */
    public int getNumRows() 
    { 
        return theStrings.length; 
    }
    
    /** returns the number of columns in theStrings */
    public int getNumCols() 
    { 
        return theStrings[0].length; 
    }
    
    /** prints element in theStrings in row-major order */
    public void print()
    {
        for (MyString[] row : theStrings) 
        {
            for (MyString m : row) System.out.print(m.getTheString() + " ");
            
            System.out.println();
        }
    }
}
