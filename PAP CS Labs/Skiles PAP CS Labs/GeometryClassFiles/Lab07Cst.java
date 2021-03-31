// Lab07Cst.java
// The Geometry Class Program
// This is the student, starting version of Lab 07C.
// 4 Geometry class methods are provided as an example.
// You need to write the other 20 on your own.

public class Lab07Cst
{
	public static double side, length, width, height, base1, base2, radius;

	public static void main (String args[])
	{
		System.out.println("\nLab 07C\n\n");
		enterData();
		display2DPerimeters();
		display2DAreas();
		display3DSurfaceAreas();
		display3DVolumes();
	}

	public static void enterData()
	{
		System.out.print("Enter  Side     ===>>  ");
		side = Expo.enterDouble();
		System.out.print("Enter  Length   ===>>  ");
		length = Expo.enterDouble();
		System.out.print("Enter  Width    ===>>  ");
		width = Expo.enterDouble();
		System.out.print("Enter  Height   ===>>  ");
		height = Expo.enterDouble();
		System.out.print("Enter  Base1    ===>>  ");
		base1 = Expo.enterDouble();
		System.out.print("Enter  Base2    ===>>  ");
		base2 = Expo.enterDouble();
		System.out.print("Enter  Radius   ===>>  ");
		radius = Expo.enterDouble();
	}

// Remove comments from the println statements below as you complete each of the methods of the Geometry class.
// Leave comments in place for any methods that you have not finished.

	public static void display2DPerimeters()
	{
		System.out.println("\n\nPerimeters of 2D Shapes");
		System.out.println("=====================================================");
		System.out.println("Square Perimeter:                 " + Geometry.squarePerimeter(side));
		System.out.println("Pentagon Perimeter:               " + Geometry.pentagonPerimeter(side));
		System.out.println("Hexagon Perimeter:                " + Geometry.hexagonPerimeter(side));
     	System.out.println("Octagon Perimeter:                " + Geometry.octagonPerimeter(side));
	    System.out.println("Rectangle Perimeter:              " + Geometry.rectanglePerimeter(length,width));
		System.out.println("Circle Circumference:             " + Geometry.circleCircumference(radius));
		System.out.println("\n");
	}

	public static void display2DAreas()
	{
		System.out.println("Areas of 2D Shapes");
		System.out.println("=====================================================");
     	System.out.println("Square Area:                      " + Geometry.squareArea(side));
		System.out.println("Rectangle Area:                   " + Geometry.rectangleArea(length,width));
		System.out.println("Parallelogram Area:               " + Geometry.parallelogramArea(base1,height));
		System.out.println("Triangle Area:                    " + Geometry.triangleArea(base1,height));
		System.out.println("Trapezoid Area:                   " + Geometry.trapezoidArea(base1,base2,height));
		System.out.println("Hexagon Area:                     " + Geometry.hexagonArea(base1,base2,height));
		System.out.println("Circle Area:                      " + Geometry.circleArea(radius));
		System.out.println("\n");
	}



	public static void display3DSurfaceAreas()
	{
		System.out.println("Surface Areas of 3D Shapes");
		System.out.println("=====================================================");
		System.out.println("Cube Surface Area:                " + Geometry.cubeSurfaceArea(side));
		System.out.println("Square Prism Surface Area:        " + Geometry.squarePrismSurfaceArea(side,height));
		System.out.println("Rectangular Prism Surface Area:   " + Geometry.rectangularPrismSurfaceArea(length,width,height));
		System.out.println("Sphere Surface Area:              " + Geometry.sphereSurfaceArea(radius));
		System.out.println("\n");
	}

	public static void display3DVolumes()
	{
		System.out.println("Volumes of 3D Shapes");
		System.out.println("=====================================================");
	System.out.println("Cube Volume:                      " + Geometry.cubeVolume(side));
		System.out.println("Square Prism Volume:              " + Geometry.squarePrismVolume(side,height));
		System.out.println("Rectangular Prism Volume:         " + Geometry.rectangularPrismVolume(length,width,height));
		System.out.println("Pyramid Volume:                   " + Geometry.pyramidVolume(side,height));
		System.out.println("Cylinder Volume:                  " + Geometry.cylinderVolume(radius,height));
		System.out.println("Cone Volume:                      " + Geometry.coneVolume(radius,height));
		System.out.println("Sphere Volume:                    " + Geometry.sphereVolume(radius));
		System.out.println("\n");
	}
}


class Geometry
{
    // 2D Perimeters
	public static double squarePerimeter (double side)
	{
	    return 4 * side;
	}
    
	public static double rectanglePerimeter (double length, double width)
	{
	    return 2*(length + width);
	}

	public static double circleCircumference (double radius)
	{
	    return Math.PI * 2 * radius;
	}

	public static double hexagonPerimeter (double side)
	{
	   return 6*side;
	}

	public static double pentagonPerimeter (double side)
	{
	   return 5*side;
	}

	public static double octagonPerimeter (double side)
	{
	   return 8*side;
	}
	

	



	// 2D Areas
	public static double rectangleArea (double L, double W)
	{
	    return L * W;
	}

	public static double squareArea (double s)
	{
	    return Math.pow(s,2);
	}
	
	public static double parallelogramArea (double b, double h)
	{
	    return b * h;
	}

	public static double triangleArea (double b, double h)
	{
	    return b * h/2;
	}

	public static double trapezoidArea (double b1, double b2, double h)
	{
	   return (b1+b2)/2*h;
	}

	public static double hexagonArea (double b1, double b2, double h)
	{
	    return (b1+b2)*h;
	}

	public static double circleArea (double r)
	{
	    return Math.PI * Math.pow(r,2);
	}





    // 3D Surface Areas
	public static double cubeSurfaceArea (double s)
	{
	    return 6 * s * s;
	}

	public static double squarePrismSurfaceArea (double s, double h)
	{
	    return 2 * Math.pow(s,2) + 4 * s * h;
	}

	public static double rectangularPrismSurfaceArea (double l, double w, double h)
	{
	    return 2 * l * w + 2 * l * h + 2 * w * h;
	}

	public static double sphereSurfaceArea (double r)
	{
	    return 4 * Math.PI * r * r;
	}


	// 3D Volumes
	public static double coneVolume (double r, double h)
	{
	    return Math.PI * r * r * h / 3;
	}

	public static double cubeVolume (double s)
	{
	    return s * s * s;
	}

	public static double squarePrismVolume (double s, double h)
	{
	    return s * s * h;
	}

	public static double rectangularPrismVolume (double l, double b, double h)
	{
	    return l * b * h;
	}

	public static double pyramidVolume (double s, double h)
	{
	    return s * s * h/3;
	}

	public static double cylinderVolume (double r, double h)
	{
	    return Math.PI * r * r * h;
	}

	public static double sphereVolume (double r)
	{
	    return Math.PI * r * r * r * 4/3;
	}

}


