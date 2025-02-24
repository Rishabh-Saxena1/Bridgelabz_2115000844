import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class ImportantMethodAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ImportantMethod {
        String level() default "HIGH";
    }

    static class MyClass {
        @ImportantMethod
        public void importantTask1() {
            System.out.println("Important task 1");
        }

        @ImportantMethod(level = "MEDIUM")
        public void importantTask2() {
            System.out.println("Important task 2");
        }

        public void regularTask() {
            System.out.println("Regular task");
        }
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class<?> clazz = myClass.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}
