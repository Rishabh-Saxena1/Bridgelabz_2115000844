import java.util.ArrayList;
 public class NumberChecker6 {

 	// Method to find factors of a number and return them as an array
 	public static int[] getFactors(int number) {
     	int count = 0;

     	// First loop: Count the number of factors
     	for (int i = 1; i <= number; i++) {
         	if (number % i == 0) {
             	count++;
         	}
     	}

     	int[] factors = new int[count];
     	int index = 0;

     	// Second loop: Store the factors in the array
     	for (int i = 1; i <= number; i++) {
     	    if (number % i == 0) {
             	factors[index++] = i;
         	}
     	}
     	return factors;
 	}

 	// Method to find the greatest factor of a number using the factors array
 	public static int getGreatestFactor(int number) {
     	int[] factors = getFactors(number);
     	return factors[factors.length - 1]; // The greatest factor is the last element
 	}

 	// Method to find the sum of the factors using the factors array
 	public static int getSumOfFactors(int number) {
     	int[] factors = getFactors(number);
     	int sum = 0;
     	for (int factor : factors) {
         	sum += factor;
     	}
     	return sum;
 	}

 	// Method to find the product of the factors using the factors array
 	public static int getProductOfFactors(int number) {
     	int[] factors = getFactors(number);
     	int product = 1;
     	for (int factor : factors) {
         	product *= factor;
     	}
     	return product;
 	}

 	// Method to find the product of the cube of the factors
 	public static double getProductOfCubesOfFactors(int number) {
     	int[] factors = getFactors(number);
     	double product = 1;
     	for (int factor : factors) {
         	product *= Math.pow(factor, 3);
     	}
     	return product;
 	}

 	// Method to check if a number is a perfect number
 	public static boolean isPerfectNumber(int number) {
     	int[] factors = getFactors(number);
     	int sum = 0;

     	// Exclude the number itself from the sum of factors
     	for (int i = 0; i < factors.length - 1; i++) {
         	sum += factors[i];
     	}
     	return sum == number;
 	}

 	// Method to check if a number is an abundant number
 	public static boolean isAbundantNumber(int number) {
     	int[] factors = getFactors(number);
     	int sum = 0;

     	// Exclude the number itself from the sum of factors
     	for (int i = 0; i < factors.length - 1; i++) {
         	sum += factors[i];
 	    }
     	return sum > number;
 	}

 	// Method to check if a number is a deficient number
 	public static boolean isDeficientNumber(int number) {
     	int[] factors = getFactors(number);
     	int sum = 0;

     	// Exclude the number itself from the sum of factors
     	for (int i = 0; i < factors.length - 1; i++) {
         	sum += factors[i];
     	}
     	return sum < number;
 	}

 	// Method to check if a number is a strong number
 	public static boolean isStrongNumber(int number) {
     	int originalNumber = number;
     	int sum = 0;

     	while (number > 0) {
         	int digit = number % 10;
         	sum += factorial(digit);
         	number /= 10;
     	}
     	return sum == originalNumber;
 	}

 	// Helper method to calculate factorial of a number
 	public static int factorial(int number) {
     	if (number == 0 || number == 1) return 1;
     	int result = 1;
     	for (int i = 2; i <= number; i++) {
         	result *= i;
     	}
     	return result;
 	}

 	public static void main(String[] args) {
     	// Test numbers
     	int number = 28;  // Perfect number
     	int abundantNumber = 12; // Abundant number
     	int deficientNumber = 15; // Deficient number
    	 int strongNumber = 145; // Strong number

     	// Get factors
     	int[] factors = getFactors(number);
     	System.out.print("Factors of " + number + ": ");
     	for (int factor : factors) {
         	System.out.print(factor + " ");
     	}
     	System.out.println();
     	System.out.println("Greatest factor: " + getGreatestFactor(number));
     	System.out.println("Sum of factors: " + getSumOfFactors(number));
     	System.out.println("Product of factors: " + getProductOfFactors(number));
     	System.out.println("Product of cubes of factors: " + getProductOfCubesOfFactors(number));
     	System.out.println("Is " + number + " a perfect number? " + isPerfectNumber(number));
     	System.out.println("Is " + abundantNumber + " an abundant number? " + isAbundantNumber(abundantNumber));
     	System.out.println("Is " + deficientNumber + " a deficient number? " + isDeficientNumber(deficientNumber));
     	System.out.println("Is " + strongNumber + " a strong number? " + isStrongNumber(strongNumber));
 	}
 }
