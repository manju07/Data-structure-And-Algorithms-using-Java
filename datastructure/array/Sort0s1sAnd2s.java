package datastructure.array;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * Sort 0's, 1's and 2's
 * 
 * @return sorted list
 */
public class Sort0s1sAnd2s {

    private static void sort0s1sAnd2s(int[] arr) {
        int n = arr.length;
        int l = 0, m = 0, h = n - 1;
        while (m < h)
            if (arr[m] == 0)
                AlgoUtils.swapByIndex(arr, l++, m);
            else if (arr[m] == 2)
                AlgoUtils.swapByIndex(arr, h--, m);
            else
                m++;
        ArrayUtil.printArray(arr);
    }

    public static void main(String[] args) {
        int[][] twoDArr = new int[][] {
                { 1, 0, 1, 2, 0, 1, 0, 2, 1, 1 },
                { 1, 2, 2, 2, 0, 1, 0, 2, 1, 1 },
                { 2, 1, 2, 2, 0, 1, 0, 2, 1, 1 },
        };

        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            sort0s1sAnd2s(arr);
            System.out.println();
        }
    }
}
