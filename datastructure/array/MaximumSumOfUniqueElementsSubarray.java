package datastructure.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Find Maximum sum of contiguous subarray having unique elements
 * 
 * @author Manjunath Asundi
 */
public class MaximumSumOfUniqueElementsSubarray {

    public static int findMaxSumSubarray(int arr[]) {
        int i = 0, j = 1;
        int maxSum = Integer.MIN_VALUE, sum = arr[i];
        Set<Integer> set = new HashSet<>();
        set.add(arr[i]);
        for (; i < arr.length && j < arr.length;) {
            if (set.contains(arr[j])) {
                sum = sum - arr[i];
                set.remove(arr[i]);
                i++;
            } else {
                set.add(arr[j]);
                sum = sum + arr[j];
                maxSum = Math.max(sum, maxSum);
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        for (int arr[] : new int[][] { { 1, 2, 3, 3, 1, 5, 6 }, { 4, 2, 3, 1, 5, 6, 7, 2 },
                { 5, 6, 3, 4, 1, 2, 3, 8, 7 } })
            System.out.println("Max Sum = " + findMaxSumSubarray(arr));
    }
}