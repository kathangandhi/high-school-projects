import java.util.ArrayList;
import java.util.Stack;

public class StackProbs {

	public static Stack<Integer> doubleUp(Stack<Integer> nums){
		Stack<Integer> temp = new Stack<>();
		int currentValue;
		
		while(!nums.empty()) {
			currentValue = nums.pop();
			temp.push(currentValue);
			temp.push(currentValue);
		}
		
		while(!temp.empty()) {
			currentValue = temp.pop();
			nums.push(currentValue);
		}
		
		return nums;
	}
	
	public static Stack<Integer> posAndNeg(Stack<Integer> nums){
		Stack<Integer> positive = new Stack<>();
		Stack<Integer> negative = new Stack<>();
		
		while(!nums.empty()) {
			if(nums.peek() < 0) { negative.push(nums.pop()); }
				else positive.push(nums.pop());
		}
		
		while(!positive.empty()) {
			negative.push(positive.pop());
		}
		
		return negative;
		
	}
	
	public static Stack<Integer> shiftByN(Stack<Integer> nums, int n){
		//create reverse stack, emptying nums in the process
		Stack<Integer> reverse = new Stack<>();
		
		reverse = reverseStack(nums);
		//remove the first n values and store them in a temporary "end" stack
		Stack<Integer> end = new Stack<>();
		for(int i=0; i<n; i++) {
			end.push(reverse.pop());
		}
		//refill nums with the remaining values from the reversed stack
		nums = reverseStack(reverse);
		
		//reverse end stack and add it to nums
		end  = reverseStack(end);
		while(!end.empty()) {
			nums.push(end.pop());
		}
		
		return nums;
		
	}
	
	public static String reverseVowels(String str){
		Stack<Character> consonants = new Stack<>();
		Stack<Character> vowels = new Stack<>();
		
		for(int i=0; i < str.length(); i++) {
			char current = str.charAt(i);
			if( current == 'a'|| current == 'e' || current == 'i' || current ==  'o' || current == 'u') {vowels.push(current);}
			else consonants.push(current);
		}
		
		while(!vowels.empty()) {
			
		}
		//TODO left off here
		
		return "-1"; //TODO
	}
	
	private static Stack<Integer> reverseStack(Stack<Integer> nums){
		Stack<Integer> reverse = new Stack<>();
		while(!nums.empty()) {
			reverse.push(nums.pop());
		}
		 
		return reverse;
	}
	
	static public boolean allUnique(String s) {
		ArrayList<Character> happened = new ArrayList();
		for(int i=0; i < s.length(); i++) {
			if(happened.contains(s.charAt(i))) return false;
			else happened.add(s.charAt(i));
		}
		
		return true;
	}
	
}
