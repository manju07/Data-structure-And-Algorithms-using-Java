package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * Reverse Queue
 * @author Manjunath Asundi
 */
public class ReverseQueue {

    private static void reverseQueueMethod(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int data = queue.poll();
        reverseQueueMethod(queue);
        queue.add(data);
    }

    private static void printQueue(Queue<Integer> queue) {
        Iterator<Integer> iterator = queue.iterator();
        System.out.print("Queue is -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        printQueue(queue);
        reverseQueueMethod(queue);
        printQueue(queue);
    }
}