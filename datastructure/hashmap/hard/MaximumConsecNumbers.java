package datastructure.hashmap.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Maximum consecutive numbers present in the array
 * 
 * @author Manjunath Asundi
 */
public class MaximumConsecNumbers {

    public static int findMaximumConsecutiveNumbersPresent(int arr[]) {
        int maxConsecNoPresent = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            while (set.contains(value))
                value++;
            if ((value - arr[i]) > maxConsecNoPresent)
                maxConsecNoPresent = value - arr[i];
        }
        return maxConsecNoPresent;
    }

    public static void main(String[] args) {
        int twoDArray[][] = { { 1, 94, 93, 1000, 5, 92, 78 }, { 1, 5, 92, 4, 78, 6, 7 } };
        for (int[] arr : twoDArray) {
            System.out.println("Maximum consecutive numbers present is = " + findMaximumConsecutiveNumbersPresent(arr));
        }
    }
}