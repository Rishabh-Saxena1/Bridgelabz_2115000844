import java.util.*;
public class InsertionSort {
    public static void insertionSort(int[] empId) {
        int n = empId.length;
        for (int i = 1; i < n; i++) {
            int key = empId[i];
            int j = i - 1;
            while (j >= 0 && empId[j] > key) {
                empId[j + 1] = empId[j];
                j = j - 1;
            }
            empId[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] empId = {105, 23, 89, 77, 56, 12, 34};
        System.out.println("Original Array of Employee IDs: " + Arrays.toString(empId));
        insertionSort(empId);
        System.out.println("Sorted Array of Employee IDs: " + Arrays.toString(empId));
    }
}
