import java.util.*;
import java.io.*;

public class ProblemA{
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("A.txt"));

        int numDataSets = input.nextInt();
        int plots[] = new int[10];
        int joeMoney = 0;

        for(int I = 0; I < numDataSets; I++){
            joeMoney = input.nextInt();
            int numPlots = input.nextInt();
            plots = new int[numPlots];

            for(int i = 0; i < numPlots; i++){
                plots[i] = input.nextInt();
            }

            int maxCount = 0;
            for(int i = 0; i < numPlots; i++){
                int cost = 0;
                int count = 0;
                for(int j = i; j < numPlots; j++){
                    cost += plots[j];
                    if(cost <= joeMoney)
                        count++;
                    else if(count > maxCount){
                        maxCount = count;
                        break;
                    }
                    else
                        break;
                }
                if(count > maxCount)
                    maxCount = count;
            }
            System.out.println(maxCount);
        }
    }
}
