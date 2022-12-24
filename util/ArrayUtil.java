package util;

import java.util.List;

/**
 * Array related Util Methods
 * 
 * @author Manjunath Asundi
 */
public class ArrayUtil<T extends Number> {

    public static void printArray(int arr[]) {
        for (int data : arr)
            System.out.print(data + " ");
        System.out.println();
    }

    public static <T> void printArray(List<T> resultArr) {
        for (T data : resultArr)
            System.out.print(data + " ");
        System.out.println();
    }

    public static <T> void printList(List<T> list) {
        for (Object object : list)
            System.out.print(object + " ");
        System.out.println();
    }
}