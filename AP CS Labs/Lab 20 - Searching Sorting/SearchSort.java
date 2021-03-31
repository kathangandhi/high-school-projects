import java.util.*;
public class SearchSort{
    private int nums[];

    /**
     * A constructor to initialize array nums
     */
    public SearchSort(int[] nums){
        this.nums = nums;
    }

    /**
     * A constructor to initialize array nums 
     */
    public SearchSort(int size){
        this.nums = new int[size];
    }

    /**
     * Fills array with random values 
     */
    public void initArray(){
        for(int i = 0; i < nums.length; i++){
            int rand = (int)(Math.random()*nums.length + 1);
            nums[i] = rand;
        }
    }

    /**
     * Swaps values at index i and j
     * @param i First index
     * @param j Second index
     */
    private void swap(int i, int j){
        int og = nums[j];
        nums[j] = nums[i];
        nums[i] = og;
    }

    /**
     * Conducts a linear search and returns index of key, 
     * -1 if not found
     */
    public int linearSearch(int key){
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key){
                index = i;    
                break;
            }
            if(i == nums.length-1)
                index = -1;
        }

        return index;
    }

    /**
     * Conducts a linear search and returns index of key, 
     * -1 if not found
     */
    public int binarySearch(int key){
        Arrays.sort(nums);
        int index = 0,front = 0,back = nums.length-1,middle = nums.length/2;

        while(front <= back){
            index = middle;
            if(nums[index] == key){
                return index;
            }
            else if(key < nums[index]){
                back = middle-1;
            }
            else if(key > nums[index]){
                front = middle+1;
            }

            middle = front+back/2;
        }

        return -1;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int binarySearchRecursive(int key){
        return binarySearchRecursive(key,0,nums.length-1);
    }

    /**
     * Conducts a linear search and returns index of key, 
     * -1 if not found
     */
    public int binarySearchRecursive(int key,int front,int back){
        Arrays.sort(nums);
        int middle = (front+back+1)/2;

        if(front > back)
            return -1;
        else if(nums[middle] == key)
            return middle;
        else if(key < nums[middle])
            return binarySearchRecursive(key,front,middle-1);
        else if(key > nums[middle])
            return binarySearchRecursive(key,middle+1,back);
        return -1;
    }

    /**
     * Conducts a bubble sort on a list
     */
    public void bubbleSort(boolean print){
        boolean sorted = true;
        while(sorted){
            int count = 0;
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    this.swap(i,i+1);
                    count++;
                }
            }

            if(print)
                System.out.println(this.toString());

            if(count == 0)
                sorted = false;
        }

        if(!print)
            System.out.println(this.toString());
    }

    public void selectionSort(boolean print){
        for(int s = 0; s < nums.length; s++){
            int biggest = Integer.MAX_VALUE;
            int smallIndex = 0;

            //find the lowest number between i and nums.length
            //i is incremented so that it doesn't consider sorted elements
            for(int i = s; i < nums.length; i++){
                if(nums[i] < biggest){
                    biggest = nums[i];
                    smallIndex = i;
                }
            }

            this.swap(s,smallIndex);//swaps smallest number with current index
            if(print)
                System.out.println(this.toString());
        }

        if(!print)
            System.out.println(this.toString());
    }

    public void insertionSort(boolean print){
        boolean sorted = true;
        while(sorted){
            int count = 0;
            for(int s = 1; s < nums.length; s++){
                for(int i = s; i >= 1; i--){
                    if(nums[i] < nums[i-1]){
                        this.swap(i,i-1);
                        count++;
                    }
                    else
                        break;
                }

                if(print)
                    System.out.println(this.toString());
            }

            if(!print)
                System.out.println(this.toString());

            if(count == 0)
                sorted = false;
        }
    }

    public void mergeSort(boolean print){
        mergeSort(nums,print);
        
        if(!print)
            System.out.println(this.toString());
    }

    private void mergeSort(int[] nums,boolean print){
        if(nums.length > 1){
            int center = nums.length/2;
            int left = 0;
            int right = nums.length;

            int[] leftArr = copyArray(left,center,nums);
            int[] rightArr = copyArray(center,right,nums);

            mergeSort(leftArr,print);
            mergeSort(rightArr,print);

            int li = 0, ri = 0, c = 0;
            for(; li < leftArr.length && ri < rightArr.length; c++){
                if(leftArr[li] > rightArr[ri]){
                    nums[c] = rightArr[ri];
                    ri++;
                }
                else{
                    nums[c] = leftArr[li];
                    li++;
                }
            }

            for(;li < leftArr.length; c++, li++){
                nums[c] = leftArr[li];
            }

            for(; ri < rightArr.length; c++, ri++){
                nums[c] = rightArr[ri];
            }
            
            if(print)
                System.out.println(Arrays.toString(nums));
        }
    }

    private int[] copyArray(int i, int j, int arr[]){
        int[] copy = new int[j-i];
        for(int loop = i; loop < j; loop++){
            copy[loop-i] = arr[loop];
        }

        return copy;
    }

    /**
     * Returns legible String with array values. Uses Array's toString()
     */
    @Override
    public String toString(){
        return Arrays.toString(nums);
    }
}