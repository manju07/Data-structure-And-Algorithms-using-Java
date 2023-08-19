package util;

import java.util.Random;

public class AlgoUtils {

    public static void swapByIndex(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * @apiNote Return random value between o to bound range
     * @param bound random value between 0 to bound range
     * @return integer value
     */
    public static int random(int bound) {
        return new Random().nextInt(bound);
    }
}
