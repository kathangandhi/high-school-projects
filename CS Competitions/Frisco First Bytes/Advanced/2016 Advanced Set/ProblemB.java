import java.util.*;
import java.io.*;

public class ProblemB{
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("B.txt"));
        
        int count = input.nextInt();
        for(int i = 0; i < count; i++){
            int numCandy = input.nextInt();
            String name = input.next();
            
            if(numCandy%4 != 0)
                System.out.println(name+" wins");
            else if(name.equals("Joe"))
                System.out.println("Jane wins");
            else
                System.out.println("Joe wins");
        }
    }
}