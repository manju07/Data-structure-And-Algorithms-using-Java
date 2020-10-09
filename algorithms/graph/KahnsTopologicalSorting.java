package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Manjunath Asundi
 * Kahns topological sorting algorithm
 */
public class KahnsTopologicalSorting {

    public static void kahnsTopologicalSortingAlgorithm(Graph graph) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int inDegree[] = findInDegree(graph);
        for (int i = 0; i < graph.getV(); i++)
            if (inDegree[i] == 0)
                queue.addLast(i);

        int vertexCount = 0;
        List<Integer> resultArr = new ArrayList<Integer>();
        while (queue.size() != 0) {
            int vertex = queue.removeFirst();
            resultArr.add(vertex);
            LinkedList<Integer> list = graph.getAdjList().get(vertex);
            for (Integer data : list)
                if (--inDegree[data] == 0)
                    queue.addLast(data);
            vertexCount++;
        }
        if (vertexCount == graph.getV())
            for (Integer data : resultArr)
                System.out.print(data + " ");
        else
            System.out.print("Topological sorting is not possible");

    }

    public static int[] findInDegree(Graph graph) {
        LinkedList<LinkedList<Integer>> adjList = graph.getAdjList();
        int inDegree[] = new int[graph.getV()];
        for (int i = 0; i < graph.getV(); i++)
            for (int j = 0; j < adjList.get(i).size(); j++)
                inDegree[adjList.get(i).get(j)]++;
        return inDegree;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(4, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        System.out.print("Kahns Topological sorting -> ");
        kahnsTopologicalSortingAlgorithm(graph);
    }
}