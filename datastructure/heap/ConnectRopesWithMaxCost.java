package datastructure.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ConnectRopesWithMinCost
 * @apiNote Connect N ropes with maximum cost
 * @author Manjunath Asundi
 */
public class ConnectRopesWithMaxCost {

    public static int minCostToConnectRopes(int arr[]) {
        Queue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
        int minCost = 0;
        for (int i = 0; i < arr.length; i++)
            queue.add(arr[i]);
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            int sum = a + b;
            minCost += sum;
            queue.add(sum);
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(minCostToConnectRopes(new int[] { 4, 3, 2, 6 }));
    }
}