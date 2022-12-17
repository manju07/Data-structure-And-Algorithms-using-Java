package datastructure.array;

import util.ArrayUtil;

/**
 * Rearrange array elements Max1, Min1, Max2, Min2.....
 * @author Manjunath Asundi
 */
public class RearrangeWithMaxAndMinConsecutive {

    private static void rearrangeArrayWithMaxMin(int[] arr) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int maxElement = arr[arr.length - 1] + 1;

        for (int i = 0; i < arr.length; i++) {
            if ((i % 2) == 0) 
                arr[i] += (arr[maxIndex--] % maxElement) * maxElement;
            else
                arr[i] += (arr[minIndex++] % maxElement) * maxElement;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] /= maxElement;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ArrayUtil.printArray(arr);
        rearrangeArrayWithMaxMin(arr);
        ArrayUtil.printArray(arr);
    }
}
