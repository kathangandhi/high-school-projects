import java.util.*;

/**
 * The TwoDArrays class has a lot of useful methods for 2D arrays
 */
public class TwoDArrays
{
    private int[][] nums;

    /**
     * The TwoDArrays constructor for initialising 2D array nums
     * @param numbers the array provided
     */
    public TwoDArrays(int [][] nums){
        this.nums = nums;
    }

    /**
     * The sum method adds all the numbers in the 2D array
     * @return sum of all elements
     */
    public int sum(){
        int total =  0;
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[0].length; col++){
                total += nums[row][col];
            }
        }
        return total;
    }

    /**
     * The method checks if the 2D array has equal no. of rows and cols
     * @return if the 2D array is square
     */
    public boolean isSquare(){
        int rows = nums[0].length;
        int cols = nums.length;
        return (cols==rows);
    }

    /**
     * The method checks if the 2D array's elements are in sequence
     * Precondition - nums is a square 2D array
     * @return if all elements are in dequence 
     */
    public boolean inSequence(){
        if(!isSquare()){
            return false;
        }
        
        int currentNum = nums[0][0];
        int count = 0;
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[0].length; col++){
                if(currentNum==nums[row][col]){
                    count++;
                    currentNum++;
                }
            }
        } 
        
        return (count == nums.length * nums.length);
    }

    /**
     * The method finds the location of the element with the smallest absolute value
     * @return the location as {row,col} 
     */
    public int[] closestToZero(){
        int closest = Integer.MAX_VALUE;
        int[] values = new int[2];
        
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[0].length; col++){
                if(Math.abs(nums[row][col]-0) < closest){
                    closest = Math.abs(nums[row][col]-0);
                    values = new int[]{row,col};
                }    
            }
        }
        
        return values;
    }

    /**
     * The method adds two 2D arrays of similar dimensions together
     * @param other the 2nd 2D array to add
     * 
     * Calls on method print(int[][])
     */
    public void addMatrix(int[][] other){
        int[][] addition = new int[other.length][other[0].length];
        
        for(int row = 0; row < nums.length; row++){
            for(int col = 0; col < nums[0].length; col++){
                addition[row][col] += nums[row][col] + other[row][col]; 
            }
        }
        
        print(addition);
    }

    /**
     * The method adds all elements of a column in a 2D array 
     * @param col the column index in the 2D array
     * @return the sum of the column in the 2D array
     */
    public int columnSum(int col){
        int sum = 0;
        for(int rowNo = 0; rowNo < nums.length; rowNo++){
            if(col < nums[rowNo].length)
                sum += nums[rowNo][col];
        }
        return sum;
    }

    /**
     * The method checks if a 2D array shows column magic 
     * @return if the sum of all columns is same
     * 
     * Calls on columnSum()
     */
    public boolean isColumnMagic(){
        int colSum = columnSum(0);
        for(int i = 1; i < nums.length; i++){
            if(columnSum(i) != columnSum(0))
                return false;
        }
        return true;
    }

    /**
     * The method checks if a 2D array shows diagonal magic 
     * @return if the sum of diagonals is same
     */
    public boolean sameDiagonalSums(){
        int cols = nums[0].length;
        int rows = nums.length;
        int d1sum = 0;
        int d2sum = 0;
        for(int i = 0; i < nums.length; i++){
            d1sum += nums[i][i];
            d2sum += nums[(nums.length-1)-i][i];
        }
        return (d1sum == d2sum);
    }

    /**
     * The method prints a 2D array
     */
    private void print(int[][] array){
        for(int[] row: array){
            System.out.print(Arrays.toString(row)+" ");
        }
        System.out.println();
    }
}
