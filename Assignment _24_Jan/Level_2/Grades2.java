import java.util.*;
 public class Grades2 {
 public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
   	System.out.print("number of students: ");
    	int Students = sc.nextInt();
   	int[][] marks = new int[Students][3];
    	double[] percentages = new double[Students];
    	char[] grades = new char[Students];
   	for (int i = 0; i < Students; i++) {
        	System.out.println("Enter marks for student " + (i + 1));
        	for (int j = 0; j < 3; j++) {
            	do {
                	System.out.print("Enter marks for subject " + (j + 1) + ": ");
                	marks[i][j] = sc.nextInt();
                	if (marks[i][j] < 0) {
                    	System.out.println("Marks cannot be negative. Please enter positive values.");
                	}
            	} while (marks[i][j] < 0);
        	}
    	}
   	for (int i = 0; i <Students; i++) {
        	int total= 0;
        	for (int j = 0; j < 3; j++) {
            	total+= marks[i][j];
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
    	}
   	for (int i = 0; i < Students; i++) {
        	System.out.println("Student " + (i + 1) + ": Marks = " + marks[i][0] + ", " + marks[i][1] + ", " + marks[i][2]
                	+ ", Percentage = " + percentages[i] + "%, Grade = " + grades[i]);
    	}
    }
 }
