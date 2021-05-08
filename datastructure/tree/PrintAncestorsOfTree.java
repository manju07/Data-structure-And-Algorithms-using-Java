package datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Print all ancestors for every node
 * @author Manjunath Asundi
 */
public class PrintAncestorsOfTree {

    public static void findAncestorsOfTree(Node<Integer> tree, Map<Integer, List<Integer>> map, List<Integer> list) {
        if (tree == null)
            return;
        map.put(tree.data, list);
        List<Integer> newList = new ArrayList<>(list);
        newList.add(tree.data);
        findAncestorsOfTree(tree.left, map, new ArrayList<>(newList));
        findAncestorsOfTree(tree.right, map, new ArrayList<>(newList));
    }

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(1);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(3);

        tree.left.left = new Node<Integer>(4);
        tree.left.right = new Node<Integer>(5);

        tree.right.left = new Node<Integer>(6);
        tree.right.right = new Node<Integer>(7);

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        findAncestorsOfTree(tree, map, list);

        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}