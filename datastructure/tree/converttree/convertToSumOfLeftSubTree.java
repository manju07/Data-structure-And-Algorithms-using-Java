package datastructure.tree.converttree;

import datastructure.tree.Node;

/**
 * convert To Sum Of Left SubTree
 * @author Manjunath Asundi
 */
class SumOfLeftTree {
    static int constructSumTree(Node<Integer> tree) {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return tree.data;
        int lSum = constructSumTree(tree.left);
        int rSum = constructSumTree(tree.right);
        tree.data = tree.data + lSum;
        return tree.data + rSum;
    }
}

/**
 * convertToSumOfLeftSubTree
 */
public class convertToSumOfLeftSubTree {

    static void printInPreOrder(Node<Integer> tree) {
        if (tree == null)
            return;
        System.out.print(tree.data + " ");
        printInPreOrder(tree.left);
        printInPreOrder(tree.right);
    }

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(1);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(3);
        tree.left.left = new Node<Integer>(4);
        tree.left.right = new Node<Integer>(5);
        tree.right.right = new Node<Integer>(6);
        System.out.println("Pre Order Before constructing sum of left tree");
        printInPreOrder(tree);
        SumOfLeftTree.constructSumTree(tree);
        System.out.println("\nPre order after constructing sum of left tree");
        printInPreOrder(tree);
    }
}