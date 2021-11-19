package datastructure.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Max sub array sum is divisible by K
 * 
 * @author Manjunath Asundi
 */
public class LargestSubArraySumDivisibleByK {
    public static int largestSumOfSubArrayDivisibleByKUtil(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int mod = sum % k;
            if (mod == 0)
                maxLength = i + 1;
            else if (map.containsKey(mod) && (i - map.get(mod) > maxLength))
                maxLength = i - map.get(mod);
            else
                map.put(mod, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int kArr[] = { 3, 5 };
        int twoDArray[][] = new int[][] { { 2, 7, 6, 1, 4, 5 }, { -2, 2, -5, 12, -11, -1, 7 } };
        for (int i = 0; i < kArr.length; i++) {
            System.out.println("Max sum of sub array length divisible by k = "
                    + largestSumOfSubArrayDivisibleByKUtil(twoDArray[i], kArr[i]));
        }
    }
}
