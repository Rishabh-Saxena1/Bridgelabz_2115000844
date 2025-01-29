import java.util.Scanner;
public class substringOccurrences{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Input the main string
        System.out.println("Enter the main string:");
        String mainString = sc.nextLine();

        // Input the substring to find
        System.out.println("Enter the substring to find:");
        String subString = sc.nextLine();

        // Count occurrences
        int count = countOccurrences(mainString, subString);
        System.out.println("Occurrences of \"" + subString + "\": " + count);
    }
    // Method to count occurrences of substring
    public static int countOccurrences(String mainString, String subString) {
        if (subString.isEmpty()) {
            return 0; // Prevent infinite loop if substring is empty
        }

        int count = 0;
        int index = 0;

        // Find all occurrences using indexOf
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index++; // Move index by 1 to check for overlapping occurrences
        }

        return count;
    }
}
