import java.lang.annotation.*;
 import java.lang.reflect.*;

 // Defining custom annotation
 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 @interface LogExecutionTime {}
 class Execution{
    @LogExecutionTime
    public void heavyTask() {
    	try {
        	Thread.sleep(500);
    	} catch (InterruptedException e) {
        	e.printStackTrace();
    	}
    	System.out.println("Heavy task completed");
    }

    @LogExecutionTime
    public void lightTask() {
    	try {
        	Thread.sleep(100); // Simulating a lighter task
    	} catch (InterruptedException e) {
        	e.printStackTrace();
    	}
    	System.out.println("Light task completed");
    }
 }
 public class ExecutionTimeClass{
    public static void main(String[] args) throws Exception {
    	Execution execute = new Execution();
    	Method[] methods = execute.getClass().getMethods();
    	for (Method method : methods) {
        	if (method.isAnnotationPresent(LogExecutionTime.class)) {
    	        long startTime = System.nanoTime();
            	method.invoke(execute);
            	long endTime = System.nanoTime();
            	System.out.println("Execution time of " + method.getName() + ": " + (endTime - startTime) / 1000000 + " ms");
        	}
    	}
    }
 }
