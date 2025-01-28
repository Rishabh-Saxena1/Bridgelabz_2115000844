import java.util.*;
 public class Random{
 public static int[] generate4Digit(int size) {
    	int[] numbers = new int[size];
    	for (int i = 0; i < size; i++) {
        	numbers[i] = (int) (Math.random() * 9000) + 1000;
    	}
    	return numbers;
    }

    public static double[] AverageMinMax(int[] numbers) {
    	double[] result = new double[3];
    	int minValue = numbers[0];
    	int maxValue = numbers[0];
    	int sum = 0;

    	for (int number : numbers) {
        	sum += number;
            minValue = Math.min(minValue, number);
        	maxValue = Math.max(maxValue, number);
    	}

    	double average = (double) sum / numbers.length;

    	result[0] = average;
    	result[1] = minValue;
    	result[2] = maxValue;

    	return result;
    }
 public static void main(String[] args) {
    	int size =6;
    	int[] randomNumbers = generate4Digit(size);

    	System.out.println("Generated 4-digit random numbers: " + Arrays.toString(randomNumbers));

    	double[] statistics = AverageMinMax(randomNumbers);

    	System.out.println("Average: " + statistics[0]);
    	System.out.println("Minimum value: " + statistics[1]);
    	System.out.println("Maximum value: " + statistics[2]);
    }
 }
