import java.util.*;
import java.io.*;

/**
 * WordCloud class has a collection of Word objects
 */
public class WordCloud{
    private ArrayList<Word> words;//ArrayList for all Word objects
    private ArrayList<Word> topHits;//smaller ArrayList having top 30 Word objects
    private int totalWords;//all words in supplied passage
    private int uniqueWords;//the size of the words ArrayList 

    /**
     * WordCloud constructor to initialise all instance variables
     * @param fileName name of file directory
     */
    public WordCloud(String fileName) throws IOException{
        words = new ArrayList<Word>();
        topHits = new ArrayList<Word>();
        totalWords = 0;
        uniqueWords = words.size();
        load(fileName);
    }

    /**
     * Parses all the words in the passage and initialises <code>words</code> with
     * @param fileName name of file directory
     */
    private void load(String fileName) throws IOException{
        Scanner in = new Scanner(new File(fileName));
        while(in.hasNext()){
            String input = in.next().toLowerCase().trim();//method call
            //trim method removes extra spaces in a String
            if(getIndex(input) < 0)
                words.add(new Word(input));
                //adds new Word object if no such word exists
            else
                words.get(getIndex(input)).increment();//Word method call
                //increments count of the Word object if already found
        }

        topHits = getTopHits();//method call
        printInfo();//method call
    }
    
    private int getIndex(String str){
        int count = -1;

        for(int i = 0; i < words.size(); i++){
            if(words.get(i).getWord().equals(str)){
                count = i;
                break;
            }
        }

        return count;
    }

    public ArrayList<Word> getTopHits(){
        ArrayList<Word> temp = words;
        ArrayList<Word> answer = new ArrayList<>();
        
        for(int hits = 0; hits < 30; hits++){
            int max = Integer.MIN_VALUE;
            Word take = new Word("");
            for(int i = 0; i < words.size(); i++){
                if(words.get(i).getCount() > max){
                    max = words.get(i).getCount();
                    take = words.get(i);
                }
            }
            answer.add(take);
            words.remove(take);
        }
        
        words = temp;
        return answer;
    }

    public void printInfo(){
        System.out.println("\t\t Word \t\t Frequency");
        for(int i = 0; i < topHits.size(); i++){
            System.out.println((i+1)+")\t\t "+topHits.get(i).toString());
        }
    }
}