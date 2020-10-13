package algorithms.graph;

import java.util.LinkedList;

/**
 * @author Manjunath Asundi
 * Max cable length between of any 2 vertices
 */

/**
 * MaxLength
 */
class MaxLength {
    int maxCableLength = 0;
}

public class LongestPathBetweenPair {

    public static void findLongestPathBetween2Pairs(int source, LinkedList<LinkedList<Edge>> aList, Boolean[] visited,
            int prevLength, MaxLength maxLength) {
        visited[source] = true;
        int lengthSum = 0;
        LinkedList<Edge> linkedList = aList.get(source);
        for (int i = 0; i < linkedList.size(); i++) {
            Edge edge = linkedList.get(i);
            if (!visited[edge.getDestination()]) {
                lengthSum = prevLength + edge.getWeight();
                findLongestPathBetween2Pairs(edge.getDestination(), aList, visited, lengthSum, maxLength);
            }
            if (lengthSum > maxLength.maxCableLength)
                maxLength.maxCableLength = lengthSum;
        }
    }

    public static void resetVisited(Boolean[] visited) {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        LinkedList<LinkedList<Edge>> adjList = new LinkedList<LinkedList<Edge>>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new LinkedList<Edge>());

        adjList.get(0).add(new Edge(0, 1, 3));
        adjList.get(1).add(new Edge(1, 0, 3));

        adjList.get(1).add(new Edge(1, 2, 4));
        adjList.get(2).add(new Edge(2, 1, 4));

        adjList.get(1).add(new Edge(1, 5, 2));
        adjList.get(5).add(new Edge(5, 1, 2));

        adjList.get(5).add(new Edge(5, 3, 6));
        adjList.get(3).add(new Edge(3, 5, 6));

        adjList.get(5).add(new Edge(5, 4, 7));
        adjList.get(4).add(new Edge(4, 5, 7));

        Boolean[] visited = new Boolean[vertices];
        MaxLength maxLength = new MaxLength();
        for (int i = 0; i < vertices; i++) {
            resetVisited(visited);
            findLongestPathBetween2Pairs(i, adjList, visited, 0, maxLength);
        }
        System.out.println("Longest path between pair is -> " + maxLength.maxCableLength);
    }
}