package algorithms.graph;

import java.util.LinkedList;

/**
 * @author Manjunath Asundi 
 * Count total number of subtrees in the given forest
 */
public class CountNumberOfTrees {

    public static void dfs(int v, Graph graph, Boolean visited[]) {
        visited[v] = true;
        LinkedList<Integer> linkedList = graph.getAdjList().get(v);
        for (Integer data : linkedList)
            if (!visited[data])
                dfs(data, graph, visited);
    }

    public static int findNumberOfTrees(Graph graph) {
        int totalTreesCount = 0;
        Boolean[] visited = graph.getVisited();
        for (int i = 0; i < graph.getV(); i++) {
            if (visited[i] == false) {
                dfs(i, graph, visited);
                totalTreesCount++;
            }
        }
        return totalTreesCount;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 2);
        graph.addEdge(3, 3);
        graph.addEdge(4, 4);
        System.out.println("Total number of trees -> " + findNumberOfTrees(graph));
    }
}