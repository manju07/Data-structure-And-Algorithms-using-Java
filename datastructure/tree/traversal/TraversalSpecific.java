package datastructure.tree.traversal;

import java.util.ArrayDeque;
import java.util.Queue;

import datastructure.tree.Node;

/**
 * Traverse tree in specific order
 * 
 * @author Manjunath Asundi
 */
public class TraversalSpecific {

    private static void traverseInSpecificOrder(Node<Integer> tree) {
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        System.out.print(tree.data + " ");
        if (tree.left != null)
            queue.add(tree.left);
        if (tree.right != null)
            queue.add(tree.right);
        while (!queue.isEmpty()) {
            Node<Integer> temp1 = queue.poll();
            Node<Integer> temp2 = queue.poll();
            System.out.print(temp1.data + " " + temp2.data + " ");
            if (temp1.left != null && temp1.right != null && temp2.left != null && temp2.right != null) {
                queue.add(temp1.left);
                queue.add(temp2.right);
                queue.add(temp1.right);
                queue.add(temp2.left);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>(1);
        node.left = new Node<Integer>(2);
        node.right = new Node<Integer>(3);
        node.left.left = new Node<Integer>(4);
        node.left.right = new Node<Integer>(5);
        node.right.left = new Node<Integer>(6);
        node.right.right = new Node<Integer>(7);

        node.left.left.left = new Node<Integer>(8);
        node.left.left.right = new Node<Integer>(9);

        node.left.right.left = new Node<Integer>(10);
        node.left.right.right = new Node<Integer>(11);

        node.right.left.left = new Node<Integer>(12);
        node.right.left.right = new Node<Integer>(13);

        node.right.right.left = new Node<Integer>(14);
        node.right.right.right = new Node<Integer>(15);

        System.out.print("Print in specific order level -> ");
        traverseInSpecificOrder(node);
    }
}