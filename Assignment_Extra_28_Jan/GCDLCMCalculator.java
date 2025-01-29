import java.util.Scanner;

public class GCDLCMCalculator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int number1 = getIntegerInput(inputScanner, "Enter the first number: ");
        int number2 = getIntegerInput(inputScanner, "Enter the second number: ");

        int gcd = calculateGCD(number1, number2);
        int lcm = calculateLCM(number1, number2, gcd); // Pass the calculated GCD

        displayResult(number1, number2, gcd, lcm);

        inputScanner.close();
    }

    public static int getIntegerInput(Scanner inputScanner, String prompt) {
        System.out.print(prompt);
        return inputScanner.nextInt();
    }


    public static int calculateGCD(int a, int b) {
        // Euclidean algorithm (more efficient)
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;  // LCM formula
    }

    public static void displayResult(int num1, int num2, int gcd, int lcm) {
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}
