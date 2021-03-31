import java.util.*;

/**
 * The StringMethods class tests understanding of Strings by assigning tasks to complete through methods
 */
public class StringMethods{
    /**
     * Greets name with concatenation of Strings in methods
     * @param name The name to greet
     */
    public void unusualHello(String name){
        System.out.println("Hello "+name+", you dummy!");
    }

    /**
     * Returns last first and last characters in str
     * @param str the String to act upon
     * @return the first and last characters of str
     */
    public String stringRipper(String str){
        return str.substring(0,1)+str.substring(str.length()-1,str.length());
    }

    /**
     * Returns a and b with or without space indicated by boolean space
     * @param first String
     * @param second String
     * @param space decided if space should be added between a and b
     * @return desired String
     */
    public String concatenate(String a, String b, boolean space){
        if(space)
            return a+" "+b;
        else
            return a+b;
    }

    /**
     * Checks if sub is present in String
     * @param str the big String to check
     * @param sub the key to check in str
     * @return whether sub is present in str or not
     */
    public boolean hasSub(String str, String sub){
        int wLength = str.length();
        int subLength = sub.length();

        for(int count = 0; count < wLength-subLength+1; count++){
            if(str.substring(count,subLength+count).equals(sub))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if equal numbers of "foo" and "bar" are present in str
     * @param str the big String to check
     * @return whether equal numbers of "foo" and "bar" are present
     */
    public boolean evenFooBar(String str){
        int wLength = str.length();
        int subLength = 3;
        int foo = 0;
        int bar = 0;
        String sub1 = "foo";
        String sub2 = "bar";
        for(int count = 0; count < wLength-2; count++){
            if(str.substring(count,count+3).equals(sub1))
                foo++;
            if(str.substring(count,count+3).equals(sub2))
                bar++;
        }
        
        if(foo==bar)
            return true;
        else
            return false;
    }
    
    /**
     * Sets up a microwave timer based on str
     * @param str the time to enter
     * @return time formatted as a timer
     */
    public String microwaveTime(String str){
        if(str.length()>=3)
            return str.charAt(0)+": "+str.charAt(1)+str.charAt(2);//an hour or more
        else if(str.length()==2)
            return "0: "+str.charAt(1)+str.charAt(2);//10 or more minutes
        else
            return "0: 0"+str.charAt(2);//9 or less minutes
    }
    
    /**
     * Reverses order of words
     * @param str the sentence to test
     * @return the words in str in reverse order
     */
    public String reverseWords(String str){
        String words[] = str.split(" ");
        String result = "";
        for(int i = words.length-1; i >=0; i--)
            result += words[i]+" ";   
        return result;
    }
    
    /**
     * Returns sum of numbers in str
     * @param str the sentence to test
     * @return the sum of numbers in str
     */
    public int sumString(String str){
        Scanner space = new Scanner(str);
        int count = 0;//sum of numbers
        while(space.hasNext()){ 
            if(space.hasNextInt())
                count+=space.nextInt();
            else
                space.next();
        }
        return count;
    }
}
