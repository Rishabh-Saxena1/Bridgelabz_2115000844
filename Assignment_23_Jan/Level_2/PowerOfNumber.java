import java.util.*;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base number: ");
        int number = sc.nextInt();
        System.out.print("Enter the power: ");
        int p = sc.nextInt();

        int result = 1;

        // Calculate power using a loop
        for (int i = 1; i <= p; i++) {
            result *= number;  // Multiply result by the base number
        }
        System.out.println(number + " raised to the power of " + p + " is: " + result);
    }
}
