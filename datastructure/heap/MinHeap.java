package datastructure.heap;

/**
 * MaxHeap
 * @author Manjunath Asundi 
 */
class InnerMinHeap {

    static void buildMinHeap(int arr[], int root, int n) {
        int smallest = root;
        int left = (2 * root) + 1;
        int right = (2 * root) + 2;
        if (left <= n && arr[smallest] > arr[left])
            smallest = left;
        if (right <= n && arr[smallest] > arr[right])
            smallest = right;
        if (smallest != root) {
            int temp = arr[root];
            arr[root] = arr[smallest];
            arr[smallest] = temp;
            buildMinHeap(arr, smallest, n);
        }
    }

    static void heapify(int arr[]) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--)
            buildMinHeap(arr, i, n - 1);

        for (int i = n - 1; i >= 0; i--) {
            buildMinHeap(arr, 0, i);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class MinHeap {
    public static void main(String[] args) {
        int arr[] = { 4, 10, 3, 5, 1 };
        InnerMinHeap.heapify(arr);
        InnerMinHeap.printArray(arr);
    }
}