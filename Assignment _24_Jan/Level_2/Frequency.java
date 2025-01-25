import java.util.Scanner;
 public class Frequency {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter a number: ");
 int num = sc.nextInt();
 int[] d = new int[10];  //digits Array
 int[] freq = new int[10]; //Frequency Array
 int temp = num;
 int cnt = 0;
 while (temp > 0) {
 d[cnt] = temp % 10;
 temp /= 10;
 cnt++;
 }
 for (int i = 0; i < cnt; i++) {
 freq[d[i]]++;
 }
 for (int i = 0; i < 10; i++) {
 if (freq[i] > 0) {
 System.out.println("Digit " + i + " appears " + freq[i] + " times");
 }
 }
 }
 }
