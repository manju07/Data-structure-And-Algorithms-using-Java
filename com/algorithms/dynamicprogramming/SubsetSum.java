package com.algorithms.dynamicprogramming;

/**
 * InnerSubsetSum
 */
class InnerSubsetSum {

    static boolean findSubSetSum(int arr[], int n, int sum) {
        if (n < 0)
            return false;
        if (sum == 0)
            return true;
        if (arr[n] > sum)
            return findSubSetSum(arr, n - 1, sum);
        return findSubSetSum(arr, n - 1, sum - arr[n]) || findSubSetSum(arr, n - 1, sum);
    }
}

/**
 * SubsetSum
 */
public class SubsetSum {

    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 40;
        System.out.println(sum + " is subset array: " + InnerSubsetSum.findSubSetSum(arr, arr.length - 1, sum));
    }
}