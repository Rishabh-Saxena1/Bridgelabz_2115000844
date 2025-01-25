import java.util.Scanner;

public class Copy2DArrayTo1D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions of the 2D array
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create 2D array
        int[][] matrix = new int[rows][columns];

        // Get user input for 2D array elements
        System.out.println("Enter elements for the 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Create 1D array to store elements
        int[] oneDimensionalArray = new int[rows * columns];
        int index = 0;

        // Copy elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                oneDimensionalArray[index++] = matrix[i][j];
            }
        }

        // Display the 1D array
        System.out.print("1D Array: ");
        for (int i = 0; i < oneDimensionalArray.length; i++) {
            System.out.print(oneDimensionalArray[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
