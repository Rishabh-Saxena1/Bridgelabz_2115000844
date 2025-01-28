import java.util.Scanner;
 public class Friends{
 public static int findYoungest(int[] ages) {
 int youngestIndex = 0;
 for (int i = 1; i < ages.length; i++) {
 if (ages[i] < ages[youngestIndex]) {
 youngestIndex = i;
 }
 }
 return youngestIndex;
 }
 public static int findTallest(double[] heights) {
 int tallestIndex = 0;
 for (int i = 1; i < heights.length; i++) {
 if (heights[i] > heights[tallestIndex]) {
 tallestIndex = i;
 }
 }
 return tallestIndex;
 }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 String[] names = {"Amar", "Akbar", "Anthony"};
 int[] ages = new int[3];
 double[] heights = new double[3];
 for(int i = 0; i < 3; i++) {
 System.out.print("Enter the age of " + names[i] + ": ");
 ages[i] = sc.nextInt();
 System.out.print("Enter the height of " + names[i] + " in cm: ");
 heights[i] = sc.nextDouble();
 }
 int youngestIndex = findYoungest(ages);
 int tallestIndex = findTallest(heights);
 System.out.println(names[youngestIndex] + " is the youngest.");
 System.out.println(names[tallestIndex] + " is the tallest.");
 }
 }
