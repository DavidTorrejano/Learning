package collections.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Map doesn't extend from collection, although it can be seen as a collection
public class Maps {
    public static void main(String[] args) {

        // This map keeps no order
        Map<String, Integer> map = new HashMap<>();
        map.put("David", 1);
        map.put("Fernando", 10);
        map.put("Rodrigo", 100);
        map.put("Armaní", 1000);

        System.out.println(map.getOrDefault("David", 7));
        System.out.println(map.getOrDefault("Rodrigo", 5));


        Set<Map.Entry<String, Integer>> entrySet =  map.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Set <String> allKeys = map.keySet();
        for (String key : allKeys) {
            System.out.println("{" + key + ": " + map.get(key) + "}");
        }

        Map<String, Integer> treeMap = new TreeMap<>();



    }
}
