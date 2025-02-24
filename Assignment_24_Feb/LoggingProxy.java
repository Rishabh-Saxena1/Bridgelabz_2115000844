import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy {

    interface Greeting {
        String sayHello(String name);
    }

    static class GreetingImpl implements Greeting {
        @Override
        public String sayHello(String name) {
            return "Hello, " + name + "!";
        }
    }

    static class LoggingHandler implements InvocationHandler {
        private final Object target;

        public LoggingHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Calling method: " + method.getName());
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(greeting)
        );
        String result = proxyGreeting.sayHello("World");
        System.out.println("Result: " + result);
    }
}
