class Vehicle{
    int maxSpeed;
    String fuelType;
    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo(){
        System.out.println("Max Speed of vehicle is: " + maxSpeed + " and fueltype of vehicle is: " + fuelType);
    }
}
class Car extends Vehicle{
    int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    public void displayInfo(){
        System.out.println("Details of Car");
        super.displayInfo();
    }
}
class Truck extends Vehicle{
    int loadCapacity;
    public Truck(int maxSpeed, String fuelType, int loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    public void displayInfo(){
        System.out.println("Details of Truck");
        super.displayInfo();
    }
}
class Motorcycle extends Vehicle{
    String model;
    public Motorcycle(int maxSpeed, String fuelType, String model){
        super(maxSpeed, fuelType);
        this.model = model;
    }
    public void displayInfo(){
        System.out.println("Details of Motorcycle");
        super.displayInfo();
    }
}
public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] veh = new Vehicle[3];
        veh[0] = new Car(120, "Petrol", 7);
        veh[1] = new Truck(80, "Diesel", 100);
        veh[2] = new Motorcycle(120,"Petrol","Honda");

        for (Vehicle ve : veh){
            ve.displayInfo();
        }
    }
}
