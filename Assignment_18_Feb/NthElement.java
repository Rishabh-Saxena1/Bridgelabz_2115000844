import java.util.*;
public class NthElement {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            }
            else {
                throw new IllegalArgumentException("List is shorter than " + n + " elements.");
            }
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60));
        int n = 2;
        try {
            int result = findNthFromEnd(list, n);
            System.out.println("The " + n + "rd element from the end is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
