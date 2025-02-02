  import java.util.*;
class OnlineCourse {
   String courseName;
   int duration;
   double fee;
   private static String instituteName = "Default Institute";

   public OnlineCourse(String courseName, int duration, double fee) {
       this.courseName = courseName;
       this.duration = duration;
       this.fee = fee;
   }

   public void showDetails() {
       System.out.println("Course Name: " + courseName);
       System.out.println("Duration: " + duration + " months");
       System.out.println("Fee: " + fee);
       System.out.println("Institute Name: " + instituteName);
   }

   public static void update   (String newName) {
       instituteName = newName;
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter institute name: ");
       String newInstituteName = sc.nextLine();
       OnlineCourse.update(newInstituteName);

       System.out.print("Enter number of courses: ");
       int numCourses = sc.nextInt();
       sc.nextLine();

       OnlineCourse[] courses = new OnlineCourse[numCourses];

       for (int i = 0; i < numCourses; i++) {
           System.out.print("Enter course name: ");
           String name = sc.nextLine();
           System.out.print("Enter duration: ");
           int duration = sc.nextInt();
           System.out.print("Enter fee: ");
           double fee = sc.nextDouble();
           sc.nextLine();
           courses[i] = new OnlineCourse(name, duration, fee);
       }

       System.out.println(" Course Details:");
       for (OnlineCourse course : courses) {
           course.showDetails();
           System.out.println();
       }
   }
}
