package com.ds.tree.constructtree;
import com.ds.tree.Node;

class ConstructTree {
    static Node<Integer> buildTree(int inOrder[], int levelOrder[], int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        if (inStart == inEnd)
            return new Node<Integer>(inOrder[inStart]);
        int inIndex = search(levelOrder, inOrder, inStart, inEnd);
        Node<Integer> tNode = new Node<Integer>(inOrder[inIndex]);
        tNode.left = buildTree(inOrder, levelOrder, inStart, inIndex - 1);
        tNode.right = buildTree(inOrder, levelOrder, inIndex + 1, inEnd);
        return tNode;
    }

    static int search(int levelOrder[], int inOrder[], int inStart, int inEnd) {
        for (int i = 0; i < levelOrder.length; i++) {
            for (int j = inStart; j <= inEnd; j++) {
                if (levelOrder[i] == inOrder[j])
                    return j;
            }
        }
        return -1;
    }

    static void printTreeInPostOrder(Node<Integer> tree) {
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
public class InAndLevel {
    public static void main(String[] args) {
        int inOrder[] = { 4, 8, 10, 12, 14, 20, 22 };
        int levelOrder[] = { 20, 8, 22, 4, 12, 10, 14 };
        Node<Integer> tree = ConstructTree.buildTree(inOrder, levelOrder, 0, inOrder.length - 1);
        ConstructTree.printTreeInPostOrder(tree);
    }
}