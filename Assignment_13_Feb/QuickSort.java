import java.util.*;
public class QuickSort {
    public static void quickSort(double[] productPrices, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(productPrices, low, high);
            quickSort(productPrices, low, partitionIndex - 1);
            quickSort(productPrices, partitionIndex + 1, high);
        }
    }

    private static int partition(double[] productPrices, int low, int high) {
        double pivot = productPrices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (productPrices[j] < pivot) {
                i++;
                double temp = productPrices[i];
                productPrices[i] = productPrices[j];
                productPrices[j] = temp;
            }
        }
        double temp = productPrices[i + 1];
        productPrices[i + 1] = productPrices[high];
        productPrices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        double[] productPrices = {299.99, 150.50, 450.75, 199.99, 349.00, 125.25};
        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
