import java.util.*;
import java.io.*;
public class Finance{
    private double budget;
    private Company company;
    
    public Finance(Company company,String textFile) throws IOException{
        this.company = company;
        setFinance(textFile);
    }
    
    public void setBudget(int newBudget){
        this.budget = newBudget;
    }
    
    public double getBudget(){
        return this.budget;
    }
    
    public void setFinance(String textFile) throws IOException{
        try{
            Scanner input = new Scanner(new File(textFile));
            this.budget = input.nextDouble();
        }
        catch(FileNotFoundException e){
            System.err.println("File not Found");
        }
    }

    @Override
    public String toString(){
        String toReturn = new String();
        toReturn += "Budget: "+this.budget+"\n";
        return toReturn;
    }
}