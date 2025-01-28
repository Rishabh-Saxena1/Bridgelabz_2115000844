import java.util.*;
 public class DivideChocolates {
 	public static int[] findRemainderQuotient(int num, int divisor) {
     	int[] result = new int[2];
     	result[0] = num / divisor;
     	result[1] = num % divisor;
     	return result;
 	}
 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.print("Enter the total number of chocolates: ");
     	int noOfChocolates = sc.nextInt();
     	System.out.print("Enter the number of children: ");
     	int noOfChildren = sc.nextInt();
     	if (noOfChildren == 0) {
         	System.out.println("Number of children cannot be zero.");
     	}
 	else {
         	int[] result = findRemainderQuotient(noOfChocolates, noOfChildren);
         	System.out.println("Each child will get " + result[0] + " chocolates.");
         	System.out.println("Remaining chocolates: " + result[1]);
     	}
 	}
 }

