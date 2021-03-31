import java.util.*;
import static java.lang.System.out;

public class MyString
{
    private String theString;
    
    /** 
     * constructs a new MyString object, using the value of the
     * String parameter to initialize the instance variable
     * @param s the value to set theString
     */
    public MyString(String s)
    {
        theString = s;
    }
    
    /**
     * theString getter method, returns the value of the private
     * instance variable for this object
     * @return theString variable
     */
    public String getTheString()
    {
        return theString;
    }
    
    /** 
     * theString setter method 
     * @param newValue the value to swap with
     */
    public void setTheString(String newValue)
    {
        theString = newValue;
    }
}
