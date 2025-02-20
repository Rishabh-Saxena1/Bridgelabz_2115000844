import java.util.*;
class Employee {
    String id;
    String name;
    String department;

    public Employee(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

public class GroupObjects {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("E001", "Pinky", "HR"),
            new Employee("E002", "Tinky", "IT"),
            new Employee("E003", "Minky", "IT"),
            new Employee("E004", "Sinky", "Finance"),
            new Employee("E005", "Qinky", "HR")
        );
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        grouped.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}
