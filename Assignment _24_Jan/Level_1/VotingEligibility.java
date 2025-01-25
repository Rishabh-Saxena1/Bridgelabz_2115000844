import java.util.Scanner;

public class VotingEligibility {

    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Declare an array to store the ages of 10 students
        int[] studentAges = new int[10];

        // Get age input for each student
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            studentAges[i] = input.nextInt();

            // Validate age input
            if (studentAges[i] < 0) {
                System.err.println("Invalid age for student " + (i + 1) + ".");
                // You can choose to exit the program here or continue with the next student
                // System.exit(0); 
            }
        }

        // Check voting eligibility for each student
        for (int i = 0; i < studentAges.length; i++) {
            if (studentAges[i] >= 18) {
                System.out.println("The student with the age " + studentAges[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + studentAges[i] + " cannot vote.");
            }
        }

        // Close the Scanner object
        input.close();
    }
}
