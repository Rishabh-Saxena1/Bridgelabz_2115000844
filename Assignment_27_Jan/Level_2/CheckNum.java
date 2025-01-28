import java.util.Scanner;
 public class CheckNum{
    public static boolean isPositive(int num) {
    	return num >= 0;
    }

    public static boolean isEven(int num) {
    	return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
    	if (num1 > num2) return 1;
    	else if (num1 < num2) return -1;
    	else return 0;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] num= new int[5];

    	for (int i = 0; i < num.length; i++) {
        	num[i] = sc.nextInt();
    	}

    	for (int i = 0; i < num.length; i++) {
        	if (isPositive(num[i])) {
            	if (isEven(num[i])) {
                	System.out.println(num[i] + " is Positive and Even");
            	} else {
                	System.out.println(num[i] + " is Positive and Odd");
            	}
      	  } else {
            	System.out.println(num[i] + " is Negative");
        	}
    	}

    	int comparisonResult = compare(num[0], num[num.length - 1]);
    	if (comparisonResult == 1) {
        	System.out.println("First element is greater than last element");
    	} else if (comparisonResult == -1) {
        	System.out.println("First element is less than last element");
    	} else {
        	System.out.println("First element is equal to last element");
    	}
   	}
 }
