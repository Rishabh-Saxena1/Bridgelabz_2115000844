import java.lang.reflect.Field;

public class PrivateFieldAccess {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> personClass = person.getClass();
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.setInt(person, 30);
        int retrievedAge = ageField.getInt(person);
        System.out.println("Modified Age: " + retrievedAge);
    }

    static class Person {
        private int age;
    }
}
