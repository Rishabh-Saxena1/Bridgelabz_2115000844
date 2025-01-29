import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int computerGuess;
        String userFeedback;
        boolean correctGuess = false;

        System.out.println("Think of a number between 1 and 100.");

        while (!correctGuess) {
            computerGuess = generateGuess(lowerBound, upperBound, randomGenerator);
            System.out.println("My guess is: " + computerGuess);

            userFeedback = getUserFeedback(inputScanner);

            if (userFeedback.equalsIgnoreCase("correct")) {
                correctGuess = true;
                System.out.println("I guessed it! The number is " + computerGuess);
            } else if (userFeedback.equalsIgnoreCase("high")) {
                upperBound = computerGuess - 1;
            } else if (userFeedback.equalsIgnoreCase("low")) {
                lowerBound = computerGuess + 1;
            } else {
                System.out.println("Invalid feedback. Please enter 'high', 'low', or 'correct'.");
            }

            if(lowerBound > upperBound){
                System.out.println("You have cheated. Number can not be in this range.");
                break;
            }
        }

        inputScanner.close();
    }

    public static int generateGuess(int lower, int upper, Random random) {
        return lower + random.nextInt(upper - lower + 1);
    }

    public static String getUserFeedback(Scanner inputScanner) {
        System.out.print("Is the number high, low, or correct? ");
        return inputScanner.nextLine();
    }
}
