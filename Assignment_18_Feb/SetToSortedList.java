import java.util.*;
public class SetToSortedList {
   
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 1, 9, 3, 7, 2));
        List<Integer> sortedList = convertToSortedList(hashSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
