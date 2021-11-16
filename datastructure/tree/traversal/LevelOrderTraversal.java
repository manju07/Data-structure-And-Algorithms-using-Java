package datastructure.tree.traversal;

import java.util.ArrayDeque;
import java.util.Queue;

import datastructure.tree.Node;

/**
 * Level order traversal of tree
 * 
 * @author Manjunath Asundi
 */
public class LevelOrderTraversal {

    private static void printInLevelOrderTraversal(Node<Integer> tree) {
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node<Integer> temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
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
        System.out.print("Level Order Traversal -> ");
        printInLevelOrderTraversal(node);
    }
}