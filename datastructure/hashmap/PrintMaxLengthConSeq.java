package datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerPrintMaxLengthConSeq {
    static void findMaxLengthOfConsecutiveSequence(int arr[]) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxLength = 1;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (!hm.containsKey(arr[i] - 1))
                hm.put(arr[i], 1);
            else {
                int count = hm.get(arr[i] - 1) + 1;
                hm.put(arr[i], count);
                if (maxLength < count) {
                    maxLength = count;
                    index = i;
                }
            }
        }
        for (int i = arr[index] - maxLength + 1; i <= arr[index]; i++)
            System.out.print(i + " ");
    }
}

/**
 * PrintMaxLengthConSeq
 */
public class PrintMaxLengthConSeq {

    public static void main(String[] args) {
        int a[][] = { { 3, 10, 3, 11, 4, 5, 6, 7, 8, 12 }, { 6, 7, 8, 3, 4, 5, 9, 10 } };
        for (int[] is : a) {
            InnerPrintMaxLengthConSeq.findMaxLengthOfConsecutiveSequence(is);
            System.out.println();
        }
    }
}