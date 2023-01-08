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

    public static void printArrayWithIndex(int arr[]) {
        System.out.print("Index ");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(i + ", ");
            else
                System.out.print(i);
        }
        System.out.print("\nArray ");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + ", ");
            else
                System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void printArray(int arr[]) {
        for (int data : arr)
            System.out.print(data + " ");
        System.out.println();
    }

    /**
     * @apiNote Print integer array
     * @param printString print the string to console before arr[]
     * @param arr         integer array, it's printed after printString
     */
    public static void printArray(String printString, int arr[]) {
        System.out.println(printString);
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
     * Generate integer array of size range and each element between 1 to range
     * 
     * @param range elements value will be between 1 to range
     * @return int array
     */
    public static int[] constructArrayWithinRange(int range) {
        Set<Integer> set = new HashSet<Integer>();
        int[] arr = new int[range];
        int index = 0;
        while (index < range) {
            int data = AlgoUtils.random(range) + 1;
            if (!set.contains(data)) {
                arr[index++] = data;
                set.add(data);
            }
        }
        return arr;
    }

    /**
     * Generate random integer array based on length and elements range
     * 
     * @param lengthBound Array length
     * @param valuesBound elements value bound
     * @return int array
     */
    public static int[] constructArrayByLengthAndValueBound(int lengthBound, int valuesBound) {
        Set<Integer> set = new HashSet<Integer>();
        int[] arr = new int[lengthBound];
        int index = 0;
        while (index < lengthBound) {
            int data = AlgoUtils.random(valuesBound) + 1;
            if (!set.contains(data)) {
                arr[index++] = data;
                set.add(data);
            }
        }
        return arr;
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