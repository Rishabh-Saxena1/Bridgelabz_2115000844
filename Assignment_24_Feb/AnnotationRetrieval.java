import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationRetrieval {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Author {
        String name();
    }

    @Author(name = "John Doe")
    static class MyClass {
        // Class content
    }

    public static void main(String[] args) {
        Class<?> myClass = MyClass.class;
        if (myClass.isAnnotationPresent(Author.class)) {
            Author authorAnnotation = myClass.getAnnotation(Author.class);
            String authorName = authorAnnotation.name();
            System.out.println("Author: " + authorName);
        } else {
            System.out.println("Author annotation not found.");
        }
    }
}
