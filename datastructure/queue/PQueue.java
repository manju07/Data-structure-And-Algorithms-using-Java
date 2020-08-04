package datastructure.queue;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * @author Manjunath Asundi 
 */
public class PQueue {
    public static void main(String args[]) {
        Queue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        pq.add(17);
        pq.add(4);
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(10);
        pq.add(14);
        while(pq.size()!=0) {
            System.out.print(pq.poll()+" ");
        }
    }
}