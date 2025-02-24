import java.lang.reflect.Field;

public class StaticFieldAccess {

    static class Configuration {
        private static String API_KEY = "initial_key";
    }

    public static void main(String[] args) throws Exception {
        Class<?> configClass = Configuration.class;
        Field apiKeyField = configClass.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        apiKeyField.set(null, "modified_key");
        String modifiedApiKey = (String) apiKeyField.get(null);
        System.out.println("Modified API Key: " + modifiedApiKey);
    }
}
