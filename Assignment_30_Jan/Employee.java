public class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", 101, 50000);
        Employee emp2 = new Employee("Alice Smith", 102, 60000);

        System.out.println("=== Employee 1 ===");
        emp1.displayDetails();

        System.out.println("\n=== Employee 2 ===");
        emp2.displayDetails();
    }
}
