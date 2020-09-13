package datastructure.hashmap.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manjunath Asundi
 * Count all sub arrays sum length which subarrays have distinct elements
 */
public class CountSubArraysSumLengthWithDistinctElements {

    public static int countTotalSubArraysSumLengthWithDistinctElements(int arr[]) {
        Set<Integer> set = new HashSet<>();
        int countSubArraysLength = 0;
        int j = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            while (j < n && !set.contains(arr[j]))
                set.add(arr[j++]);
            countSubArraysLength += ((j - i) * (j - i + 1)) / 2;
            set.remove(arr[i]);
        }
        return countSubArraysLength;
    }

    public static void main(String[] args) {
        int twoDArray[][] = { { 1, 2, 3 }, { 1, 2, 1 }, { 1, 2, 3, 4 } };
        for (int[] arr : twoDArray) {
            System.out.println("Count sum of sub arrays length with distinct elements = "
                    + countTotalSubArraysSumLengthWithDistinctElements(arr));
        }
    }
}