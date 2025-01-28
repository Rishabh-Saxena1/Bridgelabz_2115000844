import java.util.*;
 public class EuclideanDistance {
 	public static double calculateDistance(double x1, double y1, double x2, double y2) {
     	return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
 	}
 	public static double[] LinearEquation(double x1, double y1, double x2, double y2) {
     	double[] result = new double[2];
     	if (x1 == x2) {
         	throw new IllegalArgumentException("The line is vertical, slope is undefined.");
     	}
     	double slope = (y2 - y1) / (x2 - x1);
     	double yIntercept = y1 - slope * x1;
     	result[0] = slope;
     	result[1] = yIntercept;
     	return result;
 	}
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.print("Enter x1: ");
     	double x1 = sc.nextDouble();
     	System.out.print("Enter y1: ");
     	double y1 = sc.nextDouble();
     	System.out.print("Enter x2: ");
     	double x2 = sc.nextDouble();
     	System.out.print("Enter y2: ");
     	double y2 = sc.nextDouble();

     	double distance = calculateDistance(x1, y1, x2, y2);
     	System.out.println("The Euclidean distance between the points is: " + distance);
    	 try {
         	double[] lineEquation = LinearEquation(x1, y1, x2, y2);
         	System.out.printf("The equation of the line is: y = %.2fx + %.2f\n", lineEquation[0], lineEquation[1]);
     	} catch (IllegalArgumentException e) {
         	System.out.println(e.getMessage());
     	}
 	}
 }
