package algorithms.graph.mst;

import java.util.LinkedList;
import algorithms.graph.Edge;

/**
 * @author Manjunath Asundi 
 * Prims algorithm to find MST
 */
public class Prims {

    public static void addEdge(LinkedList<LinkedList<Edge>> list, int u, int v, int w) {
        list.get(u).add(new Edge(u, v, w));
    }

    public static int minKey(int keyValues[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < mstSet.length; i++) {
            if (keyValues[i] < min && mstSet[i] == false) {
                min = keyValues[i];
                index = i;
            }
        }
        return index;
    }

    public static void print(LinkedList<LinkedList<Edge>> list, int parent[]) {
        for (int i = 1; i < parent.length; i++) {
            LinkedList<Edge> linkedList = list.get(parent[i]);
            for (Edge edge : linkedList)
                if (edge.getDestination() == i)
                    System.out.println(parent[i] + " - " + i + " weight: " + edge.getWeight());
        }
    }

    public static void primsForMST(LinkedList<LinkedList<Edge>> list, int v) {
        Boolean mstSet[] = new Boolean[v];
        int keyValues[] = new int[v];
        int parent[] = new int[v];
        for (int i = 0; i < mstSet.length; i++) {
            mstSet[i] = false;
            keyValues[i] = Integer.MAX_VALUE;
        }
        keyValues[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < v - 1; i++) {
            int vertex = minKey(keyValues, mstSet);
            mstSet[vertex] = true;
            LinkedList<Edge> adjList = list.get(vertex);
            for (Edge edge : adjList) {
                int dest = edge.getDestination(), weight = edge.getWeight();
                if (mstSet[dest] == false && weight < keyValues[dest]) {
                    keyValues[dest] = weight;
                    parent[dest] = vertex;
                }
            }
        }
        print(list, parent);
    }

    public static void main(String[] args) {
        int v = 5;

        LinkedList<LinkedList<Edge>> list = new LinkedList<LinkedList<Edge>>();
        for (int i = 0; i < v; i++)
            list.add(new LinkedList<Edge>());

        addEdge(list, 0, 1, 2);
        addEdge(list, 0, 3, 6);

        addEdge(list, 1, 0, 2);
        addEdge(list, 1, 2, 3);
        addEdge(list, 1, 4, 5);
        addEdge(list, 1, 3, 8);

        addEdge(list, 2, 1, 3);
        addEdge(list, 2, 4, 7);

        addEdge(list, 3, 0, 6);
        addEdge(list, 3, 1, 8);
        addEdge(list, 3, 4, 9);

        addEdge(list, 4, 1, 5);
        addEdge(list, 4, 3, 9);
        addEdge(list, 4, 2, 7);

        primsForMST(list, v);
    }
}