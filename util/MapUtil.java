package util;

import java.util.Map;

/**
 * Map related util methods are written here
 * 
 * @author Manjunath Asundi
 */
public class MapUtil {

    public static void printMap(Map map) {
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();
    }
}