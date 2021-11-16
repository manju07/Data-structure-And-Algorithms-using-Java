package datastructure.tree.bst;

import datastructure.tree.Node;

/**
 * @author Manjunath Asundi 
 */
class InnerGreaterSumTree {
    static int sum = 0;

    static void greaterSumTree(Node<Integer> tree) {
        if (tree == null)
            return;
        greaterSumTree(tree.right);
        int temp = tree.data;
        tree.data = sum;
        sum += temp;
        greaterSumTree(tree.left);
    }

    static void printInInOrder(Node<Integer> tree) {
        if (tree == null)
            return;
        printInInOrder(tree.left);
        System.out.print(tree.data + " ");
        printInInOrder(tree.right);
    }
}

/**
 * GreaterSumTree
 */
public class GreaterSumTree {
    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(11);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(29);
        tree.left.left = new Node<Integer>(1);
        tree.left.right = new Node<Integer>(7);
        tree.right.left = new Node<Integer>(15);
        tree.right.right = new Node<Integer>(40);
        tree.right.right.left = new Node<Integer>(35);

        System.out.print("BST:");
        InnerGreaterSumTree.printInInOrder(tree);
        InnerGreaterSumTree.greaterSumTree(tree);
        System.out.println();
        System.out.print("Greater sum tree: ");
        InnerGreaterSumTree.printInInOrder(tree);
    }
}