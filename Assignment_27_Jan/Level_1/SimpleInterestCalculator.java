import java.util.Scanner;

public class SimpleInterestCalculator {

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest (%): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        double simpleInterest = calculateSimpleInterest(principal, rate, time);

        System.out.println("\nThe Simple Interest is " + simpleInterest + 
                " for Principal " + principal + 
                ", Rate of Interest " + rate + "%" + 
                " and Time " + time + " years.");

        scanner.close();
    }
}
