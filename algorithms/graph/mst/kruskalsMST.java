package algorithms.graph.mst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import algorithms.graph.Edge;

/**
 * Subset class
 */
class Subset {
    int parent, rank;
}

/**
 * @author Manjunath Asundi 
 * Constructing minimum spanning tree by kruskals algorithm 
 */
public class kruskalsMST {

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

    public static void KruskalMST(Edge[] edges, int V, int E) {

        Arrays.sort(edges, (obj1, obj2) -> obj1.getWeight() - obj2.getWeight());

        Subset subset[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        int totalWeight = 0;
        List<Edge> resultEdges = new LinkedList<Edge>();

        for (int i = 0; i < E; i++) {
            int s = find(subset, edges[i].getSource());
            int d = find(subset, edges[i].getDestination());
            if (s != d) {
                resultEdges.add(edges[i]);
                totalWeight += edges[i].getWeight();
                union(subset, s, d);
            }
        }
        System.out.println("Edges are -> ");
        ;
        for (Edge edge : resultEdges) 
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        System.out.println("Total weight of MST is -> " + totalWeight);
    }

    public static void main(String[] args) {
        int V = 4, E = 5;
        Edge[] edges = new Edge[E];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new Edge();

        edges[0].setSource(0);
        edges[0].setDestination(1);
        edges[0].setWeight(10);

        edges[1].setSource(0);
        edges[1].setDestination(2);
        edges[1].setWeight(6);

        edges[2].setSource(0);
        edges[2].setDestination(3);
        edges[2].setWeight(5);

        edges[3].setSource(1);
        edges[3].setDestination(3);
        edges[3].setWeight(15);

        edges[4].setSource(2);
        edges[4].setDestination(3);
        edges[4].setWeight(4);

        KruskalMST(edges, V, E);
    }
}