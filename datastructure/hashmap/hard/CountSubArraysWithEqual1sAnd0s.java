package datastructure.hashmap.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 * Count all sub arrays having equal number of 1's and 0's
 */
public class CountSubArraysWithEqual1sAnd0s {

    public static int countAllSubArraysWithEqualNumberOf1sAnd0s(int arr[], int n) {
        int subArrayCount = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : arr[i];
            if (sum == 0)
                subArrayCount++;
            if (map.containsKey(sum)) {
                int count = map.get(sum);
                subArrayCount += count;
                map.put(sum, count + 1);
            } else
                map.put(sum, 1);
        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        int arr[][] = { 
        { 1, 0, 0, 1, 0, 1, 1 },
        { 1, 1, 1, 0, 0 }, 
        { 1, 0, 1, 1, 1, 1, 1, 0 } };
        for (int[] is : arr)           
            System.out.println("Sub arrays count with equal number of 1's and 0's = "
                    + countAllSubArraysWithEqualNumberOf1sAnd0s(is, is.length));
    }
}