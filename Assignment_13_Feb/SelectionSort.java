
import java.util.*;
public class SelectionSort {
    public static void selectionSort(double[] examScores) {
        int n = examScores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (examScores[j] < examScores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = examScores[minIndex];
            examScores[minIndex] = examScores[i];
            examScores[i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] examScores = {78.5, 92.0, 45.0, 88.5, 67.0, 99.5, 52.0, 73.5};
        System.out.println("Original Array of Exam Scores: " + Arrays.toString(examScores));
        selectionSort(examScores);
        System.out.println("Sorted Array of Exam Scores: " + Arrays.toString(examScores));
    }
}

