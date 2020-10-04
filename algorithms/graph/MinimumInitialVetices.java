package algorithms.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Manjunath Asundi 
 * Find minimum initial vertices required to traverse entire matrix
 */
public class MinimumInitialVetices {

    public static Map<Integer, List<LinkedList<Integer>>> findMaxValueIndices(int region[][]) {
        Map<Integer, List<LinkedList<Integer>>> map = new HashMap<>();
        for (int i = 0; i < region.length; i++) {
            for (int j = 0; j < region[i].length; j++) {
                List<LinkedList<Integer>> linkedList;
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(i);
                list.add(j);
                if (!map.containsKey(region[i][j])) {
                    linkedList = new LinkedList<LinkedList<Integer>>();
                    linkedList.add(list);
                } else {
                    linkedList = map.get(region[i][j]);
                    linkedList.add(list);
                }
                map.put(region[i][j], linkedList);
            }
        }
        return map;
    }

    public static void dfs(int region[][], Boolean[][] visited, int i, int j, int rows, int cols) {
        visited[i][j] = true;
        int rowIndices[] = { 1, 0, -1, 0 };
        int colIndices[] = { 0, -1, 0, 1 };
        int maxValueI = -1, maxValueJ = -1;
        int maxValue = -1;
        for (int k = 0; k < colIndices.length; k++) {
            int rc = i + rowIndices[k];
            int cc = j + colIndices[k];
            if (rc > -1 && rc < rows && cc > -1 && cc < cols && visited[rc][cc] == false
                    && region[rc][cc] <= region[i][j]) {
                if (maxValue < region[rc][cc]) {
                    maxValue = region[rc][cc];
                    maxValueI = rc;
                    maxValueJ = cc;
                }
            }
        }
        System.out.println("maxValue=" + maxValue + " maxValueI=" + maxValueI + " maxValueJ=" + maxValueJ);
        if (maxValue != -1)
            dfs(region, visited, maxValueI, maxValueJ, rows, cols);
    }

    public static int findMinimumInitialVertices(int region[][], int rows, int cols) {
        int minimumInitialVeticesCount = 0;
        Boolean[][] visited = new Boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                visited[i][j] = false;

        Map<Integer, List<LinkedList<Integer>>> map = findMaxValueIndices(region);
        Map<Integer, List<LinkedList<Integer>>> linkedHashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        for (Map.Entry<Integer, List<LinkedList<Integer>>> data: linkedHashMap.entrySet()) {
            List<LinkedList<Integer>> listOfList = data.getValue();
            for (LinkedList<Integer> list : listOfList) {
                if (!visited[list.get(0)][list.get(1)]) {
                    System.out.println("I=" + list.get(0) + " j=" + list.get(1));
                    dfs(region, visited, list.get(0), list.get(1), rows, cols);
                    minimumInitialVeticesCount++;
                }
            }
        }
        return minimumInitialVeticesCount;
    }

    public static void main(String[] args) {
        int region[][][] = { { { 1, 2, 3 }, { 2, 3, 1 }, { 1, 1, 1 } }, { { 3, 3 }, { 1, 1 } } };
        for (int[][] twoDArray : region)
            System.out.println("Minimum initial vertices count to traverse entire matrix -> "
                    + findMinimumInitialVertices(twoDArray, twoDArray.length, twoDArray[0].length));
    }
}