import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (true) { // Loop for multiple calculations
            System.out.println("\nBasic Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = inputScanner.nextInt();

            if (choice == 5) {
                break; // Exit the loop if the user chooses 5
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                continue; // Go back to the beginning of the loop
            }

            System.out.print("Enter the first number: ");
            double num1 = inputScanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = inputScanner.nextDouble();

            double result = 0;

            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
            }

            System.out.println("Result: " + result);
        }

        inputScanner.close();
        System.out.println("Exiting calculator.");
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN; // Return "Not a Number" for division by zero
        }
        return x / y;
    }
}
