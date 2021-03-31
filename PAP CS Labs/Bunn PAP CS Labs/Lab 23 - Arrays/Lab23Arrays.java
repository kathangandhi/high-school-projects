import java.util.*;

public class Lab23Arrays
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String[] s = {"Hello", "Goodbye", "Computer", "Science", "Um", "Do", "What", "Now"};

        //2
        System.out.println(s.length);
        System.out.println();
        
        //3
        for(int i = 0; i < s.length; i++)
        {
            System.out.println(s[i].charAt(0));
        }
        System.out.println();
        
        //4
        int sum = 0;
        for(int j = 0; j < s.length; j++)
        {
            sum+=s[j].length();
        }
        System.out.println(sum);
        System.out.println();
        
        //5
        int number = 0;
        for(int k = 0; k < s.length; k++)
        {
            if(s[k].length()>=7)
              number++;
            
            
        }
        if(number>=2)
              System.out.println("2 Length 7");
        else
              System.out.println("Under 2 Length 7");
        System.out.println();
        
        //6
        System.out.println("Ma mother");
        System.out.println();
        
        //7
        for(int l = 0; l < s.length; l++)
        {
         for(int m = 0; m < s[l].length(); m++)
         {
             if(s[l].charAt(m)==('e'))
               { 
                   System.out.println(l);
                   m = 7;
               }
           }
        }
        System.out.println();
        
        //8
        int os = 0;
        for(int l = 0; l < s.length; l++)
        {
         for(int m = 0; m < s[l].length(); m++)
         {
             if(s[l].charAt(m)==('o'))
               {                
                   os++;
               }
           }
        }
        
        if(os==0)
           System.out.println("No o's");
        else
           System.out.println("At least 1 o");
        System.out.println();
        
        //Magic 8 - Ball
        String results[] = {"It is certain","It is decidedly so", "Without a doubt", "Yes definitely", "You may rely on it", "As I see it, yes", "Most likely", "Outlook good", "Yes", "Signs point to yes", "Reply hazy try again", "Ask again later", "Better not tell you now", "Cannot predict now", "Concentrate and ask again", "Don't count on it", "My reply is no", "My sources say no", "Outlook not so good", "Very doubtful"};
        int result = (int)(Math.random()*20);
        System.out.println("What question do you have?");
        String response = input.nextLine();
        System.out.println(results[result]);
        
        
        
    }
}