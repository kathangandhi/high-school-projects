import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		
		//initialize the input scanner
		File inputFile = new File("input.txt");
		try {
			Scanner inScan = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/////TESTING/////////
		
		
		
	}
}
