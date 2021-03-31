
public class Square {

	//type constants
	public static final int EMPTY = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int EXIT = 3;
	
	//status constants //STATUS IS ONLY APPLIED TO EMPTY SPACES
	public static final char WORKING = 'o';
	public static final char EXPLORED = '.';
	public static final char ON_EXIT_PATH = 'x';
	public static final char UNKNOWN = '_';
	
	
	private int type;
	private int row, col;
	private char status;

	
	public Square(int row, int col, int type) {
		this.type = type;
		this.row = row;
		this.col = col;
		
		if(type == EMPTY) this.status = UNKNOWN;
	}
	
	//TODO setStatus()
	
	//overridden methods
	@Override
	public String toString() {
		switch (this.type) {
		
		case EMPTY:
			return this.status + "";

		case WALL:
			return "#";
			
		case START:
			return "S";
			
		case EXIT:
			return "E";
			
		default:
			return "?";
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Square other;
		try {
			other = (Square) obj;
		}
		catch(ClassCastException e) {
			return false;
		}
		
		return (other.getRow() == this.row && other.getCol() == this.col);
	}
	
	
	//used by maze to reset itself
	public void reset() { //TODO make sure this method does everything needed
		this.status = UNKNOWN;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	//Getters and setters
	public int getRow() { return this.row;}
	public int getCol() { return this.col;}
	public int getType() { return this.type;}
	public char getStatus() {return this.status;}
}
