/**
 * The Body class governs the principles of a body in the universe based on gravity
 */
public class Body{
    public static final double G = 6.67E-11; //Newtons' gravitational constant

    private double x, y; //planet's x and y coordinate position
    private double xVelocity, yVelocity;
    private double mass;
    private double xNetForce, yNetForce; //net forces action on this planet
    private double xAccel, yAccel; //the acceleration created by gravity in x and y direction

    private String image; //image of this planet (for drawing)

    /**
     * The constructor to initialise all the variables of the Body
     */
    public Body(double xPos, double yPos, double xV, double yV, double m, String img){
        //big list of variables
        x = xPos;
        y = yPos;
        xVelocity = xV;
        yVelocity = yV;
        mass = m;
        image = img;
        xNetForce = 0; 
        yNetForce = 0;
        xAccel = 0; 
        yAccel = 0;
    }

    /** 
     * finds distance between the accessing body and other body
     * @param other the other body object
     * @return distance between 2 bodies
     */
    private double getDistance(Body other){
        return Math.sqrt((x - other.x)*(x - other.x) + (y - other.y) * (y - other.y));
    }

    /** 
     * finds pairwise force between the accessing body and other body
     * @param other the other body object
     * @return the gravity between two bodies
     */
    private double getPairwiseForce(Body other){
        return (G*mass*other.mass)/(getDistance(other)*getDistance(other));
    }

    /** 
     * finds pairwise force x component between the accessing body and other body
     * @param other the other body object
     * @return the gravity in the x direction between two bodies
     */
    private double getPairwiseForceX(Body other){
        return getPairwiseForce(other) * (other.x - x)/getDistance(other);
    }

    /** 
     * finds pairwise force between the accessing body and other body
     * @param other the other body object
     * @return the gravity in the y direction between two bodies
     */
    private double getPairwiseForceY(Body other){
        return getPairwiseForce(other) * (other.y - y )/getDistance(other);
    }

    /** 
     * calculates/sets the net force exerted on this body by all the (input) bodies
     * @param bodies the array of Body objects
     */
    public void setNetForce(Body[] bodies){   
        xNetForce = 0;
        yNetForce = 0;

        for(int i = 0; i < bodies.length; i++){
            if(this==bodies[i])
                continue;
            else{
                xNetForce += getPairwiseForceX(bodies[i]);
                yNetForce += getPairwiseForceY(bodies[i]);
            }
        }
    }

    /** 
     * updates this body's accel, vel, and position, given the time step 
     * @param dt the change in time
     */
    public void update(double dt){
        xAccel = xNetForce/mass;
        yAccel = yNetForce/mass;

        xVelocity += dt*xAccel;
        yVelocity += dt*yAccel;

        x += dt*xVelocity;
        y += dt*yVelocity;
    }

    /** 
     * Draws the body using the StdDraw library file's drawing method 
     */
    public void draw()
    {
        StdDraw.picture(x, y, image);
    }
}