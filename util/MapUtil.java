package util;

import java.util.Map;

/**
 * Map related util methods are written here
 * 
 * @author Manjunath Asundi
 */
public class MapUtil {

    public static <K,V> void printMap(Map<K,V> map) {
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();
    }
}