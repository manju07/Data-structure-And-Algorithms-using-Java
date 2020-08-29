package datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi
 * Print all distinct elements in every window of size K
 */
public class CountDistinctElementsinWindowSizeK {
    
    static void countDistinctElements(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                count++;
            } else 
                map.put(arr[i], map.get(i) + 1);
        }
        System.out.print(count + " ");
        for (int i = k; i < arr.length; i++) {
            if(map.get(arr[i-k]) > 1) {
                map.put(arr[i-k], map.get(arr[i-k]) - 1);
            } else {
                map.remove(arr[i-k]);
                count--;
            }
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                count++;
            } else {
                map.put(arr[i], map.get(arr[i])+1);
            }
            System.out.print(count+ " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, k = 4;
        countDistinctElements(arr, k);
    }
}