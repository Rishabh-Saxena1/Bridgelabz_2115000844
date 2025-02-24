import java.lang.annotation.*;
 import java.lang.reflect.*;
 // Defining custom annotation
 @Retention(RetentionPolicy.RUNTIME)
 @Target(ElementType.METHOD)
 @interface RoleAllowed {
    String value();
 }

 class Users{
    private String role;
    public Users(String role) {
    	this.role = role;
    }

    public String getRole() {
    	return role;
    }
 }
 class AdminOperations {
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
    	System.out.println("Admin task");
    }
 }
 public class ClassLevelAnnotation{
    public static void main(String[] args) throws Exception {
    	Users user = new Users("USER"); // Change role to "ADMIN" to allow access
    	AdminOperations adminOps = new AdminOperations();

    	Method method = adminOps.getClass().getMethod("performAdminTask");

    	if (method.isAnnotationPresent(RoleAllowed.class)) {
  	      RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
        	if (user.getRole().equals(roleAllowed.value())) {
                method.invoke(adminOps);
        	} else {
            	System.out.println("Access Denied!");
      	  }
    	}
    }
 }
