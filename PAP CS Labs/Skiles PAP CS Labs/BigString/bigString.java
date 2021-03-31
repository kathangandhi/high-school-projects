/*
 * You should output each word of the String w individually onto a separate line. 
 * You must use the indexOf(char, int) method. The char is the character you are looking for
 * the int is where the method should start looking for the character. You will also need
 * a repetition statement. You may NOT use the split() method.
*/

import java.util.*;

    public class bigString
    {
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
                     
            String w = "The big brown fox jumped over the lazy sleeping dog";
          
            /*
            When grading, you will uncomment out the two lines below and will be 
            given a new sentence for String w.
            */
           
            //System.out.print("Enter a sentence: ");
            //w = input.nextLine();
          
            //Write your code to separate out each word in String w below this line. 
            int index = 0;
            int index2 = 0;
            w = w+" ";
            index2 = w.indexOf(' ',index);
            
            while(index2 < w.length() && index2!=-1)
            {
                System.out.println(w.substring(index,index2));
                index = index2+1;
                index2 = w.indexOf(' ',index);
            }
             
            
        }
            
        
        
        
    }
