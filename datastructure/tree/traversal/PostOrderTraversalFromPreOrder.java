package datastructure.tree.traversal;

/**
 * Print Post order traversal from given Pre order.
 * 
 * @author Manjunath Asundi
 */
public class PostOrderTraversalFromPreOrder {

    public static void printPostOrder(int pre[]) {
        int root = pre[0], pivot = -1;
        for (int i = 1; i < pre.length; i++)
            if (pre[i] >= root)
                pivot = i;
        for (int i = pivot - 1; i >= 0; i--) {
            System.out.print(pre[i] + " ");
        }
        for (int i = pre.length - 1; i >= pivot; i--) {
            System.out.print(pre[i] + " ");
        }
    }

    public static void main(String[] args) {
        int pre[] = { 40, 30, 32, 35, 80, 90, 100, 120 };
        printPostOrder(pre);
        System.out.println();
    }
}