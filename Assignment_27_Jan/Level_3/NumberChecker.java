import java.util.ArrayList;
 import java.util.List;
 import java.util.*;

 public class NumberChecker{

 	// Method to count of digits in a number
 	public static int countDigits(int number) {
         	return String.valueOf(number).length();
     	}

     	// Method to store digits of the number in an array
     	public static int[] getDigitsArray(int number) {
         	String numStr = String.valueOf(number);
         	int[] digits = new int[numStr.length()];
         	for (int i = 0; i < numStr.length(); i++) {
                 	digits[i] = numStr.charAt(i) - '0';
         	}
         	return digits;
     	}

     	// Method to check if a number is a duck number
     	public static boolean isDuckNum(int[] digitsArray) {
         	for (int i = 1; i < digitsArray.length; i++) {
                 	if (digitsArray[i] == 0) {
                     	return true;
                 	}
         	}
         	return false;
     	}

     	// Method to check if the number is an Armstrong number
     	public static boolean isArmstrongNum(int number) {
         	int[] digitsArray = getDigitsArray(number);
         	int sum = 0;
         	int power = digitsArray.length;
         	for (int digit : digitsArray) {
                 	sum += Math.pow(digit, power);
         	}
         	return sum == number;
     	}

     	// Method to find the largest and second largest elements
     	public static int[] findLargestSecondLargest(int[] digitsArray) {
   	      int largest = Integer.MIN_VALUE;
         	int secondLargest = Integer.MIN_VALUE;

         	for (int digit : digitsArray) {
                 	if (digit > largest) {
                     	secondLargest = largest;
                     	largest = digit;
                 	}
         	else if (digit > secondLargest && digit != largest) {
                     	secondLargest = digit;
                 	}
         	}
         	return new int[]{largest, secondLargest};
     	}

     	// Method to find the smallest and second smallest elements
     	public static int[] findSmallestSecondSmallest(int[] digitsArray) {
         	int smallest = Integer.MAX_VALUE;
         	int secondSmallest = Integer.MAX_VALUE;

         	for (int digit : digitsArray) {
                 	if (digit < smallest) {
                     	secondSmallest = smallest;
                     	smallest = digit;
                 	}
         	else if (digit < secondSmallest && digit != smallest) {
   	                  secondSmallest = digit;
                 	}
         	}
     	return new int[]{smallest, secondSmallest};
     	}

 	public static void main(String[] args) {
         	Scanner sc = new Scanner (System.in);
     	System.out.println("Enter number: ");
     	int number = sc.nextInt();

         	System.out.println("Number: " + number);
         	System.out.println("Count of digits: " + countDigits(number));

         	int[] digitsArray = getDigitsArray(number);
    	     System.out.print("Digits array: ");
         	for (int digit : digitsArray) {
                 	System.out.print(digit + " ");
         	}
         	System.out.println();

         	System.out.println("Is Duck Number: " + isDuckNum(digitsArray));
         	System.out.println("Is Armstrong Number: " + isArmstrongNum(number));

         	int[] largestAndSecondLargest = findLargestSecondLargest(digitsArray);
         	System.out.println("Largest digit: " + largestAndSecondLargest[0]);
         	System.out.println("Second largest digit: " + largestAndSecondLargest[1]);

         	int[] smallestAndSecondSmallest = findSmallestSecondSmallest(digitsArray);
         	System.out.println("Smallest digit: " + smallestAndSecondSmallest[0]);
         	System.out.println("Second smallest digit: " + smallestAndSecondSmallest[1]);
     	}
 }
