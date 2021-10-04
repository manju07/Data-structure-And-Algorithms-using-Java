package algorithms.graph.shortest;

import java.util.LinkedList;
import java.util.List;

import algorithms.graph.Edge;
import algorithms.graph.Graph;

class Node {
    int vertex, distance;

    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + distance;
        result = prime * result + vertex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (distance != other.distance)
            return false;
        if (vertex != other.vertex)
            return false;
        return true;
    }
}

/**
 * @author Manjunath Asundi 
 * Find all shortest paths from source vertex to all other vertices using dijkstra's algorithm and min heap
 */
public class DijkstraUsingMinHeap {

    public static void printAllShortestPathsFromSource(int keyValue[], int sourceVertex) {
        for (int i = 0; i < keyValue.length; i++)
            System.out.println("from source vertex: " + sourceVertex + " to  destination vertex: " + i
                    + " shortest path sum:" + keyValue[i]);
    }

    public static void minHeap(Node[] list, int root, int n) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int smallest = root;
        if (left <= n && list[smallest].distance > list[left].distance)
            smallest = left;
        if (right <= n && list[smallest].distance > list[right].distance)
            smallest = right;
        if (smallest != root) {
            Node temp = list[root];
            list[root] = list[smallest];
            list[smallest] = temp;
            minHeap(list, smallest, n);
        }
    }

    private static void heapify(Node[] minHeapList, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            minHeap(minHeapList, i, n);
        }
        Node temp = minHeapList[0];
        minHeapList[0] = minHeapList[n];
        minHeapList[n] = temp;
    }

    public static void primsForShortestPath(LinkedList<LinkedList<Edge>> list, int v, int sourceVertex) {
        Boolean spSet[] = new Boolean[v];
        Node[] minHeapList = new Node[v];
        for (int i = 0; i < spSet.length; i++) {
            spSet[i] = false;
            if (i == sourceVertex)
                minHeapList[i] = new Node(i, 0);
            else
                minHeapList[i] = new Node(i, Integer.MAX_VALUE);
        }
        int n = minHeapList.length - 1;

        List<Node> resultList = new LinkedList<Node>();
        while (n != 0) {
            heapify(minHeapList, n);
            Node node = minHeapList[n--];
            int vertex = node.vertex;
            int distance = node.distance;
            if (spSet[vertex])
                continue;
            resultList.add(node);
            spSet[vertex] = true;
            LinkedList<Edge> linkedList = list.get(vertex);
            for (int j = 0; j < linkedList.size(); j++) {
                Edge edge = linkedList.get(j);
                int destination = edge.getDestination(), weight = edge.getWeight();
                if (spSet[destination] == false) {
                    for (int i = 0; i <= n; i++) {
                        if (destination == minHeapList[i].vertex) {
                            int sum = distance + weight;
                            if (minHeapList[i].distance > sum)
                                minHeapList[i].distance = sum;
                        }
                    }
                }
            }
        }
        for (Node node : resultList)
            System.out.println("from " + sourceVertex + " vertex to " + node.vertex + " destination vertex, shortest path sum:"
                    + node.distance);
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

        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 5, 2);

        primsForShortestPath(graph.getEdgesList(), graph.getV(), 0);
    }
}