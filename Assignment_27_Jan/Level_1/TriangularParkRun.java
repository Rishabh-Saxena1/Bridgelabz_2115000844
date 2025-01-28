import java.util.Scanner;

public class TriangularParkRun {

    public static double calculateRounds(double side1, double side2, double side3, double targetDistance) {
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;

        // Calculate the number of rounds
        double rounds = targetDistance / perimeter;

        return rounds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        // Convert 5km to meters
        double targetDistance = 5000; 

        double rounds = calculateRounds(side1, side2, side3, targetDistance);

        System.out.println("The athlete needs to complete " + rounds + " rounds.");

        scanner.close();
    }
}
