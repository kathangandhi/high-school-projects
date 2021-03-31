// JavaLab04st.java
// Arithmetic With Math Class Methods
// This is the student, starting version, of Java Lab 04.


public class JavaLab04st
{
	public static void main(String args[])
	{
		System.out.println("JavaLab04");
		System.out.println();
		double w = 10.0;
		double x = 5.0;
		double y = 77.77;
		double z = 1.21;

		//Square Roots
		double s1 = Math.sqrt(25);
		System.out.println("s1 = " + s1);
		double s2 = Math.sqrt(100);
		System.out.println("s2 = " + s2);
		double s3 = Math.sqrt(3);
		System.out.println("s3 = " + s3);
		double s4 = Math.sqrt(x);
		System.out.println("s4 = " + s4);
		double s5 = Math.sqrt(y);
		System.out.println("s5 = " + s5);
		double s6 = Math.sqrt(x+y);
		System.out.println("s6 = " + s6);
		double s7 = Math.sqrt(x*y);
		System.out.println("s7 = " + s7);
		System.out.println();
		
		//Absolute Value
		double a1 = Math.abs(7);
		System.out.println("a1 = " + a1);
		double a2 = Math.abs(-7);
		System.out.println("a2 = " + a2);
		double a3 = Math.abs(w);
		System.out.println("a3 = " + a3);
		double a4 = Math.abs(-x);
		System.out.println("a4 = " + a4);
		double a5 = Math.abs(z-y);
		System.out.println("a5 = " + a5);
		double a6 = Math.abs(y-z);
		System.out.println("a6 = " + a6);
		System.out.println();
		
		//Powers
		double p1 = Math.pow(7, 2);
		System.out.println("p1 = " + p1);
		double p2 = Math.pow(2, 7);
		System.out.println("p2 = " + p2);
		double p3 = Math.pow(z, 3);
		System.out.println("p3 = " + p3);
		double p4 = Math.pow(3, z);
		System.out.println("p4 = " + p4);
		double p5 = Math.pow(w, x);
		System.out.println("p5 = " + p5);
		double p6 = Math.pow(x, w);
		System.out.println("p6 = " + p6);
		double p7 = Math.pow((-x), 2);
		System.out.println("p7 = " + p7);
		double p8 = Math.pow(w, (-1));
		System.out.println("p8 = " + p8);
		double p9 = Math.pow(w, (-2));
		System.out.println("p9 = " + p9);
		System.out.println();
		
		//Round OFF
		double r1= Math.round(2.0001);
		System.out.println("r1 = " + r1);
		double r2= Math.round(2.4999);
		System.out.println("r2 = " + r2);
		double r3= Math.round(2.5);
		System.out.println("r3 = " + r3);
		double r4= Math.round(2.9999);
		System.out.println("r4 = " + r4);
		System.out.println();
		
		//Complicated
		double c1= Math.pow(1, 2);
		c1 = (Math.PI*c1);
		System.out.println("c1 = " + c1);
		double c2= Math.pow(5, 2);
		c2 = (Math.PI*c2);
		System.out.println("c2 = " + c2);
		double c3= Math.pow(10, 2);
		c3 = (Math.PI*c3);
		System.out.println("c3 = " + c3);
		double c4= Math.pow(50, 2);
		c4 = (Math.PI*c4);
		System.out.println("c4 = " + c4);
		double c5= Math.pow(100, 2);
		c5 = (Math.PI*c5);
		System.out.println("c5 = " + c5);
		double c6= Math.abs(Math.PI);
		c6 = -(c6);
		System.out.println("c6 = " + c6);
		double c7= Math.abs(-65536);
		c7 = Math.sqrt(c7);
		System.out.println("c7 = " + c7);
		double c8= Math.sqrt(65536);
		c8 = Math.sqrt(c8);
		System.out.println("c8 = " + c8);
		double c9= Math.sqrt(65536);
		c9 = Math.sqrt(c9);
		c9 = Math.sqrt(c9);
		System.out.println("c9 = " + c9);
		double c10=Math.sqrt(65536);
		c10 = Math.sqrt(c10);
		c10 = Math.sqrt(c10);
		c10 = Math.sqrt(c10);
		System.out.println("c10 = " + c10);
		
		
		
		
		
		
		
	}
}
