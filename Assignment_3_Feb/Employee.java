import java.util.*;
class Employee {
   static String companyName = "iEngineer";
   static int totalEmployees = 0;
   final int employeeId;
   String name;
   String designation;
   Employee(String name, int employeeId, String designation) {
       this.name = name;
       this.employeeId = employeeId;
       this.designation = designation;
       totalEmployees++;
   }
   static void displayTotalEmployees() {
       System.out.println("Total no of Employees: " + totalEmployees);
   }
   void showDetails() {
           System.out.println("Name: " + name);
           System.out.println("ID: " + employeeId);
           System.out.println("Designation: " + designation);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter employee name: ");
       String name = sc.nextLine();
       System.out.print("Enter employee ID: ");
       int employeeId = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter designation: ");
       String designation = sc.nextLine();
       Employee emp = new Employee(name, employeeId, designation);
       if(emp instanceof Employee){
            Employee.displayTotalEmployees();
            emp.showDetails();
       }
       else{
        System.out.println("Not instance");
    }
   }
}
