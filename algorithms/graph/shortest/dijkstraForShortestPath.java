package algorithms.graph.shortest;

import java.util.LinkedList;

import algorithms.graph.Edge;
import algorithms.graph.Graph;

/**
 * @author Manjunath Asundi 
 * Find all shortest paths from source vertex to all other vertices using dijkstra's algorithm
 */
public class dijkstraForShortestPath {

    public static void printAllShortestPathsFromSource(int keyValue[]) {
        for (int i = 1; i < keyValue.length; i++) 
            System.out.println("vertex: " + i + " shortest path sum:" + keyValue[i]);
    }

    public static int findMinValueKey(int keyValue[], Boolean spSet[]) {
        int minValue = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < spSet.length; i++) {
            if (spSet[i] == false && keyValue[i] < minValue) {
                minValue = keyValue[i];
                index = i;
            }
        }
        return index;
    }

    public static void primsForShortestPath(LinkedList<LinkedList<Edge>> list, int v) {
        Boolean spSet[] = new Boolean[v];
        int keyValue[] = new int[v];
        for (int i = 0; i < spSet.length; i++) {
            spSet[i] = false;
            keyValue[i] = Integer.MAX_VALUE;
        }
        keyValue[0] = 0;
        for (int i = 0; i < v; i++) {
            int vertex = findMinValueKey(keyValue, spSet);
            spSet[vertex] = true;
            LinkedList<Edge> linkedList = list.get(vertex);
            for (int j = 0; j < linkedList.size(); j++) {
                Edge edge = linkedList.get(j);
                int dest = edge.getDestination(), weight = edge.getWeight();
                int sum = keyValue[vertex] + weight;
                if (spSet[dest] == false)
                    if (keyValue[dest] > sum)
                        keyValue[dest] = sum;
            }
        }
        printAllShortestPathsFromSource(keyValue);
    }

    public static void main(String[] args) {
        int v = 9;
        Graph graph = new Graph(v);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);

        graph.addEdge(1, 0, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(1, 2, 8);

        graph.addEdge(7, 0, 8);
        graph.addEdge(7, 8, 6);
        graph.addEdge(7, 6, 1);

        graph.addEdge(2, 1, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 5, 4);

        graph.addEdge(8, 2, 2);
        graph.addEdge(8, 6, 6);
        graph.addEdge(8, 7, 7);

        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 2, 7);
        graph.addEdge(3, 5, 14);

        graph.addEdge(5, 4, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(5, 3, 14);
        graph.addEdge(5, 2, 4);

        graph.addEdge(4, 3, 9);
        graph.addEdge(4, 5, 10);

        primsForShortestPath(graph.getEdgesList(), graph.getV());
    }
}