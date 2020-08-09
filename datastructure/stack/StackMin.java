package datastructure.stack;

import java.util.ArrayList;

/**
 * Find minimum at every stage of stack
 * 
 * @author Manjunath Asundi
 */
public class StackMin {
    private Integer minValue = Integer.MAX_VALUE;
    private ArrayList<Integer> stack = new ArrayList<Integer>();
    private ArrayList<Integer> trackMin = new ArrayList<Integer>();

    void push(int data) {
        if (data < minValue) {
            trackMin.add(data);
            minValue = data;
        }
        stack.add(data);
    }

    Integer pop() {
        if (stack.get(stack.size() - 1) == trackMin.get(trackMin.size() - 1))
            trackMin.remove(trackMin.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    Integer getMin() {
        return trackMin.get(trackMin.size() - 1);
    }

    public static void main(String[] args) {
        StackMin st1 = new StackMin();
        st1.push(4);
        st1.push(5);
        System.out.println("Get Min: " + st1.getMin());
        st1.push(1);
        st1.push(7);
        System.out.println("Get Min: " + st1.getMin());
        st1.pop();
        st1.pop();
        System.out.println("Get Min: " + st1.getMin());
        st1.pop();
        System.out.println("Get Min: " + st1.getMin());
    }
}