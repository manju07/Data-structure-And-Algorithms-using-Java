package algorithms.dynamicprogramming;

/**
 * @author Manjunath Asundi 
 */
class InnerLargestSumContiguous {
    static int largestContiguousSumArray(int arr[]) {
        int currentMax = 0, maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax += arr[i];
            if (currentMax < 0)
                currentMax = 0;
            if (currentMax > maxSum)
                maxSum = currentMax;
        }
        return maxSum;
    }

}

/**
 * LargestSumContiguous
 */
public class LargestSumContiguous {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Largset contiguous sum sub array: " + InnerLargestSumContiguous.largestContiguousSumArray(arr));
    }
}