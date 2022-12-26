package datastructure.array;

import java.util.Arrays;

import util.ArrayUtil;

/**
 * Find all triangles count that a + b > c, a + c > b, b + c > a
 * 
 * @author Manjunath Asundi
 */
public class Traingles {

    private static int findAllTraingles(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1; j++) {
                while ((k < n) && (arr[i] + arr[j] > arr[k])) {
                    k++;
                }
                if (k > j) {
                    count += (k - j - 1);
                }
            }
        }
        return count;
    }

    /**
     * @apiNote Find all traingles
     *          Time complexity is O(n^2) and space complexity is O(1)
     * @param arr Integer Array
     * @return count of traingles
     */
    private static int findAllTrainglesSolution2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0;
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = n - 1; i > 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] twoDArr = {
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructArrayWithinRange(10),
                { 8, 4, 6, 3, 7, 9 },
                { 4, 6, 3, 7 },
                { 10, 21, 22, 100, 101, 200, 300 }
        };

        System.out.println("\n\nSolution - 1\n");
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            System.out.println("Number of traingles = " + findAllTraingles(arr));
            System.out.println();
        }

        twoDArr = new int[][] {
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructArrayWithinRange(10),
                { 8, 4, 6, 3, 7, 9 },
                { 4, 6, 3, 7 },
                { 10, 21, 22, 100, 101, 200, 300 }
        };

        System.out.println("\n\nSolution - 2\n");
        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            System.out.println("Number of traingles = " + findAllTrainglesSolution2(arr));
            System.out.println();
        }
    }
}
