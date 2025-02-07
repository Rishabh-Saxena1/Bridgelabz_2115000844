interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is cooking food.");
    }
}

class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving customers.");
    }
}
class RestaurantManagement{
    public static void main(String[] args) {
        Worker chef = new Chef("Rashi", 101);
        Worker waiter = new Waiter("Shantanu", 102);
        chef.performDuties();
        waiter.performDuties();
    }
}
