package datastructure.tree.constructtree;

import datastructure.tree.Node;

class Index {
    int index = 0;
}

/**
 * @author Manjunath Asundi 
 * Construct tree from given preorder
 */
public class PreOrderToTree {

    public static Node<Integer> constructtreeFromPreOrder(int pre[], Index Index, int min, int max, int size) {
        if (Index.index >= size)
            return null;
        Node<Integer> root = null;
        int data = pre[Index.index];
        if (data > min && data < max) {
            root = new Node<Integer>(data);
            Index.index++;
            if (Index.index < size) {
                root.left = constructtreeFromPreOrder(pre, Index, min, data, size);
                root.right = constructtreeFromPreOrder(pre, Index, data, max, size);
            }
        }
        return root;
    }

    public static void printInInOrder(Node<Integer> root) {
        if (root == null)
            return;
        printInInOrder(root.left);
        printInInOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int pre[] = { 10, 5, 1, 7, 40, 50 };
        Node<Integer> root = constructtreeFromPreOrder(pre, new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE,
                pre.length);
        printInInOrder(root);
        System.out.println();
    }
}