import java.util.*;
import java.io.*;

public class Runner{
    public static void main(String args[]) throws FileNotFoundException{
        Bachelors b = new Bachelors("bachelors.txt");
        b.solve();
    }
}
