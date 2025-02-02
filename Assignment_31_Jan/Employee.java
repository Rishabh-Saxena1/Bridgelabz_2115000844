import java.util.*;
class Employee {
   public int employeeID;
   protected String department;
   private double salary;

   public Employee(int employeeID, String department, double salary) {
       this.employeeID = employeeID;
       this.department = department;
       this.salary = salary;
   }

   public void setSalary(double salary) {
       if (salary > 0) {
           this.salary = salary;
       }
   }

   public double getSalary() {
       return salary;
   }
}

class Manager extends Employee {
   public Manager(int employeeID, String department, double salary) {
       super(employeeID, department, salary);
   }

   public void showDetails() {
       System.out.println("Employee ID: " + employeeID);
       System.out.println("Department: " + department);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter Employee ID: ");
       int employeeID = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter Department: ");
       String department = sc.nextLine();
       System.out.print("Enter Initial Salary: ");
       double salary = sc.nextDouble();
       Manager manager = new Manager(employeeID, department, salary);
       manager.showDetails();
       System.out.println("Salary: " + manager.getSalary());

       System.out.print("Enter new salary: ");
       double newSalary = sc.nextDouble();
       manager.setSalary(newSalary);
       System.out.println("Updated Salary: " + manager.getSalary());
   }
}
