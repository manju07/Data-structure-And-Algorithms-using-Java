package datastructure.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manjunath Asundi 
 */
class InnerArrayContainsContiguousElements {
    static boolean isArrayContainsContiguousIntegers(int arr[]) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int count = 0;
        int value = arr[0];
        while (set.contains(value)) {
            count++;
            value--;
        }
        value = arr[0] + 1;
        while (set.contains(value)) {
            count++;
            value++;
        }
        return set.size() == count;
    }
}

/**
 * ArrayContainsContiguousElements
 * link https://www.geeksforgeeks.org/check-array-contains-contiguous-integers-duplicates-allowed/
 */
public class ArrayContainsContiguousElements {

    public static void main(String[] args) {
        int arr[][] = { { 5, 2, 3, 6, 4, 4, 6, 6 }, { 10, 14, 10, 12, 12, 13, 15 } };
        for (int[] is : arr) {
            System.out.println(InnerArrayContainsContiguousElements.isArrayContainsContiguousIntegers(is));
        }
    }
}