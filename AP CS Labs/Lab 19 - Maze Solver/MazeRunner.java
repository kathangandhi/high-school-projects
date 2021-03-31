import java.io.IOException;

public class MazeRunner
{
	public static void main(String args[]) throws IOException{
		Maze m = new Maze("maze4.txt");
		m.solve();
	}
}