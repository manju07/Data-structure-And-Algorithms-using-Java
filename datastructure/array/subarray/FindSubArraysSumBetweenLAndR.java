package datastructure.array.subarray;

import util.ArrayUtil;

/**
 * Find sub arrays of sum between L and R
 * 
 * @author Manjunath Asundi
 */
public class FindSubArraysSumBetweenLAndR {

    private static void printSubArraysOfSumLivesBetweenLAndR(int[] arr, int l, int r) {
        int i = 0, j = 0;
        int sum = 0;
        int n = arr.length;
        while (i < n) {
            int tempSum = sum;
            while (j < n && (tempSum < l || tempSum <= r)) {
                tempSum += arr[j];
                if (tempSum >= l && tempSum <= r) {
                    System.out.println("Index from " + i + " to " + j + " sum = " + tempSum);
                    sum = tempSum;
                }
                j++;
            }

            if (tempSum > r) {
                j--;
            }

            sum -= arr[i++];
            if (sum >= l && sum <= r) {
                System.out.println("Index from " + i + " to " + (j - 1) + " sum = " + sum);
            }

        }
    }

    public static void main(String[] args) {
        int[][] twoDArr = {
                { 7, 5, 4, 3, 8, 9, 1, 6, 10, 2 },
                { 2, 3, 5, 8 },
                ArrayUtil.constructArrayByLengthAndValueBound(10, 10)
        };
        for (int[] arr : twoDArr) {
            ArrayUtil.printArrayWithIndex(arr);
            printSubArraysOfSumLivesBetweenLAndR(arr, 4, 13);
            System.out.println();
        }
    }
}
