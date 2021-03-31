import java.util.*;

public class usingStrings
{
      public static void main(String[] args)
        {
           
           System.out.println(); 
           System.out.println("Part 1 - Name"); 
           //Create a new String called name that stores your first and last name
           //NOTE: This is the ONLY time you will type your name. You must use
           //the appropriate string methods on the remaining parts.
           //Output name.
           String name = "Kathan Gandhi";
           System.out.println(name);
           
           
           System.out.println(); 
           System.out.println("Part 2 - Total characters in string"); 
           //Output the total number of characters in the string.
           System.out.println(name.length());
           
           
           System.out.println(); 
           System.out.println("Part 3 - Upper Case"); 
           //Create a new string called nameUpper which should be 
           //full name in all upper case letters. DO NOT just type
           //your name, use the appropriate string method to initialize nameUpper.
           //Output nameUpper
           String nameUpper = name.toUpperCase();           
           System.out.println(nameUpper);
           
           System.out.println(); 
           System.out.println("Part 4 - Lower Case"); 
           //Create a new string called nameLower which should be 
           //full name in all lower case letters. DO NOT just type
           //your name, use the appropriate string method.
           //Output nameLower
           String nameLower = name.toLowerCase();
           System.out.println(nameLower);
           
           System.out.println(); 
           System.out.println("Part 5 - First Name"); 
           //Create a new string called fisrt and use the subtring method to 
           //initialize it to your first name only from the name string.
           //Output first
           String first = name.substring(0,6);
           System.out.println(first);
           
           System.out.println(); 
           System.out.println("Part 6 - Last Name"); 
           //Create a new string called last and use the subtring method to 
           //initialize it to your first name only from the name string.
           //Output last
           String last = name.substring(7,13);
           System.out.println(last);
           
           
           System.out.println(); 
           System.out.println("Part 7 - No Vowels");
           //Use the appropriat method to replace all the vowels 
           //in String name with the * symmbol. NOTE: You need to modify
           //the original String name, do not create any new Strings here.
           //Output name
           name = name.replace('a','*');
           name = name.replace('e','*');
           name = name.replace('i','*');
           name = name.replace('o','*');
           name = name.replace('u','*');
           System.out.println(name);
           
           System.out.println(); 
           System.out.println("Part 8 - Full Name");
           //Create a new string called full. Use the String first and last to 
           //initialize full with your first and last name. Be sure to 
           //Include a space.
           //Output full.
           String full = new String();
           full = first+" "+last;
           System.out.println(full);
           
           
           
        }
}
