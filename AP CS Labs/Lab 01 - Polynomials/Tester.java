import java.util.*;
public class Tester{
    public static void main(String args[]){
        //3
        System.out.print("Hello again, world");
        //4
        //The above prints "Hello again, world"

        //5
        int numApples = 10;

        //6
        final int PRICE_OF_APPLE = 210;

        //7
        System.out.println("Price of apples: "+numApples*PRICE_OF_APPLE);

        //8
        if(numApples*PRICE_OF_APPLE>=2000)
            System.out.println("Thank you, valued customer");
            
        //9
        for(int i = 1; i < 13; i++)
            System.out.print(i+" ");
        System.out.println();    
        
        //10
        for(int i = 1; i < 10; i++)
            System.out.print(i*i+" ");
        System.out.println();
        
        //11
        for(int i = 0; i < 5; i++)
            System.out.print((int) Math.pow(4,i)+" ");
        System.out.println();
        
        //12
        System.out.println("What dissapears the moment you say its name?");
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            
        }
        System.out.println("Silence");
        
        //13
        Scanner console = new Scanner(System.in);
        
        //14
        System.out.println("What is your name");
        String name = console.nextLine();
        
        //15
        System.out.println(name.length());
        
        //16
        int userInput = 1;
        double sum = 0;
        int count = 0;
        while(userInput!=0){
            System.out.println("Enter a no.: ");
            userInput=console.nextInt();
            sum+=(double) userInput;
            count++;
        }
        double average = sum/count;
        System.out.println("Sum: "+(int) sum);
        System.out.println("Average: "+average);
        
        //17
        double areas[];
        areas = new double[9];
        
        //19
        areas[0] = 4.56;
        
        //20
        areas[8] = 8.08;
        
        //21
        boolean tf[] = {true,true,false,false,true};
        
        //22
        System.out.println();
        
        //23
        method();
        
        //24
        addNums(20,13);
        
        //25
        longString("hey","nope");
        
        //26
        altCaps("hello");
        
        //28
        Player winner = new Player();
        Player loser = new Player("Loser",0);
        System.out.println(winner.playerInfo());
        System.out.println(loser.playerInfo());
        
    }
    
    public static void method(){
        System.out.println("This is a method");
    }
    
    public static void addNums(int num1, int num2){
        System.out.println(num1+num2);
    } 
    
    public static void longString(String s1, String s2){
        if(s1.length()>s2.length())
            System.out.println(s1);
        else
            System.out.println(s2);
    }
    
    public static void altCaps(String message){
        String m="";
        for(int i = 0; i < message.length(); i++){
            if(i%2!=0)
               m+=message.substring(i,i+1).toUpperCase(); 
            else
               m+=message.charAt(i);
        }
        System.out.println(m);
    }
}
