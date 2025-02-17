import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);

    void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate;

    public Car(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + insuranceRate + "%";
    }
}

class Bike extends Vehicle implements Insurable {
    private double insuranceRate;

    public Bike(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + insuranceRate + "%";
    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceRate;

    public Truck(String vehicleNumber, double rentalRate, double insuranceRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insuranceRate = insuranceRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * insuranceRate / 100;
    }

    @Override
    public String getInsuranceDetails() {
        return "Insurance Rate: " + insuranceRate + "%";
    }
}

public class Q03_VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();

        System.out.print("Enter number of vehicles: ");
        int numberOfVehicles = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfVehicles; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1) + ":");
            System.out.print("Enter vehicle type (Car/Bike/Truck): ");
            String type = scanner.nextLine();

            System.out.print("Enter vehicle number: ");
            String vehicleNumber = scanner.nextLine();

            System.out.print("Enter rental rate: ");
            double rentalRate = scanner.nextDouble();

            System.out.print("Enter insurance rate (in %): ");
            double insuranceRate = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            if (type.equalsIgnoreCase("Car")) {
                vehicles.add(new Car(vehicleNumber, rentalRate, insuranceRate));
            } else if (type.equalsIgnoreCase("Bike")) {
                vehicles.add(new Bike(vehicleNumber, rentalRate, insuranceRate));
            } else if (type.equalsIgnoreCase("Truck")) {
                vehicles.add(new Truck(vehicleNumber, rentalRate, insuranceRate));
            } else {
                System.out.println("Invalid vehicle type. Skipping...");
            }
        }

        System.out.print("\nEnter number of days for rental: ");
        int days = scanner.nextInt();

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(days);
            System.out.println("Rental Cost for " + days + " days: " + rentalCost);

            if (vehicle instanceof Insurable) {
                double insuranceCost = ((Insurable) vehicle).calculateInsurance();
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: " + insuranceCost);
            }
            System.out.println(" ");
        }

        scanner.close();
    }
}
