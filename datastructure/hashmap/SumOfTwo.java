package datastructure.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manjunath Asundi 
 */
public class SumOfTwo {

    static void sumOfTwoElements(int arr[], int sum) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(sum-arr[i])) System.out.println(arr[i] + " "+ (sum-arr[i])); 
            else set.add(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,2,4,5,7,11,9,8,3,13};
        int sum = 12;
        sumOfTwoElements(arr, sum);
    }
}