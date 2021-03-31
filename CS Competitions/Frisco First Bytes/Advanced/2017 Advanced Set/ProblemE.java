import java.util.*;
import java.io.*;

public class ProblemE{
    private static ArrayList<Integer> carList;
    private static ArrayList<Integer> pitList;
    private static Scanner input;

    public static void main(String args[]) throws IOException{
        input = new Scanner(new File("E.txt"));
        carList = new ArrayList<Integer>();
        pitList = new ArrayList<Integer>();

        while(input.hasNextLine()){
            String command = input.next();
            if(command.equals("START"))
                initialise();
            else if(command.equals("DROPOUT"))
                dropRemove();
            else if(command.equals("OVERTAKE"))
                shuffle();
            else if(command.equals("PITSTOP"))
                pitStop();
            else if(command.equals("PITRETURN"))
                pitReturn();
            else if(command.equals("CRASH"))
                crashRemove();
            else if(command.equals("END"))
                end();
        }
    }

    public static void initialise(){
        while(input.hasNextInt()){
            carList.add(input.nextInt());
        }
        input.nextLine();
    }

    public static void dropRemove(){
        int carNumber = input.nextInt();
        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i) == carNumber){
                carList.remove(i);
                break;
            }
        }
        input.nextLine();
    }

    public static void shuffle(){
        int carNumber = input.nextInt();
        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i) == carNumber){
                carList.add(i-1,carList.remove(i));
                break;
            }
        }
        input.nextLine();
    }

    public static void pitStop(){
        int carNumber = input.nextInt();
        pitList.add(carNumber);

        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i) == carNumber){
                carList.remove(i);
                break;
            }
        }
        input.nextLine();
    }

    public static void pitReturn(){
        int carNumber = input.nextInt();
        int place = input.nextInt();
        for(int i = 0; i < pitList.size(); i++){
            if(pitList.get(i) == carNumber){
                pitList.remove(i);
                break;
            }
        }
        
        carList.add(place,carNumber);
        input.nextLine();
    }
    
    public static void crashRemove(){
        while(input.hasNextInt()){
            int carNumber = input.nextInt();
            for(int i = 0; i < carList.size(); i++){
                if(carList.get(i) == carNumber){
                    carList.remove(i);
                    break;
                }
            }
        }
        input.nextLine();
    }

    public static void end(){
        System.out.println(carList);
        carList = new ArrayList<Integer>();
        pitList = new ArrayList<Integer>();
        input.nextLine();
    }
}
