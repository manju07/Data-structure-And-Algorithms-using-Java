package datastructure.tree.converttree;

import datastructure.tree.Node;


class SumTree {
    static int constructSumTree(Node<Integer> tree) {
        if(tree == null) return 0;
        int temp = tree.data;
        tree.data = constructSumTree(tree.left) + constructSumTree(tree.right);
        return temp + tree.data;
    }
}

/**
 * ConverstToSumTree
 */
public class ConverstToSumTree {

    static void printInPreOrder(Node<Integer> tree) {
        if(tree == null) return;
        System.out.print(tree.data+" ");
        printInPreOrder(tree.left);
        printInPreOrder(tree.right);
    } 

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(10);
        tree.left = new Node<Integer>(-2); 
        tree.right = new Node<Integer>(6);
        tree.left.left = new Node<Integer>(8);
        tree.left.left.left = new Node<Integer>(10);
        tree.left.right = new Node<Integer>(-4);
        tree.right.left = new Node<Integer>(7);
        tree.right.right = new Node<Integer>(5);
        System.out.println("Pre Order Before constructing sum tree");
        printInPreOrder(tree);
        SumTree.constructSumTree(tree);
        System.out.println("\nPre order after constructing sm tree");
        printInPreOrder(tree);
    }
}