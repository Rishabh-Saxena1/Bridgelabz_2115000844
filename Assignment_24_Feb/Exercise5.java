import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Exercise5 {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Repeatable(BugReports.class)
    public @interface BugReport {
        String description();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface BugReports {
        BugReport[] value();
    }

    static class BugTracker {
        @BugReport(description = "Null pointer exception")
        @BugReport(description = "Incorrect calculation")
        public void process() {
            System.out.println("Processing...");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        BugTracker bugTracker = new BugTracker();
        Method method = BugTracker.class.getMethod("process");
        if (method.isAnnotationPresent(BugReports.class)) {
            BugReport[] bugReports = method.getAnnotation(BugReports.class).value();
            for (BugReport bugReport : bugReports) {
                System.out.println("Bug Report: " + bugReport.description());
            }
        }
    }
}
