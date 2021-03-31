import java.util.*;
import java.io.*;
/**
 * Dummy class for a runner, only contains a main method
 */
public class Runner{
    /**
     * Old fashioned runner main method. <br>
     * If file directory/name is not right, then it will print an error message
     * "File not found..."
     */
    public static void main(String args[]) throws IOException{
        Company com = new Company("Gandhi Consulting","gandhiconsulting.org");
        Display gui = new Display();
    }
}
