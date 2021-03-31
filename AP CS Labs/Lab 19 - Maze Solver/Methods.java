import java.util.*;

public class Methods{
    public static void main(String args[]){
        Methods m = new Methods();
        //System.out.println(m.isPalindrome("mom"));
        //System.out.println(m.isPrime(7));
        //m.timesTwo(28);
        //System.out.println(m.findGCD(40,48));
        //int[] arr = {0,1,2,3,4,5};
        //System.out.println(m.findArrSum(arr));
        //System.out.println(m.reverseString("bin"));
        //m.printReverse("hello");
        //System.out.println(m.isPowerofN(8,2));
        //System.out.println(m.curlyString("what's (all this) then"));
        //m.printPattern(16);
        //m.printSquares(5);
        System.out.println(m.wordWrap("hello, how are you doing today?",13));
    }

    public boolean isPalindrome(String test){
        if(test.length()==1)
            return true;
        if(test.charAt(0)==test.charAt(test.length()-1)){
            test = test.substring(1,test.length()-1);
            return isPalindrome(test);
        }
        return false;
    }

    public boolean isPrime(int num){
        return this.isPrime(num,2);
    }

    public boolean isPrime(int num, int counter){
        if(counter == num)
            return true;
        if(num%counter != 0)
            return isPrime(num,counter+1);
        return false;
    }

    public void timesTwo(int n){
        if(n == 2||n%2 != 0){
            System.out.print(n);
            return;
        }
        else
            System.out.print("2 * ");
        timesTwo(n/2);
    }

    public int findGCD(int num1, int num2){
        int divisor = (num1 < num2)? num1: num2;
        return this.findGCD(num1,num2,divisor);
    }

    public int findGCD(int num1, int num2, int div){
        if(div == 1)
            return div;
        if(num1 % div == 0 && num2 % div == 0)
            return div;
        else
            return findGCD(num1,num2,div-1);
    }

    public int findArrSum(int[] arr){
        return this.findArrSum(arr,0);
    }

    public int findArrSum(int[] arr, int index){
        if(index == arr.length - 1)
            return arr[index];
        else
            return arr[index]+findArrSum(arr,index+1);
    }

    public String reverseString(String str){
        if(str.length() == 1)
            return str;
        else{
            String lastChar = str.substring(str.length()-1,str.length());
            str = str.substring(0,str.length()-1);
            return lastChar + reverseString(str);
        }
    }

    public void printReverse(String str){
        if(str.length() == 1){
            System.out.println(str);
        }
        else{
            String lastChar = str.substring(str.length()-1,str.length());
            str = str.substring(0,str.length()-1);
            System.out.print(lastChar);
            printReverse(str);
        }
    }

    public boolean isPowerofN(int num, int base){
        return this.isPowerofN(num,base,0);
    }

    public boolean isPowerofN(int num, int base, int count){
        if(Math.pow(base,count) == num)
            return true;
        if(Math.pow(base,count) > num)
            return false;
        if(num == 1)
            return true;
        else
            return isPowerofN(num,base,count+1);
    }

    public String curlyString(String str){
        return this.curlyString(str,0);
    }

    public String curlyString(String str, int index){
        if(str.charAt(index)=='('){
            str = str.substring(index,str.length());
            curlyString(str,index+1);
        }
        if(str.charAt(index)==')'){
            str = str.substring(0,index+1);
            return str;
        }
        return curlyString(str,index+1);
    }

    public void printPattern(int num){
        if(num < 0){
            System.out.print(num);
        }
        else{
            System.out.print(num+" ");
            printPattern(num-5);
            System.out.print(" "+num);
        }
    }

    public void printSquares(int num){
        if(num % 2 == 0)
            printSquares(num-1);
        if(num == 1)
            System.out.print("1");
        else{
            System.out.print(num * num+" ");
            printSquares(num-2);
            System.out.print((num-1)*(num-1)+" ");
        }
    }
    
    public String wordWrap(String line, int width){
        if(line.length() <= width)
            return line;
        int split = line.lastIndexOf(" ",13);
        return line.substring(0,split+1)+"\n"+wordWrap(line.substring(split+1),width);
    }
}
