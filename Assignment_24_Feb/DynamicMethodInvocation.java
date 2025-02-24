import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {

    public static void main(String[] args) throws Exception {
        MathOperations mathOperations = new MathOperations();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first argument: ");
        int arg1 = scanner.nextInt();

        System.out.print("Enter second argument: ");
        int arg2 = scanner.nextInt();

        scanner.close();

        try {
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
            int result = (int) method.invoke(mathOperations, arg1, arg2);
            System.out.println("Result of " + methodName + ": " + result);
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + methodName);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    static class MathOperations {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }
    }
}
