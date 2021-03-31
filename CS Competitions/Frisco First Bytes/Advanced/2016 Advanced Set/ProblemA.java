import java.util.*;
import java.io.*;

public class ProblemA{
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("A.txt"));
        
        int loop = input.nextInt();
        input.nextLine();
        for(int i = 0; i < loop; i++){
            List<Integer> denoms = new ArrayList<Integer>();
            int sum = 0;
            
            //stores sum,
            //reads line, breaks it into numbers
            //and puts into ArrayList
            String line = input.nextLine();
            String[] numbers = line.split(" ");
            for(int j = 0; j < numbers.length; j++){
                if(j == 0)
                    sum = Integer.parseInt(numbers[j]);
                else
                    denoms.add(Integer.parseInt(numbers[j]));
            }
            
            int count = Integer.MAX_VALUE;
            for(int k = denoms.size()-1; k >= 0; k--){
                int coins = greedy(k,denoms,sum);
                if(coins < count)
                    count = coins;
            }
            
            System.out.println(count);
        }
    }
    
    public static int greedy(int denomIndex, List<Integer> denoms, int sum){
        int coins = 0;
        
        for(int i = denomIndex; i >= 0; i--){
            int denomNow = denoms.get(i);
            if(sum/denomNow > 0){
                coins += sum/denomNow;
                sum -= sum/denomNow*denomNow;
            }
        }
        
        //to-do
        return coins;
    }
}
