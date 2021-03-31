

public class ArraysDemo
{
    public static void main(String args[])
    {
        //double numbers[] = {10.0,30.0,20.0,40.0};
        //numbers[2]=10.0;
        //System.out.println(numbers[2]);
        
        int numbers[] = new int[5];//array object
                                   //5 means no. of slots
        
        for(int i = 0; i<5; i++)
           numbers[i] = (int) (Math.random()*100);
           
        //for(int i = 0; i<5; i++)
           //System.out.println(numbers[i]);
           
        for(int i: numbers)//for each loop
           System.out.println(i);//read only 
    }
}
