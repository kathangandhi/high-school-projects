import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Dictionary {
 //store words into a HashMap<wordSize, List of those words>
	
	private List<String> words;
	private Scanner sc;
	private int sizeCategory;
	
	
	public Dictionary(int sizeCategory) {
		words = new ArrayList<>();
		this.sizeCategory = sizeCategory;
		
		File dictionary = new File("dictionary.txt");
		try {
			sc = new Scanner(dictionary);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
	}
	
	
	
	private void initialize() { //should create a hashmap of wordSize <Integer wordSize, List<String>>
		
		while(sc.hasNext()) {
			String word = sc.next();
			
			if(word.length() == this.sizeCategory) this.words.add(word);
		}
		
		
	}
	
	
	public List<String> getWords(){ 
		return this.words;
	}
	
	public void remove(List<String> toRemove) {
		for(String word: toRemove) {
			this.words.remove(word);
		}
	}
	
	
	
}
