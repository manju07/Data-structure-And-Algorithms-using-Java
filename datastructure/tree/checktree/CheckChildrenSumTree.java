package datastructure.tree.checktree;

import datastructure.tree.Node;

/**
 * @author Manjunath Asundi 
 */
class CheckChildrenSumOfTree {
    static int checkChildrenSumToRoot(Node<Integer> tree) {
        if (tree == null)
            return 0;
        if (tree.left == null && tree.right == null)
            return tree.data;
        int lSum = checkChildrenSumToRoot(tree.left);
        int rSum = checkChildrenSumToRoot(tree.right);
        if (lSum == -1 || rSum == -1)
            return -1;
        if (tree.data == (lSum + rSum))
            return tree.data;
        return -1;
    }
}

/**
 * CheckChildrenSumTree
 */
public class CheckChildrenSumTree {

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(10);
        tree.left = new Node<Integer>(8);
        tree.right = new Node<Integer>(2);
        tree.left.left = new Node<Integer>(3);
        tree.left.right = new Node<Integer>(5);
        tree.right.left = new Node<Integer>(2);

        if (CheckChildrenSumOfTree.checkChildrenSumToRoot(tree) == -1)
            System.out.println("Children sum property failed");
        else
            System.out.println("Children sum property got success");
    }
}