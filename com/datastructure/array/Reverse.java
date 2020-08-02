package com.datastructure.array;
/**
 * Reverse
 */
public class Reverse {

    static Integer[] rotateArr(Integer arr[], Integer d) {
        reverseArr(arr, 0, d - 1);
        reverseArr(arr, d, arr.length-1);
        reverseArr(arr, 0, arr.length-1);
        return arr;
    }

    static void reverseArr(Integer arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static void printArray(Integer[] arr) {
        for (Integer integer : arr) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        Integer d = 4;
        printArray(arr);
        rotateArr(arr, d);
        printArray(arr);
    }
}