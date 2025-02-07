class Animal{
    String name;
    int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void makeSound(){
        System.out.println("The animal makes a sound");
    }
    public void showInfo(){
        System.out.println("Name of the animal is: " + name + " and age is :" + age);
    }
}
    class Dog extends Animal{
        public Dog(String name, int age){
            super(name, age);
        }
        public void makeSound(){
            System.out.println("The dog barks");
        }
    }
    class Cat extends Animal{
        public Cat(String name, int age){
            super(name, age);
        }
        public void makeSound(){
            System.out.println("The cat meow");
        }
}
    class Bird extends Animal{
        public Bird (String name, int age){
            super(name, age);
        }
        public void makeSound(){
            System.out.println("The bird chirps");
        }
    }
public class AnimalHierarchy{
    public static void main(String[] args) {
        Animal dog = new Dog("Tommy", 3);
        Animal cat = new Cat("Quicky", 3);
        Animal bird = new Bird("Mithu", 3);

        dog.showInfo();
        dog.makeSound();

        cat.showInfo();
        cat.makeSound();

        bird.showInfo();
        bird.makeSound();
    }
}
