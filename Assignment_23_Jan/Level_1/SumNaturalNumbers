import java.util.*;
public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Check if the entered number is a natural number
        if (n >= 1) {
            // Compute the sum using the formula: n * (n + 1) / 2
            int formulaSum = n * (n + 1) / 2;

            // Compute the sum using a while loop
            int loopSum = 0;
            int i = 1;
            while (i <= n) {
                loopSum += i;
                i++;
            }

            // Compare the results and print them
            if (formulaSum == loopSum) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("There is a discrepancy in the results.");
            }

            // Print the computed sums
            System.out.println("Sum using the formula: " + formulaSum);
            System.out.println("Sum using the while loop: " + loopSum);
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

    }
}
