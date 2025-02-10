import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class RideHailingApplication implements GPS {
    private String currentLocation;

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    public double calculateFareForVehicle(Vehicle vehicle, double distance) {
        return vehicle.calculateFare(distance);
    }
}

public class Q08_RideHailingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vehicles to add: ");
        int numVehicles = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < numVehicles; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1));

            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();

            System.out.print("Enter Driver Name: ");
            String driverName = scanner.nextLine();

            System.out.print("Enter Rate per Kilometer: ");
            double ratePerKm = scanner.nextDouble();
            scanner.nextLine();  

            System.out.print("Enter Vehicle Type (Car/Bike/Auto): ");
            String vehicleType = scanner.nextLine();

            if (vehicleType.equalsIgnoreCase("Car")) {
                vehicles.add(new Car(vehicleId, driverName, ratePerKm));
            } else if (vehicleType.equalsIgnoreCase("Bike")) {
                vehicles.add(new Bike(vehicleId, driverName, ratePerKm));
            } else if (vehicleType.equalsIgnoreCase("Auto")) {
                vehicles.add(new Auto(vehicleId, driverName, ratePerKm));
            } else {
                System.out.println("Invalid vehicle type. Skipping this entry.");
            }
        }

        RideHailingApplication app = new RideHailingApplication();

        System.out.print("\nEnter your current location: ");
        String location = scanner.nextLine();
        app.updateLocation(location);

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.print("Enter distance for fare calculation: ");
            double distance = scanner.nextDouble();
            System.out.println("Fare: " + app.calculateFareForVehicle(vehicle, distance));
            System.out.println();
        }

        scanner.close();
    }
}
