package datastructure.hashmap.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi
 * Sum of all unique sum of sub arrays
 */
public class SumOfUniqueSumOfSubArrays {

    public static int findAllSumOfUniqueSumOfSubArrays(int arr[]) {
        int sumOfSubArrays = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, 1);
                else
                    map.put(sum, map.get(sum) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet())
            if (set.getValue() == 1)
                sumOfSubArrays += set.getKey();
        return sumOfSubArrays;
    }

    public static void main(String[] args) {
        int twoDArray[][] = { { 3, 4, 5 }, { 2, 4, 2 } };
        for (int[] arr : twoDArray)
            System.out.println("Sum of All unique sub array sum = " + findAllSumOfUniqueSumOfSubArrays(arr));
    }
}