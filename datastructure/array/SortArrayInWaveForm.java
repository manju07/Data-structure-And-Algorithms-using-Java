package datastructure.array;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * Sort array in the wave form
 * such that largest, smallest, largest, smallest, ....
 * 
 * @author Manjunath Asundi
 */
public class SortArrayInWaveForm {

    private static void sortArrayInWaveForm(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (i > 0 && arr[i] < arr[i - 1]) {
                AlgoUtils.swapByIndex(arr, i, i - 1);
            }
            if (arr[i] < arr[i + 1]) {
                AlgoUtils.swapByIndex(arr, i, i + 1);
            }
            ArrayUtil.printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtil.constructRandomUniqueElementsArray();
        ArrayUtil.printArray(arr);
        sortArrayInWaveForm(arr);
        ArrayUtil.printArray(arr);
    }
}