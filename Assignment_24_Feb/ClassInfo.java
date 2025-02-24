import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fully qualified class name: ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            Class<?> cls = Class.forName(className);
            displayClassInfo(cls);
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + className);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void displayClassInfo(Class<?> cls) {
        System.out.println("Class: " + cls.getName());
        System.out.println("----------------------------------------");

        // Constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + Modifier.toString(constructor.getModifiers()) + " " + cls.getSimpleName() + "(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }

        // Methods
        System.out.println("\nMethods:");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if(!method.getName().startsWith("<")) { //avoid compiler generated methods.
                System.out.print("  " + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getSimpleName());
                    if (i < parameterTypes.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
        }

        // Fields
        System.out.println("\nFields:");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("  " + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
        }
    }
}
