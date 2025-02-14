import java.util.*;
public class MergeSort {
    public static void mergeSort(double[] bookPrice, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(bookPrice, left, mid);
            mergeSort(bookPrice, mid + 1, right);
            merge(bookPrice, left, mid, right);
        }
    }

    private static void merge(double[] bookPrice, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = bookPrice[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = bookPrice[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                bookPrice[k] = leftArray[i];
                i++;
            } else {
                bookPrice[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            bookPrice[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            bookPrice[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        double[] bookPrice = {299.99, 150.50, 450.75, 199.99, 349.00, 125.25};
        System.out.println("Original Array Book Prices: " + Arrays.toString(bookPrice));
        mergeSort(bookPrice, 0, bookPrice.length - 1);
        System.out.println("Sorted Array Book Prices: " + Arrays.toString(bookPrice));
    }
}
