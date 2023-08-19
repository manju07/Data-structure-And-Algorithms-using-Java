package algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @apiNote Find nth Fibbonacci number by Dynamic programming 
 * @author Manjunath Asundi
 */
public class Fibbonacci {
    public static int fibbonacciOfN(int n, Map<Integer, Integer> map) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int d = fibbonacciOfN(n - 1, map) + fibbonacciOfN(n - 2, map);
        map.put(n, d);
        return d;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : new int[] { 10, 7, 5, 6 })
            System.out.println(n + "th fibbonacci number is " + fibbonacciOfN(n, map));
    }
}