package com.ds.tree.bst;

import com.ds.tree.Node;

/**
 * InnerKthSmallest
 */
class InnerKthSmallest {
    static int count = 0;

    static void findKthSmallest(Node<Integer> tree, int k) {
        if (tree == null)
            return;
        findKthSmallest(tree.left, k);
        count++;
        if (count == k) {
            System.out.println(tree.data);
            return;
        }
        findKthSmallest(tree.right, k);
    }
}

/**
 * KthSmallest link
 * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 */
public class KthSmallest {
    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(20);
        tree.left = new Node<Integer>(8);
        tree.right = new Node<Integer>(22);
        tree.left.left = new Node<Integer>(4);
        tree.left.right = new Node<Integer>(12);
        tree.left.right.left = new Node<Integer>(10);
        tree.left.right.right = new Node<Integer>(14);
        int k = 6;
        System.out.print(k + "th smallest element is: ");
        InnerKthSmallest.findKthSmallest(tree, k);
    }
}