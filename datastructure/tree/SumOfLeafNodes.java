package datastructure.tree;

/**
 * SumOfLeafNodes
 */
public class SumOfLeafNodes {

    static int sumOfLeafNodes(Node<Integer> tree) {
        if(tree == null) return 0;
        if(tree.left == null && tree.right == null) return (int) tree.data;
        return sumOfLeafNodes(tree.left) + sumOfLeafNodes(tree.right);
    }
    public static void main(String[] args) {
        Node<Integer> tree = new Node<Integer>(1);
        tree.left = new Node<Integer>(2);
        tree.right = new Node<Integer>(3);
        tree.left.left = new Node<Integer>(4);
        tree.left.right = new Node<Integer>(5);
        tree.right.left = new Node<Integer>(6);
        tree.right.right = new Node<Integer>(7);
        System.out.println("Sum Of leaf nodes:" + sumOfLeafNodes(tree));
    }
}