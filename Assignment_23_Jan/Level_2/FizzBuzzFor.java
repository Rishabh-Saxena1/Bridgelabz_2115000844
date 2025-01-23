import java.util.*;
public class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if the number is positive or not
        if (number > 0) {
            System.out.println("FizzBuzz results:");
            // Loop from 0 to the input number
            for (int i = 0; i <= number; i++) {
                // Check conditions for Fizz, Buzz, and FizzBuzz
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
        else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
        else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
        else {
                    System.out.println(i);
                }
            }
        }
    else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
