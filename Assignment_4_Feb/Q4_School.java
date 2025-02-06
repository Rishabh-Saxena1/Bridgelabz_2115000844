import java.util.ArrayList;

class Course {
    private String name;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + name + " - Enrolled Students:");
        for (Student student : students) {
            System.out.println("  " + student.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayEnrolledCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("  " + course.getName());
        }
    }

    public String getName() {
        return name;
    }
}

class School {
    private String name;
    private ArrayList<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name + " - Students List:");
        for (Student student : students) {
            System.out.println("  " + student.getName());
        }
    }
}

public class Q4_School {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student student1 = new Student("Kanishk");
        Student student2 = new Student("Aryan");

        school.addStudent(student1);
        school.addStudent(student2);

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);

        school.displayStudents();

        student1.displayEnrolledCourses();
        student2.displayEnrolledCourses();

        course1.displayEnrolledStudents();
        course2.displayEnrolledStudents();
    }
}
