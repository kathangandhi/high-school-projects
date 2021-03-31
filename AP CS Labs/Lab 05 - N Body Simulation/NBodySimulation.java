import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NBodySimulation{
    private Body[] bodies;    //stores all the bodies in the simulation
    private int    numBodies; //number of bodies in this simulation
    private double uRadius;   //radius of the universe
    private String fileName;  //file providing the input
    
    /**
     * The NBodySimulation constructor that parse the file provided for data
     * @param file the String for the file name
     */
    public NBodySimulation(String file) throws IOException
    {
        fileName = file;
        
        File f = new File(fileName);
        Scanner input = new Scanner(f);
        numBodies = input.nextInt();
        uRadius = input.nextDouble();
        bodies = new Body[numBodies];
        
        for(int i = 0; i < bodies.length; i++){
            bodies[i] = new Body(input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.next());
        }
        initCanvas(); //don't move, should be the last line of the constructor
    }
    
    /** initialize the drawing canvas */
    private void initCanvas()
    {
        StdDraw.setScale(-uRadius, uRadius); //set canvas size / scale
        StdDraw.picture(0, 0, "starfield.jpg"); //paint background
        
        for (Body body : bodies)
            body.draw();
    }
    
    /** 
     * run the n-bodies simulation
     * @param T total time to run the simulation, in seconds
     * @param dt time step, in seconds
     */
    public void run(double T, double dt)
    {
        for(int t = 0; t < T; t += dt){
            StdDraw.picture(0, 0, "starfield.jpg");
            for(int bodyNum = 0; bodyNum < bodies.length; bodyNum++){
                bodies[bodyNum].setNetForce(bodies);
                bodies[bodyNum].update(dt);
                
            }
            for(int bodyNum = 0; bodyNum < bodies.length; bodyNum++){
                bodies[bodyNum].draw();
            }
            StdDraw.show(10); //don't worry about the compiler warning
        }
    }
}