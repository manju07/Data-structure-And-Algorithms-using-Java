package datastructure.array;

import util.ArrayUtil;

/**
 * After quarrel frog jumps to different direction from same point and task is
 * to make max distance between them. also, they can only jump to adjacent
 * greater
 * element.
 * 
 * @author Manjunath Asundi
 */
public class FrogJumps {

    private static int largestDistanceJumpFogs(int[] arr) {
        int i = 0;
        int n = arr.length;
        int maxDistance = Integer.MIN_VALUE;
        while (i < n) {
            int j = i + 1;
            while (j < n && arr[j] >= arr[j - 1]) {
                j++;
            }

            int k = i - 1;
            while (k >= 0 && arr[k] >= arr[k + 1]) {
                k--;
            }

            int distance = (j - 1) - (k + 1) + 1;
            if (distance > maxDistance) {
                maxDistance = distance;
            }
            i = j;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[][] twoDArr = {
                { 4, 3, 2, 1, 2, 3, 4 },
                { 1, 2, 3, 4 },
                { 1, 1 },
                { 1, 1, 2, 5, 1, 3, 1, 2, 6 },
                { 1, 5, 5, 2, 6 },
                { 9, 1, 4, 3, 2, 5, 7, 8, 1, 3, 1, 5, 8 }
        };
        for (int[] arr : twoDArr) {
            System.out.println();
            ArrayUtil.printArray(arr);
            System.out.println("Max distance = " + largestDistanceJumpFogs(arr));
        }
    }
}