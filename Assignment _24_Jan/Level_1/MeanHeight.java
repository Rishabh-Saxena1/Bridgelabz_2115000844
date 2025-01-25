import java.util.Scanner;

public class MeanHeight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];

        // Get input for heights of 11 players
        System.out.println("Enter heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        // Calculate the sum of heights
        double sum = 0;
        for (double height : heights) {
            sum += height;
        }

        // Calculate the mean height
        double meanHeight = sum / heights.length;

        // Print the mean height
        System.out.println("Mean height of the players: " + meanHeight);

        scanner.close();
    }
}
