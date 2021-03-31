import java.util.Random;

public class Die
{
    private int numFaces;
    
    public Die()
    {
        numFaces=6;
    }

    
    public Die(int faces)
    {
        // put your code here
        numFaces=faces;
    }
    
    public int roll()
    {
        Random rand = new Random();
        int result = rand.nextInt(numFaces) + 1;
        return result;
    }
}
