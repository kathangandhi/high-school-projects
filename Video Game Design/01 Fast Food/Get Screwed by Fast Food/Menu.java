import java.util.*;
import java.util.stream.*;
import java.io.*;

/**
 * Menu organizes the Food choices the player gets
 *
 * @author Kathan Gandhi
 * @version 08/23/2019
 */
public class Menu{
    private ArrayList<Food> fullMenu;
    private ArrayList<Food> available;

    public Menu(){
        fullMenu = new ArrayList<>();
        available = new ArrayList<>();

        loadMenu();
    }

    public void loadMenu(){
        try{
            Scanner file = new Scanner(new File("Menu.txt"));  
            while(file.hasNextLine()){
                String name = file.next();
                int cal = file.nextInt();
                double price = file.nextDouble();

                Food item = new Food(name,cal,price);
                fullMenu.add(item);
            }   
        }
        catch(FileNotFoundException e){
            System.out.println("Failed to load data! Please restart!");
        }
    }

    public ArrayList<Food> makeAvailable(){
        available.clear();
        int choices = 1+(int)(Math.random()*4);

        for(int i = 0; i < choices; i++){
            int r = (int)(Math.random()*fullMenu.size());
            available.add(fullMenu.get(r));
        }

        Set<Food> set = new HashSet<>(available);
        available.clear();
        available.addAll(set);
        
        return available;
    }

    public ArrayList<Food> getAvailable(){
        return available;
    }

    public String toString(){
        String toReturn = new String();

        for(int i = 0; i < fullMenu.size(); i++){
            toReturn += fullMenu.get(i).toString()+"\n";
        }

        return toReturn;
    }
}