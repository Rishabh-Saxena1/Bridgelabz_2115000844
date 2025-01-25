import java.util.Scanner;

public class ArrayInputSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10]; // Array to store numbers
        double total = 0.0; // Variable to store the sum
        int index = 0; // Index for the array

        System.out.println("Enter numbers (enter 0 or a negative number to stop):");

        while (true) {
            double number = scanner.nextDouble();

            // Check for termination conditions
            if (number <= 0 || index >= 10) {
                break;
            }

            // Store the number in the array
            numbers[index] = number;
            index++; 
        }

        // Calculate the sum of numbers
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display the entered numbers
        System.out.print("Entered numbers: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Display the sum of numbers
        System.out.println("Sum of numbers: " + total);

        scanner.close();
    }
}
