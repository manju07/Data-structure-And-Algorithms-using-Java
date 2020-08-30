package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi
 * Print all sub arrays with sum equal 0
 */
public class PrintAllSubArraysWIthSumZero {

    static void printSubArraysWithSumZero(int arr[]) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                System.out.println(0 + " to " + i);
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (!map.containsKey(sum))
                map.put(sum, new ArrayList<Integer>());
            else {
                list = map.get(sum);
                for (Integer index : list)
                    System.out.println((index + 1) + " to " + i);
            }
            list.add(i);
            map.put(sum, list);
        }
    }

    public static void main(String[] args) {
        printSubArraysWithSumZero(new int[]{ 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 });
    }
}