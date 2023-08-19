package datastructure.array.sort;

import util.ArrayUtil;

/**
 * @apiNote Insertion sort
 * @author Manjunath Asundi
 */
public class InsertionSort {
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        int n = arr.length;
        int i = 1;

        while (i < n) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        int twoDArr[][] = {
                ArrayUtil.constructArrayWithinRange(10),
                ArrayUtil.constructArrayWithinRange(10),
                ArrayUtil.constructArrayWithinRange(10),
        };
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray("Input Array ", arr);
            insertionSort(arr);
            ArrayUtil.printArray("Sorted Array ", arr);
            System.out.println();
        }
    }
}
