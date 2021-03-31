import java.util.*;
public class StationarySprite extends Sprite{
    public StationarySprite(double left,double top,int width,int height,String image){
        super(left,top,width,height,image);
    }
    
    public void step(World world){
        return;
    }
}
