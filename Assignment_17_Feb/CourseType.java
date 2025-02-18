import java.util.*;

abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    public String toString() {
        return getClass().getSimpleName() + " (Evaluation: " + evaluationMethod + ")";
    }
}

class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Written Exam");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignments & Projects");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research Papers & Thesis");
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    public String toString() {
        return courseName + department + " : " + courseType;
    }
}

class University {
    public static void displayCourses(List<? extends CourseType> courses) {
        System.out.println("Available Courses:");
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

public class MultiLevelUniversity {
    public static void main(String[] args) {
        ExamCourse examType = new ExamCourse();
        AssignmentCourse assignmentType = new AssignmentCourse();
        ResearchCourse researchType = new ResearchCourse();

        Course<ExamCourse> math = new Course<>("Biology", "Science", examType);
        Course<AssignmentCourse> softwareEng = new Course<>("Cryptography", "Computer Science", assignmentType);
        Course<ResearchCourse> aiResearch = new Course<>("AI Research", "Artificial Intelligence", researchType);

        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(math.getCourseType());
        allCourses.add(softwareEng.getCourseType());
        allCourses.add(aiResearch.getCourseType());

        University.displayCourses(allCourses);
    }
}
