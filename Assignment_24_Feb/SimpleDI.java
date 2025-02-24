import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDI {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Inject {}

    static class DIContainer {
        private final Map<Class<?>, Object> instances = new HashMap<>();

        public <T> void register(Class<T> clazz, T instance) {
            instances.put(clazz, instance);
        }

        public <T> T resolve(Class<T> clazz) throws Exception {
            if (instances.containsKey(clazz)) {
                return clazz.cast(instances.get(clazz));
            }

            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length != 1) {
                throw new IllegalArgumentException("Class must have exactly one constructor.");
            }

            Constructor<?> constructor = constructors[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Object[] parameters = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                parameters[i] = resolve(parameterTypes[i]);
            }

            T instance = clazz.cast(constructor.newInstance(parameters));
            instances.put(clazz, instance);
            injectFields(instance);
            return instance;
        }

        private <T> void injectFields(T instance) throws Exception {
            Class<?> clazz = instance.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    field.set(instance, resolve(field.getType()));
                }
            }
        }
    }

    static class DependencyA {
        public String messageA() {
            return "Message A";
        }
    }

    static class DependencyB {
        public String messageB() {
            return "Message B";
        }
    }

    static class Client {
        @Inject
        DependencyA dependencyA;

        @Inject
        DependencyB dependencyB;

        public void printMessages() {
            System.out.println(dependencyA.messageA());
            System.out.println(dependencyB.messageB());
        }
    }

    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        Client client = container.resolve(Client.class);
        client.printMessages();
    }
}
