import java.util.Scanner;

public class MaxOfThreeNumbers {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int firstNumber = getUserIntegerInput(inputScanner, "Enter the first number: ");
        int secondNumber = getUserIntegerInput(inputScanner, "Enter the second number: ");
        int thirdNumber = getUserIntegerInput(inputScanner, "Enter the third number: ");

        int maximumNumber = findMaximumOfThree(firstNumber, secondNumber, thirdNumber);

        System.out.println("The maximum of the three numbers is: " + maximumNumber);

        inputScanner.close();
    }

    public static int getUserIntegerInput(Scanner inputScanner, String promptMessage) {
        System.out.print(promptMessage);
        return inputScanner.nextInt();
    }

    public static int findMaximumOfThree(int numberOne, int numberTwo, int numberThree) {
        int currentMaximum = numberOne;

        if (numberTwo > currentMaximum) {
            currentMaximum = numberTwo;
        }

        if (numberThree > currentMaximum) {
            currentMaximum = numberThree;
        }

        return currentMaximum;
    }
}
