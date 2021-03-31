import java.io.*;
import java.util.*;

/**
 * The Word class stores a particular word and 
 * how many times it has been used
 */
public class Word{
    private String word;//literal for the word
    private int count = 1;//the no. of times the word was used

    /**
     * Word constructor that initialises <code>word</code>
     */
    public Word(String w){
        word = w;
    }

    //getter methods
    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }
    
    //setter method
    public void increment(){
        count++;
    }
    
    //helpful representation of object
    public String toString(){
        return word + "\t\t\t" + count;
    }
 }