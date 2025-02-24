import java.lang.reflect.Field;
import java.util.Map;

public class JsonGenerator {

    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            sb.append("\"").append(fields[i].getName()).append("\":");
            Object value = fields[i].get(obj);
            if (value instanceof String) {
                sb.append("\"").append(value).append("\"");
            } else {
                sb.append(value);
            }
            if (i < fields.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Alice", 30);
        String json = toJson(person);
        System.out.println(json);
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
