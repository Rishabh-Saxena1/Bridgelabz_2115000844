import java.util.*;
 public class StudentReportCard{
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.print("Enter the number of students: ");
     	int noOfStudents = sc.nextInt();
     	int[][] scores = generateScores(noOfStudents);
     	double[][] results = calculateResults(scores);
     	displayScorecard(scores, results);
 	}
 	public static int[][] generateScores(int noOfStudents) {
     	Random rand = new Random();
     	int[][] scores = new int[noOfStudents][3];
     	for (int i = 0; i < noOfStudents; i++) {
         	scores[i][0] = rand.nextInt(90) + 10;
         	scores[i][1] = rand.nextInt(90) + 10;
         	scores[i][2] = rand.nextInt(90) + 10;
     	}
     	return scores;
 	}
 	public static double[][] calculateResults(int[][] scores) {
     	double[][] results = new double[scores.length][3];
     	for (int i = 0; i < scores.length; i++) {
         	int total = scores[i][0] + scores[i][1] + scores[i][2];
         	double average = total / 3.0;
         	double percentage = (total / 300.0) * 100;

         	results[i][0] = Math.round(total * 100.0) / 100.0;
         	results[i][1] = Math.round(average * 100.0) / 100.0;
         	results[i][2] = Math.round(percentage * 100.0) / 100.0;
     	}
     	return results;
 	}
 	public static void displayScorecard(int[][] scores, double[][] results) {
     	System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
     	for (int i = 0; i < scores.length; i++) {
         	System.out.print("Student " + (i + 1) + "\t");
         	System.out.print(scores[i][0] + "\t");
         	System.out.print(scores[i][1] + "\t\t");
         	System.out.print(scores[i][2] + "\t");
         	System.out.print(results[i][0] + "\t");
         	System.out.print(results[i][1] + "\t");
         	System.out.print(results[i][2]);
         	System.out.println();
     	}
 	}
 }
