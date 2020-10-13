package algorithms.graph.topological;

import java.util.LinkedList;
import java.util.Stack;
import algorithms.graph.Edge;

/**
 * @author Manjunath Asundi
 * Find the longest path of pair using topological sorting
 */
public class LongestPathBetweenPair {

    public static void findLongestPathForPair(int v, LinkedList<LinkedList<Edge>> listOfLists, int dist[]) {
        LinkedList<Edge> list = listOfLists.get(v);
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);
            if (dist[edge.getDestination()] < (dist[v] + edge.getWeight()))
                dist[edge.getDestination()] = dist[v] + edge.getWeight();
        }
    }

    public static void topologicalSortingUtil(int v, LinkedList<LinkedList<Edge>> adjList, Boolean visited[],
            Stack<Integer> stack) {
        visited[v] = true;
        LinkedList<Edge> list = adjList.get(v);
        for (Edge edge : list)
            if (!visited[edge.getDestination()])
                topologicalSortingUtil(edge.getDestination(), adjList, visited, stack);
        stack.push(v);
    }

    public static int findMaxDistance(int dist[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++)
            if (max < dist[i])
                max = dist[i];
        return max;
    }

    public static void main(String[] args) {
        int vertices = 6;
        LinkedList<LinkedList<Edge>> adjList = new LinkedList<LinkedList<Edge>>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new LinkedList<Edge>());

        adjList.get(0).add(new Edge(0, 1, 3));
        adjList.get(1).add(new Edge(1, 2, 4));
        adjList.get(1).add(new Edge(1, 5, 2));
        adjList.get(5).add(new Edge(5, 3, 6));
        adjList.get(5).add(new Edge(5, 4, 7));

        Boolean[] visited = new Boolean[vertices];
        int dist[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            dist[i] = 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < vertices; i++)
            if (!visited[i])
                topologicalSortingUtil(i, adjList, visited, stack);

        while (stack.size() != 0)
            findLongestPathForPair(stack.pop(), adjList, dist);

        System.out.println("Longest path of pair distance is = " + findMaxDistance(dist));
    }
}