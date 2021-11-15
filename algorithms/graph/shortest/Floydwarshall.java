package algorithms.graph.shortest;

/**
 * @author Manjunath Asundi
 * Find all shortest paths from each vertex
 */
public class Floydwarshall {

    public static void findAllShortestPaths(int matrix[][]) {
        for (int k = 0; k < matrix.length; k++) 
            for (int i = 0; i < matrix.length; i++) 
                for (int j = 0; j < matrix[i].length; j++) 
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE
                            && matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
        printShortestPaths(matrix);
    }

    public static void printShortestPaths(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE)
                    System.out.print(matrix[i][j] + " ");
                else
                    System.out.print(-1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        findAllShortestPaths(new int[][] { { 0, 5, Integer.MAX_VALUE, 10 },
                { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE }, { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } });
    }
}
