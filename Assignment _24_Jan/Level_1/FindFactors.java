import java.util.Scanner;

public class FindFactors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Initializing variables
        int maxFactors = 10; 
        int[] factors = new int[maxFactors]; 
        int index = 0; 

        // Finding factors and storing in array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index >= maxFactors) {
                    // Resize the array if needed
                    int[] temp = new int[maxFactors * 2]; 
                    System.arraycopy(factors, 0, temp, 0, maxFactors); 
                    factors = temp; 
                    maxFactors *= 2; 
                }
                factors[index++] = i; 
            }
        }

        // Displaying factors
        System.out.print("Factors of " + number + ": ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
