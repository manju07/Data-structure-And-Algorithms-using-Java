package datastructure.array;

import util.ArrayUtil;

/**
 * @apiNote Update elements from index L to R by adding X.
 *          update complexity is O(1) and print array complexity is O(n)
 * @author Manjunath Asundi
 */
public class RangeUpdateInOof1 {
    private static int[] d;

    private static void initializeDArr(int[] arr) {
        int n = arr.length;
        d = new int[n + 1];
        d[0] = arr[0];
        d[n] = 0;
        for (int i = 1; i < n; i++) {
            d[i] = arr[i] - arr[i - 1];
        }
    }

    private static void update(int x, int l, int r) {
        d[l] += x;
        d[r + 1] -= x;
    }

    private static void printArray(String printString, int[] arr) {
        System.out.println(printString);

        arr[0] = d[0];
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = d[i] + arr[i - 1];
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] twoDDataArr = {
                ArrayUtil.constructArrayByLengthAndValueBound(6, 10),
                ArrayUtil.constructArrayByLengthAndValueBound(6, 10),
                ArrayUtil.constructArrayByLengthAndValueBound(6, 10)
        };

        for (int[] arr : twoDDataArr) {
            ArrayUtil.printArray("\nInput Array", arr);
            initializeDArr(arr);
            update(10, 1, 4);
            printArray("After update 10 between 1 to 4 indexes", arr);
            update(20, 0, 2);
            printArray("After update 20 between 0 to 2 indexes", arr);
            System.out.println();
        }
    }
}
