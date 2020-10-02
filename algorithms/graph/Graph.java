package algorithms.graph;

import java.util.LinkedList;

/**
 * @author Manjunath Asundi
 */
public class Graph {
    private int v;
    private LinkedList<LinkedList<Integer>> adjList;
    private Boolean visited[];

    public Graph() {

    }

    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < v; i++)
            adjList.add(new LinkedList<Integer>());
        visited = new Boolean[this.v];
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
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

    public Boolean[] getVisited() {
        return visited;
    }

    public void resetVisited() {
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
    }
}
