import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() +
            " height " + getHeight()
            + " width " + getWidth();
        return output;

    }

    /**sets the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array

                pixels[r][c].setBlue(0);
            }
        }
    }

    /**keeps the blue only */
    public void keepOnlyBlue(){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array

                pixels[r][c].setRed(0);
                pixels[r][c].setGreen(0);
            }
        }
    }

    /**inverts colors */
    public void negate(){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array

                pixels[r][c].setRed(255-pixels[r][c].getRed());
                pixels[r][c].setGreen(255-pixels[r][c].getGreen());
                pixels[r][c].setBlue(255-pixels[r][c].getBlue());
            }
        }
    }

    /** 
     * inverts colors if intensity of any color is less than the threshold
     * @param threshold the setpoint to decide inversion of colors
     */
    public void solarize(int threshold){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array
                int red = pixels[r][c].getRed();
                int green = pixels[r][c].getGreen();
                int blue = pixels[r][c].getBlue();

                if(red < threshold||green < threshold||blue < threshold){
                    pixels[r][c].setRed(255-pixels[r][c].getRed());
                    pixels[r][c].setGreen(255-pixels[r][c].getGreen());
                    pixels[r][c].setBlue(255-pixels[r][c].getBlue());
                }
            }
        }
    }

    /** makes it monochromatic */
    public void grayscale(){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array

                int avg = (int)pixels[r][c].getAverage();
                pixels[r][c].setRed(avg);
                pixels[r][c].setGreen(avg);
                pixels[r][c].setBlue(avg);
            }
        }
    }

    /**
     * intensifies current RGB values based on provided coefficients
     * @param redCoeff the coefficient for the red 
     * @param greenCoeff the coefficient for the green
     * @param blueCoeff the coefficient for the blue
     */
    public void tint(double redCoeff, double greenCoeff, double blueCoeff){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array
                int newRed = (int)(pixels[r][c].getRed()*redCoeff);
                int newGreen = (int)(pixels[r][c].getGreen()*greenCoeff);
                int newBlue = (int)(pixels[r][c].getBlue()*blueCoeff);

                //if the new values are valid(< 255)
                if(newRed < 255)
                    pixels[r][c].setRed(newRed);
                else
                    pixels[r][c].setRed(255);

                if(newGreen < 255)
                    pixels[r][c].setGreen(newGreen);
                else
                    pixels[r][c].setGreen(255);

                if(newBlue < 255)
                    pixels[r][c].setBlue(newBlue);
                else
                    pixels[r][c].setBlue(255);
            }
        }
    }

    /** finds fish in pools */
    public void showFish(){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array

                if(pixels[r][c].getBlue()<190&&pixels[r][c].getBlue()>160&&pixels[r][c].getRed()<25&&pixels[r][c].getRed()>15){
                    pixels[r][c].setRed(0);
                    pixels[r][c].setBlue(0);
                    pixels[r][c].setGreen(0);
                }
                else{
                    pixels[r][c].setRed(255);
                }
            }
        }
    }

    /** 
     * mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right 
     */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** 
     * mirrors the picture around a
     * vertical mirror in the center of the picture
     * from left to right 
     */
    public void mirrorVertical(int rowLimit)
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int row = 0; row < rowLimit; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** 
     * mirrors the picture around a
     * vertical mirror in the center of the picture
     * from right to left 
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = width-1; col > width/2; col--)
            {
                rightPixel = pixels[row][col];
                leftPixel = pixels[row][width - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** 
     * mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from up to down 
     */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel upPixel = null;
        Pixel downPixel = null;

        int length = pixels.length;

        for (int row = 0; row < length/2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                upPixel = pixels[row][col];
                downPixel = pixels[(length - 1) - row][col];
                downPixel.setColor(upPixel.getColor());
            }
        }
    }

    /** 
     * mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from up to down 
     */
    public void verticalFlip()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel upPixel = null;
        Pixel downPixel = null;

        int length = pixels.length;

        for(int row = 0; row < length/2; row++)
        {
            for(int col = 0; col < pixels[row].length; col++)
            {
                upPixel = pixels[row][col];
                downPixel = pixels[(length - 1) - row][col];
                
                //swap upPixel and downPixel
                Color temp = downPixel.getColor();
                downPixel.setColor(upPixel.getColor());
                upPixel.setColor(temp);
            }
        }
    }

    /** 
     * mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from up to down 
     */
    public void mirrorHorizontalBottomToTop()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel upPixel = null;
        Pixel downPixel = null;

        int length = pixels.length;

        for (int row = length-1; row > length/2; row--)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                downPixel = pixels[row][col];
                upPixel = pixels[(length-1) - row][col];
                upPixel.setColor(downPixel.getColor());
            }
        }
    }

    /** mirrors the arms of the snowman */
    public void mirrorArms()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel upPixel = null;
        Pixel downPixel = null;

        for (int row = 155; row < 195; row++)
        {
            for (int col = 100; col < 170; col++)
            {
                upPixel = pixels[row][col];
                downPixel = pixels[195+(195-row)][col];
                downPixel.setColor(upPixel.getColor());
            }
        }

        for (int row = 155; row < 195; row++)
        {
            for (int col = 240; col < 295; col++)
            {
                upPixel = pixels[row][col];
                downPixel = pixels[195+(195-row)][col];
                downPixel.setColor(upPixel.getColor());
            }
        }
    }

    /** mirrors the gull */
    public void mirrorGull()
    {
        Pixel[][] pixels = this.getPixels2D();

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        for (int row = 230; row < 325; row++)
        {
            for (int col = 235; col < 345; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][(125+col)];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** 
     * detects edges in the 
     * image based on what color difference 
     * is considered an edge(provided by user)
     */
    public void edgeDetection(int param)
    {
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        Pixel left = null;
        Pixel right = null;
        Pixel up = null;
        Pixel down = null;

        for(int r = 0; r < pixels.length; r++){
            for(int c = 1; c < pixels[r].length; c++){
                left = pixels[r][c-1];
                right = pixels[r][c];
                if(right.colorDistance(left.getColor())>=param){
                    left.setRed(0); left.setGreen(0); left.setBlue(0);
                }
                else{
                    left.setRed(255); left.setGreen(255); left.setBlue(255);
                }
            }
        }

        for(int r = 1; r < pixels.length; r++){
            for(int c = 1; c < pixels[r].length; c++){
                up = pixels[r-1][c];
                down = pixels[r][c];
                if(up.colorDistance(down.getColor())>=param){
                    up.setRed(0); up.setGreen(0); up.setBlue(0);
                }
                else{
                    up.setRed(255); up.setGreen(255); up.setBlue(255);
                }
            }
        }
    }

    /** 
     * copy from the passed from to the specified rowStart and colStart 
     * in the current picture
     * @param from the picture to copy from
     * @param rowStart the start row to copy to
     * @param colStart the start col to copy to
     */
    public void copy(Picture from, int rowStart, int colStart)
    {
        Pixel[][] thisPixels = this.getPixels2D(); //gets the pixel grid for this picture
        Pixel[][] fromPixels = from.getPixels2D();

        for(int r = 0; r < fromPixels.length; r++){
            for(int c = 0; c < fromPixels[r].length; c++){
                thisPixels[rowStart+r][colStart+c].setColor(fromPixels[r][c].getColor());
            }
        }
    }

    /** make it poster-like with high contrast pixel colors */
    public void posterize(int span){
        Pixel[][] pixels = this.getPixels2D(); //gets the pixel grid for this picture

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                //pixels[r][c] is the pixel object (reference), located at [r, c] in the pixels 2D array
                int newRed = pixels[r][c].getRed()/span*span;
                int newGreen = pixels[r][c].getGreen()/span*span;
                int newBlue = pixels[r][c].getBlue()/span*span;

                pixels[r][c].setRed(newRed);
                pixels[r][c].setGreen(newGreen);
                pixels[r][c].setBlue(newBlue);
            }
        }
    }

    /** selectively swap pixels with close color values between two Pictures w*/
    public void chromakey(Picture from, Color ref, int dist){
        Pixel[][] thisPixels = this.getPixels2D(); //gets the pixel grid for this picture
        Pixel[][] fromPixels = from.getPixels2D();

        for(int r = 0; r < fromPixels.length; r++){
            for(int c = 0; c < fromPixels[r].length; c++){
                if(thisPixels[r][c].colorDistance(ref)<=dist){
                    thisPixels[r][c].setColor(fromPixels[r][c].getColor());
                }
            }
        }
    }

    /**
     * encodes a steganographic picture
     */
    public void encode(Picture msg){
        Pixel[][] thisPixels = this.getPixels2D();
        Pixel[][] fromPixels = msg.getPixels2D();

        for(int r = 0; r < thisPixels.length; r++){
            for(int c = 0; c < fromPixels[r].length; c++){
                if(thisPixels[r][c].getRed()%2==1)
                    thisPixels[r][c].setRed(thisPixels[r][c].getRed()-1);
            }
        }

        for(int r = 0; r < thisPixels.length; r++){
            for(int c = 0; c < thisPixels[r].length; c++){
                if(fromPixels[r][c].colorDistance(Color.BLACK)<50){
                    if(thisPixels[r][c].getRed()%2==0)
                        thisPixels[r][c].setRed(thisPixels[r][c].getRed()+1);
                }
            }
        }
    }

    /**
     * decodes a steganographic picture
     */
    public Picture decode(){
        Picture now = new Picture(this.getHeight(), this.getWidth());
        Pixel[][] thisPixels = this.getPixels2D();
        Pixel[][] nowPixels = now.getPixels2D();

        for(int r = 0; r < thisPixels.length; r++){
            for(int c = 0; c < thisPixels[r].length; c++){
                if(thisPixels[r][c].getRed()%2==1)
                    nowPixels[r][c].setColor(Color.BLACK);
            }
        }

        return now;
    }
    
    /**
     * Blurs the image by averaging the neighboring pixels' value 
     * to determine the pixel's color value
     */
    public Picture simpleBlur(){
        Picture now = new Picture(this.getHeight(), this.getWidth());
        Pixel[][] thisPixels = this.getPixels2D();
        Pixel[][] nowPixels = now.getPixels2D();

        for(int r = 1; r < thisPixels.length-1; r++){
            for(int c = 1; c < thisPixels[r].length-1; c++){
                //storing neighboring pixels
                Pixel left = thisPixels[r][c-1];
                Pixel up = thisPixels[r-1][c];
                Pixel right = thisPixels[r][c+1];
                Pixel down = thisPixels[r+1][c];
                
                //calculate value of the color based on surrounding pixel colors
                int red = (left.getRed()+up.getRed()+right.getRed()+down.getRed())/4;
                int blue = (left.getBlue()+up.getBlue()+right.getBlue()+down.getBlue())/4;
                int green = (left.getGreen()+up.getGreen()+right.getGreen()+down.getGreen())/4;
                
                //change color values
                nowPixels[r][c].setRed(red); 
                nowPixels[r][c].setBlue(blue); 
                nowPixels[r][c].setGreen(green);  
            }
        }

        return now;
    }
}// this is the end of class Picture, put all new methods before this
