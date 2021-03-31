 
 
 
public class hiddenWord  
{
    static String scramble = "";
    
    public static void main(String[] args) 
    {
        //Do not modify anything in the main method.
        
        String w = "automobile";
        System.out.println(w);
        
        System.out.println(encode(w));
        
        
    }
    
    
    public static String encode(String word)
    {
        
        //1. Convert String word into a character array called letters1.
        char letters1[] = new char[word.length()];
        for(int i = 0; i < word.length(); i++)
            letters1[i] = word.charAt(i);
        
        //2. Create a new character array, letters2, of the same length as letters1
        char letters2[] = new char[letters1.length];
        
        //3. Initialize all elements of letters2 to the * symbol.
        for(int i = 0; i < letters1.length; i++)
            letters2[i] = '*';
       
                       
        //4. Declare variable int index.
        int index;
        int control = 0;
        
        /*
         * 5. Randomly select half the letters from the letters1 array, one at a time, and copy each to its 
         * corresponding location in the letters2 array. Only copy the letters into letters2 where there  
         * is an * symbol. If there is a letter in the position, you need to select another location.
         * Note: You will need a for loop since it is a fixed number of letters, and a do/while to select
         * the location within the letters2 array without an *.
         */
        for(int i = 0; i < (letters1.length/2); i++)
        {
            index = (int) (Math.random()*letters1.length);
            if(letters2[index] == '*')
            {   
                letters2[index] = letters1[index];
                control++;
            }
            else if(letters2[index] == letters1[index])
            { i--;
            
            }
        }       
        
        //6. Convert letters2 to a String code and return code.
        word = new String(letters2);
        return word;
        
    }
    
} 