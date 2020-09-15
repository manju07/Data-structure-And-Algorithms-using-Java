package datastructure.hashmap.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find A + B + C  = D and find D from given array
 * @author Manjunath Asundi
 */
public class FindAplusBplusCEqualToD {

    public static int findD(int arr[]) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                map.put(arr[i] + arr[j], Arrays.asList(i, j));

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] > arr[j] ? arr[i] - arr[j] : arr[j] - arr[i];
                if (map.containsKey(sum)) {
                    List<Integer> list = map.get(sum);
                    if ((list.get(0) != i && list.get(1) != i) && (list.get(0) != j && list.get(1) != j)) {
                        return arr[i] > arr[j] ? arr[i] : arr[j];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] twoDArray = { { 2, 3, 5, 7, 12 }, { 2, 5, 1, 8, 4, 9 } };
        for (int[] arr : twoDArray) {
            int d = findD(arr);
            if (d != -1)
                System.out.println("A + B + C = D and D = " + d);
            else
                System.out.println("Not found");
        }
    }
}