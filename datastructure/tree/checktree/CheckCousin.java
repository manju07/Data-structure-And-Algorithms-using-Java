package datastructure.tree.checktree;

import datastructure.tree.Node;

/**
 * @author Manjunath Asundi 
 */
class InnerCheckCousin {

    static int findLevel(Node<Integer> tree, Node<Integer> a, int level) {
        if (tree == null)
            return 0;
        if (tree == a) {
            System.out.println(a.data + " " + level);
            return level;
        }
        int r1 = findLevel(tree.left, a, level + 1);
        if (r1 != 0)
            return r1;
        return findLevel(tree.right, a, level + 1);
    }

    static boolean isSiblings(Node<Integer> tree, Node<Integer> a, Node<Integer> b) {
        if (tree == null)
            return false;
        return ((tree.left == a && tree.right == b) || (tree.left == b && tree.right == a)
                || (isSiblings(tree.left, a, b)) || (isSiblings(tree.right, a, b)));
    }

    static boolean checkCousin(Node<Integer> tree, Node<Integer> a, Node<Integer> b) {
        int l1 = findLevel(tree, a, 0);
        int l2 = findLevel(tree, b, 0);
        System.out.println("l1:" + l1 + " l2:" + l2);
        return ((l1 == l2) && (!isSiblings(tree, a, b)));
    }
}

/**
 * CheckCousin
 */
public class CheckCousin {

    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(1);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(3);
        tree.left.left = new Node<Integer>(4);
        tree.left.right = new Node<Integer>(5);
        tree.right.left = new Node<Integer>(6);
        tree.right.right = new Node<Integer>(7);
        if (InnerCheckCousin.checkCousin(tree, tree.left.left, tree.right.left))
            System.out.println("they are cousins");
        else
            System.out.println("they are not cousins");
    }
}