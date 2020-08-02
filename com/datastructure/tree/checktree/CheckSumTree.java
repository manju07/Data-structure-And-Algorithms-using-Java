package com.datastructure.tree.checktree;

import com.datastructure.tree.Node;

class ChildrenSumOfTree {
    static int isRootChildrenSum(Node<Integer> tree) {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return tree.data;
        if (tree.data == (isRootChildrenSum(tree.left) + isRootChildrenSum(tree.right)))
            return tree.data * 2;
        return -1;
    }
}

/**
 * CheckSumTree
 */
public class CheckSumTree {
    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(20);
        tree.left = new Node<Integer>(8);
        tree.right = new Node<Integer>(2);
        tree.left.left = new Node<Integer>(3);
        tree.left.right = new Node<Integer>(5);
        tree.right.left = new Node<Integer>(2);

        if ((ChildrenSumOfTree.isRootChildrenSum(tree)) == -1)
            System.out.println("Tree is not it's sum of children");
        else
            System.out.println("Tree is sum of childrens");
    }
}