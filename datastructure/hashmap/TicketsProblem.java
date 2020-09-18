package datastructure.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Manjunath Asundi
 * N people are standing in the queue to buy movie tickets and given q queries
 * each query have 2 values called E, X
 * if E == 1, 1st personal standing in the queue buy a ticket and come out( consider x == 0)
 * if E == 2, X person losts patience for waiting, he will come out of the queue
 * if E == 3, find the position of the X person in the queue 
 * at last return sum of the third queries
 * @return sum of all 3rd query as a result    
 */
public class TicketsProblem {
    public static int sumOfPositions(int n, int q, int[] queries[]) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, i);
        int firstPoint = 1;
        for (int i = 0; i < queries.length; i++) {
            int e = queries[i][0];
            int x = queries[i][1];
            if (e == 1) {
                map.remove(firstPoint++);
                for (int j = firstPoint; j <= n; j++)
                    if (map.containsKey(j))
                        map.put(j, map.get(j) - 1);
            } else if (e == 2) {
                if (x == firstPoint)
                    firstPoint++;
                map.remove(x++);
                for (int j = x; j <= n; j++)
                    if (map.containsKey(j))
                        map.put(j, map.get(j) - 1);
            } else
                sum += map.containsKey(x) ? map.get(x) : 0;

        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10, q = 5, queries[][] = { { 2, 3 }, { 1, 0 }, { 3, 7 }, { 2, 6 }, { 3, 9 } };
        System.out.println("Sum of positions = " + sumOfPositions(n, q, queries));
    }
}