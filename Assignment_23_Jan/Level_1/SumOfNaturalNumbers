import java.util.*;
public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Check if the entered number is a natural number
        if (n >= 1) {
            // Compute the sum using the formula: n * (n + 1) / 2
            int formulaSum = n * (n + 1) / 2;

            // Compute the sum using a for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // Compare the results and print them
            if (formulaSum == loopSum) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("There is a discrepancy in the results.");
            }

            // Print the computed sums
            System.out.println("Sum using the formula: " + formulaSum);
            System.out.println("Sum using the for loop: " + loopSum);
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }
    }
}
