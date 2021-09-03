package algorithms.graph;

import java.util.LinkedList;

/**
 * @author Manjunath Asundi
 */
public class Graph {
    private int v;
    private LinkedList<LinkedList<Integer>> adjList;
    private Boolean visited[];
    private LinkedList<LinkedList<Edge>> edgesList;

    public Graph() {

    }

    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList<LinkedList<Integer>>();
        edgesList = new LinkedList<LinkedList<Edge>>();
        visited = new Boolean[this.v];
        for (int i = 0; i < v; i++) {
            adjList.add(new LinkedList<Integer>());
            edgesList.add(new LinkedList<Edge>());
            visited[i] = false;
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public void addEdge(int u, int v, int w) {
        edgesList.get(u).add(new Edge(u, v, w));
    }

    public int getV() {
        return this.v;
    }

    public LinkedList<LinkedList<Integer>> getAdjList() {
        return this.adjList;
    }

    public Boolean[] getVisited() {
        return visited;
    }

    public void resetVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }
}
