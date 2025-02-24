import java.lang.annotation.*;
 import java.lang.reflect.*;
 import java.util.*;
 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 @interface CacheResult {}

 class ExpensiveOperations {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
    	if (cache.containsKey(number)) {
        	System.out.println("Returning cached result for: " + number);
        	return cache.get(number);
    	}

    	System.out.println("Computing square for: " + number);
    	int result = number * number;
    	cache.put(number, result);
    	return result;
    }
 }
 public class CachingSystem{
    public static void main(String[] args) throws Exception {
    	ExpensiveOperations operations = new ExpensiveOperations();
    	System.out.println("Result: " + operations.computeSquare(5));
    	System.out.println("Result: " + operations.computeSquare(5)); // Cached result
    	System.out.println("Result: " + operations.computeSquare(7));
    	System.out.println("Result: " + operations.computeSquare(7)); // Cached result
    }
 }

