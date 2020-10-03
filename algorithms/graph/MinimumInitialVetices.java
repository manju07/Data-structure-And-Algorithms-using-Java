package algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Manjunath Asundi 
 * Find minimum initial vertices required to traverse entire matrix
 */
public class MinimumInitialVetices {

    public static List<LinkedList<Integer>> findMaxValueIndices(int region[][]) {
        int maxValue = Integer.MIN_VALUE;
        List<LinkedList<Integer>> maxValueIndices = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < region.length; i++) {
            for (int j = 0; j < region[i].length; j++) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                if (maxValue < region[i][j]) {
                    maxValue = region[i][j];
                    maxValueIndices = new LinkedList<LinkedList<Integer>>();
                    list.add(i);
                    list.add(j);
                    maxValueIndices.add(list);
                } else if (maxValue == region[i][j]) {
                    list.add(i);
                    list.add(j);
                    maxValueIndices.add(list);
                }
            }
        }
        return maxValueIndices;
    }

    public static void dfs(int region[][], Boolean[][] visited, int i, int j, int rows, int cols) {
        visited[i][j] = true;
        int rowIndices[] = { 1, 0, -1, 0 };
        int colIndices[] = { 0, -1, 0, 1 };
        int maxValueI = -1, maxValueJ = -1;
        int maxValue = -1;
        for (int k = 0; k < colIndices.length; k++) {
            int rc = i + rowIndices[i];
            int cc = i + colIndices[j];
            if (rc > -1 && rc < rows && cc > -1 && cc < cols && visited[rc][cc] == false
                    && region[rc][cc] <= region[i][j]) {
                if (maxValue < region[rc][cc]) {
                    maxValue = region[rc][cc];
                    maxValueI = rc;
                    maxValueJ = cc;
                }
            }
        }
        if (maxValue != -1)
            dfs(region, visited, maxValueI, maxValueJ, rows, cols);
    }

    public static int findMinimumInitialVertices(int region[][], int rows, int cols) {
        int minimumInitialVeticesCount = 0;
        Boolean[][] visited = new Boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                visited[i][j] = false;

        List<LinkedList<Integer>> maxValueIndices = findMaxValueIndices(region);
        for (LinkedList<Integer> linkedList : maxValueIndices) {
            if (!visited[linkedList.get(0)][linkedList.get(1)]) {
                dfs(region, visited, linkedList.get(0), linkedList.get(1), rows, cols);
                minimumInitialVeticesCount++;
            }
        }
        return minimumInitialVeticesCount;
    }

    public static void main(String[] args) {
        int region[][] = { { 1, 2, 3 }, { 2, 3, 1 }, { 1, 1, 1 } };
        System.out.println("Minimum initial vertices count to traverse entire matrix -> "
                + findMinimumInitialVertices(region, region.length, region[0].length));
    }
}