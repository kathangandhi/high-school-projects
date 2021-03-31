import java.util.*;
import java.io.*;

public class ProblemE{
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("E.txt"));

        int count = input.nextInt();
        for(int i = 0; i < count; i++){
            int width = input.nextInt();
            int length = input.nextInt();

            System.out.println(countSquares(width,length));
        }
    }

    public static int countSquares(int width, int length){
        if(width < length){
            if(length % width == 0)
                return length/width;
            else 
                return length/width+countSquares(width,length-(length/width*width));
        }
        else{
            if(width > length && width % length == 0)
                return width/length;
            else
                return width/length+countSquares(width-(width/length*length),length);
        }
    }
}