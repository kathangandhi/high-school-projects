import java.util.*;
import java.io.*;

public class FFB2015
{
    public static void main(String args[]) throws Exception{
        /*//A Tax Man
        Scanner fileA = new Scanner(new File("Tax.txt"));
        double taxRate = 0.08375;
        int price = fileA.nextInt();

        System.out.println("Tax Amount: $ "+(price*taxRate));
         */
        /*
        //B Ticket To Ride
        Scanner fileB = new Scanner(new File("Ticket.txt"));
        int sum = 0;

        for(int i = 0; i < 5; i++)
        sum += fileB.nextInt();
        System.out.println("Bag Weight: "+sum);

        if(sum <= 50)
        System.out.println("Bag under limit, no up charge");

        else
        System.out.println("Bag over weight, pay $50 extra");
         */
        /*
        //C I Feel Fine
        Scanner fileC = new Scanner(new File("Fine.txt"));
        int numDays = fileC.nextInt();
        int hours = 0;

        while(fileC.hasNext()){
        hours += fileC.nextInt();
        }
        double average = (double) hours/numDays;

        System.out.println("Total vacation time missed: "+hours+" hours");
        System.out.println("Average daily time missed: "+average+" hours");
         */
        /*
        //D Day Tripper
        Scanner fileD = new Scanner(new File("Tripper.txt"));
        int numDays = fileD.nextInt();
        int price = 0;

        for(int day = 0; day < numDays; day++){
        int trips = 0;
        trips += fileD.nextInt();
        for(int bill = 0; bill < trips; bill++)
        price += fileD.nextInt();
        }
        int savings = 3500 - price;
        int pounds = savings/100;
        int pence = savings - pounds*100;

        if(savings < 0){
        System.out.println("BUY THE TRAVELCARD");  
        System.out.println("Expected savings: "+Math.abs(pounds)+" Pounds, "+Math.abs(pence)+" Pence"); 
        }
        else if(savings > 0){
        System.out.println("BUY SINGLE-USE TICKETS");
        System.out.println("Expected savings: "+Math.abs(pounds)+" Pounds, "+Math.abs(pence)+" Pence");
        }
        else
        System.out.println("Both are equal!");
         */
        /*
        //E Paperback Writer
        Scanner fileE = new Scanner(new File("Writer.txt"));
        String sentence = fileE.nextLine();
        String words[] = sentence.split(" ");
        int pairs = fileE.nextInt();
        fileE.nextLine();

        for(int count = 0; count < words.length; count++){
        Scanner loop = new Scanner(new File("Writer.txt"));
        loop.nextLine();
        loop.nextLine();
        for(int list = 0; list < pairs; list++){
        String key = loop.next();
        if(words[count].contains(key))
        words[count] = words[count].replaceAll(key, loop.next()+loop.nextLine());
        else
        loop.nextLine();
        }
        }

        for(String out: words)
        System.out.print(out+" ");
         */
        ///*
        //F Mowing The Lawn 
        Scanner fileF = new Scanner(new File("goat.txt"));
        int numBldgs = fileF.nextInt();
        String names[] = new String[numBldgs];
        int stats[][] = new int[numBldgs][3]; 
        int out[] = new int[numBldgs];
        
        for(int i = 0; i < numBldgs; i++){
            names[i] = fileF.next();
            stats[i][0] = fileF.nextInt();
            stats[i][1] = fileF.nextInt();
            stats[i][2] = fileF.nextInt();
        }
        
        for(int i = 0; i < numBldgs; i++){
            out[i] = 3*stats[i][2]*stats[i][2] + (int)Math.pow(stats[i][2] - stats[i][0],2) + (int)Math.pow(stats[i][2] - stats[i][1],2);
            out[i] *= Math.PI/4;
        }
        
        for(int i = 0; i < numBldgs; i++){
            System.out.println(names[i]+" "+out[i]);
        }
        //*/
        /*
        //G Pool Deck problem
        Scanner fileG = new Scanner(new File("pool.txt"));
        int count = 0;
        while(fileG.hasNext()){
        fileG.nextLine();
        count++;
        }
        int numBarrels[] = new int[count];
        int diameters[] = new int[count];
        int widths[] = new int[count];

        count = 0;
        Scanner value = new Scanner(new File("pool.txt"));
        while(value.hasNext()){
        numBarrels[count] = value.nextInt();
        diameters[count] = value.nextInt();
        count++;
        }

        for(int time = 0; time < 3; time++){
        widths[time] = -diameters[time] + (int) Math.sqrt((diameters[time] * diameters[time]) + (4 * numBarrels[time]));
        widths[time] /= 2;
        }

        for(int out: widths)    
        System.out.println(out);
         */
    }
}