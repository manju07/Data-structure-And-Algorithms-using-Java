package datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerMaxLengthOfConsSequence {
    static int findMaxLengthOfConsecutiveSequence(int arr[]) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxLength = 1;
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i] - 1))
                hm.put(arr[i], 1);
            else {
                int count = hm.get(arr[i] - 1) + 1; 
                hm.put(arr[i], count);
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

}

/**
 * MaxLengthOfConsSequence
 * link https://www.geeksforgeeks.org/longest-increasing-consecutive-subsequence/
 */
public class MaxLengthOfConsSequence {
    public static void main(String[] args) {
        int a[][] = { { 3, 10, 3, 11, 4, 5, 6, 7, 8, 12 }, { 6, 7, 8, 3, 4, 5, 9, 10 } };
        for (int[] is : a) {
            System.out.println("Maximum length of consecutive sequence: "+ InnerMaxLengthOfConsSequence.findMaxLengthOfConsecutiveSequence(is));
        }

    }
}