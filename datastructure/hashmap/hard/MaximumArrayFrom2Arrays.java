package datastructure.hashmap.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created maximum array from given 2 arrays and most preferred array is first array 
 * @author Manjunath Asundi
 */
public class MaximumArrayFrom2Arrays {

    public static List<Integer> findMaximumArrayFrom2Arrays(int a[], int b[]) {
        Integer tempA[] = new Integer[a.length], tempB[] = new Integer[b.length];
        for (int i = 0; i < a.length; i++) {
            tempA[i] = a[i];
            tempB[i] = b[i];
        }
        Arrays.sort(tempA, Collections.reverseOrder());
        Arrays.sort(tempB, Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        while (map.size() != a.length && i < tempA.length && j < tempB.length) {
            if (tempA[i] >= tempB[j]) {
                if (!map.containsKey(tempA[i]))
                    map.put(tempA[i], 1);
                else
                    map.put(tempA[i], map.get(tempA[i]) + 1);
                i++;
            } else {
                if (!map.containsKey(tempB[j]))
                    map.put(tempB[j], 1);
                else
                    map.put(tempB[j], map.get(tempB[j]) + 1);
                j++;
            }
        }
        List<Integer> maximumArray = new ArrayList<Integer>();
        for (int k = 0; k < a.length; k++) 
            if (map.containsKey(a[k]))
                maximumArray.add(a[k]);

        for (int k = 0; k < b.length; k++)
            if (map.containsKey(b[k]) && map.get(b[k]) == 1 && !maximumArray.contains(b[k]))
                maximumArray.add(b[k]);
        return maximumArray;
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) 
            System.out.print(list.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int twoDArrayA[][] = { { 9, 7, 2, 3, 6 }, { 6, 7, 5, 3 } };
        int twoDArrayB[][] = { { 7, 4, 8, 0, 1 }, { 5, 6, 2, 9 } };
        for (int i = 0; i < twoDArrayB.length; i++) {
            System.out.print("Maximum Array derived from 2 arrays is -> ");
            printList(findMaximumArrayFrom2Arrays(twoDArrayA[i], twoDArrayB[i]));
        }
    }
}