import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        String inputString = getInputString(inputScanner);
        boolean isPalindrome = checkPalindrome(inputString);
        displayResult(isPalindrome);

        inputScanner.close();
    }

    public static String getInputString(Scanner inputScanner) {
        System.out.print("Enter a string: ");
        return inputScanner.nextLine();
    }

    public static boolean checkPalindrome(String inputString) {
        String cleanedString = inputString.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric and lowercase
        String reversedString = new StringBuilder(cleanedString).reverse().toString();
        return cleanedString.equals(reversedString);
    }

    public static void displayResult(boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}
