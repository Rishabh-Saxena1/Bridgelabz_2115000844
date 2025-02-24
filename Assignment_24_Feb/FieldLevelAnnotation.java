import java.lang.annotation.*;
 import java.lang.reflect.*;

 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.FIELD)
 @interface MaxLength {
    int value();
 }
 class User {
    @MaxLength(10)
    private String username;

    public User(String username) throws Exception {
    	validate(username);
    	this.username = username;
    }

    private void validate(String username) throws Exception {
    	for (Field field : this.getClass().getDeclaredFields()) {
        	if (field.isAnnotationPresent(MaxLength.class)) {
            	MaxLength annotation = field.getAnnotation(MaxLength.class);
                if (username.length() > annotation.value()) {
                	throw new IllegalArgumentException("Username exceeds length of " + annotation.value() + " characters");
            	}
        	}
    	}
    }
    public String getUsername() {
    	return username;
    }
 }
 public class FieldLevelAnnotation{
    public static void main(String[] args) {
    	try {
        	User user1 = new User("ShortName");
        	System.out.println("User 1: " + user1.getUsername());

        	User user2 = new User("ThisNameIsTooLong"); // Should throw an exception
        	System.out.println("User 2: " + user2.getUsername());
    	} catch (Exception e) {
        	System.out.println("Error: " + e.getMessage());
    	}
    }
 }
