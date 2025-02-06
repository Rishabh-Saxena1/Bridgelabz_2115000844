import java.util.ArrayList;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayFaculty() {
        System.out.println("  Faculty: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayDepartment() {
        System.out.println(" Department: " + name);
        for (Faculty faculty : facultyMembers) {
            faculty.displayFaculty();
        }
    }
}

class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyMembers;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found!");
    }

    public void displayUniversity() {
        System.out.println("\nUniversity: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
        System.out.println("\nIndependent Faculty Members:");
        for (Faculty faculty : facultyMembers) {
            faculty.displayFaculty();
        }
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("\nUniversity " + name + " has been closed. All departments have been removed.");
    }
}

public class Q5_University {
    public static void main(String[] args) {
        University university = new University("Global Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty faculty1 = new Faculty("Dr. Kanishk");
        Faculty faculty2 = new Faculty("Prof. Aryan");
        Faculty faculty3 = new Faculty("Dr. Riya");

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);

        university.assignFacultyToDepartment("Computer Science", faculty1);
        university.assignFacultyToDepartment("Mechanical Engineering", faculty2);

        university.displayUniversity();

        university.closeUniversity();
    }
}
