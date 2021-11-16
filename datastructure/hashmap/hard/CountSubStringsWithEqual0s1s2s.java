package datastructure.hashmap.hard;

import java.util.HashMap;
import java.util.Map;

import util.Pair;

/**
 * Count substrings having equal number of o's, 1's and 2's
 * @author Manjunath Asundi
 */
public class CountSubStringsWithEqual0s1s2s {

    public static int countSubStringsWithEqual0s1s2s(String str) {
        int zc = 0, oc = 0, tc = 0, substrCount = 0;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<Pair<Integer, Integer>, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zc++;
            else if (str.charAt(i) == '1')
                oc++;
            else
                tc++;
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(zc - oc, zc - tc);
            if (!map.containsKey(pair))
                map.put(pair, 1);
            else {
                int count = map.get(pair);
                substrCount += count;
                map.put(pair, count + 1);
            }
        }
        return substrCount;
    }

    public static void main(String[] args) {
        String[] arrayOfStrings = { "010120102", "11112202101", "120121120" };
        for (String string : arrayOfStrings)
            System.out.println(string + " Count of substrings having equal number of 0's 1's and 2's = "
                    + countSubStringsWithEqual0s1s2s(string));
    }
}