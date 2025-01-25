import java.util.Scanner;

public class NumberAnalysis {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Declare an array to store 5 numbers
        int[] numbers = new int[5];

        // Get user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // Analyze each number
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative.");
            } else {
                System.out.println(numbers[i] + " is zero.");
            }
        }

        // Compare first and last elements
        if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is greater than the last element.");
        } else if (numbers[0] < numbers[numbers.length - 1]) {
            System.out.println("First element is less than the last element.");
        } else {
            System.out.println("First element is equal to the last element.");
        }

        // Close the Scanner object
        input.close();
    }
}
