package com.ds.heap;

/**
 * InnerMinHeap
 */
class InnerMaxHeap {

    static void buildMinHeap(int arr[], int root, int n) {
        int largest = root;
        int left = (2 * root) + 1;
        int right = (2 * root) + 2;
        if (left <= n && arr[largest] < arr[left])
            largest = left;
        if (right <= n && arr[largest] < arr[right])
            largest = right;
        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            buildMinHeap(arr, largest, n);
        }
    }

    static void heapify(int arr[]) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--)
            buildMinHeap(arr, i, n-1);

        for (int i = n - 1; i >= 0; i--) {
            buildMinHeap(arr, 0, i);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }
}

/**
 * MinHeap
 */
public class MaxHeap {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 3, 5, 1 };
        InnerMaxHeap.heapify(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}