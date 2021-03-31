
//Name:
//Period:
import java.util.*;
public class hangman
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int[] a = {5, 34, 3, -6, 7, 81, 1, 7, 5, 2, 2, 53, 4, 5, 62, 7};
        int[] b = {1, 3, 4, 90, -4, 60, 12, 13, 4, -4, -1, 2, 4, 4, 9, 8};

        //2
        int suma = 0;
        for(int i = 0; i < a.length; i++)
            suma+=a[i];

        int sumb = 0;
        for(int j = 0; j < b.length; j++)
            sumb+=b[j];
        int average = (suma + sumb)/(a.length + b.length);
        System.out.println("Arrays Average "+average);
        System.out.println();

        //3
        int even = 0;
        int odd = 0;
        for(int k = 0; k < a.length; k++)
        {
            if(a[k]%2==0)
                even++;
            else
                odd++;

            if(b[k]%2==0)
                even++;
            else
                odd++;
        }

        if(even>odd)
            System.out.println("More even than odd.");
        else if(odd>even)
            System.out.println("More odd than even.");
        else
            System.out.println("Even equals odd.");
        System.out.println();

        //4
        int first = 0;
        int second = 0;
        int third = 0;

        for(int l = 0; l < a.length - 3; l++)
        {
            first = a[l];
            second = a[l+1];
            third = a[l+2];
            if(first+1==second&&second+1==third)
            {   
                System.out.println(first+" "+second+" "+third);
                System.out.println("Three in a row!");
            }
        }

        for(int m = 0; m < b.length - 3; m++)
        {
            first = b[m];
            second = b[m+1];
            third = b[m+2];
            if(first+1==second&&second+1==third)
            {   
                System.out.println(first+" "+second+" "+third);
                System.out.println("Three in a row!");
            }
        }
        System.out.println("Did not find three in a row.");
        System.out.println();

        //Riddle

        //6
        int c[] = new int[a.length];
        for(int reverse = 0; reverse < c.length; reverse++)
        {
            c[reverse] = a[(a.length-1)-reverse];
        }

        for(int t:c)
            System.out.print(t+" ");
        System.out.println();
        System.out.println();

        //7
        int largestA = 0;
        for(int n = 0; n < a.length; n++)
        {
            if(largestA<a[n])
                largestA = a[n];
        }

        int smallestA = 100;
        for(int o = 0; o < a.length; o++)
        {
            if(smallestA>a[o])
                smallestA = a[o];

        }

        int rangeA = largestA - smallestA;

        int largestB = 0;
        for(int n = 0; n < b.length; n++)
        {
            if(largestB<b[n])
                largestB = b[n];
        }

        int smallestB = 100;
        for(int o = 0; o < b.length; o++)
        {
            if(smallestB>a[o])
                smallestB = b[o];

        }

        int rangeB = largestB - smallestB;

        System.out.println("Range for A: "+rangeA);
        System.out.println("Range for B: "+rangeB);
        System.out.println();

        //Riddle
        System.out.println("180 Minutes");

        //Hangman
        String[] secret = {"c", "o", "m", "p", "u", "t", "e", "r"};
        String[] masked = new String[secret.length];

        for(int h = 0; h < masked.length; h++)
            masked[h] = "_";
        int guesses = 10;
        String temp;
        
        do
        {   boolean check = true;
            int characters = 0;
            for(String g: masked)
                System.out.print(g+" ");
            System.out.println();
            System.out.println("Take a guess");
            temp = input.nextLine();
            for(int t = 0; t < masked.length; t++)
            {
                
                    if(temp.equals(secret[t]))
                    {   
                        System.out.println("Correct Letter!");
                        masked[t] = temp;
                        t = masked.length;
                        check=false;
                    }
                    
                }
                
            if (check){
              guesses--;
              System.out.println(guesses+" Guesses Left");
            }
            
            for(int d = 0; d < masked.length; d++)
            {
             if(masked[d].equals(secret[d]))
               characters++;
            }
            if(characters==masked.length)
            {
              System.out.println("Congrats You Win");
              break;
            }
        }while(guesses>0);

    }
}