package collections.framework;

import java.util.*;

// Map doesn't extend from collection, although it can be seen as a collection
public class Maps {
    public static void main(String[] args) {

        // This map keeps no order
        Map<String, Integer> map = new HashMap<>();
        map.put("David", 1);
        map.put("Fernando", 10);
        map.put("Rodrigo", 100);
        map.put("Armaní", 1000);

//        System.out.println(map.getOrDefault("David", 7));
//        System.out.println(map.getOrDefault("Rodrigo", 5));


        Set<Map.Entry<String, Integer>> entrySet =  map.entrySet();

//        for (Map.Entry<String, Integer> entry : entrySet) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        Set <String> allKeys = map.keySet();
//        for (String key : allKeys) {
//            System.out.println("{" + key + ": " + map.get(key) + "}");
//        }

        // The treeMap implements SortedMap and NavigableMap, that is why we can have methods to find values such as:
        // ceilingEntry(K key) -> this will return the value of the lowest key, higher or equal to the key passed as argument
        // floorEntry(K key) -> Does about the same as ceiling but returns the highest key lower than the passed
        // as argument or the one passed as argument
        // The higherEntry(K key) and lowerEntry(K key) don't include the key passed as argument, therefore, even if the
        // key exists this method will return the closest higher or lower value or if not present, returns null.

        NavigableMap<String, Integer> treeMap = new TreeMap<>((a, b) -> b.compareToIgnoreCase(a));
        treeMap.put("David", 1);
        treeMap.put("Fernando", 10);
        treeMap.put("Rodrigo", 100);
        treeMap.put("Armaní", 1000);

        Map.Entry<String, Integer> nm = treeMap.ceilingEntry("J");
        System.out.println(nm);
        System.out.println(treeMap.ceilingKey("Z"));



    }
}
