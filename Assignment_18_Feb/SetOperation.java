import java.util.*;
public class SetOperation {
    public static <T> Set<T> getUnion(Set<T> set1, Set<T> set2) {
        Set<T> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }
    public static <T> Set<T> getIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        Set<Integer> union = getUnion(set1, set2);
        Set<Integer> intersection = getIntersection(set1, set2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
