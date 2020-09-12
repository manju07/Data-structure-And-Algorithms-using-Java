package datastructure.hashmap.hard;

import java.util.Arrays;

/**
 * @author Manjunath Asundi 
 * Print all triplets those sum equal to 0
 */
public class TripletSumEqualToZero {
    public static void findTripletsSumEqualToZero(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, m = arr.length - 1;
            while (j > i && j < m) {
                if (arr[i] + arr[j] + arr[m] == 0) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[m]);
                    j++;
                    m--;
                } else if (arr[i] + arr[j] + arr[m] < 0)
                    j++;
                else
                    m--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] twoDArray = { { 0, -1, 2, -3, 1 }, { 1, -2, 1, 0, 5 } };
        for (int i = 0; i < twoDArray.length; i++)
            findTripletsSumEqualToZero(twoDArray[i]);
    }
}