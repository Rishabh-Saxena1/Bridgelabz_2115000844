class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void displayRole(){
        System.out.println("Name of the person is: " + name + ", and Age: " + age);
    }
}
class Teacher extends Person{
    String subject;
    public Teacher(String name, int age, String subject){
        super(name, age);
        this.subject = subject;
    }
    public void displayRole(){
        super.displayRole();
        System.out.println("Role: Teacher");
        System.out.println("This teacher teaches " + subject);
    }
}
class Student extends Person{
    String grade;
    public Student(String name, int age, String grade){
        super(name, age);
        this.grade = grade;
    }
    public void displayRole(){
        super.displayRole();
        System.out.println("Role: Student");
        System.out.println("Student get " + grade);
    }
}
class Staff extends Person{
    String role;
    public Staff(String name, int age, String role){
        super(name, age);
        this.role = role;
    }
    public void displayRole(){
        super.displayRole();
        System.out.println("Role: Staff");
        System.out.println("This staff do the role of " + role);
    }
}
public class SchoolSystem {
    public static void main(String[] args) {
        Person T = new Teacher("Anisha", 26, "Physics");
        T.displayRole();

        Person S = new Student("Priyanka", 16, "B+");
        S.displayRole();

        Person St = new Staff("Rajni", 42, "Sweeper");
        St.displayRole();
    }
}
