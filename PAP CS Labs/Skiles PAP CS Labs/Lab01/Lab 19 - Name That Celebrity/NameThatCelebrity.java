
//Name:
//Period:

import java.util.*;

public class NameThatCelebrity
{
  public static void main(String[] args)
  {
     Scanner input = new Scanner(System.in);
     
     //1
     System.out.print("Enter String Value: ");
     String s  = input.nextLine();
     System.out.println();
     System.out.println("The word "+s+" has "+s.length()+" letters");
     System.out.println();
     
     //2
     System.out.print("Enter String Value: ");
     s = input.nextLine();
     System.out.println();
     System.out.println("Word "+s+" without first letter = "+s.substring(1,s.length()));
     System.out.println();
     
     //3
     System.out.print("Enter String Value: ");
     s = input.nextLine();
     System.out.println();
     System.out.println("Word "+s+" without last letter = "+s.substring(0,s.length()-1));
     System.out.println();
     
     //4
     System.out.print("Enter String Value 1: ");
     String wordOne = input.nextLine();
     System.out.println();
     System.out.print("Enter String Value 2: ");
     String wordTwo = input.nextLine();
     System.out.println();
     
     if(wordOne.length()>wordTwo.length())
        System.out.println(wordTwo+wordOne+wordTwo);
     else
        System.out.println(wordOne+wordTwo+wordOne);
     System.out.println();
     
     //5
     System.out.print("Enter String Value(even no. of letters): ");
     String evenString = input.nextLine();
     if(evenString.length()%2!=0)
        System.out.println("Odd no. of letters");
     else
        System.out.println(evenString.substring(0,evenString.length()/2));
     System.out.println();
     
     //6
     System.out.print("Enter String Value 1: ");
     String a = input.nextLine();
     System.out.println();
     System.out.print("Enter String Value 2: ");
     String b = input.nextLine();
     System.out.println();
     a = a.substring(1,a.length());
     b = b.substring(1,b.length());
     System.out.println(a+b);
     System.out.println(); 
     
     //7
     System.out.println("Coal");
     System.out.println();
     
     //8
     System.out.print("Enter String Value: ");
     String bad = input.nextLine();
     if(bad.substring(0,3).equals("Bad")||bad.substring(0,3).equals("bad"))
         System.out.println("HAS BAD");
     System.out.println();
     
     //9
     System.out.print("Enter String Value: ");
     b = input.nextLine();
     System.out.println(b.substring(1,b.length()-1));
     System.out.println();
     
     //10
     System.out.print("Enter String Value: ");
     b = input.nextLine();
     if(b!="way")
        System.out.println("No way");
     System.out.println();
     
     //11
     System.out.print("Enter String Value: ");
     String oddString = input.nextLine();
     System.out.println(oddString.substring((oddString.length()-1)/2-1,(oddString.length()-1)/2+2));
     
    
     //Celebrity Guessing App
     System.out.println("Welcome to Guess The Celebrity");
     System.out.println("Some of the letters will be given and you have to guess the name");
     System.out.println();
     
     String celeb = "Rohit Sharma";
     String celeb1 = "Rohit";
     String celeb2 = "Sharma";
     System.out.println("Choose level of difficulty(1 - easy, 2 - medium, 3 - hard): ");
     int choice = input.nextInt();
     input.nextLine();
     System.out.println();
     
     String puzzle = new String();
     int firstName1 = 0;
     int firstName2 = 0;
     int secondName1 = 0;
     int secondName2 = 0;
     int guesses = 0;
     String hint = null;
     
     if(choice==1)
     {   
         firstName1 = 1;
         firstName2 = 5;
         secondName1 = 1;
         secondName2 = 6; 
         hint = "He is captain of MI";
     }
     if(choice==2)
     {   
         firstName1 = 2;
         firstName2 = 4;
         secondName1 = 2;
         secondName2 = 5; 
         hint = "He is an Indian Batsman";
     }
     if(choice==3)
     {   
         firstName1 = 2;
         firstName2 = 3;
         secondName1 = 3;
         secondName2 = 4;
         hint = "He has made 2 200s";
     }
     
     puzzle = celeb1.substring(firstName1,firstName2)+" "+celeb2.substring(secondName1,secondName2);
     while(guesses<4)
     {
         if(guesses==3)
            System.out.println("Hint: "+hint);
         System.out.println("Puzzle: "+puzzle);
         System.out.println("Guess: ");
         String guess = input.nextLine();
         if(guess.equals(celeb))
         {   
             System.out.println("Congrats! You Won");
             System.out.println();
             break;
         }
         else
         {   
             System.out.println("Sorry, Try Again.");
             guesses++;
         }
     }
     if(guesses==4)
        System.out.println("You Lost ... The answer is "+celeb);
  }
}