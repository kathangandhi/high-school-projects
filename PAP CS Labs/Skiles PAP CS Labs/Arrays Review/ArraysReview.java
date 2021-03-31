

public class ArraysReview
{
   public static void main(String args[])
   {
       //1
       double num1[] = new double[15];
       
       //2
       for(int i = 0; i < num1.length; i++)
           num1[i] = ((int)(Math.random()*150000))/10000.0;
        
       //3
       System.out.println("Values of num1");
       for(double t:num1)
           System.out.print(t+" ");
       System.out.println();
       System.out.println();
       //4
       int num2[] = new int[15];
       
       //5
       for(int i = 0; i < num1.length; i++)
          num2[i] = (int) num1[i];
          
       //6
       System.out.println("Values of num2");
       for(int t:num2)
           System.out.print(t+" ");
       System.out.println(); 
       System.out.println();
       
       //8
       sort(num2);
       System.out.println("Num2 Sorted");
       for(int t:num2)
           System.out.print(t+" ");
       System.out.println();
       System.out.println();
       
       //10
       duplicates(num2);
       System.out.println("Num2 w/o duplicates");
       for(int t:num2)
           System.out.print(t+" ");
       System.out.println();
       System.out.println();
       
       //11
       String phrase[] = {"The","bid","brown","fox","jumped","over","the","lazy","sleeping","dog"};
       System.out.println("Total number of vowels: " + numVowels(phrase));      
    }
    
   public static void sort(int[] x)
   {
       int duplicate[] = new int[15];
       for(int i = 0; i < x.length; i++)
          duplicate[i] = x[i];
        
       for(int i = 0; i < x.length; i++)
       {
           int smallest = 100;
           for(int j = 0; j < duplicate.length; j++)
           {
              if(duplicate[j]<smallest)
                 smallest = duplicate[j];
              
           }
           for(int k = 0; k < duplicate.length; k++)
           {
              int temp = 100;
              if(duplicate[k]==smallest)
              {  
                  duplicate[k]=temp;
                  break;
              }
           }
           x[i] = smallest;
       }
   }
   
   public static void duplicates(int[] x)
   {
       boolean check = false;
       while(!check)
       {
          for(int j = 0; j < 14; j++)
          {
           if(x[j]==x[j+1])
              x[j+1] = (int)(Math.random()*15);
           
           
          }
          sort(x);
          if(x[0]!=x[1]&&x[1]!=x[2]&&x[2]!=x[3]&&x[3]!=x[4]&&x[4]!=x[5]&&x[5]!=x[6]&&x[7]!=x[8]&&x[8]!=x[9]&&x[10]!=x[11]&&x[11]!=x[12]&&x[12]!=x[13]&&x[13]!=x[14])
             check = true;
       }
       
   }
   
   public static int numVowels(String[] x)
   {
       int characters = 0;
       for(int s = 0; s < x.length; s++)
       {
           for(int i = 0;i < x[s].length(); i++)
           {
               if(x[s].charAt(i)=='a'||x[s].charAt(i)=='e'||x[s].charAt(i)=='i'||x[s].charAt(i)=='o'||x[s].charAt(i)=='u')
                  characters++;
           }
       }
       return characters;
   }
}
