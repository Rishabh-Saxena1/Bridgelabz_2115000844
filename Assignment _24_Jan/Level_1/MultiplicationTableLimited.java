import java.util.Scanner;

public class MultiplicationTableLimited {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] multiplicationResult = new int[4]; // Array to store results from 6 to 9

        // Calculate multiplication table from 6 to 9
        for (int i = 0; i < multiplicationResult.length; i++) {
            multiplicationResult[i] = number * (i + 6); 
        }

        // Display the multiplication table
        System.out.println("Multiplication table of " + number + " from 6 to 9:");
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " x " + (i + 6) + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
