package algorithms.graph.topological;

import java.util.LinkedList;
import java.util.Stack;

import algorithms.graph.Graph;

/**
 * @author Manjunath Asundi 
 * Print all topological orders
 */
public class PrintTopologicalSortings {

    public static void topologicalSortingUtil(Graph graph, boolean visited[], Stack<Integer> stack, int[] inDegree) {
        int flag = 0;
        for (int i = 0; i < graph.getV(); i++) {
            if (visited[i] == false && inDegree[i] == 0) {
                stack.push(i);
                visited[i] = true;
                LinkedList<Integer> list = graph.getAdjList().get(i);
                for (Integer vertex : list)
                    inDegree[vertex]--;

                topologicalSortingUtil(graph, visited, stack, inDegree);

                stack.pop();
                visited[i] = false;
                for (Integer vertex : list)
                    inDegree[vertex]++;
                flag = 1;
            }
        }
        if (flag == 0) {
            for (int i = 0; i <stack.size(); i++)
                System.out.print(stack.get(i) + " ");
            System.out.println();
        }
    }

    public static void printAllTopologicalSortings(Graph graph) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.getV()];
        int[] inDegree = findAllVerticesInDegree(graph);
        topologicalSortingUtil(graph, visited, stack, inDegree);
    }

    static int[] findAllVerticesInDegree(Graph graph) {
        int inDegree[] = new int[graph.getV()];
        LinkedList<LinkedList<Integer>> adj = graph.getAdjList();
        for (LinkedList<Integer> list : adj)
            for (Integer vertex : list)
                inDegree[vertex]++;
        return inDegree;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        printAllTopologicalSortings(graph);
    }
}