import java.util.*;
public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if the entered number is a positive integer
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            // Initialize the factorial variable
            long fact = 1;

            // Compute the factorial using a for loop
            for (int i = 1; i <= number; i++) {
                fact *= i; // Multiply factorial by i
            }
            System.out.println("The factorial of " + number + " is: " + fact);
        }
    }
}
