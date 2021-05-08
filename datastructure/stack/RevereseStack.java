package datastructure.stack;

import java.util.Stack;

/**
 * Reverse stack without using extra memory
 * @category Stack
 * @author Manjunath Asundi
 */
public class RevereseStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        reverse(stack);
        reverseStackUtil(stack, temp);
    }

    public static void reverseStackUtil(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int temp = stack.pop();
        reverseStackUtil(stack, data);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverse(stack);
        System.out.print("After reversing stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}