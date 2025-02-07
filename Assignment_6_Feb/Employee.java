class Employee{
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary){
        this.name= name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails(){
        System.out.println("Name of the employee is: " + name + " ,ID of the employee is: " + id + " and Salary of the employee is :" + salary);
    }
}
class Manager extends Employee{
    int teamSize;
    public Manager(String name, int id, double salary, int teamSize){
        super(name,id,salary);
        this.teamSize = teamSize;
    }
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Team size: " + teamSize);
    }
}
class Developer extends Employee{
    String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage){
        super(name,id,salary);
        this.programmingLanguage = programmingLanguage;
    }
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee{
    public Intern(String name, int id, double salary){
        super(name,id,salary);
    }
    public void displayDetails(){
        super.displayDetails();
    }
}
public class EmployeeManagement{
    public static void main(String[] args) {
        Employee manager = new Manager("Ashish",158,20000,4);
        Employee developer = new Developer("Riya", 1215, 500000, "Java");
        Employee intern = new Intern ("Parth", 556 , 10000);

        System.out.println("\nDetails of Manager: ");
        manager.displayDetails();
        System.out.println("\nDetails of Developer: ");
        developer.displayDetails();
        System.out.println("\nDetails of Intern: ");
        intern.displayDetails();
    }
}
