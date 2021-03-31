import java.util.List;

public abstract class MazeSolver {

	private Maze maze;
	private boolean solved; //keeps track if an exit path has been found
	private boolean unsolvable; //becomes true if it has been confirmed that no exit path exists
	
	public MazeSolver(Maze maze) {
		this.maze = maze;
		this.makeEmpty();
		this.add(maze.getStart());
	}
	
	/**
	 * makes the worklist empty
	 */
	public abstract void makeEmpty();
	
	/**
	 * 
	 * @return true if the worklist is empty, false otherwise
	 */
	public abstract boolean isEmpty();
	
	/**
	 * adds a square to the worklist
	 * @param s
	 */
	public abstract void add(Square s);
	
	/**
	 * 
	 * @return the next item from the worklist
	 */
	public abstract Square next();
	
	/**
	 * 
	 * @return	 True if: either the exit path has been found, or if it has been determined that no such path exists.
	 *				Returns false otherwise
	 * 
	 */
	public boolean isSolved() { //TODO MAKE SURE THIS WORKS
		if(solved || unsolvable) return true;
		return false;
	}
	
	public void step() { //TODO MAKE SURE YOU GOT THE LOGIC RIGHT
		if(this.isEmpty()) {this.unsolvable = true; return;} //if the worklist is empty and the exit has not been reached, that means no exit path exists
		
		Square working = this.next(); //grab the next square from the worklist
		working.setStatus(Square.WORKING); 
		
		if(working.equals(this.maze.getExit())) {this.solved = true; return;} //if the working square is the exit, then the maze has been solved
		
		//otherwise it is working is a reachable (non-exit) location
		List<Square> neighbors = maze.getNeighbors(working); 
		for(Square s: neighbors) { //add all the neighbors into the worklist
			if(s.getStatus() != Square.EXPLORED) this.add(s); //adds neighbor to worklist if it hasn't been explored yet
		}
		
		working.setStatus(Square.EXPLORED); //set the current square to explored, so as to not to check it again
		
	}
	
	/** 
	 * 
	 * @return whether is not yet solved, solved, or unsolvable
	 */
	public String getPath() {
		if(this.unsolvable) return "Maze is unsolvable";
		if(this.solved) return "Maze is solved";
		else return "Maze is not yet Solved";
	}
	
	/**
	 * repeatedly call
	 */
	public void solve() {
		
	}
}
