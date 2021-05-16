package datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.ArrayUtil;

/**
 * Find next greater element for every element. if you don't find, print -1 to
 * that element.
 * 
 * @author Manjunath Asundi
 */
public class PrintNextGreaterElement {

    private static void findNextGreaterElement(int arr[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            if (!stack.isEmpty()) {
                int tos = stack.pop();
                while (data > tos) {
                    list.add(data);
                    if (stack.isEmpty())
                        break;
                    tos = stack.pop();
                }
                if (tos > data)
                    stack.push(data);
            }
            stack.push(data);
        }
        while (!stack.isEmpty()) {
            list.add(-1);
            stack.pop();
        }
        ArrayUtil.printList(list);
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 6, 5, 4, 3, 2, 1 };
        ArrayUtil.printArray(arr);
        findNextGreaterElement(arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.println();

        ArrayUtil.printArray(arr);
        findNextGreaterElement(arr);
        System.out.println();

        arr = new int[] { 4, 3, 2, 5, 7, 1, 9, 8 };
        ArrayUtil.printArray(arr);
        findNextGreaterElement(arr);
    }
}