package datastructure.queue;

import java.util.Stack;

/**
 * Implement queue using stack
 * 
 * @author Manjunath Asundi
 */
public class QueueUsingStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void queueUsingStack(int a[]) {

    }

    public void enque(int data) {
        stack1.push(data);
    }

    public int deque() {
        if (stack2.size() != 0)
            return stack2.pop();
        else if (stack1.size() != 0) {
            while (stack1.size() != 0)
                stack2.push(stack1.pop());
            return stack2.pop();
        }
        System.out.print("Queue is empty");
        return -1;
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        System.out.println(queue.deque());
        queue.enque(5);
        System.out.println(queue.deque());
    }
}