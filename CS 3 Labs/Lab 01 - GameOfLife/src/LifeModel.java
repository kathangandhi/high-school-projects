import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	private String fileName;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{     
		this.fileName = fileName;
		
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{
		
		for(int r=0; r<grid.length; r++) {
			for(int c=0; c < grid[0].length; c++) {
				int neighbors = getNeighborNumber(r,c);
				if(neighbors <= 1 || neighbors >= 4) {grid[r][c].setAliveNext(false);}
				else if(neighbors == 2 && grid[r][c].isAliveNow())grid[r][c].setAliveNext(true);
				else if(neighbors == 3) grid[r][c].setAliveNext(true); 
				
			}
		}
		
		for(int r=0; r<grid.length; r++) {
			for(int c=0; c<grid[0].length; c++) {
				if(grid[r][c].isAliveNext()) grid[r][c].setAliveNow(true);
				else grid[r][c].setAliveNow(false);
			}
		}
	}
	
	//added method
	private int getNeighborNumber(int row, int col) { //TODO test this method
		int neighbors = 0;
		
		for(int r=row-1; r<=row+1; r++) {
			for(int c=col-1; c<=col+1; c++) {
				if(row == r && col == c) continue;
				if(r<0 || r>=grid.length || c<0|| c>=grid[0].length) continue;
				else if(grid[r][c].isAliveNow()) neighbors++;
			}
		}
		
		
		return neighbors;
	}
	
	public void reset() throws IOException{ 
		int r, c;
		
		for(r=0; r < SIZE; r++ ) {
			for(c = 0; c < SIZE; c++) {
				grid[r][c].setAliveNow(false);
				grid[r][c].setAliveNext(false);
			}
		}
		
		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}
	}
	
	public LifeCell[][] getGrid(){
		return this.grid;
	}
	
}

