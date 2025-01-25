import java.util.Scanner;
 public class Grades {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[][] M = new int[5][3]; //Array to store Marks
    	double[] percentages = new double[5]; //Array to store Percentage
    	char[] grades = new char[5];
   	for (int i = 0; i < 5; i++) {
        	System.out.print("marks for Physics, Chemistry, and Maths for student " + (i + 1) + ": ");
        	for (int j = 0; j < 3; j++) {
            	M[i][j] = sc.nextInt();
        	}
    	}
   	for (int i = 0; i < 5; i++) {
        	int total = 0;
        	for (int j = 0; j < 3; j++) {
            	total += M[i][j];
        	}
        	percentages[i] = (total / 3.0);
        	if (percentages[i] >= 90) {
            	grades[i] = 'A';
        	} else if (percentages[i] >= 75) {
            	grades[i] = 'B';
        	} else if (percentages[i] >= 50) {
  	          grades[i] = 'C';
        	} else {
            	grades[i] = 'D';
        	}
    	}//display result
   	for (int i = 0; i < 5; i++) {
        	System.out.println("Student " + (i + 1) + ": Percentage = " + percentages[i] + "%, Grade = " + grades[i]);
    	}
    }
 }
