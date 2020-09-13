package datastructure.hashmap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 * Range queries finding frequency of given element and
 *         range[L,R]
 */
public class RangeQueriesFrequencyOfElements {

    public static int rangeQueries(Map<Integer, ArrayList<Integer>> map, int left, int right, int element) {
        int lowerBound = -1, upperBound = -1;
        ArrayList<Integer> arrayList = map.get(element);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) >= left) {
                lowerBound = i;
                break;
            }
        }

        for (int j = arrayList.size() - 1; j >= 0; j--) {
            if (arrayList.get(j) <= right) {
                upperBound = j;
                break;
            }
        }
        return upperBound - lowerBound + 1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 8, 6, 9, 8, 6, 8, 2, 11 };
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (map.containsKey(arr[i]))
                list = map.get(arr[i]);
            list.add(i);
            map.put(arr[i], list);
        }
        int[] queries[] = { { 1, 6, 2 }, { 4, 9, 8 } };
        for (int[] query : queries)
            System.out.println("Range queries frequency of element " + query[2] + " from left index =" + query[0]
                    + " and right index = " + query[1] + " and total No. Of elements appearing = "
                    + rangeQueries(map, query[0] - 1, query[1] - 1, query[2]));
    }
}