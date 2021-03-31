import java.util.*;
import java.io.*;

/**
 * The MyStringsRunner is the driver class to run MyString and MyStrings
 */
public class MyStringsRunner{
    public static void main(String[] args) throws IOException{
        //initialising procedure with file parsing 
        //makes a MyStrings object
        Scanner file = new Scanner(new File("input01.txt"));
        int rows = file.nextInt();
        int cols = file.nextInt();
        MyStrings object = new MyStrings(rows, cols);

        //adds all Strings to MyString
        for(int row = 0; row < object.getNumRows(); row++){ 
            for(int col = 0; col < object.getNumCols(); col++){
                String adder = file.next();
                MyString insert = new MyString(adder);
                object.addMyString(insert, row, col);
            }
        }

        //6 - replaces all occurrences of e with !
        for(int row = 0; row < object.getNumRows(); row++){ 
            for(int col = 0; col < object.getNumCols(); col++){
                String access = object.getMyStringAt(row, col).getTheString();
                access = access.replaceAll("e", "!");
                object.setMyStringAt(access, row, col);
            }
        }
        object.print();
        
        //7 - histogram of String lengths
        int size[] = new int[6];
        for(int row = 0; row < object.getNumRows(); row++){ 
            for(int col = 0; col < object.getNumCols(); col++){
                String access = object.getMyStringAt(row, col).getTheString();
                switch(access.length()){
                    case 3: size[0]++;
                    break;
                    case 4: size[1]++;
                    break;
                    case 5: size[2]++;
                    break;
                    case 6: size[3]++;
                    break;
                    case 7: size[4]++;
                    break;
                    case 8: size[5]++;
                    break;
                }
            }
        }

        System.out.println();
        for(int prints = 3; prints <= 8; prints++){
            System.out.println("Length of "+prints+" >>> "+size[prints-3]+" times");
        }
        
        //8
        Scanner in = new Scanner(new File("input02.txt"));
        MyStrings obj2 = new MyStrings(in.nextInt(), in.nextInt());
        
        for(int r = 0; r < obj2.getNumRows(); r++){
            for(int c = 0; c < obj2.getNumCols(); c++){
                MyString str = new MyString(in.next());
                obj2.addMyString(str, r, c);
            }
        }
        
        for(int r = 0; r < obj2.getNumRows(); r++){
            for(int c = 0; c < obj2.getNumCols(); c++){
                String access = obj2.getMyStringAt(r, c).getTheString();
                if(access.endsWith("e"))
                    access+="!";
                obj2.setMyStringAt(access, r, c);
            }
        }
        System.out.println();
        obj2.print();
    }
}
