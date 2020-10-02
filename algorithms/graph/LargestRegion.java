package algorithms.graph;

/**
 * @author Manjunath Asundi 
 * Consider 1 is filled and 0 is empty from the given
 * matrix, can travel vertically, horizontally and diagonally 
 * and find largest region size
 */
public class LargestRegion {

    public static int dfsOnRegion(int region[][], int row, int col, int rows, int cols, int count) {
        region[row][col] = -1;
        int rowIndex[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
        int colIndex[] = { 1, -1, 0, 0, -1, 1, -1, 1 };
        for (int i = 0; i < colIndex.length; i++) {
            int rowCompute = row + rowIndex[i];
            int colCompute = col + colIndex[i];
            if (rowCompute > -1 && rowCompute < rows && colCompute > -1 && colCompute < cols
                    && region[rowCompute][colCompute] == 1)
                count = dfsOnRegion(region, rowCompute, colCompute, rows, cols, count + 1);
        }
        return count;
    }

    public static int findLargestRegion(int region[][], int rows, int cols) {
        int largestRegionSize = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (region[i][j] == 1) {
                    int regionSize = dfsOnRegion(region, i, j, rows, cols, 1);
                    if (regionSize > largestRegionSize)
                        largestRegionSize = regionSize;
                }
            }
        }
        return largestRegionSize;
    }

    public static void main(String[] args) {
        int region[][] = { { 0, 1, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
        System.out.println("Largest region size is " + findLargestRegion(region, region.length, region[0].length));
    }
}