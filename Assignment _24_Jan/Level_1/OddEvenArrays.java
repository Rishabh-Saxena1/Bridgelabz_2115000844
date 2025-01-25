import java.util.Scanner;

public class OddEvenArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Validate input (natural number)
        if (number <= 0) {
            System.err.println("Invalid input. Please enter a natural number.");
            System.exit(1); 
        }

        // Calculate array sizes (maximum possible)
        int maxEven = number / 2;
        int maxOdd = (number + 1) / 2;

        // Create arrays to store even and odd numbers
        int[] evenNumbers = new int[maxEven];
        int[] oddNumbers = new int[maxOdd];

        // Initialize index variables
        int evenIndex = 0;
        int oddIndex = 0;

        // Populate arrays with even and odd numbers
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }

        // Print even numbers
        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        // Print odd numbers
        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
