import java.util.*;
public class FactorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if the entered number is a positive integer
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            // Initialize the factorial variable
            long factorial = 1;

            // Compute the factorial using a while loop
            int i = 1;
            while (i <= number) {
                factorial *= i; // Multiply factorial by i
                i++; // Increment i
            }
            System.out.println("The factorial of " + number + " is: " + factorial);
        }
    }
}
