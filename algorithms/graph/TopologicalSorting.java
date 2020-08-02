package algorithms.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

    public static void topologicalSortingUtil(int v, Graph graph, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        LinkedList<Integer> linkedList = graph.getAdjList().get(v);
        for (Integer data : linkedList) {
            if(!visited[data])
                topologicalSortingUtil(data, graph, visited, stack);
        }
        stack.push(v);
    }

    public static void topologicalSortingAlgo(Graph graph) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            if(!visited[i]) {
                topologicalSortingUtil(i, graph, visited, stack);
            }   
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() +" ");
        }
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
        topologicalSortingAlgo(graph);
    }
}