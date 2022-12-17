package datastructure.array;

import util.ArrayUtil;

/**
 * Moving all zeros at the end of array
 * @author Manjunath Asundi
 */
public class MoveAllZerosToEnd {

    private static void moveAllZerosToEndOfArraySolution1(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];

        while (count < arr.length)
            arr[count++] = 0;
    }

    private static void moveAllZerosToEndOfArraySolution2(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 4, 0, 0, 5, 0, 6, 7 };
        System.out.println("Solution - 1");
        ArrayUtil.printArray(arr);
        moveAllZerosToEndOfArraySolution1(arr);
        ArrayUtil.printArray(arr);
        System.out.println();

        arr = new int[] { 1, 2, 0, 4, 0, 0, 5, 0, 6, 7 };
        System.out.println("Solution - 2");
        ArrayUtil.printArray(arr);
        moveAllZerosToEndOfArraySolution2(arr);
        ArrayUtil.printArray(arr);
    }
}
