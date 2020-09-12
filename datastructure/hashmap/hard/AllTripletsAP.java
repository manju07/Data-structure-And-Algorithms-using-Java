package datastructure.hashmap.hard;

/**
 * @author Manjunath Asundi 
 * Print all triplets from sorted form which are in
 *         airthmetic progression
 */
public class AllTripletsAP {

    public static void printAllTripletsFormAP(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i - 1, k = i + 1; j >= 0 && k < arr.length;) {
                if (arr[j] + arr[k] == arr[i] * 2) {
                    System.out.println(arr[j] + " " + arr[i] + " " + arr[k]);
                    j--;
                    k++;
                } else if (arr[j] + arr[k] < arr[i] * 2)
                    k++;
                else
                    j--;
            }
        }
    }

    public static void main(String[] args) {
        int twoDarr[][] = { { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 }, { 3, 5, 6, 7, 8, 10, 12 } };
        for (int[] arr : twoDarr) {
            printAllTripletsFormAP(arr);
            System.out.println();
        }
    }
}