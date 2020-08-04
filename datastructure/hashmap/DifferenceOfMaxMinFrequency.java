package datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerDifferenceOfMaxMinFrequency {

    static int differenceBetweenMaxMinFrequency(int arr[]) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxF = Integer.MIN_VALUE;
        int minF = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                int count = hm.get(arr[i]) + 1;
                hm.put(arr[i], count);
            } else
                hm.put(arr[i], 1);

        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int v = entry.getValue();
            if (v > maxF)
                maxF = v;
            if (v < minF)
                minF = v;
        }
        return maxF - minF;
    }
}

/**
 * DifferenceOfMaxMinFrequency link
 * https://www.geeksforgeeks.org/difference-between-highest-and-least-frequencies-in-an-array/
 */
public class DifferenceOfMaxMinFrequency {
    public static void main(String[] args) {
        int arr[][] = { { 7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5 }, { 1, 1, 1, 3, 3, 3 } };
        for (int[] is : arr) {
            System.out.println("Difference betwen max and min frequency:"
                    + InnerDifferenceOfMaxMinFrequency.differenceBetweenMaxMinFrequency(is));
        }
    }
}