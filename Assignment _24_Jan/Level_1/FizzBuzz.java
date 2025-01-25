import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        String[] results = new String[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = Integer.toString(i); 
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        scanner.close();
    }
}
