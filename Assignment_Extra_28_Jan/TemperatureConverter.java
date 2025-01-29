import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Menu:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = inputScanner.nextInt();

        if (choice == 1) {
            double fahrenheit = getTemperatureInput(inputScanner, "Enter temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            displayResult(fahrenheit, celsius, "Fahrenheit", "Celsius");

        } else if (choice == 2) {
            double celsius = getTemperatureInput(inputScanner, "Enter temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            displayResult(celsius, fahrenheit, "Celsius", "Fahrenheit");
        } else {
            System.out.println("Invalid choice.");
        }

        inputScanner.close();
    }

    public static double getTemperatureInput(Scanner inputScanner, String prompt) {
        System.out.print(prompt);
        return inputScanner.nextDouble();
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static void displayResult(double inputTemp, double convertedTemp, String inputUnit, String outputUnit) {
        System.out.println(inputTemp + " degrees " + inputUnit + " is equal to " + convertedTemp + " degrees " + outputUnit + ".");
    }
}
