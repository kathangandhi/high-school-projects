import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class
 * methods.  Uncomment the methods and the code
 * in the main to test.
 */
public class PictureTester
{
    /** Main method for testing*/
    public static void main(String[] args)
    {
        Picture pic = new Picture("waterlilies.jpg");
        pic.explore();
        pic.simpleBlur().explore();
        
        //8
        //createCollage(); //LEAVE COMMENTED FOR NOW
        
        //9
        //testChromakey(); //LEAVE COMMENTED FOR NOW
        
        //10
        //testSteganography(); //LEAVE COMMENTED FOR NOW
    }

    /** Method to create a collage of several pictures */
    public static void createCollage()
    {
        Picture pic = new Picture(800, 800); //blank picture, 800 x 800 pixels

        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");

        pic.copy(flower1,0,0);
        pic.copy(flower2,100,0);
        pic.copy(flower1,200,0);

        Picture flowerNoBlue = new Picture(flower2);

        flowerNoBlue.zeroBlue();
        pic.copy(flowerNoBlue,300,0);
        pic.copy(flower1,400,0);
        pic.copy(flower2,500,0);
        pic.mirrorVertical();

        pic.explore();
    }

    public static void testChromakey()
    {
        Picture one = new Picture("blue-mark.jpg");
        Picture two = new Picture("moon-surface.jpg");

        one.chromakey(two, new Color(10, 40, 75), 60);

        one.explore();
    }

    public static void testSteganography()
    {
        Picture msg   = new Picture("msg.jpg");
        Picture beach = new Picture("beach.jpg");

        beach.encode(msg); //hide the message in the beach picture
        beach.explore(); //beach w/ hidden message inside, shouldn't look different

        beach.decode().explore(); //see the hidden message in the beach picture
        
    }
}
