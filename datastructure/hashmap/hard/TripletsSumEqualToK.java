package datastructure.hashmap.hard;

import java.util.Arrays;

/**
 * Print all triplets those sum equal to K
 * 
 * @author Manjunath Asundi
 */
public class TripletsSumEqualToK {
    public static void findTripletsSumEqualToK(int arr[], int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, m = arr.length - 1;
            while (j > i && j < m) {
                if (arr[i] + arr[j] + arr[m] == k) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[m]);
                    j++;
                    m--;
                } else if (arr[i] + arr[j] + arr[m] < k)
                    j++;
                else
                    m--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] twoDArray = { { 12, 3, 6, 1, 6, 9 }, { -2, 0, 1, 1, 2 }, { -2, 0, 1, 1, 2 } };
        int kArr[] = { 24, 0, 10 };
        for (int i = 0; i < kArr.length; i++)
            findTripletsSumEqualToK(twoDArray[i], kArr[i]);
    }
}