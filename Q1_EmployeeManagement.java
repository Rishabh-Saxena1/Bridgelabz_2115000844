import java.util.*;

interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public abstract double calculateSalary();

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    @Override
    public void displayDetails() {
        System.out.println(" Full-Time Employee Details ");
        super.displayDetails();
        System.out.println(getDepartmentDetails());
        System.out.println();
    }
}

class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Part-Time Employee Details ");
        super.displayDetails();
        System.out.println(getDepartmentDetails());
        System.out.println();
       
    }
}

public class Q1_EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee full = new FullTimeEmployee(1, "Ritik", 10000, 5000);
        full.assignDepartment("Developer");
        employees.add(full);

        PartTimeEmployee part = new PartTimeEmployee(2, "Ayush", 8000, 5, 1000);
        part.assignDepartment("Quality Analyst");
        employees.add(part);

        for (Employee em : employees) {
            em.displayDetails();
        }
    }
}
