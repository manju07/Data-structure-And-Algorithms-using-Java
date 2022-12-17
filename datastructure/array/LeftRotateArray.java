package datastructure.array;

import util.ArrayUtil;

public class LeftRotateArray {

    private static void leftRotateArrayDTimes(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int greatestCD = gcd(n, d);
        for (int i = 0; i < greatestCD; i++) {
            int temp = arr[i];
            int j = i;
            while (j < n) {
                int k = j + d;

                if (k >= n) {
                    k = k - n;
                }

                if (k == i) {
                    break;
                }

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }
        };
        int[] dArr = { 5, 10 };
        for (int i = 0; i < dArr.length; i++) {
            ArrayUtil.printArray(arr[i]);
            leftRotateArrayDTimes(arr[i], dArr[i]);
            ArrayUtil.printArray(arr[i]);
            System.out.println();
        }
    }
}