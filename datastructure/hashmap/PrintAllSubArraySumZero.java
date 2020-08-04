package datastructure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerPrintAllSubArraySumZero {
    static void printAllSubArrayWithSumZero(int arr[]) {
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                System.out.println(0 + " to " + i);
            List<Integer> list = new ArrayList<Integer>();
            if (hm.containsKey(sum)) {
                list = hm.get(sum);
                for (int j = 0; j < list.size(); j++)
                    System.out.println((list.get(j) + 1) + " to " + i);
                list.add(i);
            } else {
                list.add(i);
                hm.put(sum, list);
            }
        }
    }

}

/**
 * PrintAllSubArraySumZero
 */
public class PrintAllSubArraySumZero {

    public static void main(String[] args) {
        int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
        InnerPrintAllSubArraySumZero.printAllSubArrayWithSumZero(arr);
    }
}