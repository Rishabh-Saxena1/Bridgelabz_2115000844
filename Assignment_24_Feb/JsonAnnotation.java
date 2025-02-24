import java.lang.annotation.*;
 import java.lang.reflect.*;
 import java.util.*;

 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.FIELD)
 @interface JsonField {
    String name();
 }
 class UserClass {
    @JsonField(name = "user_name")
    private String username;
    @JsonField(name = "user_age")
    private int age;
    public UserClass(String username, int age) {
  	  this.username = username;
    	this.age = age;
    }

    // Method to convert object to JSON string
    public String toJson() throws Exception {
    	StringBuilder json = new StringBuilder("{");
    	Field[] fields = this.getClass().getDeclaredFields();
    	List<String> jsonFields = new ArrayList<>();

    	for (Field field : fields) {
        	if (field.isAnnotationPresent(JsonField.class)) {
            	field.setAccessible(true);
            	JsonField annotation = field.getAnnotation(JsonField.class);
            	String key = annotation.name();
            	String value = field.get(this).toString();
            	jsonFields.add("\"" + key + "\": \"" + value + "\"");
        	}
    	}

    	json.append(String.join(", ", jsonFields)).append("}");
    	return json.toString();
    }
 }
 public class JsonAnnotation{
    public static void main(String[] args) throws Exception {
    	UserClass user = new UserClass("Rashi", 20);
    	System.out.println(user.toJson());
    }
 }
