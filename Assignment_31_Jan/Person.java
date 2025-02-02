import java.util.Scanner;
class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(Person otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }
    public void showDetails() {
        System.out.println("Person's name is : " + name + "and age is: " + age);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        Person P1 = new Person(name, age);
        Person P2 = new Person(P1);
        System.out.println(" Original Person:");
        P1.showDetails();
        System.out.println(" Other Person:");
        P2.showDetails();
    }
}
