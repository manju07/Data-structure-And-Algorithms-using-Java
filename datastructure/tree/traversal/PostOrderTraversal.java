package datastructure.tree.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Print post order traversal from given In and Pre orders.
 * 
 * @author Manjunath Asundi
 */
public class PostOrderTraversal {

    static int preIndex = 0;

    public static void printPostOrder(int in[], int pre[], int startInIndex, int endInIndex,
            Map<Integer, Integer> map) {
        if (startInIndex > endInIndex)
            return;
        int index = map.get(pre[preIndex++]);
        printPostOrder(in, pre, startInIndex, index - 1, map);
        printPostOrder(in, pre, index + 1, endInIndex, map);
        System.out.print(in[index] + " ");
    }

    public static void printPostOrderTraversal(int in[], int pre[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        printPostOrder(in, pre, 0, in.length - 1, map);
    }

    public static void main(String[] args) {
        int in[] = { 4, 2, 5, 1, 3, 6 };
        int pre[] = { 1, 2, 4, 5, 3, 6 };
        printPostOrderTraversal(in, pre);
        System.out.println();
    }
}