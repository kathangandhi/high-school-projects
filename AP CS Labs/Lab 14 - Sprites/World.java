import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class World
{
    public static void main(String[] args)
    {
        Display display = new Display(500, 500);
        display.run();
    }

    private List<Sprite> sprites;
    private int width;
    private int height;

    /** make a World with a default size 500 x 500 */
    public World()
    {
        this(500, 500);
    }

    public World(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.sprites = new ArrayList<>();

        Random rand = new Random();
        MobileSprite character = new MobileSprite(rand.nextInt(200)+50,rand.nextInt(200)+50,50,50,"circle.png",0,0);
        sprites.add(character);
    }

    public void stepAll()
    {
        for (int i = 0; i < sprites.size(); i++)
        {
            if(sprites.get(i).isAlive()){
                Sprite s = sprites.get(i);
                s.step(this);
            }
            else{
                sprites.remove(i);
            }
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getNumSprites()
    {
        return sprites.size();
    }

    public Sprite getSprite(int index)
    {
        return sprites.get(index);
    }

    public void mouseClicked(int x, int y)
    {
        System.out.println("mouseClicked:  " + x + ", " + y);
    }

    /**
     * the display instructs the World (which contains all the Sprites)
     * which key has been pressed
     */
    public void keyPressed(int key){
        // left 37 up 38 right 39 down 40
        MobileSprite m = (MobileSprite) sprites.get(0);
        switch(key){
            case 40:
            m.setVX(0.0); m.setVY(2.0); break;
            case 39:
            m.setVX(2.0); m.setVY(0.0); break;
            case 38:
            m.setVX(0.0); m.setVY(-2.0); break;
            case 37:
            m.setVX(-2.0); m.setVY(0.0); break;
            default:
            System.out.println("Press direction keys");
        }
    }

    public void keyReleased(int key)
    {
        System.out.println("key released: " + key);
    }

    public String getTitle()
    {
        return "World";
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        for (int i = 0; i < sprites.size(); i++)
        {
            Sprite sprite = sprites.get(i);
            g.drawImage(Display.getImage(sprite.getImage()),
                (int)sprite.getLeft(), (int)sprite.getTop(),
                sprite.getWidth(), sprite.getHeight(), null);
        }
    }
}
