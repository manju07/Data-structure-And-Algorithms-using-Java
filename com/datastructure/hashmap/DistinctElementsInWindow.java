package com.datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * InnerDistinctElementsInWindow
 */
class InnerDistinctElementsInWindow {
    static void printDistinctElementsWindow(int arr[], int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 1);
            else {
                int count = hm.get(arr[i]);
                hm.put(arr[i], count + 1);
            }
        }
        System.out.print(hm.size() + " ");
        for (int i = k; i < arr.length; i++) {
            if (hm.get(arr[i - k]) == 1) {
                hm.remove(arr[i - k]);
            } else if (hm.get(arr[i - k]) > 1) {
                int count = hm.get(arr[i - k]);
                hm.put(arr[i - k], count - 1);
            }
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 1);
            else {
                int count = hm.get(arr[i]);
                hm.put(arr[i], count + 1);
            }
            System.out.print(hm.size() + " ");
        }
    }
}

/**
 * DistinctElementsInWindow
 */
public class DistinctElementsInWindow {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        InnerDistinctElementsInWindow.printDistinctElementsWindow(arr, k);
    }
}