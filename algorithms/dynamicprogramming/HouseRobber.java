package algorithms.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {

    /**
     * 
     * 9, 3, 4, 6, 2, 3
     * 9 + 6 + 3
     * 
     */
    public static int maxRob(int[] arr, int index, int length) {
        if (index >= length)
            return 0;

        int rob = arr[index] + maxRob(arr, index + 2, length);
        int notRob = maxRob(arr, index + 1, length);

        return Math.max(rob, notRob);
    }

    /**
     * top down, recursive, store result to avoid the recomputation
     * 
     */
    public static int maxRob_Memoization(int[] arr, int index, int length, int mem[]) {
        if (index >= length)
            return 0;

        if (mem[index] != -1)
            return mem[index];

        int rob = arr[index] + maxRob(arr, index + 2, length);
        int notRob = maxRob(arr, index + 1, length);

        mem[index] = Math.max(rob, notRob);
        return mem[index];
    }

    /**
     * Bottom up, loop, keep base values and use to compute the next values
     * 
     */
    public static int maxRob_Tabulation(int[] arr, int index, int length) {
        if (index >= length)
            return 0;
        
        int dp[] = new int[length + 1];
        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 2; i <= length; i++) {
            dp[i] = Math.max(arr[i-1] +  dp[i-2], dp[i-1]);
        }
        //   9,  3,  4,  6,  2,  3 
        // 0, 9, 9, 13, 15, 15, 18
        return dp[length];
    }

    /**
     * Bottom up, loop, keep base values and use to compute the next values
     * 
     */
    public static int maxRob_Tabulization_Solution2(int[] arr, int index, int length) {
        if (index >= length)
            return 0;
        
        
        int firstResult = 0;
        int secondResult = arr[0];

        for (int i = 1; i < length; i++) {
            int tempResult = Math.max(arr[i] + firstResult, secondResult);
            firstResult = secondResult;
            secondResult = tempResult;
        }
        //   9,  3,  4,  6,  2,  3 
        //0, 9,  9, 13, 15, 15,  18 
        return secondResult;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 3, 4, 6, 2, 3 };
        long startTime = System.nanoTime();
        System.out.println(maxRob(arr, 0, arr.length));
        System.out.println(((System.nanoTime() - startTime)) + " nano");

        
        int mem[] = new int[arr.length];
        Arrays.fill(mem, -1);
        startTime = System.nanoTime();
        System.out.println(maxRob_Memoization(arr, 0, arr.length, mem));
        System.out.println(((System.nanoTime() - startTime)) + " nano");

        startTime = System.nanoTime();
        System.out.println(maxRob_Tabulation(arr, 0, arr.length));
        System.out.println(((System.nanoTime() - startTime)) + " nano");

        startTime = System.nanoTime();
        System.out.println(maxRob_Tabulization_Solution2(arr, 0, arr.length));
        System.out.println(((System.nanoTime() - startTime)) + " nano");
    }
}