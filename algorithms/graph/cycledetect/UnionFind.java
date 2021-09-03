package algorithms.graph.cycledetect;

import algorithms.graph.Edge;

/**
 * @author Manjunath Asundi 
 * Union-Find algorithm to detect cycle in the graph
 */
public class UnionFind {
    public static void union(int parent[], int u, int v) {
        parent[u] = v;
    }

    public static int find(int parent[], int v) {
        if (parent[v] == -1)
            return v;
        return find(parent, parent[v]);
    }

    public static Boolean isCycleDetected(int V, int E, Edge[] edges) {
        int parent[] = new int[V];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;

        for (int i = 0; i < E; i++) {
            int s = find(parent, edges[i].getSource());
            int d = find(parent, edges[i].getDestination());
            if (s == d)
                return true;
            union(parent, s, d);
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        Edge[] edges = new Edge[3];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new Edge();

        edges[0].setSource(0);
        edges[0].setDestination(1);

        edges[1].setSource(1);
        edges[1].setDestination(2);

        edges[2].setSource(2);
        edges[2].setDestination(1);
        if (isCycleDetected(V, E, edges))
            System.out.println("Cycle Detected");
        else
            System.out.println("There is no cycle found");

    }
}