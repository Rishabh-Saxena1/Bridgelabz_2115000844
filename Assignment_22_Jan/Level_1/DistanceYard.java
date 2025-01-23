import java.util.*;
public class DistanceYard{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distanceInFeet, distanceInYards, distanceInMiles;
        System.out.print("Enter the distance in feet: ");
        distanceInFeet =sc.nextDouble();
        distanceInYards = distanceInFeet / 3;
        distanceInMiles = distanceInYards / 1760;
        System.out.println("The distance in feet is "+distanceInFeet+" in yards is "+distanceInYards+ " and in miles is "+distanceInMiles);
    }
}
