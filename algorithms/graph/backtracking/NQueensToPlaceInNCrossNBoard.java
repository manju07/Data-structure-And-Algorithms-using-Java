package algorithms.graph.backtracking;

/**
 * Place N Queens in the N*N matrix chess board
 * @author Manjunath Asundi
 */
public class NQueensToPlaceInNCrossNBoard {

    public static Boolean isSafe(int matrix[][], int row, int column, int n) {
        // Check upper columns elements
        for (int i = row - 1; i >= 0; i--)
            if (matrix[i][column] == 1)
                return false;
        // Check left upper diagnol elements
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--)
            if (matrix[i][j] == 1)
                return false;
        // Check right upper diagnol elements
        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++)
            if (matrix[i][j] == 1)
                return false;

        return true;
    }

    public static Boolean placeNQueensUtilSolution1(int matrix[][], int n, int row) {
        if (row >= n)
            return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(matrix, row, i, n)) {
                matrix[row][i] = 1;
                if (placeNQueensUtilSolution1(matrix, n, row + 1))
                    return true;
                matrix[row][i] = 0;
            }
        }
        return false;
    }

    public static void placeNQueensInTheChessBoardSolution1(int n) {
        int matrix[][] = new int[n][n];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = 0;

        if (placeNQueensUtilSolution1(matrix, n, 0))
            printMatrix(matrix);
        else
            System.out.println("Can't place " + n + " queens in the matrix");
    }

    public static Boolean placeNQueensUtilSolution2(int matrix[][], int[] ld, int[] rd, int[] row, int n, int cc) {
        if (cc >= n)
            return true;
        for (int i = 0; i < n; i++) {
            if (ld[i - cc + n - 1] == 1 || rd[i + cc] == 1 || row[i] == 1)
                continue;
            matrix[i][cc] = 1;
            ld[i - cc + n - 1] = rd[i + cc] = row[i] = 1;
            if (placeNQueensUtilSolution2(matrix, ld, rd, row, n, cc + 1))
                return true;
            matrix[i][cc] = 0;
            ld[i - cc + n - 1] = rd[i + cc] = row[i] = 0;
        }
        return false;
    }

    public static void placeNQueensInTheChessBoardSolution2(int n) {
        int matrix[][] = new int[n][n];
        int ld[] = new int[n * n];
        int rd[] = new int[n * n];
        int row[] = new int[n];
        for (int i = 0; i < matrix.length; i++) 
            for (int j = 0; j < matrix.length; j++) 
                matrix[i][j] = 0;

        if (placeNQueensUtilSolution2(matrix, ld, rd, row, n, 0))
            printMatrix(matrix);
        else
            System.out.println("Solution doesn't exist");
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println("Result from 1st solution");
        placeNQueensInTheChessBoardSolution1(n);
        System.out.println("Result from 2nd solution");
        placeNQueensInTheChessBoardSolution2(n);
    }
}
