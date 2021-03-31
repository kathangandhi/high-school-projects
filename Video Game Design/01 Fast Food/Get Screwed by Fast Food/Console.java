import java.util.*;
import java.io.*;

/**
 * Main class that starts the game
 *
 * @author Kathan Gandhi
 * @version 08/19/2019
 */
public class Console{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        Scanner file; 

        //Loading menu
        try{
            System.out.print("Loading");
            for(int i = 0; i < 3; i++){
                Thread.sleep(1000);
                System.out.print("..");
            }
            System.out.println();
        }
        catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Sorry, the game crased! Please restart.");
        }

        //Welcome session
        System.out.println("\nWelcome to Get Screwed by Fast Food\n");
        System.out.print("Enter name: ");
        String name = reader.nextLine();

        System.out.println("\f");
        System.out.println("Hello, "+name+"! Get ready to survive the week.\n");

        System.out.println("Skip Briefing? (y/n)");
        String yn = reader.next();
        if(yn.equalsIgnoreCase("y"))
            System.out.println("\f");
        else if(yn.equalsIgnoreCase("n")){
            //Briefing
            System.out.println("\f");
            try{
                Thread.sleep(2500);
                file = new Scanner(new File("Briefing.txt"));
                while(file.hasNextLine()){
                    System.out.println(file.nextLine());
                    Thread.sleep(2500);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("Couldn't find file! Please restart.");
            }
        }
        else{
            System.out.println("You tried to mess around! GOODBYE");
            System.exit(0);
        }
        System.out.print("Continue? (press any key): ");
        yn = reader.next();
        System.out.println("\f");

        System.out.println("Skip Controls? (y/n)");
        yn = reader.next();
        if(yn.equalsIgnoreCase("y"))
            System.out.println("\f");
        else if(yn.equalsIgnoreCase("n")){
            //Controls
            System.out.println("\f");
            try{
                Thread.sleep(2500);
                file = new Scanner(new File("Controls.txt"));
                while(file.hasNextLine()){
                    System.out.println(file.nextLine());
                    Thread.sleep(2500);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("Couldn't find file! Please restart.");
            }
        }
        else{
            System.out.println("You tried to mess around! GOODBYE");
            System.exit(0);
        }
        System.out.print("Continue? (press any key): ");
        yn = reader.next();

        //Person & Menu creation
        Menu m = new Menu();
        Person player = new Person(name,m);

        int time = 3;
        while(!player.didPersonLose()){
            updateConsole(player,m,time);
            ++time;
            if(time % 21 == 0)
                player.addMoney();
        }

        System.out.println("\f");
        System.out.println("Game Over!\n");
        System.out.println("You survived "+(int)time/3+" day(s)!");
    }

    public static void updateConsole(Person p, Menu m, int time){
        System.out.println("\f");
        System.out.print("Day: "+(int)time/3+"\t\t\t\t\t\t\t\t\t\t");
        System.out.println("Calories: "+p.getCalLevel()+" Money: "+p.getMoney());
        System.out.println("Calorie Range: "+Arrays.toString(p.getCalRange()));
        System.out.println();

        ArrayList<Food> menu = p.getMenu();
        for(int i = 0; i < menu.size(); i++){
            System.out.println((i+1)+" "+menu.get(i).toString());
        } 
        System.out.println();

        String choice = new String();
        while(!choice.matches("[0-9]+")){
            Scanner reader = new Scanner(System.in);
            System.out.println("What would you like to eat?");
            choice = reader.next();
            if(choice.matches("[0-9]+"))
                p.makeChoice(Integer.parseInt(choice));
        }

        try{
            System.out.println("\f");
            Thread.sleep(1000);
            System.out.println("Current Calories: "+p.getCalLevel());
            Thread.sleep(1000);
            System.out.println("You work and lose calories too");
            p.burnCal();
            System.out.println("You now have: "+p.getCalLevel()+" calories");
            Thread.sleep(3000);
        }
        catch(Exception e){
            System.out.println("Game crashed");
        }
    }
}