import java.util.Scanner;

public class FactorialCalculator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int number = getIntegerInput(inputScanner, "Enter a non-negative integer: ");

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = calculateFactorial(number);  // Use long for potentially large results
            displayResult(number, factorial);
        }

        inputScanner.close();
    }

    public static int getIntegerInput(Scanner inputScanner, String prompt) {
        System.out.print(prompt);
        return inputScanner.nextInt();
    }

    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        } else {
            return n * calculateFactorial(n - 1); // Recursive step
        }
    }

    public static void displayResult(int number, long factorial) {
        System.out.println("The factorial of " + number + " is: " + factorial);
    }
}
