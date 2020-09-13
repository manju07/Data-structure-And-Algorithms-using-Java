package datastructure.hashmap.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi
 * Count all pairs with equal elements
 */
public class CountPairsWithEqualElements {
    public static int countNumberOfPairsWithEqualElements(int arr[]) {
        int countPairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet())
            countPairs += ((set.getValue() * (set.getValue() - 1)) / 2);
        return countPairs++;
    }

    public static void main(String[] args) {
        int[] twoDArray[] = { { 1, 1, 2 }, { 1, 1, 1 }, { 1, 2, 3 } };
        for (int[] arr : twoDArray)
            System.out.println("Count of pairs having same elements = " + countNumberOfPairsWithEqualElements(arr));
    }
}