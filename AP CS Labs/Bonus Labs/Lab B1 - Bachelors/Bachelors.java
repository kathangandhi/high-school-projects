import java.util.*;
import java.io.*;

public class Bachelors{
    private int numLadies;
    private int numBachelors;
    private int[] ladiesHeights;
    private int[] bachelorsHeights;

    public Bachelors(String fileName) throws FileNotFoundException{
        Scanner input = new Scanner(new File(fileName));
        numLadies = input.nextInt();

        ladiesHeights = new int[numLadies];
        for(int i = 0; i < numLadies; i++){
            ladiesHeights[i] = input.nextInt();
        }

        numBachelors = input.nextInt();

        bachelorsHeights = new int[numBachelors];
        for(int i = 0; i < numBachelors; i++){
            bachelorsHeights[i] = input.nextInt();
        }
    }

    public void solve(){
        for(int I = 0; I < numBachelors; I++){
            int smallest = 0;
            int biggest = Integer.MAX_VALUE;

            for(int i = 0; i < numLadies; i++){
                if(ladiesHeights[i] > smallest && ladiesHeights[i] < bachelorsHeights[I])
                    smallest = ladiesHeights[i];
                if(ladiesHeights[i] < biggest && ladiesHeights[i] > bachelorsHeights[I])
                    biggest = ladiesHeights[i];
            }

            if(smallest == 0)
                smallest = -1;
            if(biggest == Integer.MAX_VALUE)
                biggest = -1;
                
            System.out.println(smallest+" "+biggest);
        }
    }
}
