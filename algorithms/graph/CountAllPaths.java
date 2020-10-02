package algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Manjunath Asundi 
 * Count all paths of V and U
 */
public class CountAllPaths {

    public static int dfs(int v, int u, List<LinkedList<Integer>> adjList, Boolean[] visited, int count) {
        if (v == u)
            return count + 1;
        visited[v] = true;
        LinkedList<Integer> list = adjList.get(v);
        for (int i = 0; i < list.size(); i++)
            if (visited[list.get(i)] == false)
                count = dfs(list.get(i), u, adjList, visited, count);
        return count;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        for (int uv[] : new int[][] { { 0, 4 }, { 1, 3 }, { 2, 4 } }) {
            graph.resetVisited();
            System.out.println("Count of paths between " + uv[0] + " and " + uv[1] + " = "
                    + dfs(uv[0], uv[1], graph.getAdjList(), graph.getVisited(), 0));
        }
    }
}