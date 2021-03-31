import java.util.*;

/************************************************************/
//                       Hands-On Quiz
//         This is the ONLY Java file you may have open!
//              All work must be completed on this file.
/************************************************************/


public class Quiz2
{
      public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter test string: ");
            String test = input.nextLine();
            
            System.out.println("Part 1");
            System.out.println();
            //Complete Part 1 Here
            System.out.println(test);
            
            
            System.out.println();
            System.out.println("Part 2");
            System.out.println();
            //Complete Part 2 Here
            int index = test.indexOf(" ");
            System.out.println(test.substring(index+1));
           
            
            System.out.println();
            System.out.println("Part 3");
            System.out.println();
            //Complete Part 3 Here
            test = test.replace('a','A');
            test = test.replace('e','E');
            test = test.replace('i','I');
            test = test.replace('o','O');
            test = test.replace('u','U');
            System.out.println(test);
        }
}
