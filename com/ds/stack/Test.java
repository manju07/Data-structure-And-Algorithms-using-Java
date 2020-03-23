package com.ds.stack;

import java.util.Stack;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (stack.size() != 0) {
            System.out.print(stack.pop() + " ");
        }
    }
}