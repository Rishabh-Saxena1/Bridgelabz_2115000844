import java.util.Scanner;

public class FibonacciGenerator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int numberOfTerms = inputScanner.nextInt();

        generateAndPrintFibonacci(numberOfTerms);

        inputScanner.close();
    }

    public static void generateAndPrintFibonacci(int numTerms) {
        if (numTerms <= 0) {
            System.out.println("Number of terms must be positive.");
            return;
        }

        int firstTerm = 0;
        int secondTerm = 1;

        System.out.print("Fibonacci Sequence: ");

        if (numTerms >= 1) {
            System.out.print(firstTerm + " ");
        }
        if (numTerms >= 2) {
            System.out.print(secondTerm + " ");
        }

        for (int i = 3; i <= numTerms; i++) {
            int nextTerm = firstTerm + secondTerm;
            System.out.print(nextTerm + " ");
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        System.out.println(); // Add a newline at the end
    }
}
