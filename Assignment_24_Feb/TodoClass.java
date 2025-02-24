import java.lang.annotation.*;
 import java.lang.reflect.*;

 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 @interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
 }
 class Task{
    @Todo(task = "Implement login functionality", assignedTo = "Rashi", priority = "HIGH")
    public void loginFeature() {
    	System.out.println("features");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Shantanu")
    public void optimizeDatabase() {
    	System.out.println("optimization");
    }
 }
 public class TodoClass{
    public static void main(String[] args) throws Exception {
        Task taskManager = new Task();
    	Method[] methods = taskManager.getClass().getMethods();

    	// Retrieving and printing all pending tasks
    	for (Method method : methods) {
        	if (method.isAnnotationPresent(Todo.class)) {
            	Todo annotation = method.getAnnotation(Todo.class);
            	System.out.println("Task: " + annotation.task());
            	System.out.println("Assigned To: " + annotation.assignedTo());
            	System.out.println("Priority: " + annotation.priority());
        	}
    	}
    	taskManager.loginFeature();
    	taskManager.optimizeDatabase();
    }
 }
