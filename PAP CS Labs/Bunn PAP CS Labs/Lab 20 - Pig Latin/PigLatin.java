
import java.util.*;

public class PigLatin
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    //1
    System.out.print("Enter a string: ");
    String str = input.nextLine();
    String duplicate  = new String();
    duplicate = str.toUpperCase();
    System.out.println();
    System.out.println(duplicate.charAt(0) + str.substring(1,str.length()));
    System.out.println();
    
    //2
    System.out.print("Enter a string: ");
    str = input.nextLine();
    duplicate = str.toLowerCase();
    String duplicate2 = str.toUpperCase();
    System.out.println();
    System.out.println(duplicate.substring(0,duplicate.length()-2) + duplicate2.substring(duplicate.length()-2,duplicate2.length()));
    System.out.println();

    //3
    System.out.print("Enter a string: ");
    str = input.nextLine();
    int count = 0;
    for(int i = 0; i < str.length()-1; i++)
    {   
        if(str.charAt(i)=='e')
           count++;   
    }
    System.out.println();
    System.out.println("There are "+count+" 'e's in "+str);
    System.out.println();
    
    //4
    System.out.print("Enter a string: ");
    str = input.nextLine();
    count = 0;
    for(int i = 0; i < str.length()-1; i++)
    {   
        if(str.substring(i,i+2).equalsIgnoreCase("hi"))
           count++;   
    }
    System.out.println();
    System.out.println("There are "+count+" 'hi's in "+str);
    System.out.println(); 
    
    //5
    System.out.print("Enter string 1: ");
    str = input.nextLine();
    str = str.toLowerCase();
    System.out.print("Enter string 2: ");
    String target = input.nextLine();
    target = target.toLowerCase();
    System.out.println();
    for(int i = 0; i < str.length()-target.length()+1; i++)
    {   
        if(str.substring(i,i+target.length()).equals(target))
           count++;   
    }
    if(count>0)
       System.out.println("Found It");
    else
       System.out.println("Nope");
    System.out.println();
    
    //6
    System.out.print("Enter a string: ");
    str = input.nextLine();
    System.out.print("Enter an integer: ");
    int n = input.nextInt();
    System.out.println();
    for(int i = 0; i < n; i++)
        System.out.print(str.substring(str.length()-n,str.length()));
    System.out.println();
    System.out.println();
    
    //8
    input.nextLine();
    System.out.print("Enter your name: ");
    String name = input.nextLine();
    String dName = name.toUpperCase();
    
    int space = name.indexOf(' ');
    
    System.out.println(name.substring(0,space) + " " + dName.substring(space+1,name.length()));
    System.out.println();
    System.out.println();
    
    //9
    System.out.print("Enter a string: ");
    str = input.nextLine();
    System.out.println();
    for(int i = 0; i < str.length(); i++)
    {
        if(str.charAt(i)!='*')
           System.out.print(str.charAt(i));
    }
    System.out.println();
    System.out.println();
    
    //10
    System.out.print("Enter your email: ");
    String email = input.nextLine();
    int at = email.indexOf('@');
    System.out.println();
    System.out.println(email.substring(at+1,email.length()));
    
    //Pig Latin App
    int counter = 0;
    int location = 0;
    
    while(counter==0)
    {
     System.out.print("Enter a string: ");
     String pigLatin = input.nextLine();
     System.out.println();
    
     if(pigLatin.equals("quit"))
     { 
         counter++;
         continue;
     }  
     if(pigLatin.charAt(0)=='a'||pigLatin.charAt(0)=='e'||pigLatin.charAt(0)=='i'||pigLatin.charAt(0)=='o'||pigLatin.charAt(0)=='u')
       pigLatin = pigLatin + "hay";
     else
     {
        for(int i = 0; i < pigLatin.length(); i++)
        {
            if(pigLatin.charAt(i)=='a'||pigLatin.charAt(i)=='e'||pigLatin.charAt(i)=='i'||pigLatin.charAt(i)=='o'||pigLatin.charAt(i)=='u')
            {   
                location = i;
                break;
            }
           }
        pigLatin = pigLatin.substring(counter+1,pigLatin.length())+pigLatin.substring(0,counter+1)+"ay";
     }
     System.out.println(pigLatin);
     System.out.println();
    }
}
}