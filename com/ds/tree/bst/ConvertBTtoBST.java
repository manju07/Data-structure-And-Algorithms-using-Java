package com.ds.tree.bst;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ds.tree.Node;

/**
 * InnerConvertBTtoBST
 */
class InnerConvertBTtoBST {

    static void inOrderTraversal(Node<Integer> tree, List<Integer> list) {
        if (tree == null)
            return;
        inOrderTraversal(tree.left, list);
        list.add(tree.data);
        inOrderTraversal(tree.right, list);
    }

    static void convertToBSTUtil(Node<Integer> tree, LinkedList<Integer> list) {
        if (tree == null)
            return;
        convertToBSTUtil(tree.left, list);
        tree.data = list.pop();
        convertToBSTUtil(tree.right, list);
    }

    static void traverseInOrder(Node<Integer> tree) {
        if (tree == null)
            return;
        traverseInOrder(tree.left);
        System.out.print(tree.data + " ");
        traverseInOrder(tree.right);
    }

    static void convertBTtoBST(Node<Integer> tree) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        inOrderTraversal(tree, list);
        Collections.sort(list);
        convertToBSTUtil(tree, list);
    }
}

/**
 * ConvertBTtoBST
 * link https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
 */
public class ConvertBTtoBST {
    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(10);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(7);
        tree.left.left = new Node<Integer>(8);
        tree.left.right = new Node<Integer>(4);
        System.out.print("BT:");
        InnerConvertBTtoBST.traverseInOrder(tree);
        System.out.println();
        InnerConvertBTtoBST.convertBTtoBST(tree);
        System.out.print("BST:");
        InnerConvertBTtoBST.traverseInOrder(tree);
        System.out.println();
    }
}