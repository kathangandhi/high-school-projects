import java.util.*;

    public class Palindrome
    {
        public static void main(String[] args)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a Word");
            String test = input.nextLine();
            String tester = new String();
            
            //Initialized
            for(int i = 0; i < test.length() ; i++)
            {
                tester += test.charAt(test.length() - i - 1);
            }
            
            System.out.println(tester);
            System.out.println(test);
            
            //check
            boolean check = false;
            tester = tester.toLowerCase();
            test = test.toLowerCase();
            for(int i = 0; i < test.length(); i++)
            {
               if(test.charAt(i)!=(tester.charAt(i)))
                    check = true;
            }
            
            if(check)
               System.out.println("Not A Palindrome");
            else
               System.out.println("Is A Palindrome");
            
        }
    }
