// Lab05Ast.java
// Arithmetic with PEMDAS
// This is the student, starting version, of Lab 05A.


public class Lab05Ast
{
	public static void main(String args[])
	{
		double r = 10.0;
		double x = 5.0;
		double y = 77.77;
		double z = 1.21;
		final double PI = 3.14159;

		System.out.println("Lab 05A, 100 Point Version");
      	System.out.println();
      	System.out.println("Arithmetic with PEMDAS");
      	System.out.println();
        System.out.println("By: Kathan Gandhi");
        System.out.println("\n===========================\n");

		double a1 = 2 * (x + 1);
		System.out.println("a1 = " + a1);
		double a2 = 2*x + 2*1;
		System.out.println("a2 = " + a2);
		System.out.println();
		double b1 = 3*(r+x);
		System.out.println("b1 = " + b1);
		double b2 = 3*r +x;
		System.out.println("b2 = " + b2);
		double c1 = r*(x+y);
		System.out.println("c1 = " + c1);
		double c2 = (r*x+r*y);  
		System.out.println("c2 = " + c2);
		double d1 = 5*(y-7.77);
		System.out.println("d1 = " + d1);
		double d2 = 5*y - 5*(7.77);
		System.out.println("d2 = " + d2);
		double e1 = z*(y-r);
		System.out.println("e1 = " + e1);
		double e2 = z*y-z*r;
		System.out.println("e2 = " + e2);
		double f1 =r*(x+y+z);
		System.out.println("f1 = " + f1);
		double f2 =r*(x+y+z);
		System.out.println("f2 = " + f2);
		double g1 =r+x*y+z;
		System.out.println("g1 = " + g1);
		double g2 =(r+x)*(y+z);
		System.out.println("g2 = " + g2);
		double h1 =r-x*y-z;
		System.out.println("h1 = " + h1);
		double h2 =(r-x)*(y-z);
		System.out.println("h2 = " + h2);
		double j1 =r*x/y*z;
		System.out.println("j1 = " + j1);
		double j2 =r*x/y*z;
		System.out.println("j2 = " + j2);
		double k1 =r-x/y-z;
		System.out.println("k1 = " + k1);
		double k2 =(r-x)/(y-z);
		System.out.println("k2 = " + k2);
		double m1 =1.0/2.0;
		System.out.println("m1 = " + m1);
		double m2 =3.0/7.0;
		System.out.println("m2 = " + m2);
		double n1 =2*(r+x)/5;
		System.out.println("n1 = " + n1);
		double n2 =2*r+x/5;
		System.out.println("n2 = " + n2);
		double p1 =2*PI*r;
		System.out.println("p1 = " + p1);
		double p2 =PI*r*r;
		System.out.println("p2 = " + p2);
		
		
		









		System.out.println();
	}
}
