package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Array related Util Methods
 * 
 * @author Manjunath Asundi
 */
public class ArrayUtil<T extends Number> {

    public static void printArray(int arr[]) {
        for (int data : arr)
            System.out.print(data + " ");
        System.out.println();
    }

    public static <T> void printArray(List<T> resultArr) {
        for (T data : resultArr)
            System.out.print(data + " ");
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for (Object object : list)
            System.out.print(object + " ");
        System.out.println();
    }

    /**
     * Generate random unique elements integer array of size between 5 and 10
     * and value will be in range of 0 to 15
     * 
     * @return int array
     */
    public static int[] constructRandomUniqueElementsArray() {
        int low = 5;
        int length = AlgoUtils.random(5) + low;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(AlgoUtils.random(15));
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Generate random integer array of size between 5 and 10
     * and value will be in range of 0 to 15
     * 
     * @return int array
     */
    public static int[] constructRandomArray() {
        int low = 5;
        int length = AlgoUtils.random(5) + low;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = AlgoUtils.random(15);
        }
        return arr;
    }
}