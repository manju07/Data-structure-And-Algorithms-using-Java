package com.ds.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * InnerLargestSubArrayWithSumZero
 */
class InnerLargestSubArrayWithSumZero {
    static int printLargestSubArrayWithSumZero(int arr[]) {
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!sumMap.containsKey(sum))
                sumMap.put(sum, i);
            else {
                int j = sumMap.get(sum);
                maxLength = Math.max(maxLength, i - j);
            }
        }
        return maxLength;
    }
}

/**
 * LargestSubArrayWithSumZero Link
 * https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 */
public class LargestSubArrayWithSumZero {
    public static void main(String[] args) {
        int arr[][] = { { 15, -2, 2, -8, 1, 7, 10, 23 }, { 1, 2, 3 }, { 1, 0, 3 } };
        for (int[] is : arr) {
            System.out.println("Max length of sub array having sum zero: "
                    + InnerLargestSubArrayWithSumZero.printLargestSubArrayWithSumZero(is));
        }
    }
}