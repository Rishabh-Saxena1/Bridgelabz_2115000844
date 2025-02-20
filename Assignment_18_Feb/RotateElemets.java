import java.util.*;
public class RotateElemets {
    public static <T> void rotateArrayList(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        if (k < 0) {
            k = n + k;
        }
        List<T> rotatedList = new ArrayList<>(list.subList(n - k, n));
        rotatedList.addAll(list.subList(0, n - k));
        list.clear();
        list.addAll(rotatedList);
    }
    public static <T> void rotateLinkedList(LinkedList<T> list, int k) {
        int n = list.size();
        k = k % n;
        if (k < 0) {
            k = n + k;
        }
        for (int i = 0; i < k; i++) {
            T last = list.removeLast();
            list.addFirst(last);
        }
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        rotateArrayList(arrayList, 2);
        System.out.println("Rotated ArrayList: " + arrayList);

        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("\nOriginal LinkedList: " + linkedList);
        rotateLinkedList(linkedList, 2);
        System.out.println("Rotated LinkedList: " + linkedList);
    }
}
