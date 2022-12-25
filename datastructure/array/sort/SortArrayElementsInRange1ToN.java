package datastructure.array.sort;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * Sort the given array, elements are in range between 1 to N.
 * 
 * @author Manjunath Asundi
 */
public class SortArrayElementsInRange1ToN {

    private static void sortArrayElementsInRange1ToN(int[] arr) {
        int index = 0;
        while (index < arr.length) {

            int value = arr[index] - 1;

            if (arr[value] != arr[index]) {
                AlgoUtils.swapByIndex(arr, index, value);
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] twoDArr = {
                ArrayUtil.constructArrayWithinRange(AlgoUtils.random(6) + 4),
                ArrayUtil.constructArrayWithinRange(AlgoUtils.random(8) + 4),
                ArrayUtil.constructArrayWithinRange(AlgoUtils.random(10) + 4)
        };

        for (int[] arr : twoDArr) {
            ArrayUtil.printArray(arr);
            sortArrayElementsInRange1ToN(arr);
            ArrayUtil.printArray(arr);
            System.out.println();
        }
    }
}