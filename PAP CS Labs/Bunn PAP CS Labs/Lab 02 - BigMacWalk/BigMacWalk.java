

public class BigMacWalk
{ 
    public static void main(String args[])
    {
        //Problem 1
        int apples = 12;//variable apples is an integer with value 12//
        System.out.println();
        //Problem 2
        int oranges = 24;//variable oranges is an integer with value 24//
        System.out.println();
        //Problem 3
        System.out.println("You have this many apples>>> "+apples);//Print statement for apples
        System.out.println();
        //Problem 4
        System.out.println("You have this many oranges>>> "+oranges);//Print statement for oranges
        System.out.println();
        //Problem 5
        double pi=3.14519;
        System.out.println();
        //Problem 6
        System.out.println("Pi is equal to>>> "+pi);
        System.out.println();
        //Problem 7
        System.out.println("3 = Sides on a Triangle");
        System.out.println();
        //Problem 8
        String day = "Tuesday";
        System.out.println();
        //Problem 9
        System.out.println("Hello, today is>>> "+day);
        System.out.println();
        //Problem 10
        int a = 10;
        int b = 20;
        int difference = b - a;
        System.out.println();
        //Problem 11
        System.out.println("b minus a>>> "+difference);
        System.out.println();
        //Problem 12
        int miles = 192;
        int gallons = 16;
        int mpg = 0;
        System.out.println();
        //Problem 13
        mpg = mpg + miles/gallons;
        System.out.println("The mpg is>>> "+mpg);
        System.out.println();
        //Problem 14
        double length = 12.75;
        double width = 8.65;
        double area1 = length*width;
        System.out.println("The area is>>> "+area1);
        System.out.println();
        //Problem 15
        System.out.println("6 = Pockets on a Pool Table");
        System.out.println();
        //Problem 16
        double base = 11.89;
        double height = 22.4;
        double area2 = base*height/2;
        System.out.println("The area is>>> "+area2);
        System.out.println();
        //Big Mac Walk App
        double numBigMacs = 10;
        double BigMac = 590;
        double calories = 94;
        double totalcaloriesforBigMac  = numBigMacs*BigMac;
        double mile1 = totalcaloriesforBigMac/calories;
        System.out.println("Number of Big Macs eaten>>> "+numBigMacs);
        System.out.println("Total calories>>> "+totalcaloriesforBigMac);
        System.out.println("Miles to walk to burn off all Big Macs>>> "+mile1);
        System.out.println();
        double fries = 10;
        double soda = 5;
        double caloriesfries = 340;
        double caloriessoda = 150;
        double totalcaloriesforfries = fries*caloriesfries;
        double totalcaloriesforsoda = soda*caloriessoda;
        double mile2 = totalcaloriesforfries/calories;
        double mile3 = totalcaloriesforsoda/calories;
        System.out.println("Number of fries eaten>>> "+fries);
        System.out.println("Total calories>>> "+totalcaloriesforfries);
        System.out.println("Miles to walk to burn off all fries>>> "+mile2);
        System.out.println();
        System.out.println("Number of sodas drunk>>> "+soda);
        System.out.println("Total calories>>> "+totalcaloriesforsoda);
        System.out.println("Miles to walk to burn off all fries>>> "+mile3);
        System.out.println();
        double grandtotalcalories = totalcaloriesforsoda + totalcaloriesforfries + totalcaloriesforBigMac;
        double miletotal = grandtotalcalories/94;
        System.out.println("The total miles to walk>>> "+miletotal);
        
        
        

        
        
        
        
        
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
