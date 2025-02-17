import java.util.*;
public class DataStructureComparison {
    public static void main(String[] args) {
        int size = 1000000;
        Random rand = new Random();
        int target = rand.nextInt(size);

        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(size);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }

        // Measure time for Linear Search
        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long arraySearchTime = System.nanoTime() - startTime;

        // Measure time for HashSet Search
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long hashSetSearchTime = System.nanoTime() - startTime;

        // Measure time for TreeSet Search
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long treeSetSearchTime = System.nanoTime() - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Array Search Time: " + arraySearchTime / 1000000.0 + " ms (Found: " + foundInArray + ")");
        System.out.println("HashSet Search Time: " + hashSetSearchTime / 1000000.0 + " ms (Found: " + foundInHashSet + ")");
        System.out.println("TreeSet Search Time: " + treeSetSearchTime / 1000000.0 + " ms (Found: " + foundInTreeSet + ")");
    }

    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
