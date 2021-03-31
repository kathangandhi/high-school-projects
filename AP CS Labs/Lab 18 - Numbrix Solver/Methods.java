import java.util.*;
import java.lang.System;
public class Methods{
    /**
     * Tests all the recursive methods
     */
    public static void main(String args[]){
        //System.out.println(Methods.numEars(1));
        //Methods.countdown(10);
        //System.out.println(Methods.factorial(5));
        //System.out.println(Methods.cheerlead("Let's go",2));
        //System.out.println(Methods.power(4,5));
        //System.out.println(Methods.fibonacci(6));
        //System.out.println(Methods.pattern(7));
        //System.out.println(Methods.countNumA("aaHELLOa"));
        //System.out.println(Methods.printAtoBbyC(10,30,5));
        //System.out.println(Methods.oddDigitCounter(3834));
        //System.out.println(Methods.sumDigits(128));
    }

    /**
     * Counts number of ears on each bunny and assumes each bunny has 2 ears
     * @param bunnies Number of <code>bunnies</code>
     * @return Number of ears counted
     */
    public static int numEars(int bunnies){
        if(bunnies == 1)
            return 2;
        else
            return 2+numEars(bunnies-1);
    }

    /**
     * Prints countdown from <code>num</code> to 0
     * @param num Number to start countdown from
     * @return Countdown text
     */
    public static void countdown(int num){
        if(num == 1)
            System.out.println("blastoff!");
        else{
            System.out.print(num+", ");
            countdown(num-1);
        }
    }

    /**
     * Calculates factorial of <code>num</code>
     * @param num Input to calculate factorial
     * @return The calculated factorial
     */
    public static int factorial(int num){
        if(num == 1)
            return 1;
        else{
            return num*factorial(num-1);
        }
    }

    /**
     * Prints cheer text
     * @param str The cheer to repeat
     * @param i The number of times to repeat
     * @return Cheer text
     */
    public static String cheerlead(String str, int i){
        if(i == 1)
            return str;
        else
            return str+" "+cheerlead(str,i-1);
    }

    /**
     * Calculates a number raised to another, just like Math.pow<p>
     * Only int input accepted
     * @param radix The base
     * @param exponent The exponent
     * @return Calculated value
     */
    public static int power(int radix, int exponent){
        if(exponent == 1)
            return radix;
        else
            return radix*power(radix,exponent-1);
    }

    /**
     * Calculates the <code>n</code>th term of a Fibonacci series<p>
     * f(0) = 0 and f(1) = 1 
     * @param n The term sought
     * @return The <code>n</code>th term
     */
    public static int fibonacci(int n){
        if(n == 1)
            return 0;
        else if(n == 2)
            return 1;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }

    /**
     * Calculates <code>pattern</code>
     * @param num The initial term
     * @return The <code>pattern</code> text
     */
    public static String pattern(int num){
        if(num <= 0)
            return ""+num;
        else
            return num+", "+pattern(num-5);
    }

    /**
     * Counts number of a's in <code>msg</code>
     * @param msg The text to check
     * @return Number of a's found
     */
    public static int countNumA(String msg){
        int length = msg.length();
        if(length == 1){
            if(msg.charAt(0) == 'a')
                return 1;
        }
        else if(msg.charAt(0) == 'a')
            return 1 + countNumA(msg.substring(1,msg.length()));
        else
            return 0 + countNumA(msg.substring(1,msg.length()));
        return 0;
    }

    /**
     * Prints all numbers between <code>a</code> and <code>b</code> 
     * in increments of <code>c</code>
     * @param a Lower bound
     * @param b Upper bound
     * @param c Change in number
     * @return Method text
     */
    public static String printAtoBbyC(int a, int b, int c){
        if(a == b)
            return ""+a;
        else
            return ""+a+" "+printAtoBbyC(a+c,b,c);    
    }

    /**
     * Finds number of odd digits in number 
     * @param num Number to be checked
     * @return Number of odd digits
     */
    public static int oddDigitCounter(int num){
        if(num/10 == 0)
            if(num % 2 == 1)
                return 1;
            else
                return 0;
        else if(num % 2 == 1)
            return 1 + oddDigitCounter(num/10);
        else
            return 0 + oddDigitCounter(num/10);
    }
    
    /**
     * Finds sum of digits of number 
     * @param num Number to be checked
     * @return Sum of digits
     */
    public static int sumDigits(int num){
        if(num/10 == 0)
            return num;
        else
            return (num%10) + sumDigits(num/10);
    }
}
