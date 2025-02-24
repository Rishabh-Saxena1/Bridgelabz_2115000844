import java.lang.reflect.Method;

public class PrivateMethodInvocation {

    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Class<?> calculatorClass = calculator.getClass();
        Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        int result = (int) multiplyMethod.invoke(calculator, 5, 3);
        System.out.println("Result: " + result);
    }

    static class Calculator {
        private int multiply(int a, int b) {
            return a * b;
        }
    }
}
