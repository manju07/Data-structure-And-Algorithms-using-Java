package datastructure.array;

/**
 * Search element in the sorted and rotated array
 * @author Manjunath Asundi
 */
public class SearchElement {

    public int binarySearch(int arr[], int low, int high, int k) {
        if (low > high)
            return -1;
        int m = (low + high) / 2;
        if (arr[m] == k)
            return m;
        if (arr[m] < k)
            return binarySearch(arr, m + 1, high, k);
        if (arr[m] > k)
            return binarySearch(arr, low, m - 1, k);
        return -1;
    }

    public int findPivotPoint(int arr[], int n) {
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (m > 0 && m < n - 1 && arr[m - 1] < arr[m] && (arr[m] > arr[m + 1])) {
                return m;
            } else if (m > 0 && arr[m - 1] < arr[m]) {
                l = m + 1;
            } else if (m < n - 1 && arr[m] < arr[m + 1]) {
                h = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 13, 18, 25, 2, 8, 10 }, k = 8;
        SearchElement searchElement = new SearchElement();
        int pivotPoint = searchElement.findPivotPoint(arr, arr.length);
        if (pivotPoint != -1) {
            int index = -1;
            if (arr[0] <= k && k <= arr[pivotPoint]) {
                index = searchElement.binarySearch(arr, 0, pivotPoint, k);
                System.out.println(index);
            } else {
                index = searchElement.binarySearch(arr, pivotPoint + 1, arr.length - 1, k);
                System.out.println(index != -1);
            }
            if (index != -1) {
                System.out.println("Index:" + index);
            }
        }

    }
}