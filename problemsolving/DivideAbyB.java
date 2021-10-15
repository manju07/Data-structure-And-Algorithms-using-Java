package problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * Divide A by B without using float data type and repeating floating point string should need to be enclosed by parenthesis
 * @author Manjunath Asundi
 */
public class DivideAbyB {

    public static String divide(int a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        int d = a / b;
        int r = a % b;
        String result = d + ".";
        if (r == 0)
            return result + "0";
        while (!map.containsKey(r)) {
            map.put(r, result.length());
            a = r * 10;
            d = a / b;
            result = result + d;
            r = a % b;
            if (r == 0)
                break;
        }
        if (map.containsKey(r)) {
            int index = map.get(r);
            result = result.substring(0, index) + "(" + result.substring(index) + ")";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 2));
        System.out.println(divide(7, 2));
        System.out.println(divide(7, 5));
        System.out.println(divide(10, 3));
        System.out.println(divide(1, 97));
        System.out.println(divide(4, 11));
        System.out.println(divide(18, 13));
    }
}