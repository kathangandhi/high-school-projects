/************************************************************/
//                       Hands-On Quiz
//         This is the ONLY Java file you may have open!
//              All work must be completed on this file.
/************************************************************/
import java.util.*;

public class Quiz
{
      public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            
            System.out.println("Part 1");
            System.out.println();
            //Complete Part 1 Here
            String test = new String();
            System.out.print("Enter test word: ");
            test = input.nextLine();
            System.out.println();
            System.out.println("Your test word is: "+test);
            
            
            System.out.println();
            System.out.println("Part 2");
            System.out.println();
            //Complete Part 2 Here
            System.out.println("'O's have been replaced with '*'s:");
            test = test.replace('o','*');
            System.out.println(test);
           
           
            
            System.out.println();
            System.out.println("Part 3");
            System.out.println();
            //Complete Part 3 Here
            System.out.println("Letter Composition:");
            for(int i = 0; i < test.length(); i++)
            {
                System.out.print(test.charAt(i)+" ");
                System.out.print("- ");
            }    
        }
}
