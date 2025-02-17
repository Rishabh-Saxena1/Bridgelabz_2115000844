import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter number");
        int num = sc.nextInt();
       
        // Measure time for Recursive Fibonacci
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(num);
        long recursiveTime = System.nanoTime() - startTime;
       
        // Measure time for Iterative Fibonacci
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(num);
        long iterativeTime = System.nanoTime() - startTime;
       
        System.out.println("Fibonacci Number: " + num);
        System.out.println("Recursive Fibonacci Result: " + recursiveResult + " | Time: " + recursiveTime / 1000000.0 + " ms");
        System.out.println("Iterative Fibonacci Result: " + iterativeResult + " | Time: " + iterativeTime / 1000000.0 + " ms");
    }

    public static int fibonacciRecursive(int num) {
        if (num <= 1){
            return num;
        }
        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }

    public static int fibonacciIterative(int num) {
        if (num <= 1){
            return num;
        }
        int a = 0, b = 1, sum;
        for (int i = 2; i <= num; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
