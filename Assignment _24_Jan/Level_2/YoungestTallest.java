import java.util.Scanner;

public class YoungestTallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        // Get input for age and height of each friend
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for friend " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height for friend " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Find the youngest friend
        int youngestAge = ages[0];
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestIndex = i;
            }
        }

        // Find the tallest friend
        double tallestHeight = heights[0];
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("Youngest friend: Friend " + (youngestIndex + 1));
        System.out.println("Tallest friend: Friend " + (tallestIndex + 1));

        scanner.close();
    }
}
