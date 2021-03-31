import java.util.*;
import java.io.*;
/**
 * The Company class represents the main organisation and is the main class<p>
 * Also interacts with Finance, Employee, and Information classes
 */
public class Company{
    private String companyName;
    private String domain;
    private ArrayList<Employee> employees;
    private Finance cashFlow;
    
    private final String empFile = "employees.txt";
    private final String finFile = "finance.txt";

    /**
     * Contructor that initialises the Company object with a name and website.<p>
     * Contructor also initialises <code>employees</code> and <code>cashFlow</code><p>
     * Constructor calls on <code>parseEmployee</code> method that parses information from .txt file
     * @param companyName Provides name of company
     * @param domain Provides name of wesite
     * @param textFile Provides directory/name of textFile
     */
    public Company(String companyName,String domain) throws IOException{
        this.companyName = companyName;
        this.domain = domain;
        this.employees = new ArrayList<Employee>();
        parseEmployee(empFile);
        cashFlow = new Finance(this,finFile);
    }

    /**
     * Parses input from provided textFile and populates <code>employees</code><p>
     * Error message printed if FileNotFoundException occurs
     * @param textFile Provides directory/name of textFile 
     */
    public void parseEmployee(String textFile) throws IOException{
        try{
            Scanner parse = new Scanner(new File(textFile));
            while(parse.hasNextLine()){
                String name = parse.next()+" "+parse.next();
                String age = parse.next();
                String birthday = parse.next()+" "+parse.next()+" "+parse.next();
                Information stats = new Information(name, 15, birthday);
                int workHours = parse.nextInt();
                double salary = parse.nextDouble();
                String role = parse.next();
                Employee emp = new Employee(stats, workHours, salary, role);
                employees.add(emp);
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File not found...");
        }
    }

    @Override
    public String toString(){
        String toReturn = new String();
        
        toReturn += "Company: "+companyName;
        toReturn += "\nWebsite: "+domain+"\n\n";
        for(Employee e: employees){
            toReturn += e.toString();
        }
        toReturn += cashFlow.toString();
        
        return toReturn;
    }
}
