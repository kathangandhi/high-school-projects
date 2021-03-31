import java.util.*;

public class Lab27WordScramble
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        /*
        //1
        System.out.print("Enter a char: ");
        String finess = input.nextLine();
        char AorNot = finess.charAt(0);
        System.out.println("Is A: "+isLetterA(AorNot));
        System.out.println();

        //2
        System.out.print("Enter a String: ");
        String twoA = input.nextLine();
        System.out.println("Has two As: "+hasTwoA(twoA));
        System.out.println();

        //3
        System.out.print("Enter a char: ");
        finess = input.nextLine();
        char vowel = finess.charAt(0);
        System.out.println("Is a vowel: "+isVowel(vowel));
        System.out.println();

        //4
        System.out.print("Enter a String: ");
        String vowels = input.nextLine();
        System.out.println("Has "+numVowels(vowels)+" vowels");
        System.out.println();

        //5
        System.out.print("Enter a String: ");
        String test = input.nextLine();
        System.out.print("Enter char 1: ");
        finess = input.nextLine();
        char first = finess.charAt(0);
        System.out.print("Enter char 2: ");
        finess = input.nextLine();
        char second = finess.charAt(0);
        System.out.println("There are even "+first+" and "+second+" : "+evenChars(test,first,second));
        System.out.println();

        //6
        System.out.print("Enter a String: ");
        test = input.nextLine();
        System.out.print("Enter char: ");
        finess = input.nextLine();
        char tester = finess.charAt(0);
        System.out.println("Two "+tester+"s in a row: "+twoInARow(test,tester));
        System.out.println();

        //7
        System.out.print("Enter a String: ");
        test = input.nextLine();
        System.out.println("When vowels of "+test+" are capitalized: "+capitalizeVowels(test));
        System.out.println();

        //8
        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();
        System.out.println();
        System.out.print("The longest word in the sentence:");
        System.out.println(sentence);
        System.out.println("is "+longestWord(sentence));
        */

        System.out.println("Enter a sentence: ");
        String scrambler = input.nextLine();
        System.out.println();
        wordScramble(scrambler);
    }

    public static boolean isLetterA(char letter)
    {
        boolean check;
        if(letter=='a'||letter=='A')
            check = true;
        else
            check = false;
        return check; 
    }

    public static boolean hasTwoA(String s)
    {
        boolean check;
        int counter = 0;

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)=='a'||s.charAt(i)=='A')
                counter++;
        }

        if(counter>=2)
            check = true;
        else
            check = false;
        return check;
    }

    public static boolean isVowel(char letter)
    {
        boolean check;
        if(letter=='a'||letter=='i'||letter=='e'||letter=='o'||letter=='u'||letter=='A'||letter=='I'||letter=='E'||letter=='O'||letter=='U')
            check = true;
        else
            check = false;
        return check;
    }

    public static int numVowels(String s)
    {
        int counter = 0;
        boolean check;
        for(int i = 0; i < s.length(); i++)
        {
            if(isVowel(s.charAt(i)))
                counter++;
        }
        return counter;
    }

    public static boolean evenChars(String s, char a, char b)
    {
        int counterA = 0;
        int counterB = 0;
        boolean check;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)==a)
                counterA++;
            if(s.charAt(i)==b)
                counterB++;
        }
        if(counterA%2==0&&counterB%2==0)
            check = true;
        else
            check = false;
        return check;
    }

    public static boolean twoInARow(String s, char a)
    {
        int counter = 0;
        boolean check = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {   
                check = true;
                break;
            }
        }
        return check;
    }

    public static String capitalizeVowels(String s)
    {
        String mod = new String();
        String temp;
        for(int i = 0; i < s.length(); i++)
        {
            if(isVowel(s.charAt(i)))
            {   
                temp = s.substring(i,i+1);
                mod += temp.toUpperCase();
            }
            else
                mod += s.charAt(i);
        }
        return mod;
    }

    public static String longestWord(String s)
    {
        String words[] = s.split(" ");
        String longWord = " ";
        for(int i = 0; i < words.length; i++)
        {
            if(words[i].length()>longWord.length())
                longWord = words[i];
        }
        return longWord;
    }

    public static void wordScramble(String line)
    {
        String words[] = line.split(" ");
        
        for(int i = 0; i < words.length; i++)
        {
            char letters[] = words[i].toCharArray();
            char scramble[] = new char[letters.length];
            scramble[0] = letters[0];
            scramble[letters.length-1] = letters[letters.length-1];
            for(int j = 1; j < letters.length-1; j++)
            {
                int random = (int) (Math.random()*letters.length);
                while((random == letters.length-1) || (random == 0))
                {
                    random = (int) (Math.random()*letters.length);
                }
                scramble[0] = letters[0];
                scramble[letters.length-1] = letters[letters.length-1];
                if(letters[random]!= '#')
                {           
                    scramble[j] = letters[random];
                    letters[random] = '#';
                }
                else
                    j--;
            }
            //scrambled = scramble[i];
            String scrambled = new String(scramble);
            words[i] = scrambled;
            //System.out.print(scrambled+" ");
        }
        
        for(String t: words)
            System.out.print(t+" ");
    }
}
