import java.util.*;
 public class FactorOperation {
 public static int[] find(int num) {
    	int count = 0;
    	for (int i = 1; i <= num; i++) {
        	if (num % i == 0) {
            	count++;
        	}
    	}
    	int[]factors = new int[count];
    	int index = 0;
    	for (int i = 1; i <= num; i++) {
        	if (num % i == 0) {
            	factors[index++] = i;
        	}
    	}
    	return factors;
    }
    public static int sumOfFactors(int[] factors) {
    	int sum = 0;
  	  for (int factor : factors) {
        	sum += factor;
    	}
    	return sum;
    }
    public static long productOfFactors(int[] factors) {
    	long product = 1;
    	for (int factor : factors) {
        	product *= factor;
    	}
    	return product;
    }

    public static int sumOfSquareOfFactors(int[] factors) {
    	int sum = 0;
    	for (int factor : factors) {
        	sum += Math.pow(factor, 2);
    	}
    	return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    	System.out.print("Enter a number: ");
    	int num = sc.nextInt();
    	int[] factors = find(num);
    	System.out.print("Factors: ");
    	for (int factor : factors) {
        	System.out.print(factor + " ");
    	}
    	System.out.println();
    	System.out.println("Sum of factors: " + sumOfFactors(factors));
    	System.out.println("Product of factors: " + productOfFactors(factors));
    	System.out.println("Sum of square of factors: " + sumOfSquareOfFactors(factors));
    }
 }
