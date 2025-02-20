import java.util.*;
public class FrequencyOfCharacter {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
       
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> frequencyMap = countFrequency(stringList);
        System.out.println("Frequency of elements: " + frequencyMap);
    }
}
