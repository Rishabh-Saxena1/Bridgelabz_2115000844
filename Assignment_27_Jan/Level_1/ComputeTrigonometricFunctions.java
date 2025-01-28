import java.util.*;
 public class ComputeTrigonometricFunctions{
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.print("Enter the angle in degrees: ");
     	double angle = sc.nextDouble();
     	double[] results = calculateTrigonometricFunctions(angle);
     	System.out.println("For angle " + angle + " degrees:");
     	System.out.println("Sine: " + results[0]);
     	System.out.println("Cosine: " + results[1]);
     	System.out.println("Tangent: " + results[2]);
 	}
 	public static double[] calculateTrigonometricFunctions(double angle) {
     	double radians = Math.toRadians(angle);
     	double sine = Math.sin(radians);
     	double cosine = Math.cos(radians);
     	double tangent = Math.tan(radians);
     	return new double[] {sine, cosine, tangent};
 	}
 }
