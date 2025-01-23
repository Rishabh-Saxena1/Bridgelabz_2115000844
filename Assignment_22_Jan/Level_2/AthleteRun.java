import java.util.*;
public class AthleteRun{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Taking user inputs for the sides of the triangular park
        System.out.print("Enter the first side of the triangular park: ");
        double side1=sc.nextDouble();
        System.out.print("Enter the second side of the triangular park: ");
        double side2=sc.nextDouble();
        System.out.print("Enter the third side of the triangular park: ");
        double side3=sc.nextDouble();
        // Calculating the perimeter of the triangle
        double perimeter=side1+side2+side3;
        // Total distance to complete(5 km=5000 meters)
        double totalDistance=5000.0;
        // Calculating the number of rounds
        double rounds=totalDistance/perimeter;

        // Displaying the result (rounding up to the nearest whole number)
        System.out.println("The total number of rounds the athlete will run is " +
                           (int)Math.ceil(rounds) + " to complete 5 km.");
    }
}
