import java.util.*;
public class HeapSort {
    public static void heapSort(double[] salary) {
        int n = salary.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            double temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;
            heapify(salary, i, 0);
        }
    }
    private static void heapify(double[] salary, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salary[left] > salary[largest]) {
            largest = left;
        }
        if (right < n && salary[right] > salary[largest]) {
            largest = right;
        }
        if (largest != i) {
            double temp = salary[i];
            salary[i] = salary[largest];
            salary[largest] = temp;
            heapify(salary, n, largest);
        }
    }

    public static void main(String[] args) {
        double[] salary = {55000, 72000, 48000, 65000, 99000, 58000};
        System.out.println("Original Salary Demands: " + Arrays.toString(salary));
        heapSort(salary);
        System.out.println("Sorted Salary Demands: " + Arrays.toString(salary));
    }
}
