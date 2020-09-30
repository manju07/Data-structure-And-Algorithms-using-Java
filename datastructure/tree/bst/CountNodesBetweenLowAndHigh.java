package datastructure.tree.bst;

import datastructure.tree.Node;

/**
 * @author Manjunath Asundi 
 * Given a binary search tree, and a lower and upper
 * bound, find the number of nodes in the tree within that bound.
 */
public class CountNodesBetweenLowAndHigh {

    public static int getCount(Node<Integer> tree, int low, int high) {
        if (tree == null)
            return 0;
        if (low <= tree.data && tree.data <= high)
            return 1 + getCount(tree.left, low, high) + getCount(tree.right, low, high);
        else if (tree.data < high)
            return getCount(tree.right, low, high);
        return getCount(tree.left, low, high);
    }

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(8);
        tree.left = new Node<Integer>(6);
        tree.right = new Node<Integer>(15);

        tree.left.left = new Node<Integer>(3);
        tree.left.right = new Node<Integer>(5);
        tree.right.left = new Node<Integer>(13);
        tree.right.right = new Node<Integer>(18);

        tree.left.left.left = new Node<Integer>(1);
        tree.left.left.right = new Node<Integer>(4);

        tree.right.right.left = new Node<Integer>(17);
        tree.right.right.right = new Node<Integer>(20);
//          8
//         / \
//        6   15
//       / \  / \
//      3   5 13 18
//     / \       / \
//    1   4     17  20
        for (int[] arr : new int[][] { { 1, 4 }, { 8, 15 }, { 13, 20 } })
            System.out.println(
                    "Nodes count between " + arr[0] + " and " + arr[1] + " = " + getCount(tree, arr[0], arr[1]));
    }
}