package algorithms.graph.backtracking;

/**
 * @author Manjunath Asundi
 * Finding Knight tour
 */
public class KnightTour {

    public static Boolean knightTourUtil(int cr, int cl, int k, int[] moveX, int[] moveY, int n, int[][] matrix) {
        if (k == (n * n))
            return true;
        for (int i = 0; i < moveY.length; i++) {
            int nextR = cr + moveY[i];
            int nextC = cl + moveX[i];
            if (nextR < n && nextR > -1 && nextC < n && nextC > -1 && matrix[nextR][nextC]==-1) {
                matrix[nextR][nextC] = k;
                Boolean result = knightTourUtil(nextR, nextC, k + 1, moveX, moveY, n, matrix);
                if (result)
                    return result;
                else
                    matrix[nextR][nextC] = -1;
            }
        }
        return false;
    }

    public static void findKnightTourSolution(int n) {
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = -1;
        matrix[0][0] = 0;
        int k = 1;
        int moveY[] = { 1, -1, -2, -2, 2, 2, -1, 1 };
        int moveX[] = { -2, -2, -1, 1, 1, -1, 2, 2 };
        if (knightTourUtil(0, 0, k, moveX, moveY, n, matrix))
            printMatrix(matrix);
        else
            System.out.println("Solution doesn't exist");
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        findKnightTourSolution(8);
    }
}