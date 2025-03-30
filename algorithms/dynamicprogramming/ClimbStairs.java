package algorithms.dynamicprogramming;

import java.util.Arrays;

/**
 * Input: n = 1
 * Output: 1
 * Explanation: There is only one way to climb 1 stair.
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to reach 2th stair: {1, 1} and {2}.
 * 
 * 
 * Input: n = 4
 * Output: 5
 * 1, 1, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 1, 1
 * 2, 2
 * Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2},
 * {2, 1, 1}, {1, 2, 1} and {2, 2}.
 * 
 */
public class ClimbStairs {

    public static int numberOfWaysToReachN(int n) {
        if (n == 0 || n == 1)
            return 1;
        return numberOfWaysToReachN(n - 1) + numberOfWaysToReachN(n - 2);
    }

    // Memoization
    public static int numberOfWaysToReachN_Memoization(int n, int[] mem) {
        if (n == 0 || n == 1)
            return 1;

        if (mem[n] != -1)
            return mem[n];

        mem[n] = numberOfWaysToReachN(n - 1) + numberOfWaysToReachN(n - 2);
        return mem[n];
    }

    // Tabulation
    public static int numberOfWaysToReachN_Tabulation(int n) {
        if (n == 0 || n == 1)
            return 1;

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // n = 4
        // base=1, firstStep=1, 2, 3, 5
        return dp[n];
    }

    // Tabulation with space reduced
    public static int numberOfWaysToReachN_Tabulation_SpaceReduced(int n) {
        if (n == 0 || n == 1)
            return 1;

        int result1 = 1, result2 = 1;
        
        for (int i = 2; i <= n; i++) {
            int result = result1 + result2;
            result2 = result1;
            result1 = result;
        }

        // n = 4
        // base=1, firstStep=1, 2, 3, 5
        return result1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfWaysToReachN(n));

        int mem[] = new int[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(numberOfWaysToReachN_Memoization(n, mem));

        System.out.println(numberOfWaysToReachN_Tabulation(n));
        System.out.println(numberOfWaysToReachN_Tabulation_SpaceReduced(n));
    }
}
