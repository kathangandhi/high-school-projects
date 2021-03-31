public class NumberList{
    private int size;//number of elements, different from arr.length
    private Integer[] arr;//backing array

    /**
     * <code>NumberList</code> constructor that initialises backing array
     */
    public NumberList(){
        this.arr = new Integer[2];
        this.size = 0;
    }

    /**
     * Returns number of elements in the array
     * @return number of elements in array
     */
    public int size(){
        return this.size;
    } 

    /**
     * Checks if the array is empty
     * @return true, if there are no elements in array
     */
    public boolean isEmpty(){
        return (this.size==0);
    }

    /**
     * Returns a String representation of the <code>NumberList</code>
     * @return String representation of the <code>NumberList</code>
     */
    public String toString(){
        String arrRep = new String();//local variable to store String representation
        if(this.isEmpty()){
            arrRep += "[]";
            return arrRep;
        }
            
        //appends all elements in format
        arrRep += "[";
        for(int i = 0; i < this.size-1; i++){
            arrRep += arr[i]+", ";
        }
        arrRep += arr[this.size-1]+"]";

        return arrRep;//returns String representation
    }

    /**
     * Increases length of backing array by creating new array and copying elements
     */
    private void doubleCapacity(){
        Integer[] temp = new Integer[2*arr.length];//declares new array

        //copies all elements from original array to new array
        for(int i = 0; i < size; i++){
            temp[i] = arr[i];
        }

        arr = temp;//sets reference for arr to new array
    }

    /**
     * Adds element to array in the specified index and shifts subsequent elements down
     * @param index the specified index for adding the element
     * @param element the desired element to add
     * @throws IndexOutOfBoundsException if index is inappropriate
     */
    public void add(int index, Integer element){
        if(size == arr.length)
            this.doubleCapacity();
        
        if(index < 0||index > this.size)
            throw new IndexOutOfBoundsException();
        else 
        if(index == size){
            arr[index] = element;
            size++;
        }
        else{//if index is between the elements
            size++;
            
            for(int i = size-1; i > index; i--){
                arr[i] = arr[i-1];
            }
            arr[index] = element;
        } 
    }

    /**
     * Adds element to array at the end
     * @param element the desired element to add
     */
    public void add(Integer element){
        if(size == arr.length)
            this.doubleCapacity();
        arr[size] = element;
        size++;
    }

    /**
     * Gets element from array at specified index
     * @param index the desired index in the array
     * @return the Integer element at the index in the array
     * @throws IndexOutOfBoundsException if index is inappropriate
     */
    public Integer get(int index){
        if(index < 0||index > size)
            throw new IndexOutOfBoundsException();
        else
            return arr[index];
    }

    /**
     * Swaps element in array at specified index with specified element
     * @param index the desired index in the array
     * @param element the element to replace with
     * @return the original Integer element at the index in the array
     * @throws IndexOutOfBoundsException if index is inappropriate
     */
    public Integer set(int index, Integer element){
        if(index < 0||index > size)
            throw new IndexOutOfBoundsException();
        else{
            Integer temp = arr[index];
            arr[index] = element;
            return temp;
        }
    }

    public Integer remove(int index){
        if(index < 0||index > size)
            throw new IndexOutOfBoundsException();
        else{
            Integer temp = arr[index];//stores element to return
            arr[index] = null;//removes element at index
            size--;//reduces size of list
            
            for(int i = index; i < size; i++){
                arr[i] = arr[i+1];//shifts all elements down
            }
            arr[size] = null;
            
            return temp;
        }    
    } 
}