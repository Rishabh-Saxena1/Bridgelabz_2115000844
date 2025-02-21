import java.io.*;
import java.util.*;
public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();
            System.out.print("Enter denominator: ");
            int deno = sc.nextInt();
            int result = num / deno;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }
        finally {
            sc.close();
        }
    }
}
