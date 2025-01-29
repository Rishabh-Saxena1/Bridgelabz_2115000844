import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a number to check for primality: ");
        int numberToCheck = inputScanner.nextInt();

        boolean isPrime = isPrimeNumber(numberToCheck);

        if (isPrime) {
            System.out.println(numberToCheck + " is a prime number.");
        } else {
            System.out.println(numberToCheck + " is not a prime number.");
        }

        inputScanner.close();
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }

        // Optimization: Check only up to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Divisible by a number other than 1 and itself
            }
        }

        return true; // No divisors found, it's a prime number
    }
}
