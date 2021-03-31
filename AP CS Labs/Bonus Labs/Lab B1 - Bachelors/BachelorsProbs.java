import java.io.*;

public class BachelorsProbs{
    public int withoutDupes(int[] nums){
        int size = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1])
                size++;
        }
        
        return size;
    }
    
    public int[] collapse(int[] nums){
        int sum = 0;
        int[] collapseArray = new int[(nums.length+1)/2];
        
        for(int i = 0; i < nums.length; i += 2){
            if(i == nums.length-1)
                sum = nums[i];
            else
                sum = nums[i]+nums[i+1];
                
            collapseArray[(i+1)/2] = sum;
        }
        
        return collapseArray;
    }
}
