import java.util.*;
public class HeightConversion{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double height = sc.nextDouble();
        double heightInInches = height / 2.54;
        double heightInFeet = Math.floor(heightInInches / 12);
        double remainingInches = heightInInches % 12;
System.out.println("Your height in cm is "+height+" while in feet is "+heightInFeet+" and inches is "+remainingInches);
    }
}
