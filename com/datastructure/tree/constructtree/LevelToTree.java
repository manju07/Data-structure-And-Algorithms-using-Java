package com.datastructure.tree.constructtree;
import com.datastructure.tree.Node;

class ConstructFromLevelOrder {
    static int levelIndex = 0;
    static Node<Integer> constructTreeFromLevelOrder(int levelOrder[], int level) {
        if(level >= levelOrder.length) return null;
        Node<Integer> tNode = new Node<Integer>(levelOrder[level]);
        tNode.left = constructTreeFromLevelOrder(levelOrder, (level*2)+1);
        tNode.right = constructTreeFromLevelOrder(levelOrder, (level*2)+2);
        return tNode;
    }

    static void printTreeInPostOrder(Node<Integer> tree) {
        if (tree == null)
            return;
        printTreeInPostOrder(tree.left);
        System.out.print(tree.data + " ");
        printTreeInPostOrder(tree.right);
    }
}

/**
 * LevelToTree
 */
public class LevelToTree {
    public static void main(String[] args) {
        int levelOrder[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        Node<Integer> tree = ConstructFromLevelOrder.constructTreeFromLevelOrder(levelOrder, 0);
        System.out.print("Post order:");
        ConstructFromLevelOrder.printTreeInPostOrder(tree);
    }
}