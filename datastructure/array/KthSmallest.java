package datastructure.array;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * Find kth smallest element in the given unsorted array
 * @author Manjunath Asundi
 */
public class KthSmallest {

    private static void buildMaxHeap(int arr[], int root, int n) {
        int largest = root;
        int left = (root * 2) + 1;
        int right = (root * 2) + 2;
        if (left <= n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right <= n && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            buildMaxHeap(arr, largest, n);
        }
    }

    private static int heapify(int[] arr, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--) {
            buildMaxHeap(arr, i, k - 1);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                AlgoUtils.swapByIndex(arr, i, 0);
                buildMaxHeap(arr, 0, k - 1);
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        int[][] twoDArr = new int[][] {
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                ArrayUtil.constructRandomArray(),
                ArrayUtil.constructRandomUniqueElementsArray(),
                { 1, 11, 3, 4, 8, 5, 9, 7, 10 },
                { 12, 2, 13, 5, 8, 11, 9, 6, 10 },
                { 13, 3, 15, 7, 8, 9, 11, 12 },
                { 2, 4, 6, 8, 9, 3, 7 }
        };

        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            int k = AlgoUtils.random(arr.length - 1) + 1;
            System.out.println((k) + "(st/nd/rd/th) smallest number = " + heapify(arr, k));
            System.out.println();
        }
    }
}