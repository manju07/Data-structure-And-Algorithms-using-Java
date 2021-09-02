package algorithms.graph.cycledetect;

import algorithms.graph.Edge;

/**
 * Subset class
 */
class Subset {
    int parent, rank;
}

/**
 * @author Manjunath Asundi 
 * Union-Find by Rank and Path algorithm to detect cycle in the graph.
 */
public class UnionFindByRankAndPath {

    public static void union(Subset[] subset, int u, int v) {
        int u1 = find(subset, u);
        int v1 = find(subset, v);
        if (subset[u1].rank > subset[v1].rank)
            subset[v1].parent = u1;
        else if (subset[u1].rank < subset[v1].rank)
            subset[u1].parent = v1;
        else {
            subset[u1].parent = v1;
            subset[v1].rank++;
        }
    }

    public static int find(Subset[] subset, int v) {
        if (subset[v].parent != v)
            subset[v].parent = find(subset, subset[v].parent);
        return subset[v].parent;
    }

    public static Boolean isCycleDetected(int V, int E, Edge[] edges) {
        Subset subset[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        for (int i = 0; i < E; i++) {
            int s = find(subset, edges[i].getSource());
            int d = find(subset, edges[i].getDestination());
            if (s == d)
                return true;
            union(subset, s, d);
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
        edges[2].setDestination(0);
        if (isCycleDetected(V, E, edges))
            System.out.println("Cycle Detected");
        else
            System.out.println("There is no cycle found");
    }
}