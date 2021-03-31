import java.util.*;
public class HeavySprite extends MobileSprite{
    private double gravity;
    
    public HeavySprite(double left,double top,int width,int height,String image,double vx,double vy,double gravity){
        super(left,top,width,height,image,vx,vy);
        this.gravity = gravity;
    }
    
    public void step(World world){
        super.step(world);
        setVY(getVY()+gravity);
    }
}
