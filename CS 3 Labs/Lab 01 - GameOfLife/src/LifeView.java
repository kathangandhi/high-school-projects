import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/** The view (graphical) component */
public class LifeView extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static int SIZE = 60;
	private Color cellColor; //keeps track of the original cell color
	private boolean randomizeColor;

	/** store a reference to the current state of the grid */
    private LifeCell[][] grid;

    public LifeView()
    {
    	this(Color.BLUE);
    }
    
    public LifeView(Color cellColor) {
    	grid = new LifeCell[SIZE][SIZE];
    	this.cellColor = cellColor;
    	this.randomizeColor = false;
    }

    /** entry point from the model, requests grid be redisplayed */
    public void updateView( LifeCell[][] mg )
    {
        grid = mg;
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int testWidth = getWidth() / (SIZE+1);
        int testHeight = getHeight() / (SIZE+1);
        // keep each life cell square
        int boxSize = Math.min(testHeight, testWidth);

        for ( int r = 0; r < SIZE; r++ )
        {
            for (int c = 0; c < SIZE; c++ )
            {
                if (grid[r][c] != null)
                {
                    if ( grid[r][c].isAliveNow() )
                        g.setColor( getCellColor() );
                    else
                        g.setColor( new Color(235,235,255) );

                    g.fillRect( (c+1)*boxSize, (r+1)* boxSize, boxSize-2, boxSize-2);
                }
            }
        }
    }
    
    public Color getCellColor() { 
    	//in this method will be the logic for checking if randomizeColor is activated
    	//if it is then return a random color
    	//if it's not then return this.cellColor
    	if(randomizeColor) {
    		//Math.random() * (max - min) + min
    		int r = (int)( Math.random() * (256));
    		System.out.println("r: " + r);
    		int g = (int) (Math.random() * (256)); 
    		int b = (int) (Math.random() * (256)); 
    		return new Color(r,g,b);
    	}
    	else return this.cellColor;
    }
    
    public void setRandomizeColor(boolean randomizeColor) {
    	this.randomizeColor = randomizeColor;
    }
    
    public boolean getRandomizeColor() {
    	return this.randomizeColor;
    }
}
