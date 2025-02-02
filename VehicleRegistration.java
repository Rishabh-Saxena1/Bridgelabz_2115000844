import java.util.*;
class VehicleRegistration {
   String ownerName;
   String vehicleType;
   private static double registrationFee = 500.0;
   public VehicleRegistration(String ownerName, String vehicleType) {
       this.ownerName = ownerName;
       this.vehicleType = vehicleType;
   }
   public void showDetails() {
       System.out.println("Owner Name: " + ownerName);
       System.out.println("Vehicle Type: " + vehicleType);
       System.out.println("Registration Fee: " + registrationFee);
   }
   public static void updateFee(double newFee) {
       registrationFee = newFee;
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter new registration fee: ");
       double newFee = sc.nextDouble();
       sc.nextLine();
       VehicleRegistration.updateFee(newFee);

       System.out.print("Enter number of vehicles: ");
       int numVehicles = sc.nextInt();
       sc.nextLine();
       VehicleRegistration[] vehicles = new VehicleRegistration[numVehicles];

       for (int i = 0; i < numVehicles; i++) {
           System.out.print("Enter owner name: ");
           String ownerName = sc.nextLine();
           System.out.print("Enter vehicle type: ");
           String vehicleType = sc.nextLine();
           vehicles[i] = new VehicleRegistration(ownerName, vehicleType);
       }

       System.out.println("\nVehicle Details:");
       for (VehicleRegistration vehicle : vehicles) {
           vehicle.showDetails();
           System.out.println();
       }
   }
}
