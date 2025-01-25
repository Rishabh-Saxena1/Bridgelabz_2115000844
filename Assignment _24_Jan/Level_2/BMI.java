import java.util.*;
 public class BMI{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
   	System.out.print("number of persons: ");
    	int num = sc.nextInt();
   	double[][] personData = new double[num][3];
    	String[] weightStatus = new String[num];

    	for (int i = 0; i < num; i++) {
        	double weight, height;

        	do {
            	System.out.print("weight for person " + (i + 1) + " (in kg): ");
            	weight = sc.nextDouble();
            	if (weight <= 0) {
                	System.out.println("cannot be negative or zero,Please enter a positive value.");
            	}
        	} while (weight <= 0);

        	do {
            	System.out.print("heights for person " + (i + 1) + " : ");
            	height = sc.nextDouble();
            	if (height <= 0) {
                	System.out.println("cannot be negative or zero,Please enter a positive value.");
            	}
        	} while (height <= 0);
      	personData[i][0] = weight;
        	personData[i][1] = height;

        	double bmi = weight / (height * height);
        	personData[i][2] = bmi;

        	if (bmi < 18.5) {
            	weightStatus[i] = "Underweight";
        	} else if (bmi >= 18.5 && bmi < 24.9) {
            	weightStatus[i] = "Normal weight";
        	} else if (bmi >= 25 && bmi < 29.9) {
            	weightStatus[i] = "Overweight";
        	} else {
            	weightStatus[i] = "Obese";
        	}
    	}

    	for (int i = 0; i < num; i++) {
        	System.out.println("Person " + (i + 1) + ": Height = " + personData[i][1] + "m, Weight = " + personData[i][0]
                	+ "kg, BMI = " + personData[i][2] + ", Status = " + weightStatus[i]);
    	}
    }
 }
