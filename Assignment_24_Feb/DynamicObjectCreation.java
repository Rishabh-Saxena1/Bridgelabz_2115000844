import java.lang.reflect.Constructor;

public class DynamicObjectCreation {

    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");
        Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);
        Object student = constructor.newInstance("Alice", 20);
        System.out.println(student);
    }

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + '}';
        }
    }
}
