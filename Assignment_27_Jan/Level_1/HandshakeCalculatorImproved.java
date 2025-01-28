import java.util.Scanner;

public class HandshakeCalculatorImproved { // Changed class name

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int totalHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println("Maximum number of handshakes possible: " + totalHandshakes);

        scanner.close();
    }
}
