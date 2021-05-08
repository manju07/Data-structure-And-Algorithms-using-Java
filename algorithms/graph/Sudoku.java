package algorithms.graph;

import java.util.HashMap;
import java.util.Map;

// 10 X 10 

// [ B C V B D ……..T
// C
// G
// B
// A
// T
// …
// .
// .
// .
// …………………….]

// Dictionary: 
// BAT, CAT,RAT………..BCVCB

// C -> CAT, CAD, CBA
// B -> BAT
/**
 * Find all occurence words in the given Matrix(Sudoku Game)
 * 
 * @author Manjunath Asundi
 */
public class Sudoku {

    static int rowArr[] = { 0, 0, 1, -1 };
    static int colArr[] = { 1, -1, 0, 0 };

    private static void findWords(char[][] matrix, Map<String, Integer> map, int minStrLength, int maxStrLength,
            String result, int iIndex, int jIndex, int rows, int cols) {
        if (iIndex < 0 || jIndex < 0 || iIndex >= rows || jIndex >= cols || result.length() > maxStrLength)
            return;
        // System.out.println(result + " " + iIndex + " " + jIndex);
        result = result + matrix[iIndex][jIndex];
        // System.out.println(result + " " + iIndex + " " + jIndex);
        if (result.length() >= minStrLength && result.length() <= maxStrLength) {
            if (map.containsKey(result))
                map.put(result, 1);
        } else if (result.length() > maxStrLength)
            return;
        for (int i = 0; i < rowArr.length; i++) {
            int tempIIndex = iIndex + rowArr[i];
            int tempJIndex = jIndex + colArr[i];
            // System.out.println(iIndex + " " + jIndex);
            if (tempIIndex >= 0 && tempIIndex < rows && tempJIndex >= 0 && tempJIndex < cols)
                findWords(matrix, map, minStrLength, maxStrLength, result, tempIIndex, tempJIndex, rows, cols);
        }
    }

    public static void main(String[] args) {
        char[][] matrix = { { 'a', 'b', 'c' }, { 'c', 'd', 'e' }, { 'e', 'a', 'b' } };
        String[] strArr = { "ba", "abc", "ab", "ace", "de", "eac", "bda", "e" };
        int minStrLength = -1, maxStrLength = -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            if (minStrLength > strArr[i].length())
                minStrLength = strArr[i].length();
            if (maxStrLength < strArr[i].length())
                maxStrLength = strArr[i].length();
            map.put(strArr[i], 0);
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                findWords(matrix, map, minStrLength, maxStrLength, "", i, j, 3, 3);

        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }

}