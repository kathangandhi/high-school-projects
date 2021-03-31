import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class WordLadder {

	String start;
	String finish;
	
	Dictionary dictionary;
	
	String wordLadder;
	
	
	public WordLadder(String start, String finish) {
		this.start = start;
		this.finish = finish;
		this.dictionary = new Dictionary(start.length());
		this.wordLadder = "Not yet known";
		initialize();
	}
	
	
	/**
	 * initializes this.wordLadder (String) to the shortest possible word ladders from this.start to this.finish (or one of the shortest)
	 */
	private void initialize() {
		
		Queue<Stack<String>> wordLadders = new LinkedList<>();
		Stack<String> firstStack = new Stack<>();
		firstStack.push(this.start);
		wordLadders.offer(firstStack);
		
		
		while(!wordLadders.isEmpty()) {
			Stack<String> current = wordLadders.poll();
			
			//check if a word ladder has been found
			if(current.size() > 1 && current.peek().equalsIgnoreCase(this.finish)) {this.wordLadder = current.toString(); return;}
			
			//get the next set of words for this stack
			List<String> adjacentWords = getAdjacentWords(current.peek());
			
			//remove any word found in alreadyUsedWords from the adjacentWords Queue and any remaining word to alreadyUsedWords
			//has already been implemented in dictionary
			
			//Add a new Stack to wordLadders for each of the remaining adjacentWords
				//for each element in adjacentWords:
				/*
				 * Create a clone of the current stack
				 * push the element
				 * add that stack to wordLadders
				 */
			for(String word: adjacentWords) {
				Stack<String> newStack = (Stack<String>) current.clone();
				newStack.push(word);
				wordLadders.offer(newStack);
			}
			
			System.out.println(wordLadders.peek().size()  + " words found");
		}
		
		this.wordLadder = "No possible wordLadder between " + this.start + " and " + this.finish;
		//	for each of the stacks in wordLadders
		// if stack.peek() == this.start, then this stack represents a word ladder
		//find all words that differ from stack.peek() by one letter (call getAdjacentWords())
		//remove any already used words from the returned Queue
		//add all the new adjacent words to the alreadyUsedWords list (so as not to ever add this word again)
		//Add a stack for each of the branching paths of this stack
		
		//if queue is empty (no word ladder exists)
		//if a stack in this.wordLadders has a top String that equals the bottom String, do the following code (word ladder has been found)
		
		/////////// DETAILED DESCRIPTION OF BRANCHING ALGORITHM ///////////////
		/* branching algorithm
		 * poll a stack from wordLadders
		 * get a Queue of adjacent words of the top item in this stack
		 * for each of these adjacent words, add a new stack to wordLadders that is a copy of the original stack plus the adjacent word
		 */
		
		//get a queue of all adjacent words, then push 
	}
	
	
	public List<String> getAdjacentWords(String word){ 
		List<String> neighbors = new ArrayList<>();
		
		List<String> equalSizedWords = dictionary.getWords();
		
		for(String potentialNeighbor: equalSizedWords) {
			
			boolean isNeighbor = true;
			int distance = 0;
			for(int i = 0; i < potentialNeighbor.length(); i++) {
				String potential = potentialNeighbor.substring(i,i+1);
				String actual = word.substring(i, i+1);
				
				if(!potential.equalsIgnoreCase(actual)) {distance++;}
				if(distance > 1) {isNeighbor = false; break;}
			}
			if(distance == 0) isNeighbor = false;
			if(isNeighbor) neighbors.add(potentialNeighbor);
			
			
		}
		
		dictionary.remove(neighbors);
		return neighbors;
	}
	
	public String getStart() {return this.start;}
	public String getFinish() {return this.finish;}
	
	@Override
	public String toString() {
		return this.wordLadder;
	}
	
	
}
