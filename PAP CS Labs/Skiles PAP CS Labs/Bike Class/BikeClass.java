

public class BikeClass
{
  public static void main(String args[])
  {
   Bicycle bike = new Bicycle("blue");// make a new Bicycle object
   bike.setSpeed(10);
   System.out.println("Color: "+bike.color);
   System.out.println("Speed: "+bike.speed);
   System.out.println("Miles traveled: " +bike.travel((double)3/60));//3 minutes
   System.out.println("Location: "+bike.location);
   bike.increaseSpeed(5);
   System.out.println("Speed: "+bike.speed);
   System.out.println("Miles traveled: "+bike.travel((double)3/60));//3 minutes
   System.out.println("Location: "+bike.location);
   
  }
}
