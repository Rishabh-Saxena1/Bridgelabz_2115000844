import java.util.*;
 public class NumberChecker5 {
 	// Method to check if a number is a prime number
 	public static boolean isPrimeNumber(int number) {
     	if (number <= 1) return false;
     	for (int i = 2; i <= Math.sqrt(number); i++) {
         	if (number % i == 0) return false;
     	}
     	return true;
 	}

 	// Method to check if a number is a neon number
 	public static boolean isNeonNumber(int number) {
     	int square = number * number;
     	int sumOfDigits = 0;
     	while (square > 0) {
         	sumOfDigits += square % 10;
         	square /= 10;
     	}
     	return sumOfDigits == number;
 	}

     // Method to check if a number is a spy number
 	public static boolean isSpyNumber(int number) {
     	int sumOfDigits = 0, productOfDigits = 1;
     	while (number > 0) {
         	int digit = number % 10;
         	sumOfDigits += digit;
         	productOfDigits *= digit;
         	number /= 10;
     	}
     	return sumOfDigits == productOfDigits;
 	}

 	// Method to check if a number is an automorphic number
 	public static boolean isAutomorphicNumber(int number) {
     	int square = number * number;
     	return String.valueOf(square).endsWith(String.valueOf(number));
 	}

 	// Method to check if a number is a buzz number
 	public static boolean isBuzzNumber(int number) {
     	return number % 7 == 0 || number % 10 == 7;
 	}

 	public static void main(String[] args) {
     	Scanner sc = new Scanner (System.in);
 	System.out.print("Enter any number: ");
     	int primeNumber = sc.nextInt();
     	int neonNumber = sc.nextInt();
     	int spyNumber = sc.nextInt();
     	int automorphicNumber = sc.nextInt();
     	int buzzNumber = sc.nextInt();

     	System.out.println("Is " + primeNumber + " a prime number? " + isPrimeNumber(primeNumber));
     	System.out.println("Is " + neonNumber + " a neon number? " + isNeonNumber(neonNumber));
     	System.out.println("Is " + spyNumber + " a spy number? " + isSpyNumber(spyNumber));
     	System.out.println("Is " + automorphicNumber + " an automorphic number? " + isAutomorphicNumber(automorphicNumber));
     	System.out.println("Is " + buzzNumber + " a buzz number? " + isBuzzNumber(buzzNumber));
 	}
 }
