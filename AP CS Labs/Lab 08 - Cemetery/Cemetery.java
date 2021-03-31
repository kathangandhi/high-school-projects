import java.util.*;
import java.io.*;

public class Cemetery{
    ArrayList<Tombstone> list = new ArrayList<Tombstone>();//represents a collection of Tombstones
    
    /**
     * Cemetery contructor to parse data from a text file, 
     * create a cemetery and print the average age of the deceased
     */
    public Cemetery(String fileName) throws IOException{
        createCemetery(fileName);
        System.out.println((int)(getAge()/365.0)+" year(s)");
    }

    /**
     * Parses data from the textfile and initialise the collection
     * @param fileName name of the textfile
     */
    public void createCemetery(String fileName) throws IOException{
        Scanner line = new Scanner(new File(fileName));

        for(int I = 0; I < 612; I++){
            //scanner to parse textfile
            Scanner in = new Scanner(line.nextLine());
            
            //declaring variables
            String name = "";
            String date = "";
            double age = 0;
            String address = "";
            
            //parse name till you find number
            while(!in.hasNextInt()){
                name += in.next()+" ";
            }
            
            //next 3 nos. represent the burialDate
            for(int i = 0; i < 3; i++){
                date += in.next()+" ";
            }
            
            //parse age based on weird nos. and symbols 
            age = parseAge(in.next());
            
            //add to address till end of line
            while(in.hasNext()){
                address += in.next()+" ";
            }
            
            //initialise and store new Tombstone object based on parse variables
            list.add(new Tombstone(name,date,age,address));
        }
    }

    /** 
     * Calculates the average age of the Cemetery population in the <code>list</code>
     * @return the average age of the Cemetery population
     */
    public int getAge(){
        int totalAge = 0, avgAge = 0;

        for(int i = 0; i < list.size(); i++)
            totalAge += list.get(i).getAge();
        System.out.println(totalAge);
        avgAge = totalAge/list.size();

        return avgAge;
    }

    /**
     * Helper method to parseAge from textfile by Mr. Bunn
     * @param ageString weird numbers and letters to represent age
     */
    public static int parseAge(String ageString)
    {
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;

        boolean done = true;

        try { result = Integer.parseInt(ageString); } //is the String a whole number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years

        double ageDouble = 0;

        done = true;

        try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }

        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }

        return 0;
    }
}
