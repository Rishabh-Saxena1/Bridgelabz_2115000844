import java.util.*;
public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 92, 45, 88, 67, 99, 52, 73};
        System.out.println("Original Marks Array: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("Sorted Marks Array: " + Arrays.toString(marks));
    }
}
