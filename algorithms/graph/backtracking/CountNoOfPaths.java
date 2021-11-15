package algorithms.graph.backtracking;

/**
 * Count number of paths from source(0,0) to (r-1, c-1)
 * @author Manjunath Asundi
 */
public class CountNoOfPaths {
    private static int countNoOfPaths = 0;
    public static void findNoOfPathsSolution1(int maze[][], int cr, int cc) {
        if (cr >= maze.length || cc >= maze[cr].length || maze[cr][cc] == -1)
            return;
        if (cr == maze.length - 1 && cc == maze[cr].length - 1) {
            countNoOfPaths++;
            return;
        }
        findNoOfPathsSolution1(maze, cr, cc + 1);
        findNoOfPathsSolution1(maze, cr + 1, cc);
    }

    public static int findNoOfPathsSolution2(int[] maze[]) {
        if (maze[0][0] == -1)
            return 0;
        for (int i = 0; i < maze.length; i++)
            if (maze[i][0] == 0)
                maze[i][0] = 1;
            else
                break;

        for (int i = 1; i < maze[0].length; i++)
            if (maze[0][i] == 0)
                maze[0][i] = 1;
            else
                break;

        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[i].length; j++) {
                if (maze[i][j] == -1)
                    continue;
                if (maze[i - 1][j] > 0)
                    maze[i][j] = maze[i][j] + maze[i - 1][j];
                if (maze[i][j - 1] > 0)
                    maze[i][j] = maze[i][j] + maze[i][j - 1];
            }
        }
        return maze[maze.length - 1][3];
    }

    public static void main(String[] args) {
        int maze[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
        findNoOfPathsSolution1(maze, 0, 0);
        System.out.println("[Solution1] No of paths: " + countNoOfPaths);
        System.out.println("[Solution2] No of paths: " + findNoOfPathsSolution2(maze));
    }
}
