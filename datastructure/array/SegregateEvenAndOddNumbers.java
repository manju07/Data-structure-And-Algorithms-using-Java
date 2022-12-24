package datastructure.array;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * @apiNote Segregate even numbers first and then odd numbers from the given
 *          array.
 * 
 * @author Manjunath Asundi
 */
public class SegregateEvenAndOddNumbers {

    private static void segregateEvenAndThenOddNumbers_Solution1(int[] arr) {
        int[] resultArr = new int[arr.length];
        int i = 0, j = arr.length - 1;
        int l = 0, r = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 == 0) {
                resultArr[l++] = arr[i];
            } else {
                resultArr[r--] = arr[i];
            }

            if (arr[j] % 2 == 0) {
                resultArr[l++] = arr[j];
            } else {
                resultArr[r--] = arr[j];
            }
            
            i++;
            j--;
        }
        ArrayUtil.printArray(resultArr);
    }

    private static void segregateEvenAndThenOddNumbers_Solution2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {

            while (l < r && (arr[l] % 2 == 0)) {
                l++;
            }

            while (l < r && (arr[r] % 2 != 0)) {
                r--;
            }

            if (l < r) {
                AlgoUtils.swapByIndex(arr, l, r);
            }
        }
    }

    public static void main(String[] args) {
        int twoDArr[][] = {
                { 1, 3, 5, 7 },
                { 1, 3, 4, 8, 5, 9, 7, 10 },
                { 2, 3, 5, 8, 12, 9, 6, 10 },
                { 1, 3, 5, 7, 8, 9, 4, 12 },
                { 2, 4, 6, 8 }
        };

        System.out.println("Solution-1");
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            segregateEvenAndThenOddNumbers_Solution1(arr);
            System.out.println();
        }

        twoDArr = new int[][] {
                { 1, 3, 5, 7 },
                { 1, 3, 4, 8, 5, 9, 7, 10 },
                { 2, 3, 5, 8, 12, 9, 6, 10 },
                { 1, 3, 5, 7, 8, 9, 4, 12 },
                { 2, 4, 6, 8 }
        };
        System.out.println("Solution-2");
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            segregateEvenAndThenOddNumbers_Solution2(arr);
            ArrayUtil.printArray(arr);
            System.out.println();
        }
    }
}