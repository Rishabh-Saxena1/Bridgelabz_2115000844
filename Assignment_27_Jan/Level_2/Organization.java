import java.util.Scanner;
 public class Organization{
 public static void main(String[] args) {
    	double[][] data = new double[10][3];
    	Scanner sc = new Scanner(System.in);
   	for (int i = 0; i < 10; i++) {
        	data[i][0] = sc.nextDouble();
        	data[i][1] = sc.nextDouble();
    	}
   	calculate(data);
    	String[] statuses=BMIStatus(data);

    	for (int i = 0; i < 10; i++) {
        	System.out.println("Person = "+i+1+" Weight = "+data[i][0]+ " Height = "+data[i][1] +" BMI = "+data[i][2]+" Status = "+statuses[i]);
    	}
    }
    public static void calculate(double[][] data) {
    	for (int i = 0; i < data.length; i++) {
        	double heightInMeters = data[i][1] / 100;
        	data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
    	}
    }

    public static String[] BMIStatus(double[][] data) {
    	String[] statuses = new String[data.length];

    	for (int i = 0; i < data.length; i++) {
        	double bmi = data[i][2];

        	if (bmi < 18.5) {
            	statuses[i] = "Underweight";
        	} else if (bmi < 24.9) {
            	statuses[i] = "Normal weight";
        	} else if (bmi < 29.9) {
            	statuses[i] = "Overweight";
        	} else {
            	statuses[i] = "Obese";
        	}
    	}

    	return statuses;
    }
 }
