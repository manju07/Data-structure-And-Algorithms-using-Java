package com.ds.tree.constructtree;
import com.ds.tree.Node;
class BuildTree {
    static int preIndex = 0;

    static Node<Character> buildTree(char preOrder[], char inOrder[], int inStart, int inEnd) {
        if (inStart > inEnd || preIndex == preOrder.length)
            return null;

        Node<Character> tNode = new Node<Character>(preOrder[preIndex]);
        int inIndex = search(preOrder, inOrder, inStart, inEnd);
        preIndex++;
        tNode.left = buildTree(preOrder, inOrder, inStart, inIndex - 1);
        tNode.right = buildTree(preOrder, inOrder, inIndex + 1, inEnd);
        return tNode;
    }

    static int search(char preOrder[], char inOrder[], int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preIndex])
                return i;
        }
        return -1;
    }

    static void printTreeInPostOrder(Node<Character> tree) {
        if (tree == null)
            return;
        printTreeInPostOrder(tree.left);
        printTreeInPostOrder(tree.right);
        System.out.print(tree.data + " ");
    }
}

/**
 * InAndPreorder
 */
public class InAndPreorder {
    public static void main(String[] args) {
        char inOrder[] = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char preOrder[] = { 'A', 'B', 'D', 'E', 'C', 'F' };
        Node<Character> tree = BuildTree.buildTree(preOrder, inOrder, 0, inOrder.length - 1);
        System.out.println("Printing tree in Postorder:");
        BuildTree.printTreeInPostOrder(tree);
    }
}