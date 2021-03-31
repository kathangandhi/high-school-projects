/**
 * Simple driver class to test data
 */
public class Runner{
    
    /**
     * the main method of the driver class
     */
    public static void main(String args[]){
        //1
        Polynomial a = new Polynomial();
        a.setTerm(1.0,2); a.setTerm(2.0,1); a.setTerm(3.0,0);
        
        System.out.println(a.evaluate(4.5));
        System.out.println(a.toString());
        
        //2
        Polynomial b = new Polynomial();
        b.setTerm(4.32,2);b.setTerm(-2.12,1);b.setTerm(3.67,0);
        System.out.println(b.evaluate(2));
        
        //3
        System.out.println();
        Polynomial medicine = new Polynomial();
        medicine.setTerm(-0.05,2);medicine.setTerm(2.0,1);medicine.setTerm(2.0,0);
        System.out.println("Start "+medicine.evaluate(0));
        System.out.println("1 hr "+medicine.evaluate(1));
        System.out.println("2 hrs "+medicine.evaluate(2));
        System.out.println("3 hrs "+medicine.evaluate(3));
        System.out.println("4 hrs "+medicine.evaluate(4));
        System.out.println("5 hrs "+medicine.evaluate(5));
        System.out.println("6 hrs "+medicine.evaluate(6));
        System.out.println("7 hrs "+medicine.evaluate(7));
        System.out.println("8 hrs "+medicine.evaluate(8));
        
        //4
        Polynomial projectile = new Polynomial();
        projectile.setTerm(-4.905,2);projectile.setTerm(50.0,1);projectile.setTerm(3.0,0);
        System.out.println(projectile.evaluate(3));
    }
}
