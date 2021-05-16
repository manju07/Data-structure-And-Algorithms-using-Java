package util;

import java.util.Map;

/**
 * Map related util methods are written here
 * @author Manjunath Asundi
 */
public class MapUtil {

    private static void printMap(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> data : map.entrySet()) {
            System.out.println(data.getKey() + " " + data.getValue());
        }
        System.out.println();
    }
}