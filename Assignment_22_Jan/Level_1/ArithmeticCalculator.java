import java.util.*;
public class ArithmeticCalculator{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number 1");
        float number1 = sc.nextFloat();
        System.out.print("Enter the number 2");
        float number2 = sc.nextFloat();
        // Addition
        float add = number1 + number2;
        // Subtraction
        float sub = number1 - number2;
        // Multiplication
        float mul = number1 * number2;
        // Divison
        float div = number1/number2;
        System.out.print("The addition, subtraction, multiplication and division value of 2 numbers "+ number1 + " and " + number2 + " is " + add + "," + sub + "," + mul + " and " + div);
    }
}
