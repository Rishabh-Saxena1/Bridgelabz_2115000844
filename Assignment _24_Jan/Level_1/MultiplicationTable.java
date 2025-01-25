import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get user input for the number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Create an array to store the multiplication table
        int[] multiplicationTable = new int[10];

        // Calculate the multiplication table
        for (int i = 0; i < multiplicationTable.length; i++) {
            multiplicationTable[i] = number * (i + 1);
        }

        // Print the multiplication table
        System.out.println("Multiplication table of " + number + ":");
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " x " + (i + 1) + " = " + multiplicationTable[i]);
        }

        // Close the Scanner object
        input.close();
    }
}
