import java.util.*;
public class Runner{
    public static void main(String args[]){
        SearchSort obj = new SearchSort(10);
        obj.initArray();
        System.out.println(obj);
        System.out.println(obj.binarySearch(3));
    }
}