import java.util.*;
import java.io.*;

public class StudentTester
{   
    public static void main(String[] args) throws IOException
    {
        List<Student> list = new ArrayList<Student>();
        //      Student a = new Student("Joe", 100009);
        //      Student b = new Student("Sally", 100004);
        //      Student c = new Student("Sam", 100007);
        //      Student d = new Student("Bob", 100006);
        //
        //      list.add(a); list.add(b); list.add(c); list.add(d);
        //      

        Scanner in = new Scanner(new File("names.csv"));

        while(in.hasNext()){
            String name = in.next();
            int studentID = (int)(Math.random()*1000)+100000;
            Student s = new Student(name,studentID);
            list.add(s);
        }
        
        Student.sort(list);
        System.out.println(list);
    }
}
