package datastructure.hashmap.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Find longest sub-array having count of 1's one more than count of 0's
 * @author Manjunath Asundi 
 */
public class LongestSubArrayWith1sCountThan0s {

    public static int findLongestSubArrayLengthWith1sCountThan0s(int arr[]) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : arr[i];
            if (sum == 1)
                maxLength = i + 1;
            if (!map.containsKey(sum))
                map.put(sum, i);
            if (map.containsKey(sum - 1)) {
                if (maxLength < i - map.get(sum - 1))
                    maxLength = i - map.get(sum - 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 0, 0, 1, 1 }, { 0, 1, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0 } };
        for (int[] is : arr)
            System.out.println("Longest sub array count 1's one more than 0's count "
                    + findLongestSubArrayLengthWith1sCountThan0s(is));
    }
}