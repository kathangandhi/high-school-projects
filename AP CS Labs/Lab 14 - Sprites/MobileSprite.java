import java.util.*;
public class MobileSprite extends Sprite{
    private double vx;
    private double vy;
    
    public MobileSprite(double left,double top,int width,int height,String image,double vx,double vy){
        super(left,top,width,height,image);
        this.vx = vx;
        this.vy = vy;
    }
    
    public void setVX(double newVX){
        this.vx = newVX;
    }
    
    public void setVY(double newVY){
        this.vy = newVY;
    }
    
    public double getVX(){
        return vx;
    }
    
    public double getVY(){
        return vy;
    }
    
    public void step(World world){
        if(getLeft() < 0) //bounce off left edge   
            vx = Math.abs(vx);   
        if (getLeft() + getWidth() >= world.getWidth()) //bounce off right edge   
            vx = -Math.abs(vx);   
        if (getTop() < 0) //bounce off top edge   
            vy = Math.abs(vy);   
        if (getTop() + getHeight() >= world.getHeight()) //bounce off bottom edge   
            vy = -Math.abs(vy);
            
        setLeft(getLeft()+vx);
        setTop(getTop()+vy);
    }
}
