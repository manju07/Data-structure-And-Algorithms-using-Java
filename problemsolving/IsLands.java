package problemsolving;

/**
 * Test
 */
public class IsLands {

    private static int countIslands = 0;
    private static int adjRow[] = { -1, 0, 1, 0};
    private static int adjCol[] = { 0, 1, 0, -1};

    public static Boolean isSatify(int nr, int nc, int rows, int cols, int matrix[][]) {
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] == 1)
            return true;
        return false;
    }

    public static void findIslandsUtil(int matrix[][], int rows, int cols, int cr, int cc) {
        if (matrix[cr][cc] != 1)
            return;
        matrix[cr][cc] = -1;
        for (int i = 0; i < adjRow.length; i++) {
            int nr = cr + adjRow[i];
            int nc = cc + adjCol[i];
            if (isSatify(nr, nc, rows, cols, matrix)) 
                findIslandsUtil(matrix, rows, cols, nr, nc);
        }

    }

    public static void findIslands(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    countIslands++;
                    findIslandsUtil(matrix, matrix.length, matrix[i].length, i, j);
            }
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { 
            { 0, 1, 1, 1, 0, 0, 0, 0 },
            { 1, 0, 0, 1, 0, 1, 1, 1 },
            { 1, 0, 0, 1, 0, 1, 0, 1 } 
        };
        findIslands(matrix);
        System.out.println("Number of Islands = " + countIslands);
    }
}