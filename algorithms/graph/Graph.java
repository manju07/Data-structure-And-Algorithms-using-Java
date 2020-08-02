package algorithms.graph;

import java.util.LinkedList;

public class Graph {
    private int v;
    private LinkedList<LinkedList<Integer>> adjList;

    public Graph() {

    }

    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<Integer>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public int getV() {
        return this.v;
    }

    public LinkedList<LinkedList<Integer>> getAdjList() {
        return this.adjList;
    }
}
