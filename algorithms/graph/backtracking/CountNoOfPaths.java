package algorithms.graph.backtracking;

/**
 * Count number of paths from source(0,0) to (r-1, c-1)
 * @see https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 * @author Manjunath Asundi 
 */
public class CountNoOfPaths {
    public static int countNoOfPaths = 0;

    public static void findNoOfPaths(int maze[][], int cr, int cc) {
        if (cr >= maze.length || cc >= maze[cr].length || maze[cr][cc] == -1)
            return;
        if (cr == maze.length - 1 && cc == maze[cr].length-1) {
            countNoOfPaths++;
            return;
        }
        findNoOfPaths(maze, cr, cc + 1);
        findNoOfPaths(maze, cr + 1, cc);
    }

    public static void main(String[] args) {
        int maze[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
        findNoOfPaths(maze, 0, 0);
        System.out.println("No of paths: " + countNoOfPaths);
    }
}
