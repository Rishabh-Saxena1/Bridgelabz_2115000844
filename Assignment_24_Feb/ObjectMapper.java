import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            } catch (NoSuchFieldException e) {
            }
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = Map.of("name", "Alice", "age", 30);
        Person person = ObjectMapper.toObject(Person.class, map);
        System.out.println(person.name);
        System.out.println(person.age);
    }

    static class Person {
        String name;
        int age;
    }
}
