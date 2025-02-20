import java.util.*;
public class FindKey {
    public static String findMaxKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "Map is empty!";
        }
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        System.out.println("Key with max value: " + findMaxKey(map));
    }
}
