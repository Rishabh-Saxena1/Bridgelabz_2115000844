import java.lang.reflect.Method;

public class MethodTiming {

    public static void timeMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                method.setAccessible(true);
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                System.out.println(method.getName() + " executed in " + (endTime - startTime) + " nanoseconds");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyClass myObject = new MyClass();
        timeMethods(myObject);
    }

    static class MyClass {
        public void method1() {
            for (int i = 0; i < 1000; i++) {
                Math.sqrt(i);
            }
        }

        public void method2() {
            for (int i = 0; i < 500; i++) {
                Math.pow(2, i);
            }
        }

        private void privateMethod() {}

        public void methodWithParameter(int a) {}
    }
}
