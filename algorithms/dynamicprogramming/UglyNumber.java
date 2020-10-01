package algorithms.dynamicprogramming;

/**
 * @author Manjunath Asundi 
 * Find nth ugly number which is prime factor of 2, 3 or 5
 * Series 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15 ..... 
 */
public class UglyNumber {
    static int uglyNumbers[] = new int[100];

    public static int findUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        uglyNumbers[0] = 1;
        if (uglyNumbers[n] != 0)
            return uglyNumbers[n];
        for (int i = 1; i <= n; i++) {
            int uglyNumber = Math.min(Math.min(uglyNumbers[i2] * 2, uglyNumbers[i3] * 3), uglyNumbers[i5] * 5);
            // System.out.println("uglyNumber " + uglyNumber);
            uglyNumbers[i] = uglyNumber;
            if (uglyNumber == uglyNumbers[i2] * 2)
                i2++;
            if (uglyNumber == uglyNumbers[i3] * 3)
                i3++;
            if (uglyNumber == uglyNumbers[i5] * 5)
                i5++;
        }
        return uglyNumbers[n];
    }

    public static void main(String[] args) {
        for (int n : new int[] { 5, 10, 8, 7, 12, 54 })
            System.out.println(n + "th ugly number is " + findUglyNumber(n));
    }
}