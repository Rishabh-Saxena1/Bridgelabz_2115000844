import java.util.*;
public class UserKiloToMiles{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance in kilometers: ");
        double km = sc.nextDouble();
        double miles = km / 1.6; //Conversion
        System.out.print("The total miles is "+miles+" miles for the given "+ km);
    }
}
