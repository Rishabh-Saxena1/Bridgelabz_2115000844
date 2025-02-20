import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static <T> List<T> removeDuplicatesManual(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
       
        for (T item : list) {
            if (seen.add(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        System.out.println("Original List: " + list);
        List<String> uniqueList1 = removeDuplicates(list);
        System.out.println("Without Duplicates (LinkedHashSet): " + uniqueList1);
        List<String> uniqueList2 = removeDuplicatesManual(list);
        System.out.println("Without Duplicates (Manual): " + uniqueList2);
    }
}
