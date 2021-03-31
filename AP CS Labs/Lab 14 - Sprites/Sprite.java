import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public abstract class Sprite
{
    private double left;  //the x-coordinate of the left edge of the sprite
    private double top;   //the y-coordinate of the top edge of the sprite
    private int width; //the width of the object
    private int height; //the height of the object
    private String image; //the image designation
    private boolean alive = true; //alive or dead

    /**Constructor that takes in parameters and intialises instance variables*/
    public Sprite(double left, double top, int width, int height, String image)
    {
        this.left   = left;
        this.top    = top;
        this.width  = width;
        this.height = height;

        this.setImage(image);
    }

    /**Determines if two Sprite object are contacting each other
      *<p> Uses <code>Rectangle</code> class to do so
      */
    public boolean overlap(Sprite other){
        Rectangle r1 = new Rectangle((int)left,(int)top,(int)width,(int)height);
        Rectangle r2 = new Rectangle((int)other.getLeft(),(int)other.getTop(),(int)other.getWidth(),(int)other.getHeight());
        return (r1.intersects(r2));
    }

    /**Abstract method that must be inherited by inheriting Sprite objects*/
    public abstract void step(World world);

    //-----------------Getters-------------------

    public double getLeft()   { return this.left;   }

    public int getWidth()     { return this.width;  }

    public double getTop()    { return this.top;    }

    public int getHeight()    { return this.height; }

    public String getImage()  { return this.image;  }

    public boolean isAlive()  { return alive;       }

    //-----------------Setters-------------------

    public void setLeft(double left) { this.left = left; }

    public void setTop(double top)   { this.top = top; }

    public void setWidth(int width)  { this.width = width; }

    public void setHeight(int height) { this.height = height; }

    public void setImage(String image) { this.image = image; }

}
