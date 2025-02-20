import java.util.*;
import java.util.stream.Collectors;
public class SymmetricDifference {
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        unionSet.removeAll(intersectionSet);
        return unionSet;
    }

    public static <T> Set<T> getSymmetricDifferenceStreams(Set<T> set1, Set<T> set2) {
        return set1.stream()
                .filter(e -> !set2.contains(e))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        Set<Integer> symmetricDiff = getSymmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
