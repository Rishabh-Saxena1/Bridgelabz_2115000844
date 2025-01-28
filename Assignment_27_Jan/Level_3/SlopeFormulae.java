import java.util.*;
 public class SlopeFormulae {
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.println("Enter coordinates of point A (x1, y1):");
     	double x1 = sc.nextDouble();
     	double y1 = sc.nextDouble();

     	System.out.println("Enter coordinates of point B (x2, y2):");
     	double x2 = sc.nextDouble();
     	double y2 = sc.nextDouble();

     	System.out.println("Enter coordinates of point C (x3, y3):");
     	double x3 = sc.nextDouble();
     	double y3 = sc.nextDouble();

     	if (collinearUsingSlope(x1, y1, x2, y2, x3, y3)) {
         	System.out.println("The points are collinear using the slope formula.");
     	}
     	else {
         	System.out.println("The points are not collinear using the slope formula.");
     	}

     	if (collinearUsingArea(x1, y1, x2, y2, x3, y3)) {
         	System.out.println("The points are collinear using the area of triangle formula.");
     	}
     	else {
   	      System.out.println("The points are not collinear using the area of triangle formula.");
     	}
 	}

 	public static boolean collinearUsingSlope(double x1, double y1, double x2, double y2, double x3, double y3) {
     	double slopeAB = (y2 - y1) / (x2 - x1);
     	double slopeBC = (y3 - y2) / (x3 - x2);
     	double slopeAC = (y3 - y1) / (x3 - x1);
     	return slopeAB == slopeBC && slopeBC == slopeAC;
 	}

 	public static boolean collinearUsingArea(double x1, double y1, double x2, double y2, double x3, double y3) {
     	double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
     	return area == 0;
 	}
 }
