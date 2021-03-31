

public class Bicycle
{
    public String color;
    public double location;
    public double speed;
    
    public Bicycle(String c)
    {
     color=c;
     location=0;
     speed=0;
    }

    public void setSpeed(double newSpeed)
    {
     speed=newSpeed;  
    }
    
    public void increaseSpeed(double deltaSpeed)
    {
     speed+=deltaSpeed;  
    }
    
    public double travel(double hours)
    {
     double miles=hours*speed;
     location+=miles;
     return miles;
    }
}
