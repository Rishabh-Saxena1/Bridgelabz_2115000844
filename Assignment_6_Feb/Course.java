class Course{
    String courseName;
    int duration;
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayInfo(){
        System.out.println("Course Name: " + courseName + " and the duration of the course is: " + duration);
    }
}
class OnlineCourse extends Course{
    String platform;
    boolean isRecorded;
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Platform for the course is: " + platform + " and the course is " + (isRecorded ? "recorded" : "not recorded"));
    }
}
class PaidOnlineCourse extends OnlineCourse{
    int fee;
    double discount;
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, int fee, double discount){
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount =discount;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Fee for the course is: " + fee + " and you will get the discount of " + discount);
    }
}
public class EducationalCourse {
    public static void main(String[] args) {
        Course cou = new Course("Java Fundamentals", 20);
        System.out.println("Basic details about the course");
        cou.displayInfo();

        OnlineCourse OC = new OnlineCourse("Gate wallah", 100, "Physics Wallah", true);
        System.out.println("Online Course details");
        OC.displayInfo();

        PaidOnlineCourse POC = new PaidOnlineCourse("JEE Full Preparation", 365, "Offline coaching", false, 58000, 10);
        System.out.println("Paid Online Course details");
        POC.displayInfo();
    }
}
