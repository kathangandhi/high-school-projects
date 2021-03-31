/************************************************************/
//                  Chapter 11 Exam - Hands-On
//         This is the ONLY Java file you may have open!
//              All work must be completed on this file.
/************************************************************/


public class Ch11Test
{
      public static void main(String[] args)
        {
         //1
         int num[] = new int[30];
         for(int i = 0; i < num.length; i++)
             num[i] = (int) ((Math.random()*5)+1);
         
         for(int t: num)
            System.out.print(t+" ");
         System.out.println();
         System.out.println();
         
         //2
        int copy[] = new int[30];
        for(int i = 0; i < copy.length; i++)
        {     
            copy[i] = num[i];
        }
        
         for(int k = 0; k < num.length; k++)
         {
             int smallest = 100;
             for(int i = 0; i < num.length; i++)
             {    
               if(num[i] < smallest) 
                  smallest = num[i];
             }
             
             for(int j = 0; j < num.length; j++)
             {  int control = 0;  
                if(num[j] == smallest && control == 0) 
                {   
                    copy[k] = num[j];
                    num[j] = 100;
                    break;
                }
             }
        }
         
        for(int t: copy)
            System.out.print(t+" ");
         System.out.println();
         System.out.println();
         
         //3
        for(int j = 0; j < num.length; j++)
         {
             if(copy[j]==1||copy[j]==3||copy[j]==5)
                copy[j] = 0;
         }
         
        for(int t: copy)
            System.out.print(t+" ");
         System.out.println();
         System.out.println();
        }
}
