import java.util.Scanner;

public class LargestSecondLargestDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initializations
        int maxDigits = 10; // Initial array size
        int[] digits = new int[maxDigits];
        int index = 0;

        // Extract digits and store in array
        while (number != 0) {
            if (index >= maxDigits) { // Resize array if needed
                int[] temp = new int[maxDigits * 2];
                System.arraycopy(digits, 0, temp, 0, maxDigits);
                digits = temp;
                maxDigits *= 2;
            }
            digits[index++] = number % 10;
            number /= 10;
        }

        // Find largest and second largest digits
        int largest = digits[0];
        int secondLargest = 0; 

        for (int i = 1; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        scanner.close();
    }
}
