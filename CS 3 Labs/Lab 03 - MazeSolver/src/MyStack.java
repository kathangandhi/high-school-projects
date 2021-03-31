import java.util.EmptyStackException;

public class MyStack implements StackADT{

	Square[] stack;
	int size;
	
	public MyStack() {
		this(7);
	}
	
	public MyStack(int capacity) {
		stack = new Square[capacity];
		size = 0;
	}
	
	public boolean isEmpty() { //Confirmed
		return (this.size==0);
	}
	
	public Square peek() {
		if(this.isEmpty()) throw new EmptyStackException();
		else return stack[this.size-1];
	}
	
	public Square pop() {
		Square top = this.peek();
		stack[this.size-1] = null;
		this.size--;
		return top;
	}
	
	public void push(Square item) { //Seems to be working
		if(stack.length + 1 == size) this.doubleCapacity();
		stack[size] = item;
		this.size++;
	}
	
	private void doubleCapacity() {
		Square[] hold = new Square[stack.length * 2];
		for(int i = 0; i < this.size; i++) {
			hold[i] = stack[i];
		}
		stack = hold;
	}
	
	@Override
	public String toString() {
		String s = "";
		s = stack[size-1] + "   <-----TOP\n";
		for(int i = this.size - 2; i >= 0; i--) {//reverse //chqnge TODO
			s += (stack[i] + "\n");
		}
		
		s += "¯¯¯¯¯¯¯";
		return s;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * remove all elements from the data structure
	 */
	@Override
	public void clear() {
		this.size = 0;
		this.stack = new Square[7];
	}
	
	//TODO LEFT OFF MAKING SURE MyStack implements StackADT
	
}
