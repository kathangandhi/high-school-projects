/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
	    //System.out.println("board");
		ElevensBoard board = new ElevensBoard();
		//System.out.println(board);
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
