import java.util.*;
import java.io.*;

public class ProblemC{
    private static HashMap<Character,Integer> alphabets = new HashMap<Character,Integer>();
    
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("C.txt")); 
        Scanner console = new Scanner(System.in);
        
        String letters = "cfdjeistaglnqmrbphok";
        for(int i = 0; i < letters.length(); i++){
            alphabets.put(letters.charAt(i),i);
        }
        
        int numSets = input.nextInt();
        for(int i = 0; i < numSets; i++){
            int numTitles = input.nextInt();
            input.nextLine();
            ArrayList<String> titles = new ArrayList<String>();
            for(int j = 0; j < numTitles; j++){
                titles.add(input.nextLine());
            }
            ProblemC.arrange(titles);
            
            for(int j = 0; j < numTitles; j++){
                System.out.println(titles.get(j));
            }
            
            if(i == numSets-1)
                System.out.println("******************************");
            else
                System.out.println("******************************\n");
        }
    }
    
    public static void arrange(ArrayList<String> titles){
        boolean sorted = false;
        while(!sorted){
            int count = 0;
            for(int i = 0; i < titles.size()-1; i++){
                if(ProblemC.compareTo(titles.get(i), titles.get(i+1)) > 0){
                    titles.add(i,titles.remove(i+1));
                    count++;
                }
            }
            
            if(count == 0)
                sorted = !sorted;
        }
    }
    
    public static int compareTo(String a, String b){
        int loop = 0;
        if(a.length() < b.length())
            loop = a.length();
        else
            loop = b.length();
            
        for(int i = 0; i < loop; i++){
            if(alphabets.get(a.charAt(i)) < alphabets.get(b.charAt(i)))
                return -1;
            else if(alphabets.get(a.charAt(i)) > alphabets.get(b.charAt(i)))
                return 1;
        }
        
        if(a.length() > b.length())
            return 1;
        else if(a.length() < b.length())
            return -1;
        return 0;
    }
}