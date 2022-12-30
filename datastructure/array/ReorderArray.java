package datastructure.array;

import util.AlgoUtils;
import util.ArrayUtil;

/**
 * Reorder an array according to given indexes
 * @author Manjunath Asundi
 */
public class ReorderArray {
    private static void reorderAnArray(int dataArr[], int indexArr[]) {
        if (dataArr == null || indexArr == null || indexArr.length != dataArr.length)
            return;
        int index = 0;
        int n = dataArr.length;
        while (index < n) {
            int indexValue = indexArr[index];
            if (indexValue != index) {
                AlgoUtils.swapByIndex(indexArr, index, indexValue);
                AlgoUtils.swapByIndex(dataArr, index, indexValue);
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] twoDDataArr = {
                { 10, 11, 12 },
                { 50, 40, 70, 60, 90 }
        };
        int[][] twoDIndexArr = {
                { 1, 0, 2 },
                { 3, 0, 4, 1, 2 }
        };
        for (int i = 0; i < twoDIndexArr.length; i++) {
            System.out.println("\n\nBefore");
            ArrayUtil.printArray(twoDDataArr[i]);
            ArrayUtil.printArray(twoDIndexArr[i]);
            reorderAnArray(twoDDataArr[i], twoDIndexArr[i]);
            System.out.println("\nAfter");
            ArrayUtil.printArray(twoDDataArr[i]);
            ArrayUtil.printArray(twoDIndexArr[i]);
        }

    }
}