package util;

import java.util.List;

/**
 * Array related Util Methods
 * 
 * @author Manjunath Asundi
 */
public class ArrayUtil {

    public static void printArray(int arr[]) {
        for (int data : arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void printList(List list) {
        for (Object object : list) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}