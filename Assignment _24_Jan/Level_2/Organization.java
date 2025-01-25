import java.util.*;
 public class Organization {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    System.out.print("number of persons: ");
    	int Persons = sc.nextInt();
   	double[] weight = new double[Persons];
    	double[] height = new double[Persons];
    	double[] bmi = new double[Persons];
    	String[] weightStatus = new String[Persons];
   	for (int i = 0; i < Persons; i++) {
        	do {
            	System.out.print("weight for person " + (i + 1) + " (in kg): ");
            	weight[i] = sc.nextDouble();
            	if (weight[i] <= 0) {
                	System.out.println("must be a positive number.");
            	}
        	} while (weight[i] <= 0);

        	do {
            	System.out.print("height for person " + (i + 1) + " (in meters): ");
         	   height[i] = sc.nextDouble();
            	if (height[i] <= 0) {
                	System.out.println("must be a positive number.");
            	}
        	} while (height[i] <= 0);

        	bmi[i] = weight[i] / (height[i] * height[i]);

        	if (bmi[i] < 18.5) {
            	weightStatus[i] = "Underweight";
        	} else if (bmi[i] >= 18.5 && bmi[i] < 24.9) {
            	weightStatus[i] = "Normal weight";
        	} else if (bmi[i] >= 25 && bmi[i] < 29.9) {
           	 weightStatus[i] = "Overweight";
        	} else {
            	weightStatus[i] = "Obese";
        	}
    	}
   	for (int i = 0; i <Persons; i++) {
        	System.out.println("Person " + (i + 1) + ": Height = " + height[i] + "m, Weight = " + weight[i] + "kg, BMI = " + bmi[i] + ", Status = " + weightStatus[i]);
    	}
    }
 }
