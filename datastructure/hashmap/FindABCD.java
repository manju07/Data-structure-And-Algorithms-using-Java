package datastructure.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manjunath Asundi 
 */
class InnerfindABCD {
    static void findFourElements(List<Integer> list) {
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (!hm.containsKey(sum))
                    hm.put(sum, Arrays.asList(i, j));
                else {
                    List<Integer> pairs = hm.get(sum);
                    System.out.println(list.get(pairs.get(0)) + " + " + list.get(pairs.get(1)) + " = " + list.get(i)
                            + " + " + list.get(j));
                    return;
                }
            }
        }
    }
}

/**
 * find A+B=C+D
 * Link https://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 */
public class FindABCD {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 7, 1, 12, 9);
        InnerfindABCD.findFourElements(list);
    }
}