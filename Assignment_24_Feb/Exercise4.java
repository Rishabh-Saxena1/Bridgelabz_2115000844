import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Exercise4 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface TaskInfo {
        String priority();
        String assignedTo();
    }

    static class TaskManager {
        @TaskInfo(priority = "High", assignedTo = "John")
        public void performTask() {
            System.out.println("Performing task");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TaskManager taskManager = new TaskManager();
        Method method = TaskManager.class.getMethod("performTask");
        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}
