import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class Driver{
    /**
     * The main method of the Driver class that runs the program
     */
    public static void main(String[] args) throws IOException{
        int height = 480, width = 480;

        //construct DrawingPanel, and get its Graphics context
        DrawingPanel panel = new DrawingPanel(height, width);
        Graphics g = panel.getGraphics();

        //Test Step 1 - construct mountain map data
        MapDataDrawer map = new MapDataDrawer("Colorado_480x480.txt", height, width);

        //Test Step 2 - min, max
        int min = map.findMin();
        System.out.println("Min value in map: "+min);

        int max = map.findMax();
        System.out.println("Max value in map: "+max);

        //Test Step 3 - draw the map
        map.drawMap(g);

        //Test Step 4 - draw a greedy path
        g.setColor(Color.RED); //can set the color of the 'brush' before drawing, then method doesn't need to worry about it
        int totalChange = map.drawLowestElevPath(g, 200);
        System.out.println("Lowest-Elevation-Change Path starting at row 200 \ngives total change of: "+totalChange);

        //Test Step 5 - draw the best path
        g.setColor(Color.RED);
        int bestRow = map.indexOfLowestElevPath(g);

        //map.drawMap(g); //use this to get rid of all red lines
        g.setColor(Color.GREEN); //set brush to green for drawing best path
        totalChange = map.drawLowestElevPath(g, bestRow);
        System.out.println("The Lowest-Elevation-Change Path starts at row: "+bestRow+"\nand gives a total change of: "+totalChange  );

    }
}
