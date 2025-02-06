import java.util.ArrayList;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayEmployee() {
        System.out.println("   Employee: " + name);
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void displayDepartment() {
        System.out.println(" Department: " + name);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (deptName.equals(deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found!");
    }

    public void displayCompany() {
        System.out.println("\nCompany: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void closeCompany() {
        departments.clear();
        System.out.println("\nCompany " + name + " has been closed. All departments and employees are removed.");
    }
}

public class Q3_Company {
    public static void main(String[] args) {
        Company company = new Company("Tech Innovators");

        company.addDepartment("Engineering");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("Engineering", "Kanishk");
        company.addEmployeeToDepartment("Engineering", "Aryan");
        company.addEmployeeToDepartment("HR", "Riya");

        company.displayCompany();

        company.closeCompany();
    }
}
