package ProblemF;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class ProblemFRunner{
    private static Student[] data;

    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(new File("F.txt"));

        int size = input.nextInt();
        data = new Student[size];

        int index = 0;
        String name = new String();
        String gpa = new String();
        String studentID = new String();
        
        while(input.hasNext()){
            String phrase = input.next();

            if(phrase.length() > 2 )
                name += phrase+" ";
            else{
                gpa += phrase;
                studentID = input.next();
                data[index] = new Student(name,gpa,studentID);
                index++;

                name = new String();
                gpa = new String();
                studentID = new String();
            }
        }
        
        sortData();
        
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }

    public static void sortData(){
        boolean sorted = false;
        while(!sorted){
            int count = 0;
            
            for(int i = 0; i < data.length-1; i++){
                if(data[i].compareTo(data[i+1]) == -1){
                    Student store = data[i];
                    data[i] = data[i+1];
                    data[i+1] = store;
                    count++;
                }
            }
            
            if(count == 0)
                sorted = true;
        }
    }
}
