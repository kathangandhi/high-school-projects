import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze {

	Square[][] grid;
	Square startSquare;
	Square exitSquare;
	
	public Maze() {
	}
	
	//TODO test this method
	public boolean loadMaze(String filename) {
		Scanner sc;
		
		
		//returns false if file is not found
		try {
			File file = new File(filename); 
			sc = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: File Not Found");
			System.out.println(e.getStackTrace());
			return false;
		}
		
		//else initializes the grid with the file
		grid = new Square[sc.nextInt()][sc.nextInt()];
		
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				int type = sc.nextInt();
				grid[r][c] = new Square(r, c, type);
				if(type == Square.START) this.startSquare = grid[r][c];
				else if(type == Square.EXIT) this.exitSquare = grid[r][c];
			}
		}
		
		sc.close();
		
		return true;
	}
	
	public List<Square> getNeighbors(Square s){ //TODO test this method
		//returns neighbors North, East, South, and West (int that specific order)
		//only added to list if neighbors exist and are not out of bounds
		//returns all neighbor squares, no matter the type
		List<Square> neighbors = new ArrayList<>();
		
		int row = s.getRow();
		int col = s.getCol();
		
		//makes sure Square s is within the grid
		if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) throw new ArrayIndexOutOfBoundsException();
		
		try { //this try catch will test the method
		if(row > 0) neighbors.add(grid[row - 1][col]);
		
		if(col < grid[row].length -1) neighbors.add(grid[row][col+1]);
		
		if(row < grid.length-1) neighbors.add(grid[row + 1][col]);
		
		if(col > 0 ) neighbors.add(grid[row][col - 1]);
		
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("something wrong with getNeighbors method");
		}
		
		return neighbors;
	}
	
	/**
	 * resets the status variable of all the squares in the maze
	 */
	public void reset() {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				grid[r][c].reset();
			}
		}
	}
	
	public Square getStart() {
		try {
			this.startSquare.equals(this.exitSquare);
		}
		catch(NullPointerException e) {
			System.out.println("Error: Maze File not loaded");
			e.printStackTrace();
		}
		
			return this.startSquare;
	}
	
	public Square getExit(){
		try {
			this.startSquare.equals(this.exitSquare);
		}
		catch(NullPointerException e) {
			System.out.println("Error: Maze File not loaded");
			e.printStackTrace();
		}
		return this.exitSquare;
	}
	
	@Override
	public String toString() {
		String s = "";
		try {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[r].length; c++) {
				s += grid[r][c].toString() + " ";
			}
			s += "\n"; 
		}
		}
		catch(NullPointerException e) {
			System.out.println("Error: Maze File not loaded");
			e.printStackTrace();
		}
		
		return s;
	}
}
