import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the count of digits
        int temp = number;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Store digits in an array
        int[] digits = new int[count];
        int index = 0;
        temp = number;
        while (temp > 0) {
            digits[index++] = temp % 10;
            temp /= 10;
        }

        // Create an array to store digits in reverse order
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i]; 
        }

        // Display the reversed number
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();

        scanner.close();
    }
}
