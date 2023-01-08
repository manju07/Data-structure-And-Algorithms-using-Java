package datastructure.array.subarray;

import util.ArrayUtil;

/**
 * Find sub array of sum in the given array
 * @author Manjunath Asundi
 */
public class FindSubArrayOfSum {

    private static void findSubArrayOfSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            System.out.println("No sub array found for sum " + sum);
            return;
        }
        int n = arr.length;
        int j = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            while (j < n && tempSum > sum) {
                tempSum -= arr[j];
                j++;
            }
            if (tempSum == sum) {
                System.out.println("Sub array of sum " + sum + " found in index between " + (j) + " to " + i);
                return;
            }
        }
        System.out.println("No sub array found for sum " + sum);
    }

    public static void main(String[] args) {
        int[][] twoDArr = {
                ArrayUtil.constructArrayByLengthAndValueBound(10, 20),
                ArrayUtil.constructArrayByLengthAndValueBound(10, 20),
                ArrayUtil.constructArrayByLengthAndValueBound(10, 20),
                { 1, 4, 20, 3, 10, 5 },
                { 1, 4, 0, 0, 3, 10, 5 },
                { 1, 4 }
        };
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            findSubArrayOfSum(arr, 33);
            System.out.println();
        }
    }
}
