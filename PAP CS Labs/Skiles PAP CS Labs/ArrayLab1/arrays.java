import java.util.*;

public class arrays
{
    public static void main(String args[])
    {
        //Sets a radnom value for size;
        int size = (int) (Math.random()*25)+25;
        
        //Creates the array with the size.
        int numbers[] = new int[size];
        for(int i=0; i<size; i++)
            numbers[i] = (int) (Math.random()*100);
            
        //Size is set to 0 so you will not be able to use this variable.
        size=0;
        
       System.out.print("1. Total number of elements in the array: ");
        //1. Output the length of the array.
        System.out.println(numbers.length);
       
        
        
       System.out.println(); 
       System.out.println("2. Original values in array"); 
        //2. Output all the values in the array in a SINGLE LINE separated by a space.
        for(int i: numbers)
           System.out.print(i+" ");
       
       
       System.out.println(); 
       System.out.println();
       System.out.println("3. Reverse order of values in the array");
        //3. Output all the values in the array in reverse order in a SINGLE LINE separated by a space.
        for(int i = numbers.length - 1; i>=0; i--)
           System.out.print(numbers[i]+" ");
       
       
       System.out.println(); 
       System.out.println();
       System.out.println("4. The total of all the values in the array are");
        //4. Add up all the values in the array and output it.
        int sum = 0;
        for(int i: numbers)
           
            sum += i;
        System.out.println(sum);
       
       System.out.println(); 
       System.out.println("5. The average of all the values in the array is");
        //5. Calculate the average value and output it.
        sum = 0;
        for(int i: numbers)
          
            sum += i;
        int average = sum/numbers.length;
        System.out.println(average);
       
       System.out.println(); 
       System.out.println("6. The largest value in the array is");
        //6. Identify the largest value in the array and output it
        int largest = 0;
        for(int i = 0; i < numbers.length; i++)
        {
           if(largest<numbers[i])
             largest = numbers[i];
           
        }
        System.out.println(largest);
       
       System.out.println(); 
       System.out.println("7. The smallest value in the array is");
        //7. Identify the smallest value in the array and output it
        int smallest = 100;
        for(int i = 0; i < numbers.length; i++)
        {
           if(smallest>numbers[i])
             smallest = numbers[i];
           
        }
        System.out.println(smallest);
        
       System.out.println(); 
       System.out.println("8. The even numbers in the array are");
        //8. Output all the even values in the array in a SINGLE LINE separated by a space.
        int even = 0;
        for(int i : numbers)
         { 
            if(i%2==0)
            {  
                even++;
                System.out.print(i+" ");
            }
         }
        System.out.println(even);
        
       System.out.println(); 
       System.out.println("9. The odd numbers in the array are");
        //9. Output all the odd values in the array in a SINGLE LINE separated by a space.
        int odd = 0;
        for(int i : numbers)
         { 
             if(i%2!=0)
             {  
                 odd++;
                 System.out.print(i+" ");
             }
         }
        System.out.println(odd);
       
       System.out.println(); 
       System.out.println("10. The first and last values in the array swapped");
        //10. You will output the array twince. First output the original
        // values in the array in a SINGLE LINE separated by a space. Next swop the first and last
        // values in the array and output it again in a SINGLE LINE separated by a space below the original
        // showing that the values have been swapped.
        int changer = numbers[0];
        for(int i: numbers)
           System.out.print(i+" ");
        System.out.println();
        numbers[0]=numbers[numbers.length-1];
        numbers[numbers.length-1]=changer;
        for(int i: numbers)
           System.out.print(i+" ");
       System.out.println();
       System.out.println();
       
        //11. Create a new array called num and it should be the same size as numbers. Copy all the values from
        //numbers into num.
        System.out.println("11. Array Values");
        int num[]=new int[numbers.length];
        int numd[]=new int[numbers.length];
        for(int i = 0; i < numbers.length; i++)
        { 
            num[i] = numbers[i];
            System.out.print(num[i]+" ");
        } 
        for(int i = 0; i < numbers.length; i++)
        { 
            numd[i] = numbers[i];
            System.out.print(num[i]+" ");
        } 
       System.out.println();
       System.out.println();
        
        //12. Sort all the values in num in ascending order, least to greatest. Output all the values of the array in a
        //single line separated by a space.
        System.out.println("12. Descending Order");
        
        for(int i = 0; i <= num.length - 1; i++)
        {  
           largest = 0;
           for(int j = 0; j < num.length; j++)
           {
            if(largest < num[j])
              largest = num[j];
           
           }
           
           for(int k = 0; k < num.length ; k++)
           {
            if(largest==num[k])
            {
              System.out.print(num[k]+" ");
              num[k] = 0;
              break;
            }
            }
          
           
        }
        
       //13. Sort all the values in numbers in descending order, greatest to least. Output all the values of the
        //array in a single line separated by a space.
        System.out.println();
        System.out.println();
        System.out.println("13. Ascending Order");
        for(int i = 0; i <= numd.length - 1; i++)
        {  
           smallest = 100;
           for(int j = 0; j < numd.length; j++)
           {
            if(smallest > numd[j])
              smallest = numd[j];
           
           }
           
           for(int k = 0; k < numd.length ; k++)
           {
            if(smallest==numd[k])
            {
              System.out.print(numd[k]+" ");
              numd[k] = 100;
              break;
            }
            }
          
           
        }
       System.out.println();
       System.out.println();
       //14. Create a new array called count and set its size to 20 and initialize it to random values ranging from 0
        //to 5. Output all the values of the array in a single line
        System.out.println("14. All The Values Of the Array");
        int count[] = new int[20];
        for(int i = 0; i < 20; i++)
          count[i] = (int)(Math.random()*6);
        for(int i: count)
           System.out.print(i+" ");
        
       System.out.println();
        //15. You will create a histogram. Go through the array counting all the 0s, 1s, 2s, 3s, 4, and 5s. Create a
        //graph using the asterisks symbol. Output one * for each instance of the searched values in the chart.
        //Your final output should look similar to the example below. There should be a total of 20 asterisks
        //shown when complete.
        System.out.println();
        System.out.println("Histogram");
        int zero = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        
        for(int i = 0; i < 20; i++ )
        {
            if(count[i]==0)
              zero++;
            if(count[i]==1)
              one++;
            if(count[i]==2)
              two++;
            if(count[i]==3)
              three++;
            if(count[i]==4)
              four++;
            if(count[i]==5)
              five++;
        }
        System.out.print("0s = ");
        for(int i = 0; i < zero; i++)
          System.out.print("*");
        System.out.println();
        System.out.print("1s = ");
        for(int i = 0; i < one; i++)
          System.out.print("*");
        System.out.println();
        System.out.print("2s = ");
        for(int i = 0; i < two; i++)
          System.out.print("*");
        System.out.println();
        System.out.print("3s = ");
        for(int i = 0; i < three; i++)
          System.out.print("*");
        System.out.println();
        System.out.print("4s = ");
        for(int i = 0; i < four; i++)
          System.out.print("*");
        System.out.println();
        System.out.print("5s = ");
        for(int i = 0; i < five; i++)
          System.out.print("*");
        System.out.println();
    }
    
    
    
}